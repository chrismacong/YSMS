package com.cwkj.ysms.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import com.cwkj.ysms.basedao.GenericDao;
import com.cwkj.ysms.model.YsmsLeague;
import com.cwkj.ysms.util.Page;

public interface LeagueDao extends GenericDao{
	/**
	 * 保存或更新联赛
	 * @param ysmsLeague 联赛实体
	 */
	public void save(YsmsLeague ysmsLeague);
	
	/**
	 * 删除联赛
	 * @param ysmsLeague 联赛Id
	 */
	public void delete(YsmsLeague ysmsLeague);
	
	/**
	 * 根据Id查询联赛
	 * @param leagueId 联赛Id
	 * @return 查询结果
	 */
	public YsmsLeague findById(int leagueId);
	
	/**
	 * 查询全部联赛
	 * @return 结果列表
	 */
	public List<YsmsLeague> findAll();
	
	/**
	 * 根据年份查询联赛
	 * @param year 年份
	 * @return 结果列表
	 */
	public List<YsmsLeague> findByLeagueYear(int year);
	
	/**
	 * 根据联赛等级查询联赛
	 * @param level 联赛等级
	 * 1=男子二年级, 2=女子二年级, 3=男子三年级, 4=女子三年级, 5=男子四年级, 6=女子四年级, 7=男子五年级, 8=女子五年级
	   9=男子六年级, 10=女子六年级, 11=男子七年级, 12=女子七年级, 13=男子八年级, 14=女子八年级, 15=高中男子, 16=高中女子
	 * @return 结果列表
	 */
	public List<YsmsLeague> findByLeagueLevel(int level);
	
	/**
	 * 根据分页信息查询所有联赛
	 * @param page 分页信息
	 * @return 结果列表
	 */
	public List<YsmsLeague> findAllByPage(Page page);
	
	/**
	 * 根据年份和分页信息查询所有联赛
	 * @param year 年份
	 * @param page 分页信息
	 * @return 结果列表
	 */
	public List<YsmsLeague> findByLeagueYearAndPage(int year, Page page);
}
