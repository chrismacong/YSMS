package com.cwkj.ysms.dao;

import java.util.List;
import java.util.Map;

import com.cwkj.ysms.basedao.GenericDao;
import com.cwkj.ysms.model.YsmsZoneTeam;

public interface ZoneTeamDao extends GenericDao{
	/**
	 * 添加新的联赛组组-队伍关系
	 * @param ysmsLeagueTeam 联赛组队伍实体
	 */
	public void save(YsmsZoneTeam ysmsLeagueTeam);
	
	/**
	 * 获取已报名的关联实体
	 * @return 结果列表
	 */
	public List<YsmsZoneTeam> getSignedTeam(int zoneId,int startIndex);
	
	
	public int getSignedTeamCount(int zoneId);
	
	/**
	 * 获取已参加的关联实体
	 * @return 结果列表
	 */
	public List<YsmsZoneTeam> getParticipatedTeam(int zoneId);
	
	public List<Map<String,Object>> seletedTeam(int zoneId,List<Integer> teamIds);
	
	/**
	 * 获取已参加的关联实体中名称符合条件的
	 * @return
	 */
	public List<YsmsZoneTeam> getTeamByIdAndName(int leagueId, String teamName);
	
	/**
	 * 获取已参加的关联实体所属学校符合条件的
	 * @return
	 */
	public List<YsmsZoneTeam> getTeamByIdAndSchoolName(int leagueId, String schoolName);
	

	/**
	 * 根据实力对象查询
	 * @param ysmsLeague
	 * @return 结果列表
	 */
	public List<YsmsZoneTeam> findByExample(YsmsZoneTeam ysmsZoneTeam);
	
	/**
	 * 根据Id查询关系
	 * @param detailId 主键Id
	 * @return 结果
	 */
	public YsmsZoneTeam findById(int detailId);
	
	/**
	 * 根据球队Id查询关系
	 * 一个球队只有可能参加一项赛事，因此至多有一个关系实体
	 * @param teamId 球队Id
	 * @return 结果
	 */
	public YsmsZoneTeam findByTeamId(int teamId);
	
	/**
	 * 删除球队联赛组关系
	 * @param ysmsLeagueTeam
	 */
	public void delete(YsmsZoneTeam ysmsZoneTeam);
	
	
	public boolean update(int zoneId,List<Integer> teamIds,String type);
	
	
	public void fixUpdate(int zoneId,List<Integer> teamIds);
}
