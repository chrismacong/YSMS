package com.cwkj.ysms.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.cwkj.ysms.dao.AthleteDao;
import com.cwkj.ysms.dao.FoulDao;
import com.cwkj.ysms.dao.GamesDao;
import com.cwkj.ysms.dao.GamesJudgeDao;
import com.cwkj.ysms.dao.GoalDao;
import com.cwkj.ysms.dao.JudgeDao;
import com.cwkj.ysms.dao.LeagueZoneDao;
import com.cwkj.ysms.dao.TeamDao;
import com.cwkj.ysms.dao.TeammemberDao;
import com.cwkj.ysms.dao.ZoneTeamDao;
import com.cwkj.ysms.model.YsmsAthlete;
import com.cwkj.ysms.model.YsmsFoul;
import com.cwkj.ysms.model.YsmsGames;
import com.cwkj.ysms.model.YsmsGamesJudge;
import com.cwkj.ysms.model.YsmsGoal;
import com.cwkj.ysms.model.YsmsJudge;
import com.cwkj.ysms.model.YsmsTeammember;
import com.cwkj.ysms.model.YsmsZoneTeam;
import com.cwkj.ysms.model.view.FoulView;
import com.cwkj.ysms.model.view.GameView;
import com.cwkj.ysms.model.view.GoalView;
import com.cwkj.ysms.service.GamesManagementService;
import com.cwkj.ysms.util.Page;

@Component
public class GamesManagementServiceImpl implements GamesManagementService{
	
	@Resource
	private GamesDao gamesDao;
	@Resource
	private GoalDao goalDao;
	@Resource
	private FoulDao foulDao;
	@Resource
	private AthleteDao athleteDao;
	public ZoneTeamDao getZoneTeamDao() {
		return zoneTeamDao;
	}

	public void setZoneTeamDao(ZoneTeamDao zoneTeamDao) {
		this.zoneTeamDao = zoneTeamDao;
	}

	@Resource
	private JudgeDao judgeDao;
	@Resource 
	private GamesJudgeDao gamesJudgeDao;
	@Resource
	private LeagueZoneDao leagueZoneDao;
	@Resource
	private TeamDao teamDao;
	@Resource
	private ZoneTeamDao zoneTeamDao;
	public TeamDao getTeamDao() {
		return teamDao;
	}

	public void setTeamDao(TeamDao teamDao) {
		this.teamDao = teamDao;
	}

	public LeagueZoneDao getLeagueZoneDao() {
		return leagueZoneDao;
	}

	public void setLeagueZoneDao(LeagueZoneDao leagueZoneDao) {
		this.leagueZoneDao = leagueZoneDao;
	}

	public GamesJudgeDao getGamesJudgeDao() {
		return gamesJudgeDao;
	}

	public void setGamesJudgeDao(GamesJudgeDao gamesJudgeDao) {
		this.gamesJudgeDao = gamesJudgeDao;
	}

	public JudgeDao getJudgeDao() {
		return judgeDao;
	}

	public void setJudgeDao(JudgeDao judgeDao) {
		this.judgeDao = judgeDao;
	}
	
	@Resource
	private TeammemberDao teammemberDao;
	public TeammemberDao getTeammemberDao() {
		return teammemberDao;
	}

	public void setTeammemberDao(TeammemberDao teammemberDao) {
		this.teammemberDao = teammemberDao;
	}

	public AthleteDao getAthleteDao() {
		return athleteDao;
	}

	public void setAthleteDao(AthleteDao athleteDao) {
		this.athleteDao = athleteDao;
	}

	public FoulDao getFoulDao() {
		return foulDao;
	}

	public void setFoulDao(FoulDao foulDao) {
		this.foulDao = foulDao;
	}

	public GoalDao getGoalDao() {
		return goalDao;
	}

	public void setGoalDao(GoalDao goalDao) {
		this.goalDao = goalDao;
	}

	public GamesDao getGamesDao() {
		return gamesDao;
	}

	public void setGamesDao(GamesDao gamesDao) {
		this.gamesDao = gamesDao;
	}

	@Override
	public boolean updateGamesInfo(int gamesId, Date gamesTime,
			String gamesLocation, int chiefUmpireId, int sideRefereeId_1,
			int sideRefereeId_2, int fourth_Officer, int officer_1, int officer_2, int recorder_1, int recorder_2) {
		YsmsGames ysmsGames = gamesDao.findById(gamesId);
		ysmsGames.setGamesTime(gamesTime);
		ysmsGames.setGameLocation(gamesLocation);
		gamesDao.save(ysmsGames);
		YsmsJudge chiefJudge = judgeDao.findById(chiefUmpireId);
		YsmsJudge sideReferee1 = judgeDao.findById(sideRefereeId_1);
		YsmsJudge sideReferee2 = judgeDao.findById(sideRefereeId_2);
		YsmsJudge fourthOfficer = judgeDao.findById(fourth_Officer);
		YsmsJudge officer1 = judgeDao.findById(officer_1);
		YsmsJudge officer2 = judgeDao.findById(officer_2);
		YsmsJudge recorder1 = judgeDao.findById(recorder_1);
		YsmsJudge recorder2 = judgeDao.findById(recorder_2);
		YsmsGamesJudge chiefGamesJudge = new YsmsGamesJudge();
		chiefGamesJudge.setJudgePosition(1);
		chiefGamesJudge.setYsmsGames(ysmsGames);
		chiefGamesJudge.setYsmsJudge(chiefJudge);
		gamesJudgeDao.save(chiefGamesJudge);
		YsmsGamesJudge sideGamesJudge1 = new YsmsGamesJudge();
		sideGamesJudge1.setJudgePosition(2);
		sideGamesJudge1.setYsmsGames(ysmsGames);
		sideGamesJudge1.setYsmsJudge(sideReferee1);
		gamesJudgeDao.save(sideGamesJudge1);
		YsmsGamesJudge sideGamesJudge2 = new YsmsGamesJudge();
		sideGamesJudge2.setJudgePosition(2);
		sideGamesJudge2.setYsmsGames(ysmsGames);
		sideGamesJudge2.setYsmsJudge(sideReferee2);
		gamesJudgeDao.save(sideGamesJudge2);
		YsmsGamesJudge theFourthOfficer = new YsmsGamesJudge();
		theFourthOfficer.setJudgePosition(3);
		theFourthOfficer.setYsmsGames(ysmsGames);
		theFourthOfficer.setYsmsJudge(fourthOfficer);
		gamesJudgeDao.save(theFourthOfficer);
		YsmsGamesJudge theOfficer1 = new YsmsGamesJudge();
		theOfficer1.setJudgePosition(4);
		theOfficer1.setYsmsGames(ysmsGames);
		theOfficer1.setYsmsJudge(officer1);
		gamesJudgeDao.save(theOfficer1);
		YsmsGamesJudge theOfficer2 = new YsmsGamesJudge();
		theOfficer2.setJudgePosition(5);
		theOfficer2.setYsmsGames(ysmsGames);
		theOfficer2.setYsmsJudge(officer2);
		gamesJudgeDao.save(theOfficer2);
		YsmsGamesJudge theRecorder1 = new YsmsGamesJudge();
		theRecorder1.setJudgePosition(6);
		theRecorder1.setYsmsGames(ysmsGames);
		theRecorder1.setYsmsJudge(recorder1);
		gamesJudgeDao.save(theRecorder1);
		YsmsGamesJudge theRecorder2 = new YsmsGamesJudge();
		theRecorder2.setJudgePosition(7);
		theRecorder2.setYsmsGames(ysmsGames);
		theRecorder2.setYsmsJudge(recorder2);
		gamesJudgeDao.save(theRecorder2);
		
		return true; 
	}

