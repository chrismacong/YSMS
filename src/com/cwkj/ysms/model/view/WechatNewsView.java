package com.cwkj.ysms.model.view;

public class WechatNewsView {
	public int newsId;
	public String newsTitle;
	public String newsAuthor;
	public String username;
	public String newsDatestr;
	public String picUrl;
	public String url;
	public String newsContent;
	public String getNewsContent() {
		return newsContent;
	}
	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}
	public int getNewsId() {
		return newsId;
	}
	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}
	public String getNewsTitle() {
		return newsTitle;
	}
	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}
	public String getNewsAuthor() {
		return newsAuthor;
	}
	public void setNewsAuthor(String newsAuthor) {
		this.newsAuthor = newsAuthor;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNewsDatestr() {
		return newsDatestr;
	}
	public void setNewsDatestr(String newsDatestr) {
		this.newsDatestr = newsDatestr;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
