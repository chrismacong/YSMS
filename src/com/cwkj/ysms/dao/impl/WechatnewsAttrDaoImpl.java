package com.cwkj.ysms.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cwkj.ysms.basedao.impl.GenericDaoImpl;
import com.cwkj.ysms.dao.WechatnewsAttrDao;
import com.cwkj.ysms.model.YsmsWechatnewsAttr;
@Repository
public class WechatnewsAttrDaoImpl extends GenericDaoImpl implements WechatnewsAttrDao{
	private static final Log log = LogFactory.getLog(WechatnewsAttrDaoImpl.class);
	@Override
	public void save(YsmsWechatnewsAttr ysmsWechatnewsAttr) {
		log.debug("saving YsmsWechatnewsAttr instance");
		try {
			getSession().saveOrUpdate(ysmsWechatnewsAttr);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	@Override
	public void delete(YsmsWechatnewsAttr ysmsWechatnewsAttr) {
		log.debug("deleting YsmsWechatnewsAttr instance");
		try {
			getSession().delete(ysmsWechatnewsAttr);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	@Override
	public YsmsWechatnewsAttr findByID(Integer id) {
		log.debug("getting YsmsWechatnewsAttr instance with Id: " + id);
		try {
			YsmsWechatnewsAttr result = (YsmsWechatnewsAttr) getSession().get(
					"com.cwkj.ysms.model.YsmsWechatnewsAttr", id);
			return result;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public YsmsWechatnewsAttr findByNewsId(Integer newsId) {
		log.debug("finding all YsmsWechatnewsAttr instances");
		try {
			String queryString = "from YsmsWechatnewsAttr as ywa where ywa.ysmsWechatnews.nid=" + newsId;
			Query queryObject = getSession().createQuery(queryString);
			List<YsmsWechatnewsAttr> list = queryObject.list();
			if(list==null||list.size()==0)
				return null;
			else
				return list.get(0);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

}
