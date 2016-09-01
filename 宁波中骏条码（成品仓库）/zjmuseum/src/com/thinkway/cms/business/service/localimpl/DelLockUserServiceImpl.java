package com.thinkway.cms.business.service.localimpl;


import com.thinkway.cms.business.domains.DelLockUser;
import com.thinkway.cms.business.query.BaseQuery;
import com.thinkway.cms.business.service.iface.DelLockUserService;
import com.thinkway.cms.persistence.TxManager;
import com.thinkway.cms.persistence.iface.SequenceDao;
import com.thinkway.cms.persistence.iface.DelLockUserDao;
import com.thinkway.cms.persistence.sqlmapdao.SequenceSqlMapDao;
import com.thinkway.cms.persistence.sqlmapdao.SqlMapDao;
import com.thinkway.cms.persistence.sqlmapdao.DelLockUserSqlMapDao;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;



@SuppressWarnings("unchecked")
public class DelLockUserServiceImpl implements DelLockUserService {

    TxManager txManager = null;
    DelLockUserDao dellockuserDao = null;
    SequenceDao sequenceDao = null;
    public DelLockUserServiceImpl() {
        txManager = SqlMapDao.getTxManager();
        dellockuserDao = new DelLockUserSqlMapDao();
        sequenceDao = new SequenceSqlMapDao();
      }

    public DelLockUser createDelLockUser(DelLockUser dellockuser) {
    	//设置业务对象编号
    	DelLockUser retVal = null;		
		
        try {
        	 txManager.startTx();            
            dellockuserDao.createDelLockUser(dellockuser);          
            txManager.commitTx();
            retVal = dellockuser;
                        
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
    
    public DelLockUser getDelLockUser(String vbeln) {
    	
    	DelLockUser retVal = null;
    	
    	try {
            txManager.startTx();
            if(vbeln!=null||!vbeln.equals(""))
            	retVal = dellockuserDao.getDelLockUser(vbeln);

            txManager.commitTx();
            
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
    
   
   
	
	public boolean deleteDelLockUserByVbeln(String vbeln) {
		boolean retVal = false;

		try {
			txManager.startTx();
			dellockuserDao.deleteDelLockUserByVbeln(vbeln);
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

	public boolean deleteDelLockUserByUserid(String userid) {
		boolean retVal = false;

		try {
			txManager.startTx();
			dellockuserDao.deleteDelLockUserByUserid(userid);
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
	
}
