package com.cwkj.ysms.test.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cwkj.ysms.dao.GamesDao;
import com.cwkj.ysms.dao.GamesJudgeDao;
import com.cwkj.ysms.dao.JudgeDao;
import com.cwkj.ysms.model.YsmsGamesJudge;
import com.cwkj.ysms.model.YsmsJudge;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations="file:WebContent/WEB-INF/springMVC-servlet.xml") 
public class GamesJudgeDaoTest {
	@Autowired
	private GamesJudgeDao gamesJudgeDao;
	
	@Autowired
	private GamesDao gamesDao;
	
	@Autowired
	private JudgeDao judgeDao;
	
	@Test
	public void testSave(){
		YsmsGamesJudge ysmsGamesJudge = new YsmsGamesJudge();
		ysmsGamesJudge.setYsmsGames(gamesDao.findById(5));
		ysmsGamesJudge.setYsmsJudge(judgeDao.findById(4));
		ysmsGamesJudge.setJudgePosition(1);
		gamesJudgeDao.save(ysmsGamesJudge);
	}
	
	@Test
	public void testGetJudgeRelationByIdAndGameId(){
		YsmsGamesJudge ysmsGamesJudge = gamesJudgeDao.getJudgeRelationByIdAndGameId(5, 4);
		System.out.println(ysmsGamesJudge.getYsmsGames().getGameLocation());
	}
	
	@Test
	public void testDelete(){
		YsmsGamesJudge ysmsGamesJudge = gamesJudgeDao.getJudgeRelationByIdAndGameId(5, 4);
		gamesJudgeDao.delete(ysmsGamesJudge);
	}
	
	@Test
	public void testGetJudgesByGameId(){
		List<YsmsJudge> judgeList = gamesJudgeDao.getJudgesByGameId(5);
		System.out.println(judgeList.get(0).getIdentifiedAddress());
	}
	
	@Test
	public void testGetJudgeRelationsByJudgeId(){
		List<YsmsGamesJudge> ysmsGamesJudge_list = gamesJudgeDao.getJudgeRelationsByJudgeId(4);
		System.out.println(ysmsGamesJudge_list.size());
	}
	
}
