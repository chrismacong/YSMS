package com.cwkj.ysms.dao;

import java.util.List;

import com.cwkj.ysms.basedao.GenericDao;
import com.cwkj.ysms.model.YsmsJobs;
/**
 * 
 * 工作常量表(ysms_job)数据处理接口
 * 
 * @author liyayan
 * @date 2015年3月12日 下午13:54:47
 *
 */
public interface JobsDao extends GenericDao {
	/**
	 * 查询
	 * @param jobId 工作id
	 * @return
	 */
	public YsmsJobs findById(Integer jobId);
	
	/**
	 * 获取全部职业列表
	 * @return 职业list
	 */
	public List<YsmsJobs> findAll();
	
	/**
	 * 获取所有ID号小于100的职业
	 * 即不包含学生
	 * @return
	 */
	public List<YsmsJobs> findAllBesidesStudent();
}
