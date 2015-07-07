package com.cwkj.ysms.test.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cwkj.ysms.dao.CoachDao;
import com.cwkj.ysms.dao.SchoolDao;
import com.cwkj.ysms.model.YsmsAthlete;
import com.cwkj.ysms.model.YsmsCoach;
import com.cwkj.ysms.model.YsmsSchool;
import com.cwkj.ysms.util.Page;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations="file:WebContent/WEB-INF/springMVC-servlet.xml") 
public class CoachDaoTest {
	
	@Autowired
	private CoachDao coachDao;

	@Autowired
	private SchoolDao schoolDao;
	
	@Test
	public void testSave(){

		YsmsCoach ysmsCoach = new YsmsCoach();
		YsmsSchool s = schoolDao.findById(1);
		ysmsCoach.setYsmsSchool(s);
		ysmsCoach.setIdentifiedId("220104199213412254");
		ysmsCoach.setIdentifiedName("夏夏");
		ysmsCoach.setCoachMobile("555444");
		ysmsCoach.setIdentifiedGender(0);
		ysmsCoach.setIdentifiedNationality("高山");
		ysmsCoach.setIdentifiedAddress("XX小学");
		ysmsCoach.setCoachLevel(1);
		ysmsCoach.setSchoolcoachFlag(true);
		String dateStr = "2015-01-01 00:00:00";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		try {
			date = sdf.parse(dateStr);
			ysmsCoach.setIdentifiedBirthday(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		ysmsCoach.setDeleteflag(0);
		coachDao.save(ysmsCoach);
	}
	
	@Test
	public void testDelete(){
		YsmsCoach a = coachDao.findById(3);
		coachDao.delete(a);
	}
	
	@Test
	public void testUpdata(){

		YsmsCoach a = coachDao.findById(3);
		a.setDeleteflag(1);
		coachDao.updata(a);
		System.out.println(a.getDeleteflag());
	}
	
	@Test
	public void testFindById(){
		
		YsmsCoach a = coachDao.findById(208);
		System.out.println(a.getDeleteflag());
	}
	
	@Test
	public void testFindAll(){
		List<YsmsCoach> y = new ArrayList<YsmsCoach>();
		y = coachDao.findAll();
		System.out.println(y.size());
	}
	
	@Test
	public void findAllByPage() {
		Page page = new Page();
		page.setBeginIndex(1);
		page.setCurrentPage(1);
		page.setEveryPage(2);
		List<YsmsCoach> coachList = coachDao.findAllByPage(page);
		System.out.println(coachList.size());
	}
	
	@Test
	public void findByFuzzyQuery() {
		String identifiedId = null;
		Integer schoolId = 1; 
		String coachContact = null; 
		String identifiedName = "王尼玛";
		Integer identifiedGender = 1;	
		List<YsmsCoach>  y = coachDao.findByFuzzyQuery(identifiedId, schoolId, coachContact, 
				identifiedName, identifiedGender);
		if(y.size() > 0){
			for(int i = 0;i<y.size();i++){
				System.out.println(y.get(i).getIdentifiedName());
			}
		}else{
			System.out.println("无数据");
		}
	}

	@Test
	public void findByFuzzyQueryAndPage() {
		String identifiedId = "220104199213412351";
		Integer schoolId = 1; 
		String coachContact = null; 
		String identifiedName = "小头爸爸";
		Integer identifiedGender = 1;
		Page page = new Page();
		page.setBeginIndex(0);
		page.setCurrentPage(1);
		page.setEveryPage(20);
		List<YsmsCoach> y = coachDao.findByFuzzyQueryAndPage(identifiedId, schoolId, coachContact, 
				identifiedName, identifiedGender, page);
		if(y.size() > 0){
			for(int i = 0;i<y.size();i++){
				System.out.println(y.get(i).getIdentifiedName());
			}
		}else{
			System.out.println("无数据");
		}
	}
}
