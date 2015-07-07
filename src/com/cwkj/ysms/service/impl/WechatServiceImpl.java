package com.cwkj.ysms.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cwkj.ysms.dao.AthleteDao;
import com.cwkj.ysms.dao.UserDao;
import com.cwkj.ysms.dao.WechataccountDao;
import com.cwkj.ysms.dao.WechatnewsAttrDao;
import com.cwkj.ysms.dao.WechatnewsDao;
import com.cwkj.ysms.model.YsmsAthlete;
import com.cwkj.ysms.model.YsmsUser;
import com.cwkj.ysms.model.YsmsWechataccount;
import com.cwkj.ysms.model.YsmsWechatnews;
import com.cwkj.ysms.model.YsmsWechatnewsAttr;
import com.cwkj.ysms.model.view.WechatNewsView;
import com.cwkj.ysms.service.WechatService;

@Service
public class WechatServiceImpl implements WechatService{

	@Resource
	private WechataccountDao wechataccountDao;
	
	@Resource
	private AthleteDao athleteDao;
	
	@Resource
	private UserDao userDao;
	
	@Resource
	private WechatnewsDao wechatnewsDao;
	
	@Resource
	private WechatnewsAttrDao wechatnewsAttrDao;
	public WechatnewsDao getWechatnewsDao() {
		return wechatnewsDao;
	}

	public void setWechatnewsDao(WechatnewsDao wechatnewsDao) {
		this.wechatnewsDao = wechatnewsDao;
	}

	public WechatnewsAttrDao getWechatnewsAttrDao() {
		return wechatnewsAttrDao;
	}

