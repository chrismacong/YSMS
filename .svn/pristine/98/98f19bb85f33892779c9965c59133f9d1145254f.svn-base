package com.cwkj.ysms.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cwkj.ysms.basedao.impl.GenericDaoImpl;
import com.cwkj.ysms.dao.LeagueZoneDao;
import com.cwkj.ysms.model.YsmsLeagueZone;
import com.cwkj.ysms.util.Page;

@Repository
public class LeagueZoneDaoImpl extends GenericDaoImpl implements LeagueZoneDao{
	private static final Log log = LogFactory.getLog(LeagueZoneDaoImpl.class);
	@Override
	public void save(YsmsLeagueZone ysmsLeagueZone) {
		log.debug("saving YsmsLeagueZone instance");
		try {
			getSession().saveOrUpdate(ysmsLeagueZone);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	@Override
	public void delete(YsmsLeagueZone ysmsLeagueZone) {
		log.debug("deleting YsmsLeagueZone instance");
		try {
			getSession().delete(ysmsLeagueZone);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	@Override
	public YsmsLeagueZone findById(int zoneId) {
		// TODO Auto-generated method stub
		log.debug("getting YsmsLeagueZone instance with id: " + zoneId);
		try {
			YsmsLeagueZone result = (YsmsLeagueZone) getSession()
					.get("com.cwkj.ysms.model.YsmsLeagueZone", zoneId);
			return result;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public List<YsmsLeagueZone> findAll() {
		log.debug("finding all YsmsLeagueZone instances");
		try {
			String queryString = "from YsmsLeagueZone";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	@Override
	public List<YsmsLeagueZone> findByLeagueId(int leagueId) {
		log.debug("finding YsmsLeagueZone instance by leagueId");
		try {
			String sql = " from YsmsLeagueZone as lz where lz.deleteflag = 0 and lz.ysmsLeague.leagueId = "+leagueId;
			List<Object> objects= findByHQL(sql);
			List<YsmsLeagueZone> results = new ArrayList<YsmsLeagueZone>();
			for(int i=0;i<objects.size();i++){
				YsmsLeagueZone leagueZone = (YsmsLeagueZone)objects.get(i);
				results.add(leagueZone);
			}
			log.debug("find by leagueId successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by leagueId failed", re);
			throw re;
		}
	}

	@Override
	public List<YsmsLeagueZone> findAllByPage(Page page) {
		// TODO Auto-generated method stub
		log.debug("finding all YsmsLeagueZone instances");
		try {
			String queryString = "from YsmsLeagueZone";
			Query queryObject = getSession().createQuery(queryString);
			if(page != null){
				queryObject.setMaxResults(page.getEveryPage());
				queryObject.setFirstResult(page.getBeginIndex());
			}
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

}
