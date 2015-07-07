package com.cwkj.ysms.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cwkj.ysms.basedao.impl.GenericDaoImpl;
import com.cwkj.ysms.dao.DistrictDao;
import com.cwkj.ysms.model.YsmsDistrict;

@Repository
public class DistrictDaoImpl extends GenericDaoImpl implements DistrictDao {
	private static final Log log = LogFactory.getLog(DistrictDaoImpl.class);
	@Override
	public YsmsDistrict findById(Integer districtId) {
		log.debug("getting YsmsDistrict instance with districtId: " + districtId);
		try {
			YsmsDistrict result = (YsmsDistrict) getSession()
					.get("com.cwkj.ysms.model.YsmsDistrict", districtId);
			return result;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public List<YsmsDistrict> findAll() {
		// TODO Auto-generated method stub
		log.debug("finding all YsmsDistrict instances");
		try {
			String queryString = "from YsmsDistrict where 0=0";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

}
