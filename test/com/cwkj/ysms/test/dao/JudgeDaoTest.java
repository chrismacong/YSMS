package com.cwkj.ysms.test.dao;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cwkj.ysms.dao.DistrictDao;
import com.cwkj.ysms.dao.JobsDao;
import com.cwkj.ysms.dao.JudgeDao;
import com.cwkj.ysms.model.YsmsDistrict;
import com.cwkj.ysms.model.YsmsJobs;
import com.cwkj.ysms.model.YsmsJudge;
import com.cwkj.ysms.util.Page;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:WebContent/WEB-INF/springMVC-servlet.xml")
public class JudgeDaoTest {

	@Autowired
	private JudgeDao judgeDao;

	@Autowired
	private DistrictDao districtDao;
	
	@Autowired
	private JobsDao jobsDao;
	
	@Test
	public void testUpdate() {
		String userId = "";
		String identifiedId = "";
		String judgeName = "";
		String judgeGender = "";
		String judgeBirthDate = "1989-11-12";
		String identifiedAddress = "";
		String nationality = "";
		String judegeReason = "";
		String contact = "";
		String deleteflag = "";
		String judge_level = "";
		String judge_id = "6";
		judgeDao.update(identifiedId, judgeName, judgeGender, judgeBirthDate,
				identifiedAddress, nationality, judegeReason, contact,
				deleteflag, judge_id);
	}

	@Test
	public void testGetListByPage() {
		Page page = new Page();
		page.setEveryPage(10);
		page.setBeginIndex(2);
		judgeDao.getJudgeListByPage(null, null, null, null, null, 0);
	}

	@Test
	public void save() {
		YsmsJudge ysmsJudge = new YsmsJudge();
		ysmsJudge.setIdentifiedId("2222");
		ysmsJudge.setDeleteflag(0);
		ysmsJudge.setIdentifiedBirthday(new Date());
		ysmsJudge.setIdentifiedGender(0);
		ysmsJudge.setIdentifiedName("张三");
		ysmsJudge.setIdentifiedNationality("民族");
		ysmsJudge.setIdentifiedAddress("123123");
		ysmsJudge.setJudgeJobaddress("鼓楼区");
		ysmsJudge.setJudgeLevel(4);
		ysmsJudge.setJudgeMobile("15123412341");
		ysmsJudge.setJudgeStatus(2);
		ysmsJudge.setJudgeTips("");
		YsmsDistrict ysmsDistrict = districtDao.findById(1);
		ysmsJudge.setYsmsDistrict(ysmsDistrict);
		YsmsJobs ysmsJobs = jobsDao.findById(8);
		ysmsJudge.setYsmsJobs(ysmsJobs);

		judgeDao.save(ysmsJudge);
	}

	 
}
