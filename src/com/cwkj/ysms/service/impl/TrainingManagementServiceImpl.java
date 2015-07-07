package com.cwkj.ysms.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cwkj.ysms.dao.TrainDao;
import com.cwkj.ysms.dao.TrainDetailDao;
import com.cwkj.ysms.model.YsmsAthlete;
import com.cwkj.ysms.model.YsmsTrain;
import com.cwkj.ysms.model.YsmsTrainDetail;
import com.cwkj.ysms.service.TrainingManagementService;
import com.cwkj.ysms.util.Page;

@Service
public class TrainingManagementServiceImpl implements TrainingManagementService {

	@Resource
	private TrainDao trainDao;
	@Resource
	private TrainDetailDao trainDetailDao;
	
	public TrainDao getTrainDao() {
		return trainDao;
	}

	public void setTrainDao(TrainDao trainDao) {
		this.trainDao = trainDao;
	}

	public TrainDetailDao getTrainDetailDao() {
		return trainDetailDao;
	}

	public void setTrainDetailDao(TrainDetailDao trainDetailDao) {
		this.trainDetailDao = trainDetailDao;
	}

	@Override
	public boolean addTraining(String trainName, Date trainBegintime,
			Date trainEndtime, String trainAddress, String trainTeacher,
			int trainCategory, String trainDesc) {
		try {
			YsmsTrain ysmsTrain = new YsmsTrain();
			ysmsTrain.setDeleteflag(0);
			ysmsTrain.setTrainAddress(trainAddress);
			ysmsTrain.setTrainCategory(trainCategory);
			ysmsTrain.setTrainName(trainName);
			ysmsTrain.setTrainDesc(trainDesc);
			ysmsTrain.setTrainTeacher(trainTeacher);
			ysmsTrain.setTrainBegintime(trainBegintime);
			ysmsTrain.setTrainEndtime(trainEndtime);
			trainDao.save(ysmsTrain);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean updateTraining(int trainId, String trainName,
			Date trainBegintime, Date trainEndtime, String trainAddress,
			String trainTeacher, int trainCategory, String trainDesc) {
		try {
			YsmsTrain ysmsTrain = trainDao.findById(trainId);
			ysmsTrain.setDeleteflag(0);
			ysmsTrain.setTrainAddress(trainAddress);
			ysmsTrain.setTrainCategory(trainCategory);
			ysmsTrain.setTrainName(trainName);
			ysmsTrain.setTrainDesc(trainDesc);
			ysmsTrain.setTrainTeacher(trainTeacher);
			ysmsTrain.setTrainBegintime(trainBegintime);
			ysmsTrain.setTrainEndtime(trainEndtime);
			trainDao.updata(ysmsTrain);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteTraining(int trainId) {
		try {
			YsmsTrain ysmsTrain = trainDao.findById(trainId);
			ysmsTrain.setDeleteflag(1);
			trainDao.updata(ysmsTrain);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public YsmsTrain getTrainingByID(int trainId) {
		YsmsTrain ysmsTrain = trainDao.findById(trainId);
		return ysmsTrain;
	}

	@Override
	public List<YsmsTrain> getAllTrainings() {
		List<YsmsTrain> ysmsTrainList = trainDao.findAll();
		return ysmsTrainList;
	}

	@Override
	public List<YsmsTrain> getAllTrainingsByPage(Page page) {
		List<YsmsTrain> ysmsTrainList = trainDao.findAllByPage(page);
		return ysmsTrainList;
	}

	@Override
	public boolean addTrainDetail(int learnerId, int trainId) {
		try {
			YsmsTrain ysmsTrain = trainDao.findById(trainId);
			YsmsTrainDetail ysmsTrainDetail = new YsmsTrainDetail();
			ysmsTrainDetail.setDetailResult(0);
			ysmsTrainDetail.setLearnerId(learnerId);
			ysmsTrainDetail.setYsmsTrain(ysmsTrain);
			trainDetailDao.save(ysmsTrainDetail);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean modifyTrainDetail(int detailId, int detailResult) {
		try {
			YsmsTrainDetail ysmsTrainDetail = trainDetailDao.findById(detailId);
			ysmsTrainDetail.setDetailResult(detailResult);
			trainDetailDao.updata(ysmsTrainDetail);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean checkTrainDetail(int learnerId, int trainId) {
		List<YsmsTrainDetail> results = trainDetailDao.findByConditionsAndPage(learnerId+"", trainId+"", null, null);
		if(results.size()>0){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public List<YsmsTrainDetail> getTrainDeatilsByConditionsAndPage(String learnerId,
			String trainId, String detailResult, Page page) {
		List<YsmsTrainDetail> results = trainDetailDao.findByConditionsAndPage(learnerId, trainId, detailResult, page);
		if(results.size()>0){
			return results;
		}else{
			return null;
		}
	}

}
