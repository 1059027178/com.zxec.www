package com.thinkway.cms.persistence.iface;

import java.sql.SQLException;

public interface SequenceDao {

	int getNextId(String name) throws SQLException;
	
}
