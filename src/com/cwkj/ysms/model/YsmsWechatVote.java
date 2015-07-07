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
 * YsmsWechatVote entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ysms_wechat_vote", catalog = "ysms")
public class YsmsWechatVote implements java.io.Serializable {

	// Fields

	private Integer id;
	private YsmsWechataccount ysmsWechataccount;
	private YsmsWechatnews ysmsWechatnews;
	private Integer voteflag;

	// Constructors

	/** default constructor */
	public YsmsWechatVote() {
	}

	/** full constructor */
	public YsmsWechatVote(YsmsWechataccount ysmsWechataccount,
			YsmsWechatnews ysmsWechatnews, Integer voteflag) {
		this.ysmsWechataccount = ysmsWechataccount;
		this.ysmsWechatnews = ysmsWechatnews;
		this.voteflag = voteflag;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "wechataccount_id", nullable = false)
	@JsonIgnore
	public YsmsWechataccount getYsmsWechataccount() {
		return this.ysmsWechataccount;
	}

	public void setYsmsWechataccount(YsmsWechataccount ysmsWechataccount) {
		this.ysmsWechataccount = ysmsWechataccount;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "news_id", nullable = false)
	@JsonIgnore
	public YsmsWechatnews getYsmsWechatnews() {
		return this.ysmsWechatnews;
	}

	public void setYsmsWechatnews(YsmsWechatnews ysmsWechatnews) {
		this.ysmsWechatnews = ysmsWechatnews;
	}

	@Column(name = "voteflag", nullable = false)
	public Integer getVoteflag() {
		return this.voteflag;
	}

	public void setVoteflag(Integer voteflag) {
		this.voteflag = voteflag;
	}

}