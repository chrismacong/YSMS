package com.cwkj.ysms.wechat.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.cwkj.ysms.model.YsmsAthlete;
import com.cwkj.ysms.model.YsmsLeague;
import com.cwkj.ysms.model.YsmsWechataccount;
import com.cwkj.ysms.model.YsmsWechatnews;
import com.cwkj.ysms.model.view.GameView;
import com.cwkj.ysms.service.GamesManagementService;
import com.cwkj.ysms.service.LeagueManagementService;
import com.cwkj.ysms.service.NewsManagementService;
import com.cwkj.ysms.service.WechatService;
import com.cwkj.ysms.util.ThtApplicationContext;
import com.cwkj.ysms.wechat.entity.ReceiveXmlEntity;
import com.cwkj.ysms.wechat.service.WechatControllerService;
import com.cwkj.ysms.wechat.util.FormatPicWordXmlResult;
import com.cwkj.ysms.wechat.util.FormatXmlResult;
import com.cwkj.ysms.wechat.util.ParseReceiveXml;
import com.cwkj.ysms.wechat.util.WechatResourceUtil;
import com.cwkj.ysms.wechat.util.WechatResourceUtilBak;

/**
 * 微信流程控制类
 * @author Administrator
 *
 */
public class WeChatController implements WechatControllerService{
	public static final String URL_HEAD = "http://sf.njfootball.cn";
	public String wechatProcess(String content){
		//解析接收到的xml数据，转为对象
		ReceiveXmlEntity rxe = ParseReceiveXml.getMsgEntity(content);
		String realContent = rxe.getContent();
		String msgType = rxe.getMsgType();
		String xmlResult = "";
		String userOpenId = rxe.getFromUserName(); //用户的OPENID值
		String event = "";
		String eventKey = "";
		WechatService wechatService = ThtApplicationContext.getBean(WechatService.class);
		if("event".equals(msgType)){
			event = rxe.getEvent();
			if("subscribe".equals(event)){ //订阅
				YsmsWechataccount account = WechatResourceUtil.getWechatUserInfo(userOpenId);
				if(account == null)
					account = WechatResourceUtilBak.getWechatUserInfo(userOpenId);
				wechatService.saveWechatAccount(account);
			}
			else if("unsubscribe".equals(event)){ //取消订阅
				wechatService.deleteWechatAccount(userOpenId);
			}
			//TODO
			//此处应获取全部用户信息并保存，这需要认证后的微信账号
			if("CLICK".equals(event)){
				eventKey = rxe.getEventKey();
			}
			else{
				String tlResult = "欢迎使用南京市青少年足球联盟公众平台，我是您的服务向导索克！您可以点击下方菜单选择相应功能，也可以直接输入文字与可爱的索克交流哦！";
				return FormatXmlResult.getXmlResult(rxe, tlResult);
			}
		}
		if((eventKey==null||"".equals(eventKey))&&(realContent==null||"".equals(realContent))){
			String tlResult = "欢迎使用南京市青少年足球联盟公众平台，我是您的服务向导索克！您可以点击下方菜单选择相应功能，也可以直接输入文字与可爱的索克交流哦！";
			return FormatXmlResult.getXmlResult(rxe, tlResult);
		}
		boolean isBinded = wechatService.isBinded(userOpenId);
		GamesManagementService gamesManagementService = ThtApplicationContext.getBean(GamesManagementService.class);
		if("最新赛况".equals(realContent)||"23_RESULT".equals(eventKey)){
			if(!isBinded){
				xmlResult = FormatXmlResult.getXmlResult(rxe, "抱歉，必须进行用户绑定后才能使用本功能，请点击“我的账户-用户绑定”完成用户绑定.");
				return xmlResult;
			}
			YsmsAthlete ysmsAthlete = wechatService.findAthleteByOpenId(userOpenId);
			GameView gameView = gamesManagementService.getLastGameByAthlete(ysmsAthlete.getAthleteId());
			String title = "";
			if(gameView==null){
				String tlResult="近期无比赛";
				xmlResult = FormatXmlResult.getXmlResult(rxe, tlResult);
				return xmlResult;
			}
			Integer hostScore = gameView.getHostScore();
			Integer guestScore = gameView.getGuestScore();
			if(hostScore==null||guestScore==null){
				title="信息暂未上报.";
			}
			else{
				int gap = hostScore - guestScore;
				int sub = hostScore + guestScore;
				if(Math.abs(gap)==0){
					if(hostScore>0)
						title="势均力敌！";
					else
						title="握手言和，";
				}
				else if(sub>=6 && gap<=2){
					title="进球大餐！";
				}
				else if(gap==1){
					title="差之毫厘，";
				}
				else if(gap>=4){
					title="一边倒！";
				}
			}
			title += gameView.getHostSchoolName() + gameView.getHostTeamName() +  " " + 
					gameView.getHostScore() + ":" + gameView.getGuestScore() +  " " +
					gameView.getGuestSchoolName() + gameView.getGuestTeamName();
			String description = "点击查看具体比赛数据";
			String url = URL_HEAD + "/wechat/result.html?athlete_id=" + ysmsAthlete.getAthleteId();
			xmlResult = FormatPicWordXmlResult.getXmlResult(rxe, title, description, URL_HEAD + "/images/1.jpg", url);
		}
		else if("最近比赛".equals(realContent)||"22_GAME".equals(eventKey)){
			if(!isBinded){
				xmlResult = FormatXmlResult.getXmlResult(rxe, "抱歉，必须进行用户绑定后才能使用本功能，请点击“我的账户-用户绑定”完成用户绑定.");
				return xmlResult;
			}
			YsmsAthlete ysmsAthlete = wechatService.findAthleteByOpenId(userOpenId);
			GameView gameView = gamesManagementService.getNextGameByAthlete(ysmsAthlete.getAthleteId());
			String title = "";
			if(gameView==null){
				String tlResult="未来无比赛";
				xmlResult = FormatXmlResult.getXmlResult(rxe, tlResult);
				return xmlResult;
			}
			String dateStr = gameView.gameTime;
			if(dateStr!=null){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				try {
					Date date = sdf.parse(dateStr);
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(date);
					title += calendar.get(Calendar.MONTH) + 1 + "月" + calendar.get(Calendar.DAY_OF_MONTH) + "日";
					SimpleDateFormat simple = new SimpleDateFormat("HH:mm");
					title += simple.format(date) + " ";
				} catch (ParseException e) {
					e.printStackTrace();
				}
				title += gameView.getHostSchoolName() + gameView.getHostTeamName() +  " VS " +
						gameView.getGuestSchoolName() + gameView.getGuestTeamName();
			}
			String description = "点击查看具体比赛数据";
			String url = URL_HEAD + "/wechat/game.html?athlete_id=" + ysmsAthlete.getAthleteId();
			xmlResult = FormatPicWordXmlResult.getXmlResult(rxe, title, description, URL_HEAD + "/images/2.jpg", url);
		}
		else if("完善资料".equals(realContent)||"32_INFO".equals(eventKey)){
			if(!isBinded){
				xmlResult = FormatXmlResult.getXmlResult(rxe, "抱歉，必须进行用户绑定后才能使用本功能，请点击“我的账户-用户绑定”完成用户绑定.");
				return xmlResult;
			}
			String title = "完善资料";
			String description = "点击完善运动员资料";
			String url = URL_HEAD + "/wechat/modifyinfo.html?open_id=" + userOpenId;
			xmlResult = FormatPicWordXmlResult.getXmlResult(rxe, title, description, URL_HEAD + "/images/3.jpg", url);
		}
		else if("校足资讯".equals(realContent)||"10_NEWS".equals(eventKey)){
			List<YsmsWechatnews> newsList = new ArrayList<YsmsWechatnews>();
			Calendar calendar = Calendar.getInstance();
			Date date = calendar.getTime();
			NewsManagementService newsManagementService = ThtApplicationContext.getBean(NewsManagementService.class);
			List<YsmsWechatnews> newList = newsManagementService.getNewsByDateLimit10(date,0);
			int day = calendar.get(Calendar.DATE);
			calendar.set(Calendar.DATE, day-1);
			Date yesterday = calendar.getTime();
			
			if(newList.size()==0){
				newList = newsManagementService.getNewsByDateLimit10(yesterday,0); //今天没有用昨天的 避免新闻员来不及写
				if(newList.size()==0){
					//昨天再没有就不是劳资的问题了
					String tlResult="暂无最新新闻。";
					xmlResult = FormatXmlResult.getXmlResult(rxe, tlResult);
				}
				else{
					for(int i=0;i<newList.size();i++){
						YsmsWechatnews wechatNews = newList.get(i);
						wechatNews.setPicurl(URL_HEAD + "/YSMSRepo/news/cover/" + wechatNews.getPicurl());
						wechatNews.setUrl(URL_HEAD + wechatNews.getUrl() + "&open_id=" + userOpenId);
						wechatNews.setDigest("点击下方打开网页查看");
						newsList.add(wechatNews);
					}
					xmlResult = FormatPicWordXmlResult.getNewsResult(rxe, newsList);
				}
			}
			else{
				for(int i=0;i<newList.size();i++){
					YsmsWechatnews wechatNews = newList.get(i);
					wechatNews.setPicurl(URL_HEAD + "/YSMSRepo/news/cover/" + wechatNews.getPicurl());
					wechatNews.setUrl(URL_HEAD + wechatNews.getUrl() + "&open_id=" + userOpenId);
					wechatNews.setDigest("点击下方打开网页查看");
					newsList.add(wechatNews);
				}
				xmlResult = FormatPicWordXmlResult.getNewsResult(rxe, newsList);
			}
			return xmlResult;
		}
		else if("公告".equals(realContent)||"10_NOTICE".equals(eventKey)){
			List<YsmsWechatnews> newsList = new ArrayList<YsmsWechatnews>();
			Calendar calendar = Calendar.getInstance();
			Date date = calendar.getTime();
			NewsManagementService newsManagementService = ThtApplicationContext.getBean(NewsManagementService.class);
			List<YsmsWechatnews> newList = newsManagementService.getNewsByDateLimit10(date,1);
			int day = calendar.get(Calendar.DATE);
			calendar.set(Calendar.DATE, day-1);
			Date yesterday = calendar.getTime();
			
			if(newList.size()==0){
				newList = newsManagementService.getNewsByDateLimit10(yesterday,1); //今天没有用昨天的 避免新闻员来不及写
				if(newList.size()==0){
					//昨天再没有就不是劳资的问题了
					String tlResult="暂无最新新闻。";
					xmlResult = FormatXmlResult.getXmlResult(rxe, tlResult);
				}
				else{
					for(int i=0;i<newList.size();i++){
						YsmsWechatnews wechatNews = newList.get(i);
						wechatNews.setPicurl(URL_HEAD + "/YSMSRepo/news/cover/" + wechatNews.getPicurl());
						wechatNews.setUrl(URL_HEAD + wechatNews.getUrl() + "&open_id=" + userOpenId);
						wechatNews.setDigest("点击下方打开网页查看");
						newsList.add(wechatNews);
					}
					xmlResult = FormatPicWordXmlResult.getNewsResult(rxe, newsList);
				}
			}
			else{
				for(int i=0;i<newList.size();i++){
					YsmsWechatnews wechatNews = newList.get(i);
					wechatNews.setPicurl(URL_HEAD + "/YSMSRepo/news/cover/" + wechatNews.getPicurl());
					wechatNews.setUrl(URL_HEAD + wechatNews.getUrl() + "&open_id=" + userOpenId);
					wechatNews.setDigest("点击下方打开网页查看");
					newsList.add(wechatNews);
				}
				xmlResult = FormatPicWordXmlResult.getNewsResult(rxe, newsList);
			}
			return xmlResult;
		}
		else{
			String tlResult = "";
			if("联赛信息".equals(realContent)||"21_LEAGUE".equals(eventKey)){
				Calendar calendar = Calendar.getInstance();
				int year = calendar.get(Calendar.YEAR);
				LeagueManagementService leagueManagementService = ThtApplicationContext.getBean(LeagueManagementService.class);
				List<YsmsLeague> leagueList = leagueManagementService.getYearlyLeagues(year);
				if(leagueList.size()==0){
					tlResult = "本年度暂时没有联赛";
				}
				else{
					tlResult = "本年度已经或要有组织的联赛包括：";
					for(int i=0;i<leagueList.size();i++){
						tlResult += leagueList.get(i).getLeagueName() + "、";
					}
					tlResult = tlResult.substring(0, tlResult.lastIndexOf("、"));
				}
			}
			else if("相关产品".equals(realContent)||"24_PRODUCT".equals(eventKey)){
				tlResult = "该功能暂未开放";
			}
			else if("用户绑定".equals(realContent)||"31_BIND".equals(eventKey)){
				if(isBinded){
					//已完成绑定，给他回复一个绑定信息界面
					String title = "用户已绑定";
					String description = "点击查看绑定用户信息";
					String url = URL_HEAD + "/wechat/unbind.html?open_id=" + userOpenId;
					xmlResult = FormatPicWordXmlResult.getXmlResult(rxe, title, description, URL_HEAD + "/images/4.jpg", url);
					return xmlResult;
				}
				else{
					//未完成绑定，给他回复一个绑定界面
					String title = "用户绑定";
					String description = "点击进入绑定页";
					String url = URL_HEAD + "/wechat/bind.html?open_id=" + userOpenId;
					xmlResult = FormatPicWordXmlResult.getXmlResult(rxe, title, description, URL_HEAD + "/images/5.jpg", url);
					return xmlResult;
				}
			}
			else{
				//调用图灵机器人接口处理模块，获取图灵机器人的结果
				tlResult = new TulingController().getTulingRe(realContent.replaceAll(" ","")); //去除空格否则报错 	
			}
			//封装微信接口的XML数据
			xmlResult = FormatXmlResult.getXmlResult(rxe, tlResult);
		}

		return xmlResult;
	}
}
