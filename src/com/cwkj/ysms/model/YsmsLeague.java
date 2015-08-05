package com.cwkj.ysms.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * YsmsLeague entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ysms_league", catalog = "ysms")
public class YsmsLeague implements java.io.Serializable {

	// Fields

	private Integer leagueId;
	private String leagueName;
	private Date leagueYear;
	private Integer leagueTotal;
	private Date registerBegintime;
	private Date registerEndtime;
	private Integer deleteflag;
	private Date leagueBegintime;
	private Date leagueEndtime;
	private String leagueDescription;
	
	private Set<YsmsLeagueZone> ysmsLeagueZones = new HashSet<YsmsLeagueZone>(0);

	// Constructors

	/** default constructor */
	public YsmsLeague() {
	}

	/** minimal constructor */
	public YsmsLeague(String leagueName, Date leagueYear, Integer leagueTotal,
			Date registerBegintime, Date registerEndtime, Integer deleteflag) {
		this.leagueName = leagueName;
		this.leagueYear = leagueYear;
		this.leagueTotal = leagueTotal;
		this.registerBegintime = registerBegintime;
		this.registerEndtime = registerEndtime;
		this.deleteflag = deleteflag;
	}

	/** full constructor */
	public YsmsLeague(String leagueName, Date leagueYear, Integer leagueTotal,
			Date registerBegintime, Date registerEndtime, Integer deleteflag,
			Set<YsmsLeagueZone> ysmsLeagueZones) {
		this.leagueName = leagueName;
		this.leagueYear = leagueYear;
		this.leagueTotal = leagueTotal;
		this.registerBegintime = registerBegintime;
		this.registerEndtime = registerEndtime;
		this.deleteflag = deleteflag;
		this.ysmsLeagueZones = ysmsLeagueZones;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "league_id", unique = true, nullable = false)
	public Integer getLeagueId() {
		return this.leagueId;
	}

	public void setLeagueId(Integer leagueId) {
		this.leagueId = leagueId;
	}

	@Column(name = "league_name", nullable = false, length = 512)
	public String getLeagueName() {
		return this.leagueName;
	}

	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "league_year", nullable = false, length = 0)
	public Date getLeagueYear() {
		return this.leagueYear;
	}

	public void setLeagueYear(Date leagueYear) {
		this.leagueYear = leagueYear;
	}

	@Column(name = "league_total", nullable = false)
	public Integer getLeagueTotal() {
		return this.leagueTotal;
	}

	public void setLeagueTotal(Integer leagueTotal) {
		this.leagueTotal = leagueTotal;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "register_begintime", nullable = false, length = 0)
	public Date getRegisterBegintime() {
		return this.registerBegintime;
	}

	public void setRegisterBegintime(Date registerBegintime) {
		this.registerBegintime = registerBegintime;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "register_endtime", nullable = false, length = 0)
	public Date getRegisterEndtime() {
		return this.registerEndtime;
	}

	public void setRegisterEndtime(Date registerEndtime) {
		this.registerEndtime = registerEndtime;
	}

	@Column(name = "deleteflag", nullable = false)
	public Integer getDeleteflag() {
		return this.deleteflag;
	}

	public void setDeleteflag(Integer deleteflag) {
		this.deleteflag = deleteflag;
	}
	
	@Column(name = "league_begintime")
	public Date getLeagueBegintime() {
		return leagueBegintime;
	}

	public void setLeagueBegintime(Date leagueBegintime) {
		this.leagueBegintime = leagueBegintime;
	}

	@Column(name = "league_endtime")
	public Date getLeagueEndtime() {
		return leagueEndtime;
	}

	public void setLeagueEndtime(Date leagueEndtime) {
		this.leagueEndtime = leagueEndtime;
	}

	@Column(name = "league_description")
	public String getLeagueDescription() {
		return leagueDescription;
	}

	public void setLeagueDescription(String leagueDescription) {
		this.leagueDescription = leagueDescription;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ysmsLeague")
	@JsonIgnore
	public Set<YsmsLeagueZone> getYsmsLeagueZones() {
		return this.ysmsLeagueZones;
	}

	public void setYsmsLeagueZones(Set<YsmsLeagueZone> ysmsLeagueZones) {
		this.ysmsLeagueZones = ysmsLeagueZones;
	}

}