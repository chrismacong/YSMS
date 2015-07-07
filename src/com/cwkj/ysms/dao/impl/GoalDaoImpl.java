package com.cwkj.ysms.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.cwkj.ysms.basedao.impl.GenericDaoImpl;
import com.cwkj.ysms.dao.GoalDao;
import com.cwkj.ysms.model.YsmsGoal;
import com.cwkj.ysms.model.YsmsLeague;

@Repository
public class GoalDaoImpl extends GenericDaoImpl implements GoalDao {
	private static final Log log = LogFactory.getLog(GoalDaoImpl.class);

	@Override
	public void save(YsmsGoal ysmsGoal) {
		// TODO Auto-generated method stub
		log.debug("saving YsmsGoal instance");
		try {
			getSession().saveOrUpdate(ysmsGoal);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	@Override
	public void delete(YsmsGoal ysmsGoal) {
		// TODO Auto-generated method stub
		log.debug("deleting YsmsGoal instance");
		try {
			getSession().delete(ysmsGoal);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	@Override
	public YsmsGoal findById(int goalId) {
		// TODO Auto-generated method stub
		log.debug("getting YsmsGoal instance with id: " + goalId);
		try {
			YsmsGoal result = (YsmsGoal) getSession()
					.get("com.cwkj.ysms.model.YsmsGoal", goalId);
			return result;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public List<YsmsGoal> findByShooter(int shooter_id) {
		// TODO Auto-generated method stub
		log.debug("finding YsmsGoal instance by shooter_id");
		try {
			String sql = " from YsmsGoal where shooter = "+shooter_id;
			List<Object> objects= findByHQL(sql);
			List<YsmsGoal> results = new ArrayList<YsmsGoal>();
			for(int i=0;i<objects.size();i++){
				YsmsGoal goal = (YsmsGoal)objects.get(i);
				results.add(goal);
			}
			log.debug("find by shooter_id successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by shooter_id failed", re);
			throw re;
		}
	}

	@Override
	public List<YsmsGoal> findByAssistant(int assistant_id) {
		// TODO Auto-generated method stub
		log.debug("finding YsmsGoal instance by assistant_id");
		try {
			String sql = " from YsmsGoal where assistant = "+assistant_id;
			List<Object> objects= findByHQL(sql);
			List<YsmsGoal> results = new ArrayList<YsmsGoal>();
			for(int i=0;i<objects.size();i++){
				YsmsGoal goal = (YsmsGoal)objects.get(i);
				results.add(goal);
			}
			log.debug("find by assistant_id successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by assistant_id failed", re);
			throw re;
		}
	}

	@Override
	public List<YsmsGoal> findByGame(int game_id) {
		// TODO Auto-generated method stub
		log.debug("finding YsmsGoal instance by game_id");
		try {
			String sql = " from YsmsGoal where games_id = "+game_id;
			List<Object> objects= findByHQL(sql);
			List<YsmsGoal> results = new ArrayList<YsmsGoal>();
			for(int i=0;i<objects.size();i++){
				YsmsGoal goal = (YsmsGoal)objects.get(i);
				results.add(goal);
			}
			log.debug("find by game_id successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by game_id failed", re);
			throw re;
		}
	}


}
