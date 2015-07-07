package com.cwkj.ysms.dao;

import java.util.List;

import com.cwkj.ysms.basedao.GenericDao;
import com.cwkj.ysms.model.YsmsLeagueLevel;

public interface LeagueLevelDao extends GenericDao{
	/**
	 * 查询
	 * @param levelId 年级id
	 * @return
	 */
	public YsmsLeagueLevel findById(Integer levelId);
	
	/**
	 * 获取全部年级列表
	 * @return 年级list
	 */
	public List<YsmsLeagueLevel> findAll();
}
