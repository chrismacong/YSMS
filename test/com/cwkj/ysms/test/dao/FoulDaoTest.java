package com.cwkj.ysms.test.dao;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cwkj.ysms.dao.AthleteDao;
import com.cwkj.ysms.dao.FoulDao;
import com.cwkj.ysms.dao.GamesDao;
import com.cwkj.ysms.model.YsmsAthlete;
import com.cwkj.ysms.model.YsmsFoul;
import com.cwkj.ysms.model.YsmsGames;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations="file:WebContent/WEB-INF/springMVC-servlet.xml") 
public class FoulDaoTest {
	@Autowired
	private FoulDao foulDao;
	
	@Autowired
	private AthleteDao athleteDao;
	
	@Autowired
	private GamesDao gamesDao;
	
	@Test
	public void testSave(){
		try {
			YsmsFoul ysmsFoul = new YsmsFoul();
			ysmsFoul.setFoulLevel(2);
			Date date = new Date();
			ysmsFoul.setTime("40分45秒");
			YsmsAthlete ysmsAthlete  = athleteDao.findById(1);
			ysmsFoul.setYsmsAthlete(ysmsAthlete);
			YsmsGames ysmsGames = gamesDao.findById(4);
			ysmsFoul.setYsmsGames(ysmsGames);
			foulDao.save(ysmsFoul);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDelete(){
		try {
			YsmsFoul ysmsFoul = foulDao.findById(1);
			foulDao.delete(ysmsFoul);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFindById(){
		try {
			YsmsFoul ysmsFoul = foulDao.findById(1);
			System.out.println(ysmsFoul.getTime());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFindAll(){
		List<YsmsFoul> ysmsFoul_list = foulDao.findAll();
		System.out.println(ysmsFoul_list.size());
	}
	
	@Test
	public void testGetYsmsFoulsByAthleteId(){
		List<YsmsFoul> ysmsFoul_list = foulDao.getYsmsFoulsByAthleteId(3);
		System.out.println(ysmsFoul_list.size());
	}
	
	@Test
	public void testGetYsmsFoulsByGamesId(){
		List<YsmsFoul> ysmsFoul_list = foulDao.getYsmsFoulsByGamesId(4);
		System.out.println(ysmsFoul_list.size());
	}
}
