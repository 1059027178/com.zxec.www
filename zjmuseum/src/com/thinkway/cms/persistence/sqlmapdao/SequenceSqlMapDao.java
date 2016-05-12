package com.thinkway.cms.persistence.sqlmapdao;

import java.sql.SQLException;

import com.thinkway.cms.business.domains.Sequence;
import com.thinkway.cms.persistence.iface.SequenceDao;

public class SequenceSqlMapDao extends SqlMapDao implements SequenceDao {

	  public synchronized int getNextId(String name) throws SQLException {
	    Sequence sequence = new Sequence(name, -1);

	    sequence = (Sequence) sqlMapper.queryForObject("getSequence", sequence);
	    if (sequence == null) {
	      throw new SQLException("Error: A null sequence was returned from the database (could not get next " + name + " sequence).");
	    }
	    Object parameterObject = new Sequence(name, sequence.getNextId() + 1);
	    sqlMapper.update("updateSequence", parameterObject);

	    return sequence.getNextId();
	  }

}
