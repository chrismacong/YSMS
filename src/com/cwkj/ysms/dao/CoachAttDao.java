package com.cwkj.ysms.dao;

import com.cwkj.ysms.basedao.GenericDao;
import com.cwkj.ysms.model.YsmsCoachAtt;
import com.cwkj.ysms.model.YsmsJudgeAtt;

public interface CoachAttDao extends GenericDao {
	/**
	 * 保存或更新照片信息
	 * @param ysmsCoachAtt
	 */
	public void save(YsmsCoachAtt ysmsCoachAtt);
	
	/**
	 * 根据教练员Id查找图片对象
	 * @param CoachId
	 */
	public YsmsCoachAtt findByCoachId(int CoachId);
	
	/**
	 * 删除照片信息，一般伴随教练员删除而删除
	 * @param ysmsCoachAtt
	 */
	public void delete(YsmsCoachAtt ysmsCoachAtt);
}
