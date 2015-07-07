package com.cwkj.ysms.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cwkj.ysms.basedao.impl.GenericDaoImpl;
import com.cwkj.ysms.dao.JobsDao;
import com.cwkj.ysms.model.YsmsJobs;

@Repository
public class JobsDaoImpl extends GenericDaoImpl implements JobsDao {
	private static final Log log = LogFactory.getLog(JobsDaoImpl.class);
	
	@Override
	public YsmsJobs findById(Integer jobId) {
		log.debug("getting YsmsJobs instance with jobId: " + jobId);
		try {
			YsmsJobs result = (YsmsJobs) getSession()
					.get("com.cwkj.ysms.model.YsmsJobs", jobId);
			return result;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public List<YsmsJobs> findAllBesidesStudent() {
		log.debug("finding all YsmsJobs instances");
		try {
			String queryString = "from YsmsJobs j where j.jobId<=100";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	@Override
	public List<YsmsJobs> findAll() {
		// TODO Auto-generated method stub
		log.debug("finding all YsmsJobs instances");
		try {
			String queryString = "from YsmsJobs where 0=0";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

}
