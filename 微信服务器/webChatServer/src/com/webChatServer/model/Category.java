package com.webChatServer.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Category entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CATEGORY", schema = "WEIXINTEST")
public class Category implements java.io.Serializable {
	// Fields

	private int ctId;
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

	public Category(int ctId, String ctType, int hot) {
		// TODO Auto-generated constructor stub
		this.ctId = ctId;
		this.ctType = ctType;
		this.hot = hot;
	}

	// Property accessors
	/**
	 * ����hibernate��һ��ֻʹ��������������������⡿��
	 * 1.�����ݿ�����������,����oracle sql���£�
	 * oracle sql ��create sequence seq_on_test increment by 1 start with 1 nomaxvalue nocycle nocache;
	 * 2.���ö�Ӧ���е���Ϣ�����ơ�ÿ�����Ӷ��٣���
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQ_ON_TEST")
	@SequenceGenerator(name="SEQ_ON_TEST",sequenceName="SEQ_ON_TEST",allocationSize=1)
	@Column(name = "CT_ID", unique = true, nullable = true, precision = 22, scale = 0)
	public int getCtId() {
		return this.ctId;
	}

	public void setCtId(int ctId) {
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