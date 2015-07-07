package com.cwkj.ysms.wechat.controller;

import net.sf.json.JSONObject;

import com.cwkj.ysms.wechat.tl.HttpGetRequest;

/**
 * 图灵机器人接口流程控制类
 * @author Administrator
 *
 */
public class TulingController {
	private final String TULING_KEY = "aaa4d16a28abd674b1706996ee7a6dee";
	/**
	 * 调用机器人接口，并返回所需内容
	 * @param info
	 * @return
	 */
	public String getTulingRe(String info){
		//调用图灵机器人接口api，获取结果
		String url = "http://www.tuling123.com/openapi/api?key=" + TULING_KEY
															+ "&info=" + info;
		String tlResult = HttpGetRequest.get(url);
		
		//解析图灵结果数据
		JSONObject json = JSONObject.fromObject(tlResult);
		String jsonResult = json.getString("text");
		return jsonResult;
	}

}
