package com.webChatServer.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Category entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CATEGORY", schema = "WEIXINTEST")
public class Category implements java.io.Serializable {

	// Fields

	private BigDecimal ctId;
	private String ctType;
	private int hot;

	// Constructors

	/** default constructor */
	public Category() {
	}

	/** full constructor */
	public Category(String ctType, int hot) {
		this.ctType = ctType;
		this.hot = hot;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "CT_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getCtId() {
		return this.ctId;
	}

	public void setCtId(BigDecimal ctId) {
		this.ctId = ctId;
	}

	@Column(name = "CT_TYPE", length = 20)
	public String getCtType() {
		return this.ctType;
	}

	public void setCtType(String ctType) {
		this.ctType = ctType;
	}

	@Column(name = "HOT", precision = 1, scale = 0)
	public int getHot() {
		return this.hot;
	}

	public void setHot(int hot) {
		this.hot = hot;
	}

}