	@Override
	public GameView getGamesInfo(int gamesId) {
		GameView gameView = new GameView();
		YsmsGames ysmsGames = gamesDao.findById(gamesId);
		gameView.setHostSchoolName(ysmsGames.getYsmsTeamByHostTeamid().getYsmsSchool().getSchoolName());
		gameView.setGuestSchoolName(ysmsGames.getYsmsTeamByGuestTeamid().getYsmsSchool().getSchoolName());
		gameView.setHostTeamName(ysmsGames.getYsmsTeamByHostTeamid().getTeamName());
		gameView.setGuestTeamName(ysmsGames.getYsmsTeamByGuestTeamid().getTeamName());
		gameView.setHostScore(ysmsGames.getHostScore());
		gameView.setGuestScore(ysmsGames.getGuestScore());
		gameView.setHostTeamId(ysmsGames.getYsmsTeamByHostTeamid().getTeamId());
		gameView.setGuestTeamId(ysmsGames.getYsmsTeamByGuestTeamid().getTeamId());
		gameView.setIsOvertimeFlag(ysmsGames.getIsOvertimeFlag());
		gameView.setIsPenaltyFlag(ysmsGames.getIsPenaltyFlag());
		gameView.setIsGameOver(ysmsGames.getIsGameOver());
		
		gameView.setHostGoalAttempt(ysmsGames.getHostGoalAttempt());
		gameView.setHostTargetNumber(ysmsGames.getHostTargetNumber());
		gameView.setHostCornerKick(ysmsGames.getHostCornerKick());
		gameView.setHostFreeKick(ysmsGames.getHostFreeKick());
		gameView.setHostFoul(ysmsGames.getHostFoul());
		gameView.setHostOffside(ysmsGames.getHostOffside());
		gameView.setHostOvertimeScore(ysmsGames.getHostOvertimeScore());
		gameView.setHostPenaltyScore(ysmsGames.getHostPenaltyScore());
		
		gameView.setGuestGoalAttempt(ysmsGames.getGuestGoalAttempt());
		gameView.setGuestTargetNumber(ysmsGames.getGuestTargetNumber());
		gameView.setGuestCornerKick(ysmsGames.getGuestCornerKick());
		gameView.setGuestFreeKick(ysmsGames.getGuestFreeKick());
		gameView.setGuestFoul(ysmsGames.getGuestFoul());
		gameView.setGuestOffside(ysmsGames.getGuestOffside());
		gameView.setGuestOvertimeScore(ysmsGames.getGuestOvertimeScore());
		gameView.setGuestPenaltyScore(ysmsGames.getGuestPenaltyScore());
		
		return gameView;
	}

	@Override
	public boolean replyGamesInfo(int gamesId, int hostTeamGoals, int guestTeamGoals, 
			int isOvertimeFlag, int isPenaltyFlag, 
			String hostGoalAttempt, String hostTargetNumber, String hostCornerKick,
			String hostFreeKick, String hostFoul, String hostOffside, 
			String hostOvertimeScore, String hostPenaltyScore,
			String guestGoalAttempt, String guestTargetNumber, String guestCornerKick,
			String guestFreeKick, String guestFoul, String guestOffside, 
			String guestOvertimeScore, String guestPenaltyScore){
		YsmsGames ysmsGames = gamesDao.findById(gamesId);
		ysmsGames.setHostScore(hostTeamGoals);
		ysmsGames.setGuestScore(guestTeamGoals);
		ysmsGames.setIsOvertimeFlag(isOvertimeFlag);
		ysmsGames.setIsPenaltyFlag(isPenaltyFlag);
		if(hostGoalAttempt!=null&&!"".equals(hostGoalAttempt))
			ysmsGames.setHostGoalAttempt(Integer.parseInt(hostGoalAttempt));
		else
			ysmsGames.setHostGoalAttempt(null);
		if(hostTargetNumber!=null&&!"".equals(hostTargetNumber))
			ysmsGames.setHostTargetNumber(Integer.parseInt(hostTargetNumber));
		else
			ysmsGames.setHostTargetNumber(null);
		if(hostCornerKick!=null&&!"".equals(hostCornerKick))
			ysmsGames.setHostCornerKick(Integer.parseInt(hostCornerKick));
		else
			ysmsGames.setHostCornerKick(null);
		if(hostFreeKick!=null&&!"".equals(hostFreeKick))
			ysmsGames.setHostFreeKick(Integer.parseInt(hostFreeKick));
		else
			ysmsGames.setHostFreeKick(null);
		if(hostFoul!=null&&!"".equals(hostFoul))
			ysmsGames.setHostFoul(Integer.parseInt(hostFoul));
		else
			ysmsGames.setHostFoul(null);
		if(hostOffside!=null&&!"".equals(hostOffside))
			ysmsGames.setHostOffside(Integer.parseInt(hostOffside));
		else
			ysmsGames.setHostOffside(null);
		if(hostPenaltyScore!=null&&!"".equals(hostPenaltyScore))
			ysmsGames.setHostPenaltyScore(Integer.parseInt(hostPenaltyScore));
		else
			ysmsGames.setHostPenaltyScore(null);
		if(hostOvertimeScore!=null&&!"".equals(hostOvertimeScore))
			ysmsGames.setHostOvertimeScore(Integer.parseInt(hostOvertimeScore));
		else
			ysmsGames.setHostOvertimeScore(null);
		if(hostPenaltyScore!=null&&!"".equals(hostPenaltyScore))
			ysmsGames.setHostPenaltyScore(Integer.parseInt(hostPenaltyScore));
		else
			ysmsGames.setHostPenaltyScore(null);
		if(guestGoalAttempt!=null&&!"".equals(guestGoalAttempt))
			ysmsGames.setGuestGoalAttempt(Integer.parseInt(guestGoalAttempt));
		else
			ysmsGames.setGuestGoalAttempt(null);
		if(guestTargetNumber!=null&&!"".equals(guestTargetNumber))
			ysmsGames.setGuestTargetNumber(Integer.parseInt(guestTargetNumber));
		else
			ysmsGames.setGuestTargetNumber(null);
		if(guestCornerKick!=null&&!"".equals(guestCornerKick))
			ysmsGames.setGuestCornerKick(Integer.parseInt(guestCornerKick));
		else
			ysmsGames.setGuestCornerKick(null);
		if(guestFreeKick!=null&&!"".equals(guestFreeKick))
			ysmsGames.setGuestFreeKick(Integer.parseInt(guestFreeKick));
		else
			ysmsGames.setGuestFreeKick(null);
		if(guestFoul!=null&&!"".equals(guestFoul))
			ysmsGames.setGuestFoul(Integer.parseInt(guestFoul));
		else
			ysmsGames.setGuestFoul(null);
		if(guestOffside!=null&&!"".equals(guestOffside))
			ysmsGames.setGuestOffside(Integer.parseInt(guestOffside));
		else
			ysmsGames.setGuestOffside(null);
		if(guestPenaltyScore!=null&&!"".equals(guestPenaltyScore))
			ysmsGames.setGuestPenaltyScore(Integer.parseInt(guestPenaltyScore));
		else
			ysmsGames.setGuestPenaltyScore(null);
		if(guestOvertimeScore!=null&&!"".equals(guestOvertimeScore))
			ysmsGames.setGuestOvertimeScore(Integer.parseInt(guestOvertimeScore));
		else
			ysmsGames.setGuestOvertimeScore(null);
		if(guestPenaltyScore!=null&&!"".equals(guestPenaltyScore))
			ysmsGames.setGuestPenaltyScore(Integer.parseInt(guestPenaltyScore));
		else
			ysmsGames.setGuestPenaltyScore(null);
		gamesDao.save(ysmsGames);
		return true;
	}

