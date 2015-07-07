package com.cwkj.ysms.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cwkj.ysms.basedao.impl.GenericDaoImpl;
import com.cwkj.ysms.dao.FoulDao;
import com.cwkj.ysms.model.YsmsFoul;

@Repository
public class FoulDaoImpl extends GenericDaoImpl implements FoulDao {
	private static final Log log = LogFactory.getLog(FoulDaoImpl.class);

	@Override
	public void save(YsmsFoul ysmsFoul) {
		log.debug("saving YsmsFoul instance");
		try {
			getSession().saveOrUpdate(ysmsFoul);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	@Override
	public void delete(YsmsFoul ysmsFoul) {
		log.debug("deleting YsmsFoul instance");
		try {
			getSession().delete(ysmsFoul);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	@Override
	public YsmsFoul findById(int foulId) {
		log.debug("getting YsmsFoul instance with id: " + foulId);
		try {
			YsmsFoul result = (YsmsFoul) getSession()
					.get("com.cwkj.ysms.model.YsmsFoul", foulId);
			return result;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public List<YsmsFoul> findAll() {
		log.debug("finding all YsmsFoul instances");
		try {
			String queryString = "from YsmsFoul";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	@Override
	public List<YsmsFoul> getYsmsFoulsByGamesId(int gamesId) {
		log.debug("finding YsmsFoul instances by gamesId");
		try {
			String queryString = "from YsmsFoul y where y.ysmsGames.gamesId = " + gamesId;
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find YsmsFoul instances failed", re);
			throw re;
		}
	}

	@Override
	public List<YsmsFoul> getYsmsFoulsByAthleteId(int athleteId) {
		log.debug("finding YsmsFoul instances by athleteId");
		try {
			String queryString = "from YsmsFoul y where y.ysmsAthlete.athleteId = " + athleteId;
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find YsmsFoul instances failed", re);
			throw re;
		}
	}

	@Override
	public List<YsmsFoul> findByGame(int gamesId) {
		log.debug("finding YsmsFoul instance by game_id");
		try {
			String sql = " from YsmsFoul where games_id = "+gamesId;
			List<Object> objects= findByHQL(sql);
			List<YsmsFoul> results = new ArrayList<YsmsFoul>();
			for(int i=0;i<objects.size();i++){
				YsmsFoul foul = (YsmsFoul)objects.get(i);
				results.add(foul);
			}
			log.debug("find by game_id successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by game_id failed", re);
			throw re;
		}
	}

}
