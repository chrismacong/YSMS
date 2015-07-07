package com.cwkj.ysms.control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cwkj.ysms.model.YsmsAthlete;
import com.cwkj.ysms.model.view.FoulView;
import com.cwkj.ysms.model.view.GameView;
import com.cwkj.ysms.model.view.GoalView;
import com.cwkj.ysms.model.view.MemberAthleteView;
import com.cwkj.ysms.service.GamesManagementService;
import com.cwkj.ysms.service.TeamManagementService;
import com.cwkj.ysms.service.WechatService;
import com.cwkj.ysms.wechat.controller.WeChatController;
import com.cwkj.ysms.wechat.service.WechatControllerService;
import com.cwkj.ysms.wechat.util.AccountFinalUtil;
import com.cwkj.ysms.wechat.util.SignUtil;

@Controller
@RequestMapping(value = "/wechat")
public class WeChatControl extends HttpServlet{
	private static String token1 = AccountFinalUtil.token1;
	private static String encodingAESKey1 = AccountFinalUtil.encodingAESKey1;
	private static String appId1 = AccountFinalUtil.appId1;
	private static String appSecret1 = AccountFinalUtil.appSecret1;
	private static String token2 = AccountFinalUtil.token2;
	private static String encodingAESKey2 = AccountFinalUtil.encodingAESKey2;
	private static String appId2 = AccountFinalUtil.appId2;
	private static String appSecret2 = AccountFinalUtil.appSecret2;

	@Resource
	private GamesManagementService gamesManagementService;

	public GamesManagementService getGamesManagementService() {
		return gamesManagementService;
	}
	public void setGamesManagementService(
			GamesManagementService gamesManagementService) {
		this.gamesManagementService = gamesManagementService;
	}

	@Resource
	private TeamManagementService teamManagementService;
	public TeamManagementService getTeamManagementService() {
		return teamManagementService;
	}
	public void setTeamManagementService(TeamManagementService teamManagementService) {
		this.teamManagementService = teamManagementService;
	}

