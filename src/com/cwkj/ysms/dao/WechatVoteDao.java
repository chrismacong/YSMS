package com.cwkj.ysms.dao;

import java.util.List;

import com.cwkj.ysms.model.YsmsWechatVote;

public interface WechatVoteDao {
	public void save(YsmsWechatVote ysmsWechatVote);

	public void delete(YsmsWechatVote ysmsWechatVote);
	
	public YsmsWechatVote findById(Integer id);
	
	public void update(YsmsWechatVote ysmsWechatVote);
	
	public List<YsmsWechatVote> findAll();
	
	public YsmsWechatVote findByNewsAndOpenid(int newsId, String openId);
	
}
