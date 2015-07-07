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
 * YsmsGamesJudge entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ysms_games_judge", catalog = "ysms")
public class YsmsGamesJudge implements java.io.Serializable {

	// Fields

	private Integer detailId;
	private YsmsJudge ysmsJudge;
	private YsmsGames ysmsGames;
	private Integer judgePosition;

	// Constructors

	/** default constructor */
	public YsmsGamesJudge() {
	}

	/** full constructor */
	public YsmsGamesJudge(YsmsJudge ysmsJudge, YsmsGames ysmsGames,
			Integer judgePosition) {
		this.ysmsJudge = ysmsJudge;
		this.ysmsGames = ysmsGames;
		this.judgePosition = judgePosition;
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
	@JoinColumn(name = "judge_id")
	@JsonIgnore
	public YsmsJudge getYsmsJudge() {
		return this.ysmsJudge;
	}

	public void setYsmsJudge(YsmsJudge ysmsJudge) {
		this.ysmsJudge = ysmsJudge;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "games_id")
	@JsonIgnore
	public YsmsGames getYsmsGames() {
		return this.ysmsGames;
	}

	public void setYsmsGames(YsmsGames ysmsGames) {
		this.ysmsGames = ysmsGames;
	}

	@Column(name = "judge_position")
	public Integer getJudgePosition() {
		return this.judgePosition;
	}

	public void setJudgePosition(Integer judgePosition) {
		this.judgePosition = judgePosition;
	}

}