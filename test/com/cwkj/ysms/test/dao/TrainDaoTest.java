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

import com.cwkj.ysms.dao.TrainDao;
import com.cwkj.ysms.model.YsmsTrain;
import com.cwkj.ysms.model.YsmsTrainDetail;
import com.cwkj.ysms.util.Page;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations="file:WebContent/WEB-INF/springMVC-servlet.xml")
public class TrainDaoTest {

	@Autowired
	private TrainDao trainDao;

	@Test
	public void testSave(){

		YsmsTrain ysmsTrain = new YsmsTrain();
		ysmsTrain.setDeleteflag(0);
		ysmsTrain.setTrainAddress("XX街道");
		ysmsTrain.setTrainCategory(1);
		ysmsTrain.setTrainName("名称");
		ysmsTrain.setTrainDesc("描述");
		ysmsTrain.setTrainTeacher("主讲人");
		/*YsmsTrainDetail ysmsTrainDetail = new YsmsTrainDetail();
		ysmsTrain.setYsmsTrainDetails(ysmsTrainDetail);*/
		String dateStr1 = "2015-01-01 00:00:00";
		String dateStr2 = "2015-01-03 00:00:00";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date1 = new Date();
		Date date2 = new Date();
		try {
			date1 = sdf.parse(dateStr1);
			date2 = sdf.parse(dateStr2);
			ysmsTrain.setTrainBegintime(date1);
			ysmsTrain.setTrainEndtime(date2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		trainDao.save(ysmsTrain);
	}
	
	@Test
	public void testDelete(){
		YsmsTrain a = trainDao.findById(3);
		trainDao.delete(a);
	}
	
	@Test
	public void testUpdata(){
		YsmsTrain a = trainDao.findById(1);
		a.setDeleteflag(1);
		trainDao.updata(a);
		System.out.println(a.getDeleteflag());
	}
	
	@Test
	public void testFindById(){
		YsmsTrain a = trainDao.findById(1);
		System.out.println(a.getDeleteflag());
	}
	
	@Test
	public void testFindAll(){
		List<YsmsTrain> y = new ArrayList<YsmsTrain>();
		y = trainDao.findAll();
		System.out.println(y.size());
	}
	
	@Test
	public void findAllByPage() {
		Page page = new Page();
		page.setBeginIndex(1);
		page.setCurrentPage(1);
		page.setEveryPage(20);
		List<YsmsTrain> trainList = trainDao.findAllByPage(page);
		System.out.println(trainList.size());
	}
}
