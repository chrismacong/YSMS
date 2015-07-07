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
 * YsmsGoal entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ysms_goal", catalog = "ysms")
public class YsmsGoal implements java.io.Serializable {

	// Fields

	private Integer goalId;
	private YsmsGames ysmsGames;
	private Integer shooter;
	private Integer assistant;
	private String time;
	private Integer style;

	// Constructors

	/** default constructor */
	public YsmsGoal() {
	}

	/** minimal constructor */
	public YsmsGoal(Integer shooter, String time, Integer style) {
		this.shooter = shooter;
		this.time = time;
		this.style = style;
	}

	/** full constructor */
	public YsmsGoal(YsmsGames ysmsGames, Integer shooter, Integer assistant,
			String time, Integer style) {
		this.ysmsGames = ysmsGames;
		this.shooter = shooter;
		this.assistant = assistant;
		this.time = time;
		this.style = style;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "goal_id", unique = true, nullable = false)
	public Integer getGoalId() {
		return this.goalId;
	}

	public void setGoalId(Integer goalId) {
		this.goalId = goalId;
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

	@Column(name = "shooter", nullable = false)
	public Integer getShooter() {
		return this.shooter;
	}

	public void setShooter(Integer shooter) {
		this.shooter = shooter;
	}

	@Column(name = "assistant")
	public Integer getAssistant() {
		return this.assistant;
	}

	public void setAssistant(Integer assistant) {
		this.assistant = assistant;
	}

	@Column(name = "time", nullable = false, length = 128)
	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Column(name = "style", nullable = false)
	public Integer getStyle() {
		return this.style;
	}

	public void setStyle(Integer style) {
		this.style = style;
	}

}