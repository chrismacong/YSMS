package com.cwkj.ysms.dao;

import java.util.List;

import com.cwkj.ysms.model.YsmsGroup;

public interface GroupDao {
	
	/**
	 * 保存用户组信息
	 * @param ysmsGroup
	 */
	public void save(YsmsGroup ysmsGroup);
	
	/**
	 * 删除用户组信息
	 * @param ysmsFourl
	 */
	public void delete(YsmsGroup ysmsGroup);
	
	
	/**
	 * 查询用户组信息
	 * @param GroupId 用户组信息Id
	 */
	public YsmsGroup findById(int GroupId);
	
	
	/**
	 * 查询所有用户组信息
	 * @return
	 */
	public List<YsmsGroup> findAll();
}
