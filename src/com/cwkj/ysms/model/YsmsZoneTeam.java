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
 * YsmsZoneTeam entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ysms_zone_team", catalog = "ysms")
public class YsmsZoneTeam implements java.io.Serializable {

	// Fields

	private Integer detailId;
	private YsmsTeam ysmsTeam;
	private YsmsLeagueZone ysmsLeagueZone;
	private Integer zoneResult;
	private String zoneGroup;

	// Constructors

	

	/** default constructor */
	public YsmsZoneTeam() {
	}

	/** full constructor */
	public YsmsZoneTeam(YsmsTeam ysmsTeam, YsmsLeagueZone ysmsLeagueZone,
			Integer zoneResult, String zoneGroup) {
		this.ysmsTeam = ysmsTeam;
		this.ysmsLeagueZone = ysmsLeagueZone;
		this.zoneResult = zoneResult;
		this.zoneGroup = zoneGroup;
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
	@JoinColumn(name = "team_id")
	@JsonIgnore
	public YsmsTeam getYsmsTeam() {
		return this.ysmsTeam;
	}

	public void setYsmsTeam(YsmsTeam ysmsTeam) {
		this.ysmsTeam = ysmsTeam;
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

	@Column(name = "zone_result")
	public Integer getZoneResult() {
		return zoneResult;
	}

	public void setZoneResult(Integer zoneResult) {
		this.zoneResult = zoneResult;
	}
	
	@Column(name = "zone_group", length = 60)
	public String getZoneGroup() {
		return zoneGroup;
	}

	public void setZoneGroup(String zoneGroup) {
		this.zoneGroup = zoneGroup;
	}
}