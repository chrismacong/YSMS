package com.cwkj.ysms.model;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * YsmsGames entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ysms_games", catalog = "ysms")
public class YsmsGames implements java.io.Serializable {

	// Fields

	private Integer gamesId;
	private YsmsTeam ysmsTeamByHostTeamid;
	private YsmsLeagueZone ysmsLeagueZone;
	private YsmsTeam ysmsTeamByGuestTeamid;
	private Date gamesTime;
	private String gameLocation;
	private Integer hostScore;
	private Integer guestScore;
	private Integer gamesOrder;
	private Integer hostUniform;
	private Integer guestUniform;
	private Integer hostGoalAttempt;
	private Integer guestGoalAttempt;
	private Integer hostTargetNumber;
	private Integer guestTargetNumber;
	private Integer hostCornerKick;
	private Integer guestCornerKick;
	private Integer hostFreeKick;
	private Integer guestFreeKick;
	private Integer hostFoul;
	private Integer guestFoul;
	private Integer hostOffside;
	private Integer guestOffside;
	private Integer isOvertimeFlag;

	private Integer hostOvertimeScore;
	private Integer guestOvertimeScore;
	private Integer isPenaltyFlag;
	private Integer hostPenaltyScore;
	private Integer guestPenaltyScore;
	private Integer isGameOver;
	private Set<YsmsFoul> ysmsFouls = new HashSet<YsmsFoul>(0);
	private Set<YsmsGoal> ysmsGoals = new HashSet<YsmsGoal>(0);
	private Set<YsmsGamesJudge> ysmsGamesJudges = new HashSet<YsmsGamesJudge>(0);

	// Constructors

	/** default constructor */
	public YsmsGames() {
	}

	/** minimal constructor */
	public YsmsGames(Integer gamesOrder) {
		this.gamesOrder = gamesOrder;
	}

	/** full constructor */
	public YsmsGames(YsmsTeam ysmsTeamByHostTeamid,
			YsmsLeagueZone ysmsLeagueZone, YsmsTeam ysmsTeamByGuestTeamid,
			Date gamesTime, String gameLocation, Integer hostScore,
			Integer guestScore, Integer gamesOrder, Integer hostUniform, 
			Integer guestUniform, Set<YsmsFoul> ysmsFouls,
			Set<YsmsGoal> ysmsGoals, Set<YsmsGamesJudge> ysmsGamesJudges) {
		this.ysmsTeamByHostTeamid = ysmsTeamByHostTeamid;
		this.ysmsLeagueZone = ysmsLeagueZone;
		this.ysmsTeamByGuestTeamid = ysmsTeamByGuestTeamid;
		this.gamesTime = gamesTime;
		this.gameLocation = gameLocation;
		this.hostScore = hostScore;
		this.guestScore = guestScore;
		this.gamesOrder = gamesOrder;
		this.ysmsFouls = ysmsFouls;
		this.ysmsGoals = ysmsGoals;
		this.ysmsGamesJudges = ysmsGamesJudges;
		this.hostUniform = hostUniform;
		this.guestUniform = guestUniform;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "games_id", unique = true, nullable = false)
	public Integer getGamesId() {
		return this.gamesId;
	}

	public void setGamesId(Integer gamesId) {
		this.gamesId = gamesId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "host_teamid")
	@JsonIgnore
	public YsmsTeam getYsmsTeamByHostTeamid() {
		return this.ysmsTeamByHostTeamid;
	}

	public void setYsmsTeamByHostTeamid(YsmsTeam ysmsTeamByHostTeamid) {
		this.ysmsTeamByHostTeamid = ysmsTeamByHostTeamid;
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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "guest_teamid")
	@JsonIgnore
	public YsmsTeam getYsmsTeamByGuestTeamid() {
		return this.ysmsTeamByGuestTeamid;
	}

	public void setYsmsTeamByGuestTeamid(YsmsTeam ysmsTeamByGuestTeamid) {
		this.ysmsTeamByGuestTeamid = ysmsTeamByGuestTeamid;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "games_time", length = 0)
	public Date getGamesTime() {
		return this.gamesTime;
	}

	public void setGamesTime(Date gamesTime) {
		this.gamesTime = gamesTime;
	}

	@Column(name = "game_location", length = 128)
	public String getGameLocation() {
		return this.gameLocation;
	}

	public void setGameLocation(String gameLocation) {
		this.gameLocation = gameLocation;
	}

	@Column(name = "host_score")
	public Integer getHostScore() {
		return this.hostScore;
	}

	public void setHostScore(Integer hostScore) {
		this.hostScore = hostScore;
	}

	@Column(name = "guest_score")
	public Integer getGuestScore() {
		return this.guestScore;
	}

	public void setGuestScore(Integer guestScore) {
		this.guestScore = guestScore;
	}

	@Column(name = "games_order", nullable = false)
	public Integer getGamesOrder() {
		return this.gamesOrder;
	}

	public void setGamesOrder(Integer gamesOrder) {
		this.gamesOrder = gamesOrder;
	}
	
	@Column(name = "host_uniform", nullable = false)
	public Integer getHostUniform(){
		return this.hostUniform;
	}
	public void setHostUniform(Integer hostUniform){
		this.hostUniform = hostUniform;
	}
	
	@Column(name = "guest_uniform", nullable = false)
	public Integer getGuestUniform(){
		return this.guestUniform;
	}
	public void setGuestUniform(Integer guestUniform){
		this.guestUniform = guestUniform;
	}
	
	@Column(name = "host_goalattempt")
	public Integer getHostGoalAttempt() {
		return hostGoalAttempt;
	}

