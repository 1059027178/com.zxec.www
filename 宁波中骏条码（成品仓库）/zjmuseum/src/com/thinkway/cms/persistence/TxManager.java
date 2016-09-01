package com.thinkway.cms.persistence;

import java.sql.SQLException;

public interface TxManager {

    public void startTx() throws SQLException;

    public void commitTx() throws SQLException;

    public void endTx() throws SQLException;

}
