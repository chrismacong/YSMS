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

import com.cwkj.ysms.model.YsmsCoach;
import com.cwkj.ysms.model.YsmsSchool;
import com.cwkj.ysms.service.CoachManagementService;
import com.cwkj.ysms.util.Page;


@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations="file:WebContent/WEB-INF/springMVC-servlet.xml") 
public class CoachServiceTest {

	@Autowired
	private CoachManagementService coachManagementService;
	
	@Test
	public void testAddCoach() {
		try {
			Integer schoolId = 1;
			String identifiedId = "20112325012";
			String coachContact = "777888";
			String identifiedName = "证件名称";
			String identifiedAddress = "南京信息工程大学滨江学院";
			String identifiedNationality = "汉";
			Integer identifiedGender = 1;
			String BirthdayStr = "2015-3-6";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date identifiedBirthday = sdf.parse(BirthdayStr);
			coachManagementService.addCoach(identifiedId, schoolId, coachContact, identifiedName, 
					identifiedGender, identifiedBirthday, identifiedAddress, identifiedNationality, 
					null, BirthdayStr, 2, identifiedGender, "1121381273872", false, "123178363");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdateCoach() {
		try {
			Integer schoolId = 1;
			Integer coachId = 4;
			String identifiedId = "xxx";
			String coachContact = "11";
			String identifiedName = "证件名称";
			String identifiedAddress = "南京信息工程大学";
			String identifiedNationality = "汉";
			Integer identifiedGender = 1;
			String BirthdayStr = "2015-3-10";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date identifiedBirthday = sdf.parse(BirthdayStr);
			System.out.println(coachManagementService.updateCoach(coachId, identifiedId, schoolId,
					coachContact, identifiedName, identifiedGender, identifiedBirthday,
					identifiedAddress, identifiedNationality, 2, false));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDeleteCoach() {
		Integer coachId = 3;
		System.out.println(coachManagementService.deleteCoach(coachId));
	}

	@Test
	public void testGetCoachByID() {
		Integer coachId = 1;
		YsmsCoach YsmsCoach = coachManagementService.getCoachByID(coachId);
		System.out.println(YsmsCoach.getIdentifiedGender());
	}

	@Test
	public void testGetCoachesByPage() {
		Integer schoolId = 1;
		Page page = new Page();
		page.setEveryPage(10);
		page.setBeginIndex(0);
		String identifiedId = null;
		String identifiedName = null;
		Integer identifiedGender = 0;
		String coachContact = null;
		List<YsmsCoach> athleteList = coachManagementService.getCoachesByPage(identifiedId, 
				schoolId, coachContact, identifiedName, identifiedGender, page);
		if(athleteList.size()>0){
			for(int i = 0; i<athleteList.size();i ++){
				System.out.println(athleteList.get(i).getCoachMobile());
			}
		}else{
			System.out.println("无数据");
		}
	}

	@Test
	public void testGetCoaches() {
		Integer schoolId = 162;
		String identifiedId = null;
		String identifiedName = null;
		Integer identifiedGender = 0;
		String coachContact = null;
		List<YsmsCoach> athleteList = coachManagementService.getCoaches(identifiedId, 
				schoolId, coachContact, identifiedName, identifiedGender);
		if(athleteList.size()>0){ 
			for(int i = 0; i<athleteList.size();i ++){
				System.out.println(athleteList.get(i).getCoachId());
			}
		}else{
			System.out.println("无数据");
		}
	}
}