	public void setHostGoalAttempt(Integer hostGoalAttempt) {
		this.hostGoalAttempt = hostGoalAttempt;
	}
	
	@Column(name = "guest_goalattempt")
	public Integer getGuestGoalAttempt() {
		return guestGoalAttempt;
	}

	public void setGuestGoalAttempt(Integer guestGoalAttempt) {
		this.guestGoalAttempt = guestGoalAttempt;
	}

	@Column(name = "host_targetnumber")
	public Integer getHostTargetNumber() {
		return hostTargetNumber;
	}

	public void setHostTargetNumber(Integer hostTargetNumber) {
		this.hostTargetNumber = hostTargetNumber;
	}

	@Column(name = "guest_targetnumber")
	public Integer getGuestTargetNumber() {
		return guestTargetNumber;
	}

	public void setGuestTargetNumber(Integer guestTargetNumber) {
		this.guestTargetNumber = guestTargetNumber;
	}

	@Column(name = "host_cornerkick")
	public Integer getHostCornerKick() {
		return hostCornerKick;
	}

	public void setHostCornerKick(Integer hostCornerKick) {
		this.hostCornerKick = hostCornerKick;
	}

	@Column(name = "guest_cornerkick")
	public Integer getGuestCornerKick() {
		return guestCornerKick;
	}

	public void setGuestCornerKick(Integer guestCornerKick) {
		this.guestCornerKick = guestCornerKick;
	}

	@Column(name = "host_freekick")
	public Integer getHostFreeKick() {
		return hostFreeKick;
	}

	public void setHostFreeKick(Integer hostFreeKick) {
		this.hostFreeKick = hostFreeKick;
	}

	@Column(name = "guest_freekick")
	public Integer getGuestFreeKick() {
		return guestFreeKick;
	}

	public void setGuestFreeKick(Integer guestFreeKick) {
		this.guestFreeKick = guestFreeKick;
	}

	@Column(name = "host_foul")
	public Integer getHostFoul() {
		return hostFoul;
	}

	public void setHostFoul(Integer hostFoul) {
		this.hostFoul = hostFoul;
	}

	@Column(name = "guest_foul")
	public Integer getGuestFoul() {
		return guestFoul;
	}

	public void setGuestFoul(Integer guestFoul) {
		this.guestFoul = guestFoul;
	}

	@Column(name = "host_offside")
	public Integer getHostOffside() {
		return hostOffside;
	}

	public void setHostOffside(Integer hostOffside) {
		this.hostOffside = hostOffside;
	}

	@Column(name = "guest_offside")
	public Integer getGuestOffside() {
		return guestOffside;
	}

	public void setGuestOffside(Integer guestOffside) {
		this.guestOffside = guestOffside;
	}
	
	@Column(name = "is_overtime_flag", nullable = false)
	public Integer getIsOvertimeFlag() {
		return isOvertimeFlag;
	}

	public void setIsOvertimeFlag(Integer isOvertimeFlag) {
		this.isOvertimeFlag = isOvertimeFlag;
	}

	@Column(name = "overtime_host_score")
	public Integer getHostOvertimeScore() {
		return hostOvertimeScore;
	}

	public void setHostOvertimeScore(Integer hostOvertimeScore) {
		this.hostOvertimeScore = hostOvertimeScore;
	}
	
	@Column(name = "overtime_guest_score")
	public Integer getGuestOvertimeScore() {
		return guestOvertimeScore;
	}

	public void setGuestOvertimeScore(Integer guestOvertimeScore) {
		this.guestOvertimeScore = guestOvertimeScore;
	}

	@Column(name = "is_penalty_flag", nullable = false)
	public Integer getIsPenaltyFlag() {
		return isPenaltyFlag;
	}

	public void setIsPenaltyFlag(Integer isPenaltyFlag) {
		this.isPenaltyFlag = isPenaltyFlag;
	}

	@Column(name = "penalty_host_score")
	public Integer getHostPenaltyScore() {
		return hostPenaltyScore;
	}

	public void setHostPenaltyScore(Integer hostPenaltyScore) {
		this.hostPenaltyScore = hostPenaltyScore;
	}

	@Column(name = "penalty_guest_score")
	public Integer getGuestPenaltyScore() {
		return guestPenaltyScore;
	}

	public void setGuestPenaltyScore(Integer guestPenaltyScore) {
		this.guestPenaltyScore = guestPenaltyScore;
	}
	
	@Column(name = "is_game_over", nullable = false)
	public Integer getIsGameOver() {
		return isGameOver;
	}

	public void setIsGameOver(Integer isGameOver) {
		this.isGameOver = isGameOver;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ysmsGames")
	@JsonIgnore
	public Set<YsmsFoul> getYsmsFouls() {
		return this.ysmsFouls;
	}

	public void setYsmsFouls(Set<YsmsFoul> ysmsFouls) {
		this.ysmsFouls = ysmsFouls;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ysmsGames")
	@JsonIgnore
	public Set<YsmsGoal> getYsmsGoals() {
		return this.ysmsGoals;
	}

	public void setYsmsGoals(Set<YsmsGoal> ysmsGoals) {
		this.ysmsGoals = ysmsGoals;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ysmsGames")
	@JsonIgnore
	public Set<YsmsGamesJudge> getYsmsGamesJudges() {
		return this.ysmsGamesJudges;
	}

	public void setYsmsGamesJudges(Set<YsmsGamesJudge> ysmsGamesJudges) {
		this.ysmsGamesJudges = ysmsGamesJudges;
	}

}