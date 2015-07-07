package com.cwkj.ysms.test.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cwkj.ysms.dao.SchoolUserDao;
import com.cwkj.ysms.model.YsmsSchool;
import com.cwkj.ysms.model.YsmsSchooluser;
import com.cwkj.ysms.model.YsmsUser;
import com.cwkj.ysms.service.SchoolManagementService;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations="file:WebContent/WEB-INF/springMVC-servlet.xml") 
public class SchoolServiceTest {

	@Autowired
	private SchoolManagementService schoolManagementService;
	@Autowired
	private SchoolUserDao schooluserDao;
	
	@Test
	public void testAddSchool(){
		String schoolName = "测试一号小学";
		String schoolCategory = "0";
		String user_email = "ceshi@163.com";
		String userName = "ceshizhanghao";
		String userPassword = "123456";
		Boolean bol = schoolManagementService.addSchool("1", schoolName, schoolCategory, user_email, userName, userPassword, "1", "beijing", "zhangsan", "025-82745723",  "025-82745724");
		System.out.println(bol);
	}
	
	@Test
	public void testDeleteSchool(){
		Boolean bol = schoolManagementService.deleteSchool(9);
		System.out.println(bol);
	}
	
	@Test
	public void testGetSchoolByID(){
		YsmsSchool ysmsSchool = schoolManagementService.getSchoolByID(9);
		List<YsmsSchooluser> list = schooluserDao.findBySchoolId(ysmsSchool.getSchoolId());
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getYsmsUser().getUserPassword());
		}
	}
	
	@Test
	public void testUpdateSchool(){
		String schoolId = "9";
		String schoolName = "我是一个小学";
		String schoolCategory = null;
		Boolean bol = schoolManagementService.updateSchool(schoolId, schoolName);
		System.out.println(bol);
	}
	
	@Test
	public void testGetSchools(){
		String schoolName = "我是";
		String schoolCategory = "";
		List<YsmsSchool> ysmsShoools = schoolManagementService.getSchools(schoolName, schoolCategory);
		for(int i=0;i<ysmsShoools.size();i++){
			System.out.println(ysmsShoools.get(i).getSchoolName());
		}
	}
}
