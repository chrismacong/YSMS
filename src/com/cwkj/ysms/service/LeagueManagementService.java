package com.cwkj.ysms.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.cwkj.ysms.model.YsmsGames;
import com.cwkj.ysms.model.YsmsLeague;
import com.cwkj.ysms.model.YsmsLeagueLevel;
import com.cwkj.ysms.model.YsmsZoneTeam;
import com.cwkj.ysms.model.view.LeagueView;
import com.cwkj.ysms.model.view.ZoneView;
import com.cwkj.ysms.util.Page;

/**
 * 联赛管理Service接口
 * 负责对联赛进行增删改查和队伍分组过程
 * @author chrismacong
 * @since 2015-3-5
 *
 */
public interface LeagueManagementService {
	/**
	 * 添加新联赛
	 * @param leagueYear 联赛年份，4位int型
	 * @param leagueTotal 总场次，表明比赛的轮数。如每个球队需要3场小组赛和3场淘汰赛决出总冠军，则需要6场比赛
	 * @param registerBeginTime 报名开始时间
	 * @param registerEndTime 报名结束时间
	 * @return 操作结果，true表示成功
	 */
	public boolean addLeague(int leagueYear, String leagueName, int leagueTotal, 
			Date registerBeginTime, Date registerEndTime);
	
	/**
	 * 删除联赛
	 * @param leagueId 联赛Id
	 * @return 操作结果，true表示成功
	 */
	public boolean deleteLeague(int leagueId);
	
	/**
	 * 查看联赛信息修改是否被允许
	 * 在当前日期处于允许修改联赛信息的时间段内，不可对联赛进行修改操作，只能进行删除操作或报名时间修改操作
	 * @param leagueId 联赛Id
	 * @return 是否允许。 true为允许
	 */
	public boolean isModifyPermitted(int leagueId);
	
	/**
	 * 查看联赛报名是否已结束
	 * @param leagueId 联赛Id
	 * @return 是否结束。 true为已结束
	 */
	public boolean isRegisterEnd(int leagueId);
	
	/**
	 * 修改联系信息
	 * @param leagueId 联赛Id
	 * @param leagueYear 联赛年份
	 * @param registerBeginTime 报名开始时间
	 * @param registerEndTime 报名结束时间
	 * @return
	 */
	public boolean modifyLeague(int leagueId, int leagueYear, String leagueName, 
			Date registerBeginTime, Date registerEndTime, Date leagueBeginTime, Date leagueEndTime,
			String leagueDescription);
	
	
	/**
	 * 根据球队总数计算总场次
	 * @param totalTeams 总球队数
	 * @return 总场次
	 */
	public int calulatorLeagueTotal(int totalTeams);
	
	/**
	 * 修改联赛报名时间信息和名称
	 * 在报名已经开始，并且有球队报名时，仅可进行此修改
	 * @param leagueId 联赛Id
	 * @param registerEndTime 报名结束时间
	 * @return
	 */
	public boolean modifyLeagueRegisterDateAndName(int leagueId, String leagueName, Date registerEndTime);
	
	/**
	 * 获取所有联赛
	 * @return 联赛list
	 */
	public List<YsmsLeague> getAllLeagues();
	
	/**
	 * 根据分页信息获取联赛
	 * @param page 分页实体
	 * @return 联赛list
	 */
	public List<YsmsLeague> getLeaguesByPage(Page page);
	
	/**
	 * 获取某一年的所有联赛
	 * @param year 年份
	 * @return 联赛list
	 */
	public List<YsmsLeague> getYearlyLeagues(int year);
	
	/**
	 * 根据分页信息获取某一年的联赛视图
	 * 用于学校用户查询联赛，判断是否可以参加或者是否已经报名
	 * @param year 年份
	 * @param schoolId 学校Id
	 * @return 联赛list
	 */
	public List<LeagueView> getYearlyLeagueViews(int year, int schoolId);
	
	/**
	 * 根据分页信息获取某一年的联赛
	 * @param year 年份
	 * @param page 分页实体
	 * @return 联赛list
	 */
	public List<YsmsLeague> getYearlyLeaguesByPage(int year, Page page);
	
	/**
	 * 球队分组
	 * @param leagueId 联赛id
	 * @param groupedTeams 联赛分组表。map中的key值为组别index， value值为逗号分隔的球队Id
	 * @param promotionTeamNum 每组出线球队数
	 * @param isDoubleRound 是否双循环
	 * @return 比赛list
	 */
	public List<YsmsGames> groupTeamsForZone(int zoneId, Map groupedTeams, 
			int promotionTeamNum, boolean isDoubleRound);
	
	/**
	 * 球队分组简单方法
	 * 不产生比赛
	 * @param leagueId
	 * @param groupedTeams
	 * @return
	 */
	public boolean groupTeamsForZone(int zoneId, Map<String,Object> groupedTeams);
	/**
	 * 根据联赛Id获取联赛信息
	 * @param leagueId 联赛Id
	 * @return 联赛实体
	 */
	public YsmsLeague getLeagueById(int leagueId);
	
	/**
	 * 根据联赛Id获取联赛级别
	 * @param leagueId 联赛Id
	 * @return
	 */
	public List<ZoneView> getZonesByLeague(int leagueId);
	
	/**
	 * 获取所有年级
	 * @return
	 */
	public List<YsmsLeagueLevel> getAllLevels();
	
	/**
	 * 添加联赛组
	 * 
	 * @param leagueId
	 * @param zoneName
	 * @param levelIndexes
	 * @return
	 */
	public boolean addZone(int leagueId, String zoneName, String[] levelIndexes, int maxAthleteNum);
	
	/**
	 * 修改联赛组
	 * @param zoneId
	 * @param zoneName
	 * @param levelIndexes
	 * @return
	 */
	public boolean modifyZone(int zoneId, String zoneName, String[] levelIndexes);
	
	/**
	 * 删除联赛组
	 * @param zoneId
	 * @return
	 */
	public boolean deleteZone(int zoneId);

	/**
	 * 根据联赛Id和学校Id获取联赛组别
	 * 需要根据学校Id判断是否具备报名参加各个组别的条件，需要根据联赛Id判断是否在报名开始日后，报名截止日前
	 * @param leagueId 联赛Id
	 * @param schoolId 学校Id
	 * @return
	 */
	public List<ZoneView> getZonesByLeagueAndSchool(int leagueId, int schoolId);
	
	
	public List<Map<String,Object>> getNotSelectedTeams(int zoneId,List<Integer> teamIds);
	
	/**
	 * 获取小组中的组别列表
	 * @param zoneId
	 * @return
	 */
	public List<String> getDistinctGroupsOfZone(int zoneId);
	
	/**
	 * 获取小组排名规则
	 * @param zoneId
	 * @return
	 */
	public String getListRuleOrder(int zoneId);
	
	/**
	 * 设置小组排名规则
	 * @param zoneId
	 * @param ruleOrder
	 * @return
	 */
	public boolean setListRuleOrder(int zoneId, String ruleOrder);
}
