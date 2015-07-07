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
 * YsmsJudgeAtt entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ysms_judge_att", catalog = "ysms")
public class YsmsJudgeAtt implements java.io.Serializable {

	// Fields

	private Integer judgeAttid;
	private YsmsJudge ysmsJudge;
	private String attName;
	private Integer attType;

	// Constructors

	/** default constructor */
	public YsmsJudgeAtt() {
	}

	/** minimal constructor */
	public YsmsJudgeAtt(String attName, Integer attType) {
		this.attName = attName;
		this.attType = attType;
	}

	/** full constructor */
	public YsmsJudgeAtt(YsmsJudge ysmsJudge, String attName, Integer attType) {
		this.ysmsJudge = ysmsJudge;
		this.attName = attName;
		this.attType = attType;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "judge_attid", unique = true, nullable = false)
	public Integer getJudgeAttid() {
		return this.judgeAttid;
	}

	public void setJudgeAttid(Integer judgeAttid) {
		this.judgeAttid = judgeAttid;
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

	@Column(name = "att_name", nullable = false, length = 65535)
	public String getAttName() {
		return this.attName;
	}

	public void setAttName(String attName) {
		this.attName = attName;
	}

	@Column(name = "att_type", nullable = false)
	public Integer getAttType() {
		return this.attType;
	}

	public void setAttType(Integer attType) {
		this.attType = attType;
	}

}