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

import com.cwkj.ysms.model.YsmsAthlete;
import com.cwkj.ysms.model.YsmsSchool;
import com.cwkj.ysms.model.YsmsTrain;
import com.cwkj.ysms.model.YsmsTrainDetail;
import com.cwkj.ysms.service.TrainingManagementService;
import com.cwkj.ysms.util.Page;
import com.cwkj.ysms.util.PageUtil;


@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations="file:WebContent/WEB-INF/springMVC-servlet.xml") 
public class TrainServiceTest {

	@Autowired
	private TrainingManagementService trainingManagementService;
	
	@Test
	public void testAddTraining() {
		try {
			String trainDesc = "1";
			String trainName = "监护人";
			String trainAddress = "南京信息工程大学滨江学院";
			String trainTeacher = "汉";
			Integer trainCategory = 1;
			String trainBegintimeStr = "2015-3-6 22:00:00";
			String trainEndtimeStr = "2015-3-7 22:00:00";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date trainBegintime = sdf.parse(trainBegintimeStr);
			Date trainEndtime = sdf.parse(trainEndtimeStr);
			trainingManagementService.addTraining(trainName, trainBegintime, trainEndtime, 
					trainAddress, trainTeacher, trainCategory, trainDesc);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdateTraining() {
		try {
			Integer trainId = 4;
			String trainDesc = "1";
			String trainName = "监护人培训";
			String trainAddress = "南京信息工程大学滨江学院";
			String trainTeacher = "zhujiangren";
			Integer trainCategory = 1;
			String trainBegintimeStr = "2015-3-6 22:00:00";
			String trainEndtimeStr = "2015-3-7 22:00:00";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date trainBegintime = sdf.parse(trainBegintimeStr);
			Date trainEndtime = sdf.parse(trainEndtimeStr);
			System.out.println(trainingManagementService.updateTraining(trainId, trainName, 
					trainBegintime, trainEndtime, trainAddress, trainTeacher, trainCategory, 
					trainDesc));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDeleteTraining() {
		Integer trainId = 4;
		System.out.println(trainingManagementService.deleteTraining(trainId));
	}

	@Test
	public void testGetTrainingByID() {
		Integer trainId = 1;
		YsmsTrain ysmsTrain = trainingManagementService.getTrainingByID(trainId);
		System.out.println(ysmsTrain.getTrainAddress());
	}

	@Test
	public void testGetAllTrainings() {
		List<YsmsTrain> ysmsTrainList = trainingManagementService.getAllTrainings();
		if(ysmsTrainList.size()>0){
			for(int i = 0; i<ysmsTrainList.size();i ++){
				System.out.println(ysmsTrainList.get(i).getTrainAddress());
			}
		}else{
			System.out.println("无数据");
		}
	}

	@Test
	public void testGetAllTrainingsByPage() {
		Page page = new Page();
		page.setEveryPage(10);
		page.setBeginIndex(0);
		List<YsmsTrain> ysmsTrainList = trainingManagementService.getAllTrainingsByPage(page);
		if(ysmsTrainList.size()>0){
			for(int i = 0; i<ysmsTrainList.size();i ++){
				System.out.println(ysmsTrainList.get(i).getTrainAddress());
			}
		}else{
			System.out.println("无数据");
		}
	}
	
	@Test
	public void testAddTrainDetail() {
		int learnerId = 4;
		int trainId = 2;
		System.out.println(trainingManagementService.addTrainDetail(learnerId, trainId));
	}
	
	@Test
	public void testModifyTrainDetail() {
		int detailId = 1;
		int detailResult = -1;
		System.out.println(trainingManagementService.modifyTrainDetail(detailId, detailResult));
	}
	
	@Test
	public void testGetTrainDeatilsByConditionsAndPage() {
		String learnerId = "4";
		String trainId = "2";
		String detailResult = "0";
		Page page = PageUtil.createPage(15, 1);
		List<YsmsTrainDetail> ysmsTrainDetails = trainingManagementService.getTrainDeatilsByConditionsAndPage(learnerId, trainId, detailResult, page);
		if(ysmsTrainDetails!=null){
			int size = ysmsTrainDetails.size();
			for(int i=0;i<size;i++){
				System.out.println(ysmsTrainDetails.get(i).getDetailId());
			}
		}
	}
}
