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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * YsmsGroup entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ysms_group", catalog = "ysms")
public class YsmsGroup implements java.io.Serializable {

	// Fields

	private Integer groupId;
	private String groupDesc;
	private String groupName;
	private Set<YsmsGroupFunction> ysmsGroupFunctions = new HashSet<YsmsGroupFunction>(
			0);
	private Set<YsmsUser> ysmsUsers = new HashSet<YsmsUser>(0);

	// Constructors

	/** default constructor */
	public YsmsGroup() {
	}

	/** minimal constructor */
	public YsmsGroup(String groupName) {
		this.groupName = groupName;
	}

	/** full constructor */
	public YsmsGroup(String groupDesc, String groupName,
			Set<YsmsGroupFunction> ysmsGroupFunctions, Set<YsmsUser> ysmsUsers) {
		this.groupDesc = groupDesc;
		this.groupName = groupName;
		this.ysmsGroupFunctions = ysmsGroupFunctions;
		this.ysmsUsers = ysmsUsers;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "group_id", unique = true, nullable = false)
	public Integer getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	@Column(name = "group_desc", length = 1024)
	public String getGroupDesc() {
		return this.groupDesc;
	}

	public void setGroupDesc(String groupDesc) {
		this.groupDesc = groupDesc;
	}

	@Column(name = "group_name", nullable = false, length = 128)
	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ysmsGroup")
	@JsonIgnore
	public Set<YsmsGroupFunction> getYsmsGroupFunctions() {
		return this.ysmsGroupFunctions;
	}

	public void setYsmsGroupFunctions(Set<YsmsGroupFunction> ysmsGroupFunctions) {
		this.ysmsGroupFunctions = ysmsGroupFunctions;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ysmsGroup")
	@JsonIgnore
	public Set<YsmsUser> getYsmsUsers() {
		return this.ysmsUsers;
	}

	public void setYsmsUsers(Set<YsmsUser> ysmsUsers) {
		this.ysmsUsers = ysmsUsers;
	}

}