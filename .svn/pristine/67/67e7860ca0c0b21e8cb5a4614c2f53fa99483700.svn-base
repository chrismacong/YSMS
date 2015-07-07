package com.cwkj.ysms.service;

import java.util.Date;
import java.util.List;

import com.cwkj.ysms.model.YsmsTrain;
import com.cwkj.ysms.model.YsmsTrainDetail;
import com.cwkj.ysms.util.Page;

/**
 * 
 * 培训信息模块接口 提供对培训信息的新增，修改，删除和查询方法；
 * 
 * @author panhailin henry_pan@126.com
 * @date 2015年3月5日 下午4:10:38
 *
 */
public interface TrainingManagementService {
	/**
	 * 
	 * 添加培训课程
	 * 
	 * @param trainName
	 *            课程名称
	 * @param trainBegintime
	 *            开始时间
	 * @param trainEndtime
	 *            结束时间
	 * @param trainAddress
	 *            培训地点
	 * @param trainTeacher
	 *            授课老师
	 * @param trainCategory
	 *            课程分类
	 * @param trainDesc
	 *            课程描述
	 * @return boolean
	 *
	 */
	public boolean addTraining(String trainName, Date trainBegintime,
			Date trainEndtime, String trainAddress, String trainTeacher,
			int trainCategory, String trainDesc);

	/**
	 * 
	 * 根据trainId修改培训信息
	 * 
	 * @param trainId
	 *            课程ID
	 * @param trainName
	 *            课程名称
	 * @param trainBegintime
	 *            开始时间
	 * @param trainEndtime
	 *            结束时间
	 * @param trainAddress
	 *            培训地点
	 * @param trainTeacher
	 *            授课老师
	 * @param trainCategory
	 *            课程分类
	 * @param trainDesc
	 *            课程描述
	 * @return boolean
	 *
	 */
	public boolean updateTraining(int trainId, String trainName,
			Date trainBegintime, Date trainEndtime, String trainAddress,
			String trainTeacher, int trainCategory, String trainDesc);

	/**
	 * 
	 * 根据trainId删除培训信息
	 * 
	 * @param trainId
	 *            课程ID
	 * @return boolean
	 *
	 */
	public boolean deleteTraining(int trainId);

	/**
	 * 
	 * 根据trainId查询一条培训信息
	 * 
	 * @param trainId
	 *            课程ID
	 * @return YsmsTrain 培训信息POJO
	 *
	 */
	public YsmsTrain getTrainingByID(int trainId);
	
	/**
	 * 查询全部培训
	 * @return
	 */
	public List<YsmsTrain> getAllTrainings();
	
	/**
	 * 分页查询全部培训
	 * @return
	 */
	public List<YsmsTrain> getAllTrainingsByPage(Page page);
	
	/**
	 * 为教练员或者裁判员报名一家培训
	 * @param learnerId 教练员或者裁判员用户Id
	 * @param trainId 培训课程Id
	 * @return true-添加成功；false-添加失败
	 */
	public boolean addTrainDetail(int learnerId, int trainId);
	
	/**
	 * 修改教练员或者裁判员参与的课程进度
	 * @param detailId
	 * @param detailResult 
	 * 0-报名未审核；
	 * -1报名未通过；
	 * 1-报名通过学习中；
	 * 2-课程学完通过；
	 * 3课程学完未通过
	 * @return true-修改成功；false-修改失败
	 */
	public boolean modifyTrainDetail(int detailId, int detailResult);
	
	/**
	 * 检查训练员或者裁判员是否已经报名该培训
	 * @param learnerId 教练员或者裁判员用户Id
	 * @param trainId 培训课程Id
	 * @return true-可以报名；false-已经报名
	 */
	public boolean checkTrainDetail(int learnerId, int trainId);
	
	/**
	 * 
	 * @param learnerId
	 * @param trainId
	 * @param detailResult
	 * @param page
	 * @return
	 */
	public List<YsmsTrainDetail> getTrainDeatilsByConditionsAndPage(String learnerId,
			String trainId,String detailResult,Page page);
}
