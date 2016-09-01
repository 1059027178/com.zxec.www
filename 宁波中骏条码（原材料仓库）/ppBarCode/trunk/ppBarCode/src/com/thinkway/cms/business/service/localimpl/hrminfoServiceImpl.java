package com.thinkway.cms.business.service.localimpl;

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

import com.thinkway.cms.business.domains.hrminfo;
import com.thinkway.cms.business.query.BaseQuery;
import com.thinkway.cms.business.service.iface.hrminfoService;
import com.thinkway.cms.persistence.TxManager;
import com.thinkway.cms.persistence.iface.hrminfoDao;
import com.thinkway.cms.persistence.iface.SequenceDao;
import com.thinkway.cms.persistence.sqlmapdao.hrminfoSqlMapDao;
import com.thinkway.cms.persistence.sqlmapdao.SequenceSqlMapDao;
import com.thinkway.cms.persistence.sqlmapdao.SqlMapDao;
import com.thinkway.cms.util.MD5Util;
import com.thinkway.cms.util.RandomId;

/**
 * 提供人员信息操作服务
 * @author welson
 * 
 */
@SuppressWarnings("unchecked")
public class hrminfoServiceImpl implements hrminfoService , Serializable{
	private static final long serialVersionUID = -9050495977797372653L; 
	TxManager txManager = null;
	hrminfoDao hrminfoDao = null; 		//hrminfo管理
	SequenceDao sequenceDao = null; // 序列号
    private String smsEnable = "0";
    
    public void setSmsEnable(String smsEnable) {
		this.smsEnable = smsEnable;
	}
    
	public hrminfoServiceImpl() {

		this.txManager = SqlMapDao.getTxManager();
		hrminfoDao = new hrminfoSqlMapDao();
		sequenceDao = new SequenceSqlMapDao();
	}

	
	/*****************************************************
	*  人员信息管理
	// *****************************************************/

	// 创建新的人员信息
	public hrminfo createhrminfo(hrminfo hrminfo) {
		hrminfo retVal = hrminfo;

		try {
			hrminfo.sethrminfoId(sequenceDao.getNextId("hrminfo"));
			txManager.startTx();
			hrminfoDao.createhrminfo(hrminfo);
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

	// 更新人员信息信息
	public boolean updatehrminfo(hrminfo hrminfo) {
		boolean retVal = false;

		try {
			txManager.startTx();
			hrminfoDao.updatehrminfo(hrminfo);		
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

	// 获取人员信息信息
	public hrminfo gethrminfoDetail(String hrminfoId) {
		hrminfo retVal = null;

		try {
			txManager.startTx();
			retVal = hrminfoDao.gethrminfoById(hrminfoId);
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
	//根据工号获取人员数
	public int gethrminfoCountsByObjno(String objno) {
		int retVal = 0;
		try {
			txManager.startTx();
			retVal = hrminfoDao.gethrminfoCountsByObjno(objno);
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

	// 删除人员信息
	public boolean deletehrminfoById(String id) {
		boolean retVal = false;

		try {
			txManager.startTx();
			hrminfoDao.deletehrminfoById(id);
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

	//获取所有人员信息列表
	public List getAllhrminfos(BaseQuery queryObj) {
		List retVal = null;
		try {
			txManager.startTx();
			Map<String, Object> queryMap = BeanUtils.describe(queryObj);
			retVal = hrminfoDao.getAllhrminfos(queryMap);
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
	
	public boolean deletehrminfoByIds(String[] ids) {
		boolean retVal = false;

		try {
			List<String> idsList = Arrays.asList(ids);
			txManager.startTx();
			hrminfoDao.deletehrminfoByIds(idsList);
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
	
	  
	
	//获取所有人员信息记录
	public int getAllhrminfosCount(BaseQuery queryObj) {
		int retVal = 0;
		try {
			txManager.startTx();
			Map<String, Object> queryMap = BeanUtils.describe(queryObj);
			retVal = hrminfoDao.getAllhrminfosCount(queryMap);
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
