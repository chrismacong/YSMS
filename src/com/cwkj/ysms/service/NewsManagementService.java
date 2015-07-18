package com.cwkj.ysms.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.cwkj.ysms.model.YsmsVote;
import com.cwkj.ysms.model.YsmsWechatnews;
import com.cwkj.ysms.model.view.NewsView;

public interface NewsManagementService {
	/**
	 * 保存图片
	 * @param file
	 * @param userId
	 * @param forwardDir
	 * @return
	 */
	public String saveImageFile(MultipartFile file, int userId, String forwardDir);
	/**
	 * 保存新闻
	 * @param newsTitle
	 * @param newsAuthor
	 * @param isTop
	 * @param content
	 * @param coverImagePath
	 * @param userId
	 * @return
	 */
	public boolean saveNews(String newsTitle, String newsAuthor, boolean isTop, String content, String coverImagePath, int userId);
	/**
	 * 获取某一天的所有新闻，按index排序
	 * @param date
	 * @return
	 */
	public List<YsmsWechatnews> getNewsByDate(Date date);
	/**
	 * 获取某一天的所有新闻，为审核用，按审核状态排序
	 * @param date
	 * @return
	 */
	public List<YsmsWechatnews> getNewsByDateForVerify(Date date);	
	/**
	 * 获取某一天的前10条新闻，按index排序
	 * @param date
	 * @return
	 */
	public List<YsmsWechatnews> getNewsByDateLimit10(Date date);
	/**
	 * 交换两条新闻顺序
	 * @param news_id_down2up
	 * @param news_id_up2down
	 * @return
	 */
	public boolean switchNewsIndex(int news_id_down2up, int news_id_up2down);
	/**
	 * 删除新闻
	 * @param newsId
	 * @return
	 */
	public boolean deleteNews(int newsId);
	/**
	 * 获取某条新闻详细信息
	 * @param newsId
	 * @return
	 */
	public Map<String, Object> getNews(int newsId);
	/**
	 * 获取可以修改的新闻
	 * @param newsId
	 * @return
	 */
	public Map<String, Object> getNewsForModify(int newsId);
	/**
	 * 按照view获取某条新闻信息
	 * @param newsId
	 * @return
	 */
	public NewsView getSimpleNews(int newsId);
	/**
	 * 投票
	 * @param newsId
	 * @param openId
	 * @param paths
	 * @return
	 */
	public boolean vote(int newsId, String openId, String paths);
	/**
	 * 判断用户是否已经参与投票
	 * @param newsId
	 * @param openId
	 * @return
	 */
	public boolean isVoted(int newsId, String openId);
	/**
	 * 根据日期获取投票
	 * @param date
	 * @return
	 */
	public List<YsmsWechatnews> getVoteByDate(Date date);
	/**
	 * 获取投票结果
	 * @param newsId
	 * @return
	 */
	public List<YsmsVote> getVoteResult(int newsId);
	
	/**
	 * 修改审核状态
	 * @param newsId
	 * @param verified
	 * @return
	 */
	public boolean verify(int newsId, int verified);
	/**
	 * 消息群发（订阅号）
	 * @param checked
	 * @return
	 */
	public boolean broadcast(String checked, String forwardDir);
	/**
	 * 消息群发（服务号）
	 * @param checked
	 * @param forwardDir
	 * @return
	 */
	public boolean broadcastService(String checked, String forwardDir);
	
	/**
	 * 修改消息内容
	 * @param newsId
	 * @param content
	 * @return
	 */
	public boolean updateNewsContent(int newsId, String content);
}
