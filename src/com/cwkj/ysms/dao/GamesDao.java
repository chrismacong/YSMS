package com.cwkj.ysms.dao;

import java.util.Date;
import java.util.List;

import com.cwkj.ysms.basedao.GenericDao;
import com.cwkj.ysms.model.YsmsAthlete;
import com.cwkj.ysms.model.YsmsGames;
import com.cwkj.ysms.model.view.AssistRankView;
import com.cwkj.ysms.model.view.ShooterRankView;
import com.cwkj.ysms.util.Page;

/**
 * @author seed
 *
 */
public interface GamesDao extends GenericDao  {
	/**
	 * 根据球队Id获取比赛列表
	 * 包括主客场
	 * @param team_id
	 * @return 结果列表
	 */
	public List<YsmsGames> getGamesByTeamId(int teamId);
	
	/**
	 * 根据日期获取比赛列表
	 * @param date 日期
	 * @return 结果列表
	 */
	public List<YsmsGames> getGamesByDate(Date date);
	
	/**
	 * 根据联赛组Id获取比赛列表
	 * @param zoneId 联赛组Id
	 * @return 结果列表
	 */
	public List<YsmsGames> getGamesByZoneId(int zoneId);
	
	/**
	 * 根据联赛组Id获取和日期获取比赛列表
	 * @param zoneId 联赛组Id
	 * @param date 日期
	 * @return 结果列表
	 */
	public List<YsmsGames> getGamesByZoneIdAndDate(int zoneId, Date date);
	
	/**
	 * 添加或保存比赛信息
	 * @param ysmsGames 比赛实体
	 */
	public void save(YsmsGames ysmsGames);
	
	/**
	 * 根据Id获取比赛信息
	 * @param gamesId 比赛Id
	 * @return 比赛信息
	 */
	public YsmsGames findById(int gamesId);
	
	
	/**
	 * 删除比赛信息
	 * @param ysmsGames 比赛
	 */
	public void delete(YsmsGames ysmsGames);
	
	
	/**
	 * 根据联赛组Id和时间段获取比赛信息
	 * @param leagueId 联赛Id
	 * @param beginDate 开始时间
	 * @param endDate 结束时间
	 * @return
	 */
	public List<YsmsGames> getGamesByZoneIdBetweenDate(int zoneId,Date beginDate, Date endDate);
	
	
	/**
	 * 根据队伍Id和时间段获取比赛信息
	 * @param teamId 队伍Id
	 * @param beginDate 开始时间
	 * @param endDate 结束时间
	 * @return
	 */
	public List<YsmsGames> getGamesByTeamIdBetweenDate(int teamId,Date beginDate,Date endDate);
	
	
	/**
	 * 根据队伍Id获取最近一场未开始的比赛
	 * @param teamId 队伍Id
	 * @return
	 */
	public YsmsGames getNextGameByTeamId(int teamId);
	
	/**
	 * 根据队伍Id获取最近的比赛列表
	 * @param teamId
	 * @return
	 */
	public List<YsmsGames> getNextGamesByTeamId(int teamId);
	
	
	/**
	 * 根据队伍Id获取最近刚结束的比赛
	 * @param teamId
	 * @return
	 */
	public YsmsGames getLastGameByTeamId(int teamId);
	
	/**
	 * 根据队伍Id获取最近刚结束的比赛列表
	 * @param teamId
	 * @return
	 */
	public List<YsmsGames> getLastGamesByTeamId(int teamId);
	
	/**
	 * 根据球员Id获取他最近一场未开始的比赛
	 * @param athleteId
	 * @return
	 */
	public YsmsGames getNextGameByAthleteId(int athleteId);
	
	/**
	 * 根据球员Id获取他最近刚结束的比赛
	 * @param athleteId
	 * @return
	 */
	public YsmsGames getLastGameByAthleteId(int athleteId);
	
	/**
	 * 根据球员Id获取他最近未开始的比赛列表
	 * 限制不超过10条
	 * @param athleteId
	 * @return
	 */
	public List<YsmsGames> getNextGamesByAthleteId(int athleteId);
	
	/**
	 * 根据球员Id获取他最近刚结束的比赛列表
	 * 限制不超过10条
	 * @param athleteId
	 * @return
	 */
	public List<YsmsGames> getLastGamesByAthleteId(int athleteId);
	
	public List<YsmsGames> findByFuzzyQueryAndPage(Integer leagueId, Integer zoneId,
			Date date, Page page);
	
	/**
	 * @param leagueId
	 * @param zoneId
	 * @param date
	 * @param page
	 * @param judgeId
	 * @return
	 */
	public List<YsmsGames> findByFuzzyQueryAndPageForJudge(Integer leagueId, Integer zoneId, 
			Date date, Page page, int judgeId);
	
	/**
	 * 获取数量
	 * @param leagueId
	 * @param zoneId
	 * @param date
	 * @return
	 */
	public int getGamesCount(Integer leagueId, Integer zoneId, Date date);

	/**
	 * 获取全部比赛
	 * @return
	 */
	public List<YsmsGames> findAll();

	List<YsmsGames> getGamesBetweenDate(Date beginDate, Date endDate);

	List<YsmsGames> getGamesBySchoolIdBetweenDate(int schoolId, Date beginDate,
			Date endDate);
	
	/**
	 * 获取球队在某个日期前的比赛
	 * @param teamId
	 * @param date
	 * @return
	 */
	List<YsmsGames> getGamesByTeamIdBeforeDate(int teamId, Date date);
	
	/**
	 * 查询积分榜
	 * @param zoneId
	 * @param topHowMany 查询前几名
	 * @return
	 */
	List<ShooterRankView> getShooterRank(int zoneId, int topHowMany);

	/**
	 * 查询助攻榜
	 * @param zoneId
	 * @param topHowMany 查询前几名
	 * @return
	 */
	List<AssistRankView> getAssistRank(int zoneId, int topHowMany);

	/**
	 * @param leagueId
	 * @param zoneId
	 * @param date
	 * @param judgeId
	 * @return
	 */
	public int getMyGamesCount(Integer leagueId, Integer zoneId, Date date,
			int judgeId);
}
