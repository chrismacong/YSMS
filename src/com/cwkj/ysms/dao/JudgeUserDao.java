package com.cwkj.ysms.dao;

import java.util.List;

import com.cwkj.ysms.basedao.GenericDao;
import com.cwkj.ysms.model.YsmsJudgeUser;

/**
 * 学校用户关联表dao曾
 * @author chrismacong
 *
 */
public interface JudgeUserDao extends GenericDao {
	/**
	 * 保存或更新裁判员用户关系
	 * @param ysmsSchoolUser
	 */
	public void save(YsmsJudgeUser ysmsJudgeUser);
	
	/**
	 * 删除裁判员用户关系
	 * @param ysmsSchoolUser
	 */
	public void delete(YsmsJudgeUser ysmsJudgeUser);
	
	/**
	 * 根据裁判员Id查询裁判员用户关系
	 * @param schoolId
	 * @return
	 */
	public List<YsmsJudgeUser> findByJudgeId(int judgeId);
	
	/**
	 * 根据用户Id查询裁判员用户关系
	 * @param userId
	 * @return
	 */
	public List<YsmsJudgeUser> findByUserId(int userId);
}
