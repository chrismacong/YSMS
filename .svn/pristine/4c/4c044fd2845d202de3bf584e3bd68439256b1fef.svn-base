package com.cwkj.ysms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * YsmsLog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ysms_log", catalog = "ysms")
public class YsmsLog implements java.io.Serializable {

	// Fields

	private Integer logId;
	private YsmsUser ysmsUser;
	private String logContent;
	private String logType;
	private Date logTime;

	// Constructors

	/** default constructor */
	public YsmsLog() {
	}

	/** full constructor */
	public YsmsLog(YsmsUser ysmsUser, String logContent, String logType,
			Date logTime) {
		this.ysmsUser = ysmsUser;
		this.logContent = logContent;
		this.logType = logType;
		this.logTime = logTime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "log_id", unique = true, nullable = false)
	public Integer getLogId() {
		return this.logId;
	}

	public void setLogId(Integer logId) {
		this.logId = logId;
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

	@Column(name = "log_content", length = 8000)
	public String getLogContent() {
		return this.logContent;
	}

	public void setLogContent(String logContent) {
		this.logContent = logContent;
	}

	@Column(name = "log_type", length = 2000)
	public String getLogType() {
		return this.logType;
	}

	public void setLogType(String logType) {
		this.logType = logType;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "log_time", length = 0)
	public Date getLogTime() {
		return this.logTime;
	}

	public void setLogTime(Date logTime) {
		this.logTime = logTime;
	}

}