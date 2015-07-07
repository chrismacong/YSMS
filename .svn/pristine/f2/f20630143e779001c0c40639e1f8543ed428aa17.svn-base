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
 * YsmsTeam entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ysms_team", catalog = "ysms")
public class YsmsTeam implements java.io.Serializable {

	// Fields

	private Integer teamId;
	private YsmsSchool ysmsSchool;
	private String teamName;
	private Integer deleteflag;
	private String leaderName;
	private String leaderPhone;
	private String doctorName;
	private String doctorPhone;
	private Set<YsmsZoneTeam> ysmsZoneTeams = new HashSet<YsmsZoneTeam>(0);
	private Set<YsmsTeammember> ysmsTeammembers = new HashSet<YsmsTeammember>(0);
	private Set<YsmsGames> ysmsGamesesForGuestTeamid = new HashSet<YsmsGames>(0);
	private Set<YsmsGames> ysmsGamesesForHostTeamid = new HashSet<YsmsGames>(0);

	// Constructors

	/** default constructor */
	public YsmsTeam() {
	}

	/** minimal constructor */
	public YsmsTeam(YsmsSchool ysmsSchool, Integer deleteflag) {
		this.ysmsSchool = ysmsSchool;
		this.deleteflag = deleteflag;
	}

	/** full constructor */
	public YsmsTeam(YsmsSchool ysmsSchool, String teamName, Integer deleteflag, String leaderName, 
			String leaderPhone, String doctorName, String doctorPhone,
			Set<YsmsZoneTeam> ysmsZoneTeams,
			Set<YsmsTeammember> ysmsTeammembers,
			Set<YsmsGames> ysmsGamesesForGuestTeamid,
			Set<YsmsGames> ysmsGamesesForHostTeamid) {
		this.ysmsSchool = ysmsSchool;
		this.teamName = teamName;
		this.deleteflag = deleteflag;
		this.ysmsZoneTeams = ysmsZoneTeams;
		this.ysmsTeammembers = ysmsTeammembers;
		this.ysmsGamesesForGuestTeamid = ysmsGamesesForGuestTeamid;
		this.ysmsGamesesForHostTeamid = ysmsGamesesForHostTeamid;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "team_id", unique = true, nullable = false)
	public Integer getTeamId() {
		return this.teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "school_id", nullable = false)
	@JsonIgnore
	public YsmsSchool getYsmsSchool() {
		return this.ysmsSchool;
	}

	public void setYsmsSchool(YsmsSchool ysmsSchool) {
		this.ysmsSchool = ysmsSchool;
	}

	@Column(name = "team_name", length = 128)
	public String getTeamName() {
		return this.teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	@Column(name = "deleteflag", nullable = false)
	public Integer getDeleteflag() {
		return this.deleteflag;
	}

	public void setDeleteflag(Integer deleteflag) {
		this.deleteflag = deleteflag;
	}
	
	@Column(name = "leader_name", length = 128)
	public String getLeaderName(){
		return this.leaderName;
	}
	
	public void setLeaderName(String leaderName){
		this.leaderName = leaderName;
	}
	
	@Column(name = "leader_phone", length = 128)
	public String getLeaderPhone() {
		return leaderPhone;
	}

	public void setLeaderPhone(String leaderPhone) {
		this.leaderPhone = leaderPhone;
	}
	
	@Column(name = "doctor_name", length = 128) 
	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	
	@Column(name = "doctor_phone", length = 128)
	public String getDoctorPhone(){
		return doctorPhone;
	}
	
	public void setDoctorPhone(String doctorPhone) {
		this.doctorPhone = doctorPhone;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ysmsTeam")
	@JsonIgnore
	public Set<YsmsZoneTeam> getYsmsZoneTeams() {
		return this.ysmsZoneTeams;
	}

	public void setYsmsZoneTeams(Set<YsmsZoneTeam> ysmsZoneTeams) {
		this.ysmsZoneTeams = ysmsZoneTeams;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ysmsTeam")
	@JsonIgnore
	public Set<YsmsTeammember> getYsmsTeammembers() {
		return this.ysmsTeammembers;
	}

	public void setYsmsTeammembers(Set<YsmsTeammember> ysmsTeammembers) {
		this.ysmsTeammembers = ysmsTeammembers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ysmsTeamByGuestTeamid")
	@JsonIgnore
	public Set<YsmsGames> getYsmsGamesesForGuestTeamid() {
		return this.ysmsGamesesForGuestTeamid;
	}

	public void setYsmsGamesesForGuestTeamid(
			Set<YsmsGames> ysmsGamesesForGuestTeamid) {
		this.ysmsGamesesForGuestTeamid = ysmsGamesesForGuestTeamid;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ysmsTeamByHostTeamid")
	@JsonIgnore
	public Set<YsmsGames> getYsmsGamesesForHostTeamid() {
		return this.ysmsGamesesForHostTeamid;
	}

	public void setYsmsGamesesForHostTeamid(
			Set<YsmsGames> ysmsGamesesForHostTeamid) {
		this.ysmsGamesesForHostTeamid = ysmsGamesesForHostTeamid;
	}

}