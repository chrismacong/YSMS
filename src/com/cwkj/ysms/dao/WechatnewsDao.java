package com.cwkj.ysms.dao;

import java.util.Date;
import java.util.List;

import com.cwkj.ysms.model.YsmsWechatnews;

public interface WechatnewsDao {
	/**
	 * 存储新闻
	 * @param ysmsWechatnews
	 */
	public void save(YsmsWechatnews ysmsWechatnews);
	
	/**
	 * 删除新闻
	 * @param ysmsWechatnews
	 */
	public void delete(YsmsWechatnews ysmsWechatnews);
	
	/**
	 * 根据Id查找新闻
	 * @param wechatId
	 * @return
	 */
	public YsmsWechatnews findById(int wechatId);
	
	/**
	 * 获取全部新闻
	 * @return
	 */
	public List<YsmsWechatnews> findAll();
	
	/**
	 * 根据日期获取新闻
	 * @param date
	 * @return
	 */
	public List<YsmsWechatnews> findByDate(Date date);
	
	/**
	 * 根据日期获取投票
	 * @param date
	 * @return
	 */
	public List<YsmsWechatnews> findVoteByDate(Date date);
	
	/**
	 * 根据日期获取10条新闻，用于微信
	 * @param date
	 * @return
	 */
	public List<YsmsWechatnews> findByDateLimit10(Date date);
	
	/**
	 * 根据日期获取最大nindex
	 * @param date
	 * @return
	 */
	public int getMaxNindex(Date date);

	/**
	 * 根据日期获取新闻，审核状态排序
	 * @param date
	 * @return
	 */
	public List<YsmsWechatnews> findByDateOrderbyVerified(Date date);
	/**
	 * 根据日期获取服务号新闻
	 * @param date
	 * @return
	 */
	public List<YsmsWechatnews> findServiceNewsByDate(Date date);
	
	/**
	 * 根据日期获取服务号投票
	 * @param date
	 * @return
	 */
	public List<YsmsWechatnews> findServiceVoteByDate(Date date);
	
	/**
	 * 根据日期获取10条服务号新闻，用于微信
	 * @param date
	 * @return
	 */
	public List<YsmsWechatnews> findServiceNewsByDateLimit10(Date date);
	
	/**
	 * 根据日期获取最大服务号新闻nindex
	 * @param date
	 * @return
	 */
	public int getServiceNewsMaxNindex(Date date);
	
	/**
	 * 根据日期获取服务号新闻，审核状态排序
	 * @param date
	 * @return
	 */
	public List<YsmsWechatnews> findServiceNewsByDateOrderbyVerified(Date date);
}
