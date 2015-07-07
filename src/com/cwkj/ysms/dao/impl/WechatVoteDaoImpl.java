package com.cwkj.ysms.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cwkj.ysms.basedao.impl.GenericDaoImpl;
import com.cwkj.ysms.dao.WechatVoteDao;
import com.cwkj.ysms.model.YsmsWechatVote;

@Repository
public class WechatVoteDaoImpl extends GenericDaoImpl implements WechatVoteDao{
	private static final Log log = LogFactory.getLog(WechatVoteDaoImpl.class);
	@Override
	public void save(YsmsWechatVote ysmsWechatVote) {
		log.debug("saving YsmsWechatVote instance");
		try {
			getSession().saveOrUpdate(ysmsWechatVote);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	@Override
	public void delete(YsmsWechatVote ysmsWechatVote) {
		log.debug("deleting YsmsWechatVote instance");
		try {
			getSession().delete(ysmsWechatVote);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	@Override
	public YsmsWechatVote findById(Integer id) {
		log.debug("getting YsmsVote instance with athleteId: " + id);
		try {
			YsmsWechatVote result = (YsmsWechatVote) getSession().get(
					"com.cwkj.ysms.model.YsmsWechatVote", id);
			return result;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public void update(YsmsWechatVote ysmsWechatVote) {
		log.debug("merging YsmsWechatVote instance");
		try {
			getSession().merge(ysmsWechatVote);
			log.debug("merge successful");
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	@Override
	public List<YsmsWechatVote> findAll() {
		log.debug("finding all YsmsWechatVote instances");
		try {
			String queryString = "from YsmsWechatVote";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	@Override
	public YsmsWechatVote findByNewsAndOpenid(int newsId, String openId) {
		try {
			String queryString = "from YsmsWechatVote as model where model.ysmsWechatnews.nid=" + newsId + " and model.ysmsWechataccount.openid='" + openId + "'";
			Query queryObject = getSession().createQuery(queryString);
			List<YsmsWechatVote> list = queryObject.list();
			if(list.size()>0){
				return list.get(0);
			}
		} catch (RuntimeException re) {
			log.error("find ByFuzzyQueryAndPage failed", re);
			throw re;
		}
		return null;
	}

}
