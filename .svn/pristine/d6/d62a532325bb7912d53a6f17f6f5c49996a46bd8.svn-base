package com.cwkj.ysms.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * YsmsJudgeandlevel entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ysms_judgeandlevel", catalog = "ysms")
public class YsmsJudgeandlevel implements java.io.Serializable {

	// Fields

	private Integer primaryId;
	private YsmsJudgelevel ysmsJudgelevel;
	private YsmsJudge ysmsJudge;

	// Constructors

	/** default constructor */
	public YsmsJudgeandlevel() {
	}

	/** full constructor */
	public YsmsJudgeandlevel(YsmsJudgelevel ysmsJudgelevel, YsmsJudge ysmsJudge) {
		this.ysmsJudgelevel = ysmsJudgelevel;
		this.ysmsJudge = ysmsJudge;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "primary_id", unique = true, nullable = false)
	public Integer getPrimaryId() {
		return this.primaryId;
	}

	public void setPrimaryId(Integer primaryId) {
		this.primaryId = primaryId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "level_id")
	@JsonIgnore
	public YsmsJudgelevel getYsmsJudgelevel() {
		return this.ysmsJudgelevel;
	}

	public void setYsmsJudgelevel(YsmsJudgelevel ysmsJudgelevel) {
		this.ysmsJudgelevel = ysmsJudgelevel;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "judge_id")
	@JsonIgnore
	public YsmsJudge getYsmsJudge() {
		return this.ysmsJudge;
	}

	public void setYsmsJudge(YsmsJudge ysmsJudge) {
		this.ysmsJudge = ysmsJudge;
	}

}