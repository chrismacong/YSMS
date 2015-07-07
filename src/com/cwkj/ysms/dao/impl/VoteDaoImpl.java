package com.cwkj.ysms.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cwkj.ysms.basedao.impl.GenericDaoImpl;
import com.cwkj.ysms.dao.VoteDao;
import com.cwkj.ysms.model.YsmsAthlete;
import com.cwkj.ysms.model.YsmsVote;

@Repository
public class VoteDaoImpl extends GenericDaoImpl implements VoteDao{
	private static final Log log = LogFactory.getLog(VoteDaoImpl.class);
	@Override
	public void save(YsmsVote ysmsVote) {
		log.debug("saving YsmsVote instance");
		try {
			getSession().saveOrUpdate(ysmsVote);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	@Override
	public void delete(YsmsVote ysmsVote) {
		log.debug("deleting YsmsVote instance");
		try {
			getSession().delete(ysmsVote);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	@Override
	public YsmsVote findById(Integer voteId) {
		log.debug("getting YsmsVote instance with athleteId: " + voteId);
		try {
			YsmsVote result = (YsmsVote) getSession().get(
					"com.cwkj.ysms.model.YsmsVote", voteId);
			return result;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public void update(YsmsVote ysmsVote) {
		log.debug("merging YsmsVote instance");
		try {
			getSession().merge(ysmsVote);
			log.debug("merge successful");
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	@Override
	public List<YsmsVote> findAll() {
		log.debug("finding all YsmsVote instances");
		try {
			String queryString = "from YsmsVote";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	@Override
	public YsmsVote findByNewsAndImage(int newsId, String imagePath) {
		try {
			String queryString = "from YsmsVote as model where model.ysmsWechatnews.nid=" + newsId + " and model.imagePath='" + imagePath + "'";
			Query queryObject = getSession().createQuery(queryString);
			List<YsmsVote> list = queryObject.list();
			if(list.size()>0){
				return list.get(0);
			}
		} catch (RuntimeException re) {
			log.error("find ByFuzzyQueryAndPage failed", re);
			throw re;
		}
		return null;
	}

	@Override
	public List<YsmsVote> findByNews(int newsId) {
		try {
			String queryString = "from YsmsVote as model where model.ysmsWechatnews.nid=" + newsId + " order by model.voteNum desc";
			Query queryObject = getSession().createQuery(queryString);
			List<YsmsVote> list = queryObject.list();
			return list;
		} catch (RuntimeException re) {
			log.error("find ByFuzzyQueryAndPage failed", re);
			throw re;
		}
	}

}
