package com.cwkj.ysms.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.cwkj.ysms.basedao.GenericDao;
import com.cwkj.ysms.model.YsmsJudge;
import com.cwkj.ysms.model.YsmsJudgeAtt;
import com.cwkj.ysms.util.Page;

/**
 * 
 * 裁判表(Ysms_Judge)数据处理接口
 * 
 * @author panhailin henry_pan@126.com
 * @date 2015年3月10日 下午1:49:15
 *
 */
public interface JudgeDao extends GenericDao {
	/**
	 * 
	 * 保存裁判信息
	 * 
	 * @param ysmsJudge
	 *            裁判员对象 void
	 *
	 */
	public Integer save(YsmsJudge ysmsJudge);

	

	/**
	 * 
	 * 
	 * @param userId
	 *            用户id
	 * @param identifiedId
	 *            身份证
	 * @param judgeName
	 *            裁判姓名
	 * @param judgeGender
	 *            性别
	 * @param judgeBirthDate
	 *            出生年月
	 * @param identifiedAddress
	 *            地址
	 * @param nationality
	 *            民族
	 * @param judegeReason
	 *            申请理由
	 * @param contact
	 *            联系方式 void
	 *
	 */
	public void update(String identifiedId, String judgeName,
			String judgeGender, String judgeBirthDate,
			String identifiedAddress, String nationality, String judegeReason,
			String contact, String deleteflag, String judge_id);
	
	
	public void delete(String judge_id);

	public List<Map<String,Object>> getJudgeListByPage(String identifiedName,
			String gender, String beginTime, String endTime,
			String judgeStatus,int startIndex);
	
	
	public List<Map<String,Object>> getJudgeListCount(String identifiedName,
			String gender, String beginTime, String endTime,
			String judgeStatus);

	/**
	 * 根据id查找裁判
	 * 
	 * @param judgeId
	 * @return
	 */
	public YsmsJudge findById(int judgeId);
	
	public List<Map<String,Object>> getJudgeById(int judgeId);
	
	
	public void updateById(YsmsJudge ysmsJudge);
	
	
	public void saveAtt(YsmsJudgeAtt att);
	
	public List<Map<String,Object>> gettAtt(int judgeId,int attType);
	
	public void isPassed(int judgeId,int judgeStatus);

}
