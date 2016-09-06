package com.thinkway.cms.business.query;

/**
 * 
 * 查询基类
 * 
 * @author welson
 * @version 1.0
 * 
 */
public class BaseQuery {
	private int skip;
	private int limit;
	private String sdir = null;	
	private String sort = null;
	
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getSkip() {
		return skip;
	}
	public void setSkip(int skip) {
		this.skip = skip;
	}
	public String getSdir() {
		return sdir;
	}
	public void setSdir(String sdir) {
		this.sdir = sdir;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	
}
