package com.thinkway.cms.business.service.localimpl;


import com.thinkway.cms.business.domains.DelOrdPic;
import com.thinkway.cms.business.domains.User;
import com.thinkway.cms.business.domains.UserLog;
import com.thinkway.cms.business.query.BaseQuery;
import com.thinkway.cms.business.query.UserQuery;
import com.thinkway.cms.business.service.iface.DelOrdPicService;
import com.thinkway.cms.business.service.iface.UserService;
import com.thinkway.cms.persistence.TxManager;
import com.thinkway.cms.persistence.iface.DelOrdPicLogDao;
import com.thinkway.cms.persistence.iface.SequenceDao;
import com.thinkway.cms.persistence.iface.UserDao;
import com.thinkway.cms.persistence.iface.UserLogDao;
import com.thinkway.cms.persistence.sqlmapdao.DelOrdPicLogSqlMapDao;
import com.thinkway.cms.persistence.sqlmapdao.SequenceSqlMapDao;
import com.thinkway.cms.persistence.sqlmapdao.SqlMapDao;
import com.thinkway.cms.persistence.sqlmapdao.UserLogSqlMapDao;
import com.thinkway.cms.persistence.sqlmapdao.UserSqlMapDao;
import com.thinkway.cms.business.domains.DelOrdPicLog;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;


/**
 * 提供交货拣单管理
 * @author lijunying
 * @version 1.0
 */
@SuppressWarnings("unchecked")
public class DelOrdPicServiceImpl implements DelOrdPicService {
	
	   TxManager txManager = null;
	    SequenceDao sequenceDao = null;
	    DelOrdPicLogDao delordpicLogDao = null;
	    public DelOrdPicServiceImpl() {
	        txManager = SqlMapDao.getTxManager();
	        sequenceDao = new SequenceSqlMapDao();
	        delordpicLogDao = new DelOrdPicLogSqlMapDao();
	    }
	    
	//创建交货单拣配
	public String createDelOrdPic(DelOrdPic  DelOrdPic){
		return "";
	}	
	//读取交货单拣配
	public String readDelOrdPic(DelOrdPic  DelOrdPic){
		return "";
	}
	
	//创建一条新的拣货的操作日志
	 public DelOrdPicLog createNewDelOrdPicLog(DelOrdPicLog delordpicLog){
		 DelOrdPicLog retVal = null;	    	
	        try {
	            txManager.startTx();
	            delordpicLogDao.createDelOrdPicLog(delordpicLog);	            
	            txManager.commitTx();
	            retVal = delordpicLog;	                        
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }finally{
	            try{
	                txManager.endTx();
	            }catch(SQLException ex){
	                ex.printStackTrace();
	            }
	        }     
	        return retVal;
	 }
	//根据组合关键字对象获取用户日志列表	 
	 public List getAllDelOrdPicLogByKw(BaseQuery queryObj){
		 List retVal = null;

			try {
				txManager.startTx();

				Map<String, Object> queryMap = BeanUtils.describe(queryObj);
				retVal = delordpicLogDao.getAllDelOrdPicLogByKw(queryMap);
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

	//日志记录
	public void SystemLog(String dataObj,String dataObjText,String objPk,String operator,String opeartContent){
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式  	
			DelOrdPicLog delordpicLog = new DelOrdPicLog();
			delordpicLog.setDataObj(dataObj);
			delordpicLog.setDataObjText(dataObjText);
			delordpicLog.setObjPrimaryKey(objPk);
			delordpicLog.setUserName(operator);
			delordpicLog.setOperationDate(df.format(new Timestamp(new Date().getTime())));
			delordpicLog.setOperationContent(opeartContent);
			this.createNewDelOrdPicLog(delordpicLog);			
	}
	
		
}
