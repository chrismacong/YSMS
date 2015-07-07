package com.cwkj.ysms.service;

import java.util.Date;
import java.util.List;

import com.cwkj.ysms.model.YsmsAthlete;
import com.cwkj.ysms.model.YsmsWechataccount;
import com.cwkj.ysms.model.view.WechatNewsView;

public interface WechatService {
	/**
	 * 查询openId是否存在
	 * @param openId
	 * @return
	 */
	public boolean isOpenIdExist(String openId);
	
	/**
	 * 保存微信用户登录信息
	 * @param openId
	 * @return
	 */
	public boolean saveWechatAccount(YsmsWechataccount ysmsWechataccount);
	/**
	 * 删除微信用户登录信息
	 * @param openId
	 * @return
	 */
	public boolean deleteWechatAccount(String openId);
	/**
	 * 根据openId查询运动员信息
	 * @param openId
	 * @return
	 */
	public YsmsAthlete findAthleteByOpenId(String openId);
	
	/**
	 * 用户绑定
	 * 如果姓名、身份证号、注册号匹配正确，添加运动员绑定，并返回true
	 * 否则返回false
	 * @param identifiedName
	 * @param identifiedId
	 * @param regiesterId
	 * @return
	 */
	public boolean bindAthleteWechat(String openId, String identifiedName, String identifiedId, String registerId);
	
	
	/**
	 * 接触微信号与运动员之间的绑定关系
	 * @param openId
	 * @return
	 */
	public boolean unbindAthleteWechat(String openId);
	
	/**
	 * 查找是否已经绑定了运动员
	 * @param openId
	 * @return
	 */
	public boolean isBinded(String openId);
	
	/**
	 * 完善运动员信息
	 * @param athleteId
	 * @param athleteHeight
	 * @param athleteWeight
	 * @param athleteFootsize
	 * @return
	 */
	public boolean modifyUserInfo(int athleteId, int athleteHeight, int athleteWeight, int athleteFootsize);
	
	/**
	 * 添加一条新闻
	 * 参数包括用户Id，新闻标题，新闻作者、新闻内容和封面图片路径
	 * index自动填充，默认与ID相同，这样可以保证越后发布的新闻Id越大
	 * 如果调换新闻顺序，则将两条新闻对象的index值呼唤
	 * @param userId
	 * @param title
	 * @param author
	 * @param content
	 * @param picUrl
	 * @return
	 */
	public boolean publishNews(int userId, String title, String author, String content, String picUrl);
	
	/**
	 * 调换两条新闻的顺序
	 * @param newsId1
	 * @param newsId2
	 * @return
	 */
	public boolean switchNewsOrder(int newsId1, int newsId2);
	
	/**
	 * 根据日期获取新闻
	 * @param date
	 * @return
	 */
	public List<WechatNewsView> getNewsByDate(Date date);
	
	/**
	 * 获取新闻详细信息
	 * @param newsId
	 * @return
	 */
	public WechatNewsView getNewsDetailById(int newsId);
	
	/**
	 * 删除新闻
	 * @param newsId
	 * @return
	 */
	public boolean deleteNews(int newsId);

	public String findImageUrlByOpenId(String openId);
}
