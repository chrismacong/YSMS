package com.cwkj.ysms.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cwkj.ysms.basedao.impl.GenericDaoImpl;
import com.cwkj.ysms.dao.TeamDao;
import com.cwkj.ysms.model.YsmsTeam;
import com.cwkj.ysms.model.YsmsZoneTeam;

@Repository
public class TeamDaoImpl extends GenericDaoImpl implements TeamDao{
	private static final Log log = LogFactory.getLog(TeamDaoImpl.class);
	@Override
	public void save(YsmsTeam ysmsTeam) {
		// TODO Auto-generated method stub
		log.debug("saving YsmsTeam instance");
		try {
			getSession().saveOrUpdate(ysmsTeam);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	@Override
	public void delete(YsmsTeam ysmsTeam) {
		// TODO Auto-generated method stub
		log.debug("deleting YsmsTeam instance");
		try {
			getSession().delete(ysmsTeam);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	@Override
	public YsmsTeam findById(int teamId) {
		// TODO Auto-generated method stub
		log.debug("getting YsmsTeam instance with id: " + teamId);
		try {
			YsmsTeam result = (YsmsTeam) getSession()
					.get("com.cwkj.ysms.model.YsmsTeam", teamId);
			return result;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public List<YsmsTeam> findAll() {
		// TODO Auto-generated method stub
		log.debug("finding all YsmsTeam instances");
		try {
			String queryString = "from YsmsTeam";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	@Override
	public List<YsmsTeam> findBySchoolId(int school_id) {
		// TODO Auto-generated method stub
		log.debug("finding YsmsTeam instance by school_id");
		try {
			String sql = " from YsmsTeam where school_id = " + school_id;
			List<Object> objects= findByHQL(sql);
			List<YsmsTeam> results = new ArrayList<YsmsTeam>();
			for(int i=0;i<objects.size();i++){
				YsmsTeam team = (YsmsTeam)objects.get(i);
				results.add(team);
			}
			log.debug("find by school_id successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by school_id failed", re);
			throw re;
		}
	}

	@Override
	public YsmsZoneTeam findBySchoolIdAndZoneId(int school_id,
			int zone_id) {
		log.debug("finding LeagueTeam instance by school_id and zone_id");
		try {
			String sql = "select zt from YsmsTeam t, YsmsZoneTeam zt" + 
					" where t.ysmsSchool.schoolId = " +  school_id + 
					" and zt.ysmsTeam.teamId = t.teamId" +
					" and zt.ysmsLeagueZone.zoneId = " + zone_id;
			Query query = getSession().createQuery(sql);
			List<YsmsZoneTeam> objects = query.list();
			if (objects.size() < 1) {
				return null;
			}
			YsmsZoneTeam result = objects.get(0);
			log.debug("find by  school_id and zone_id after date successful, gamesId: " + result.getDetailId());
			return result;
		} catch (RuntimeException re) {
			log.error("find by  school_id and zone_id after date failed", re);
			throw re;
	}
	}

	@Override
	public List<YsmsTeam> findByZoneIdandGroupBesidesSelected(Integer zoneId, String groupName, 
			Integer[] selectedTeamIds) {
		log.debug("finding YsmsTeam instance by school_id");
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("select yt from YsmsTeam yt, YsmsZoneTeam yzt where yt.teamId=yzt.ysmsTeam.teamId and yzt.zoneGroup is not null and yzt.zoneGroup !='0'");
			if(zoneId!=null){
				sql.append(" and yzt.ysmsLeagueZone.zoneId="+ zoneId);
			}
			if(groupName!=null&&!"".equals(groupName)){
				sql.append(" and yzt.zoneGroup='" + groupName + "'"); 
			}
			if(selectedTeamIds.length>0){
				String ids = "";
				for(int i=0;i<selectedTeamIds.length;i++){
					Integer selectedTeamId = selectedTeamIds[i];
					if(selectedTeamId!=null){
						ids = ids + selectedTeamId + ",";
					}
				}
				if(ids.length()>0){
					ids = ids.substring(0,ids.lastIndexOf(","));
					sql.append(" and yt.teamId not in (" + ids + ")");
				}
			}
			List<Object> objects= findByHQL(sql.toString()); 
			List<YsmsTeam> results = new ArrayList<YsmsTeam>();
			for(int i=0;i<objects.size();i++){
				YsmsTeam team = (YsmsTeam)objects.get(i);
				results.add(team);
			}
			log.debug("find by school_id successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by school_id failed", re);
			throw re;
		}
	}

}
