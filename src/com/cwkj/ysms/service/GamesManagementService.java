package com.cwkj.ysms.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.cwkj.ysms.model.YsmsGames;
import com.cwkj.ysms.model.view.FoulView;
import com.cwkj.ysms.model.view.GameView;
import com.cwkj.ysms.model.view.GoalView;
import com.cwkj.ysms.model.view.SuspensionView;

/**
 * 比赛管理Service接口
 * 包含比赛信息管理和比赛上报
 * @author chrismacong
 * @since 2015-3-5
 *
 */
public interface GamesManagementService {
	
	/**
	 * 添加比赛信息
	 * @param zoneId
	 * @param gamesOrder
	 * @param hostTeamId
	 * @param hostUniformIsDarK
	 * @param guestTeamId
	 * @param guestUniformIsDark
	 * @param gamesTime
	 * @param gamesLocation
	 * @param chiefUmpireId
	 * @param sideRefereeId_1
	 * @param sideRefereeId_2
	 * @param forth_Officer
	 * @param officer_1
	 * @param officer_2
	 * @param recorder_1
	 * @param recorder_2
	 * @return
	 */
	public boolean addGamesInfo(int zoneId, int gamesOrder, int hostTeamId, String hostUniform, 
			int guestTeamId, String guestUniform, Date gamesTime,
			String gamesLocation, int chiefUmpireId, int sideRefereeId_1,
			int sideRefereeId_2, int forth_Officer, int officer_1, int officer_2, int recorder_1, int recorder_2);
	
	/**
	 * 在不设置裁判员的前提下配置比赛
	 * @param zoneId
	 * @param gamesOrder
	 * @param hostTeamId
	 * @param hostUniformIsDarK
	 * @param guestTeamId
	 * @param guestUniformIsDark
	 * @param gamesTime
	 * @param gamesLocation
	 * @return
	 */
	public boolean addGamesInfo(int zoneId, int gamesOrder, int hostTeamId, String hostUniform, 
			int guestTeamId, String guestUniform, Date gamesTime,
			String gamesLocation);
	/**
	 * 更新比赛时间、地点和裁判信息
	 * 主队、客队信息和场次信息已自动生成
	 * @param gamesId 比赛Id
	 * @param gamesTime 比赛时间
	 * @param gamesLocation 比赛地点
	 * @param chiefUmpireId 主裁判Id
	 * @param sideRefereeId_1  边裁Id1
	 * @param sideRefereeId_2 边裁Id2
	 * @return 是否成功，true表示成功
	 */
	public boolean updateGamesInfo(int gamesId, Date gamesTime,
			String gamesLocation, int chiefUmpireId, int sideRefereeId_1,
			int sideRefereeId_2, int forth_Officer, int officer_1, int officer_2, int recorder_1, int recorder_2);
	
	/**
	 * 获取比赛信息
	 * 包含双方得分信息
	 * @param gamesId 比赛Id
	 * @return 比赛实体
	 */
	public GameView getGamesInfo(int gamesId);
	
	/**
	 * 比赛结果上报,也可用于比赛结果更新
	 * @param gamesId 比赛Id
	 * @param hostTeamGoals 主队进球数
	 * @param guestTeamGoals 客队进球数
	 * @return 是否成功，true表示成功
	 * @param isOvertimeFlag 是否加时赛
	 * @param isPenaltyFlag 是否点球大战
	 * @param hostGoalAttempt 主队射门
	 * @param hostTargetNumber 主队射正
	 * @param hostCornerKick 主队角球
	 * @param hostFreeKick 主队任意球
	 * @param hostFoul 主队犯规
	 * @param hostOffside 主队越位
	 * @param hostOvertimeScore 主队加时赛得分
	 * @param hostPenaltyScore 主队点球大战得分
	 * @param guestGoalAttempt 客队射门
	 * @param guestTargetNumber 客队射正
	 * @param guestCornerKick 客队角球
	 * @param guestFreeKick 客队任意球
	 * @param guestFoul 客队犯规
	 * @param guestOffside 客队越位
	 * @param guestOvertimeScore 客队加时赛进球
	 * @param guestPenaltyScore 客队点球大战进球
	 * @return
	 */
	public boolean replyGamesInfo(int gamesId, int hostTeamGoals, int guestTeamGoals, 
			int isOvertimeFlag, int isPenaltyFlag,
			String hostGoalAttempt, String hostTargetNumber, String hostCornerKick,
			String hostFreeKick, String hostFoul, String hostOffside, 
			String hostOvertimeScore, String hostPenaltyScore,
			String guestGoalAttempt, String guestTargetNumber, String guestCornerKick,
			String guestFreeKick, String guestFoul, String guestOffside, 
			String guestOvertimeScore, String guestPenaltyScore);
	
