package com.cwkj.ysms.test.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cwkj.ysms.dao.SchoolDao;
import com.cwkj.ysms.dao.TeamDao;
import com.cwkj.ysms.model.YsmsTeam;
import com.cwkj.ysms.model.YsmsZoneTeam;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations="file:WebContent/WEB-INF/springMVC-servlet.xml") 
public class TeamDaoTest {
	
	@Autowired
	private TeamDao teamDao;
	
	@Autowired
	private SchoolDao schoolDao;
	
	@Test
	public void testSave(){
		YsmsTeam ysmsTeam1 = new YsmsTeam();
		ysmsTeam1.setDeleteflag(0);
		ysmsTeam1.setTeamName("中华老字号足球联队专治各种不服");
		ysmsTeam1.setYsmsSchool(schoolDao.findById(1));
		teamDao.save(ysmsTeam1);
		YsmsTeam ysmsTeam2 = new YsmsTeam();
		ysmsTeam2.setDeleteflag(0);
		ysmsTeam2.setTeamName("小日本足球队罹患恐中症三十年");
		ysmsTeam2.setYsmsSchool(schoolDao.findById(2));
		teamDao.save(ysmsTeam2);
		YsmsTeam ysmsTeam3 = new YsmsTeam();
		ysmsTeam3.setDeleteflag(0);
		ysmsTeam3.setTeamName("国安泰达本一家吵吵啥");
		ysmsTeam3.setYsmsSchool(schoolDao.findById(3));
		teamDao.save(ysmsTeam3);
		YsmsTeam ysmsTeam4 = new YsmsTeam();
		ysmsTeam4.setDeleteflag(0);
		ysmsTeam4.setTeamName("少林功夫足球队断子绝孙脚天下无敌");
		ysmsTeam4.setYsmsSchool(schoolDao.findById(4));
		teamDao.save(ysmsTeam4);
	}
	
/*	@Test
	public void testDelete(){
		YsmsTeam ysmsTeam = teamDao.findById(2);
		teamDao.delete(ysmsTeam);
	}*/
	
	@Test
	public void testFindById(){
		YsmsTeam ysmsTeam = teamDao.findById(3);
		System.out.println(ysmsTeam.getTeamName());
	}
	
	@Test
	public void testFindAll(){
		List<YsmsTeam> list = teamDao.findAll();
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getTeamName());
		}
	}
	
	@Test
	public void testFindBySchoolId(){
		List<YsmsTeam> list = teamDao.findBySchoolId(1);
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getTeamName());
		}
	}
	@Test
	public void findBySchoolIdAndZoneId(){
		YsmsZoneTeam lt = teamDao.findBySchoolIdAndZoneId(1, 1);
		System.out.println(lt.getYsmsTeam().getYsmsSchool().getSchoolName());
	}
}
