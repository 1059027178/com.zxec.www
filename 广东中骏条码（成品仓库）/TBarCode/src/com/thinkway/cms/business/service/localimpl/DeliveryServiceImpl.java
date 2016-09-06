package com.thinkway.cms.business.service.localimpl;


import com.thinkway.cms.business.domains.Delivery;
import com.thinkway.cms.business.domains.User;
import com.thinkway.cms.business.domains.UserLog;
import com.thinkway.cms.business.query.BaseQuery;
import com.thinkway.cms.business.query.UserQuery;
import com.thinkway.cms.business.service.iface.DeliveryService;
import com.thinkway.cms.business.service.iface.UserService;
import com.thinkway.cms.persistence.TxManager;
import com.thinkway.cms.persistence.iface.DeliveryLogDao;
import com.thinkway.cms.persistence.iface.SequenceDao;
import com.thinkway.cms.persistence.iface.UserDao;
import com.thinkway.cms.persistence.iface.UserLogDao;
import com.thinkway.cms.persistence.sqlmapdao.DeliveryLogSqlMapDao;
import com.thinkway.cms.persistence.sqlmapdao.SequenceSqlMapDao;
import com.thinkway.cms.persistence.sqlmapdao.SqlMapDao;
import com.thinkway.cms.persistence.sqlmapdao.UserLogSqlMapDao;
import com.thinkway.cms.persistence.sqlmapdao.UserSqlMapDao;
import com.thinkway.cms.business.domains.DeliveryLog;

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
public class DeliveryServiceImpl implements DeliveryService {
	
	   TxManager txManager = null;
	    SequenceDao sequenceDao = null;
	    DeliveryLogDao DeliveryLogDao = null;
	    public DeliveryServiceImpl() {
	        txManager = SqlMapDao.getTxManager();
	        sequenceDao = new SequenceSqlMapDao();
	        DeliveryLogDao = new DeliveryLogSqlMapDao();
	    }
	    
	//创建交货单拣配
	public String createDelivery(Delivery  Delivery){
		return "";
	}	
	//读取交货单拣配
	public String readDelivery(Delivery  Delivery){
		return "";
	}
	
	//创建一条新的拣货的操作日志
	 public DeliveryLog createNewDeliveryLog(DeliveryLog DeliveryLog){
		 DeliveryLog retVal = null;	    	
	        try {
	            txManager.startTx();
	            DeliveryLogDao.createDeliveryLog(DeliveryLog);	            
	            txManager.commitTx();
	            retVal = DeliveryLog;	                        
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
	 public List getAllDeliveryLogByKw(BaseQuery queryObj){
		 List retVal = null;

			try {
				txManager.startTx();

				Map<String, Object> queryMap = BeanUtils.describe(queryObj);
				retVal = DeliveryLogDao.getAllDeliveryLogByKw(queryMap);
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
			DeliveryLog deliveryLog = new DeliveryLog();
		  	deliveryLog.setDataObj(dataObj);
		  	deliveryLog.setDataObjText(dataObjText);
		  	deliveryLog.setObjPrimaryKey(objPk);
		  	deliveryLog.setUserName(operator);
		  	deliveryLog.setOperationDate(df.format(new Timestamp(new Date().getTime())));
		  	deliveryLog.setOperationContent(opeartContent);
			this.createNewDeliveryLog(deliveryLog);			
	}
	
		
}
