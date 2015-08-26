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
 * YsmsSchooluser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ysms_judgeuser", catalog = "ysms")
public class YsmsJudgeUser implements java.io.Serializable {

	// Fields

	private Integer primaryId;
	private YsmsUser ysmsUser;
	private YsmsJudge ysmsJudge;

	// Constructors

	/** default constructor */
	public YsmsJudgeUser() {
	}

	/** full constructor */
	public YsmsJudgeUser(YsmsUser ysmsUser, YsmsJudge ysmsJudge) {
		this.ysmsUser = ysmsUser;
		this.ysmsJudge = ysmsJudge;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getPrimaryId() {
		return this.primaryId;
	}

	public void setPrimaryId(Integer primaryId) {
		this.primaryId = primaryId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "uid")
	@JsonIgnore
	public YsmsUser getYsmsUser() {
		return this.ysmsUser;
	}

	public void setYsmsUser(YsmsUser ysmsUser) {
		this.ysmsUser = ysmsUser;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "jid")
	@JsonIgnore
	public YsmsJudge getYsmsJudge() {
		return this.ysmsJudge;
	}

	public void setYsmsJudge(YsmsJudge ysmsJudge) {
		this.ysmsJudge = ysmsJudge;
	}

}
