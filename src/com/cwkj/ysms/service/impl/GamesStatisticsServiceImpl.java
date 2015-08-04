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
import com.cwkj.ysms.model.YsmsLeagueZone;
import com.cwkj.ysms.model.YsmsTeam;
import com.cwkj.ysms.model.YsmsTeammember;
import com.cwkj.ysms.model.YsmsZoneTeam;
import com.cwkj.ysms.model.view.MarkItemView;
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

	@Override
	public List<MarkItemView> getLeagueTable(int zoneId,
			String groupName) {
		List<MarkItemView> markList = new ArrayList<MarkItemView>();
		List<Object> gamesObjectList = gameDao.findByHQL("from YsmsGames yg where yg.ysmsLeagueZone.zoneId = " + zoneId + " and yg.gamesOrder = 1");
		List<YsmsGames> gamesList = new ArrayList<YsmsGames>();
		for(int i=0;i<gamesObjectList.size();i++){
			gamesList.add((YsmsGames)(gamesObjectList.get(i)));
		}
		
		List<YsmsTeam> teamList = teamDao.findByZoneIdandGroupBesidesSelected(zoneId, groupName, null);
		for(int i=0;i<teamList.size();i++){
			MarkItemView miv = new MarkItemView();
			miv.setTeamId(teamList.get(i).getTeamId());
			miv.setTeamName(teamList.get(i).getYsmsSchool().getSchoolName());
			miv.setGoalNum(0);
			miv.setFumbleNum(0);
			miv.setGD(0);
			miv.setMark(0);
			miv.setWinCount(0);
			miv.setDrawCount(0);
			miv.setLoseCount(0);
			miv.setTeam(teamList.get(i));
			markList.add(miv);
		}
		//读取统计数据
		markList = this.getMark(teamList, gamesList, markList);
		YsmsLeagueZone leagueZone = leagueZoneDao.findById(zoneId);
		String[] ruleStrs = leagueZone.getRuleOrder().split(",");
		Integer[] priortyOfRules = null; //规则优先级，越往后优先级越高
		if(ruleStrs!=null){
			priortyOfRules = new Integer[ruleStrs.length];
			for(int i=0;i<ruleStrs.length;i++){
				priortyOfRules[i] = Integer.parseInt(ruleStrs[i]);
			}
		}
		if(priortyOfRules!=null){
			for(int i=0;i<priortyOfRules.length;i++){
				Integer ruleId = priortyOfRules[i];
				switch(ruleId){
				case 1:
					markList = this.orderByGD(markList); //净胜球
					break;
				case 2:
					markList = this.orderByMark(markList); //积分
					break;
				case 3:
					markList = this.orderByGoal(markList); //进球
					break;
				case 4:
					markList = this.orderByYellowCard(markList); //黄牌数
					break; 
				case 5:
					markList = this.orderByRedCard(markList); //红牌数
					break; 	
				case 6:
					markList = this.orderByWinLostRelationInner(markList, gamesList); //相互之间胜负关系
					break;
				case 7:
					markList = this.orderByGDInner(markList, gamesList); //相互之间净胜球
					break;
				case 8:
					markList = this.orderByGoalInner(markList, gamesList);//相互之间进球
					break;
				}
			}
		}
		return markList;
	}
	
	private List<MarkItemView> getMark(List<YsmsTeam> teamList, List<YsmsGames> gamesList, List<MarkItemView> markList){
		//净胜球
		for(int m=0;m<teamList.size();m++){
			int GD = 0;
			YsmsTeam the_team = teamList.get(m);
			for(int i=0;i<gamesList.size();i++){
				YsmsGames the_game = gamesList.get(i);
				if(the_game.getYsmsTeamByHostTeamid().getTeamId().equals(the_team.getTeamId())){
					GD += the_game.getHostScore() - the_game.getGuestScore(); //如果是主场，那么净胜球就是主场-客场
				}
				else if(the_game.getYsmsTeamByGuestTeamid().getTeamId().equals(the_team.getTeamId())){
					GD += the_game.getGuestScore() - the_game.getHostScore();
				}
			}
			for(int i=0;i<markList.size();i++){
				MarkItemView miv_i = markList.get(i);
				if(miv_i.getTeamId() == the_team.getTeamId()){
					miv_i.setGD(GD);
					markList.set(i, miv_i);
				}
			}
		}
		//积分
		for(int m=0;m<teamList.size();m++){
			int mark = 0;
			int winCount = 0;
			int drawCount = 0;
			int loseCount = 0;
			YsmsTeam the_team = teamList.get(m);
			for(int i=0;i<gamesList.size();i++){
				YsmsGames the_game = gamesList.get(i);
				if(the_game.getYsmsTeamByHostTeamid().getTeamId().equals(the_team.getTeamId())){
					if(the_game.getHostScore() > the_game.getGuestScore()){
						mark += 3;
						winCount++;
					}
					else if (the_game.getHostScore().equals(the_game.getGuestScore())){
						mark += 1;
						drawCount++;
					}
					else
						loseCount++;
				}
				else if(the_game.getYsmsTeamByGuestTeamid().getTeamId().equals(the_team.getTeamId())){
					if(the_game.getHostScore() < the_game.getGuestScore()){
						mark += 3;
						winCount++;
					}
					else if (the_game.getHostScore().equals(the_game.getGuestScore())){
						mark += 1;
						drawCount++;
					}
					else
						loseCount++;
				}
			}
			for(int i=0;i<markList.size();i++){
				MarkItemView miv_i = markList.get(i);
				if(miv_i.getTeamId() == the_team.getTeamId()){
					miv_i.setMark(mark);
					miv_i.setWinCount(winCount);
					miv_i.setDrawCount(drawCount);
					miv_i.setLoseCount(loseCount);
					markList.set(i, miv_i);
				}
			}
		}
		//进球失球
		for(int m=0;m<teamList.size();m++){
			int goalCount = 0;
			int fumbleCount = 0;
			YsmsTeam the_team = teamList.get(m);
			for(int i=0;i<gamesList.size();i++){
				YsmsGames the_game = gamesList.get(i);
				if(the_game.getYsmsTeamByHostTeamid().getTeamId().equals(the_team.getTeamId())){
					goalCount += the_game.getHostScore();
					fumbleCount += the_game.getGuestScore();
				}
				else if(the_game.getYsmsTeamByGuestTeamid().getTeamId().equals(the_team.getTeamId())){
					goalCount += the_game.getGuestScore();
					fumbleCount += the_game.getHostScore();
				}
			}
			for(int i=0;i<markList.size();i++){
				MarkItemView miv_i = markList.get(i);
				if(miv_i.getTeamId() == the_team.getTeamId()){
					miv_i.setGoalNum(goalCount);
					miv_i.setFumbleNum(fumbleCount);
				}
			}
		}
		return markList;
	}
	private List<MarkItemView> orderByGD(List<MarkItemView> markList){
		for(int i=0;i<markList.size();i++){
			for(int j=i+1;j<markList.size();j++){

				MarkItemView miv_i = markList.get(i);
				MarkItemView miv_j = markList.get(j);
				if(miv_i.getGD() < miv_j.getGD()){
					markList.set(i, miv_j);
					markList.set(j, miv_i);
				}
			}
		}
		return markList;
	}
	
	private List<MarkItemView> orderByMark(List<MarkItemView> markList){
		for(int i=0;i<markList.size();i++){
			for(int j=i+1;j<markList.size();j++){
				
				MarkItemView miv_i = markList.get(i);
				MarkItemView miv_j = markList.get(j);
				if(miv_i.getMark() < miv_j.getMark()){
					markList.set(i, miv_j);
					markList.set(j, miv_i);
				}
			}
		}
		return markList;
	}
	
	private List<MarkItemView> orderByGoal(List<MarkItemView> markList){
		for(int i=0;i<markList.size();i++){
			for(int j=i+1;j<markList.size();j++){
				MarkItemView miv_i = markList.get(i);
				MarkItemView miv_j = markList.get(j);
				if(miv_i.getGoalNum() < miv_j.getGoalNum()){
					markList.set(i, miv_j);
					markList.set(j, miv_i);
				}
			}
		}
		return markList;
	}
	
	private List<MarkItemView> orderByYellowCard(List<MarkItemView> markList){
		//这里的运算量很大
		//黄牌
		for(int i=0;i<markList.size();i++){
			MarkItemView miv = markList.get(i);
			int yellowCardNum = this.getTeamYellowCardsInZone(miv.getTeamId());
			miv.setYellowCardCount(yellowCardNum);
			markList.set(i, miv);
		}
		
		for(int i=0;i<markList.size();i++){
			for(int j=i+1;j<markList.size();j++){
				MarkItemView miv_i = markList.get(i);
				MarkItemView miv_j = markList.get(j);
				int yellowCardNum_i = miv_i.getYellowCardCount();
				int yellowCardNum_j = miv_j.getYellowCardCount();
				if(yellowCardNum_i > yellowCardNum_j){//越多越完犊子
					markList.set(i, miv_j);
					markList.set(j, miv_i);
				}
			}
		}
		return markList;
	}
	
	private List<MarkItemView> orderByRedCard(List<MarkItemView> markList){
		//这里的运算量很大
		//红牌
		for(int i=0;i<markList.size();i++){
			MarkItemView miv = markList.get(i);
			int RedCardNum = this.getTeamRedCardsInZone(miv.getTeamId());
			miv.setRedCardCount(RedCardNum);
			markList.set(i, miv);
		}
		for(int i=0;i<markList.size();i++){
			for(int j=i+1;j<markList.size();j++){
				MarkItemView miv_i = markList.get(i);
				MarkItemView miv_j = markList.get(j);
				int redCardNum_i = miv_i.getRedCardCount();
				int redCardNum_j = miv_j.getRedCardCount();
				if(redCardNum_i > redCardNum_j){//越多越完犊子
					markList.set(i, miv_j);
					markList.set(j, miv_i);
				}
			}
		}
		return markList;
	}
	
	private List<MarkItemView> orderByWinLostRelationInner(List<MarkItemView> markList, List<YsmsGames> gamesList){
		List<MarkItemView> markListAfterOrder = new ArrayList<MarkItemView>();
		markList = this.orderByMark(markList);//先排序
		for(int i=0;i<markList.size();i++){
			List<MarkItemView> innerItems = new ArrayList<MarkItemView>(); //内部小组，取积分相同的
			List<MarkItemView> innerItemsForInnerCount = new ArrayList<MarkItemView>();;
			List<YsmsTeam> innerTeams = new ArrayList<YsmsTeam>();
			innerItems.add(markList.get(i));
			innerTeams.add(markList.get(i).getTeam());
			for(int j=i+1;j<markList.size();j++){
				if(markList.get(i).getMark() == markList.get(j).getMark()){
					//积分相同 加入小组
					innerItems.add(markList.get(j));
					innerTeams.add(markList.get(j).getTeam());
					i++;
				}
			}
			//对小组中球队再进行一次积分排序，即为按照相互胜负关系排序
			for(int m=0;m<innerItems.size();m++){
				MarkItemView miv_inner = new MarkItemView();
				miv_inner.setTeamId(innerItems.get(m).getTeamId());
				miv_inner.setTeamName(innerItems.get(m).getTeamName());
				innerItemsForInnerCount.add(miv_inner);
			}
			//积分
			for(int m=0;m<innerTeams.size();m++){
				int mark = 0;
				int winCount = 0;
				int drawCount = 0;
				int loseCount = 0;
				YsmsTeam the_team = innerTeams.get(m);
				for(int p=0;p<gamesList.size();p++){
					YsmsGames the_game = gamesList.get(p);
					for(int n=0;n<innerTeams.size();n++){
						if(the_game.getYsmsTeamByHostTeamid().getTeamId().equals(the_team.getTeamId()) && the_game.getYsmsTeamByGuestTeamid().getTeamId().equals(innerTeams.get(n).getTeamId())){
							if(the_game.getHostScore() > the_game.getGuestScore()){
								mark += 3;
								winCount++;
							}
							else if (the_game.getHostScore().equals(the_game.getGuestScore())){
								mark += 1;
								drawCount++;
							}
							else
								loseCount++;
						}
						else if(the_game.getYsmsTeamByGuestTeamid().getTeamId().equals(the_team.getTeamId()) && the_game.getYsmsTeamByHostTeamid().getTeamId().equals(innerTeams.get(n).getTeamId())){
							if(the_game.getHostScore() < the_game.getGuestScore()){
								mark += 3;
								winCount++;
							}
							else if (the_game.getHostScore().equals(the_game.getGuestScore())){
								mark += 1;
								drawCount++;
							}
							else
								loseCount++;
						}
					}
				}
				for(int p=0;p<innerItemsForInnerCount.size();p++){
					MarkItemView miv_p = innerItemsForInnerCount.get(p);
					if(miv_p.getTeamId() == the_team.getTeamId()){
						miv_p.setMark(mark);
						miv_p.setWinCount(winCount);
						miv_p.setDrawCount(drawCount);
						miv_p.setLoseCount(loseCount);
						innerItemsForInnerCount.set(p, miv_p);
					}
				}
			}
			//排序
			for(int p=0;p<innerItemsForInnerCount.size();p++){
				for(int q=p+1;q<innerItemsForInnerCount.size();q++){
					
					MarkItemView miv_p_inner = innerItemsForInnerCount.get(p); //内部
					MarkItemView miv_q_inner = innerItemsForInnerCount.get(q); //内部
					MarkItemView miv_p = innerItems.get(p); //外部
					MarkItemView miv_q = innerItems.get(q); //外部
					if(miv_p_inner.getMark() < miv_q_inner.getMark()){
						innerItems.set(p, miv_q);
						innerItems.set(q, miv_p);
					}
				}
			}
			for(int p=0;p<innerItems.size();p++){
				markListAfterOrder.add(innerItems.get(p));
			}
		}
		return markListAfterOrder;
	}
	
	private List<MarkItemView> orderByGDInner(List<MarkItemView> markList, List<YsmsGames> gamesList){
		List<MarkItemView> markListAfterOrder = new ArrayList<MarkItemView>();
		markList = this.orderByMark(markList);//先排序
		for(int i=0;i<markList.size();i++){
			List<MarkItemView> innerItems = new ArrayList<MarkItemView>(); //内部小组，取积分相同的
			List<MarkItemView> innerItemsForInnerCount = new ArrayList<MarkItemView>();;
			List<YsmsTeam> innerTeams = new ArrayList<YsmsTeam>();
			innerItems.add(markList.get(i));
			innerTeams.add(markList.get(i).getTeam());
			for(int j=i+1;j<markList.size();j++){
				if(markList.get(i).getMark() == markList.get(j).getMark()){
					//积分相同 加入小组
					innerItems.add(markList.get(j));
					innerTeams.add(markList.get(j).getTeam());
					i++;
				}
			}
			//对小组中球队再进行一次净胜球排序，即为按照相互胜负关系排序
			for(int m=0;m<innerItems.size();m++){
				MarkItemView miv_inner = new MarkItemView();
				miv_inner.setTeamId(innerItems.get(m).getTeamId());
				miv_inner.setTeamName(innerItems.get(m).getTeamName());
				innerItemsForInnerCount.add(miv_inner);
			}
			//净胜球
			for(int m=0;m<innerTeams.size();m++){
				int GD = 0;
				YsmsTeam the_team = innerTeams.get(m);
				for(int p=0;p<gamesList.size();p++){
					YsmsGames the_game = gamesList.get(p);
					for(int n=0;n<innerTeams.size();n++){
						if(the_game.getYsmsTeamByHostTeamid().getTeamId().equals(the_team.getTeamId()) && the_game.getYsmsTeamByGuestTeamid().getTeamId().equals(innerTeams.get(n).getTeamId())){
							GD += the_game.getHostScore() - the_game.getGuestScore(); //如果是主场，那么净胜球就是主场-客场
						}
						else if(the_game.getYsmsTeamByGuestTeamid().getTeamId().equals(the_team.getTeamId()) && the_game.getYsmsTeamByHostTeamid().getTeamId().equals(innerTeams.get(n).getTeamId())){
							GD += the_game.getGuestScore() - the_game.getHostScore();
						}
					}
				}
				for(int p=0;p<innerItemsForInnerCount.size();p++){
					MarkItemView miv_p = innerItemsForInnerCount.get(p);
					if(miv_p.getTeamId() == the_team.getTeamId()){
						miv_p.setGD(GD);
						innerItemsForInnerCount.set(p, miv_p);
					}
				}
			}
			//排序
			for(int p=0;p<innerItemsForInnerCount.size();p++){
				for(int q=p+1;q<innerItemsForInnerCount.size();q++){
					
					MarkItemView miv_p_inner = innerItemsForInnerCount.get(p); //内部
					MarkItemView miv_q_inner = innerItemsForInnerCount.get(q); //内部
					MarkItemView miv_p = innerItems.get(p); //外部
					MarkItemView miv_q = innerItems.get(q); //外部
					if(miv_p_inner.getGD() < miv_q_inner.getGD()){
						innerItems.set(p, miv_q);
						innerItems.set(q, miv_p);
					}
				}
			}
			for(int p=0;p<innerItemsForInnerCount.size();p++){
				markListAfterOrder.add(innerItems.get(p));
			}
		}
		return markListAfterOrder;
	}
	
	private List<MarkItemView> orderByGoalInner(List<MarkItemView> markList, List<YsmsGames> gamesList){
		List<MarkItemView> markListAfterOrder = new ArrayList<MarkItemView>();
		markList = this.orderByMark(markList);//先排序
		for(int i=0;i<markList.size();i++){
			List<MarkItemView> innerItems = new ArrayList<MarkItemView>(); //内部小组，取积分相同的
			List<MarkItemView> innerItemsForInnerCount = new ArrayList<MarkItemView>();;
			List<YsmsTeam> innerTeams = new ArrayList<YsmsTeam>();
			innerItems.add(markList.get(i));
			innerTeams.add(markList.get(i).getTeam());
			for(int j=i+1;j<markList.size();j++){
				if(markList.get(i).getMark() == markList.get(j).getMark()){
					//积分相同 加入小组
					innerItems.add(markList.get(j));
					innerTeams.add(markList.get(j).getTeam());
					i++;
				}
			}
			//对小组中球队再进行一次进球排序，即为按照相互胜负关系排序
			for(int m=0;m<innerItems.size();m++){
				MarkItemView miv_inner = new MarkItemView();
				miv_inner.setTeamId(innerItems.get(m).getTeamId());
				miv_inner.setTeamName(innerItems.get(m).getTeamName());
				innerItemsForInnerCount.add(miv_inner);
			}
			//进球
			for(int m=0;m<innerTeams.size();m++){
				int goalCount = 0;
				int fumbleCount = 0;
				YsmsTeam the_team = innerTeams.get(m);
				for(int p=0;p<gamesList.size();p++){
					YsmsGames the_game = gamesList.get(p);
					for(int n=0;n<innerTeams.size();n++){
						if(the_game.getYsmsTeamByHostTeamid().getTeamId().equals(the_team.getTeamId()) && the_game.getYsmsTeamByGuestTeamid().getTeamId().equals(innerTeams.get(n).getTeamId())){
							goalCount += the_game.getHostScore();
							fumbleCount += the_game.getGuestScore();
						}
						else if(the_game.getYsmsTeamByGuestTeamid().getTeamId().equals(the_team.getTeamId()) && the_game.getYsmsTeamByHostTeamid().getTeamId().equals(innerTeams.get(n).getTeamId())){
							fumbleCount += the_game.getHostScore();
							goalCount += the_game.getGuestScore();
						}
					}
				}
				for(int p=0;p<innerItemsForInnerCount.size();p++){
					MarkItemView miv_p = innerItemsForInnerCount.get(p);
					if(miv_p.getTeamId() == the_team.getTeamId()){
						miv_p.setGoalNum(goalCount);
						miv_p.setFumbleNum(fumbleCount);
						innerItemsForInnerCount.set(p, miv_p);
					}
				}
			}
			//排序
			for(int p=0;p<innerItemsForInnerCount.size();p++){
				for(int q=p+1;q<innerItemsForInnerCount.size();q++){
					
					MarkItemView miv_p_inner = innerItemsForInnerCount.get(p); //内部
					MarkItemView miv_q_inner = innerItemsForInnerCount.get(q); //内部
					MarkItemView miv_p = innerItems.get(p); //外部
					MarkItemView miv_q = innerItems.get(q); //外部
					if(miv_p_inner.getGoalNum() < miv_q_inner.getGoalNum()){
						innerItems.set(p, miv_q);
						innerItems.set(q, miv_p);
					}
				}
			}
			for(int p=0;p<innerItemsForInnerCount.size();p++){
				markListAfterOrder.add(innerItems.get(p));
			}
		}
		return markListAfterOrder;
	}
}
