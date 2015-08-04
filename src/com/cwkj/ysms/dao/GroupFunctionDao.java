package com.cwkj.ysms.dao;

import java.util.List;

import com.cwkj.ysms.model.YsmsGroupFunction;

public interface GroupFunctionDao {
	/**
	 * 保存用户组信息
	 * @param ysmsGroupFunction
	 */
	public void save(YsmsGroupFunction ysmsGroupFunction);
	
	/**
	 * 删除用户组信息
	 * @param ysmsGroupFunction
	 */
	public void delete(YsmsGroupFunction ysmsGroupFunction);
	
	
	/**
	 * 查询用户组信息
	 * @param GroupFunctionId 用户组信息Id
	 */
	public YsmsGroupFunction findById(int GroupFunctionId);
	
	
	/**
	 * 查询所有用户组信息
	 * @return
	 */
	public List<YsmsGroupFunction> findAll();
	
	/**
	 * 根据用户组Id获取用户权限表
	 * @param groupId
	 * @return
	 */
	public List<YsmsGroupFunction> findByGroupId(int groupId);
	
	/**
	 * 根据用户组Id和功能Id查询权限表
	 * 为了防止有重复添加造成的问题，此处会将所有满足条件的都删除
	 * @param groupId
	 * @param functionId
	 * @return
	 */
	public List<YsmsGroupFunction> findByGroupIdandFunctionId(int groupId, int functionId); 
}
