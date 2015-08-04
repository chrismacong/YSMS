package com.cwkj.ysms.service;

import java.util.List;
import java.util.Map;

import com.cwkj.ysms.model.YsmsFunction;
import com.cwkj.ysms.model.YsmsGroup;
import com.cwkj.ysms.model.YsmsGroupFunction;
import com.cwkj.ysms.model.YsmsUser;
import com.cwkj.ysms.model.view.UserGroupView;

/**
 * 
 * 用户信息模块接口 提供对用户信息的新增，修改，删除和查询方法；
 * 
 * @author panhailin henry_pan@126.com
 * @date 2015年3月5日 下午4:24:39
 *
 */
public interface UserManagementService {

	/**
	 * 
	 * 新增用户信息
	 * 
	 * @param groupId
	 *            组别ID
	 * @param userEmail
	 *            用户邮箱
	 * @param userPassword
	 *            用户密码
	 * @param userName
	 *            用户名
	 * @return boolean
	 *
	 */
	public boolean addUser(String groupId, String userEmail,
			String userPassword, String userName);

	/**
	 * 
	 * 根据userId更新用户信息
	 * 
	 * @param userId
	 *            用户ID
	 * @param groupId
	 *            组别ID
	 * @param userEmail
	 *            邮箱
	 * @param userPassword
	 *            密码
	 * @param userName
	 *            用户名
	 * @param deleteFlag
	 *            删除状态
	 * @return boolean
	 *
	 */
	public boolean updateUser(String userId, String groupId, String userEmail,
			String userPassword, String userName, String deleteFlag);

	/**
	 * 
	 * 根据userId删除用户信息
	 * 
	 * @param userId
	 *            用户ID
	 * @return boolean
	 *
	 */
	public boolean deleteUser(String userId);

	/**
	 * 
	 * 根据user_id查询一条用户信息
	 * 
	 * @param userId
	 *            用户ID
	 * @return List<Map<String,Object>>
	 *
	 */
	public List<Map<String,Object>> getUserbyID(String userId);

	/**
	 * 
	 * 模糊查询
	 * 
	 * @param groupId
	 *            组别ID
	 * @param userEmail
	 *            邮箱
	 * @param userName
	 *            用户名
	 * @param userPassword
	 *            密码
	 * @param deleteFlag
	 *            删除状态
	 * @return List<Map<String,Object>>
	 *
	 */
	public List<Map<String,Object>> getUserList(String groupId, String userEmail,
			String userName, String userPassword, String deleteFlag,String pageIndex);
	
	public int getUserListCount(String groupId, String userEmail,
			String userName, String userPassword, String deleteFlag);

	/**
	 * 
	* 登录
	* @param userName 用户名
	* @param passWord 密码
	* @return     
	* List<Map<String,Object>>     
	*
	 */
	public List<Map<String,Object>> login(String userName,String passWord);
	
	
	
	public List<Map<String,Object>> getGroups(String args);
	
	/**
	 * 查找用户名是否存在
	 * @param username
	 * @return
	 */
	public YsmsUser getUserByName(String username);
	
	/**
	 * 修改用户密码
	 * @param userName
	 * @param oldPwd
	 * @param newPwd
	 * @return
	 */
	public boolean changePwd(String userName, String oldPwd, String newPwd);
	
	/**
	 * 查看数据库中是否存在该学校用户名的用户
	 * @param userName
	 * @return 用户id，若不存在返回0
	 */
	public int checkSchoolUsername(String userName);
	
	/**
	 * 获取所有的用户组
	 * @return
	 */
	public List<UserGroupView> getAllGroups();
	
	/**
	 * 根据Id删除用户组
	 * @param groupId
	 * @return
	 */
	public boolean deleteGroup(int groupId);
	
	/**
	 * 添加用户组
	 * @param groupName
	 * @return
	 */
	public boolean addGroup(String groupName);
	
	/**
	 * 修改组别名称
	 * @param groupName
	 * @param groupId
	 * @return
	 */
	public boolean modifyGroup(String groupName, int groupId);
	/**
	 * 向用户组添加一个功能
	 * @param groupId
	 * @param functionId
	 * @return
	 */
	public boolean addFunctionToGroup(int groupId, int functionId);
	
	/**
	 * 从用户组移除一个功能
	 * @param groupId
	 * @param functionId
	 * @return
	 */
	public boolean deleteFunctionToGroup(int groupId, int functionId);
	
	/**
	 * 获取素有权限
	 * @return
	 */
	public List<YsmsFunction> getAllFunction();
}
