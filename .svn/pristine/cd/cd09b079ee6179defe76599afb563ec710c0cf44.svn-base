package com.cwkj.ysms.dao;

import java.util.List;

import com.cwkj.ysms.basedao.GenericDao;
import com.cwkj.ysms.model.YsmsGoal;

public interface GoalDao extends GenericDao{
	
	/**
	 * 添加或修改一粒新进球
	 * @param ysmsGoal 比赛
	 */
	public void save(YsmsGoal ysmsGoal);
	
	/**
	 * 删除进球信息 
	 * @param ysmsGoal 比赛
	 */
	public void delete(YsmsGoal ysmsGoal);
	
	/**
	 * 根据进球Id查询进球信息
	 * @param goalId 进球Id
	 * @return 进球信息
	 */
	public YsmsGoal findById(int goalId);
	
	/**
	 * 根据进球运动员Id查询进球信息
	 * @param shooter_id 进球运动员Id
	 * @return 进球列表
	 */
	public List<YsmsGoal> findByShooter(int shooter_id);
	
	/**
	 * 根据助攻运动员Id查询进球信息
	 * @param assistant_id
	 * @return
	 */
	public List<YsmsGoal> findByAssistant(int assistant_id);
	
	/**
	 * 根据比赛查询进球信息
	 * @param game_id
	 * @return
	 */
	public List<YsmsGoal> findByGame(int game_id);
	
}
