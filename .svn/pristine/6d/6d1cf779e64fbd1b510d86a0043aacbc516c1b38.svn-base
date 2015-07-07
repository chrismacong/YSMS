package com.cwkj.ysms.test.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cwkj.ysms.dao.AthleteDao;
import com.cwkj.ysms.model.YsmsAthlete;
import com.cwkj.ysms.model.YsmsCoach;
import com.cwkj.ysms.model.YsmsTeam;
import com.cwkj.ysms.model.view.TeamView;
import com.cwkj.ysms.service.TeamManagementService;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations="file:WebContent/WEB-INF/springMVC-servlet.xml") 
public class TeamServiceTest {
	@Autowired
	private TeamManagementService teamManagementService;
	
	@Autowired
	private AthleteDao athleteDao;

	public TeamManagementService getTeamManagementService() {
		return teamManagementService;
	}

	public void setTeamManagementService(TeamManagementService teamManagementService) {
		this.teamManagementService = teamManagementService;
	}
	
	@Test
	public void testSave(){
		List<YsmsAthlete> list = new ArrayList<YsmsAthlete>();
		YsmsAthlete ysmsAthlete = athleteDao.findById(2);
		list.add(ysmsAthlete);
		teamManagementService.addTeam(1, 2, "测试球队威武霸气", null, list);
	}
	
	@Test
	public void testModify(){
		List<YsmsAthlete> list = new ArrayList<YsmsAthlete>();
		YsmsAthlete ysmsAthlete = athleteDao.findById(1);
		list.add(ysmsAthlete);
		teamManagementService.modifyTeam(11, "测试球队王叔叔下课", null, list);
	}
	
	@Test
	public void testDelete(){
		teamManagementService.deleteTeam(12);
	}
	
	@Test
	public void testGetTeamInfoBySchool(){
		 List<YsmsTeam> ysmsTeamList = teamManagementService.getTeamInfoBySchool(1);
		 System.out.println("get team info by school completed,team numbers:"+ysmsTeamList.size());
	}
	
	@Test
	public void testgetSignedTeamByLeague(){
		 List<TeamView> ysmsTeamList = teamManagementService.getSignedTeamByZone(1,0);
		 System.out.println("get team info by League completed,team numbers:"+ysmsTeamList.size());
	}
	
	
	@Test
	public void testSignToLeague(){
		teamManagementService.signToZone(12);
	}
	
	@Test
	public void testAddCoachToTeam(){
		teamManagementService.addCoachToTeam(4, 2);
	}
	
	@Test
	public void testAddAthleteToTeam(){
		teamManagementService.addAthleteToTeam(5, 3);
	}
	
	@Test
	public void testGetParticipatedTeamByLeague(){
		List<TeamView> list = teamManagementService.getParticipatedTeamByZone(1);
		System.out.println(list.size());
	}
	
	@Test
	public void testGetAthletesForTeam(){
		List<YsmsAthlete> list = teamManagementService.getAthletesForTeam("2,3");
		for(int i=0;i<list.size();i++)
			System.out.println(list.get(i).getIdentifiedName());
	}
	
	@Test
	public void testGetCoachesForTeam(){
		List<YsmsCoach> list = teamManagementService.getCoachesForTeam("1,2");
		for(int i=0;i<list.size();i++)
			System.out.println(list.get(i).getIdentifiedName());
	}
	
	@Test
	public void testGetTeamForSchoolAndLeague(){
		YsmsTeam ysmsTeam = teamManagementService.getTeamForSchoolAndZone(4, 3);
		if(ysmsTeam!=null)
			System.out.println(ysmsTeam.getTeamName());
		else
			System.out.println("No Team!");
	}
}
