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

import com.cwkj.ysms.dao.AthleteDao;
import com.cwkj.ysms.dao.DiplomaDao;
import com.cwkj.ysms.dao.JobsDao;
import com.cwkj.ysms.dao.SchoolDao;
import com.cwkj.ysms.model.YsmsAthlete;
import com.cwkj.ysms.model.YsmsDiploma;
import com.cwkj.ysms.model.YsmsJobs;
import com.cwkj.ysms.model.YsmsSchool;
import com.cwkj.ysms.util.Page;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations="file:WebContent/WEB-INF/springMVC-servlet.xml") 
public class AthleteDaoTest {
	
	@Autowired
	private AthleteDao athleteDao;

	@Autowired
	private SchoolDao schoolDao;
	
	@Autowired
	private DiplomaDao diplomaDao;
	
	@Autowired
	private JobsDao jobsDao;
	
	@Test
	public void testSave(){

		YsmsAthlete ysmsAthlete = new YsmsAthlete();
		YsmsSchool ysmsSchool = schoolDao.findById(1);
		YsmsJobs ysmsJobsByAthleteMatherjob = jobsDao.findById(1);
		YsmsJobs ysmsJobsByAthleteFatherjob = jobsDao.findById(2);
		YsmsDiploma ysmsDiplomaByAthleteMotherdiploma = diplomaDao.findById(1);
		YsmsDiploma ysmsDiplomaByAthleteFatherdiploma = diplomaDao.findById(2);
		ysmsAthlete.setDeleteflag(0);
		ysmsAthlete.setAthleteGuardian1("赵某");
		ysmsAthlete.setAthleteGuardian2("孙某");
		ysmsAthlete.setGuardian1Mobile("15212398123");
		ysmsAthlete.setAthleteFootsize(42);
		ysmsAthlete.setGuardian2Mobile("15195906030");
		ysmsAthlete.setYsmsJobsByGuardian1Job(ysmsJobsByAthleteFatherjob);
		ysmsAthlete.setYsmsJobsByGuardian2Job(ysmsJobsByAthleteMatherjob);
		ysmsAthlete.setYsmsDiplomaByGuardian1Diploma(ysmsDiplomaByAthleteFatherdiploma);
		ysmsAthlete.setYsmsDiplomaByGuardian2Diploma(ysmsDiplomaByAthleteMotherdiploma);
		ysmsAthlete.setYsmsSchool(ysmsSchool);
		ysmsAthlete.setIdentifiedId("身份证");
		ysmsAthlete.setAthleteHeight(180);
		ysmsAthlete.setAthleteWeight(80);
		ysmsAthlete.setAthletePosition(1);
		ysmsAthlete.setIdentifiedName("钱某");
		ysmsAthlete.setIdentifiedGender(1);
		ysmsAthlete.setIdentifiedAddress("XX地址");
		ysmsAthlete.setIdentifiedNationality("汉");
		ysmsAthlete.setAthleteCoach("王叔叔");
		ysmsAthlete.setAthleteMobile("15298386781");
		ysmsAthlete.setAthleteSchoolyear("2009");
		ysmsAthlete.setStudentId("123456");
		String dateStr = "2015-01-01 00:00:00";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		try {
			date = sdf.parse(dateStr);
			ysmsAthlete.setIdentifiedBirthday(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		athleteDao.save(ysmsAthlete);
	}
	
	@Test
	public void testDelete(){
		YsmsAthlete a = athleteDao.findById(3);
		athleteDao.delete(a);
	}
	
	@Test
	public void testUpdata(){
		YsmsAthlete a = athleteDao.findById(1);
		a.setDeleteflag(1);
		athleteDao.updata(a);
		System.out.println(a.getDeleteflag());
	}
	
	@Test
	public void testFindById(){
		YsmsAthlete a = athleteDao.findById(199);
		System.out.println(a.getDeleteflag());
	}
	
	@Test
	public void testFindAll(){
		List<YsmsAthlete> y = new ArrayList<YsmsAthlete>();
		y = athleteDao.findAll();
		System.out.println(y.size());
	}
	
	@Test
	public void findAllByPage() {
		Page page = new Page();
		page.setBeginIndex(1);
		page.setCurrentPage(1);
		page.setEveryPage(20);
		List<YsmsAthlete> athleteList = athleteDao.findAllByPage(page);
		System.out.println(athleteList.size());
	}
	
	@Test
	public void findByIdentifiedId(){
		String identifiedId = "测试IdentifiedId";
		List<YsmsAthlete> ysmsAthleteList = new ArrayList<YsmsAthlete>();
		ysmsAthleteList = athleteDao.findByIdentifiedId(identifiedId);
		System.out.println(ysmsAthleteList.size());
	}
	@Test
	public void findByFuzzyQuery() {
		Integer schoolId =null;
		String identifiedId = "";
		String identifiedName = "";
		Integer identifiedGender= null;
		Integer athletePosition = null;
		Integer studentId = null;
		String athleteSchoolyear = "";
		List<YsmsAthlete> y = athleteDao.findByFuzzyQuery(schoolId, identifiedId, identifiedName, 
				identifiedGender, athletePosition, studentId, athleteSchoolyear);
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
		Integer schoolId = 1;
		String identifiedId = "";
		String identifiedName = "";
		Integer identifiedGender= 1;
		Integer athletePosition = 1;
		Integer studentId = null;
		String athleteSchoolyear = "2011";
		Page page = new Page();
		page.setBeginIndex(0);
		page.setEveryPage(10);
		List<YsmsAthlete> y = athleteDao.findByFuzzyQueryAndPage(schoolId, identifiedId, 
				identifiedName, identifiedGender, athletePosition, 
				studentId, athleteSchoolyear, page);
		if(y.size() > 0){
			for(int i = 0;i<y.size();i++){
				System.out.println(y.get(i).getIdentifiedName());
			}
		}else{
			System.out.println("无数据");
		}
	}
	
	@Test
	public void testCreateRegisterID()
	{
		System.out.println(athleteDao.createRegisterID(1, 2014, 135));
	}
}
