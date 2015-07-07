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
 * YsmsZoneLevel entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ysms_zone_level", catalog = "ysms")
public class YsmsZoneLevel implements java.io.Serializable {

	// Fields

	private Integer primaryId;
	private YsmsLeagueLevel ysmsLeagueLevel;
	private YsmsLeagueZone ysmsLeagueZone;

	// Constructors

	/** default constructor */
	public YsmsZoneLevel() {
	}

	/** full constructor */
	public YsmsZoneLevel(YsmsLeagueLevel ysmsLeagueLevel,
			YsmsLeagueZone ysmsLeagueZone) {
		this.ysmsLeagueLevel = ysmsLeagueLevel;
		this.ysmsLeagueZone = ysmsLeagueZone;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "primary_id", unique = true, nullable = false)
	public Integer getPrimaryId() {
		return this.primaryId;
	}

	public void setPrimaryId(Integer primaryId) {
		this.primaryId = primaryId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "level_id")
	@JsonIgnore
	public YsmsLeagueLevel getYsmsLeagueLevel() {
		return this.ysmsLeagueLevel;
	}

	public void setYsmsLeagueLevel(YsmsLeagueLevel ysmsLeagueLevel) {
		this.ysmsLeagueLevel = ysmsLeagueLevel;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "zone_id")
	@JsonIgnore
	public YsmsLeagueZone getYsmsLeagueZone() {
		return this.ysmsLeagueZone;
	}

	public void setYsmsLeagueZone(YsmsLeagueZone ysmsLeagueZone) {
		this.ysmsLeagueZone = ysmsLeagueZone;
	}

}