package com.cwkj.ysms.dao;

import java.util.List;

import com.cwkj.ysms.basedao.GenericDao;
import com.cwkj.ysms.model.YsmsAthlete;
import com.cwkj.ysms.util.Page;

/**
 * 
 * 运动员表(YSMS_Athlete)数据处理接口
 * 
 * @author liyayan
 * @date 2015年3月6日 下午16:11:47
 *
 */
public interface AthleteDao extends GenericDao {

	/**
	 * 保存运动员信息
	 * @param ysmsAthlete
	 */
	public void save(YsmsAthlete ysmsAthlete);
	
	/**
	 * 删除运动员信息
	 * @param ysmsAthlete 运动员id
	 */
	public void delete(YsmsAthlete ysmsAthlete);
	
	/**
	 * 查询运动员信息
	 * @param athleteId 运动员id
	 * @return
	 */
	public YsmsAthlete findById(Integer athleteId);
	/**
	 * 修改运动员信息
	 * @param ysmsAthlete
	 */
	public void updata(YsmsAthlete ysmsAthlete);
	
	/**
	 * 查询全部运动员信息
	 * @return List<YsmsAthlete> 运动员信息List
	 */
	public List<YsmsAthlete> findAll();
	
	/**
	 * 分页查询全部运动员信息
	 * @return List<YsmsAthlete> 运动员信息List
	 */
	public List<YsmsAthlete> findAllByPage(Page page);
	
	/**
	 * 通过身份证id查询运动员信息
	 * @param identifiedId 身份证id
	 * @return
	 */
	public List<YsmsAthlete> findByIdentifiedId(String identifiedId);
	
	/**
	 * 模糊查询
	 * @param schoolId 学校id
	 * @param identifiedId 身份证id
	 * @param identifiedName 身份证姓名
	 * @param identifiedGender 
	 * @param athletePosition  位置
	 * @param athleteSchoolyear 入学年份
	 * @param studentId 学籍id
	 * @return
	 */
	public List<YsmsAthlete> findByFuzzyQuery(Integer schoolId, String identifiedId,
			String identifiedName, Integer identifiedGender,
			Integer athletePosition,Integer studentId,String athleteSchoolyear);
	
	/**
	 * 模糊查询
	 * @param schoolId 学校id
	 * @param identifiedId 身份证id
	 * @param identifiedName 身份证姓名
	 * @param identifiedGender 性别
	 * @param athletePosition  位置
	 * @param athleteSchoolyear 入学年份
	 * @param studentId 学籍id
	 * @param page 
	 * @return
	 */
	public List<YsmsAthlete> findByFuzzyQueryAndPage(Integer schoolId, String identifiedId,
			String identifiedName, Integer identifiedGender,
			Integer athletePosition,Integer studentId,String athleteSchoolyear,Page page);

	public int findByFuzzyQueryAndPageCount(Integer schoolId, String identifiedId,
			String identifiedName, Integer identifiedGender,
			Integer athletePosition, Integer studentId, String athleteSchoolyear);

	public List<YsmsAthlete> findByFuzzyQueryAndPageAndOrder(Integer schoolId,
			String identifiedId, String identifiedName,
			Integer identifiedGender, Integer athletePosition,
			Integer studentId, String athleteSchoolyear, Page page,
			String orderString);

	public String createRegisterID(int schoolID, int yearIn, int athleteID);
	
	public List<YsmsAthlete> findForBinding(String identifiedName, String identifiedId, String registerId);
	
	public List<YsmsAthlete> findIncludingJin();
}
