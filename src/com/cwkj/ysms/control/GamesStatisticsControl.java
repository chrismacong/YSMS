package com.cwkj.ysms.control;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cwkj.ysms.model.YsmsLeague;
import com.cwkj.ysms.model.YsmsLeagueZone;
import com.cwkj.ysms.model.view.LeagueView;
import com.cwkj.ysms.service.GamesStatisticsService;

@Controller
@RequestMapping(value = "/gamesstatistics")
public class GamesStatisticsControl {
	@Resource
	private GamesStatisticsService gamesStatisticsServices;

	public GamesStatisticsService getGamesStatisticsServices() {
		return gamesStatisticsServices;
	}

	public void setGamesStatisticsServices(
			GamesStatisticsService gamesStatisticsServices) {
		this.gamesStatisticsServices = gamesStatisticsServices;
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public List<LeagueView> judgePresentation(HttpServletRequest request,HttpSession session,
		HttpServletResponse response){
		int judgeId = Integer.parseInt(request.getParameter("judge_id"));
		List<YsmsLeagueZone> leagueZone_list = gamesStatisticsServices.getJudgePresentation(judgeId);
		List<LeagueView> results = new ArrayList<LeagueView>();
		if (leagueZone_list !=null) {
			for (int i = 0; i < leagueZone_list.size(); i++) {
				//此处只需要联赛年份、联赛类型、联赛年即可
				YsmsLeagueZone ysmsLeagueZone = leagueZone_list.get(i);
				YsmsLeague ysmsLeague = ysmsLeagueZone.getYsmsLeague();
				LeagueView leagueView = new LeagueView();
				leagueView.setLeagueId(ysmsLeague.getLeagueId());
				Date yearDate = ysmsLeague.getLeagueYear();
				Calendar yearCalendar = Calendar.getInstance();
				yearCalendar.setTime(yearDate);
				leagueView.setLeagueYear(yearCalendar.get(Calendar.YEAR));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				leagueView.setLeagueName(ysmsLeague.getLeagueName());
				results.add(leagueView);
			}
		}
		return results;
	}
}
