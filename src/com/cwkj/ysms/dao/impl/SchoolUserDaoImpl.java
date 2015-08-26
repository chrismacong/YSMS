package com.cwkj.ysms.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.cwkj.ysms.basedao.impl.GenericDaoImpl;
import com.cwkj.ysms.dao.SchoolUserDao;
import com.cwkj.ysms.model.YsmsSchooluser;

@Repository
public class SchoolUserDaoImpl extends GenericDaoImpl implements SchoolUserDao {
	private static final Log log = LogFactory.getLog(SchoolUserDaoImpl.class);
	@Override
	public void save(YsmsSchooluser ysmsSchooluser) {
		log.debug("saving YsmsSchooluser instance");
		try {
			getSession().saveOrUpdate(ysmsSchooluser);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	@Override
	public void delete(YsmsSchooluser ysmsSchoolUser) {
		log.debug("deleting YsmsSchooluser instance");
		try {
			getSession().delete(ysmsSchoolUser);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	@Override
	public List<YsmsSchooluser> findBySchoolId(int schoolId) {
		log.debug("finding YsmsSchooluser instance by schoolId");
		try {
			String sql = " from YsmsSchooluser as s where s.ysmsSchool.schoolId = "+ schoolId;
			List<Object> objects= findByHQL(sql);
			List<YsmsSchooluser> results = new ArrayList<YsmsSchooluser>();
			for(int i=0;i<objects.size();i++){
				YsmsSchooluser schooluser = (YsmsSchooluser)objects.get(i);
				results.add(schooluser);
			}
			log.debug("find by schoolId successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by schoolId failed", re);
			throw re;
		}
	}
	@Override
	public List<YsmsSchooluser> findByUserId(int userId) {
		log.debug("finding YsmsSchooluser instance by schoolId");
		try {
			String sql = " from YsmsSchooluser as s where s.ysmsUser.userId = "+ userId;
			List<Object> objects= findByHQL(sql);
			List<YsmsSchooluser> results = new ArrayList<YsmsSchooluser>();
			for(int i=0;i<objects.size();i++){
				YsmsSchooluser schooluser = (YsmsSchooluser)objects.get(i);
				results.add(schooluser);
			}
			log.debug("find by schoolId successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by schoolId failed", re);
			throw re;
		}
	}


}
