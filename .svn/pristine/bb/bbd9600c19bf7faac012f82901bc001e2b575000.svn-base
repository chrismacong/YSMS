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
@Table(name = "ysms_schooluser", catalog = "ysms")
public class YsmsSchooluser implements java.io.Serializable {

	// Fields

	private Integer primaryId;
	private YsmsUser ysmsUser;
	private YsmsSchool ysmsSchool;

	// Constructors

	/** default constructor */
	public YsmsSchooluser() {
	}

	/** full constructor */
	public YsmsSchooluser(YsmsUser ysmsUser, YsmsSchool ysmsSchool) {
		this.ysmsUser = ysmsUser;
		this.ysmsSchool = ysmsSchool;
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
	@JoinColumn(name = "user_id")
	@JsonIgnore
	public YsmsUser getYsmsUser() {
		return this.ysmsUser;
	}

	public void setYsmsUser(YsmsUser ysmsUser) {
		this.ysmsUser = ysmsUser;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "school_id")
	@JsonIgnore
	public YsmsSchool getYsmsSchool() {
		return this.ysmsSchool;
	}

	public void setYsmsSchool(YsmsSchool ysmsSchool) {
		this.ysmsSchool = ysmsSchool;
	}

}