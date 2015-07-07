package com.cwkj.ysms.dao;

import java.util.List;

import com.cwkj.ysms.basedao.GenericDao;
import com.cwkj.ysms.model.YsmsSchool;
import com.cwkj.ysms.util.Page;

/**
 * 学校注册数据相关处理
 * @author zhangjiyao
 * @since 2015-3-6
 */
public interface SchoolDao extends GenericDao{

	/**
	 * 向数据库中存入一条学校信息
	 * @param ysmsSchool 学校信息
	 */
	public void save(YsmsSchool ysmsSchool);
	
	/**
	 * 从数据库中修改一条对应的学校信息
	 * @param ysmsSchool 学校信息
	 */
	public void updata(YsmsSchool ysmsSchool);
	
	/**
	 * 从数据库中删除一条对应的学校信息
	 * @param ysmsSchool 学校信息
	 */
	public void delete(YsmsSchool ysmsSchool);
	
	/**
	 * 根据学校信息的id从数据库中查询一个所需的学校信息
	 * @param id 学校信息的id
	 * @return YsmsSchool,内容为一个学校信息
	 */
	public YsmsSchool findById(Integer id);
	
	/**
	 * 查询数据库中所有的学校信息
	 * @return List<YsmsSchool>,内容为所有学校信息的一个List集合
	 */
	public List<YsmsSchool> findAll();
	
	/**
	 * 根据学校名和学校类型查询数据库中所有的学校信息
	 * @param schoolName 学校名
	 * @param schoolCategory 学校类型：1-小学 2-初中 3-高中
	 * @param startIndex 
	 * @return
	 */
	public List<YsmsSchool> findByNameAndCategoryAndPage(String schoolName, String schoolCategory, Page page);
	/**
	 * 根据学校名和学校类型查询数据库中所有的学校信息
	 * @param schoolName 学校名
	 * @param schoolCategory 学校类型：1-小学 2-初中 3-高中
	 * @param startIndex 
	 * @return
	 */
	public List<YsmsSchool> findByNameAndCategory(String schoolName, String schoolCategory);
	
	/**
	 * 获取满足条件的学校总数
	 * @param schoolName
	 * @param userName
	 * @param category
	 * @return
	 */
	public int getSchoolCount(String schoolName, String schoolCategory);
}
