package com.cwkj.ysms.test.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cwkj.ysms.model.YsmsAthlete;
import com.cwkj.ysms.model.YsmsWechatnews;
import com.cwkj.ysms.service.NewsManagementService;
import com.cwkj.ysms.service.WechatService;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations="file:WebContent/WEB-INF/springMVC-servlet.xml") 
public class WechatServiceTest {
	@Autowired
	private WechatService wechatService;
	
	@Autowired
	private NewsManagementService newsManagementService;
	
	@Test
	public void testIsOpenIdExist() {
		System.out.println(wechatService.isOpenIdExist("1234123123123ff2"));
	}
	
	@Test
	public void testSaveWechatAccount(){
		//System.out.println(wechatService.saveWechatAccount("1234123123123ff2"));
	}
	@Test
	public void testDeleteWechatAccount(){
		System.out.println(wechatService.deleteWechatAccount("1234123123123ff2"));
	}
	
	@Test
	public void testFindAthleteByOpenId(){
		YsmsAthlete ysmsAthlete = wechatService.findAthleteByOpenId("1234123123123ff2");
		if(ysmsAthlete==null)
			System.out.println("未绑定运动员");
		else
			System.out.println("与" + ysmsAthlete.getIdentifiedName() + "进行了绑定");
	}
	
	@Test
	public void testBindAthleteWechat(){
		System.out.println(wechatService.bindAthleteWechat("1234123123123ff2", "潘晓静", "220104198809020012", "NJ0001201500000439"));
	}
	
	@Test
	public void testUnbindAthleteWechat(){
		System.out.println(wechatService.unbindAthleteWechat("1234123123123ff2"));
	}
	
	@Test
	public void testIsBinded(){
		System.out.println(wechatService.isBinded("1234123123123ff2"));
	}
	
	@Test
	public void testGetLatest10(){
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		List<YsmsWechatnews> newList = newsManagementService.getNewsByDateLimit10(date,0);
		System.out.println(newList.size());
	}
	
}
