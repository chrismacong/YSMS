package com.cwkj.ysms.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cwkj.ysms.basedao.impl.GenericDaoImpl;
import com.cwkj.ysms.dao.TrainDetailDao;
import com.cwkj.ysms.model.YsmsTrainDetail;
import com.cwkj.ysms.util.Page;

@Repository
public class TrainDeailDaoImpl extends GenericDaoImpl implements TrainDetailDao {

	private static final Log log = LogFactory.getLog(TrainDeailDaoImpl.class);

	@Override
	public void save(YsmsTrainDetail ysmsTrainDetail) {
		log.debug("saving YsmsTrainDetail instance");
		try {
			getSession().save(ysmsTrainDetail);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	@Override
	public void updata(YsmsTrainDetail ysmsTrainDetail) {
		log.debug("updataing YsmsTrainDetail instance");
		try {
			getSession().saveOrUpdate(ysmsTrainDetail);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	@Override
	public void delete(YsmsTrainDetail ysmsTrainDetail) {
		log.debug("deleting YsmsTrainDetail instance");
		try {
			getSession().delete(ysmsTrainDetail);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	@Override
	public YsmsTrainDetail findById(Integer id) {
		log.debug("getting YsmsTrainDetail instance with id: " + id);
		try {
			String queryString = "from YsmsTrainDetail as model inner join fetch model.ysmsTrain where 1=1 ";
			queryString += " and model.detailId = "+id;
			List<YsmsTrainDetail> results = getSession().createQuery(queryString).list();
			if(results.size()>0){
				YsmsTrainDetail result = results.get(0);
				return result;
			}else{
				return null;
			}
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public List<YsmsTrainDetail> findAll() {
		log.debug("finding all YsmsTrainDetail instances");
		try {
			String queryString = "from YsmsTrainDetail";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	@Override
	public List<YsmsTrainDetail> findByConditionsAndPage(String learnerId,
			String trainId, String detailResult, Page page) {
		String hql = "from YsmsTrainDetail as model where 1=1";
		if(learnerId!=null&&!learnerId.trim().equals("")){
			hql += " and model.learnerId ="+learnerId;
		}
		if(trainId!=null&&!trainId.trim().equals("")){
			hql += " and model.ysmsTrain.trainId ="+trainId;
		}
		if(detailResult!=null&&!detailResult.trim().equals("")){
			hql += " and model.detailResult ="+detailResult;
		}
		Query query=getSession().createQuery(hql);
		if(page != null){
			query.setMaxResults(page.getEveryPage());
			query.setFirstResult(page.getBeginIndex());
		}
		List<YsmsTrainDetail> results = query.list();
		return results;
	}

}
