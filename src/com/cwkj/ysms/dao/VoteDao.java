package com.cwkj.ysms.dao;

import java.util.List;

import com.cwkj.ysms.model.YsmsVote;

public interface VoteDao {
	public void save(YsmsVote ysmsVote);
	
	public void delete(YsmsVote ysmsVote);
	
	public YsmsVote findById(Integer voteId);
	
	public void update(YsmsVote ysmsVote);
	
	public List<YsmsVote> findAll();
	
	/**
	 * 根据新闻Id和图片的文件名称查询
	 * 查询到的结果可以用来进行投票递增操作
	 * 其实使用图片文件名称已经可以保证唯一，添加新闻ID来验证有效性
	 * 新闻Id在新闻页中获取，图片文件名称在点击投票后从前台id中截取
	 * @param newsId
	 * @param imagePath
	 * @return
	 */
	public YsmsVote findByNewsAndImage(int newsId, String imagePath);
	
	/**
	 * 获取某条新闻下的投票结果
	 * @param newsId
	 * @return
	 */
	public List<YsmsVote> findByNews(int newsId);
}
