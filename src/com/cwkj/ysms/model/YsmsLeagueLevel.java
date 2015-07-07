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
 * YsmsLeagueLevel entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ysms_league_level", catalog = "ysms")
public class YsmsLeagueLevel implements java.io.Serializable {

	// Fields

	private Integer levelId;
	private String levelName;
	private Set<YsmsZoneLevel> ysmsZoneLevels = new HashSet<YsmsZoneLevel>(0);

	// Constructors

	/** default constructor */
	public YsmsLeagueLevel() {
	}

	/** minimal constructor */
	public YsmsLeagueLevel(String levelName) {
		this.levelName = levelName;
	}

	/** full constructor */
	public YsmsLeagueLevel(String levelName, Set<YsmsZoneLevel> ysmsZoneLevels) {
		this.levelName = levelName;
		this.ysmsZoneLevels = ysmsZoneLevels;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "level_id", unique = true, nullable = false)
	public Integer getLevelId() {
		return this.levelId;
	}

	public void setLevelId(Integer levelId) {
		this.levelId = levelId;
	}

	@Column(name = "level_name", nullable = false, length = 512)
	public String getLevelName() {
		return this.levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ysmsLeagueLevel")
	@JsonIgnore
	public Set<YsmsZoneLevel> getYsmsZoneLevels() {
		return this.ysmsZoneLevels;
	}

	public void setYsmsZoneLevels(Set<YsmsZoneLevel> ysmsZoneLevels) {
		this.ysmsZoneLevels = ysmsZoneLevels;
	}

}