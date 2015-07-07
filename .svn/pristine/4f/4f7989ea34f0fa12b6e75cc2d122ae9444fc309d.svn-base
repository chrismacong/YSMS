package com.cwkj.ysms.dao;

import java.util.Date;
import java.util.List;

import com.cwkj.ysms.basedao.GenericDao;
import com.cwkj.ysms.model.YsmsTrain;
import com.cwkj.ysms.util.Page;

public interface TrainDao extends GenericDao {

	/**
	 * 保存培训信息
	 * @param YsmsTrain
	 */
	public void save(YsmsTrain ysmsTrain);
	
	/**
	 * 删除培训信息
	 * @param YsmsTrain 培训id
	 */
	public void delete(YsmsTrain ysmsTrain);
	
	/**
	 * 查询培训信息
	 * @param trainId 培训id
	 * @return
	 */
	public YsmsTrain findById(Integer trainId);
	/**
	 * 修改培训信息
	 * @param YsmsTrain
	 */
	public void updata(YsmsTrain ysmsTrain);
	
	/**
	 * 查询全部培训信息
	 * @return List<YsmsTrain> 培训信息List
	 */
	public List<YsmsTrain> findAll();
	
	/**
	 * 分页查询全部培训信息
	 * @return List<YsmsTrain> 培训信息List
	 */
	public List<YsmsTrain> findAllByPage(Page page);
}
