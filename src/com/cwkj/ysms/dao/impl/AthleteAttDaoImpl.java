package com.cwkj.ysms.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.cwkj.ysms.basedao.impl.GenericDaoImpl;
import com.cwkj.ysms.dao.AthleteAttDao;
import com.cwkj.ysms.model.YsmsAthleteAtt;

@Repository
public class AthleteAttDaoImpl extends GenericDaoImpl implements AthleteAttDao{
	private static final Log log = LogFactory.getLog(AthleteAttDaoImpl.class);
	@Override
	public void save(YsmsAthleteAtt ysmsAthleteAtt) {
		log.debug("saving YsmsAthleteAtt instance");
		try {
			getSession().saveOrUpdate(ysmsAthleteAtt);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	@Override
	public YsmsAthleteAtt findByAthleteId(int athleteId) {
		log.debug("finding YsmsAthleteAtt instance by athleteId");
		try {
			String sql = " from YsmsAthleteAtt as yap where yap.ysmsAthlete.athleteId = '"+athleteId
					+"'";
			sql+=" order by yap.ysmsAthlete.athleteId ";
			List<Object> objects= findByHQL(sql);
			List<YsmsAthleteAtt> results = new ArrayList<YsmsAthleteAtt>();
			for(int i=0;i<objects.size();i++){
				YsmsAthleteAtt ysmsAthleteAtt = (YsmsAthleteAtt)objects.get(i);
				results.add(ysmsAthleteAtt);
			}
			log.debug("find by athleteId successful, result size: " + results.size());
			if(results.size()>0){
				return results.get(0);
			}
			else
				return null;
		} catch (RuntimeException re) {
			log.error("find by identifiedId failed", re);
			throw re;
		}
	}

	@Override
	public void delete(YsmsAthleteAtt ysmsAthleteAtt) {
		log.debug("deleting YsmsAthleteAtt instance");
		try {
			getSession().delete(ysmsAthleteAtt);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

}
