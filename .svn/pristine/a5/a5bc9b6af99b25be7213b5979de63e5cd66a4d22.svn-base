package com.cwkj.ysms.test.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cwkj.ysms.wechat.controller.WeChatController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:WebContent/WEB-INF/springMVC-servlet.xml")
public class TestWechatController {
	@Autowired
	private WeChatController weChatController;
	
	@Test
	public void testWechatProcess() {
		String content = "<xml><ToUserName><![CDATA[gh_63550eeb41b3]]></ToUserName><FromUserName><![CDATA[ol5Xcs6jlhGANjQ19RjAwlT3yTek]]></FromUserName><CreateTime>1432618007</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[联赛信息]]></Content><MsgId>6153047487933312898</MsgId></xml>";
		System.out.println(weChatController.wechatProcess(content));
		String content2 = "<xml><ToUserName><![CDATA[gh_63550eeb41b3]]></ToUserName><FromUserName><![CDATA[ol5Xcs6jlhGANjQ19RjAwlT3yTek]]></FromUserName><CreateTime>1432618007</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[王苏]]></Content><MsgId>6153047487933312898</MsgId></xml>";
		System.out.println(weChatController.wechatProcess(content2));
	}
}
