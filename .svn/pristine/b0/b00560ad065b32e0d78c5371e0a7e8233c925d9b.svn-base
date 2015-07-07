package com.cwkj.ysms.dao;

import java.util.List;

import com.cwkj.ysms.basedao.GenericDao;
import com.cwkj.ysms.model.YsmsAthlete;
import com.cwkj.ysms.model.YsmsCoach;
import com.cwkj.ysms.model.view.CoachManagerListView;
import com.cwkj.ysms.util.Page;
/**
 * 
 * 教练表数据处理接口
 * 
 * @author chrismacong
 * @since 2015-3-9
 *
 */
public interface CoachDao extends GenericDao {
	/**
	 * 保存教练员信息
	 * @param ysmsCoach
	 */
	public void save(YsmsCoach ysmsCoach);
	
	/**
	 * 删除教练员信息
	 * @param ysmsCoach 教练员id
	 */
	public void delete(YsmsCoach ysmsCoach);
	
	/**
	 * 修改运教练员信息
	 * @param ysmsCoach
	 */
	public void updata(YsmsCoach ysmsCoach);
	/**
	 * 查询教练员信息
	 * @param coachId 教练员id
	 * @return
	 */
	public YsmsCoach findById(Integer coachId);
	
	/**
	 * 查询全部教练员信息
	 * @return List<YsmsCoach> 教练员信息List
	 */
	public List<YsmsCoach> findAll();
	
	/**
	 * 分页查询全部教练员信息
	 * @return List<YsmsCoach> 教练员信息List
	 */
	public List<YsmsCoach> findAllByPage(Page page);
	
	/**
	 * 模糊查询
	 * @param schoolId 学校id
	 * @param identifiedId 身份证id
	 * @param identifiedName 身份证姓名
	 * @param identifiedGender 性别
	 * @param coachContact  联系方式
	 * @return
	 */
	public List<YsmsCoach> findByFuzzyQuery(String identifiedId, Integer schoolId,
			String coachContact, String identifiedName, Integer identifiedGender);
	
	
	/**
	 * 模糊查询
	 * @param schoolId 学校id
	 * @param identifiedId 身份证id
	 * @param identifiedName 身份证姓名
	 * @param identifiedGender 性别
	 * @param coachContact  联系方式
	 * @param page
	 * @return
	 */
	public List<YsmsCoach> findByFuzzyQueryAndPage(String identifiedId, Integer schoolId,
			String coachContact, String identifiedName, Integer identifiedGender, Page page);

	public int findByFuzzyQueryAndPageCount(String identifiedId,
			Integer schoolId, String coachContact, String identifiedName,
			Integer identifiedGender);

	public List<YsmsCoach> findByFuzzyQueryByPageAndOrder(String identifiedId,
			Integer schoolId, String coachContact, String identifiedName,
			Integer identifiedGender, Page page, String order);

	public CoachManagerListView getCoachListViewByID(int coachId);
}
