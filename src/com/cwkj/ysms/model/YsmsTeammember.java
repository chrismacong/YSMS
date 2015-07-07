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
 * YsmsTeammember entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ysms_teammember", catalog = "ysms")
public class YsmsTeammember implements java.io.Serializable {

	// Fields

	private Integer detailId;
	private YsmsAthlete ysmsAthlete;
	private YsmsTeam ysmsTeam;
	private YsmsCoach ysmsCoach;
	private Integer athleteNum;

	// Constructors

	/** default constructor */
	public YsmsTeammember() {
	}

	/** minimal constructor */
	public YsmsTeammember(YsmsTeam ysmsTeam) {
		this.ysmsTeam = ysmsTeam;
	}

	/** full constructor */
	public YsmsTeammember(YsmsAthlete ysmsAthlete, YsmsTeam ysmsTeam,
			YsmsCoach ysmsCoach, Integer athleteNum) {
		this.ysmsAthlete = ysmsAthlete;
		this.ysmsTeam = ysmsTeam;
		this.ysmsCoach = ysmsCoach;
		this.athleteNum = athleteNum;
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
	@JoinColumn(name = "athlete_id")
	@JsonIgnore
	public YsmsAthlete getYsmsAthlete() {
		return this.ysmsAthlete;
	}

	public void setYsmsAthlete(YsmsAthlete ysmsAthlete) {
		this.ysmsAthlete = ysmsAthlete;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "team_id", nullable = false)
	@JsonIgnore
	public YsmsTeam getYsmsTeam() {
		return this.ysmsTeam;
	}

	public void setYsmsTeam(YsmsTeam ysmsTeam) {
		this.ysmsTeam = ysmsTeam;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "coach_id")
	@JsonIgnore
	public YsmsCoach getYsmsCoach() {
		return this.ysmsCoach;
	}

	public void setYsmsCoach(YsmsCoach ysmsCoach) {
		this.ysmsCoach = ysmsCoach;
	}

	@Column(name = "athlete_num")
	public Integer getAthleteNum() {
		return this.athleteNum;
	}

	public void setAthleteNum(Integer athleteNum) {
		this.athleteNum = athleteNum;
	}

}