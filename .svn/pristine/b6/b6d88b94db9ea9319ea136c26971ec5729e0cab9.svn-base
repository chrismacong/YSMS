package com.cwkj.ysms.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.cwkj.ysms.model.YsmsJudge;
import com.cwkj.ysms.model.YsmsJudgeandlevel;
import com.cwkj.ysms.model.YsmsUser;
import com.cwkj.ysms.util.Page;

/**
 * 裁判管理Service接口 实现裁判审核和裁判查询等后台操作
 * 
 * @author chrismacong
 * @since 2015-3-5
 *
 */
public interface JudgeManagementService {
	/**
	 * 裁判员申请
	 * 
	 * @param userEmail
	 *            邮箱
	 * @param userPassword
	 *            密码
	 * @param userName
	 *            用户名
	 * @param identifiedId
	 *            身份证号
	 * @param judgeName
	 *            裁判员姓名
	 * @param judgeGender
	 *            裁判员性别 0=女 1=男
	 * @param judgeBirthDate
	 *            出生日
	 * @param identifiedAddress
	 *            户籍地址
	 * @param nationality
	 *            民族
	 * @param judegeReason
	 *            申请理由
	 * @param contact
	 *            联系方式
	 * @return
	 */
	public boolean applyJudge(String identifiedId, String identifiedName,
			int identifiedGender, String identifiedNationality,
			Date identifiedBirthday, String identifiedAddress, int jobId,
			int districtId, String jobAddress, int judgeLevel, int judgeStatus,
			String judgeMobile, String judgeTips, String fileName_id,
			String fileName_level);

	/**
	 * 
	 * 添加裁判
	 * 
	 * @param userEmail
	 * @param userPassword
	 * @param userName
	 * @param judgeName
	 * @param judgeGender
	 * @return boolean
	 *
	 */
	// public boolean addJudge(String userPassword,
	// String userName, String judgeName, String judgeGender,String judgeLevel);

	/**
	 * 获取所有裁判
	 * 
	 * @return 裁判list
	 */
	public List<Map<String, Object>> getAllJudges(String identifiedName,
			String gender, String beginTime, String endTime,
			String judgeStatus, String pageIndex);

	public Integer getAllJudgesCount(String identifiedName, String gender,
			String beginTime, String endTime, String judgeStatus);

	/**
	 * 获取相应等级的裁判 -1：未通过 0：待审核 1：校级 2：区级 3：市级
	 * 
	 * @param judgeLevel
	 * @return 裁判list
	 */
	public List<YsmsJudge> getJudgesByLevel(int judgeLevel);

	/**
	 * 
	 * 修改裁判信息
	 * 
	 * @param identifiedId
	 *            身份证ID
	 * @param judgeName
	 *            姓名
	 * @param judgeGender
	 *            性别
	 * @param judgeBirthDate
	 *            出生年月
	 * @param identifiedAddress
	 *            地址
	 * @param nationality
	 *            民族
	 * @param judegeReason
	 *            原因
	 * @param contact
	 *            联系方式
	 * @param deleteflag
	 *            删除状态
	 * @param judge_id
	 *            裁判ID
	 * @return boolean
	 *
	 */
	public boolean updateJudge(String judgeId,String jobId,String jobAddress, String districtId,
			String identifiedAddress,   String contact,
			String judgeLevel);

	public List<Map<String, Object>> getJudgeLevelByJudge(String judgeId);

	public boolean deleteJudge(String judge_id);

	public Map<String, Object> getJudgeById(int judgeId);

	public Map<String, Object> getJobAndDistrict();

	public boolean isPassed(String judgeId, String judgeStatus);

	public List<Map<String, Object>> getAtt(String judgeId, String attType);
}
