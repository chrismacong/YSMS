package com.cwkj.ysms.service;

import java.util.Date;
import java.util.List;

import com.cwkj.ysms.model.YsmsCoach;
import com.cwkj.ysms.model.YsmsJobs;
import com.cwkj.ysms.model.view.CoachManagerListView;
import com.cwkj.ysms.util.Page;

/**
 * 
 * 教练员信息模块接口 提供对教练员信息的新增，修改，删除和查询方法；
 * 
 * @author panhailin henry_pan@126.com
 * @date 2015年3月5日 下午4:52:41
 *
 */
public interface CoachManagementService {
	/**
	 * @param identifiedId
	 * @param schoolId
	 * @param coachContact
	 * @param identifiedName
	 * @param identifiedGender
	 * @param identifiedBirthday
	 * @param identifiedAddress
	 * @param identifiedNationality
	 * @param photoBase64
	 * @param jobIndex
	 * @param landPhone
	 * @param schoolcoachFlag
	 * @return
	 */
	public boolean addCoach(String identifiedId, Integer schoolId,
			String coachContact, String identifiedName, Integer identifiedGender,
			Date identifiedBirthday, String identifiedAddress,
			String identifiedNationality, String photoBase64, String landPhone, int jobIndex,
			int coachLevel, String coachattachment,
			boolean schoolcoachFlag, String schoolattachment);

	/**
	 * 
	 * 根据教练员ID修改教练员信息
	 * 
	 * @param coachId
	 *            教练员ID
	 * @param identifiedId
	 *            身份证ID
	 * @param schoolId
	 *            身份证ID
	 * @param coachContact
	 *            联系方式
	 * @param identifiedName
	 *            姓名
	 * @param identifiedGender
	 *            性别
	 * @param identifiedBirthday
	 *            出生年月
	 * @param identifiedAddress
	 *            地址
	 * @param identifiedNationality
	 *            民族
	 * @return boolean
	 *
	 */
	public boolean updateCoach(Integer coachId, String identifiedId,
			Integer schoolId, String coachContact, String identifiedName,
			Integer identifiedGender, Date identifiedBirthday,
			String identifiedAddress, String identifiedNationality, 
			int coachLevel, boolean schoolcoachFlag);

	/**
	 * 
	 * 根据coachId删除教练员信息
	 * 
	 * @param coachId
	 *            教练员ID
	 * @return boolean
	 *
	 */
	public boolean deleteCoach(Integer coachId);

	/**
	 * 
	 * 根据coachId查询教练员信息
	 * 
	 * @param coachId
	 *            教练员ID
	 * @return YsmsCoach
	 *
	 */
	public YsmsCoach getCoachByID(Integer coachId);

	/**
	 * 
	 * 根据身份证ID，学校ID，联系方式，姓名或者性别查询教练员信心
	 * 
	 * @param identifiedId
	 *            身份证ID
	 * @param schoolId
	 *            学校ID
	 * @param coachContact
	 *            联系方式
	 * @param identifiedName
	 *            姓名
	 * @param identifiedGender
	 *            性别
	 * @return List<YsmsCoach>
	 *
	 */
	public List<YsmsCoach> getCoaches(String identifiedId, Integer schoolId,
			String coachContact, String identifiedName, Integer identifiedGender);

	/**
	 * 
	 * 根据身份证ID，学校ID，联系方式，姓名或者性别分页查询教练员信心
	 * 
	 * @param identifiedId
	 *            身份证ID
	 * @param schoolId
	 *            学校ID
	 * @param coachContact
	 *            联系方式
	 * @param identifiedName
	 *            姓名
	 * @param identifiedGender
	 *            性别
	 * @return List<YsmsCoach>
	 *
	 */
	List<YsmsCoach> getCoachesByPage(String identifiedId, Integer schoolId,
			String coachContact, String identifiedName, Integer identifiedGender,Page page);

	List<YsmsCoach> getCoachesByPageAndOrder(String identifiedId,
			Integer schoolId, String coachContact, String identifiedName,
			Integer identifiedGender, Page page, String order);

	int getCoachesByPageAndOrderCount(String identifiedId, Integer schoolId,
			String coachContact, String identifiedName, Integer identifiedGender);

	public List<CoachManagerListView> getCoachesManagerListViewByPageAndOrder(
			String identifiedId, Integer schoolId, String coachContact,
			String identifiedName, Integer identifiedGender, Page page,
			String orderString);

	public CoachManagerListView getCoachListViewByID(int parseInt);

	public boolean updateCoach(int coachId, Integer schoolId, String coachPhone,  String coachLandPhone,
			int jobIndex, int coachLevel, boolean schoolcoachFlag, String image);

	/**
	 * 获取所有职业列表（不含学生）
	 * @return
	 */
	List<YsmsJobs> getAllJobs();
}
