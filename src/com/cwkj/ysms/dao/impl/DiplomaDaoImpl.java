package com.cwkj.ysms.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cwkj.ysms.basedao.impl.GenericDaoImpl;
import com.cwkj.ysms.dao.DiplomaDao;
import com.cwkj.ysms.model.YsmsDiploma;
import com.cwkj.ysms.model.YsmsJobs;

@Repository
public class DiplomaDaoImpl extends GenericDaoImpl implements
		DiplomaDao {
	private static final Log log = LogFactory.getLog(DiplomaDaoImpl.class);
	
	@Override
	public YsmsDiploma findById(Integer diplomaId) {
		log.debug("getting YsmsDiploma instance with diplomaId: " + diplomaId);
		try {
			YsmsDiploma result = (YsmsDiploma) getSession()
					.get("com.cwkj.ysms.model.YsmsDiploma", diplomaId);
			return result;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public List<YsmsDiploma> findAll() {
		// TODO Auto-generated method stub
		log.debug("finding all YsmsDiploma instances");
		try {
			String queryString = "from YsmsDiploma where 0=0";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

}
