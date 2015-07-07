package com.cwkj.ysms.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cwkj.ysms.dao.SchoolUserDao;
import com.cwkj.ysms.dao.UserDao;
import com.cwkj.ysms.model.YsmsGroup;
import com.cwkj.ysms.model.YsmsSchooluser;
import com.cwkj.ysms.model.YsmsUser;
import com.cwkj.ysms.service.UserManagementService;
import com.cwkj.ysms.util.ToolsUtil;

/**
 * 
 * 用户管理Service实现类
 * 
 * @author panhailin henry_pan@126.com
 * @date 2015年3月09日 下午1:45:40
 *
 */
@Service
public class UserManagementServiceImpl implements UserManagementService {
	@Resource
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Resource
	private SchoolUserDao schooluserDao;	

	public SchoolUserDao getSchooluserDao() {
		return schooluserDao;
	}

	public void setSchooluserDao(SchoolUserDao schooluserDao) {
		this.schooluserDao = schooluserDao;
	}

	@Override
	public boolean addUser(String groupId, String userEmail,
			String userPassword, String userName) {
		try {
			YsmsUser ysmsUser = new YsmsUser();
			ysmsUser.setUserName(userName);
			ysmsUser.setUserPassword(userPassword);
			ysmsUser.setUserEmail(userEmail);
			ysmsUser.setDeleteflag(0);
			YsmsGroup ysmsGroup = new YsmsGroup();
			ysmsGroup.setGroupId(Integer.parseInt(groupId));
			ysmsUser.setYsmsGroup(ysmsGroup);
			userDao.save(ysmsUser);
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean updateUser(String userId, String groupId, String userEmail,
			String userPassword, String userName, String deleteFlag) {
		try {
			YsmsUser ysmsUser = new YsmsUser();
			ysmsUser.setUserId(Integer.parseInt(userId));
			ysmsUser.setUserEmail(userEmail);
			ysmsUser.setUserName(userName);
			ysmsUser.setUserPassword(userPassword);
			ysmsUser.setDeleteflag(Integer.parseInt(deleteFlag));
			YsmsGroup ysmsGroup = new YsmsGroup();
			ysmsGroup.setGroupId(Integer.parseInt(groupId));
			ysmsUser.setYsmsGroup(ysmsGroup);
			userDao.update(ysmsUser);
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteUser(String userId) {
		try {
			if (ToolsUtil.isEmpty(userId)) {
				return false;
			}
			for (String user_id : userId.split(",")) {
				userDao.delete(Integer.parseInt(user_id));
			}

		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<Map<String, Object>> getUserbyID(String userId) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			if (ToolsUtil.isEmpty(userId)) {
				return list;
			}

			list = userDao.findUserByID(Integer.parseInt(userId));
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Map<String, Object>> getUserList(String groupId,
			String userEmail, String userName, String userPassword,
			String deleteFlag, String pageIndex) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			int startIndex = (Integer.parseInt(pageIndex) - 1) * 10;
			list = userDao.findUser(groupId, userEmail, userName, userPassword,
					deleteFlag, startIndex);

		} catch (Exception exception) {
			exception.printStackTrace();
			return list;
		}

		return list;
	}

	@Override
	public List<Map<String, Object>> login(String userName, String passWord) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			list = userDao.findUserByNameAndPwd(userName, passWord);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Map<String, Object>> getGroups(String args) {

		return userDao.getGroups( args);
	}

	@Override
	public int getUserListCount(String groupId, String userEmail,
			String userName, String userPassword, String deleteFlag) {
		int count = 0;
		try {
			List<Map<String, Object>> list = userDao.findUserCount(groupId,
					userEmail, userName, userPassword, deleteFlag);
			if (list != null) {
				count = Integer.parseInt(list.get(0).get("COUNT").toString());
			}

		} catch (Exception exception) {
			exception.printStackTrace();

		}

		return count;
	}

	@Override
	public YsmsUser getUserByName(String username) {
		YsmsUser ysmsUser = userDao.getUserByUsername(username);
		return ysmsUser;
	}

	@Override
	public boolean changePwd(String userName, String oldPwd, String newPwd) {
		YsmsUser ysmsUser = userDao.getUserByUsername(userName);
		if(ysmsUser.getUserPassword().equals(oldPwd)){
			ysmsUser.setUserPassword(newPwd);
			userDao.save(ysmsUser);
			return true;
		}
		else
			return false;
	}

	@Override
	public int checkSchoolUsername(String userName) {
		YsmsUser ysmsUser = userDao.getUserByUsername(userName);
		if(ysmsUser==null)
			return 0;
		List<YsmsSchooluser> schooluserList = schooluserDao.findByUserId(ysmsUser.getUserId());
		if(schooluserList.size()>0){
			YsmsSchooluser ysmsSchoolUser = schooluserList.get(0);
			return ysmsSchoolUser.getYsmsSchool().getSchoolId();
		}
		else
			return 0;
	}
}
