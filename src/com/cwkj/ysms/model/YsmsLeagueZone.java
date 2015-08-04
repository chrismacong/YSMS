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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * YsmsLeagueZone entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ysms_league_zone", catalog = "ysms")
public class YsmsLeagueZone implements java.io.Serializable {

	// Fields

	private Integer zoneId;
	private YsmsLeague ysmsLeague;
	private String zoneName;
	private Integer deleteflag;
	private String ruleOrder;

	@Column(name = "rule_order")
	public String getRuleOrder() {
		return ruleOrder;
	}

	public void setRuleOrder(String ruleOrder) {
		this.ruleOrder = ruleOrder;
	}

	@Column(name = "deleteflag", nullable = false)
	public Integer getDeleteflag() {
		return deleteflag;
	}

	public void setDeleteflag(Integer deleteflag) {
		this.deleteflag = deleteflag;
	}

	private Set<YsmsZoneTeam> ysmsZoneTeams = new HashSet<YsmsZoneTeam>(0);
	private Set<YsmsGames> ysmsGameses = new HashSet<YsmsGames>(0);
	private Set<YsmsZoneLevel> ysmsZoneLevels = new HashSet<YsmsZoneLevel>(0);

	// Constructors

	/** default constructor */
	public YsmsLeagueZone() {
	}

	/** minimal constructor */
	public YsmsLeagueZone(String zoneName) {
		this.zoneName = zoneName;
	}

	/** full constructor */
	public YsmsLeagueZone(YsmsLeague ysmsLeague, String zoneName, String ruleOrder,
			Set<YsmsZoneTeam> ysmsZoneTeams, Set<YsmsGames> ysmsGameses,
			Set<YsmsZoneLevel> ysmsZoneLevels) {
		this.ysmsLeague = ysmsLeague;
		this.zoneName = zoneName;
		this.ruleOrder = ruleOrder;
		this.ysmsZoneTeams = ysmsZoneTeams;
		this.ysmsGameses = ysmsGameses;
		this.ysmsZoneLevels = ysmsZoneLevels;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "zone_id", unique = true, nullable = false)
	public Integer getZoneId() {
		return this.zoneId;
	}

	public void setZoneId(Integer zoneId) {
		this.zoneId = zoneId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "league_id")
	@JsonIgnore
	public YsmsLeague getYsmsLeague() {
		return this.ysmsLeague;
	}

	public void setYsmsLeague(YsmsLeague ysmsLeague) {
		this.ysmsLeague = ysmsLeague;
	}

	@Column(name = "zone_name", nullable = false, length = 512)
	public String getZoneName() {
		return this.zoneName;
	}

	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ysmsLeagueZone")
	@JsonIgnore
	public Set<YsmsZoneTeam> getYsmsZoneTeams() {
		return this.ysmsZoneTeams;
	}

	public void setYsmsZoneTeams(Set<YsmsZoneTeam> ysmsZoneTeams) {
		this.ysmsZoneTeams = ysmsZoneTeams;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ysmsLeagueZone")
	@JsonIgnore
	public Set<YsmsGames> getYsmsGameses() {
		return this.ysmsGameses;
	}

	public void setYsmsGameses(Set<YsmsGames> ysmsGameses) {
		this.ysmsGameses = ysmsGameses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ysmsLeagueZone")
	@JsonIgnore
	public Set<YsmsZoneLevel> getYsmsZoneLevels() {
		return this.ysmsZoneLevels;
	}

	public void setYsmsZoneLevels(Set<YsmsZoneLevel> ysmsZoneLevels) {
		this.ysmsZoneLevels = ysmsZoneLevels;
	}

}