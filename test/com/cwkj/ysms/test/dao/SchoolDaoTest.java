package com.cwkj.ysms.test.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cwkj.ysms.dao.SchoolDao;
import com.cwkj.ysms.dao.SchoolUserDao;
import com.cwkj.ysms.dao.UserDao;
import com.cwkj.ysms.model.YsmsGroup;
import com.cwkj.ysms.model.YsmsSchool;
import com.cwkj.ysms.model.YsmsSchooluser;
import com.cwkj.ysms.model.YsmsUser;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations="file:WebContent/WEB-INF/springMVC-servlet.xml") 
public class SchoolDaoTest {
	
	@Autowired
	private SchoolDao schoolDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private SchoolUserDao schooluserDao;

	@Test
	public void testSave(){
		YsmsGroup ysmsGroup = new YsmsGroup();
		ysmsGroup.setGroupId(1);
		YsmsUser ysmsUser = new YsmsUser();
		ysmsUser.setDeleteflag(0);
		ysmsUser.setYsmsGroup(ysmsGroup);
		ysmsUser.setUserEmail("ceshi@163.com");
		ysmsUser.setUserName("ceshizhanghao");
		ysmsUser.setUserPassword("123456");
		userDao.save(ysmsUser);
		YsmsSchool ysmsSchool = new YsmsSchool();
		ysmsSchool.setSchoolName("xxx小学");
		ysmsSchool.setSchoolCategory(0);
		ysmsSchool.setDeleteflag(0);
		schoolDao.save(ysmsSchool);
		YsmsSchooluser ysmsSchooluser = new YsmsSchooluser();
		ysmsSchooluser.setYsmsSchool(ysmsSchool);
		ysmsSchooluser.setYsmsUser(ysmsUser);
		schooluserDao.save(ysmsSchooluser);
	}
	
	@Test
	public void testDelete(){
		YsmsSchool ysmsSchool = schoolDao.findById(201);
		ysmsSchool.setDeleteflag(1);
		schoolDao.delete(ysmsSchool);
	}
	
	@Test
	public void testUpdata(){
		YsmsSchool ysmsSchool = schoolDao.findById(201);
		if(ysmsSchool != null){
			ysmsSchool.setSchoolName("我是一个小学");
			schoolDao.updata(ysmsSchool);
		}
	}
	
	@Test
	public void testFindById(){
		YsmsSchool ysmsSchool = schoolDao.findById(9);
		System.out.println(ysmsSchool);
	}
	
	@Test
	public void testFindAll(){
		List<YsmsSchool> ysmsSchools = schoolDao.findAll();
		int size = ysmsSchools.size();
		for(int i=0;i<size;i++){
			System.out.println(ysmsSchools.get(i).getSchoolName());
		}
	}
	
	@Test
	public void TestFindByNameAndCategory(){
		String schoolName = "我是一个小学";
		String schoolCategory = "0";
		List<YsmsSchool> ysmsSchools = schoolDao.findByNameAndCategory(schoolName, schoolCategory);
		int size = ysmsSchools.size();
		for(int i=0;i<size;i++){
			System.out.println(ysmsSchools.get(i).getSchoolName());
		}
	}
}
