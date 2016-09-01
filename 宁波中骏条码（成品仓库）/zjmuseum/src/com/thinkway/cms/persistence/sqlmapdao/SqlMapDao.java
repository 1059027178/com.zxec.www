package com.thinkway.cms.persistence.sqlmapdao;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import java.io.Reader;
import com.ibatis.common.resources.Resources;
import java.io.IOException;

import com.thinkway.cms.persistence.TxManager;

import java.sql.*;


public class SqlMapDao implements TxManager {

    protected static SqlMapClient sqlMapper;

    private static SqlMapDao sqlMapDao = null;

    static {
        try {
            Reader reader = Resources.getResourceAsReader(
                    "com/thinkway/cms/persistence/sqlmapdao/SqlMapConfig.xml");
            sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
            reader.close();
        } catch (IOException e) {
            // Fail fast.
            throw new RuntimeException(
                    "Something bad happened while building the SqlMapClient instance." +
                    e, e);
        }
    }

    public void startTx() throws SQLException {

        SqlMapDao.sqlMapper.startTransaction();

    }

    public void commitTx() throws SQLException {

        SqlMapDao.sqlMapper.commitTransaction();

    }

    public void endTx() throws SQLException {
        SqlMapDao.sqlMapper.endTransaction();
    }

    public static TxManager getTxManager(){
        if(sqlMapDao==null){
            return new SqlMapDao();
        }else{
            return sqlMapDao;
        }
    }


}
