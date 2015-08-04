package com.cwkj.ysms.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cwkj.ysms.basedao.impl.GenericDaoImpl;
import com.cwkj.ysms.dao.FunctionDao;
import com.cwkj.ysms.model.YsmsFunction;

@Repository
public class FunctionDaoImpl extends GenericDaoImpl implements
FunctionDao {
	private static final Log log = LogFactory.getLog(FunctionDaoImpl.class);

	@Override
	public YsmsFunction findById(int functionId) {
		log.debug("getting YsmsFunction instance with id: " + functionId);
		try {
			YsmsFunction result = (YsmsFunction) getSession()
					.get("com.cwkj.ysms.model.YsmsFunction", functionId);
			return result;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public List<YsmsFunction> findAll() {
		log.debug("finding all YsmsFunction instances");
		try {
			String queryString = "from YsmsFunction where 0=0";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	
}
