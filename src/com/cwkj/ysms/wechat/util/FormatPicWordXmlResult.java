package com.cwkj.ysms.wechat.util;

import java.util.Calendar;
import java.util.List;

import com.cwkj.ysms.model.YsmsWechatnews;
import com.cwkj.ysms.wechat.entity.ReceiveXmlEntity;

public class FormatPicWordXmlResult {
	/**
	 * 封装xml数据
	 * @param rxe ReceiveXmlEntity对象
	 * @param tlResult 图灵机器人返回的结果
	 * @return
	 */
	public static String getXmlResult(ReceiveXmlEntity rxe, String title, String description, String picUrl, String url){
		StringBuffer sb = new StringBuffer();
		sb.append("<xml><ToUserName><![CDATA[");
		sb.append(rxe.getFromUserName());
		sb.append("]]></ToUserName><FromUserName><![CDATA[");
		sb.append(rxe.getToUserName());
		sb.append("]]></FromUserName><CreateTime>");
		Calendar calendar = Calendar.getInstance();
		sb.append(calendar.getTime());
		sb.append("</CreateTime><MsgType><![CDATA[news]]></MsgType><ArticleCount>1</ArticleCount><Articles><item><Title><![CDATA[");
		sb.append(title);
		sb.append("]]></Title><Description><![CDATA[");
		sb.append(description);
		sb.append("]]></Description><PicUrl><![CDATA[");
		sb.append(picUrl);
		sb.append("]]></PicUrl><Url><![CDATA[");
		sb.append(url);
		sb.append("]]></Url></item></Articles><Title><![CDATA[");
		sb.append(title);
		sb.append("]]></Title><Description><![CDATA[");
		sb.append(description);
		sb.append("]]></Description><PicUrl><![CDATA[");
		sb.append(picUrl);
		sb.append("]]></PicUrl><Url><![CDATA[");
		sb.append(url);
		sb.append("]]></Url></xml>");
		return sb.toString();
	}
	/**
	 * 封装xml数据
	 * @param rxe ReceiveXmlEntity对象
	 * @param tlResult 图灵机器人返回的结果
	 * @return
	 */
	public static String getXmlResult(ReceiveXmlEntity rxe, String title, String description, String url){
		StringBuffer sb = new StringBuffer();
		sb.append("<xml><ToUserName><![CDATA[");
		sb.append(rxe.getFromUserName());
		sb.append("]]></ToUserName><FromUserName><![CDATA[");
		sb.append(rxe.getToUserName());
		sb.append("]]></FromUserName><CreateTime>");
		Calendar calendar = Calendar.getInstance();
		sb.append(calendar.getTime());
		sb.append("</CreateTime><MsgType><![CDATA[news]]></MsgType><ArticleCount>1</ArticleCount><Articles><item><Title><![CDATA[");
		sb.append(title);
		sb.append("]]></Title><Description><![CDATA[");
		sb.append(description);
		sb.append("]]></Description><Url><![CDATA[");
		sb.append(url);
		sb.append("]]></Url></item></Articles><Title><![CDATA[");
		sb.append(title);
		sb.append("]]></Title><Description><![CDATA[");
		sb.append(description);
		sb.append("]]></Description><Url><![CDATA[");
		sb.append(url);
		sb.append("]]></Url></xml>");
		return sb.toString();
	}
	

	/**
	 * 生成多条被动回复图文信息
	 * @param rxe
	 * @param newsList
	 * @return
	 */
	public static String getNewsResult(ReceiveXmlEntity rxe, List<YsmsWechatnews> newsList){
		StringBuffer sb = new StringBuffer();
		sb.append("<xml><ToUserName><![CDATA[");
		sb.append(rxe.getFromUserName());
		sb.append("]]></ToUserName><FromUserName><![CDATA[");
		sb.append(rxe.getToUserName());
		sb.append("]]></FromUserName><CreateTime>");
		Calendar calendar = Calendar.getInstance();
		sb.append(calendar.getTime());
		sb.append("</CreateTime><MsgType><![CDATA[news]]></MsgType><ArticleCount>");
		sb.append(newsList.size());
		sb.append("</ArticleCount>");
		sb.append("<Articles>");
		for(int i=0;i<newsList.size();i++){
			YsmsWechatnews news = newsList.get(i);
			sb.append("<item><Title><![CDATA[");
			sb.append(news.getTitle());
			sb.append("]]></Title><Description><![CDATA[");
			sb.append(news.getDigest());
			sb.append("]]></Description><PicUrl><![CDATA[");
			sb.append(news.getPicurl());
			sb.append("]]></PicUrl><Url><![CDATA[");
			sb.append(news.getUrl());
			sb.append("]]></Url></item>");
		}
		sb.append("</Articles></xml>");
		return sb.toString();
	}
}
