package com.cwkj.ysms.dao;

import java.util.List;

import com.cwkj.ysms.basedao.GenericDao;
import com.cwkj.ysms.model.YsmsTrainDetail;
import com.cwkj.ysms.util.Page;

/**
 * 培训关联数据相关处理
 * @author zhangjiyao
 * @since 2015-3-11
 */
public interface TrainDetailDao extends GenericDao{

	/**
	 * 向数据库中存入一条培训关联信息
	 * @param YsmsTrainDetail 培训关联信息
	 */
	public void save(YsmsTrainDetail ysmsTrainDetail);
	
	/**
	 * 从数据库中修改一条对应的培训关联信息
	 * @param YsmsTrainDetail 培训关联信息
	 */
	public void updata(YsmsTrainDetail ysmsTrainDetail);
	
	/**
	 * 从数据库中删除一条对应的培训关联信息
	 * @param YsmsTrainDetail 培训关联信息
	 */
	public void delete(YsmsTrainDetail ysmsTrainDetail);
	
	/**
	 * 根据培训关联信息的id从数据库中查询一个所需的培训关联信息
	 * @param id 培训关联信息的id
	 * @return YsmsTrainDetail,内容为一个培训关联信息
	 */
	public YsmsTrainDetail findById(Integer id);
	
	/**
	 * 查询数据库中所有的培训关联信息
	 * @return List<YsmsTrainDetail>,内容为所有培训关联信息的一个List集合
	 */
	public List<YsmsTrainDetail> findAll();
	
	/**
	 * 根据训练者ID或者培训课程ID分页查询数据库中所有的培训关联信息
	 * @param learnerId 训练者Id
	 * @param trainId 训练课程Id
	 * @param detailResult 课程训练结果
	 * @param page 分页，page为null取消分页功能
	 * @return
	 */
	public List<YsmsTrainDetail> findByConditionsAndPage(String learnerId,String trainId,String detailResult,Page page);
}
