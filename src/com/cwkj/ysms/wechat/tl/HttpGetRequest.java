package com.cwkj.ysms.wechat.tl;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * http get请求类
 * @author Administrator
 *
 */
public class HttpGetRequest {
	/**
	 * get请求
	 * @param url
	 * @return
	 */
	public static String get(String url){
		try {
			HttpGet request = new HttpGet(url);
			//执行http get请求
			HttpResponse response = HttpClients.createDefault().execute(request);
			
			//根据返回码判断是否成功
			String result = "";
			if(response.getStatusLine().getStatusCode() == 200){
				result = EntityUtils.toString(response.getEntity());
			}
			return result;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
		
		
	}
}
