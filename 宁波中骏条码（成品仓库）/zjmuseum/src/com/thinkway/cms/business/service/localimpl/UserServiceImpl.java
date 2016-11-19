package com.thinkway.cms.business.service.localimpl;


import com.thinkway.cms.business.domains.User;
import com.thinkway.cms.business.query.BaseQuery;
import com.thinkway.cms.business.query.UserQuery;
import com.thinkway.cms.business.service.iface.UserService;
import com.thinkway.cms.persistence.TxManager;
import com.thinkway.cms.persistence.iface.SequenceDao;
import com.thinkway.cms.persistence.iface.UserDao;
import com.thinkway.cms.persistence.iface.UserLogDao;
import com.thinkway.cms.persistence.sqlmapdao.SequenceSqlMapDao;
import com.thinkway.cms.persistence.sqlmapdao.SqlMapDao;
import com.thinkway.cms.persistence.sqlmapdao.UserLogSqlMapDao;
import com.thinkway.cms.persistence.sqlmapdao.UserSqlMapDao;
import com.thinkway.cms.business.domains.UserLog;

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
 * 提供用户管理
 * @author welson
 * @version 1.0
 */
@SuppressWarnings("unchecked")
public class UserServiceImpl implements UserService {

    TxManager txManager = null;
    UserDao userDao = null;
    SequenceDao sequenceDao = null;
    UserLogDao userLogDao = null;
    public UserServiceImpl() {
        txManager = SqlMapDao.getTxManager();
        userDao = new UserSqlMapDao();
        sequenceDao = new SequenceSqlMapDao();
        userLogDao = new UserLogSqlMapDao();
    }

    public User createNewUser(User user) {
    	//设置业务对象编号
    	User retVal = null;		
		
        try {
        	user.setUserId(sequenceDao.getNextId("user"));
            txManager.startTx();            
            userDao.createUser(user);          
            txManager.commitTx();
            retVal = user;
                        
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
    
 public User regNewUser(User user) {
    	
    	User retVal = null;
    	
        try {
        	user.setUserId(sequenceDao.getNextId("user"));
            txManager.startTx();
            userDao.createUser(user);
            txManager.commitTx();
            retVal = user;
                        
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

    public boolean updateUser(User user) {
    	
    	boolean retVal = false;
    	
    	try {
            txManager.startTx();
            userDao.updateUser(user);
          txManager.commitTx();
            retVal = true;
            
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
    
    public User getUser(String id) {
    	
    	User retVal = null;
    	
    	try {
            txManager.startTx();
            if(id!=null||!id.equals(""))
            	retVal = userDao.getUserById(Integer.parseInt(id));

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
    
   
    

	public User findUserForLogin(User user) {
		User retVal = null;
		
		try{
			txManager.startTx();
			retVal = userDao.findUserForLogin(user);
			txManager.commitTx();
		}catch(SQLException ex){
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
     
	//删除多个用户
	public boolean deleteUserByIds(String[] ids) {
		boolean retVal = false;

		try {
			List<String> idsList = Arrays.asList(ids);
			txManager.startTx();
			userDao.deleteUserByIds(idsList);
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
	
	 public boolean deleteUser(String id) {
	    	
	    	boolean retVal = false;
	    	
	    	try {
	            txManager.startTx();

	            userDao.deleteUserById(Integer.parseInt(id));

	            txManager.commitTx();
	            retVal = true;
	            
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
	

	public List getMyUserByKW(BaseQuery queryObj) {
		List retVal = null;

		try {
			txManager.startTx();

			Map<String, Object> queryMap = BeanUtils.describe(queryObj);
			retVal = userDao.getAllUserByKW(queryMap);
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
	
	//根据关键字获取用户个数
	public int getMyUserCountByKW(BaseQuery queryObj) {
		int retVal = 0;

		try {
			txManager.startTx();
			Map<String, Object> queryMap = BeanUtils.describe(queryObj);
			retVal = userDao.getUserCount(queryMap);
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
	
	

	 public UserLog createNewUserLog(UserLog userLog) {
	    	
		 UserLog retVal = null;	    	
	        try {
	            txManager.startTx();
	            userLogDao.createUserLog(userLog);	            
	            txManager.commitTx();
	            retVal = userLog;	                        
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
	 
	 public void SystemLog(String dataObj,String dataObjText,String objPk,String operator,String opeartContent) {
		   SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		    UserLog userLog = new UserLog();
			userLog.setDataObj(dataObj);
			userLog.setDataObjText(dataObjText);
			userLog.setObjPrimaryKey(objPk);
			userLog.setUserName(operator);
			userLog.setOperationDate(df.format(new Timestamp(new Date().getTime())));
			userLog.setOperationContent(opeartContent);
			this.createNewUserLog(userLog);			

	 }
	 
	 public List getAllUserLogByKw(BaseQuery queryObj) {
			List retVal = null;
			try {
				txManager.startTx();
				Map<String, Object> queryMap = BeanUtils.describe(queryObj);
				retVal = userLogDao.getAllUserLogByKw(queryMap);
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

		public int getUserLogCountByKW(BaseQuery queryObj) {
			int retVal = 0;
			try {
				txManager.startTx();
				Map<String, Object> queryMap = BeanUtils.describe(queryObj);
				retVal = userLogDao.getUserLogCount(queryMap);
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
