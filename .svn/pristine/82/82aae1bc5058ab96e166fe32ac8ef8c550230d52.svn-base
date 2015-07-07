package com.cwkj.ysms.service;

import java.util.List;

import com.cwkj.ysms.model.YsmsGroup;

/**
 * 
 * 组别信息模块接口 提供对组别信息的新增，修改，删除和查询方法；
 * 
 * @author panhailin henry_pan@126.com
 * @date 2015年3月5日 下午4:37:11
 *
 */
public interface GroupManagementService {
	/**
	 * 
	 * 新增组别信息
	 * 
	 * @param group_name
	 *            组别名称
	 * @param group_desc
	 *            组别描述
	 * @param function_id
	 *            权限ID数组
	 * @return boolean
	 *
	 */
	public boolean addGroup(String group_name, String group_desc,
			String[] function_id);

	/**
	 * 
	 * 根据group_id修改组别信息
	 * 
	 * @param group_id
	 *            组别ID
	 * @param group_name
	 *            组别名称
	 * @param group_desc
	 *            组别描述
	 * @param function_id_delete
	 *            需要删除的权限ID数组
	 * @param function_id_add
	 *            需要增加的权限ID数组
	 * @return boolean
	 *
	 */
	public boolean updateGroup(int group_id, String group_name,
			String group_desc, String[] function_id_delete,
			String[] function_id_add);

	/**
	 * 
	 * 根据group_id删除组别信息
	 * 
	 * @param group_id
	 *            组别ID
	 * @return boolean
	 *
	 */
	public boolean deleteGroup(int group_id);

	/**
	 * 
	 * 根据group_id查询一条组别信息
	 * 
	 * @param group_id
	 * @return YsmsGroup
	 *
	 */
	public YsmsGroup getGroupByID(int group_id);

	/**
	 * 
	 * 根据组别名称查询组别列表
	 * 
	 * @param group_name 组别名称
	 * @param leagueId 联赛Id
	 * @return List<YsmsGroup>
	 *
	 */
	public List<YsmsGroup> getGroups(int leagueId, String group_name);
}
