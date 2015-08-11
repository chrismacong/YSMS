package com.cwkj.ysms.service.impl;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cwkj.ysms.dao.UserDao;
import com.cwkj.ysms.dao.VoteDao;
import com.cwkj.ysms.dao.WechatVoteDao;
import com.cwkj.ysms.dao.WechataccountDao;
import com.cwkj.ysms.dao.WechatnewsAttrDao;
import com.cwkj.ysms.dao.WechatnewsDao;
import com.cwkj.ysms.model.YsmsVote;
import com.cwkj.ysms.model.YsmsWechatVote;
import com.cwkj.ysms.model.YsmsWechataccount;
import com.cwkj.ysms.model.YsmsWechatnews;
import com.cwkj.ysms.model.YsmsWechatnewsAttr;
import com.cwkj.ysms.model.view.NewsView;
import com.cwkj.ysms.model.view.WechatArticleView;
import com.cwkj.ysms.service.NewsManagementService;
import com.cwkj.ysms.wechat.util.WechatResourceUtil;
import com.cwkj.ysms.wechat.util.WechatResourceUtilBak;

@Service
public class NewsManagementServiceImpl implements NewsManagementService{
	@Resource
	private UserDao userDao;


	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Resource
	private WechatnewsDao wechatNewsDao;

	public WechatnewsDao getWechatNewsDao() {
		return wechatNewsDao;
	}

	public void setWechatNewsDao(WechatnewsDao wechatNewsDao) {
		this.wechatNewsDao = wechatNewsDao;
	}

	@Resource
	private WechatnewsAttrDao wechatnewsAttrDao;

	public WechatnewsAttrDao getWechatnewsAttrDao() {
		return wechatnewsAttrDao;
	}

	public void setWechatnewsAttrDao(WechatnewsAttrDao wechatnewsAttrDao) {
		this.wechatnewsAttrDao = wechatnewsAttrDao;
	}

	@Resource
	private VoteDao voteDao;

	public VoteDao getVoteDao() {
		return voteDao;
	}

	public void setVoteDao(VoteDao voteDao) {
		this.voteDao = voteDao;
	}

	@Resource
	private WechatVoteDao wechatVoteDao;

	public WechatVoteDao getWechatVoteDao() {
		return wechatVoteDao;
	}

	public void setWechatVoteDao(WechatVoteDao wechatVoteDao) {
		this.wechatVoteDao = wechatVoteDao;
	}

	@Resource
	private WechataccountDao wechataccountDao;

	public WechataccountDao getWechataccountDao() {
		return wechataccountDao;
	}

	public void setWechataccountDao(WechataccountDao wechataccountDao) {
		this.wechataccountDao = wechataccountDao;
	}

