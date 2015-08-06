package com.cwkj.ysms.control;

import java.util.Calendar;
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
import org.springframework.web.servlet.ModelAndView;

import com.cwkj.ysms.model.view.CardSchoolView;
import com.cwkj.ysms.model.view.GameView;
import com.cwkj.ysms.service.GamesManagementService;
import com.cwkj.ysms.service.SchoolManagementService;

@Controller
@RequestMapping(value = "/management")
public class ManagementPlatformMainControl {

	@Resource
	private SchoolManagementService schoolManagementService;
	public SchoolManagementService getSchoolManagementService() {
		return schoolManagementService;
	}
	public void setSchoolManagementService(
			SchoolManagementService schoolManagementService) {
		this.schoolManagementService = schoolManagementService;
	}
	
	@Resource
	private GamesManagementService gamesManagementService;
	
	public GamesManagementService getGamesManagementService() {
		return gamesManagementService;
	}
	public void setGamesManagementService(
			GamesManagementService gamesManagementService) {
		this.gamesManagementService = gamesManagementService;
	}
	/**
	 * 管理平台主页面
	 * @param request
	 * @param session
	 * @param response
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listResult(HttpServletRequest request,HttpSession session,HttpServletResponse response){
		/*获取session获取角色信息，包括session中的角色名，根据不同角色返回不同界面*/
		//		int roleId = Integer.parseInt(session.getAttribute("roleId").toString());
		//		String username = session.getAttribute("username").toString();
		Map<String, Object> model = new HashMap<String, Object>();
		String userNickName = (String) session.getAttribute("userName");
		Object schoolId = session.getAttribute("schoolId");
		if(schoolId!=null)
			userNickName = schoolManagementService.getSchoolByID(Integer.parseInt(schoolId.toString())).getSchoolName();
		model.put("username",userNickName);
		return new ModelAndView("ManagementPlatformMainPage", model);
	}
	
	@RequestMapping(value = "/calendar", method = RequestMethod.GET)
	public ModelAndView leaguesByYear(HttpServletRequest request,
			HttpSession session,HttpServletResponse response){
		return new ModelAndView("MainCalendarPage");
	}
	
	@ResponseBody
	@RequestMapping(value = "/getevents", method = RequestMethod.POST)
	public Map<String, String> getEvents(HttpServletRequest request,
			HttpSession session,HttpServletResponse response){
		Object schoolId = session.getAttribute("schoolId");
		int year = Integer.parseInt(request.getParameter("year"));
		int month = Integer.parseInt(request.getParameter("month"));
		Map<String, String> codropsEvents = new HashMap<String, String>();
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		if(schoolId!=null){
			List<GameView> games = gamesManagementService.getGamesByMonthAndSchool(
					Integer.parseInt(schoolId.toString()), calendar.getTime());
			codropsEvents = gamesManagementService.getMapForCalendar(games);
		}
		if(schoolId==null){
			List<GameView> games = gamesManagementService.getAllGamesByMonth(calendar.getTime());
			codropsEvents = gamesManagementService.getMapForCalendar(games);
		}
		return codropsEvents;
	}
}
