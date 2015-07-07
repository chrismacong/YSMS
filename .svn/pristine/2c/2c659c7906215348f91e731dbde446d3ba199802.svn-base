package com.cwkj.ysms.service;

import java.util.List;

import com.cwkj.ysms.model.YsmsSchool;
import com.cwkj.ysms.model.view.SchoolView;

/**
 * 学校信息模块接口 提供对学校信息的新增，修改，删除和查询方法；
 * 
 * @author panhailin henry_pan@126.com
 * @date 2015年3月5日 下午3:19:55
 *
 */
public interface SchoolManagementService {
	/**
	 * 新增一所学校并根据学校名称生成用户名和密码
	 * @param schoolName 学校名称
	 * @param schoolCategory 学校类型
	 * @param userEmail 邮箱
	 * @return boolean 布尔值
	 */
	public boolean addSchool(String groupId,String schoolName, String schoolCategory,String userEmail,
			String userName, String userPassword,String districtId,String schoolAddress,String schoolContacts,String schoolMobile,String schoolFax);

	/**
	 * 删除一所学校
	 * @param schoolId 学校ID
	 * @return boolean 返回类型
	 */
	public boolean deleteSchool(int schoolId);

	/**
	 * 根据ID查询学校
	 * @param schoolId 学校ID
	 * @return YsmsSchool 返回类型
	 */
	public YsmsSchool getSchoolByID(int schoolId);

	/**
	 * 根据学校ID更新学校信息
	 * @param schoolId 学校ID
	 * @param schoolName 学校名称
	 * @param schoolCategory 学校类型
	 * @return boolean 返回类型
	 */
	public boolean updateSchool(String schoolId, String schoolName);

	/**
	 * 根据学校名称或学校类别查询学校列表
	 * @param schoolName 学校名称
	 * @param schoolCategory 学校类别
	 * @return List<YsmsSchool> 返回类型
	 */
	public List<YsmsSchool> getSchools(String schoolName, String schoolCategory);
	
	/**
	 * 获取全部学校列表
	 * @param string 
	 * @return
	 */
	public List<SchoolView> getAllSchools(String schoolName, String schoolCategory, String pageIndex);
	
	/**
	 * 获取总学校数
	 * @return
	 */
	public int getSchoolsCount(String schoolName, String schoolCategory);

}