	public String saveImageFile(MultipartFile file, int userId, String forwardDir){
		try {
			String originalFilename = file.getOriginalFilename();
			System.out.println(originalFilename);
			String fileType = originalFilename.substring(originalFilename.lastIndexOf("."));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			Calendar calendar = Calendar.getInstance();
			String fileName = sdf.format(calendar.getTime()) + "_" + userId + fileType;
			String finalDir = forwardDir + File.separator + fileName;
			File saveFile = new File(finalDir);
			if (file != null) {
				file.transferTo(saveFile);
				return fileName;
			}
			return null;
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean saveNews(String newsTitle, String newsAuthor, boolean isTop,
			String content, String coverImagePath, int userId, int forServiceFlag) {
		YsmsWechatnews ysmsWechatnews = new YsmsWechatnews();
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		ysmsWechatnews.setAuthor(newsAuthor);
		ysmsWechatnews.setDate(date);
		if(isTop){
			ysmsWechatnews.setNindex(1);
			List<YsmsWechatnews> newsList = wechatNewsDao.findByDate(date);
			for(int i=0;i<newsList.size();i++){
				YsmsWechatnews newsToAddIndex = newsList.get(i);
				newsToAddIndex.setNindex(newsToAddIndex.getNindex()+1);
				wechatNewsDao.save(newsToAddIndex);
			}
		}
		else
			ysmsWechatnews.setNindex(wechatNewsDao.getMaxNindex(date)+1);
		ysmsWechatnews.setPicurl(coverImagePath);
		ysmsWechatnews.setTitle(newsTitle);
		ysmsWechatnews.setYsmsUser(userDao.findById(userId));
		ysmsWechatnews.setVerified(0);
		ysmsWechatnews.setForServiceFlag(forServiceFlag);
		wechatNewsDao.save(ysmsWechatnews);
		int newsId = ysmsWechatnews.getNid();
		ysmsWechatnews.setUrl("/newsmanagement/news.html?nid=" + newsId);
		wechatNewsDao.save(ysmsWechatnews);
		YsmsWechatnewsAttr wechatNewsAttr = new YsmsWechatnewsAttr();
		content = content.replaceAll("contenteditable=\"true\"", "contenteditable=\"false\"");
		content = content.replaceAll("editor_obj border_", "editor_obj");
		content = content.replaceAll("class=\"delete_obj\"", "class=\"delete_obj\" style='display:none;'");
		content = content.replaceAll("name=\"praise\" disabled=\"disabled\"", "name=\"praise\"");
		wechatNewsAttr.setContent(content);
		wechatNewsAttr.setYsmsWechatnews(ysmsWechatnews);
		wechatnewsAttrDao.save(wechatNewsAttr);

		//筛选出其中的投票部分，加入到投票中
		while(content.indexOf("id=\"voteimage_")>-1){
			content = content.substring(content.indexOf("id=\"voteimage_") + 14);//把这一段截掉
			String imagePath = content.substring(0, content.indexOf("\"")); //图片文件名
			YsmsVote ysmsVote = new YsmsVote();
			ysmsVote.setImagePath(imagePath);
			ysmsVote.setVoteNum(0);
			ysmsVote.setYsmsWechatnews(ysmsWechatnews);
			voteDao.save(ysmsVote);
		}
		return true;
	}

	@Override
	public List<YsmsWechatnews> getNewsByDate(Date date, int forServiceFlag) {
		if(forServiceFlag == 0)
			return wechatNewsDao.findByDate(date);
		else
			return wechatNewsDao.findServiceNewsByDate(date);
	}

	@Override
	public boolean switchNewsIndex(int news_id_down2up, int news_id_up2down) {
		YsmsWechatnews news_down2up = wechatNewsDao.findById(news_id_down2up); //这个是要向上switch的新闻
		YsmsWechatnews news_up2down = wechatNewsDao.findById(news_id_up2down); //这个是要向下switch的新闻
		int index_down2up = news_down2up.getNindex();
		int index_up2down = news_up2down.getNindex();
		news_down2up.setNindex(index_up2down);
		news_up2down.setNindex(index_down2up);
		wechatNewsDao.save(news_up2down);
		wechatNewsDao.save(news_down2up);
		return true;
	}

	@Override
	public boolean deleteNews(int newsId) {
		YsmsWechatnews news = wechatNewsDao.findById(newsId);
		wechatNewsDao.delete(news);
		return true;
	}

	@Override
	public Map<String, Object> getNews(int newsId) {
		Map<String, Object> model = new HashMap<String, Object>();
		YsmsWechatnews wechatNews = wechatNewsDao.findById(newsId);
		NewsView newsView = new NewsView();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		newsView.setAuthor(wechatNews.getAuthor());
		newsView.setDateStr(sdf.format(wechatNews.getDate()));
		newsView.setNid(wechatNews.getNid());
		newsView.setTitle(wechatNews.getTitle());
		YsmsWechatnewsAttr newsattr = wechatnewsAttrDao.findByNewsId(newsId);
		model.put("news", newsView);
		model.put("newsattr", newsattr);
		return model;
	}

	@Override
	public List<YsmsWechatnews> getNewsByDateLimit10(Date date, int forServiceFlag) {
		if(forServiceFlag == 0)
			return wechatNewsDao.findByDateLimit10(date);
		else
			return wechatNewsDao.findServiceNewsByDateLimit10(date);
	}

	@Override
	public boolean vote(int newsId, String openId, String paths) {
		String[] path_seperate = paths.split(",");
		for(int i=0;i<path_seperate.length;i++){
			System.out.println(path_seperate[i]);
			if(path_seperate[i]!=null){
				YsmsVote ysmsVote = voteDao.findByNewsAndImage(newsId, path_seperate[i]);
				if(ysmsVote!=null){
					ysmsVote.setVoteNum(ysmsVote.getVoteNum()+1);
					voteDao.save(ysmsVote);
				}
			}
		}
		//投完票，添加一条记录信息
		YsmsWechatVote ysmsWechatVote = new YsmsWechatVote();
		ysmsWechatVote.setVoteflag(1);
		YsmsWechataccount wechatAccount = wechataccountDao.findByOpenid(openId);
		if(wechatAccount==null)
			return false;
		ysmsWechatVote.setYsmsWechataccount(wechatAccount);
		ysmsWechatVote.setYsmsWechatnews(wechatNewsDao.findById(newsId));
		wechatVoteDao.save(ysmsWechatVote);
		return true;
	}

	@Override
	public boolean isVoted(int newsId, String openId) {
		YsmsWechatVote wechatVote = wechatVoteDao.findByNewsAndOpenid(newsId, openId);
		if(wechatVote!=null)
			return true;
		return false;
	}

	@Override
	public List<YsmsWechatnews> getVoteByDate(Date date, int forServiceFlag) {
		if(forServiceFlag == 0)
			return wechatNewsDao.findVoteByDate(date);
		else
			return wechatNewsDao.findServiceVoteByDate(date);
	}

	@Override
	public List<YsmsVote> getVoteResult(int newsId) {
		return voteDao.findByNews(newsId);
	}

	@Override
	public NewsView getSimpleNews(int newsId) {
		YsmsWechatnews wechatNews = wechatNewsDao.findById(newsId);
		NewsView newsView = new NewsView();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		newsView.setAuthor(wechatNews.getAuthor());
		newsView.setDateStr(sdf.format(wechatNews.getDate()));
		newsView.setNid(wechatNews.getNid());
		newsView.setTitle(wechatNews.getTitle());
		return newsView;
	}

	@Override
	public List<YsmsWechatnews> getNewsByDateForVerify(Date date, int forServiceFlag) {
		if(forServiceFlag == 0)
			return wechatNewsDao.findByDateOrderbyVerified(date);
		else
			return wechatNewsDao.findServiceNewsByDateOrderbyVerified(date);
	}

	@Override
	public boolean verify(int newsId, int verified) {
		YsmsWechatnews wechatNews = wechatNewsDao.findById(newsId);
		if(wechatNews==null)
			return false;
		wechatNews.setVerified(verified);
		wechatNewsDao.save(wechatNews);
		return true;
	}

	@Override
	public boolean broadcast(String checked, String forwardDir) {
		String[] checked_list = checked.split(",");
		List<WechatArticleView> list = new ArrayList<WechatArticleView>();
		for(int i=0;i<checked_list.length;i++){
			if(checked_list[i]!=null&&!"".equals(checked_list[i])){
				int newsId = Integer.parseInt(checked_list[i]);
				YsmsWechatnews news = wechatNewsDao.findById(newsId);
				if(news.getVerified()==1){//通过审核
					WechatArticleView view = new WechatArticleView();
					view.setAuthor(news.getAuthor());
					view.setContent("<html><head></head><body>请点击下方“阅读全文”查看文章</body></html>");
					view.setContent_source_url("http://sf.njfootball.cn" + news.getUrl());
					view.setDigest(news.getDigest());
					view.setShow_cover_pic("1");
					view.setThumb_media_id(WechatResourceUtilBak.uploadImage(new File(forwardDir + File.separator + news.getPicurl()))); //只有订阅号发送
//					view.setThumb_media_id(WechatResourceUtil.uploadImage(new File(forwardDir + File.separator + news.getPicurl()))); //只有订阅号发送
					view.setTitie(news.getTitle());
					list.add(view);
				}
			}
		}
		String mediaId = WechatResourceUtilBak.broadcastMsg(list);
		boolean result = WechatResourceUtilBak.broadcast(mediaId);
//		String mediaId = WechatResourceUtil.broadcastMsg(list);
//		boolean result = WechatResourceUtil.broadcast(mediaId);
		System.out.println("群发结果（订阅号）:" + result);
		return result;
	}

	@Override
	public boolean broadcastService(String checked, String forwardDir) {
		String[] checked_list = checked.split(",");
		List<WechatArticleView> list = new ArrayList<WechatArticleView>();
		for(int i=0;i<checked_list.length;i++){
			if(checked_list[i]!=null&&!"".equals(checked_list[i])){
				int newsId = Integer.parseInt(checked_list[i]);
				YsmsWechatnews news = wechatNewsDao.findById(newsId);
				if(news.getVerified()==1){//通过审核
					WechatArticleView view = new WechatArticleView();
					view.setAuthor(news.getAuthor());
					view.setContent("<html><head></head><body>请点击下方“阅读全文”查看文章</body></html>");
					view.setContent_source_url("http://sf.njfootball.cn" + news.getUrl());
					view.setDigest(news.getDigest());
					view.setShow_cover_pic("1");
					view.setThumb_media_id(WechatResourceUtil.uploadImage(new File(forwardDir + File.separator + news.getPicurl()))); //只有订阅号发送
					view.setTitie(news.getTitle());
					list.add(view);
				}
			}
		}
		String mediaId = WechatResourceUtil.broadcastMsg(list);
		boolean result = WechatResourceUtil.broadcast(mediaId);
		System.out.println("群发结果（服务号）:" + result);
		return result;
	}

	@Override
	public Map<String, Object> getNewsForModify(int newsId) {
		Map<String, Object> model = new HashMap<String, Object>();
		YsmsWechatnews wechatNews = wechatNewsDao.findById(newsId);
		NewsView newsView = new NewsView();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		newsView.setAuthor(wechatNews.getAuthor());
		newsView.setDateStr(sdf.format(wechatNews.getDate()));
		newsView.setNid(wechatNews.getNid());
		newsView.setTitle(wechatNews.getTitle());
		YsmsWechatnewsAttr newsattr = wechatnewsAttrDao.findByNewsId(newsId);
		String content = newsattr.getContent();
		content = content.replaceAll("contenteditable=\"false\"", "contenteditable=\"true\"");
		newsattr.setContent(content);
		model.put("news", newsView);
		model.put("newsattr", newsattr);
		return model;
	}

	@Override
	public boolean updateNewsContent(int newsId, String content) {
		YsmsWechatnewsAttr newsattr = wechatnewsAttrDao.findByNewsId(newsId);
		content = content.replaceAll("contenteditable=\"true\"", "contenteditable=\"false\"");
		newsattr.setContent(content);
		wechatnewsAttrDao.save(newsattr);
		return true;
	}
}