	public void setWechatnewsAttrDao(WechatnewsAttrDao wechatnewsAttrDao) {
		this.wechatnewsAttrDao = wechatnewsAttrDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public WechataccountDao getWechataccountDao() {
		return wechataccountDao;
	}

	public void setWechataccountDao(WechataccountDao wechataccountDao) {
		this.wechataccountDao = wechataccountDao;
	}

	public AthleteDao getAthleteDao() {
		return athleteDao;
	}

	public void setAthleteDao(AthleteDao athleteDao) {
		this.athleteDao = athleteDao;
	}

	@Override
	public boolean isOpenIdExist(String openId) {
		YsmsWechataccount ysmsWechataccount = wechataccountDao.findByOpenid(openId);
		if(ysmsWechataccount==null)
			return false;
		return true;
	}

	@Override
	public boolean saveWechatAccount(YsmsWechataccount ysmsWechataccount) {
		ysmsWechataccount.setDeleteflag(0);
		wechataccountDao.save(ysmsWechataccount);
		return true;
	}

	@Override
	public YsmsAthlete findAthleteByOpenId(String openId) {
		YsmsWechataccount ysmsWechataccount = wechataccountDao.findByOpenid(openId);
		if(ysmsWechataccount!=null){
			return ysmsWechataccount.getYsmsAthlete();
		}
		return null;
	}

	@Override
	public boolean bindAthleteWechat(String openId, String identifiedName,
			String identifiedId, String registerId) {
		List<YsmsAthlete> athleteList = athleteDao.findForBinding(identifiedName, identifiedId, registerId);
		if(athleteList==null||athleteList.size()==0)
			return false;
		else{
			YsmsAthlete ysmsAthlete = athleteList.get(0);
			YsmsWechataccount ysmsWechataccount = wechataccountDao.findByOpenid(openId);
			if(ysmsWechataccount==null)
				return false;
			ysmsWechataccount.setYsmsAthlete(ysmsAthlete);
			wechataccountDao.save(ysmsWechataccount);
			return true;
		}
	}

	@Override
	public boolean unbindAthleteWechat(String openId) {
		YsmsWechataccount ysmsWechataccount = wechataccountDao.findByOpenid(openId);
		if(ysmsWechataccount==null)
			return false;
		ysmsWechataccount.setYsmsAthlete(null);
		wechataccountDao.save(ysmsWechataccount);
		return true;
	}

	@Override
	public boolean isBinded(String openId) {
		YsmsWechataccount ysmsWechataccount = wechataccountDao.findByOpenid(openId);
		if(ysmsWechataccount==null)
			return false;
		YsmsAthlete ysmsAthlete = ysmsWechataccount.getYsmsAthlete();
		if(ysmsAthlete==null)
			return false;
		return true;
	}

	@Override
	public boolean modifyUserInfo(int athleteId, int athleteHeight,
			int athleteWeight, int athleteFootsize) {
		YsmsAthlete ysmsAthlete = athleteDao.findById(athleteId);
		ysmsAthlete.setAthleteHeight(athleteHeight);
		ysmsAthlete.setAthleteWeight(athleteWeight);
		ysmsAthlete.setAthleteFootsize(athleteFootsize);
		athleteDao.save(ysmsAthlete);
		return true;
	}

	@Override
	public boolean deleteWechatAccount(String openId) {
		YsmsWechataccount ysmsWechataccount = wechataccountDao.findByOpenid(openId);
		wechataccountDao.delete(ysmsWechataccount);
		return true;
	}

	@Override
	public boolean publishNews(int userId, String title, String author,
			String content, String picUrl) {
		YsmsWechatnews ysmsWechatnews = new YsmsWechatnews();
		YsmsUser ysmsUser = userDao.findById(userId);
		ysmsWechatnews.setYsmsUser(ysmsUser);
		ysmsWechatnews.setTitle(title);
		ysmsWechatnews.setAuthor(author);
		ysmsWechatnews.setPicurl(picUrl);
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		ysmsWechatnews.setDate(date);
		if(ysmsUser == null)
			return false;
		ysmsWechatnews.setYsmsUser(ysmsUser);
		wechatnewsDao.save(ysmsWechatnews);
		ysmsWechatnews.setNindex(ysmsWechatnews.getNid()); //将id值设置为index，保证后插入的新闻index更大。可以通过调换顺序更换index
		ysmsWechatnews.setUrl("/getnews.html?news_id=" + ysmsWechatnews.getNid()); //设置url，此处可能需要加密或者使用uuid
		wechatnewsDao.save(ysmsWechatnews); //再次保存
		YsmsWechatnewsAttr ysmsWechatnewsAttr = new YsmsWechatnewsAttr();
		ysmsWechatnewsAttr.setYsmsWechatnews(ysmsWechatnews);
		ysmsWechatnewsAttr.setContent(content);
		wechatnewsAttrDao.save(ysmsWechatnewsAttr);
		return true;
		
	}

	@Override
	public boolean switchNewsOrder(int newsId1, int newsId2) {
		// TODO Auto-generated method stub
		YsmsWechatnews ysmsWechatnew1 = wechatnewsDao.findById(newsId1);
		YsmsWechatnews ysmsWechatnew2 = wechatnewsDao.findById(newsId2);
		int index1 = ysmsWechatnew1.getNindex();
		ysmsWechatnew1.setNindex(ysmsWechatnew2.getNindex());
		ysmsWechatnew2.setNindex(index1);
		wechatnewsDao.save(ysmsWechatnew1);
		wechatnewsDao.save(ysmsWechatnew2);
		return true;
	}

	@Override
	public List<WechatNewsView> getNewsByDate(Date date) {
		List<WechatNewsView> result = new ArrayList<WechatNewsView>();
		List<YsmsWechatnews> list = wechatnewsDao.findByDate(date);
		for(int i=0;i<list.size();i++){
			YsmsWechatnews news = list.get(i);
			WechatNewsView wechatNewsView = new WechatNewsView();
			wechatNewsView.setNewsAuthor(news.getAuthor());
			Date dateInDb = news.getDate();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			wechatNewsView.setNewsDatestr(sdf.format(dateInDb));
			wechatNewsView.setNewsId(news.getNid());
			wechatNewsView.setNewsTitle(news.getTitle());
			wechatNewsView.setPicUrl(news.getPicurl());
			wechatNewsView.setUrl(news.getUrl());
			wechatNewsView.setUsername(news.getYsmsUser().getUserName());
			result.add(wechatNewsView);
		}
		return result;
	}

	@Override
	public WechatNewsView getNewsDetailById(int newsId) {
		YsmsWechatnews news = wechatnewsDao.findById(newsId);
		YsmsWechatnewsAttr newsAttr = wechatnewsAttrDao.findByNewsId(newsId);
		WechatNewsView wechatNewsView = new WechatNewsView();
		wechatNewsView.setNewsAuthor(news.getAuthor());
		Date dateInDb = news.getDate();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		wechatNewsView.setNewsDatestr(sdf.format(dateInDb));
		wechatNewsView.setNewsId(news.getNid());
		wechatNewsView.setNewsTitle(news.getTitle());
		wechatNewsView.setPicUrl(news.getPicurl());
		wechatNewsView.setUrl(news.getUrl());
		wechatNewsView.setUsername(news.getYsmsUser().getUserName());
		wechatNewsView.setNewsContent(newsAttr.getContent());
		return wechatNewsView;
	}

	@Override
	public boolean deleteNews(int newsId) {
		YsmsWechatnews news = wechatnewsDao.findById(newsId);
		YsmsWechatnewsAttr newsAttr = wechatnewsAttrDao.findByNewsId(newsId);
		if(news!=null){
			wechatnewsDao.delete(news);
		}
		if(newsAttr!=null){
			wechatnewsAttrDao.delete(newsAttr);
		}
		return true;
	}

	@Override
	public String findImageUrlByOpenId(String openId) {
		YsmsWechataccount account = wechataccountDao.findByOpenid(openId);
		String imageUrl = account.getHeadimgurl();
		System.out.println(account.getWid());
		System.out.println(imageUrl);
		if(imageUrl==null||"".equals(imageUrl)) //若为空，显示默认图片
			return "../images/logo.png";
		return imageUrl;
	}

}
