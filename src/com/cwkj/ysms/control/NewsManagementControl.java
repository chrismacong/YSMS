package com.cwkj.ysms.control;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.cwkj.ysms.model.YsmsVote;
import com.cwkj.ysms.model.YsmsWechatnews;
import com.cwkj.ysms.service.NewsManagementService;

@Controller
@RequestMapping(value = "/newsmanagement")
public class NewsManagementControl {
	@Resource
	private NewsManagementService newsManagementService;
	public NewsManagementService getNewsManagementService() {
		return newsManagementService;
	}

	public void setNewsManagementService(NewsManagementService newsManagementService) {
		this.newsManagementService = newsManagementService;
	}

	/**
	 * 打开新闻管理界面
	 * 
	 * @param request
	 * @param session
	 * @param response
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listResult(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) {
		return new ModelAndView("NewsManagementPage");
	}
	
	@RequestMapping(value = "servicenews", method = RequestMethod.GET)
	public ModelAndView serviceNews(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) {
		return new ModelAndView("ServiceNewsManagementPage");
	}

	@RequestMapping(value = "newslist", method = RequestMethod.GET)
	public ModelAndView listNews(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) {
		return new ModelAndView("NewsListPage");
	}
	
	@RequestMapping(value = "servicenewslist", method = RequestMethod.GET)
	public ModelAndView listServiceNews(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) {
		return new ModelAndView("ServiceNewsListPage");
	}

	@RequestMapping(value = "newslistforverify", method = RequestMethod.GET)
	public ModelAndView listNewsForVerify(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) {
		return new ModelAndView("NewsVerifyPage");
	}
	
	@RequestMapping(value = "verifymanagement", method = RequestMethod.GET)
	public ModelAndView verifyManagement(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) {
		return new ModelAndView("NewsVerifyManagementPage");
	}
	
	@RequestMapping(value = "servicenewslistforverify", method = RequestMethod.GET)
	public ModelAndView listServiceNewsForVerify(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) {
		return new ModelAndView("ServiceNewsVerifyPage");
	}

	@RequestMapping(value = "votelist", method = RequestMethod.GET)
	public ModelAndView listVote(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) {
		return new ModelAndView("VoteListPage");
	}
	
	@RequestMapping(value = "servicevotelist", method = RequestMethod.GET)
	public ModelAndView listServiceVote(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) {
		return new ModelAndView("ServiceVoteListPage");
	}

	@RequestMapping(value = "editnews", method = RequestMethod.GET)
	public ModelAndView editNews(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) {
		return new ModelAndView("NewsEditPage");
	}
	
	@RequestMapping(value = "editservicenews", method = RequestMethod.GET)
	public ModelAndView editServiceNews(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) {
		return new ModelAndView("ServiceNewsEditPage");
	}

	@RequestMapping(value = "news", method = RequestMethod.GET)
	public ModelAndView news(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) {
		int newsId= Integer.parseInt(request.getParameter("nid"));
		String openIdStr = request.getParameter("open_id");
		String openId = "0";
		if(openIdStr!=null)
			openId = openIdStr;
		Map<String, Object> model = newsManagementService.getNews(newsId);
		model.put("openid", openId);
		if(newsManagementService.isVoted(newsId, openId))
			return new ModelAndView("redirect:/newsmanagement/voteresult.html?nid=" + newsId);
		return new ModelAndView("NewsPage", model);
	}

	@RequestMapping(value = "newsformodify", method = RequestMethod.GET)
	public ModelAndView newsformodify(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) {
		int newsId= Integer.parseInt(request.getParameter("nid"));
		String openIdStr = request.getParameter("open_id");
		String openId = "0";
		if(openIdStr!=null)
			openId = openIdStr;
		Map<String, Object> model = newsManagementService.getNewsForModify(newsId);
		model.put("openid", openId);
		if(newsManagementService.isVoted(newsId, openId))
			return new ModelAndView("redirect:/newsmanagement/voteresult.html?nid=" + newsId);
		return new ModelAndView("NewsModifyPage", model);
	}

	@RequestMapping(value = "voteresult", method = RequestMethod.GET)
	public ModelAndView voteResult(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) {
		Map<String, Object> model = new HashMap<String, Object>();
		int newsId= Integer.parseInt(request.getParameter("nid"));
		List<YsmsVote> resultList = newsManagementService.getVoteResult(newsId);
		model.put("results", resultList);
		return new ModelAndView("VoteAlreadyPage", model);
	}

	@ResponseBody
	@RequestMapping(value = "getnews", method = RequestMethod.POST)
	public Map<String, Object> getNews(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			String dateStr = request.getParameter("date");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
			Date date = sdf.parse(dateStr);
			List<YsmsWechatnews> newsList = newsManagementService.getNewsByDate(date,0);
			model.put("news", newsList);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model;
	}
	
	@ResponseBody
	@RequestMapping(value = "getservicenews", method = RequestMethod.POST)
	public Map<String, Object> getServiceNews(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			String dateStr = request.getParameter("date");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
			Date date = sdf.parse(dateStr);
			List<YsmsWechatnews> newsList = newsManagementService.getNewsByDate(date,1);
			model.put("news", newsList);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model;
	}

	@ResponseBody
	@RequestMapping(value = "getnewsforverify", method = RequestMethod.POST)
	public Map<String, Object> getNewsForVerify(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			String dateStr = request.getParameter("date");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
			Date date = sdf.parse(dateStr);
			List<YsmsWechatnews> newsList = newsManagementService.getNewsByDateForVerify(date,0);
			model.put("news", newsList);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model;
	}
	
	@ResponseBody
	@RequestMapping(value = "getservicenewsforverify", method = RequestMethod.POST)
	public Map<String, Object> getServiceNewsForVerify(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			String dateStr = request.getParameter("date");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
			Date date = sdf.parse(dateStr);
			List<YsmsWechatnews> newsList = newsManagementService.getNewsByDateForVerify(date,1);
			model.put("news", newsList);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model;
	}

	@ResponseBody
	@RequestMapping(value = "getvote", method = RequestMethod.POST)
	public Map<String, Object> getVote(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			String dateStr = request.getParameter("date");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
			Date date = sdf.parse(dateStr);
			List<YsmsWechatnews> newsList = newsManagementService.getVoteByDate(date,0);
			model.put("news", newsList);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model;
	}
	
	@ResponseBody
	@RequestMapping(value = "getservicevote", method = RequestMethod.POST)
	public Map<String, Object> getServiceVote(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			String dateStr = request.getParameter("date");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
			Date date = sdf.parse(dateStr);
			List<YsmsWechatnews> newsList = newsManagementService.getVoteByDate(date,1);
			model.put("news", newsList);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model;
	}

	@ResponseBody
	@RequestMapping(value = "vote", method = RequestMethod.POST)
	public Map<String, Object> vote(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) {
		Map<String, Object> model = new HashMap<String, Object>();
		int newsId = Integer.parseInt(request.getParameter("news_id"));
		String openId = request.getParameter("open_id");
		String paths = request.getParameter("paths");
		boolean result = newsManagementService.vote(newsId, openId, paths);
		model.put("success", result);
		return model;
	}

	@ResponseBody
	@RequestMapping(value = "switchnews", method = RequestMethod.POST)
	public Map<String, Object> switchNews(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) {
		Map<String, Object> model = new HashMap<String, Object>();
		int newsId_up2down = Integer.parseInt(request.getParameter("news_up2down"));
		int newsId_down2up = Integer.parseInt(request.getParameter("news_down2up"));
		boolean result = newsManagementService.switchNewsIndex(newsId_down2up, newsId_up2down);
		model.put("success", result);
		return model;
	}

	@ResponseBody
	@RequestMapping(value = "deletenews", method = RequestMethod.POST)
	public Map<String, Object> deleteNews(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) {
		Map<String, Object> model = new HashMap<String, Object>();
		int newsId = Integer.parseInt(request.getParameter("news"));
		boolean result = newsManagementService.deleteNews(newsId);
		model.put("success", result);
		return model;
	}


	@ResponseBody
	@RequestMapping(value="uploadimage", method = RequestMethod.POST)
	public Map<String, Object> uploadImg(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Object userIdInSession = session.getAttribute("userId");
			if (userIdInSession == null) {
				map.put("success", false);
				map.put("mesg", "网络会话失效，请重新登陆！");
				return map;
			}

			if (request instanceof DefaultMultipartHttpServletRequest) {
				DefaultMultipartHttpServletRequest rq = (DefaultMultipartHttpServletRequest) request;
				if (rq != null) {
					int userId = Integer.parseInt(userIdInSession
							.toString());
					Map<String, MultipartFile> file_list = rq.getFileMap();
					if (file_list != null && file_list.size() > 0) {
						if (file_list.containsKey("file")) {
							String forwardDir = request.getSession().getServletContext()
									.getRealPath("../") + File.separator +"YSMSRepo" + File.separator + "news" + File.separator + "attachment";//路径dir
							MultipartFile file = file_list
									.get("file");
							String result = newsManagementService.saveImageFile(file, userId, forwardDir);
							if(result!=null){
								map.put("dir", result);
								map.put("success", true);
							}
							else{
								map.put("success", false);
								map.put("mesg", "上传图片失败！");
							}
						}
					}
				}
			} else {
				map.put("success", false);
				map.put("mesg", "上传图片失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		return map;
	}

	@ResponseBody
	@RequestMapping(value="verify", method = RequestMethod.POST)
	public Map<String, Object> verify(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			int verified = Integer.parseInt(request.getParameter("verified"));
			int newsId = Integer.parseInt(request.getParameter("newsId"));
			boolean result = newsManagementService.verify(newsId, verified);
			map.put("success", result);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		return map;
	}

	/**
	 * @param request
	 * @param session
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="uploadnews", method = RequestMethod.POST)
	public Map<String, Object> uploadNews(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Object userIdInSession = session.getAttribute("userId");
			if (userIdInSession == null) {
				map.put("success", false);
				map.put("mesg", "网络会话失效，请重新登陆！");
				return map;
			}
			String newsTitle = "";
			String newsAuthor = "";
			String content = "";
			String isOn = "";
			String resultPath = "";
			if (request instanceof DefaultMultipartHttpServletRequest) {
				DefaultMultipartHttpServletRequest rq = (DefaultMultipartHttpServletRequest) request;
				if (rq != null) {
					Map<String, String[]> params_list = rq.getParameterMap();
					if (params_list != null && params_list.size() > 0) {
						//新闻标题
						if (params_list.containsKey("news_title")) {
							String[] titles = params_list.get("news_title");
							if (titles != null && titles.length == 1) {
								newsTitle = titles[0];
							}
						}
						else{
							map.put("success", false);
							map.put("mesg", "上传图片失败！");
						}
						//新闻作者
						if (params_list.containsKey("news_author")) {
							String[] authors = params_list.get("news_author");
							if (authors != null && authors.length == 1) {
								newsAuthor = authors[0];
							}
						}
						else{
							map.put("success", false);
							map.put("mesg", "上传图片失败！");
						}
						//新闻内容
						if (params_list.containsKey("news_html")) {
							String[] contents = params_list.get("news_html");
							if (contents != null && contents.length == 1) {
								content = contents[0];
							}
						}
						else{
							map.put("success", false);
							map.put("mesg", "上传图片失败！");
						}
						//是否置顶
						if (params_list.containsKey("zhiding")) {
							String[] checks = params_list.get("zhiding");
							if (checks != null && checks.length == 1) {
								isOn = checks[0];
							}
						}
						else{
							map.put("success", false);
							map.put("mesg", "上传图片失败！");
						}
					}
					int userId = Integer.parseInt(userIdInSession
							.toString());
					Map<String, MultipartFile> file_list = rq.getFileMap();
					if (file_list != null && file_list.size() > 0) {
						if (file_list.containsKey("coverimg")) {
							String forwardDir = request.getSession().getServletContext()
									.getRealPath("../") + File.separator +"YSMSRepo" + File.separator + "news" + File.separator + "cover";//路径dir
							MultipartFile file = file_list
									.get("coverimg");
							resultPath = newsManagementService.saveImageFile(file, userId, forwardDir);
						}
					}
					boolean isTop = false;
					if("on".equals(isOn)){
						isTop = true;
					}

					boolean result = newsManagementService.saveNews(newsTitle, newsAuthor, isTop, content, resultPath, userId,0);
					if(result){
						map.put("success", true);
					}
					else{
						map.put("success", false);
						map.put("mesg", "新闻发布失败！");
					}
				}
			} else {
				map.put("success", false);
				map.put("mesg", "新闻发布失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		return map;
	}
	
	/**
	 * @param request
	 * @param session
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="uploadservicenews", method = RequestMethod.POST)
	public Map<String, Object> uploadServiceNews(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Object userIdInSession = session.getAttribute("userId");
			if (userIdInSession == null) {
				map.put("success", false);
				map.put("mesg", "网络会话失效，请重新登陆！");
				return map;
			}
			String newsTitle = "";
			String newsAuthor = "";
			String content = "";
			String isOn = "";
			String resultPath = "";
			if (request instanceof DefaultMultipartHttpServletRequest) {
				DefaultMultipartHttpServletRequest rq = (DefaultMultipartHttpServletRequest) request;
				if (rq != null) {
					Map<String, String[]> params_list = rq.getParameterMap();
					if (params_list != null && params_list.size() > 0) {
						//新闻标题
						if (params_list.containsKey("news_title")) {
							String[] titles = params_list.get("news_title");
							if (titles != null && titles.length == 1) {
								newsTitle = titles[0];
							}
						}
						else{
							map.put("success", false);
							map.put("mesg", "上传图片失败！");
						}
						//新闻作者
						if (params_list.containsKey("news_author")) {
							String[] authors = params_list.get("news_author");
							if (authors != null && authors.length == 1) {
								newsAuthor = authors[0];
							}
						}
						else{
							map.put("success", false);
							map.put("mesg", "上传图片失败！");
						}
						//新闻内容
						if (params_list.containsKey("news_html")) {
							String[] contents = params_list.get("news_html");
							if (contents != null && contents.length == 1) {
								content = contents[0];
							}
						}
						else{
							map.put("success", false);
							map.put("mesg", "上传图片失败！");
						}
						//是否置顶
						if (params_list.containsKey("zhiding")) {
							String[] checks = params_list.get("zhiding");
							if (checks != null && checks.length == 1) {
								isOn = checks[0];
							}
						}
						else{
							map.put("success", false);
							map.put("mesg", "上传图片失败！");
						}
					}
					int userId = Integer.parseInt(userIdInSession
							.toString());
					Map<String, MultipartFile> file_list = rq.getFileMap();
					if (file_list != null && file_list.size() > 0) {
						if (file_list.containsKey("coverimg")) {
							String forwardDir = request.getSession().getServletContext()
									.getRealPath("../") + File.separator +"YSMSRepo" + File.separator + "news" + File.separator + "cover";//路径dir
							MultipartFile file = file_list
									.get("coverimg");
							resultPath = newsManagementService.saveImageFile(file, userId, forwardDir);
						}
					}
					boolean isTop = false;
					if("on".equals(isOn)){
						isTop = true;
					}
					
					boolean result = newsManagementService.saveNews(newsTitle, newsAuthor, isTop, content, resultPath, userId,1);
					if(result){
						map.put("success", true);
					}
					else{
						map.put("success", false);
						map.put("mesg", "新闻发布失败！");
					}
				}
			} else {
				map.put("success", false);
				map.put("mesg", "新闻发布失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		return map;
	}


	@ResponseBody
	@RequestMapping(value="broadcast", method = RequestMethod.POST)
	public Map<String, Object> broadcast(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Object userIdInSession = session.getAttribute("userId");
		String forwardDir = request.getSession().getServletContext()
				.getRealPath("../") + File.separator +"YSMSRepo" + File.separator + "news" + File.separator + "cover";//路径dir
		if (userIdInSession == null) {
			map.put("success",false);
			return map;
		}
		try {
			String checked = request.getParameter("checked");
			boolean result = newsManagementService.broadcast(checked, forwardDir);
			map.put("success", result);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		return map;
	}

	@ResponseBody
	@RequestMapping(value="broadcastservice", method = RequestMethod.POST)
	public Map<String, Object> broadcastService(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Object userIdInSession = session.getAttribute("userId");
		String forwardDir = request.getSession().getServletContext()
				.getRealPath("../") + File.separator +"YSMSRepo" + File.separator + "news" + File.separator + "cover";//路径dir
		if (userIdInSession == null) {
			map.put("success",false);
			return map;
		}
		try {
			String checked = request.getParameter("checked");
			boolean result = newsManagementService.broadcastService(checked, forwardDir);
			map.put("success", result);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		return map;
	}
	@ResponseBody
	@RequestMapping(value="newsmodify", method = RequestMethod.POST)
	public Map<String, Object> newsmodify(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Object userIdInSession = session.getAttribute("userId");
		String content = request.getParameter("content");
		int newsId = Integer.parseInt(request.getParameter("news_id"));
		if (userIdInSession == null) {
			map.put("success",false);
			return map;
		}
		boolean result = newsManagementService.updateNewsContent(newsId, content);
		map.put("success", result);
		return map;
	}
}
