package com.cwkj.ysms.service.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.cwkj.ysms.dao.AthleteDao;
import com.cwkj.ysms.dao.CoachDao;
import com.cwkj.ysms.dao.FoulDao;
import com.cwkj.ysms.dao.GamesDao;
import com.cwkj.ysms.dao.GamesJudgeDao;
import com.cwkj.ysms.dao.GoalDao;
import com.cwkj.ysms.dao.LeagueZoneDao;
import com.cwkj.ysms.dao.SchoolDao;
import com.cwkj.ysms.dao.TeamDao;
import com.cwkj.ysms.dao.TeammemberDao;
import com.cwkj.ysms.dao.ZoneTeamDao;
import com.cwkj.ysms.model.YsmsAthlete;
import com.cwkj.ysms.model.YsmsFoul;
import com.cwkj.ysms.model.YsmsGames;
import com.cwkj.ysms.model.YsmsGamesJudge;
import com.cwkj.ysms.model.YsmsGoal;
import com.cwkj.ysms.model.YsmsJudge;
import com.cwkj.ysms.model.YsmsLeague;
import com.cwkj.ysms.model.YsmsLeagueZone;
import com.cwkj.ysms.model.YsmsTeam;
import com.cwkj.ysms.model.YsmsTeammember;
import com.cwkj.ysms.model.YsmsZoneTeam;
import com.cwkj.ysms.service.GamesStatisticsService;

@Component
public class GamesStatisticsServiceImpl implements GamesStatisticsService{

	@Resource
	private GamesDao gameDao;

	@Resource
	private TeammemberDao teammemberDao;

	@Resource
	private AthleteDao athleteDao;

	@Resource
	private CoachDao coachDao;

	@Resource
	private FoulDao foulDao;

	@Resource
	private ZoneTeamDao zoneTeamDao;

	@Resource
	private SchoolDao schoolDao;

	@Resource
	private TeamDao teamDao;

	@Resource
	private GoalDao goalDao;
	
	@Resource
	private GamesJudgeDao gamesJudgeDao;
	
	@Resource
	private LeagueZoneDao leagueZoneDao;

	public ZoneTeamDao getZoneTeamDao() {
		return zoneTeamDao;
	}

