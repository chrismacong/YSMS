package com.cwkj.ysms.dao.impl;

import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cwkj.ysms.basedao.impl.GenericDaoImpl;
import com.cwkj.ysms.dao.CoachDao;
import com.cwkj.ysms.model.YsmsCoach;
import com.cwkj.ysms.model.YsmsCoachAtt;
import com.cwkj.ysms.model.view.CoachManagerListView;
import com.cwkj.ysms.util.Page;

@Repository
public class CoachDaoImpl extends GenericDaoImpl implements CoachDao {
	private static final Log log = LogFactory.getLog(CoachDaoImpl.class);

	@Override
	public void save(YsmsCoach ysmsCoach) {
		log.debug("saving YsmsCoach instance");
		try {
			getSession().saveOrUpdate(ysmsCoach);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	@Override
	public void delete(YsmsCoach ysmsCoach) {
		log.debug("deleting YsmsCoach instance");
		try {
			getSession().delete(ysmsCoach);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	@Override
	public void updata(YsmsCoach ysmsCoach) {
		log.debug("merging YsmsCoach instance");
		try {
			getSession().merge(ysmsCoach);
			log.debug("merge successful");
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}
	
	@Override
	public YsmsCoach findById(Integer coachId) {
		log.debug("getting YsmsCoach instance with coachId: " + coachId);
		try {
			YsmsCoach result = (YsmsCoach) getSession()
					.get("com.cwkj.ysms.model.YsmsCoach", coachId);
			return result;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public List<YsmsCoach> findAll() {
		log.debug("finding all YsmsCoach instances");
		try {
			String queryString = "from YsmsCoach where deleteflag = " + 0;
			queryString += " order by coachId ";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	@Override
	public List<YsmsCoach> findAllByPage(Page page) {
		log.debug("finding all YsmsCoach instances");
		try {
			String queryString = "from YsmsCoach where deleteflag = " + 0;
			queryString += " order by coachId ";
			Query queryObject = getSession().createQuery(queryString);
			if (page != null) {
				queryObject.setMaxResults(page.getEveryPage());
				queryObject.setFirstResult(page.getBeginIndex());
			}
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	@Override
	public List<YsmsCoach> findByFuzzyQuery(String identifiedId,
			Integer schoolId, String coachContact, String identifiedName,
			Integer identifiedGender) {
		log.debug("finding ByFuzzyQuery instances");
		try {
			String queryString = "from YsmsCoach as model where model.deleteflag=0";
			if (schoolId != null) {
				queryString += " and model.ysmsSchool.schoolId = " + schoolId;
			}
			if (identifiedId != null && !identifiedId.trim().equals("")) {
				queryString += " and model.identifiedId like '%" + identifiedId
						+ "%' ";
			}
			if (identifiedName != null && !identifiedName.trim().equals("")) {
				queryString += " and model.identifiedName like '%"
						+ identifiedName + "%' ";
			}
			if (identifiedGender != null) {
				queryString += " and model.identifiedGender = "
						+ identifiedGender;
			}
			if (coachContact != null) {
				queryString += " and model.coachContact = " + coachContact;
			}
			queryString += " order by model.coachId ";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find ByFuzzyQuery failed", re);
			throw re;
		}
	}

	@Override
	public List<YsmsCoach> findByFuzzyQueryAndPage(String identifiedId,
			Integer schoolId, String coachContact, String identifiedName,
			Integer identifiedGender, Page page) {
		log.debug("finding  ByFuzzyQueryAndPage instances");
		try {
			String queryString = "from YsmsCoach as model where model.deleteflag=0";
			if (schoolId != null) {
				queryString += " and model.ysmsSchool.schoolId = " + schoolId;
			}
			if (identifiedId != null && !identifiedId.trim().equals("")) {
				queryString += " and model.identifiedId like '%" + identifiedId
						+ "%' ";
			}
			if (identifiedName != null && !identifiedName.trim().equals("")) {
				queryString += " and model.identifiedName like '%"
						+ identifiedName + "%' ";
			}
			if (identifiedGender != null) {
				queryString += " and model.identifiedGender = "
						+ identifiedGender;
			}
			if (coachContact != null) {
				queryString += " and model.coachContact = " + coachContact;
			}
			queryString += " order by model.coachId ";
			Query queryObject = getSession().createQuery(queryString);
			if (page != null) {
				queryObject.setMaxResults(page.getEveryPage());
				queryObject.setFirstResult(page.getBeginIndex());
			}
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find ByFuzzyQueryAndPage failed", re);
			throw re;
		}
	}

	@Override
	public List<YsmsCoach> findByFuzzyQueryByPageAndOrder(String identifiedId,
			Integer schoolId, String coachContact, String identifiedName,
			Integer identifiedGender, Page page, String order) {
		log.debug("finding  findByFuzzyQueryByPageAndOrder instances");
		try {
			String queryString = "from YsmsCoach as model where model.deleteflag=0";
			if (schoolId != null) {
				queryString += " and model.ysmsSchool.schoolId = " + schoolId;
			}
			if (identifiedId != null && !identifiedId.trim().equals("")) {
				queryString += " and model.identifiedId like '%" + identifiedId
						+ "%' ";
			}
			if (identifiedName != null && !identifiedName.trim().equals("")) {
				queryString += " and model.identifiedName like '%"
						+ identifiedName + "%' ";
			}
			if (identifiedGender != null) {
				queryString += " and model.identifiedGender = "
						+ identifiedGender;
			}
			if (coachContact != null) {
				queryString += " and model.coachContact = " + coachContact;
			}
			if (order != null) {
				queryString += order;
			}
			Query queryObject = getSession().createQuery(queryString);
			if (page != null) {
				queryObject.setMaxResults(page.getEveryPage());
				queryObject.setFirstResult(page.getBeginIndex());
			}
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find findByFuzzyQueryByPageAndOrder failed", re);
			throw re;
		}
	}

	@Override
	public int findByFuzzyQueryAndPageCount(String identifiedId,
			Integer schoolId, String coachContact, String identifiedName,
			Integer identifiedGender) {
		log.debug("finding  ByFuzzyQueryAndPage Count instances");
		try {
			String queryString = "select count(*) from YsmsCoach as model where model.deleteflag=0";
			if (schoolId != null) {
				queryString += " and model.ysmsSchool.schoolId = " + schoolId;
			}
			if (identifiedId != null && !identifiedId.trim().equals("")) {
				queryString += " and model.identifiedId like '%" + identifiedId
						+ "%' ";
			}
			if (identifiedName != null && !identifiedName.trim().equals("")) {
				queryString += " and model.identifiedName like '%"
						+ identifiedName + "%' ";
			}
			if (identifiedGender != null) {
				queryString += " and model.identifiedGender = "
						+ identifiedGender;
			}
			if (coachContact != null) {
				queryString += " and model.coachContact = " + coachContact;
			}
			Query queryObject = getSession().createQuery(queryString);
			return ((Number) queryObject.uniqueResult()).intValue();
		} catch (RuntimeException re) {
			log.error("find ByFuzzyQueryAndPage Count failed", re);
			throw re;
		}
	}

	@Override
	public CoachManagerListView getCoachListViewByID(int coachId) {
		YsmsCoach ysmsCoach = findById(coachId);
		Set<YsmsCoachAtt> coachAtts = ysmsCoach.getYsmsCoachAtts();
		YsmsCoachAtt ysmsCoachID = null, ysmsCoachSchool = null, ysmsCoachLeve = null;
		for (YsmsCoachAtt ysmsCoachAtt : coachAtts) {
			switch (ysmsCoachAtt.getAttType()) {
			case 0:
				ysmsCoachID = ysmsCoachAtt;
				break;
			case 1:
				ysmsCoachSchool = ysmsCoachAtt;
				break;
			case 2:
				ysmsCoachLeve = ysmsCoachAtt;
				break;
			}
		}
		return new CoachManagerListView(ysmsCoach, ysmsCoachID,
				ysmsCoachSchool, ysmsCoachLeve);
	}

}
