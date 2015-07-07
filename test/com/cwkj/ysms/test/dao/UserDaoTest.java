package com.cwkj.ysms.test.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.jpush.api.report.UsersResult.User;

import com.cwkj.ysms.dao.AthleteDao;
import com.cwkj.ysms.dao.SchoolDao;
import com.cwkj.ysms.dao.UserDao;
import com.cwkj.ysms.model.YsmsAthlete;
import com.cwkj.ysms.model.YsmsGroup;
import com.cwkj.ysms.model.YsmsSchool;
import com.cwkj.ysms.model.YsmsUser;
import com.cwkj.ysms.util.Page;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:WebContent/WEB-INF/springMVC-servlet.xml")
public class UserDaoTest {

	@Autowired
	private UserDao userDao;

	@Test
	public void testSave() {
		YsmsUser ysmsUser = new YsmsUser();
		YsmsGroup ysmsGroup = new YsmsGroup();
		ysmsGroup.setGroupId(1);
		ysmsUser.setYsmsGroup(ysmsGroup);
		ysmsUser.setUserName("test");
		ysmsUser.setDeleteflag(0);
		ysmsUser.setYsmsGroup(ysmsGroup);
		ysmsUser.setUserEmail("sss@ss.com");
		ysmsUser.setUserPassword("ssss");
		userDao.save(ysmsUser);
	}

	@Test
	public void testFindUser() {
		String groupId = "";
		String userEmail = "";
		String userName = "";
		String deleteFlag = "";
		String userPassword = "1";
		System.out.println(userDao.findUser(groupId, userEmail, userName,
				userPassword, deleteFlag,0));
	}

	@Test
	public void testUpdate() {
		YsmsUser ysmsUser = new YsmsUser();
		YsmsGroup ysmsGroup = new YsmsGroup();
		ysmsGroup.setGroupId(1);
		ysmsUser.setUserId(1);
		ysmsUser.setYsmsGroup(ysmsGroup);
		ysmsUser.setUserName("test");
		ysmsUser.setDeleteflag(0);
		ysmsUser.setYsmsGroup(ysmsGroup);
		ysmsUser.setUserEmail("sss@ss.com");
		ysmsUser.setUserPassword("ssss");
		userDao.update(ysmsUser);
	}
	
	@Test
	public void testFindUserById() {
	 
		userDao.findUserByID(1);
	}
	
	@Test
	public void testDelete() {
	 
		userDao.delete(2);
	}
	
	@Test
	public void testFindUserByNameAndPwd(){
		userDao.findUserByNameAndPwd("test", "ssss");
	}
}
