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
import com.cwkj.ysms.dao.JudgeAndLevelDao;
import com.cwkj.ysms.dao.SchoolDao;
import com.cwkj.ysms.dao.UserDao;
import com.cwkj.ysms.model.YsmsAthlete;
import com.cwkj.ysms.model.YsmsGroup;
import com.cwkj.ysms.model.YsmsSchool;
import com.cwkj.ysms.model.YsmsUser;
import com.cwkj.ysms.util.Page;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:WebContent/WEB-INF/springMVC-servlet.xml")
public class JudgeAndLevelDaoTest {

	@Autowired
	private JudgeAndLevelDao judgeAndLevelDao;
	@Test
	 public void testQuery(){
		judgeAndLevelDao.query(null, "1");
	 }
}
