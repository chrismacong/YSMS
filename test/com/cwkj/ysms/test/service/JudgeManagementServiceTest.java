package com.cwkj.ysms.test.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cwkj.ysms.model.YsmsJudge;
import com.cwkj.ysms.model.YsmsJudgeandlevel;
import com.cwkj.ysms.model.YsmsLeague;
import com.cwkj.ysms.service.JudgeManagementService;
import com.cwkj.ysms.service.LeagueManagementService;
import com.cwkj.ysms.service.UserManagementService;
import com.cwkj.ysms.service.impl.UserManagementServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:WebContent/WEB-INF/springMVC-servlet.xml")
public class JudgeManagementServiceTest {

	@Autowired
	private JudgeManagementService judgeManagementService;

	@Test
	public void testaddJudge() {
 
		judgeManagementService.applyJudge("3201211989111031X", "潘海林", 1, "汉族", new Date(), "中国南京", 1, 1, "软件谷",1, 1, "13800000000", "333",null,null,"testjudge","123456");
	}

	@Test
	public void testModifyLevel() {

	}

	@Test
	public void getAllJudge() {
		System.out.println(judgeManagementService.getAllJudges(null, null,
				"2014-04-01", "2014-04-01", null, "1"));
	}
}