	/**
	 * 添加进球记录
	 * @param gamesId 比赛场次id
	 * @param shooterId 进球者的athleteId
	 * @param assistantId 助攻者的athleteId
	 * @param goalTimeStr 进球时间字符串，为本场比赛时间内的时间，如下半时63分22秒进球:63′22″
	 * @param goalType 进球方式，0=正常进球 ，1=点球
	 * @return 是否成功，true表示成功
	 */
	public boolean addGoalInfo(int gamesId, int shooterId, int assistantId, String goalTimeStr, 
			int goalType);
	
	/**
	 * 修改进球记录
	 * @param goalId 进球Id
	 * @param shooterId 进球者的athleteId
	 * @param assistantId 助攻者的athleteId
	 * @param goalTimeStr 进球时间字符串，为本场比赛时间内的时间，如下半时63分22秒进球:63′22″
	 * @param goalType 进球方式，0=正常进球 ，1=点球
	 * @return 是否成功，true表示成功
	 */
	public boolean modifyGoalInfo(int goalId, int shooterId, int assistantId, 
			String goalTimeStr, int goalType);
	
	/**
	 * 删除进球记录
	 * @param goalId 进球Id
	 * @return 是否成功，true表示成功
	 */
	public boolean deleteGoalInfo(int goalId);
	
	/**
	 * 添加红黄牌记录
	 * @param gamesId 比赛Id
	 * @param foulPlayerId 犯规球员Id
	 * @param foulLevel 犯规严重等级 1=黄牌，2=红牌
	 * @param foulTimeStr 犯规时间字符串，为本场比赛时间内的时间，如下半时63分22秒犯规:63′22″
	 * @return 是否成功，true表示成功
	 */
	public boolean addFoulInfo(int gamesId, int foulPlayerId, int foulLevel, String foulTimeStr);
	
	/**
	 * 修改红黄牌记录
	 * @param foulId 犯规Id
	 * @param gamesId 比赛Id
	 * @param foulPlayerId 犯规球员Id
	 * @param foulLevel 犯规严重等级 1=黄牌，2=红牌
	 * @param foulTimeStr 犯规时间字符串，为本场比赛时间内的时间，如下半时63分22秒犯规:63′22″
	 * @return 是否成功，true表示成功
	 */
	public boolean modifyFoulInfo(int foulId, int gamesId, int foulPlayerId, int foulLevel, 
			String foulTimeStr);
	
	/**
	 * 删除红黄牌记录
	 * @param foulId 犯规Id
	 * @return 是否成功，true表示成功
	 */
	public boolean deleteFoulInfo(int foulId);
	
	/**
	 * 获取球队全部赛程
	 * @param teamId
	 * @return
	 */
	public List<YsmsGames> getGamesByTeam(int teamId);
	/**
	 * 获取球队当月赛程
	 * @param teamId 球队Id
	 * @return 比赛列表
	 */
	public List<YsmsGames> getGamesThisMonthByTeam(int teamId);
	
	/**
	 * 根据月份获取学校的比赛
	 * @param teamId
	 * @param date
	 * @return
	 */
	public List<GameView> getGamesByMonthAndSchool(int schoolId, Date date);
	
	/**
	 * 获取球队的下一场比赛
	 * @param teamId 球队Id
	 * @return 比赛信息
	 */
	public GameView getNextGameByTeam(int teamId);
	
	/**
	 * 获取球队的上一场比赛
	 * @param teamId 球队Id
	 * @return 比赛信息
	 */
	public GameView getLastGameByTeam(int teamId);
	
