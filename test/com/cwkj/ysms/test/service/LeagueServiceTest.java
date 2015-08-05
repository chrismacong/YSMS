package com.cwkj.ysms.test.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cwkj.ysms.model.YsmsGames;
import com.cwkj.ysms.model.YsmsLeague;
import com.cwkj.ysms.service.LeagueManagementService;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations="file:WebContent/WEB-INF/springMVC-servlet.xml") 
public class LeagueServiceTest {

	@Autowired
	private LeagueManagementService leagueManagementService;
	
	@Test
	public void testAddLeague(){
		try {
			String beginTimeStr = "2015-3-6 22:00:00";
			String endTimeStr = "2015-3-9 00:00:00";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date registerBeginTime = sdf.parse(beginTimeStr);
			Date registerEndTime = sdf.parse(endTimeStr);
			leagueManagementService.addLeague(2012, "飞机杯高中足球联赛", 8, registerBeginTime, registerEndTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDeleteLeague(){
		int leagueId = 202;
		Boolean result = leagueManagementService.deleteLeague(leagueId);
		System.out.println("delete league result :"+result.toString());
	}
	@Test
	public void testisModifyPermitted(){
		System.out.println(leagueManagementService.isModifyPermitted(100));
	}
	
	@Test
	public void testIsRegisterEnd(){
		System.out.println(leagueManagementService.isRegisterEnd(3));
	}
	@Test
	public void testgetAllLeague(){
		List<YsmsLeague> testList = leagueManagementService.getAllLeagues();
		System.out.println(testList.get(0).getLeagueName());
	}
	@Test
	public void testgetYearlyLeague(){
		List<YsmsLeague> testList = leagueManagementService.getYearlyLeagues(2015);
		System.out.println(testList.get(0));
	}
	
	@Test
	public void testModifyLeague(){
		int leagueId = 1;
		int leagueYear = 2015;
		int leagueLevel = 2;
		String leagueName = "飞机杯小学足球联赛";
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2015);
		cal.set(Calendar.MONTH,3);
		cal.set(Calendar.DAY_OF_MONTH,20);
		Date registerBeginTime = cal.getTime();
		cal.set(Calendar.MONTH,4);
		Date registerEndTime = cal.getTime();
		Boolean result = leagueManagementService.modifyLeague(leagueId, leagueYear, leagueName, registerBeginTime, registerEndTime,null,null,null);
		System.out.println("ModifyLeague Result:"+result.toString());
	}
	
	@Test
	public void testgGroupTeamsForLeague(){
		Map map = new HashMap();
		map.put("A", "1,2,3,4");
		map.put("B", "5,6,7,8");
		map.put("C", "9,10,11,12");
		map.put("D", "13,14,15,16");
		map.put("E", "17,18,19,20");
		map.put("F", "21,22,23,24");
		map.put("G", "25,26,27,28");
		map.put("H", "29,30,31,32");
		List<YsmsGames> matchList = leagueManagementService.groupTeamsForZone(1, map, 2, false);
		System.out.println(matchList.size());
		for(int i=0;i<matchList.size();i++){
			System.out.println(matchList.get(i).getYsmsTeamByHostTeamid().getTeamName()+" VS "+matchList.get(i).getYsmsTeamByGuestTeamid().getTeamName());
		}
	}
	
	@Test
	public void testGetDistinctZoneGroup(){
		List<String> results = leagueManagementService.getDistinctGroupsOfZone(19);
		for(int i=0;i<results.size();i++){
			System.out.println(results.get(i));
		}
	}
}
