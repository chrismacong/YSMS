package com.cwkj.ysms.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cwkj.ysms.basedao.impl.GenericDaoImpl;
import com.cwkj.ysms.dao.GroupFunctionDao;
import com.cwkj.ysms.model.YsmsGroupFunction;

@Repository
public class GroupFunctionDaoImpl extends GenericDaoImpl implements
GroupFunctionDao {
	private static final Log log = LogFactory.getLog(DiplomaDaoImpl.class);

	@Override
	public void save(YsmsGroupFunction ysmsGroupFunction) {
		log.debug("saving ysmsGroupFunction instance");
		try {
			getSession().saveOrUpdate(ysmsGroupFunction);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	@Override
	public void delete(YsmsGroupFunction ysmsGroupFunction) {
		log.debug("deleting ysmsGroupFunction instance");
		try {
			getSession().delete(ysmsGroupFunction);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	@Override
	public YsmsGroupFunction findById(int GroupFunctionId) {
		log.debug("getting YsmsGroupFunction instance with id: " + GroupFunctionId);
		try {
			YsmsGroupFunction result = (YsmsGroupFunction) getSession()
					.get("com.cwkj.ysms.model.YsmsGroupFunction", GroupFunctionId);
			return result;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public List<YsmsGroupFunction> findAll() {
		log.debug("finding all YsmsGroupFunction instances");
		try {
			String queryString = "from YsmsGroupFunction where 0=0";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	@Override
	public List<YsmsGroupFunction> findByGroupId(int groupId) {
		log.debug("finding all YsmsGroupFunction instances");
		try {
			String queryString = "from YsmsGroupFunction where group_id=" + groupId;
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	@Override
	public List<YsmsGroupFunction> findByGroupIdandFunctionId(int groupId, int functionId) {
		log.debug("finding all YsmsGroupFunction instances");
		try {
			String queryString = "from YsmsGroupFunction where group_id = " + groupId + " and function_id = " + functionId;
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

}