	@Resource
	private WechatService wechatService;
	public WechatService getWechatService() {
		return wechatService;
	}
	public void setWechatService(WechatService wechatService) {
		this.wechatService = wechatService;
	}
	@RequestMapping(method = RequestMethod.GET)
	public void doGet(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) {
		try {
			// 微信加密签名  
			String msg_signature = request.getParameter("signature");
			// 时间戳  
			String timestamp = request.getParameter("timestamp");
			// 随机数  
			String nonce = request.getParameter("nonce");  
			// 随机字符串  
			String echostr = request.getParameter("echostr");  
			System.out.println("request=" + request.getRequestURL());
			PrintWriter out = response.getWriter();  
			//服务号
			if (SignUtil.checkSignature(msg_signature, timestamp, nonce, token1)) {  
				out.print(echostr);
			}
			//订阅号
			else if (SignUtil.checkSignature(msg_signature, timestamp, nonce, token2)) {  
				out.print(echostr);  
			} else {  
				System.out.println("不是微信服务器发来的请求,请小心!");  
			}  
			out.flush();  
			out.close(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping(method = RequestMethod.POST)
	public void listResult(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) {
		// 设置编码方式
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=utf-8");

			//读取微信客户端post过来的数据
			InputStream is = request.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			String str = "";
			StringBuffer sb = new StringBuffer();

			//按行读取内容
			while(null != (str = br.readLine())){
				sb.append(str);
			}
			String message = sb.toString();

			System.out.println("收到来自微信客户端的消息：" + message);

			String result = new WeChatController().wechatProcess(message);
			//返回处理结果
			OutputStream os = response.getOutputStream();
			os.write(result.getBytes("UTF-8"));
			os.flush();
			os.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "result", method = RequestMethod.GET)
	public ModelAndView result(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		Integer athleteId = Integer.parseInt(request.getParameter("athlete_id"));
		session.setAttribute("userName", "wechat"); //需要写入session，否则其他的依然无法访问
		model.put("athlete_id", athleteId);
		return new ModelAndView("WechatResultPage", model);
	}

	@RequestMapping(value = "game", method = RequestMethod.GET)
	public ModelAndView game(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		Integer athleteId = Integer.parseInt(request.getParameter("athlete_id"));
		session.setAttribute("userName", "wechat"); //需要写入session，否则其他的依然无法访问
		model.put("athlete_id", athleteId);
		return new ModelAndView("WechatGamePage", model);
	}
	
	@RequestMapping(value = "bind", method = RequestMethod.GET)
	public ModelAndView bind(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		String openId = request.getParameter("open_id");
		session.setAttribute("userName", "wechat"); //需要写入session，否则其他的依然无法访问
		String headImageUrl = wechatService.findImageUrlByOpenId(openId);
		model.put("headurl", headImageUrl);
		model.put("open_id", openId);
		return new ModelAndView("WechatBindPage", model);
	}
	
	@RequestMapping(value = "unbind", method = RequestMethod.GET)
	public ModelAndView unbind(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		String openId = request.getParameter("open_id");
		session.setAttribute("userName", "wechat"); //需要写入session，否则其他的依然无法访问
		model.put("open_id", openId);
		YsmsAthlete ysmsAthlete = wechatService.findAthleteByOpenId(openId);
		model.put("athlete", ysmsAthlete);
		return new ModelAndView("WechatUnbindPage", model);
	}
	
	@RequestMapping(value = "modifyinfo", method = RequestMethod.GET)
	public ModelAndView modifyInfo(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		String openId = request.getParameter("open_id");
		YsmsAthlete ysmsAthlete = wechatService.findAthleteByOpenId(openId);
		session.setAttribute("userName", "wechat"); //需要写入session，否则其他的依然无法访问
		model.put("athlete", ysmsAthlete);
		return new ModelAndView("WechatModifyInfoPage", model);
	}

	@ResponseBody
	@RequestMapping(value = "getlatestresult", method = RequestMethod.GET)
	public Map<String, Object> getLatestResult(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		Integer athleteId = Integer.parseInt(request.getParameter("athlete_id"));
		GameView gameView = gamesManagementService.getLastGameByAthlete(athleteId);
		model.put("game", gameView);
		if(gameView!=null){
			int gamesId = gameView.getGamesId();
			List<GoalView> hostGoalList = gamesManagementService.getTeamGoalsInGame(gamesId, gameView.getHostTeamId());
			List<GoalView> guestGoalList = gamesManagementService.getTeamGoalsInGame(gamesId, gameView.getGuestTeamId());
			List<FoulView> hostFoulList = gamesManagementService.getTeamFoulInGame(gamesId, gameView.getHostTeamId());
			List<FoulView> guestFoulList = gamesManagementService.getTeamFoulInGame(gamesId, gameView.getGuestTeamId());
			List<MemberAthleteView> hostAthleteList = teamManagementService.getAthleteMemberByTeamId(gameView.getHostTeamId());
			List<MemberAthleteView> guestAthleteList = teamManagementService.getAthleteMemberByTeamId(gameView.getGuestTeamId());
			model.put("host_goals", hostGoalList);
			model.put("guest_goals", guestGoalList);
			model.put("host_fouls",  hostFoulList);
			model.put("guest_fouls", guestFoulList);
			model.put("host_athletes", hostAthleteList);
			model.put("guest_athletes", guestAthleteList);
		}
		return model;
	}

	@ResponseBody
	@RequestMapping(value = "getnextgame", method = RequestMethod.GET)
	public Map<String, Object> getNextGame(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		Integer athleteId = Integer.parseInt(request.getParameter("athlete_id"));
		GameView gameView = gamesManagementService.getNextGameByAthlete(athleteId);
		model.put("game", gameView);
		if(gameView!=null){
			int gamesId = gameView.getGamesId();
			List<GoalView> hostGoalList = gamesManagementService.getTeamGoalsInGame(gamesId, gameView.getHostTeamId());
			List<GoalView> guestGoalList = gamesManagementService.getTeamGoalsInGame(gamesId, gameView.getGuestTeamId());
			List<FoulView> hostFoulList = gamesManagementService.getTeamFoulInGame(gamesId, gameView.getHostTeamId());
			List<FoulView> guestFoulList = gamesManagementService.getTeamFoulInGame(gamesId, gameView.getGuestTeamId());
			List<MemberAthleteView> hostAthleteList = teamManagementService.getAthleteMemberByTeamId(gameView.getHostTeamId());
			List<MemberAthleteView> guestAthleteList = teamManagementService.getAthleteMemberByTeamId(gameView.getGuestTeamId());
			model.put("host_goals", hostGoalList);
			model.put("guest_goals", guestGoalList);
			model.put("host_fouls",  hostFoulList);
			model.put("guest_fouls", guestFoulList);
			model.put("host_athletes", hostAthleteList);
			model.put("guest_athletes", guestAthleteList);
		}
		return model;
	}
	
	@ResponseBody
	@RequestMapping(value = "binduser", method = RequestMethod.GET)
	public Map<String, Object> bindUser(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		String openId = request.getParameter("open_id");
		String identifiedName = request.getParameter("identified_name");
		String identifiedId = request.getParameter("identified_id");
		String registerId = request.getParameter("register_id");
		identifiedName = new String(identifiedName.getBytes("ISO8859-1"),"UTF-8");
		boolean bindResult = wechatService.bindAthleteWechat(openId, identifiedName, identifiedId, registerId);
		model.put("success", bindResult);
		return model;
	}
	
	@ResponseBody
	@RequestMapping(value = "unbinduser", method = RequestMethod.GET)
	public Map<String, Object> unbindUser(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		String openId = request.getParameter("open_id");
		boolean bindResult = wechatService.unbindAthleteWechat(openId);
		model.put("success", bindResult);
		return model;
	}
	
	@ResponseBody
	@RequestMapping(value = "modifyuserinfo", method = RequestMethod.GET)
	public Map<String, Object> modifyUserInfo(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		int athleteId = Integer.parseInt(request.getParameter("athlete_id"));
		int athleteHeight = Integer.parseInt(request.getParameter("athlete_height"));
		int athleteWeight = Integer.parseInt(request.getParameter("athlete_weight"));
		int athleteFootsize = Integer.parseInt(request.getParameter("athlete_footsize"));
		boolean modifyResult = wechatService.modifyUserInfo(athleteId, athleteHeight, athleteWeight, athleteFootsize);
		model.put("success", modifyResult);
		return model;
	}

}
