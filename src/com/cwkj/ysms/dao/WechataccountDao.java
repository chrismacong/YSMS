package com.cwkj.ysms.dao;

import java.util.List;

import com.cwkj.ysms.model.YsmsWechataccount;

public interface WechataccountDao {
	/**
	 * 保存微信账号信息
	 * @param ysmsWechataccount
	 */
	public void save(YsmsWechataccount ysmsWechataccount);
	
	/**
	 * 删除微信账号信息
	 * @param ysmsWechataccount
	 */
	public void delete(YsmsWechataccount ysmsWechataccount);
	
	/**
	 * 根据Id查询微信账号信息
	 * @param wid
	 * @return
	 */
	public YsmsWechataccount findById(Integer wid);
	
	/**
	 * 获取全部微信账号信息
	 * @return
	 */
	public List<YsmsWechataccount> findAll();
	
	/**
	 * 根据OpenId查询微信账号信息
	 * @param openId
	 * @return
	 */
	public YsmsWechataccount findByOpenid(String openId);
}
