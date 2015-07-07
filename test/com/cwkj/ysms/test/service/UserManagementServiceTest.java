package com.cwkj.ysms.test.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cwkj.ysms.dao.WechatnewsDao;
import com.cwkj.ysms.model.YsmsLeague;
import com.cwkj.ysms.model.YsmsWechatnews;
import com.cwkj.ysms.service.LeagueManagementService;
import com.cwkj.ysms.service.UserManagementService;
import com.cwkj.ysms.service.impl.UserManagementServiceImpl;
import com.cwkj.ysms.util.ThtApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:WebContent/WEB-INF/springMVC-servlet.xml")
public class UserManagementServiceTest {

	@Autowired
	private UserManagementService userManagementService;

	@Test
	public void testAddUser() {
		String groupId = "1";
		String userEmail = "zhangsan@cwkj.com";
		String userPassword = "123456";
		String userName = "zhangsan";
		System.out.println(userManagementService.addUser(groupId, userEmail,
				userPassword, userName));
	}

	@Test
	public void testDeleteUser() {
		System.out.println(userManagementService.deleteUser("1"));
	}

	@Test
	public void testUpdateUser() {
		String userId="2";
		String groupId = "1";
		String userEmail = "zhangsan@cwkj.com";
		String userPassword = "123456";
		String userName = "zhangsan";
		String deleteFlag="0";
		System.out.println(userManagementService.updateUser(userId, groupId,
				userEmail, userPassword, userName, deleteFlag));
	}
	@Test
	public void testGetUser(){
		userManagementService.getUserbyID("1");
		 
		 
	}
	
	 @Test
	public void testGetUsers(){
		String groupId = "";
		String userEmail = "";
		String userPassword = "";
		String userName = "";
		String deleteFlag="";
		System.out.println(userManagementService.getUserList(groupId, userEmail, userName, userPassword, deleteFlag,"0"));
	}
	 @Test
	 public void testLogin(){
		 userManagementService.login("test", "ssss");
	 }
}