	@Override
	public boolean addGoalInfo(int gamesId, int shooterId, int assistantId,
			String goalTimeStr, int goalType) {
		YsmsGoal ysmsGoal = new YsmsGoal();
		ysmsGoal.setYsmsGames(gamesDao.findById(gamesId));
		ysmsGoal.setAssistant(assistantId);
		ysmsGoal.setShooter(shooterId);
		ysmsGoal.setTime(goalTimeStr);
		ysmsGoal.setStyle(goalType);
		goalDao.save(ysmsGoal);
		return true;
	}

	@Override
	public boolean modifyGoalInfo(int goalId, int shooterId,
			int assistantId, String goalTimeStr, int goalType) {
		// TODO Auto-generated method stub
		YsmsGoal ysmsGoal = goalDao.findById(goalId);
		ysmsGoal.setAssistant(assistantId);
		ysmsGoal.setShooter(shooterId);
		ysmsGoal.setTime(goalTimeStr);
		ysmsGoal.setStyle(goalType);
		goalDao.save(ysmsGoal);
		return true;
	}

	@Override
	public boolean deleteGoalInfo(int goalId) {
		YsmsGoal ysmsGoal = goalDao.findById(goalId);
		goalDao.delete(ysmsGoal);
		return true;
	}

	@Override
	public boolean addFoulInfo(int gamesId, int foulPlayerId, int foulLevel,
			String foulTimeStr) {
		// TODO Auto-generated method stub
		YsmsFoul ysmsFoul = new YsmsFoul();
		YsmsGames ysmsGames = gamesDao.findById(gamesId);
		ysmsFoul.setYsmsGames(ysmsGames);
		YsmsAthlete ysmsAthlete = athleteDao.findById(foulPlayerId);
		ysmsFoul.setYsmsAthlete(ysmsAthlete);
		ysmsFoul.setFoulLevel(foulLevel);
		ysmsFoul.setTime(foulTimeStr);
		foulDao.save(ysmsFoul);
		return true;
	}

	@Override
	public boolean modifyFoulInfo(int foulId, int gamesId, int foulPlayerId,
			int foulLevel, String foulTimeStr) {
		YsmsFoul ysmsFoul = foulDao.findById(foulId);
		YsmsGames ysmsGames = gamesDao.findById(gamesId);
		ysmsFoul.setYsmsGames(ysmsGames);
		YsmsAthlete ysmsAthlete = athleteDao.findById(foulPlayerId);
		ysmsFoul.setYsmsAthlete(ysmsAthlete);
		ysmsFoul.setFoulLevel(foulLevel);
		ysmsFoul.setTime(foulTimeStr);
		foulDao.save(ysmsFoul);
		return true;
	}

	@Override
	public boolean deleteFoulInfo(int foulId) {
		YsmsFoul ysmsFoul = foulDao.findById(foulId);
		foulDao.delete(ysmsFoul);
		return true;
	}

	@Override
	public List<YsmsGames> getGamesByTeam(int teamId) {
		return gamesDao.getGamesByTeamId(teamId);
	}

