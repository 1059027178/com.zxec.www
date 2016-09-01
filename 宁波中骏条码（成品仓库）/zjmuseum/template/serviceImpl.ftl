package com.quanhai.${project}.business.service.localimpl;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.quanhai.${project}.business.domains.${Name};
import com.quanhai.${project}.business.query.BaseQuery;
import com.quanhai.${project}.business.service.iface.${Name}Service;
import com.quanhai.${project}.persistence.TxManager;
import com.quanhai.${project}.persistence.iface.${Name}Dao;
import com.quanhai.${project}.persistence.iface.SequenceDao;
import com.quanhai.${project}.persistence.sqlmapdao.${Name}SqlMapDao;
import com.quanhai.${project}.persistence.sqlmapdao.SequenceSqlMapDao;
import com.quanhai.${project}.persistence.sqlmapdao.SqlMapDao;
import com.quanhai.${project}.util.MD5Util;
import com.quanhai.${project}.util.RandomId;

/**
 * 提供${NameDes}操作服务
 * @author welson
 * 
 */
@SuppressWarnings("unchecked")
public class ${Name}ServiceImpl implements ${Name}Service , Serializable{
	private static final long serialVersionUID = -9050495977797372653L; 
	TxManager txManager = null;
	${Name}Dao ${Lname}Dao = null; 		//${Lname}管理
	SequenceDao sequenceDao = null; // 序列号
    private String smsEnable = "0";
    
    public void setSmsEnable(String smsEnable) {
		this.smsEnable = smsEnable;
	}
    
	public ${Name}ServiceImpl() {

		this.txManager = SqlMapDao.getTxManager();
		${Lname}Dao = new ${Name}SqlMapDao();
		sequenceDao = new SequenceSqlMapDao();
	}

	
	/*****************************************************
	*  ${NameDes}管理
	// *****************************************************/

	// 创建新的${NameDes}
	public ${Name} create${Name}(${Name} ${Lname}) {
		${Name} retVal = ${Lname};

		try {
			${Lname}.set${Name}Id(sequenceDao.getNextId("${Lname}"));
			txManager.startTx();
			${Lname}Dao.create${Name}(${Lname});
			txManager.commitTx();
			return retVal;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				txManager.endTx();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 更新${NameDes}信息
	public boolean update${Name}(${Name} ${Lname}) {
		boolean retVal = false;

		try {
			txManager.startTx();
			${Lname}Dao.update${Name}(${Lname});		
			txManager.commitTx();
			retVal = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				txManager.endTx();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return retVal;
	}

	// 获取${NameDes}信息
	public ${Name} get${Name}Detail(String ${Lname}Id) {
		${Name} retVal = null;

		try {
			txManager.startTx();
			retVal = ${Lname}Dao.get${Name}ById(${Lname}Id);
			txManager.commitTx();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				txManager.endTx();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return retVal;
	}
	

	// 删除${NameDes}
	public boolean delete${Name}ById(String id) {
		boolean retVal = false;

		try {
			txManager.startTx();
			${Lname}Dao.delete${Name}ById(id);
			txManager.commitTx();
			retVal = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				txManager.endTx();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return retVal;
	}

	//获取所有${NameDes}列表
	public List getAll${Name}s(BaseQuery queryObj) {
		List retVal = null;
		try {
			txManager.startTx();
			Map<String, Object> queryMap = BeanUtils.describe(queryObj);
			retVal = ${Lname}Dao.getAll${Name}s(queryMap);
			txManager.commitTx();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				txManager.endTx();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return retVal;
	}
	
	public boolean delete${Name}ByIds(String[] ids) {
		boolean retVal = false;

		try {
			List<String> idsList = Arrays.asList(ids);
			txManager.startTx();
			${Lname}Dao.delete${Name}ByIds(idsList);
			txManager.commitTx();
			retVal = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				txManager.endTx();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return retVal;
	}
	
	  
	
	//获取所有${NameDes}记录
	public int getAll${Name}sCount(BaseQuery queryObj) {
		int retVal = 0;
		try {
			txManager.startTx();
			Map<String, Object> queryMap = BeanUtils.describe(queryObj);
			retVal = ${Lname}Dao.getAll${Name}sCount(queryMap);
			txManager.commitTx();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				txManager.endTx();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return retVal;
	}
		
	
	
	
}
