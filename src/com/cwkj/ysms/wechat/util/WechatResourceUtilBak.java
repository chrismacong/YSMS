package com.cwkj.ysms.wechat.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.json.JSONObject;

import com.cwkj.ysms.model.YsmsWechataccount;
import com.cwkj.ysms.model.view.WechatArticleView;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * 订阅号想关
 * @author chrismacong
 *
 */
public class WechatResourceUtilBak {
	public static final String UPLOAD_IMAGE_URL = "https://api.weixin.qq.com/cgi-bin/material/add_material";
	/**
	 * 获得ACCESS_TOKEN
	 * @Title: getAccess_token
	 * @Description: 获得ACCESS_TOKEN
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public static String getAccess_token(){  

		String APPID = AccountFinalUtil.appId2;
		String APPSECRET = AccountFinalUtil.appSecret2;

		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+ APPID + "&secret=" +APPSECRET;
		String accessToken = null;
		try {
			URL urlGet = new URL(url);
			HttpURLConnection http = (HttpURLConnection) urlGet.openConnection();    

			http.setRequestMethod("GET");      //必须是get方式请求    
			http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");    
			http.setDoOutput(true);        
			http.setDoInput(true);
			System.setProperty("sun.net.client.defaultConnectTimeout", "30000");//连接超时30秒
			System.setProperty("sun.net.client.defaultReadTimeout", "30000"); //读取超时30秒

			http.connect();

			InputStream is =http.getInputStream();
			int size =is.available();
			byte[] jsonBytes =new byte[size];
			is.read(jsonBytes);
			String message=new String(jsonBytes,"UTF-8");

			JSONObject demoJson = new JSONObject(message);
			accessToken = demoJson.getString("access_token");

			System.out.println(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return accessToken;
	}

	/**
	 * 创建Menu
	 * @Title: createMenu
	 * @Description: 创建Menu
	 * @param @return
	 * @param @throws IOException    设定文件
	 * @return int    返回类型
	 * @throws
	 */
	public static String createMenu() {
		String menu = "{\"button\":[{\"type\":\"click\",\"name\":\"校足资讯\",\"key\":\"10_NEWS\"}" + 
				",{\"type\":\"click\",\"name\":\"联赛信息\",\"key\":\"21_LEAGUE\"}" + 
				",{\"type\":\"click\",\"name\":\"相关产品\",\"key\":\"24_PRODUCT\"}]}";
		//此处改为自己想要的结构体，替换即可
		String access_token= getAccess_token();

		String action = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+access_token;
		try {
			URL url = new URL(action);
			HttpURLConnection http =   (HttpURLConnection) url.openConnection();    

			http.setRequestMethod("POST");        
			http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");    
			http.setDoOutput(true);        
			http.setDoInput(true);
			System.setProperty("sun.net.client.defaultConnectTimeout", "30000");//连接超时30秒
			System.setProperty("sun.net.client.defaultReadTimeout", "30000"); //读取超时30秒

			http.connect();
			OutputStream os= http.getOutputStream();    
			os.write(menu.getBytes("UTF-8"));//传入参数    
			os.flush();
			os.close();

			InputStream is =http.getInputStream();
			int size =is.available();
			byte[] jsonBytes =new byte[size];
			is.read(jsonBytes);
			String message=new String(jsonBytes,"UTF-8");
			return "返回信息"+message;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}    
		return "createMenu 失败";
	}
	public static boolean broadcast(String mediaId) {
		String broadcast = "{\"filter\":{\"is_to_all\":true,\"group_id\":\"0\"},\"mpnews\":{\"media_id\":\"" + mediaId + "\"},\"msgtype\":\"mpnews\"}";
		System.out.println(broadcast);
		//此处改为自己想要的结构体，替换即可
		String access_token= getAccess_token();
		
		String action = "https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token="+access_token;
		try {
			URL url = new URL(action);
			HttpURLConnection http =   (HttpURLConnection) url.openConnection();    
			
			http.setRequestMethod("POST");        
			http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");    
			http.setDoOutput(true);        
			http.setDoInput(true);
			System.setProperty("sun.net.client.defaultConnectTimeout", "30000");//连接超时30秒
			System.setProperty("sun.net.client.defaultReadTimeout", "30000"); //读取超时30秒
			
			http.connect();
			OutputStream os= http.getOutputStream();    
			os.write(broadcast.getBytes("UTF-8"));//传入参数    
			os.flush();
			os.close();
			
			InputStream is =http.getInputStream();
			int size =is.available();
			byte[] jsonBytes =new byte[size];
			is.read(jsonBytes);
			String message=new String(jsonBytes,"UTF-8");
			JsonParser jsonparer = new JsonParser();// 初始化解析json格式的对象
			JsonObject json = jsonparer.parse(message)
			.getAsJsonObject();
			System.out.println(json.toString());
			if (json.get("errcode") == null||json.get("errcode").toString().equals("0"))
			{ 
				return true;
			}
			return false;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}    
		return false;
	}

