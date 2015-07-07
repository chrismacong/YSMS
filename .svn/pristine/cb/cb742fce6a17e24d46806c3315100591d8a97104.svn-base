package com.cwkj.ysms.dao;

import java.util.List;

import com.cwkj.ysms.basedao.GenericDao;
import com.cwkj.ysms.model.YsmsLeagueZone;
import com.cwkj.ysms.util.Page;

public interface LeagueZoneDao extends GenericDao{
	/**
	 * 保存或更新联赛
	 * @param ysmsLeague 联赛实体
	 */
	public void save(YsmsLeagueZone ysmsLeagueZone);
	
	/**
	 * 删除联赛
	 * @param ysmsLeague 联赛Id
	 */
	public void delete(YsmsLeagueZone ysmsLeagueZone);
	
	/**
	 * 根据Id查询联赛
	 * @param zoneId 联赛组Id
	 * @return 查询结果
	 */
	public YsmsLeagueZone findById(int zoneId);
	
	/**
	 * 查询全部联赛组
	 * @return 结果列表
	 */
	public List<YsmsLeagueZone> findAll();
	
	/**
	 * 根据联赛查询联赛组
	 * @param year 年份
	 * @return 结果列表
	 */
	public List<YsmsLeagueZone> findByLeagueId(int leagueId);
	
	/**
	 * 根据分页信息查询所有联赛组
	 * @param page 分页信息
	 * @return 结果列表
	 */
	public List<YsmsLeagueZone> findAllByPage(Page page);
}
