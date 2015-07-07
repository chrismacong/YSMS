package com.cwkj.ysms.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * YsmsUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ysms_user", catalog = "ysms")
public class YsmsUser implements java.io.Serializable {

	// Fields

	private Integer userId;
	private YsmsGroup ysmsGroup;
	private String userEmail;
	private String userPassword;
	private String userName;
	private Integer deleteflag;
	private Set<YsmsSchooluser> ysmsSchoolusers = new HashSet<YsmsSchooluser>(0);
	private Set<YsmsLog> ysmsLogs = new HashSet<YsmsLog>(0);

	// Constructors

	/** default constructor */
	public YsmsUser() {
	}

	/** minimal constructor */
	public YsmsUser(YsmsGroup ysmsGroup, String userPassword, String userName,
			Integer deleteflag) {
		this.ysmsGroup = ysmsGroup;
		this.userPassword = userPassword;
		this.userName = userName;
		this.deleteflag = deleteflag;
	}

	/** full constructor */
	public YsmsUser(YsmsGroup ysmsGroup, String userEmail, String userPassword,
			String userName, Integer deleteflag,
			Set<YsmsSchooluser> ysmsSchoolusers, Set<YsmsLog> ysmsLogs) {
		this.ysmsGroup = ysmsGroup;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userName = userName;
		this.deleteflag = deleteflag;
		this.ysmsSchoolusers = ysmsSchoolusers;
		this.ysmsLogs = ysmsLogs;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "user_id", unique = true, nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	@Column(name = "user_email", length = 128)
	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Column(name = "user_password", nullable = false, length = 128)
	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Column(name = "user_name", nullable = false, length = 128)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "deleteflag", nullable = false)
	public Integer getDeleteflag() {
		return this.deleteflag;
	}

	public void setDeleteflag(Integer deleteflag) {
		this.deleteflag = deleteflag;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ysmsUser")
	@JsonIgnore
	public Set<YsmsSchooluser> getYsmsSchoolusers() {
		return this.ysmsSchoolusers;
	}

	public void setYsmsSchoolusers(Set<YsmsSchooluser> ysmsSchoolusers) {
		this.ysmsSchoolusers = ysmsSchoolusers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ysmsUser")
	@JsonIgnore
	public Set<YsmsLog> getYsmsLogs() {
		return this.ysmsLogs;
	}

	public void setYsmsLogs(Set<YsmsLog> ysmsLogs) {
		this.ysmsLogs = ysmsLogs;
	}

}