package com.cwkj.ysms.test.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cwkj.ysms.dao.LeagueDao;
import com.cwkj.ysms.model.YsmsLeague;
import com.cwkj.ysms.util.Page;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations="file:WebContent/WEB-INF/springMVC-servlet.xml") 
public class LeagueDaoTest {
	
	@Autowired
	private LeagueDao leagueDao;

	@Test
	public void testSave(){

		YsmsLeague ysmsLeague = new YsmsLeague();
		ysmsLeague.setLeagueTotal(6);
		String dateStr = "2015-01-01 00:00:00";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		try {
			date = sdf.parse(dateStr);
			ysmsLeague.setLeagueYear(date);
			ysmsLeague.setLeagueName("***联赛");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ysmsLeague.setRegisterBegintime(date);
		ysmsLeague.setRegisterEndtime(date);
		ysmsLeague.setDeleteflag(0);
		leagueDao.save(ysmsLeague);
	}
	
	@Test
	public void testFindById(){
		YsmsLeague ysmsLeague = leagueDao.findById(55);
		System.out.println(ysmsLeague.getRegisterBegintime());
	}
	
	@Test
	public void testDelete(){
		YsmsLeague ysmsLeague = new YsmsLeague();
		ysmsLeague.setLeagueTotal(6);
		String dateStr = "2015-01-01 00:00:00";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		try {
			date = sdf.parse(dateStr);
			ysmsLeague.setLeagueYear(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ysmsLeague.setRegisterBegintime(date);
		ysmsLeague.setRegisterEndtime(date);
		ysmsLeague.setDeleteflag(0);
		leagueDao.save(ysmsLeague);
		leagueDao.delete(ysmsLeague);
	}
	
	@Test
	public void testFindAll(){
		List<YsmsLeague> leagueList = leagueDao.findAll();
		System.out.println(leagueList.size());
	}
	
	@Test
	public void testFindByLeagueYear(){
		List<YsmsLeague> leagueList = leagueDao.findByLeagueYear(2015);
		System.out.println(leagueList.size());
		for(int i=0;i<leagueList.size();i++){
			System.out.println(leagueList.get(i).getLeagueYear());
		}
	}
	
	@Test
	public void testFindByLeagueLevel(){
		List<YsmsLeague> leagueList = leagueDao.findByLeagueLevel(7);
		System.out.println(leagueList.size());
		for(int i=0;i<leagueList.size();i++){
			System.out.println(leagueList.get(i).getLeagueYear());
		}
	}
	
	@Test
	public void testFindAllByPage(){
		Page page = new Page();
		page.setBeginIndex(1);
		page.setCurrentPage(1);
		page.setEveryPage(10);
		List<YsmsLeague> leagueList = leagueDao.findAllByPage(page);
		System.out.println(leagueList.size());
	}
	
	@Test
	public void testFindByLeagueYearAndPage(){
		Page page = new Page();
		page.setBeginIndex(1);
		page.setCurrentPage(1);
		List<YsmsLeague> leagueList = leagueDao.findByLeagueYearAndPage(2015, page);
		System.out.println(leagueList.size());
		for(int i=0;i<leagueList.size();i++){
			System.out.println(leagueList.get(i).getLeagueYear());
		}
	}
	
}