	/**
	 * 删除当前Menu
	 * @Title: deleteMenu
	 * @Description: 删除当前Menu
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public static String deleteMenu()
	{
		String access_token= getAccess_token();
		String action = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token="+access_token;
		try {
			URL url = new URL(action);
			HttpURLConnection http =   (HttpURLConnection) url.openConnection();    

			http.setRequestMethod("GET");        
			http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");    
			http.setDoOutput(true);        
			http.setDoInput(true);
			System.setProperty("sun.net.client.defaultConnectTimeout", "30000");//连接超时30秒
			System.setProperty("sun.net.client.defaultReadTimeout", "30000"); //读取超时30秒

			http.connect();
			OutputStream os= http.getOutputStream();    
			os.flush();
			os.close();

			InputStream is =http.getInputStream();
			int size =is.available();
			byte[] jsonBytes =new byte[size];
			is.read(jsonBytes);
			String message=new String(jsonBytes,"UTF-8");
			return "deleteMenu返回信息:"+message;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "deleteMenu 失败";   
	}

	public static YsmsWechataccount getWechatUserInfo(String openId){
		YsmsWechataccount account = new YsmsWechataccount();
		String access_token = WechatResourceUtilBak.getAccess_token();
		String userInfo_for_api = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=" + 
				access_token + "&openid=" + openId + "&lang=zh_CN";
		//		System.out.println(userInfo_for_api);
		try {
			URL urlGet = new URL(userInfo_for_api);
			HttpURLConnection http = (HttpURLConnection) urlGet.openConnection();    

			http.setRequestMethod("GET");      //必须是get方式请求    
			http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");    
			http.setDoOutput(true);        
			http.setDoInput(true);
			System.setProperty("sun.net.client.defaultConnectTimeout", "30000");//连接超时30秒
			System.setProperty("sun.net.client.defaultReadTimeout", "30000"); //读取超时30秒

			http.connect();

			InputStream is =http.getInputStream();
			int size =is.available();
			byte[] jsonBytes =new byte[size];
			is.read(jsonBytes);
			String message=new String(jsonBytes,"UTF-8");

			JSONObject demoJson = new JSONObject(message);
			System.out.println(message.toString());
			String subscribe = demoJson.getString("subscribe");//是否订阅公众号，若为0表示没有，那么我们就不为它提供其他信息
			account.setSubscribe(Integer.parseInt(subscribe));
			String nickname = demoJson.getString("nickname");//用户昵称
			account.setNickname(nickname);
			String headimgurl = demoJson.getString("headimgurl");//用户头像
			account.setHeadimgurl(headimgurl);
			String language = demoJson.getString("language");//语言
			account.setLanguage(language);
			String city = demoJson.getString("city");
			account.setCity(city);
			String province = demoJson.getString("province");
			account.setProvince(province);
			String country = demoJson.getString("country");
			account.setCountry(country);
			String subscribeTime = demoJson.getString("subscribe_time");
			account.setSubscribeTime(subscribeTime);
			String remark = demoJson.getString("remark");
			account.setRemark(remark);
			account.setGroupid(2);
			account.setOpenid(openId);
			//String result = subscribe + " " + nickname + " " + headimgurl;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return account;
	}

	public static String uploadImage(File file) {
		org.apache.commons.httpclient.HttpClient client = new org.apache.commons.httpclient.HttpClient();
		String uploadurl = String.format("%s?access_token=%s&type=%s", UPLOAD_IMAGE_URL, getAccess_token(), "thumb");
		PostMethod post = new PostMethod(uploadurl);
		post.setRequestHeader(
				"User-Agent",
				"Mozilla/5.0 (Macintosh; Intel Mac OS X 10.9; rv:30.0) Gecko/20100101 Firefox/30.0");
		post.setRequestHeader("Host", "file.api.weixin.qq.com");
		post.setRequestHeader("Connection", "Keep-Alive");
		post.setRequestHeader("Cache-Control", "no-cache");
		String result = null;
		try
		{
			if (file != null && file.exists())
			{
				FilePart filepart = new FilePart("media", file, "image/jpeg",
						"UTF-8");
				Part[] parts = new Part[] { filepart };
				MultipartRequestEntity entity = new MultipartRequestEntity(
						parts,

						post.getParams());
				post.setRequestEntity(entity);
				int status = client.executeMethod(post);
				if (status == HttpStatus.SC_OK)
				{
					String responseContent = post.getResponseBodyAsString();
					JsonParser jsonparer = new JsonParser();// 初始化解析json格式的对象
					JsonObject json = jsonparer.parse(responseContent)
					.getAsJsonObject();
					//System.out.println(json.toString());
					if (json.get("errcode") == null)// {"errcode":40004,"errmsg":"invalid media type"}
					{ // 上传成功  {"type":"TYPE","media_id":"MEDIA_ID","created_at":123456789}
						result = json.get("media_id").getAsString();
					}
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			return result;
		}
		
	}
	

	public static String broadcastMsg(List<WechatArticleView> list){
		StringBuffer articles = new StringBuffer("{\"articles\":[");
		for(int i=0;i<list.size();i++){
			WechatArticleView wav = list.get(i);
			articles.append("{");
			articles.append("\"title\":\"" + wav.getTitie() + "\",");
			articles.append("\"thumb_media_id\":\"" + wav.getThumb_media_id() + "\",");
			articles.append("\"author\":\"" + wav.getAuthor() + "\",");
			articles.append("\"digest\":\"" + wav.getDigest() + "\",");
			articles.append("\"show_cover_pic\":\"" + wav.getShow_cover_pic() + "\",");
			articles.append("\"content\":\"" + wav.getContent() + "\",");
			articles.append("\"content_source_url\":\"" + wav.getContent_source_url()+ "\"");
			articles.append("}");
			if(i+1<list.size()){
				articles.append(",");
			}
		}
		articles.append("]}");
//		System.out.println(articles.toString());
		String access_token= getAccess_token();
		String action = "https://api.weixin.qq.com/cgi-bin/material/add_news?access_token="+access_token;
		try {
			URL url = new URL(action);
			HttpURLConnection http =   (HttpURLConnection) url.openConnection();    

			http.setRequestMethod("POST");        
			http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");    
			http.setDoOutput(true);        
			http.setDoInput(true);
			System.setProperty("sun.net.client.defaultConnectTimeout", "30000");//连接超时30秒
			System.setProperty("sun.net.client.defaultReadTimeout", "30000"); //读取超时30秒

			http.connect();
			OutputStream os= http.getOutputStream();    
			os.write(articles.toString().getBytes("UTF-8"));//传入参数    
//			os.write(test_str.getBytes("UTF-8"));//传入参数    
			os.flush();
			os.close();

			InputStream is =http.getInputStream();
			int size =is.available();
			byte[] jsonBytes =new byte[size];
			is.read(jsonBytes);
			String message=new String(jsonBytes,"UTF-8");
			JsonParser jsonparer = new JsonParser();// 初始化解析json格式的对象
			JsonObject json = jsonparer.parse(message)
			.getAsJsonObject();
			if (json.get("errcode") == null)// {"errcode":40004,"errmsg":"invalid media type"}
			{ // 上传成功  {"type":"TYPE","media_id":"MEDIA_ID","created_at":123456789}
				return(json.get("media_id").getAsString());
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}    
		return "broadcastMsg 失败";
	}

	public static void main(String[] args) {
		System.out.println("------------");
		System.out.println(createMenu());
		System.out.println("------------");
	}
}