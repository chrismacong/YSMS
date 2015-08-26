package com.cwkj.ysms.service;

import java.util.List;

import com.cwkj.ysms.model.YsmsGames;
import com.cwkj.ysms.model.YsmsLeagueZone;
import com.cwkj.ysms.model.view.AssistRankView;
import com.cwkj.ysms.model.view.MarkItemView;
import com.cwkj.ysms.model.view.ShooterRankView;

/**
 * 赛事统计Service接口
 * 各项数据统计
 * @author chrismacong
 * @since 2015-3-5
 *
 */
/**
 * @author Administrator
 *
 */
public interface GamesStatisticsService {
	/**
	 * 查询某球员在一项赛事中的总进球数
	 * @param zoneId 联赛组Id
 	 * @param athleteId 球员Id
	 * @return 结果
	 */
	public int getAthleteGoalsInZone(int zoneId, int athleteId);
	
	/**
	 * 查询某球员在一项赛事中的总助攻数
	 * @param zoneId 联赛组Id
 	 * @param athleteId 球员Id
	 * @return 结果
	 */
	
	public int getAthleteAssistsInZone(int zoneId, int athleteId);
	/**
	 * 查询某球员在一项赛事中的总黄牌数
	 * @param zoneId 联赛组Id
 	 * @param athleteId 球员Id
	 * @return 结果
	 */
	public int getAthleteYellowCardsInZone(int zoneId, int athleteId);
	
	/**
	 * 查询某球员在一项赛事中的总红牌数
	 * @param zoneId 联赛组Id
 	 * @param athleteId 球员Id
	 * @return 结果
	 */
	public int getAthleteRedCardsInZone(int zoneId, int athleteId);
	
	/**
	 * 查询某球员参加过的赛事
	 * @param athleteId 球员Id
	 * @return 结果
	 */
	public List<YsmsLeagueZone> getAthletePresentation(int athleteId);
	
	/**
	 * 查询某教练参加过的赛事
	 * @param coachId 教练Id
	 * @return 结果
	 */
	public List<YsmsLeagueZone> getCoachPresentation(int coachId);
	
	/**
	 * 查询某教练的执教生涯胜率
	 * @param coachId 教练Id
 	 * @return 结果[胜率，平率，负率]
	 */
	public double[] getCoachWinningPercentage(int coachId);
	
	/**
	 * 查询球队在赛事中的比赛信息
	 * @param teamId 球队Id
	 * @param zoneId 联赛组Id
	 * @return 比赛信息List
	 */
	public List<YsmsGames> getTeamGamesInZone(int teamId);	
	
	/**
	 * 查询某球队在一项赛事中的总进球数
	 * @param  zoneId 联赛组Id
 	 * @param teamId 球队Id
	 * @return 结果
	 */
	public int getTeamGoalsInZone(int teamId);
	
	/**
	 * 查询某球队在一项赛事中的总黄牌数
	 * @param  zoneId 联赛组Id
 	 * @param teamId 球队Id
	 * @return 结果
	 */
	public int getTeamYellowCardsInZone(int teamId);
	
	/**
	 * 查询某球队在一项赛事中的总红牌数
	 * @param zoneId 联赛组Id
 	 * @param teamId 球队Id
	 * @return 结果
	 */
	public int getTeamRedCardsInZone(int teamId);

	/**
	 * 查询某裁判参加过的赛事
	 * @param judgeId 裁判Id
	 * @return 赛事List
	 */
	public List<YsmsLeagueZone> getJudgePresentation(int judgeId);
	
	/**
	 * 查询某裁判在某赛事中执法过的比赛
	 * @param judgeId 裁判Id
	 * @param  zoneId 联赛组Id
	 * @return 比赛List
	 */
	public List<YsmsGames> getJudgeGamesInZone(int judgeId, int zoneId);
	
	/**
	 * 查询某学校的历史比赛总胜率
	 * @param schoolId 学校Id
	 * @return 结果[胜率，平率，负率]
	 */
	public double[] getTotalWinningPercentageBySchool(int schoolId);
	
	/***
	 * 获取某个小组的积分榜
	 * @param zoneId
	 * @param groupName
	 * @return
	 */
	public List<MarkItemView> getLeagueTable(int zoneId, String groupName);
	
	/**
	 * 获取射手榜 
	 * @param zoneId
	 * @return
	 */
	public List<ShooterRankView> getShooterRank(int zoneId, int topHowMany);
	
	/**
	 * 获取助攻榜
	 * @param zoneId
	 * @param topHowMany
	 * @return
	 */
	public List<AssistRankView> getAssistRank(int zoneId, int topHowMany);
}
