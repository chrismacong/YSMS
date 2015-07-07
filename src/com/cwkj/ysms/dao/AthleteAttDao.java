package com.cwkj.ysms.dao;

import com.cwkj.ysms.basedao.GenericDao;
import com.cwkj.ysms.model.YsmsAthleteAtt;

public interface AthleteAttDao extends GenericDao {
	/**
	 * 保存或更新照片信息
	 * @param ysmsAthleteAtt
	 */
	public void save(YsmsAthleteAtt ysmsAthleteAtt);
	
	/**
	 * 根据运动员Id查找图片对象
	 * @param athleteId
	 */
	public YsmsAthleteAtt findByAthleteId(int athleteId);
	
	/**
	 * 删除照片信息，一般伴随运动员删除而删除
	 * @param ysmsAthleteAtt
	 */
	public void delete(YsmsAthleteAtt ysmsAthleteAtt);

}
