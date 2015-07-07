package com.cwkj.ysms.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.cwkj.ysms.basedao.impl.GenericDaoImpl;
import com.cwkj.ysms.dao.ZoneLevelDao;
import com.cwkj.ysms.model.YsmsZoneLevel;

@Repository
public class ZoneLevelDaoImpl extends GenericDaoImpl implements ZoneLevelDao{
	private static final Log log = LogFactory.getLog(ZoneLevelDaoImpl.class);
	@Override
	public void save(YsmsZoneLevel ysmsZoneLevel) {
		log.debug("saving YsmsZoneLevel instance");
		try {
			getSession().saveOrUpdate(ysmsZoneLevel);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	@Override
	public List<YsmsZoneLevel> findByZoneId(int zoneId) {
		log.debug("finding signed YsmsZoneLevel");
		try {
			String sql = " from YsmsZoneLevel where zone_id = "+ zoneId;
			List<Object> objects= findByHQL(sql);
			List<YsmsZoneLevel> results = new ArrayList<YsmsZoneLevel>();
			if(objects.size()>0){
				for(int i=0;i<objects.size();i++){
					YsmsZoneLevel zoneLevel = (YsmsZoneLevel)objects.get(i);
					results.add(zoneLevel);
				}
				return results;
			}
			log.debug("find signed YsmsZoneLevel successful, result size: " + results.size());
			return null;
		} catch (RuntimeException re) {
			log.error("find signed YsmsZoneLevel failed", re);
			throw re;
		}
	}

	@Override
	public void delete(YsmsZoneLevel ysmsZoneLevel) {
		log.debug("deleting YsmsZoneLevel instance");
		try {
			getSession().delete(ysmsZoneLevel);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

}
