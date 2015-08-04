package com.cwkj.ysms.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cwkj.ysms.basedao.impl.GenericDaoImpl;
import com.cwkj.ysms.dao.GroupDao;
import com.cwkj.ysms.model.YsmsGoal;
import com.cwkj.ysms.model.YsmsGroup;

@Repository
public class GroupDaoImpl extends GenericDaoImpl implements
GroupDao {
	private static final Log log = LogFactory.getLog(GroupDaoImpl.class);

	@Override
	public void save(YsmsGroup ysmsGroup) {
		log.debug("saving ysmsGroup instance");
		try {
			getSession().saveOrUpdate(ysmsGroup);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	@Override
	public void delete(YsmsGroup ysmsGroup) {
		log.debug("deleting ysmsGroup instance");
		try {
			getSession().delete(ysmsGroup);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	@Override
	public YsmsGroup findById(int GroupId) {
		log.debug("getting YsmsGroup instance with id: " + GroupId);
		try {
			YsmsGroup result = (YsmsGroup) getSession()
					.get("com.cwkj.ysms.model.YsmsGroup", GroupId);
			return result;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public List<YsmsGroup> findAll() {
		log.debug("finding all YsmsGroup instances");
		try {
			String queryString = "from YsmsGroup where 0=0";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
}
