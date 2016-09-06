package com.thinkway.cms.business.domains;

import java.io.Serializable;

public class Sequence implements Serializable{

	private static final long serialVersionUID = 3907024238042166650L;
	
	private String name = null;  
	private Integer nextId = null;

	  public Sequence() {
	  }

	  public Sequence(String name, Integer nextId) {
	    this.name = name;
	    this.nextId = nextId;
	  }

	  public String getName() {
	    return name;
	  }

	  public void setName(String name) {
	    this.name = name;
	  }

	  public Integer getNextId() {
	    return nextId;
	  }

	  public void setNextId(Integer nextId) {
	    this.nextId = nextId;
	  }
}
