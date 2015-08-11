package com.cwkj.ysms.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cwkj.ysms.basedao.impl.GenericDaoImpl;
import com.cwkj.ysms.dao.WechatnewsDao;
import com.cwkj.ysms.model.YsmsWechatnews;
@Repository
public class WechatnewsDaoImpl extends GenericDaoImpl implements WechatnewsDao{
	private static final Log log = LogFactory.getLog(WechatnewsDaoImpl.class);
	
	@Override
	public void save(YsmsWechatnews ysmsWechatnews) {
		log.debug("saving YsmsWechatnews instance");
		try {
			getSession().saveOrUpdate(ysmsWechatnews);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	@Override
	public void delete(YsmsWechatnews ysmsWechatnews) {
		log.debug("deleting YsmsWechatnews instance");
		try {
			getSession().delete(ysmsWechatnews);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	@Override
	public YsmsWechatnews findById(int wechatId) {
		log.debug("getting YsmsWechatnews instance with wechatId: " + wechatId);
		try {
			YsmsWechatnews result = (YsmsWechatnews) getSession().get(
					"com.cwkj.ysms.model.YsmsWechatnews", wechatId);
			return result;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public List<YsmsWechatnews> findAll() {
		log.debug("finding all YsmsWechatnews instances");
		try {
			String queryString = "from YsmsWechatnews";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	@Override
	public List<YsmsWechatnews> findByDate(Date date) {
		log.debug("finding all YsmsWechatnews instances");
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dateStr = sdf.format(date);
			String queryString = "from YsmsWechatnews where date_format(date,'%Y-%m-%d') = '" + dateStr + "' and forServiceFlag = 0 order by nindex asc";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}	
	}

	@Override
	public int getMaxNindex(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = sdf.format(date);
		String queryString = "select max(nindex) maxid from ysms_wechatnews where date_format(date,'%Y-%m-%d') = '" + dateStr + "' and forServiceFlag = 0";
		Integer maxId = (Integer)(getSession().createSQLQuery(queryString).addScalar("maxId", Hibernate.INTEGER) ).uniqueResult();
		if(maxId==null)
			maxId = 0;
		return maxId;
	}

	@Override
	public List<YsmsWechatnews> findByDateLimit10(Date date) {
		log.debug("finding all YsmsWechatnews instances");
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dateStr = sdf.format(date);
			String queryString = "from YsmsWechatnews where date_format(date,'%Y-%m-%d') = '" + dateStr + "' and verified = 1 and forServiceFlag = 0 order by nindex asc";
			Query queryObject = getSession().createQuery(queryString).setMaxResults(10);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}	
	}

	@Override
	public List<YsmsWechatnews> findVoteByDate(Date date) {
		log.debug("finding all YsmsWechatnews instances");
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dateStr = sdf.format(date);
			String queryString = "select distinct ywn from YsmsWechatnews as ywn, YsmsVote as yv where ywn.nid = yv.ysmsWechatnews.nid and date_format(date,'%Y-%m-%d') = '" + dateStr + "' and ywn.forServiceFlag = 0 order by nindex asc";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}	
	}

	@Override
	public List<YsmsWechatnews> findByDateOrderbyVerified(Date date) {
		log.debug("finding all YsmsWechatnews instances");
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dateStr = sdf.format(date);
			String queryString = "from YsmsWechatnews where date_format(date,'%Y-%m-%d') = '" + dateStr + "' and forServiceFlag = 0 order by verified asc";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}	
	}

	@Override
	public List<YsmsWechatnews> findServiceNewsByDate(Date date) {
		log.debug("finding all YsmsWechatnews instances");
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dateStr = sdf.format(date);
			String queryString = "from YsmsWechatnews where date_format(date,'%Y-%m-%d') = '" + dateStr + "' and forServiceFlag = 1 order by nindex asc";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}	
	}

	@Override
	public List<YsmsWechatnews> findServiceVoteByDate(Date date) {
		log.debug("finding all YsmsWechatnews instances");
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dateStr = sdf.format(date);
			String queryString = "select distinct ywn from YsmsWechatnews as ywn, YsmsVote as yv where ywn.nid = yv.ysmsWechatnews.nid and date_format(date,'%Y-%m-%d') = '" + dateStr + "' and ywn.forServiceFlag = 1 order by nindex asc";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}	
	}

	@Override
	public List<YsmsWechatnews> findServiceNewsByDateLimit10(Date date) {
		log.debug("finding all YsmsWechatnews instances");
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dateStr = sdf.format(date);
			String queryString = "from YsmsWechatnews where date_format(date,'%Y-%m-%d') = '" + dateStr + "' and verified = 1 and forServiceFlag = 1 order by nindex asc";
			Query queryObject = getSession().createQuery(queryString).setMaxResults(10);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}	
	}

	@Override
	public int getServiceNewsMaxNindex(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = sdf.format(date);
		String queryString = "select max(nindex) maxid from ysms_wechatnews where date_format(date,'%Y-%m-%d') = '" + dateStr + "' and forServiceFlag = 1";
		Integer maxId = (Integer)(getSession().createSQLQuery(queryString).addScalar("maxId", Hibernate.INTEGER) ).uniqueResult();
		if(maxId==null)
			maxId = 0;
		return maxId;
	}

	@Override
	public List<YsmsWechatnews> findServiceNewsByDateOrderbyVerified(Date date) {
		log.debug("finding all YsmsWechatnews instances");
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dateStr = sdf.format(date);
			String queryString = "from YsmsWechatnews where date_format(date,'%Y-%m-%d') = '" + dateStr + "' and forServiceFlag = 1 order by verified asc";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}	
	}

}
