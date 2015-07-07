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
 * YsmsFoul entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ysms_foul", catalog = "ysms")
public class YsmsFoul implements java.io.Serializable {

	// Fields

	private Integer foulId;
	private YsmsAthlete ysmsAthlete;
	private YsmsGames ysmsGames;
	private Integer foulLevel;
	private String time;

	// Constructors

	/** default constructor */
	public YsmsFoul() {
	}

	/** minimal constructor */
	public YsmsFoul(Integer foulLevel) {
		this.foulLevel = foulLevel;
	}

	/** full constructor */
	public YsmsFoul(YsmsAthlete ysmsAthlete, YsmsGames ysmsGames,
			Integer foulLevel, String time) {
		this.ysmsAthlete = ysmsAthlete;
		this.ysmsGames = ysmsGames;
		this.foulLevel = foulLevel;
		this.time = time;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "foul_id", unique = true, nullable = false)
	public Integer getFoulId() {
		return this.foulId;
	}

	public void setFoulId(Integer foulId) {
		this.foulId = foulId;
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
	@JoinColumn(name = "games_id")
	@JsonIgnore
	public YsmsGames getYsmsGames() {
		return this.ysmsGames;
	}

	public void setYsmsGames(YsmsGames ysmsGames) {
		this.ysmsGames = ysmsGames;
	}

	@Column(name = "foul_level", nullable = false)
	public Integer getFoulLevel() {
		return this.foulLevel;
	}

	public void setFoulLevel(Integer foulLevel) {
		this.foulLevel = foulLevel;
	}

	@Column(name = "time", length = 128)
	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}