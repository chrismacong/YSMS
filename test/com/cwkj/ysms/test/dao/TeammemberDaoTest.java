package com.cwkj.ysms.test.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cwkj.ysms.dao.AthleteDao;
import com.cwkj.ysms.dao.TeamDao;
import com.cwkj.ysms.dao.TeammemberDao;
import com.cwkj.ysms.model.YsmsTeammember;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations="file:WebContent/WEB-INF/springMVC-servlet.xml") 
public class TeammemberDaoTest {
	@Autowired
	private TeammemberDao teammemberDao;
	
	@Autowired
	private AthleteDao athleteDao;
	
	@Autowired
	private TeamDao teamDao;
	
	@Test
	public void testSave(){
		YsmsTeammember ysmsTeammember = new YsmsTeammember();
		ysmsTeammember.setYsmsAthlete(athleteDao.findById(16));
		ysmsTeammember.setYsmsTeam(teamDao.findById(1));
		teammemberDao.save(ysmsTeammember);
	}
	
	@Test
	public void testDelete(){
		List<YsmsTeammember> memberList = teammemberDao.findAthletesByTeamId(1);
		System.out.println(memberList.size());
		teammemberDao.delete(memberList.get(0));
	}
	
	@Test
	public void testFindAthletesByTeamId(){
		List<YsmsTeammember> memberList = teammemberDao.findAthletesByTeamId(1);
		for(int i=0;i<memberList.size();i++){
			System.out.println(memberList.get(i).getYsmsAthlete().getIdentifiedName());
		}
	}
	
	@Test
	public void testFindCoachesByTeamId(){
		List<YsmsTeammember> memberList = teammemberDao.findCoachesByTeamId(1);
		for(int i=0;i<memberList.size();i++){
			if(memberList.get(i).getYsmsAthlete()!=null)
			System.out.println(memberList.get(i).getYsmsAthlete().getIdentifiedName());
			else {
				System.out.println(memberList.get(i).getYsmsCoach().getIdentifiedName());
			}
			
		}
	}
	
	@Test
	public void testFindTeamsByAthleteId(){
		List<YsmsTeammember> memberList = teammemberDao.findTeamsByAthleteId(16);
		for(int i=0;i<memberList.size();i++){
			System.out.println(memberList.get(i).getYsmsTeam().getTeamName());
		}
	}
	@Test
	public void testFindTeamsByCoachId(){
		List<YsmsTeammember> memberList = teammemberDao.findTeamsByCoachesId(2);
		for(int i=0;i<memberList.size();i++){
			System.out.println(memberList.get(i).getYsmsTeam().getTeamName());
		}
	}
}
