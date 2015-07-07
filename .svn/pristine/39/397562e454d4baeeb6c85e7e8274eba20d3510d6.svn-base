package com.cwkj.ysms.dao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cwkj.ysms.basedao.impl.GenericDaoImpl;
import com.cwkj.ysms.dao.TrainDao;
import com.cwkj.ysms.model.YsmsAthlete;
import com.cwkj.ysms.model.YsmsTrain;
import com.cwkj.ysms.util.Page;

@Repository
public class TrainDaoImpl extends GenericDaoImpl implements TrainDao {

	private static final Log log = LogFactory.getLog(TrainDaoImpl.class);
	
	@Override
	public void save(YsmsTrain ysmsTrain) {
		log.debug("saving YsmsTrain instance");
		try {
			getSession().save(ysmsTrain);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	@Override
	public void delete(YsmsTrain ysmsTrain) {
		log.debug("deleting YsmsTrain instance");
		try {
			getSession().delete(ysmsTrain);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	@Override
	public YsmsTrain findById(Integer trainId) {
		log.debug("getting YsmsTrain instance with trainId: " + trainId);
		try {
			YsmsTrain result = (YsmsTrain) getSession()
					.get("com.cwkj.ysms.model.YsmsTrain", trainId);
			return result;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public void updata(YsmsTrain ysmsTrain) {
		log.debug("merging YsmsTrain instance");
		try {
			getSession().merge(ysmsTrain);
			log.debug("merge successful");
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	@Override
	public List<YsmsTrain> findAll() {
		log.debug("finding all YsmsTrain instances");
		try {
			String queryString = "from YsmsTrain where deleteflag = " + 0;
			queryString+=" order by trainId ";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	@Override
	public List<YsmsTrain> findAllByPage(Page page) {
		log.debug("finding all YsmsTrain instances");
		try {
			String queryString = "from YsmsTrain where deleteflag = " + 0;
			queryString+=" order by trainId ";
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
