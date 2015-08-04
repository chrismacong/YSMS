package com.cwkj.ysms.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cwkj.ysms.dao.FunctionDao;
import com.cwkj.ysms.dao.GroupDao;
import com.cwkj.ysms.dao.GroupFunctionDao;
import com.cwkj.ysms.dao.SchoolUserDao;
import com.cwkj.ysms.dao.UserDao;
import com.cwkj.ysms.model.YsmsFunction;
import com.cwkj.ysms.model.YsmsGroup;
import com.cwkj.ysms.model.YsmsGroupFunction;
import com.cwkj.ysms.model.YsmsSchooluser;
import com.cwkj.ysms.model.YsmsUser;
import com.cwkj.ysms.model.view.UserGroupView;
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
	
	@Resource
	private GroupDao groupDao;

	public GroupDao getGroupDao() {
		return groupDao;
	}

	public void setGroupDao(GroupDao groupDao) {
		this.groupDao = groupDao;
	}
	
	@Resource
	private GroupFunctionDao groupFunctionDao;

	public GroupFunctionDao getGroupFunctionDao() {
		return groupFunctionDao;
	}

	public void setGroupFunctionDao(GroupFunctionDao groupFunctionDao) {
		this.groupFunctionDao = groupFunctionDao;
	}
	
	@Resource
	private FunctionDao functionDao;
	

	public FunctionDao getFunctionDao() {
		return functionDao;
	}

	public void setFunctionDao(FunctionDao functionDao) {
		this.functionDao = functionDao;
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

	@Override
	public List<UserGroupView> getAllGroups() {
		List<UserGroupView> groupViewList = new ArrayList<UserGroupView>();
		List<YsmsGroup> groupList = groupDao.findAll();
		for(int i=0;i<groupList.size();i++){
			YsmsGroup ysmsGroup = groupList.get(i);
			UserGroupView ugv = new UserGroupView();
			ugv.setGroupId(ysmsGroup.getGroupId());
			ugv.setGroupName(ysmsGroup.getGroupName());
			List<YsmsGroupFunction> groupFunctionList = groupFunctionDao.findByGroupId(ysmsGroup.getGroupId());
			String functionStr = "";
			if(groupFunctionList!=null){
				for(int m=0;m<groupFunctionList.size();m++){
					functionStr += groupFunctionList.get(m).getYsmsFunction().getFunctionId() + ",";
				}
			}
			if(functionStr.lastIndexOf(",")>0){
				functionStr = functionStr.substring(0, functionStr.lastIndexOf(","));
			}
			ugv.setFunctionStr(functionStr);
			groupViewList.add(ugv);
		}
		return groupViewList;
	}

	@Override
	public boolean deleteGroup(int groupId) {
		//先删除所有相关的角色权限关系
		List<YsmsGroupFunction> groupFunctionList = groupFunctionDao.findByGroupId(groupId);
		for(int i=0;i<groupFunctionList.size();i++){
			groupFunctionDao.delete(groupFunctionList.get(i));
		}
		//再删除所有该角色的用户，此处需注意提示.代码处可以设定某些重要的用户类型，比如学校用户和管理员用户，是不可以删除的
		List<YsmsUser> userList = userDao.findByGroupId(groupId);
		if(userList != null){
			for(int i=0;i<userList.size();i++){
				YsmsUser user = userList.get(i);
				userDao.delete(user.getUserId());
			}
		}
		//最后删除这个组
		groupDao.delete(groupDao.findById(groupId));
		return true;
	}

	@Override
	public boolean addGroup(String groupName) {
		YsmsGroup group = new YsmsGroup();
		group.setGroupName(groupName);
		groupDao.save(group);
		return true;
	}

	@Override
	public boolean addFunctionToGroup(int groupId, int functionId) {
		YsmsGroupFunction groupFunction = new YsmsGroupFunction();
		groupFunction.setYsmsFunction(functionDao.findById(functionId));
		groupFunction.setYsmsGroup(groupDao.findById(groupId));
		groupFunctionDao.save(groupFunction);
		return true;
	}

	@Override
	public boolean deleteFunctionToGroup(int groupId, int functionId) {
		List<YsmsGroupFunction> groupFunctionList = groupFunctionDao.findByGroupIdandFunctionId(groupId, functionId);
		for(int i=0;i<groupFunctionList.size();i++){
			YsmsGroupFunction groupFunction = groupFunctionList.get(i);
			groupFunctionDao.delete(groupFunction);
		}
		return true;
	}

	@Override
	public boolean modifyGroup(String groupName, int groupId) {
		YsmsGroup group = groupDao.findById(groupId);
		group.setGroupName(groupName);
		groupDao.save(group);
		return true;
	}

	@Override
	public List<YsmsFunction> getAllFunction() {
		return functionDao.findAll();
	}
}
