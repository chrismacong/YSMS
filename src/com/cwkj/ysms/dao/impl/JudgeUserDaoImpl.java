package com.cwkj.ysms.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.cwkj.ysms.basedao.impl.GenericDaoImpl;
import com.cwkj.ysms.dao.JudgeUserDao;
import com.cwkj.ysms.model.YsmsJudgeUser;

@Repository
public class JudgeUserDaoImpl extends GenericDaoImpl implements JudgeUserDao {
	private static final Log log = LogFactory.getLog(JudgeUserDaoImpl.class);
	@Override
	public void save(YsmsJudgeUser ysmsJudgeUser) {
		log.debug("saving YsmsJudgeUser instance");
		try {
			getSession().saveOrUpdate(ysmsJudgeUser);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	@Override
	public void delete(YsmsJudgeUser ysmsJudgeUser) {
		log.debug("deleting YsmsJudgeUser instance");
		try {
			getSession().delete(ysmsJudgeUser);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	@Override
	public List<YsmsJudgeUser> findByJudgeId(int judgeId) {
		log.debug("finding YsmsJudgeUser instance by judgeId");
		try {
			String sql = " from YsmsJudgeUser as ju where ju.ysmsJudge.judgeId = "+ judgeId;
			List<Object> objects= findByHQL(sql);
			List<YsmsJudgeUser> results = new ArrayList<YsmsJudgeUser>();
			for(int i=0;i<objects.size();i++){
				YsmsJudgeUser judgeUser = (YsmsJudgeUser)objects.get(i);
				results.add(judgeUser);
			}
			log.debug("find by judgeId successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by judgeId failed", re);
			throw re;
		}
	}

	@Override
	public List<YsmsJudgeUser> findByUserId(int userId) {
		log.debug("finding YsmsJudgeUser instance by userId");
		try {
			String sql = " from YsmsJudgeUser as ju where ju.ysmsUser.userId = "+ userId;
			List<Object> objects= findByHQL(sql);
			List<YsmsJudgeUser> results = new ArrayList<YsmsJudgeUser>();
			for(int i=0;i<objects.size();i++){
				YsmsJudgeUser judgeUser = (YsmsJudgeUser)objects.get(i);
				results.add(judgeUser);
			}
			log.debug("find by userId successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by userId failed", re);
			throw re;
		}
	}

}