	@Override
	public List<YsmsGames> getGamesThisMonthByTeam(int teamId) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 1);
		Date firstDay = cal.getTime();
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		Date lastDay = cal.getTime();
		return gamesDao.getGamesByTeamIdBetweenDate(teamId, firstDay, lastDay);
		
	}

	@Override
	public GameView getNextGameByTeam(int teamId) {
		YsmsGames ysmsGames = gamesDao.getNextGameByTeamId(teamId);
		GameView gameView = new GameView();
		gameView.setGameLocation(ysmsGames.getGameLocation());
		gameView.setGamesId(ysmsGames.getGamesId());
		gameView.setHostSchoolName(ysmsGames.getYsmsTeamByHostTeamid().getYsmsSchool().getSchoolName());
		gameView.setGuestSchoolName(ysmsGames.getYsmsTeamByGuestTeamid().getYsmsSchool().getSchoolName());
		gameView.setHostTeamName(ysmsGames.getYsmsTeamByHostTeamid().getTeamName());
		gameView.setGuestTeamName(ysmsGames.getYsmsTeamByGuestTeamid().getTeamName());
		gameView.setHostScore(ysmsGames.getHostScore());
		gameView.setGuestScore(ysmsGames.getGuestScore());
		gameView.setHostTeamId(ysmsGames.getYsmsTeamByHostTeamid().getTeamId());
		gameView.setGuestTeamId(ysmsGames.getYsmsTeamByGuestTeamid().getTeamId());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
		gameView.setGameTime(sdf.format(ysmsGames.getGamesTime()));
		return gameView;
	}

	@Override
	public GameView getLastGameByTeam(int teamId) {
		YsmsGames ysmsGames = gamesDao.getLastGameByTeamId(teamId);
		GameView gameView = new GameView();
		if(ysmsGames==null){
			return null;
		}
		gameView.setGameLocation(ysmsGames.getGameLocation());
		gameView.setGamesId(ysmsGames.getGamesId());
		gameView.setHostSchoolName(ysmsGames.getYsmsTeamByHostTeamid().getYsmsSchool().getSchoolName());
		gameView.setGuestSchoolName(ysmsGames.getYsmsTeamByGuestTeamid().getYsmsSchool().getSchoolName());
		gameView.setHostTeamName(ysmsGames.getYsmsTeamByHostTeamid().getTeamName());
		gameView.setGuestTeamName(ysmsGames.getYsmsTeamByGuestTeamid().getTeamName());
		gameView.setHostScore(ysmsGames.getHostScore());
		gameView.setGuestScore(ysmsGames.getGuestScore());
		gameView.setHostTeamId(ysmsGames.getYsmsTeamByHostTeamid().getTeamId());
		gameView.setGuestTeamId(ysmsGames.getYsmsTeamByGuestTeamid().getTeamId());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
		gameView.setGameTime(sdf.format(ysmsGames.getGamesTime()));
		return gameView;
	}

	@Override
	public List<YsmsGames> getGamesByDate(Date date) {
		return gamesDao.getGamesByDate(date);
	}

	@Override
	public List<YsmsGames> getGamesByZone(int zoneId) {
		return gamesDao.getGamesByZoneId(zoneId);
	}

	@Override
	public List<YsmsGames> getGamesByZoneAndDate(int zoneId, Date date) {
		return gamesDao.getGamesByZoneIdAndDate(zoneId, date);
	}

	@Override
	public List<GoalView> getTeamGoalsInGame(int gameId, int teamId) {
		List<GoalView> viewList = new ArrayList<GoalView>();
		//取出所有进球
		List<YsmsGoal> goalsList = goalDao.findByGame(gameId);
		if(goalsList!=null){
			for(int i=0;i<goalsList.size();i++){
				boolean ifThisTeamGoal = false;
				//取出进球球员Id
				int shooterId = goalsList.get(i).getShooter();
				//查询球队成员关系中包含该球员的关系
				List<YsmsTeammember> memberList = teammemberDao.findTeamsByAthleteId(shooterId);
				//查看是否有该球队包含于这个球队列表中
				for(int j=0;j<memberList.size();j++){
					if(memberList.get(j).getYsmsTeam().getTeamId()==teamId){
						//证明存在这样的球队
						ifThisTeamGoal = true;
					}
				}
				if(ifThisTeamGoal){
					YsmsGoal ysmsGoal = goalsList.get(i);
					GoalView goalView = new GoalView();
					YsmsAthlete shooter = athleteDao.findById(ysmsGoal.getShooter());
					YsmsAthlete assistant = athleteDao.findById(ysmsGoal.getAssistant());
					if(assistant!=null){
						goalView.setAssistantName(assistant.getIdentifiedName());
						List<YsmsTeammember> tempAssistantList = teammemberDao.findByAthleteIdAndTeamId(assistant.getAthleteId(), teamId);
						if(tempAssistantList.size()>0){
							goalView.setAssistantNumber(tempAssistantList.get(0).getAthleteNum());
							goalView.setAssistantId(tempAssistantList.get(0).getYsmsAthlete().getAthleteId());
						}
					}
					goalView.setShooterName(shooter.getIdentifiedName());
					List<YsmsTeammember> tempShooterList = teammemberDao.findByAthleteIdAndTeamId(shooter.getAthleteId(), teamId);
					if(tempShooterList.size()>0){
						goalView.setShooterId(shooter.getAthleteId());
						goalView.setShooterNumber(tempShooterList.get(0).getAthleteNum());
						goalView.setStyle(ysmsGoal.getStyle());
						goalView.setGoalId(ysmsGoal.getGoalId());
						goalView.setTime(ysmsGoal.getTime());
						viewList.add(goalView);
					}
				}
			}
		}
		return viewList;
	}

	@Override
	public List<FoulView> getTeamFoulInGame(int gameId, int teamId) {
		// TODO Auto-generated method stub
		List<FoulView> viewList = new ArrayList<FoulView>();
		//取出所有进球
		List<YsmsFoul> foulsList = foulDao.getYsmsFoulsByGamesId(gameId);
		if(foulsList!=null){
			for(int i=0;i<foulsList.size();i++){
				boolean ifThisTeamFoul = false;
				//取出进球球员Id
				int playerId = foulsList.get(i).getYsmsAthlete().getAthleteId();
				//查询球队成员关系中包含该球员的关系
				List<YsmsTeammember> memberList = teammemberDao.findTeamsByAthleteId(playerId);
				//查看是否有该球队包含于这个球队列表中
				for(int j=0;j<memberList.size();j++){
					if(memberList.get(j).getYsmsTeam().getTeamId()==teamId){
						//证明存在这样的球队
						ifThisTeamFoul = true;
					}
				}
				if(ifThisTeamFoul){
					YsmsFoul ysmsFoul = foulsList.get(i);
					FoulView foulView = new FoulView();
					YsmsAthlete fouler = ysmsFoul.getYsmsAthlete();
					foulView.setAthleteName(fouler.getIdentifiedName());
					List<YsmsTeammember> tempFoulerList = teammemberDao
							.findByAthleteIdAndTeamId(fouler.getAthleteId(), teamId);
					if(tempFoulerList.size()>0){
						foulView.setAthleteId(tempFoulerList.get(0).getYsmsAthlete().getAthleteId());
						foulView.setAthleteNumber(tempFoulerList.get(0).getAthleteNum());
						foulView.setFoulId(ysmsFoul.getFoulId());
						foulView.setFoulLevel(ysmsFoul.getFoulLevel());
						foulView.setTime(ysmsFoul.getTime());
						viewList.add(foulView);
					}
				}
			}
		}
		return viewList;
	}

	@Override
	public boolean addGamesInfo(int zoneId, int gamesOrder, int hostTeamId,
			String hostUniform, int guestTeamId,
			String guestUniform, Date gamesTime, String gamesLocation,
			int chiefUmpireId, int sideRefereeId_1, int sideRefereeId_2,
			int forth_Officer, int officer_1, int officer_2, int recorder_1,
			int recorder_2) {
		YsmsGames ysmsGames = new YsmsGames();
		ysmsGames.setGamesOrder(gamesOrder);
		ysmsGames.setYsmsTeamByHostTeamid(teamDao.findById(hostTeamId));
		ysmsGames.setHostUniform(hostUniform);
		ysmsGames.setYsmsTeamByGuestTeamid(teamDao.findById(guestTeamId));
		ysmsGames.setGuestUniform(guestUniform);
		ysmsGames.setGamesTime(gamesTime);
		ysmsGames.setGameLocation(gamesLocation);
		ysmsGames.setYsmsLeagueZone(leagueZoneDao.findById(zoneId));
		ysmsGames.setIsOvertimeFlag(0);
		ysmsGames.setIsPenaltyFlag(0);
		ysmsGames.setIsGameOver(0);
		gamesDao.save(ysmsGames);
		YsmsJudge chiefJudge = judgeDao.findById(chiefUmpireId);
		YsmsJudge sideReferee1 = judgeDao.findById(sideRefereeId_1);
		YsmsJudge sideReferee2 = judgeDao.findById(sideRefereeId_2);
		YsmsJudge fourthOfficer = judgeDao.findById(forth_Officer);
		YsmsJudge officer1 = judgeDao.findById(officer_1);
		YsmsJudge officer2 = judgeDao.findById(officer_2);
		YsmsJudge recorder1 = judgeDao.findById(recorder_1);
		YsmsJudge recorder2 = judgeDao.findById(recorder_2);
		YsmsGamesJudge chiefGamesJudge = new YsmsGamesJudge();
		chiefGamesJudge.setJudgePosition(1);
		chiefGamesJudge.setYsmsGames(ysmsGames);
		chiefGamesJudge.setYsmsJudge(chiefJudge);
		gamesJudgeDao.save(chiefGamesJudge);
		YsmsGamesJudge sideGamesJudge1 = new YsmsGamesJudge();
		sideGamesJudge1.setJudgePosition(2);
		sideGamesJudge1.setYsmsGames(ysmsGames);
		sideGamesJudge1.setYsmsJudge(sideReferee1);
		gamesJudgeDao.save(sideGamesJudge1);
		YsmsGamesJudge sideGamesJudge2 = new YsmsGamesJudge();
		sideGamesJudge2.setJudgePosition(2);
		sideGamesJudge2.setYsmsGames(ysmsGames);
		sideGamesJudge2.setYsmsJudge(sideReferee2);
		gamesJudgeDao.save(sideGamesJudge2);
		YsmsGamesJudge theFourthOfficer = new YsmsGamesJudge();
		theFourthOfficer.setJudgePosition(3);
		theFourthOfficer.setYsmsGames(ysmsGames);
		theFourthOfficer.setYsmsJudge(fourthOfficer);
		gamesJudgeDao.save(theFourthOfficer);
		YsmsGamesJudge theOfficer1 = new YsmsGamesJudge();
		theOfficer1.setJudgePosition(4);
		theOfficer1.setYsmsGames(ysmsGames);
		theOfficer1.setYsmsJudge(officer1);
		gamesJudgeDao.save(theOfficer1);
		YsmsGamesJudge theOfficer2 = new YsmsGamesJudge();
		theOfficer2.setJudgePosition(4);
		theOfficer2.setYsmsGames(ysmsGames);
		theOfficer2.setYsmsJudge(officer2);
		gamesJudgeDao.save(theOfficer2);
		YsmsGamesJudge theRecorder1 = new YsmsGamesJudge();
		theRecorder1.setJudgePosition(5);
		theRecorder1.setYsmsGames(ysmsGames);
		theRecorder1.setYsmsJudge(recorder1);
		gamesJudgeDao.save(theRecorder1);
		YsmsGamesJudge theRecorder2 = new YsmsGamesJudge();
		theRecorder2.setJudgePosition(5);
		theRecorder2.setYsmsGames(ysmsGames);
		theRecorder2.setYsmsJudge(recorder2);
		gamesJudgeDao.save(theRecorder2);
		
		return true; 
	}

	@Override
	public boolean addGamesInfo(int zoneId, int gamesOrder, int hostTeamId,
			String hostUniform, int guestTeamId,
			String guestUniform, Date gamesTime, String gamesLocation) {
		YsmsGames ysmsGames = new YsmsGames();
		ysmsGames.setGamesOrder(gamesOrder);
		ysmsGames.setYsmsTeamByHostTeamid(teamDao.findById(hostTeamId));
		ysmsGames.setHostUniform(hostUniform);
		ysmsGames.setYsmsTeamByGuestTeamid(teamDao.findById(guestTeamId));
		ysmsGames.setGuestUniform(guestUniform);
		ysmsGames.setGamesTime(gamesTime);
		ysmsGames.setGameLocation(gamesLocation);
		ysmsGames.setYsmsLeagueZone(leagueZoneDao.findById(zoneId));
		ysmsGames.setIsOvertimeFlag(0);
		ysmsGames.setIsPenaltyFlag(0);
		ysmsGames.setIsGameOver(0);
		gamesDao.save(ysmsGames);
		return true;
	}

	@Override
	public List<GameView> getGamesByPage(Integer leagueId, Integer zoneId, Date date, String pageIndex) {
		List<GameView> viewList = new ArrayList<GameView>();
		int startIndex = (Integer.parseInt(pageIndex) - 1) * 8;
		Page page = new Page();
		page.setEveryPage(8);
		page.setBeginIndex(startIndex);
		List<YsmsGames> gameList = gamesDao.findByFuzzyQueryAndPage(leagueId, zoneId, date, page);
		for(int i=0;i<gameList.size();i++){
			YsmsGames ysmsGames = gameList.get(i);
			GameView gameView = new GameView();
			gameView.setGamesId(ysmsGames.getGamesId());
			Date ysmsdate = ysmsGames.getGamesTime();
			if(ysmsdate!=null){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				gameView.setGameTime(sdf.format(ysmsdate));
			}
			gameView.setGuestSchoolName(ysmsGames.getYsmsTeamByGuestTeamid().getYsmsSchool().getSchoolName());
			gameView.setHostSchoolName(ysmsGames.getYsmsTeamByHostTeamid().getYsmsSchool().getSchoolName());
			gameView.setLeagueName(ysmsGames.getYsmsLeagueZone().getYsmsLeague().getLeagueName());
			gameView.setOrderName(ysmsGames.getGamesOrder()==1?"小组赛":"淘汰赛");
			gameView.setZoneName(ysmsGames.getYsmsLeagueZone().getZoneName());
			viewList.add(gameView);
		}
		return viewList;
	}

	@Override
	public int getGamesCount(Integer leagueId, Integer zoneId, Date date) {
		return gamesDao.getGamesCount(leagueId, zoneId, date);
	}

	@Override
	public boolean deleteGame(int gamesId) {
		YsmsGames ysmsGames = gamesDao.findById(gamesId);
		gamesDao.delete(ysmsGames);
		return true;
	}

	@Override
	public GameView getGameById(int gamesId) {
		YsmsGames ysmsGames = gamesDao.findById(gamesId);
		GameView gameView = new GameView();
		Date date = ysmsGames.getGamesTime();
		if(date!=null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			gameView.setGameTime(sdf.format(date));
		}
		gameView.setGameLocation(ysmsGames.getGameLocation());
		gameView.setGamesId(ysmsGames.getGamesId());
		gameView.setHostSchoolName(ysmsGames.getYsmsTeamByHostTeamid().getYsmsSchool().getSchoolName());
		gameView.setGuestSchoolName(ysmsGames.getYsmsTeamByGuestTeamid().getYsmsSchool().getSchoolName());
		gameView.setHostTeamName(ysmsGames.getYsmsTeamByHostTeamid().getTeamName());
		gameView.setGuestTeamName(ysmsGames.getYsmsTeamByGuestTeamid().getTeamName());
		gameView.setHostUniform(ysmsGames.getHostUniform());
		gameView.setGuestUniform(ysmsGames.getGuestUniform());
		gameView.setHostScore(ysmsGames.getHostScore());
		gameView.setGuestScore(ysmsGames.getGuestScore());
		gameView.setHostTeamId(ysmsGames.getYsmsTeamByHostTeamid().getTeamId());
		gameView.setGuestTeamId(ysmsGames.getYsmsTeamByGuestTeamid().getTeamId());
		gameView.setLeagueName(ysmsGames.getYsmsLeagueZone().getYsmsLeague().getLeagueName());
		gameView.setZoneName(ysmsGames.getYsmsLeagueZone().getZoneName());
		gameView.setOrderName(ysmsGames.getGamesOrder()==1?"小组赛":"淘汰赛");
		int gameOrder = ysmsGames.getGamesOrder();
		if(gameOrder == 1){
			YsmsZoneTeam ysmsZoneTeam = zoneTeamDao.findByTeamId(ysmsGames.getYsmsTeamByHostTeamid().getTeamId());
			gameView.setOrderName(ysmsZoneTeam.getZoneGroup() + "组");
		}
		else
			gameView.setOrderName("淘汰赛");
		gameView.setZoneName(ysmsGames.getYsmsLeagueZone().getZoneName());
		return gameView;
	}

	@Override
	public boolean modifyGame(int gamesId, String hostUniform, String guestUniform,
			Date gamesTime, String gamesLocation) {
		YsmsGames ysmsGames = gamesDao.findById(gamesId);
		ysmsGames.setHostUniform(hostUniform);
		ysmsGames.setGuestUniform(guestUniform);
		ysmsGames.setGamesTime(gamesTime);
		ysmsGames.setGameLocation(gamesLocation);
		gamesDao.save(ysmsGames);
		return true;
	}

	@Override
	public boolean deleteAllGoalsInGame(int gamesId) {
		List<YsmsGoal> goalList = goalDao.findByGame(gamesId);
		for(int i=0;i<goalList.size();i++){
			goalDao.delete(goalList.get(i));
		}
		return true;
	}

	@Override
	public boolean deleteAllFoulsInGame(int gamesId) {
		List<YsmsFoul> foulList = foulDao.findByGame(gamesId);
		for(int i=0;i<foulList.size();i++){
			foulDao.delete(foulList.get(i));
		}
		return true;
	}

	@Override
	public GameView getNextGameByAthlete(int athleteId) {
		YsmsGames ysmsGames = gamesDao.getNextGameByAthleteId(athleteId);
		if(ysmsGames == null)
			return null;
		GameView gameView = new GameView();
		gameView.setGameLocation(ysmsGames.getGameLocation());
		gameView.setGamesId(ysmsGames.getGamesId());
		gameView.setHostSchoolName(ysmsGames.getYsmsTeamByHostTeamid().getYsmsSchool().getSchoolName());
		gameView.setGuestSchoolName(ysmsGames.getYsmsTeamByGuestTeamid().getYsmsSchool().getSchoolName());
		gameView.setHostTeamName(ysmsGames.getYsmsTeamByHostTeamid().getTeamName());
		gameView.setGuestTeamName(ysmsGames.getYsmsTeamByGuestTeamid().getTeamName());
		gameView.setHostScore(ysmsGames.getHostScore());
		gameView.setGuestScore(ysmsGames.getGuestScore());
		gameView.setHostTeamId(ysmsGames.getYsmsTeamByHostTeamid().getTeamId());
		gameView.setGuestTeamId(ysmsGames.getYsmsTeamByGuestTeamid().getTeamId());
		gameView.setLeagueName(ysmsGames.getYsmsLeagueZone().getYsmsLeague().getLeagueName());
		gameView.setZoneName(ysmsGames.getYsmsLeagueZone().getZoneName());
		gameView.setOrderName(ysmsGames.getGamesOrder()==1?"小组赛":"淘汰赛");
		Date date = ysmsGames.getGamesTime();
		if(date!=null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			gameView.setGameTime(sdf.format(date));
		}
		return gameView;
	}

	@Override
	public GameView getLastGameByAthlete(int athleteId) {
		YsmsGames ysmsGames = gamesDao.getLastGameByAthleteId(athleteId);
		if(ysmsGames == null)
			return null;
		GameView gameView = new GameView();
		gameView.setGameLocation(ysmsGames.getGameLocation());
		gameView.setGamesId(ysmsGames.getGamesId());
		gameView.setHostSchoolName(ysmsGames.getYsmsTeamByHostTeamid().getYsmsSchool().getSchoolName());
		gameView.setGuestSchoolName(ysmsGames.getYsmsTeamByGuestTeamid().getYsmsSchool().getSchoolName());
		gameView.setHostTeamName(ysmsGames.getYsmsTeamByHostTeamid().getTeamName());
		gameView.setGuestTeamName(ysmsGames.getYsmsTeamByGuestTeamid().getTeamName());
		gameView.setHostScore(ysmsGames.getHostScore());
		gameView.setGuestScore(ysmsGames.getGuestScore());
		gameView.setHostTeamId(ysmsGames.getYsmsTeamByHostTeamid().getTeamId());
		gameView.setGuestTeamId(ysmsGames.getYsmsTeamByGuestTeamid().getTeamId());
		gameView.setLeagueName(ysmsGames.getYsmsLeagueZone().getYsmsLeague().getLeagueName());
		gameView.setZoneName(ysmsGames.getYsmsLeagueZone().getZoneName());
		gameView.setOrderName(ysmsGames.getGamesOrder()==1?"小组赛":"淘汰赛");
		Date date = ysmsGames.getGamesTime();
		if(date!=null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			gameView.setGameTime(sdf.format(date));
		}
		return gameView;
	}

	@Override
	public List<GameView> getAllGamesByMonth(Date date) {
		List<GameView> viewList = new ArrayList<GameView>();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		Date firstDay = cal.getTime();
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		Date lastDay = cal.getTime();
		List<YsmsGames> gameList = gamesDao.getGamesBetweenDate(firstDay, lastDay);
		for(int i=0;i<gameList.size();i++){
			YsmsGames game = gameList.get(i);
			GameView gv = new GameView();
			gv.setGamesId(game.getGamesId());
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
			gv.setGameTime(sdf.format(game.getGamesTime()));
			gv.setGameLocation(game.getGameLocation());
			gv.setIsOvertimeFlag(game.getIsOvertimeFlag());
			gv.setIsPenaltyFlag(game.getIsPenaltyFlag());
			gv.setIsGameOver(game.getIsGameOver());
			gv.setHostScore(game.getHostScore());
			gv.setGuestScore(game.getGuestScore());
			gv.setHostOvertimeScore(game.getHostOvertimeScore());
			gv.setGuestOvertimeScore(game.getGuestOvertimeScore());
			gv.setHostPenaltyScore(game.getHostPenaltyScore());
			gv.setGuestPenaltyScore(game.getGuestPenaltyScore());
			gv.setHostSchoolName(game.getYsmsTeamByHostTeamid().getYsmsSchool().getSchoolName());
			gv.setGuestSchoolName(game.getYsmsTeamByGuestTeamid().getYsmsSchool().getSchoolName());
			gv.setLeagueName(game.getYsmsLeagueZone().getYsmsLeague().getLeagueName());
			
			SimpleDateFormat sdfForCalendar = new SimpleDateFormat("MM-dd-yyyy");
			gv.setGameTimeForCalendar(sdfForCalendar.format(game.getGamesTime()));
			viewList.add(gv);
		}
		return viewList;
	}

	@Override
	public List<GameView> getAllGames() {
		List<GameView> viewList = new ArrayList<GameView>();
		List<YsmsGames> gameList = gamesDao.findAll();
		for(int i=0;i<gameList.size();i++){
			YsmsGames game = gameList.get(i);
			GameView gv = new GameView();
			gv.setGamesId(game.getGamesId());
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
			gv.setGameTime(sdf.format(game.getGamesTime()));
			gv.setGameLocation(game.getGameLocation());
			gv.setIsOvertimeFlag(game.getIsOvertimeFlag());
			gv.setIsPenaltyFlag(game.getIsPenaltyFlag());
			gv.setIsGameOver(game.getIsGameOver());
			gv.setHostScore(game.getHostScore());
			gv.setGuestScore(game.getGuestScore());
			gv.setHostOvertimeScore(game.getHostOvertimeScore());
			gv.setGuestOvertimeScore(game.getGuestOvertimeScore());
			gv.setHostPenaltyScore(game.getHostPenaltyScore());
			gv.setGuestPenaltyScore(game.getGuestPenaltyScore());
			gv.setHostSchoolName(game.getYsmsTeamByHostTeamid().getYsmsSchool().getSchoolName());
			gv.setGuestSchoolName(game.getYsmsTeamByGuestTeamid().getYsmsSchool().getSchoolName());
			gv.setLeagueName(game.getYsmsLeagueZone().getYsmsLeague().getLeagueName());
			
			SimpleDateFormat sdfForCalendar = new SimpleDateFormat("MM-dd-yyyy");
			gv.setGameTimeForCalendar(sdfForCalendar.format(game.getGamesTime()));
			viewList.add(gv);
		}
		return viewList;
	}

	@Override
	public Map<String, String> getMapForCalendar(List<GameView> games) {
		//这个方法效率有点儿低
		Map<String, String> result = new HashMap<String, String>();
		int index = 0;
		if(games!=null){
			while(index<games.size()){
				GameView gv= games.get(index);
				String date = gv.getGameTimeForCalendar();
				Iterator iter = result.keySet().iterator();
				boolean containsDate = false;
				while(iter.hasNext()){
					String keystr = iter.next().toString();
					if(date.equals(keystr)){
						String val = result.get(keystr);
						val += "<a>" + gv.getGameTime() + "&nbsp;&nbsp;" + gv.getGameLocation() 
								+ "&nbsp;&nbsp;" + gv.getLeagueName() + "</a>";
						if(gv.getIsGameOver()==0)
							val += "<a style='color:black;'>" + gv.getHostSchoolName() + " VS " 
										+ gv.getGuestSchoolName() + "</a><br/>";
						else if(gv.getIsGameOver()==1)
							val += "<a style='color:black;'>" + gv.getHostSchoolName() + "&nbsp;" + gv.getHostScore() 
										+ ":" + gv.getGuestScore() + "&nbsp;" + gv.getGuestSchoolName() + "</a><br/>";
						result.put(keystr, val);
						containsDate = true;
					}
				}
				if(!containsDate){
					String val = "";
					val += "<a>" + gv.getGameTime() + "&nbsp;&nbsp;" + gv.getGameLocation() 
							+ "&nbsp;&nbsp;" + gv.getLeagueName() + "</a>";
					if(gv.getIsGameOver()==0)
						val += "<a style='color:black;'>" + gv.getHostSchoolName() + " VS " 
									+ gv.getGuestSchoolName() + "</a><br/>";
					else if(gv.getIsGameOver()==1)
						val += "<a style='color:black;'>" + gv.getHostSchoolName() + "&nbsp;" + gv.getHostScore() 
									+ ":" + gv.getGuestScore() + "&nbsp;" + gv.getGuestSchoolName() + "</a><br/>";
					result.put(date, val);
				}
				index++;
			}
		}
		return result;
	}

	@Override
	public List<GameView> getGamesByMonthAndSchool(int schoolId, Date date) {
		List<GameView> viewList = new ArrayList<GameView>();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		Date firstDay = cal.getTime();
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		Date lastDay = cal.getTime();
		List<YsmsGames> gameList = gamesDao.getGamesBySchoolIdBetweenDate(schoolId, firstDay, lastDay);
		for(int i=0;i<gameList.size();i++){
			YsmsGames game = gameList.get(i);
			GameView gv = new GameView();
			gv.setGamesId(game.getGamesId());
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
			gv.setGameTime(sdf.format(game.getGamesTime()));
			gv.setGameLocation(game.getGameLocation());
			gv.setIsOvertimeFlag(game.getIsOvertimeFlag());
			gv.setIsPenaltyFlag(game.getIsPenaltyFlag());
			gv.setIsGameOver(game.getIsGameOver());
			gv.setHostScore(game.getHostScore());
			gv.setGuestScore(game.getGuestScore());
			gv.setHostOvertimeScore(game.getHostOvertimeScore());
			gv.setGuestOvertimeScore(game.getGuestOvertimeScore());
			gv.setHostPenaltyScore(game.getHostPenaltyScore());
			gv.setGuestPenaltyScore(game.getGuestPenaltyScore());
			gv.setHostSchoolName(game.getYsmsTeamByHostTeamid().getYsmsSchool().getSchoolName());
			gv.setGuestSchoolName(game.getYsmsTeamByGuestTeamid().getYsmsSchool().getSchoolName());
			gv.setLeagueName(game.getYsmsLeagueZone().getYsmsLeague().getLeagueName());
			
			SimpleDateFormat sdfForCalendar = new SimpleDateFormat("MM-dd-yyyy");
			gv.setGameTimeForCalendar(sdfForCalendar.format(game.getGamesTime()));
			viewList.add(gv);
		}
		return viewList;
	}

	@Override
	public boolean setGameOver(int gamesId, boolean isOver) {
		YsmsGames game = gamesDao.findById(gamesId);
		game.setIsGameOver(isOver?1:0);
		gamesDao.save(game);
		return true;
	}

	@Override
	public List<GameView> getNextGamesByTeamId(int teamId) {
		List<GameView> views = new ArrayList<GameView>();
		List<YsmsGames> games = gamesDao.getNextGamesByTeamId(teamId);
		if(games!=null){
			for(int i=0;i<games.size();i++){
				YsmsGames game = games.get(i);
				GameView gv = new GameView();
				gv.setGamesId(game.getGamesId());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
				gv.setGameTime(sdf.format(game.getGamesTime()));
				gv.setGameLocation(game.getGameLocation());
				gv.setIsOvertimeFlag(game.getIsOvertimeFlag());
				gv.setIsPenaltyFlag(game.getIsPenaltyFlag());
				gv.setIsGameOver(game.getIsGameOver());
				gv.setHostScore(game.getHostScore());
				gv.setGuestScore(game.getGuestScore());
				gv.setHostOvertimeScore(game.getHostOvertimeScore());
				gv.setGuestOvertimeScore(game.getGuestOvertimeScore());
				gv.setHostPenaltyScore(game.getHostPenaltyScore());
				gv.setGuestPenaltyScore(game.getGuestPenaltyScore());
				gv.setHostSchoolName(game.getYsmsTeamByHostTeamid().getYsmsSchool().getSchoolName());
				gv.setGuestSchoolName(game.getYsmsTeamByGuestTeamid().getYsmsSchool().getSchoolName());
				gv.setLeagueName(game.getYsmsLeagueZone().getYsmsLeague().getLeagueName());
				views.add(gv);
			}
		}
		return views;
	}

	@Override
	public List<GameView> getLatestGamesByTeamid(int teamId) {
		List<GameView> views = new ArrayList<GameView>();
		List<YsmsGames> games = gamesDao.getLastGamesByTeamId(teamId);
		if(games!=null){
			for(int i=0;i<games.size();i++){
				YsmsGames game = games.get(i);
				GameView gv = new GameView();
				gv.setGamesId(game.getGamesId());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
				gv.setGameTime(sdf.format(game.getGamesTime()));
				gv.setGameLocation(game.getGameLocation());
				gv.setIsOvertimeFlag(game.getIsOvertimeFlag());
				gv.setIsPenaltyFlag(game.getIsPenaltyFlag());
				gv.setIsGameOver(game.getIsGameOver());
				gv.setHostScore(game.getHostScore());
				gv.setGuestScore(game.getGuestScore());
				gv.setHostOvertimeScore(game.getHostOvertimeScore());
				gv.setGuestOvertimeScore(game.getGuestOvertimeScore());
				gv.setHostPenaltyScore(game.getHostPenaltyScore());
				gv.setGuestPenaltyScore(game.getGuestPenaltyScore());
				gv.setHostSchoolName(game.getYsmsTeamByHostTeamid().getYsmsSchool().getSchoolName());
				gv.setGuestSchoolName(game.getYsmsTeamByGuestTeamid().getYsmsSchool().getSchoolName());
				gv.setLeagueName(game.getYsmsLeagueZone().getYsmsLeague().getLeagueName());
				views.add(gv);
			}
		}
		return views;
	}

	@Override
	public List<GameView> getNextGamesByAthleteIdLimit10(int athleteId) {
		List<GameView> views = new ArrayList<GameView>();
		List<YsmsGames> games = gamesDao.getNextGamesByAthleteId(athleteId);
		if(games!=null){
			for(int i=0;i<games.size();i++){
				YsmsGames game = games.get(i);
				GameView gv = new GameView();
				gv.setGamesId(game.getGamesId());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
				gv.setGameTime(sdf.format(game.getGamesTime()));
				gv.setGameLocation(game.getGameLocation());
				gv.setIsOvertimeFlag(game.getIsOvertimeFlag());
				gv.setIsPenaltyFlag(game.getIsPenaltyFlag());
				gv.setIsGameOver(game.getIsGameOver());
				gv.setHostScore(game.getHostScore());
				gv.setGuestScore(game.getGuestScore());
				gv.setHostOvertimeScore(game.getHostOvertimeScore());
				gv.setGuestOvertimeScore(game.getGuestOvertimeScore());
				gv.setHostPenaltyScore(game.getHostPenaltyScore());
				gv.setGuestPenaltyScore(game.getGuestPenaltyScore());
				gv.setHostSchoolName(game.getYsmsTeamByHostTeamid().getYsmsSchool().getSchoolName());
				gv.setGuestSchoolName(game.getYsmsTeamByGuestTeamid().getYsmsSchool().getSchoolName());
				gv.setLeagueName(game.getYsmsLeagueZone().getYsmsLeague().getLeagueName());
				views.add(gv);
			}
		}
		return views;
	}

	@Override
	public List<GameView> getLastGamesByAthleteIdLimit10(int athleteId) {
		List<GameView> views = new ArrayList<GameView>();
		List<YsmsGames> games = gamesDao.getLastGamesByAthleteId(athleteId);
		if(games!=null){
			for(int i=0;i<games.size();i++){
				YsmsGames game = games.get(i);
				GameView gv = new GameView();
				gv.setGamesId(game.getGamesId());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
				gv.setGameTime(sdf.format(game.getGamesTime()));
				gv.setGameLocation(game.getGameLocation());
				gv.setIsOvertimeFlag(game.getIsOvertimeFlag());
				gv.setIsPenaltyFlag(game.getIsPenaltyFlag());
				gv.setIsGameOver(game.getIsGameOver());
				gv.setHostScore(game.getHostScore());
				gv.setGuestScore(game.getGuestScore());
				gv.setHostOvertimeScore(game.getHostOvertimeScore());
				gv.setGuestOvertimeScore(game.getGuestOvertimeScore());
				gv.setHostPenaltyScore(game.getHostPenaltyScore());
				gv.setGuestPenaltyScore(game.getGuestPenaltyScore());
				gv.setHostSchoolName(game.getYsmsTeamByHostTeamid().getYsmsSchool().getSchoolName());
				gv.setGuestSchoolName(game.getYsmsTeamByGuestTeamid().getYsmsSchool().getSchoolName());
				gv.setLeagueName(game.getYsmsLeagueZone().getYsmsLeague().getLeagueName());
				views.add(gv);
			}
		}
		return views;
	}
	
}
