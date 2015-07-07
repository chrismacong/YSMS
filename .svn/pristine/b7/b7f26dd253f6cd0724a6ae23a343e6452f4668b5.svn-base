package com.cwkj.ysms.dao;

import java.util.List;

import com.cwkj.ysms.basedao.GenericDao;
import com.cwkj.ysms.model.YsmsSchooluser;

/**
 * 学校用户关联表dao曾
 * @author chrismacong
 *
 */
public interface SchoolUserDao extends GenericDao {
	/**
	 * 保存或更新学校用户关系
	 * @param ysmsSchoolUser
	 */
	public void save(YsmsSchooluser ysmsSchoolUser);
	
	/**
	 * 删除学校用户关系
	 * @param ysmsSchoolUser
	 */
	public void delete(YsmsSchooluser ysmsSchoolUser);
	
	/**
	 * 根据学校Id查询学校用户关系
	 * @param schoolId
	 * @return
	 */
	public List<YsmsSchooluser> findBySchoolId(int schoolId);
	
	/**
	 * 根据用户Id查询学校用户关系
	 * @param userId
	 * @return
	 */
	public List<YsmsSchooluser> findByUserId(int userId);
}
