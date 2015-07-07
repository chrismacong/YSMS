package com.cwkj.ysms.test.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cwkj.ysms.dao.GamesDao;
import com.cwkj.ysms.dao.GoalDao;
import com.cwkj.ysms.model.YsmsGoal;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations="file:WebContent/WEB-INF/springMVC-servlet.xml") 
public class GoalDaoTest {
	@Autowired
	private GoalDao goalDao;
	
	@Autowired
	private GamesDao gamesDao;
	
	@Test
	public void testSave(){
		YsmsGoal ysmsGoal = new YsmsGoal();
		ysmsGoal.setShooter(1);
		ysmsGoal.setAssistant(3);
		ysmsGoal.setStyle(0);
		ysmsGoal.setTime("42′30″");
		ysmsGoal.setYsmsGames(gamesDao.findById(3));
	
		goalDao.save(ysmsGoal);
	}
	
	@Test
	public void testDelete(){
		YsmsGoal ysmsGoal = goalDao.findById(1);
		goalDao.delete(ysmsGoal);
	}
	
	@Test
	public void testFindById(){
		YsmsGoal ysmsGoal = goalDao.findById(2);
		System.out.println(ysmsGoal.getTime());
	}
	
	@Test
	public void testFindByShooter(){
		List<YsmsGoal> goalList = goalDao.findByShooter(1);
		System.out.println(goalList.size());
	}
	
	@Test
	public void testFindByAssistant(){
		List<YsmsGoal> goalList = goalDao.findByAssistant(2);
		System.out.println(goalList.size());
	}
	
	@Test
	public void testFindByGames(){
		List<YsmsGoal> goalList = goalDao.findByGame(3);
		System.out.println(goalList.size());
	}
}
