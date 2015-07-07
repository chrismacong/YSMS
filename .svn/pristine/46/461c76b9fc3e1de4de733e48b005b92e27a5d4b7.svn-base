package com.cwkj.ysms.test.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cwkj.ysms.model.YsmsAthlete;
import com.cwkj.ysms.model.YsmsSchool;
import com.cwkj.ysms.service.AthleteManagementService;
import com.cwkj.ysms.util.Page;


@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations="file:WebContent/WEB-INF/springMVC-servlet.xml") 
public class AthleteServiceTest {

	@Autowired
	private AthleteManagementService athleteManagementService;
	
	@Test
	public void testAddAthlete() {
		try {
			Integer schoolId = 1;
			String identifiedId = "20112325012";
			String identifiedName = "证件名称";
			String identifiedAddress = "南京信息工程大学滨江学院";
			String identifiedNationality = "汉";
			Integer identifiedGender = 1;
			Integer athletePosition = 1;
			int athleteFootsize = 42;
			int athleteHeight = 180;
			int athleteWeight = 75;
			String studentId = "12341213";
			String BirthdayStr = "2015-3-6 22:00:00";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date identifiedBirthday = sdf.parse(BirthdayStr);
			athleteManagementService.addAthlete(schoolId, "王叔叔", "孟爷爷", "15298881322", "12398715921",
					1, 2, 1, 2, identifiedId, identifiedName, identifiedGender, identifiedBirthday, 
					identifiedAddress, identifiedNationality, athleteFootsize, athleteHeight, 
					athleteWeight, athletePosition, studentId, "2012", "15298386781", "13424", "马聪");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdateAthlete() {
		try {
			Integer schoolId = 1;
			String identifiedId = "xxx";
			String identifiedName = "证件名称";
			String identifiedAddress = "南京信息工程大学";
			String identifiedNationality = "汉";
			Integer identifiedGender = 1;
			Integer athletePosition = 1;
			int athleteHeight = 175;
			int athleteWeight = 65;
			int athleteFootsize = 39;
			String BirthdayStr = "2015-3-10";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date identifiedBirthday = sdf.parse(BirthdayStr);
			Integer fatherDiplomaId = 1;
//			System.out.println(athleteManagementService.updateAthlete(1, schoolId, "王叔叔", "苏苏", 
//					"15283749281", "15832981201", 1, 2, 1, 2, identifiedId, identifiedName, 
//					identifiedGender, identifiedBirthday, identifiedAddress, identifiedNationality,
//					athleteFootsize, athleteHeight, athleteWeight, athletePosition, "12312412", 
//					"2012", "1529371821", "马聪聪"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDeleteAthlete() {
		Integer athleteId = 1;
		System.out.println(athleteManagementService.deleteAthlete(athleteId));
	}

	@Test
	public void testGetAthleteByID() {
		Integer athleteId = 1;
		YsmsAthlete ysmsAthlete = athleteManagementService.getAthleteByID(athleteId);
		System.out.println(ysmsAthlete.getIdentifiedGender());
	}

	@Test
	public void testGetAtheletesByPage() {
		Integer schoolId = 1;
		Page page = new Page();
		page.setEveryPage(10);
		page.setBeginIndex(0);
		String identifiedId = null;
		String identifiedName = null;
		Integer identifiedGender = 1;
		Integer athletePosition = 1;
		List<YsmsAthlete> athleteList = athleteManagementService.getAtheletesByPage(schoolId, 
				identifiedId, identifiedName, identifiedGender, athletePosition, 3, 
				"", page);
		if(athleteList.size()>0){
			for(int i = 0; i<athleteList.size();i ++){
				System.out.println(athleteList.get(i).getIdentifiedName());
			}
		}else{
			System.out.println("无数据");
		}
	}

	@Test
	public void testGetAtheletes() {
		Integer schoolId = 1;
		String identifiedId = null;
		String identifiedName = null;
		Integer identifiedGender = 1;
		Integer athletePosition = 1;
		List<YsmsAthlete> athleteList = athleteManagementService.getAtheletes(schoolId, 
				identifiedId, identifiedName, identifiedGender, athletePosition, 1, 
				"");
		if(athleteList.size()>0){
			for(int i = 0; i<athleteList.size();i ++){
				System.out.println(athleteList.get(i).getAthleteId());
			}
		}else{
			System.out.println("无数据");
		}
	}
}
