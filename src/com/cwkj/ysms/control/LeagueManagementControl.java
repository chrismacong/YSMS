package com.cwkj.ysms.control;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
import org.springframework.web.servlet.ModelAndView;

import com.cwkj.ysms.model.YsmsLeague;
import com.cwkj.ysms.model.view.LeagueView;
import com.cwkj.ysms.model.view.MarkItemView;
import com.cwkj.ysms.model.view.TeamView;
import com.cwkj.ysms.model.view.ZoneView;
import com.cwkj.ysms.service.GamesStatisticsService;
import com.cwkj.ysms.service.LeagueManagementService;
import com.cwkj.ysms.service.TeamManagementService;
import com.cwkj.ysms.util.Page;
import com.cwkj.ysms.util.PageUtil;
import com.cwkj.ysms.util.ToolsUtil;

@Controller
@RequestMapping(value = "/league")
public class LeagueManagementControl {
	@Resource
	private LeagueManagementService leagueManagementService;
	public LeagueManagementService getLeagueManagementService() {
		return leagueManagementService;
	}
	public void setLeagueManagementService(
			LeagueManagementService leagueManagementService) {
		this.leagueManagementService = leagueManagementService;
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
	private GamesStatisticsService gameStatisticsService;
	public GamesStatisticsService getGameStatisticsService() {
		return gameStatisticsService;
	}
	public void setGameStatisticsService(
			GamesStatisticsService gameStatisticsService) {
		this.gameStatisticsService = gameStatisticsService;
	}
	/**
	 * 获取当前年份的联赛信息
	 * 无参数
	 * @param request
	 * @param session
	 * @param response
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listResult(HttpServletRequest request,HttpSession session,HttpServletResponse response){
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("year", year);
		return new ModelAndView("LeagueManagementPage", model);
	}


	/**
	 * 根据年份获取联赛信息
	 * 参数：year，年份
	 * @param request
	 * @param session
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/leaguesbyyear", method = RequestMethod.POST)
	public Map<String, Object> leaguesByYear(HttpServletRequest request,
			HttpSession session,HttpServletResponse response){
		int year = Integer.parseInt(request.getParameter("year"));
		List<YsmsLeague> list = leagueManagementService.getYearlyLeagues(year);
		List<LeagueView> leagues = new ArrayList<LeagueView>();
		if(list!=null){
			for(int i=0;i<list.size();i++){
				YsmsLeague ysmsLeague = list.get(i);
				if(ysmsLeague.getDeleteflag()==0){
					LeagueView leagueView = new LeagueView();
					leagueView.setLeagueId(ysmsLeague.getLeagueId());
					Date yearDate = ysmsLeague.getLeagueYear();
					Calendar yearCalendar = Calendar.getInstance();
					yearCalendar.setTime(yearDate);
					leagueView.setLeagueYear(yearCalendar.get(Calendar.YEAR));
					leagueView.setTotalNumber(ysmsLeague.getLeagueTotal());
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					leagueView.setRegisterStartDate(sdf.format(ysmsLeague.getRegisterBegintime()));
					leagueView.setRegisterEndDate(sdf.format(ysmsLeague.getRegisterEndtime()));
					leagueView.setModifyAllowed(leagueManagementService.isModifyPermitted(ysmsLeague
							.getLeagueId())?1:0);
					leagueView.setRegisterEnd(leagueManagementService.isRegisterEnd(ysmsLeague
							.getLeagueId())?1:0);
					String leagueStatus = "";
					if(leagueView.isModifyAllowed()==1)
						leagueStatus = "未开始";
					else if(leagueView.isRegisterEnd()==1)
						leagueStatus = "已截止";
					else
						leagueStatus = "进行中";
					leagueView.setLeagueStatus(leagueStatus);
					leagueView.setLeagueName(ysmsLeague.getLeagueName());
					leagues.add(leagueView);
				}
			}
			for(int i=0;i<leagues.size();i++){
				for(int j=i+1;j<leagues.size();j++){
					LeagueView view_i = leagues.get(i);
					LeagueView view_j = leagues.get(j);
					if(view_i.getLeagueStatus().compareTo(view_j.getLeagueStatus())<0){
						leagues.set(i, view_j);
						leagues.set(j, view_i);
					}
				}
			}
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("year", year);
		map.put("league_list", leagues);
		return map;
	}

	/**
	 * 根据联赛Id获取单个联赛信息
	 * 参数 league_id 联赛Id
	 * @param request
	 * @param session
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/leaguebyid", method = RequestMethod.GET)
	public ModelAndView leagueById(HttpServletRequest request,HttpSession session, 
			HttpServletResponse response){
		int leagueId = Integer.parseInt(request.getParameter("league_id"));
		session.setAttribute("leagueId", leagueId);
		YsmsLeague ysmsLeague = leagueManagementService.getLeagueById(leagueId);
		if(ysmsLeague.getDeleteflag()==1)
			return null;
		LeagueView leagueView = new LeagueView();
		leagueView.setLeagueId(ysmsLeague.getLeagueId());
		Date yearDate = ysmsLeague.getLeagueYear();
		Calendar yearCalendar = Calendar.getInstance();
		yearCalendar.setTime(yearDate);
		leagueView.setLeagueYear(yearCalendar.get(Calendar.YEAR));
		leagueView.setTotalNumber(ysmsLeague.getLeagueTotal());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		leagueView.setRegisterStartDate(sdf.format(ysmsLeague.getRegisterBegintime()));
		leagueView.setRegisterEndDate(sdf.format(ysmsLeague.getRegisterEndtime()));
		leagueView.setModifyAllowed(leagueManagementService.isModifyPermitted(ysmsLeague
				.getLeagueId())?1:0);
		leagueView.setRegisterEnd(leagueManagementService.isRegisterEnd(ysmsLeague
				.getLeagueId())?1:0);
		String leagueStatus = "";
		if(leagueView.isModifyAllowed()==1)
			leagueStatus = "未开始";
		else if(leagueView.isRegisterEnd()==1)
			leagueStatus = "已截止";
		else
			leagueStatus = "进行中";
		leagueView.setLeagueStatus(leagueStatus);
		leagueView.setLeagueName(ysmsLeague.getLeagueName());
		//获取联赛分组信息
		List<ZoneView> zoneList = leagueManagementService.getZonesByLeague(leagueId);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("league", leagueView);
		model.put("zones", zoneList);
		model.put("levels", leagueManagementService.getAllLevels());
		return new ModelAndView("LeagueDetailPage", model);
	}

	/**
	 * 添加联赛
	 * 参数：year：联赛年份	level：联赛级别		name：联赛start_date：开始报名时间		end_date：结束报名时间
	 * @param request
	 * @param session
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "addleague", method = RequestMethod.POST)
	public Map<String, Boolean> addLeague(HttpServletRequest request,HttpSession session, 
			HttpServletResponse response){
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		try {
			int year = Integer.parseInt(request.getParameter("year"));
			String name = request.getParameter("name");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date registerStartDate = sdf.parse(request.getParameter("start_date"));
			Date registerEndDate = sdf.parse(request.getParameter("end_date"));

			boolean result = leagueManagementService.addLeague(year, name, 0, registerStartDate, registerEndDate);
			map.put("success", result);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("success", false);
		}
		return map;
	}

	/**
	 * 删除联赛
	 * 参数：league_id:联赛Id
	 * @param request
	 * @param session
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "deleteleague", method = RequestMethod.POST)
	public Map<String, Boolean> deleteLeague(HttpServletRequest request,HttpSession session, 
			HttpServletResponse response){
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		int leagueId = Integer.parseInt(request.getParameter("league_id"));
		boolean result = leagueManagementService.deleteLeague(leagueId);
		if(result){
			map.put("success", true);
		}
		else
			map.put("success", false);
		return map;
	}

	/**
	 * 修改联赛
	 * 参数：league_id:联赛Id， year：联赛年份	 name：联赛名称 		
	 	level：联赛级别	start_date：开始报名时间		end_date：结束报名时间
	 * @param request
	 * @param session
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "modifyleague", method = RequestMethod.POST)
	public Map<String, Boolean> modifyLeague(HttpServletRequest request,HttpSession session, 
			HttpServletResponse response){
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		try {
			int leagueId = Integer.parseInt(request.getParameter("league_id"));
			int year = Integer.parseInt(request.getParameter("year"));
			String name = request.getParameter("name");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date registerStartDate = sdf.parse(request.getParameter("start_date"));
			Date registerEndDate = sdf.parse(request.getParameter("end_date"));
			boolean result = leagueManagementService.modifyLeague(leagueId, year, name, 
					registerStartDate, registerEndDate);
			if(result){
				map.put("success", true);
			}
			else
				map.put("success", false);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("success", false);
		}
		return map;
	}

	/**
	 * 修改联赛结束报名时间和名称
	 * 参数：league_id:联赛Id，	end_date：结束报名时间 	name：联赛名称
	 * @param request
	 * @param session
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "modifyregisterdeadlineandname", method = RequestMethod.GET)
	public Map<String, Boolean> modifyRegisterDeadlineAndName(HttpServletRequest request,
			HttpSession session, HttpServletResponse response){
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		try {
			String leagueName = request.getParameter("name");
			int leagueId = Integer.parseInt(request.getParameter("league_id"));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date registerEndDate = sdf.parse(request.getParameter("end_date"));
			if(leagueManagementService.isRegisterEnd(leagueId)){
				boolean result = leagueManagementService.modifyLeagueRegisterDateAndName(leagueId, 
						leagueName, registerEndDate);
				if(result){
					map.put("success", true);
				}
				else
					map.put("success", false);
			}
			else
				map.put("success", false);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("success", false);
		}
		return map;
	}
	
	/**
	 * 联赛分组(选择球队)
	 * @param request
	 * @param session
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/leaguegroupforteams", method = RequestMethod.POST)
	public Map<String, Boolean> leagueGroupForTeams(HttpServletRequest request,
			HttpSession session, HttpServletResponse response){
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		int zoneId = Integer.parseInt(request.getParameter("zone_id"));
		String teamAndGroup = request.getParameter("team_group");
		String[] teamGroupArray = teamAndGroup.split(",");
		Map<String, Object> teamGroupedMap = new HashMap<String, Object>();
		List<Integer> groupA=new ArrayList<Integer>();
		List<Integer> groupB=new ArrayList<Integer>();
		List<Integer> groupC=new ArrayList<Integer>();
		List<Integer> groupD=new ArrayList<Integer>();
		for(int i=0;i<teamGroupArray.length;i++){
			if(i<=5){
				if(!ToolsUtil.isEmpty(teamGroupArray[i])){
					groupA.add(Integer.parseInt(teamGroupArray[i]));
				}
				
			}else if(i<=11){
				if(!ToolsUtil.isEmpty(teamGroupArray[i])){
					groupB.add(Integer.parseInt(teamGroupArray[i]));
				}
			}else if(i<=17){
				if(!ToolsUtil.isEmpty(teamGroupArray[i])){
					groupC.add(Integer.parseInt(teamGroupArray[i]));
				}
			}else if(i<=23){
				if(!ToolsUtil.isEmpty(teamGroupArray[i])){
					groupD.add(Integer.parseInt(teamGroupArray[i]));
				}
			}

		}
		teamGroupedMap.put("A", groupA);
		teamGroupedMap.put("B", groupB);
		teamGroupedMap.put("C", groupC);
		teamGroupedMap.put("D", groupD);
		 
		boolean result = leagueManagementService.groupTeamsForZone(zoneId, teamGroupedMap);
		map.put("returnMessage", result);
		return map;
	}
	
	/**
	 * 获取联赛报名球队列表
	 * 参数：zone_id:联赛组Id
	 * @param request
	 * @param session
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getteamlistbyzoneid",method=RequestMethod.POST )
	public Map<String, Object> getTeamListByZoneId(HttpServletRequest request,HttpSession session,HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		int zoneId = (int) session.getAttribute("zoneId");
		String currentPage = request.getParameter("currentPage");
		if (!ToolsUtil.isNumeric(currentPage)) {
			currentPage = "1";
		}
		int count = teamManagementService.getSignedTeamByZoneCount(zoneId);
		Page returnPage = new Page();
		Integer returanCurrentPage = 0;
		if (Integer.parseInt(currentPage) == 0) {
			returanCurrentPage = 1;
		} else if (Integer.parseInt(currentPage) <= PageUtil.getTotalPage(10,
				count)) {
			returanCurrentPage = Integer.parseInt(currentPage);

		} else {
			returanCurrentPage = PageUtil.getTotalPage(10, count);
		}
		returnPage.setCurrentPage(returanCurrentPage);
		returnPage.setHasNextPage(PageUtil.getHasNextPage(
				PageUtil.getTotalPage(10, count), returanCurrentPage));
		returnPage.setHasPrePage(PageUtil.getHasPrePage(returanCurrentPage));
		returnPage.setTotalPage(PageUtil.getTotalPage(10, count));
		returnPage.setTotalCount(count);
		List<TeamView> team_list = teamManagementService.getSignedTeamByZone(zoneId,returanCurrentPage);
		//List<TeamView> team_chooselist = teamManagementService.getParticipatedTeamByZone(zoneId);
		map.put("team_list", team_list);
		map.put("page", returnPage);
		//map.put("team_chooselist", team_chooselist);
		return map;
	}

	/**
	 * 获取联赛组报名球队列表
	 * 参数：zone_id:联赛组Id
	 * @param request
	 * @param session
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getteamlistbyzoneidandkey", method = RequestMethod.POST)
	public Map<String, Object> getTeamListByZoneIdAndKey(HttpServletRequest request,HttpSession session,HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		int zoneId = Integer.parseInt(request.getParameter("zone_id"));
		Object key = request.getParameter("key");
		Object type = request.getParameter("type");
		List<TeamView> team_list = null;
		if(key == null){
			team_list = teamManagementService.getSignedTeamByZone(zoneId,0);
		}
		else{
			int searchType = Integer.parseInt(type.toString());
			if(searchType == 1){
				String teamName = key.toString();
				team_list = teamManagementService.getTeamByZoneAndTeamName(zoneId, teamName);
			}
			else if(searchType == 2){
				String schoolName = key.toString();
				team_list = teamManagementService.getTeamByZoneAndSchoolName(zoneId, schoolName);
			}
		}

		map.put("team_list", team_list);
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "getzonesbyleagueid", method = RequestMethod.POST)
	public Map<String, Object> getZoneByLeagueId(HttpServletRequest request,HttpSession session,HttpServletResponse response){
		int leagueId = Integer.parseInt(request.getParameter("league_id"));
		List<ZoneView> zoneList = leagueManagementService.getZonesByLeague(leagueId);
		Map<String, Object> map = new HashMap<String, Object>();
		ZoneView[] zones = new ZoneView[zoneList.size()];
		for(int i=0;i<zoneList.size();i++){
			zones[i] = zoneList.get(i);
		}
		map.put("zones", zones);
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "addzone", method = RequestMethod.POST)
	public Map<String, Object> addZone(HttpServletRequest request,HttpSession session,HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		int leagueId = Integer.parseInt(request.getParameter("league_id"));
		String zoneName = request.getParameter("zone_name");
		String levels = request.getParameter("levels");
		if(levels!=null&&levels.lastIndexOf(";")>-1){
			levels = levels.substring(0,levels.lastIndexOf(";"));
		}
		if(levels!=null){
			String[] level_array = levels.split(";");
			boolean result = leagueManagementService.addZone(leagueId, zoneName, level_array);
			map.put("result", result);
		}
		else{
			map.put("result", false);
		}
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "modifyzone", method = RequestMethod.POST)
	public Map<String, Object> modifyZone(HttpServletRequest request,HttpSession session,HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		int zoneId = Integer.parseInt(request.getParameter("zone_id"));
		String zoneName = request.getParameter("zone_name");
		String levels = request.getParameter("levels");
		if(levels!=null&&levels.lastIndexOf(";")>-1){
			levels = levels.substring(0,levels.lastIndexOf(";"));
		}
		if(levels!=null){
			String[] level_array = levels.split(";");
			boolean result = leagueManagementService.modifyZone(zoneId, zoneName, level_array);
			map.put("result", result);
		}
		else{
			map.put("result", false);
		}
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "deletezone", method = RequestMethod.POST)
	public Map<String, Object> deleteZone(HttpServletRequest request,HttpSession session,HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		int zoneId = Integer.parseInt(request.getParameter("zone_id"));
		boolean result = leagueManagementService.deleteZone(zoneId);
		map.put("result", result);
		return map;
	}
	
	/**
	 * 组别中管理
	 * @param request
	 * @param session
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "zone", method = RequestMethod.GET)
	public ModelAndView zone(HttpServletRequest request,HttpSession session,HttpServletResponse response){
		Map<String, Object> model = new HashMap<String, Object>();
		int zoneId = Integer.parseInt(request.getParameter("zone_id"));
		int leagueId = Integer.parseInt(session.getAttribute("leagueId") + "");
		model.put("league_id", leagueId);
		session.setAttribute("zoneId", zoneId);
		return new ModelAndView("ZoneManagementPage", model);
	}
	
	
	
	@RequestMapping(value = "lsfz", method = RequestMethod.GET)
	public ModelAndView lsfz(){
		return new ModelAndView("LeagueGroup");
	}
	
	
	@RequestMapping(value = "jfpm", method = RequestMethod.GET)
	public ModelAndView jfpm(HttpServletRequest request,HttpSession session,HttpServletResponse response){
		Map<String, Object> model = new HashMap<String, Object>();
		int zoneId = (int) session.getAttribute("zoneId");
		String ruleOrder = leagueManagementService.getListRuleOrder(zoneId);
		model.put("rule_order", ruleOrder);
		return new ModelAndView("RankPage", model);
	}
	
	@ResponseBody
	@RequestMapping(value = "rank", method = RequestMethod.POST)
	public Map<String,Object> rank(HttpServletRequest request,HttpSession session,HttpServletResponse response){
		Map<String, Object> model = new HashMap<String, Object>();
		int zoneId = (int) session.getAttribute("zoneId");
		List<List<MarkItemView>> markList = new ArrayList<List<MarkItemView>>();
		List<String> groupList = leagueManagementService.getDistinctGroupsOfZone(zoneId);
		if(groupList != null){
			for(int i=0;i<groupList.size();i++){
				List<MarkItemView> markForGroup = gameStatisticsService.getLeagueTable(zoneId, groupList.get(i));
				markList.add(markForGroup);
			}
		}
		model.put("groups", groupList);
		model.put("marks", markList);
		return model;
	}

	@ResponseBody
	@RequestMapping(value = "setrules", method = RequestMethod.POST)
	public Map<String, Object> setRules(HttpServletRequest request,HttpSession session,HttpServletResponse response){
		Map<String, Object> model = new HashMap<String, Object>();
		int zoneId = (int) session.getAttribute("zoneId");
		String rulesOrder = request.getParameter("rule_order");
		boolean result = leagueManagementService.setListRuleOrder(zoneId, rulesOrder);
		model.put("success", result);
		return model;
	}
	
	@ResponseBody
	@RequestMapping(value = "getNotSelectedTeams", method = RequestMethod.POST)
	public List<Map<String,Object>> getNotSelectedTeams(HttpServletRequest request){
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		try{
			String zoneId=request.getParameter("zoneId");
			String teamId=request.getParameter("teamId");
			List<Integer> teamIds=new ArrayList<Integer>();
			 
			if(ToolsUtil.isEmpty(zoneId)){
				return list;
			}
			if(!ToolsUtil.isEmpty(teamId)){
				String ids[]=teamId.split(",");
				for(String id:ids){
					teamIds.add(Integer.parseInt(id));
				}
				
			} 
			list=leagueManagementService.getNotSelectedTeams(Integer.parseInt(zoneId), teamIds);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
}
