package com.cwkj.ysms.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cwkj.ysms.basedao.impl.GenericDaoImpl;
import com.cwkj.ysms.dao.LeagueLevelDao;
import com.cwkj.ysms.model.YsmsJobs;
import com.cwkj.ysms.model.YsmsLeagueLevel;

@Repository
public class LeagueLevelDaoImpl extends GenericDaoImpl implements LeagueLevelDao {
	private static final Log log = LogFactory.getLog(LeagueLevelDaoImpl.class);
	
	@Override
	public YsmsLeagueLevel findById(Integer levelId) {
		log.debug("getting YsmsLeagueLevel instance with levelId: " + levelId);
		try {
			YsmsLeagueLevel result = (YsmsLeagueLevel) getSession()
					.get("com.cwkj.ysms.model.YsmsLeagueLevel", levelId);
			return result;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public List<YsmsLeagueLevel> findAll() {
		log.debug("finding all YsmsLeagueLevel instances");
		try {
			String queryString = "from YsmsLeagueLevel where 0=0";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

}
