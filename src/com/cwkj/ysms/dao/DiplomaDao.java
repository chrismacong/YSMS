package com.cwkj.ysms.dao;

import java.util.List;

import com.cwkj.ysms.basedao.GenericDao;
import com.cwkj.ysms.model.YsmsDiploma;

/**
 * 
 * 学历常量表(ysms_diploma)数据处理接口
 * 
 * @author liyayan
 * @date 2015年3月12日 下午13:54:47
 *
 */
public interface DiplomaDao extends GenericDao {

	/**
	 * 查询
	 * @param diplomaId 学历id
	 * @return
	 */
	public YsmsDiploma findById(Integer diplomaId);
	
	/**
	 * 获取全部学历列表
	 * @return 学历list
	 */
	public List<YsmsDiploma> findAll();
}
