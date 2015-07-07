package com.cwkj.ysms.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.cwkj.ysms.basedao.impl.GenericDaoImpl;
import com.cwkj.ysms.dao.GamesJudgeDao;
import com.cwkj.ysms.model.YsmsGamesJudge;
import com.cwkj.ysms.model.YsmsJudge;

@Repository
public class GamesJudgeDaoImpl extends GenericDaoImpl implements GamesJudgeDao {
	private static final Log log = LogFactory.getLog(GamesJudgeDaoImpl.class);
	@Override
	public List<YsmsJudge> getJudgesByGameId(int gamesId) {
		log.debug("finding YsmsJudge instance by gamesId");
		try {
			String sql = " from YsmsGamesJudge gj where gj.ysmsGames.gamesId = "+gamesId;
			List<Object> objects= findByHQL(sql);
			List<YsmsGamesJudge> results = new ArrayList<YsmsGamesJudge>();
			for(int i=0;i<objects.size();i++){
				YsmsGamesJudge gameJudge = (YsmsGamesJudge)objects.get(i);
				results.add(gameJudge);
			}
			log.debug("find by teamId successful, result size: " + results.size());
			List<YsmsJudge> judgeList = new ArrayList<YsmsJudge>();
			for(int i=0;i<results.size();i++){
				judgeList.add(results.get(i).getYsmsJudge());
			}
			return judgeList;
		} catch (RuntimeException re) {
			log.error("find by gamesId failed", re);
			throw re;
		}
	}

	@Override
	public void save(YsmsGamesJudge ysmsGamesJudge) {
		log.debug("saving YsmsGamesJudge instance");
		try {
			getSession().saveOrUpdate(ysmsGamesJudge);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
		
	}

	@Override
	public void delete(YsmsGamesJudge ysmsGamesJudge) {
		log.debug("deleting YsmsGamesJudge instance");
		try {
			getSession().delete(ysmsGamesJudge);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	@Override
	public YsmsGamesJudge getJudgeRelationByIdAndGameId(int gameId, int judgeId) {
		// TODO Auto-generated method stub
		log.debug("finding YsmsGamesJudge instance by gamesId and judgeId");
		try {
			String sql = " from YsmsGamesJudge gj where gj.ysmsGames.gamesId = " + gameId + 
					" and gj.ysmsJudge.judgeId = " + judgeId;
			List<Object> objects= findByHQL(sql);
			List<YsmsGamesJudge> results = new ArrayList<YsmsGamesJudge>();
			for(int i=0;i<objects.size();i++){
				YsmsGamesJudge gameJudge = (YsmsGamesJudge)objects.get(i);
				results.add(gameJudge);
			}
			if(results.size()>0)
				return results.get(0);
			else
				return null;
		} catch (RuntimeException re) {
			log.error("find by gamesId and judgeId failed", re);
			throw re;
		}
	}

	@Override
	public List<YsmsGamesJudge> getJudgeRelationsByJudgeId(int judgeId) {
		log.debug("finding YsmsGamesJudge instances by judgeId");
		try {
			String sql = " from YsmsGamesJudge gj where gj.ysmsJudge.judgeId = " + judgeId;
			List<Object> objects= findByHQL(sql);
			List<YsmsGamesJudge> results = new ArrayList<YsmsGamesJudge>();
			for(int i=0;i<objects.size();i++){
				YsmsGamesJudge gameJudge = (YsmsGamesJudge)objects.get(i);
				results.add(gameJudge);
			}
			return results;
		} catch (RuntimeException re) {
			log.error("find by judgeId failed", re);
			throw re;
		}
	}
}
