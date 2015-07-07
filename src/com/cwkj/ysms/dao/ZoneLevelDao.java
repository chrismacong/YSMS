package com.cwkj.ysms.dao;

import java.util.List;

import com.cwkj.ysms.basedao.GenericDao;
import com.cwkj.ysms.model.YsmsZoneLevel;

public interface ZoneLevelDao extends GenericDao{
	/**
	 * 添加新的级别-等级关系
	 * @param ysmsLeagueTeam 联赛组队伍实体
	 */
	public void save(YsmsZoneLevel ysmsZoneLevel);
	
	/**
	 * 根据zoneId获取所有等级
	 * @param zoneId
	 * @return
	 */
	public List<YsmsZoneLevel> findByZoneId(int zoneId);
	
	/**
	 * 删除级别-等级关系
	 * @param ysmsZoneLevel
	 */
	public void delete(YsmsZoneLevel ysmsZoneLevel);
}
