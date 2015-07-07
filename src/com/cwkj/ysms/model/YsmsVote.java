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
 * YsmsVote entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ysms_vote", catalog = "ysms")
public class YsmsVote implements java.io.Serializable {

	// Fields

	private Integer voteId;
	private YsmsWechatnews ysmsWechatnews;
	private String imagePath;
	private Integer voteNum;

	// Constructors

	/** default constructor */
	public YsmsVote() {
	}

	/** minimal constructor */
	public YsmsVote(YsmsWechatnews ysmsWechatnews, Integer voteNum) {
		this.ysmsWechatnews = ysmsWechatnews;
		this.voteNum = voteNum;
	}

	/** full constructor */
	public YsmsVote(YsmsWechatnews ysmsWechatnews, String imagePath,
			Integer voteNum) {
		this.ysmsWechatnews = ysmsWechatnews;
		this.imagePath = imagePath;
		this.voteNum = voteNum;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "vote_id", unique = true, nullable = false)
	public Integer getVoteId() {
		return this.voteId;
	}

	public void setVoteId(Integer voteId) {
		this.voteId = voteId;
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

	@Column(name = "image_path", length = 512)
	public String getImagePath() {
		return this.imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Column(name = "vote_num", nullable = false)
	public Integer getVoteNum() {
		return this.voteNum;
	}

	public void setVoteNum(Integer voteNum) {
		this.voteNum = voteNum;
	}

}