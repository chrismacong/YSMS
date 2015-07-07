package com.cwkj.ysms.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.cwkj.ysms.basedao.impl.GenericDaoImpl;
import com.cwkj.ysms.dao.CoachAttDao;
import com.cwkj.ysms.model.YsmsCoachAtt;
import com.cwkj.ysms.model.YsmsJudgeAtt;

@Repository
public class CoachAttDaoImpl extends GenericDaoImpl implements CoachAttDao{
	private static final Log log = LogFactory.getLog(CoachAttDaoImpl.class);
	@Override
	public void save(YsmsCoachAtt ysmsCoachAtt) {
		log.debug("saving YsmsCoachAtt instance");
		try {
			getSession().saveOrUpdate(ysmsCoachAtt);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	@Override
	public YsmsCoachAtt findByCoachId(int CoachId) {
		log.debug("finding YsmsCoachAtt instance by coachId");
		try {
			String sql = " from YsmsCoachAtt as yap where yap.ysmsCoach.coachId = '"+CoachId
					+"'";
			List<Object> objects= findByHQL(sql);
			List<YsmsCoachAtt> results = new ArrayList<YsmsCoachAtt>();
			for(int i=0;i<objects.size();i++){
				YsmsCoachAtt ysmsCoachAtt = (YsmsCoachAtt)objects.get(i);
				results.add(ysmsCoachAtt);
			}
			log.debug("find by coachId successful, result size: " + results.size());
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
	public void delete(YsmsCoachAtt ysmsCoachAtt) {
		log.debug("deleting YsmsCoachPhoto instance");
		try {
			getSession().delete(ysmsCoachAtt);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

}
