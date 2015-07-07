package com.cwkj.ysms.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cwkj.ysms.dao.SchoolDao;
import com.cwkj.ysms.dao.SchoolUserDao;
import com.cwkj.ysms.dao.UserDao;
import com.cwkj.ysms.model.YsmsDistrict;
import com.cwkj.ysms.model.YsmsGroup;
import com.cwkj.ysms.model.YsmsSchool;
import com.cwkj.ysms.model.YsmsSchooluser;
import com.cwkj.ysms.model.YsmsUser;
import com.cwkj.ysms.model.view.SchoolView;
import com.cwkj.ysms.service.SchoolManagementService;
import com.cwkj.ysms.util.Page;

/**
 * @author zhangjiyao
 * @since 2015-3-6
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SchoolManagementServiceImpl implements SchoolManagementService {

	@Resource
	private SchoolDao schoolDao;
	@Resource
	private UserDao userDao;
	@Resource
	private SchoolUserDao schooluserDao;

	public SchoolUserDao getSchooluserDao() {
		return schooluserDao;
	}

	public void setSchooluserDao(SchoolUserDao schooluserDao) {
		this.schooluserDao = schooluserDao;
	}

	public SchoolDao getSchoolDao() {
		return schoolDao;
	}

	public void setSchoolDao(SchoolDao schoolDao) {
		this.schoolDao = schoolDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean addSchool(String groupId, String schoolName,
			String schoolCategory, String userEmail, String userName,
			String userPassword, String districtId, String schoolAddress,
			String schoolContacts, String schoolMobile, String schoolFax) {
		YsmsGroup ysmsGroup = new YsmsGroup();
		ysmsGroup.setGroupId(Integer.parseInt(groupId));
		YsmsUser ysmsUser = new YsmsUser();
		ysmsUser.setDeleteflag(0);
		ysmsUser.setYsmsGroup(ysmsGroup);
		ysmsUser.setUserEmail(userEmail);
		ysmsUser.setUserName(userName);
		ysmsUser.setUserPassword(userPassword);
		YsmsDistrict ysmsDistrict=new YsmsDistrict();
		ysmsDistrict.setDistrictId(Integer.parseInt(districtId));
		YsmsSchool ysmsSchool = new YsmsSchool();
		ysmsSchool.setDeleteflag(0);
		ysmsSchool.setYsmsDistrict(ysmsDistrict);
		ysmsSchool.setSchoolName(schoolName);
		ysmsSchool.setSchoolAddress(schoolAddress);
		ysmsSchool.setSchoolContacts(schoolContacts);
		ysmsSchool.setSchoolMobile(schoolMobile);
		ysmsSchool.setSchoolFax(schoolFax);
		ysmsSchool.setSchoolCategory(Integer.parseInt(schoolCategory));

		userDao.save(ysmsUser);
		schoolDao.save(ysmsSchool);

		YsmsSchooluser ysmsSchooluser = new YsmsSchooluser();
		ysmsSchooluser.setYsmsSchool(ysmsSchool);
		ysmsSchooluser.setYsmsUser(ysmsUser);
		schooluserDao.save(ysmsSchooluser);
		return true;
	}

	@Override
	public boolean deleteSchool(int schoolId) {
		YsmsSchool ysmsSchool = schoolDao.findById(schoolId);
		ysmsSchool.setDeleteflag(1);
		List<YsmsSchooluser> list = schooluserDao.findBySchoolId(schoolId);
		for (int i = 0; i < list.size(); i++) {
			YsmsUser ysmsUser = list.get(i).getYsmsUser();
			ysmsUser.setDeleteflag(1);
			userDao.save(ysmsUser);
		}
		try {
			schoolDao.save(ysmsSchool);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public YsmsSchool getSchoolByID(int schoolId) {
		YsmsSchool ysmsSchool = schoolDao.findById(schoolId);
		return ysmsSchool;
	}

	@Override
	public boolean updateSchool(String schoolId, String schoolName) {
		YsmsSchool ysmsSchool = schoolDao.findById(Integer.parseInt(schoolId));
		if (schoolName != null && !schoolName.trim().equals("")) {
			ysmsSchool.setSchoolName(schoolName);
		}
		try {
			schoolDao.save(ysmsSchool);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public List<YsmsSchool> getSchools(String schoolName, String schoolCategory) {
		List<YsmsSchool> ysmsShoools = schoolDao.findByNameAndCategory(
				schoolName, schoolCategory);
		return ysmsShoools;
	}

	@Override
	public List<SchoolView> getAllSchools(String schoolName,
			String schoolCategory, String pageIndex) {
		List<SchoolView> schools = new ArrayList<SchoolView>();
		int startIndex = (Integer.parseInt(pageIndex) - 1) * 10;
		Page page = new Page();
		page.setEveryPage(10);
		page.setBeginIndex(startIndex);
		List<YsmsSchool> schoolList = schoolDao.findByNameAndCategoryAndPage(
				schoolName, schoolCategory, page);
		for (int i = 0; i < schoolList.size(); i++) {
			YsmsSchool ysmsSchool = schoolList.get(i);
			if (ysmsSchool.getDeleteflag() != 1) {// 未删除
				SchoolView sv = new SchoolView();
				sv.setSchoolId(ysmsSchool.getSchoolId());
				sv.setSchoolName(ysmsSchool.getSchoolName());
				int category = ysmsSchool.getSchoolCategory();
				if (category == 1)
					sv.setSchoolCategory("小学");
				else if (category == 2)
					sv.setSchoolCategory("初中");
				else if (category == 3)
					sv.setSchoolCategory("高中");
				List<YsmsSchooluser> list = schooluserDao
						.findBySchoolId(ysmsSchool.getSchoolId());
				for (int m = 0; m < list.size(); m++) {
					// 若为学校用户则set
					if (list.get(m).getYsmsUser().getYsmsGroup().getGroupId() == 2) { // hard
																						// code
						sv.setUsername(list.get(m).getYsmsUser().getUserName());
					}
				}

				schools.add(sv);
			}
		}
		return schools;
	}

	@Override
	public int getSchoolsCount(String schoolName, String schoolCategory) {
		// TODO Auto-generated method stub
		return schoolDao.getSchoolCount(schoolName, schoolCategory);
	}

}
