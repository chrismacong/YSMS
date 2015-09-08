package com.cwkj.ysms.dao;

import java.util.List;
import java.util.Map;

import com.cwkj.ysms.basedao.GenericDao;
import com.cwkj.ysms.model.YsmsJudgeandlevel;

/**
 * 
 * 裁判等级关联表(YSMS_JUDGEANDLEVEL)数据处理接口
 * 
 * @author panhailin henry_pan@126.com
 * @date 2015年3月12日 下午2:15:14
 *
 */
public interface JudgeAndLevelDao extends GenericDao {
	/**
	 * 
	 * 保存一条裁判员等级
	 * 
	 * @param judge_id
	 *            裁判员ID
	 * @param level_id
	 *            等级ID void
	 *
	 */
	public void saveLevel(YsmsJudgeandlevel ysmsJudgeandlevel);

	/**
	 * 
	 * 删除一条裁判员等级
	 * 
	 * @param judge_id
	 *            裁判员ID void
	 *
	 */
	public void deleteLevel(int judge_id);

	/**
	 * 
	 * 查询裁判员等级
	 * 
	 * @param judge_id
	 *            裁判员ID
	 * @param level_id
	 *            等级ID
	 * @return List<YsmsJudgeandlevel>
	 *
	 */
	public List<Map<String,Object>> query(String judge_id, String level_id);

	/**
	 * 根据judgeid获取等级
	 * @return
	 */
	public List<YsmsJudgeandlevel> getByJudgeId(int judgeId);
}