	public void setZoneTeamDao(ZoneTeamDao zoneTeamDao) {
		this.zoneTeamDao = zoneTeamDao;
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

	public GoalDao getGoalDao() {
		return goalDao;
	}

	public void setGoalDao(GoalDao goalDao) {
		this.goalDao = goalDao;
	}

	public GamesDao getGameDao() {
		return gameDao;
	}

	public void setGameDao(GamesDao gameDao) {
		this.gameDao = gameDao;
	}

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

	public CoachDao getCoachDao() {
		return coachDao;
	}

	public void setCoachDao(CoachDao coachDao) {
		this.coachDao = coachDao;
	}

	public FoulDao getFoulDao() {
		return foulDao;
	}

	public void setFoulDao(FoulDao foulDao) {
		this.foulDao = foulDao;
	}

	public ZoneTeamDao getLeagueTeamDao() {
		return zoneTeamDao;
	}

	public void setLeagueTeamDao(ZoneTeamDao leagueTeamDao) {
		this.zoneTeamDao = leagueTeamDao;
	}

	public SchoolDao getSchoolDao() {
		return schoolDao;
	}

	public void setSchoolDao(SchoolDao schoolDao) {
		this.schoolDao = schoolDao;
	}

	public TeamDao getTeamDao() {
		return teamDao;
	}

	public void setTeamDao(TeamDao teamDao) {
		this.teamDao = teamDao;
	}

	@Override
	public int getAthleteGoalsInZone(int zoneId, int athleteId) {
		int result = 0;
		List<YsmsGames> ysmsGames_list = gameDao.getGamesByZoneId(zoneId);
		for (YsmsGames ysmsGames : ysmsGames_list) {
			List<YsmsGoal> ysmsGoal_list = goalDao.findByGame(ysmsGames.getGamesId());
			for (YsmsGoal ysmsGoal : ysmsGoal_list) {
				if (ysmsGoal.getShooter() == athleteId) {
					result++;
				}
			}
		}
		return result;
	}

	@Override
	public int getAthleteAssistsInZone(int zoneId, int athleteId) {
		// TODO Auto-generated method stub
		int result = 0;
		List<YsmsGames> ysmsGames_list = gameDao.getGamesByZoneId(zoneId);
		for (YsmsGames ysmsGames : ysmsGames_list) {
			List<YsmsGoal> ysmsGoal_list = goalDao.findByGame(ysmsGames.getGamesId());
			for (YsmsGoal ysmsGoal : ysmsGoal_list) {
				if (ysmsGoal.getAssistant() == athleteId) {
					result++;
				}
			}
		}
		return result;
	}

	@Override
	public int getAthleteYellowCardsInZone(int zoneId, int athleteId) {
		int foulNumber = 0;
		List<YsmsGames> gameList = gameDao.getGamesByZoneId(zoneId);
		for(int i =0;i<gameList.size();i++){
			YsmsGames ysmsGames = gameList.get(i);
			List<YsmsFoul> foulList = foulDao.getYsmsFoulsByGamesId(ysmsGames.getGamesId());
			for(int j =0;j<foulList.size();j++){
				YsmsFoul ysmsFoul = foulList.get(j);
				if(ysmsFoul.getYsmsAthlete().getAthleteId()==athleteId && ysmsFoul.getFoulLevel()==1){
					foulNumber += 1;
				}
			}
		}
		return foulNumber;
	}

	@Override
	public int getAthleteRedCardsInZone(int zoneId, int athleteId) {
		int foulNumber = 0;
		List<YsmsGames> gameList = gameDao.getGamesByZoneId(zoneId);
		for(int i =0;i<gameList.size();i++){
			YsmsGames ysmsGames = gameList.get(i);
			List<YsmsFoul> foulList = foulDao.getYsmsFoulsByGamesId(ysmsGames.getGamesId());
			for(int j =0;j<foulList.size();j++){
				YsmsFoul ysmsFoul = foulList.get(j);
				if(ysmsFoul.getYsmsAthlete().getAthleteId()==athleteId && ysmsFoul.getFoulLevel()==2){
					foulNumber += 1;
				}
			}
		}
		return foulNumber;
	}

	@Override
	public List<YsmsLeagueZone> getAthletePresentation(int athleteId) {
		List<YsmsLeagueZone> leagueZoneList = new ArrayList<YsmsLeagueZone>();
		List<YsmsTeammember> memberList = teammemberDao.findTeamsByAthleteId(athleteId);
		for(int i=0;i<memberList.size();i++){
			YsmsTeam ysmsTeam = memberList.get(i).getYsmsTeam();
			YsmsZoneTeam ysmsZoneTeam = zoneTeamDao.findByTeamId(ysmsTeam.getTeamId());
			leagueZoneList.add(ysmsZoneTeam.getYsmsLeagueZone());
		}
		return leagueZoneList;
	}

	@Override
	public List<YsmsLeagueZone> getCoachPresentation(int coachId) {
		List<YsmsLeagueZone> leagueZoneList = new ArrayList<YsmsLeagueZone>();
		List<YsmsTeammember> memberList = teammemberDao.findTeamsByCoachesId(coachId);
		for(int i=0;i<memberList.size();i++){
			YsmsTeam ysmsTeam = memberList.get(i).getYsmsTeam();
			YsmsZoneTeam ysmsZoneTeam = zoneTeamDao.findByTeamId(ysmsTeam.getTeamId());
			leagueZoneList.add(ysmsZoneTeam.getYsmsLeagueZone());
		}
		return leagueZoneList;
	}

	@Override
	public double[] getCoachWinningPercentage(int coachId) {
		int totalGameCount = 0;
		int totalWinningGameCount = 0;
		int totalDualGameCount = 0;
		List<YsmsTeammember> memberList = teammemberDao.findTeamsByCoachesId(coachId);
		for(int i=0;i<memberList.size();i++){
			YsmsTeam ysmsTeam = memberList.get(i).getYsmsTeam();
			List<YsmsGames> gamesList = gameDao.getGamesByTeamId(ysmsTeam.getTeamId());
			totalGameCount += gamesList.size();
			for(int j=0;j<gamesList.size();j++){
				YsmsGames game = gamesList.get(j);
				if(game.getHostScore() == game.getGuestScore()){
					totalDualGameCount++;
				}
				else{
					if(game.getYsmsTeamByHostTeamid().getTeamId().equals(ysmsTeam.getTeamId())){
						if(game.getHostScore()>game.getGuestScore())
							totalWinningGameCount++;
					}
					else if(game.getYsmsTeamByGuestTeamid().getTeamId().equals(ysmsTeam.getTeamId())){
						if(game.getHostScore()<game.getGuestScore())
							totalWinningGameCount++;
					}
				}
			}
		}
		DecimalFormat df = new DecimalFormat("#.#");
		double winningPercentage = Double.parseDouble(
				df.format(totalWinningGameCount*100/totalGameCount));
		double dualPercentage = Double.parseDouble(
				df.format(totalDualGameCount*100/totalGameCount));
		double losePercentage = 100-winningPercentage-dualPercentage;
		double[] result = {winningPercentage, dualPercentage, losePercentage};
		return result;
	}

	@Override
	public List<YsmsGames> getTeamGamesInZone(int teamId) {
		return gameDao.getGamesByTeamId(teamId);
	}

	@Override
	public int getTeamGoalsInZone(int teamId) {
		int totalGoalCount = 0;
		List<YsmsGames> ysmsGames_list = gameDao.getGamesByTeamId(teamId);
		for (int i=0;i<ysmsGames_list.size();i++) {
			List<YsmsGoal> ysmsGoal_list = goalDao.findByGame(ysmsGames_list.get(i)
					.getGamesId());
			for (int j=0;j<ysmsGoal_list.size();j++) {
				YsmsGoal ysmsGoal = ysmsGoal_list.get(j);
				int athleteId = ysmsGoal.getShooter();
				List<YsmsTeammember> memberList = teammemberDao.findAthletesByTeamId(teamId);
				for(int k=0;k<memberList.size();k++){
					if(memberList.get(k).getYsmsAthlete().getAthleteId()
							.equals(athleteId)){
						totalGoalCount++;
					}
				}
			}
		}
		return totalGoalCount;
	}


	@Override
	public int getTeamYellowCardsInZone(int teamId) {
		int result = 0;
		List<YsmsGames> ysmsGames_list = gameDao.getGamesByTeamId(teamId);
		for (int i=0;i<ysmsGames_list.size();i++) {
			List<YsmsFoul> ysmsFouls_list = foulDao.getYsmsFoulsByGamesId(ysmsGames_list.get(i)
					.getGamesId());
			for (int j=0;j<ysmsFouls_list.size();j++) {
				YsmsFoul ysmsFoul = ysmsFouls_list.get(j);
				YsmsAthlete ysmsAthlete = ysmsFoul.getYsmsAthlete();
				List<YsmsTeammember> memberList = teammemberDao.findAthletesByTeamId(teamId);
				for(int k=0;k<memberList.size();k++){
					if(memberList.get(k).getYsmsAthlete().getAthleteId()
							.equals(ysmsAthlete.getAthleteId())){
						if (ysmsFouls_list.get(j).getFoulLevel() == 1) {
							result++;
						}
					}
				}
			}
		}
		return result;
	}

	@Override
	public int getTeamRedCardsInZone(int teamId) {
		int result = 0;
		List<YsmsGames> ysmsGames_list = gameDao.getGamesByTeamId(teamId);
		for (int i=0;i<ysmsGames_list.size();i++) {
			List<YsmsFoul> ysmsFouls_list = foulDao.getYsmsFoulsByGamesId(ysmsGames_list.get(i)
					.getGamesId());
			for (int j=0;j<ysmsFouls_list.size();j++) {
				YsmsFoul ysmsFoul = ysmsFouls_list.get(j);
				YsmsAthlete ysmsAthlete = ysmsFoul.getYsmsAthlete();
				List<YsmsTeammember> memberList = teammemberDao.findAthletesByTeamId(teamId);
				for(int k=0;k<memberList.size();k++){
					if(memberList.get(k).getYsmsAthlete().getAthleteId()
							.equals(ysmsAthlete.getAthleteId())){
						if (ysmsFouls_list.get(j).getFoulLevel() == 2) {
							result++;
						}
					}
				}
			}
		}
		return result;
	}

	@Override
	public List<YsmsLeagueZone> getJudgePresentation(int judgeId) {
		// TODO Auto-generated method stub
		List<YsmsGamesJudge> ysmsGamesJudge_list = gamesJudgeDao.getJudgeRelationsByJudgeId(judgeId);
		List<Integer> existZoneId_list = new ArrayList<Integer>();
		List<YsmsLeagueZone> results = new ArrayList<YsmsLeagueZone>();
		for (int i = 0; i < ysmsGamesJudge_list.size(); i++) {
			YsmsGamesJudge ysmsGamesJudge =ysmsGamesJudge_list.get(i);
			YsmsGames ysmsGames = gameDao.findById(ysmsGamesJudge.getYsmsGames().getGamesId()); 
			int zoneId = ysmsGames.getYsmsLeagueZone().getZoneId();
			YsmsLeagueZone ysmsLeagueZone = leagueZoneDao.findById(zoneId);
			if (!existZoneId_list.contains(zoneId)) {
				existZoneId_list.add(zoneId);
				results.add(ysmsLeagueZone);
			}
		}
		return results;
	}

	@Override
	public List<YsmsGames> getJudgeGamesInZone(int judgeId, int zoneId) {
		List<YsmsGames> ysmsGames_list = gameDao.getGamesByZoneId(zoneId);
		List<YsmsGames> results = new ArrayList<YsmsGames>();
		for (YsmsGames ysmsGames : ysmsGames_list) {
			List<YsmsJudge> ysmsJudges_list = gamesJudgeDao.getJudgesByGameId(ysmsGames.getGamesId());
			for (YsmsJudge ysmsJudge : ysmsJudges_list) {
				if (ysmsJudge.getJudgeId().equals(judgeId)) {
					results.add(ysmsGames);
				}
			}
		}
		return results;
	}

	@Override
	public double[] getTotalWinningPercentageBySchool(int schoolId) {
		// TODO Auto-generated method stub
		int totalGameCount = 0;
		int totalWinningGameCount = 0;
		int totalDualGameCount = 0;
		List<YsmsTeam> teamList = teamDao.findBySchoolId(schoolId);
		for(int i=0;i<teamList.size();i++){
			YsmsTeam ysmsTeam = teamList.get(i);
			List<YsmsGames> gamesList = gameDao.getGamesByTeamId(ysmsTeam.getTeamId());
			totalGameCount += gamesList.size();
			for(int j=0;j<gamesList.size();j++){
				YsmsGames game = gamesList.get(j);
				if(game.getHostScore() == game.getGuestScore()){
					totalDualGameCount++;
				}
				else{
					if(game.getYsmsTeamByHostTeamid().getTeamId().equals(ysmsTeam.getTeamId())){
						if(game.getHostScore()>game.getGuestScore())
							totalWinningGameCount++;
					}
					else if(game.getYsmsTeamByGuestTeamid().getTeamId().equals(ysmsTeam.getTeamId())){
						if(game.getHostScore()<game.getGuestScore())
							totalWinningGameCount++;
					}
				}
			}
		}
		DecimalFormat df = new DecimalFormat("#.#");
		if(totalGameCount==0){
			double[] result = {0.0, 0.0, 0.0};
			return result;
		}
		double winningPercentage = Double.parseDouble(
				df.format(totalWinningGameCount*100/totalGameCount));
		double dualPercentage = Double.parseDouble(
				df.format(totalDualGameCount*100/totalGameCount));
		double losePercentage = 100-winningPercentage-dualPercentage;
		double[] result = {winningPercentage, dualPercentage, losePercentage};
		return result;
	}
}