	/**
	 * 获取球员的下一场比赛
	 * @param teamId 球队Id
	 * @return 比赛信息
	 */
	public GameView getNextGameByAthlete(int athleteId);
	
	/**
	 * 获取球员的上一场比赛
	 * @param teamId 球队Id
	 * @return 比赛信息
	 */
	public GameView getLastGameByAthlete(int athleteId);
	
	/**
	 * 获取某一天的全部比赛
	 * @param date 日期
	 * @return 比赛列表
	 */
	public List<YsmsGames> getGamesByDate(Date date);
	
	
	/**
	 * 按日期所在月获取全部比赛
	 * @param date
	 * @return
	 */
	public List<GameView> getAllGamesByMonth(Date date);
	/**
	 * 获取全部比赛
	 * @return
	 */
	public List<GameView> getAllGames();
	
	/**
	 * 获取联赛的全部赛程
	 * @param zoneId
	 * @return 比赛列表
	 */
	public List<YsmsGames> getGamesByZone(int zoneId);
	
	/**
	 * 根据联赛和日期获取赛程
	 * @param zoneId 联赛组Id
	 * @param date 日期
	 * @return 比赛列表
	 */
	public List<YsmsGames> getGamesByZoneAndDate(int zoneId, Date date);

	/**
	 * 查询某场比赛中的某队进球
	 * 根据进球的球员Id判断进球是否为主队
	 * @param gameId 比赛Id
	 * @return 进球List
	 */
	public List<GoalView> getTeamGoalsInGame(int gameId, int teamId);
	
	/**
	 * 查询某场比赛中的某队犯规
	 * @param gameId 比赛Id
	 * @return 进球List
	 */
	public List<FoulView> getTeamFoulInGame(int gameId, int teamId);
	
	/**
	 * 根据分页信息获取比赛里列表
	 * @param leagueId
	 * @param zoneId
	 * @param date
	 * @param pageIndex
	 * @return
	 */
	public List<GameView> getGamesByPage(Integer leagueId, Integer zoneId, Date date, String pageIndex);

	/**
	 * 获取某联赛组在某一天的比赛总数
	 * @param leagueId
	 * @param zoneId
	 * @param date
	 * @return
	 */
	public int getGamesCount(Integer leagueId, Integer zoneId, Date date);
	
	public boolean deleteGame(int gamesId);
	
	/**
	 * 获取比赛信息
	 * @param gamesId
	 * @return
	 */
	public GameView getGameById(int gamesId);

	/**
	 * 修改比赛
	 * @return
	 */
	public boolean modifyGame(int gamesId, String hostUniform, String guestUniform, Date gamesTime, String gamesLocation);
	
	public boolean deleteAllGoalsInGame(int gamesId);
	
	public boolean deleteAllFoulsInGame(int gamesId);
	
	/**
	 * 获取用于日历显示的比赛信息哈希表
	 * @param games
	 * @return
	 */
	public Map<String, String>getMapForCalendar(List<GameView> games);
	
	/**
	 * 设置或取消完赛
	 * @param isOver
	 * @return
	 */
	public boolean setGameOver(int gamesId, boolean isOver);
	
	/**
	 * 根据球队Id获取未开始的比赛
	 * @param teamId
	 * @return
	 */
	public List<GameView> getNextGamesByTeamId(int teamId);
	
	/**
	 * 根据球队Id获取结束的比赛
	 * @param teamId
	 * @return
	 */
	public List<GameView> getLatestGamesByTeamid(int teamId);
	
	/**
	 * 根据运动员Id获取未开始的比赛，上限10条
	 * @param athleteId
	 * @return
	 */
	public List<GameView> getNextGamesByAthleteIdLimit10(int athleteId);
	
	/**
	 * 根据运动员Id获取已经结束的比赛，上限10条
	 * @param athleteId
	 * @return
	 */
	public List<GameView> getLastGamesByAthleteIdLimit10(int athleteId);
	
	/**
	 * 获取球队在比赛中的停赛信息
	 * @param teamId
	 * @param gamesId
	 * @return
	 */
	public List<SuspensionView> getSuspensionList(int teamId, int gamesId);
}
