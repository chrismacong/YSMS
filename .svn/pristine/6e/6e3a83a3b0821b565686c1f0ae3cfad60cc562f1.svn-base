package com.cwkj.ysms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * YsmsGroupFunction entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ysms_group_function", catalog = "ysms")
public class YsmsGroupFunction implements java.io.Serializable {

	// Fields

	private Integer detailId;
	private YsmsFunction ysmsFunction;
	private YsmsGroup ysmsGroup;

	// Constructors

	/** default constructor */
	public YsmsGroupFunction() {
	}

	/** full constructor */
	public YsmsGroupFunction(YsmsFunction ysmsFunction, YsmsGroup ysmsGroup) {
		this.ysmsFunction = ysmsFunction;
		this.ysmsGroup = ysmsGroup;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "detail_id", unique = true, nullable = false)
	public Integer getDetailId() {
		return this.detailId;
	}

	public void setDetailId(Integer detailId) {
		this.detailId = detailId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "function_id", nullable = false)
	@JsonIgnore
	public YsmsFunction getYsmsFunction() {
		return this.ysmsFunction;
	}

	public void setYsmsFunction(YsmsFunction ysmsFunction) {
		this.ysmsFunction = ysmsFunction;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "group_id", nullable = false)
	@JsonIgnore
	public YsmsGroup getYsmsGroup() {
		return this.ysmsGroup;
	}

	public void setYsmsGroup(YsmsGroup ysmsGroup) {
		this.ysmsGroup = ysmsGroup;
	}

}