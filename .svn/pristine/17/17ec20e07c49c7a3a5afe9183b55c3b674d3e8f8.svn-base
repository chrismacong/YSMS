package com.cwkj.ysms.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.cwkj.ysms.basedao.impl.GenericDaoImpl;
import com.cwkj.ysms.dao.JudgeAndLevelDao;
import com.cwkj.ysms.model.YsmsJudgeandlevel;
import com.cwkj.ysms.util.ToolsUtil;

/**
 * 
 * 裁判等级关联表(YSMS_JUDGEANDLEVEL)数据处理接口实现类
 * 
 * @author panhailin henry_pan@126.com
 * @date 2015年3月12日 下午2:15:45
 *
 */
@Repository
public class JudgeAndLevelDaoImpl extends GenericDaoImpl implements
		JudgeAndLevelDao {
	@Override
	public void saveLevel(YsmsJudgeandlevel ysmsJudgeandlevel) {
		try {
//			String sql = "INSERT INTO YSMS_JUDGEANDLEVEL(JUDGE_ID,LEVEL_ID) VALUES(?,?)";
//			Query query = getSession().createSQLQuery(sql);
//			query.setParameter(0, judge_id);
//			query.setParameter(1, level_id);
//			query.executeUpdate();
			getSession().save(ysmsJudgeandlevel);
		} catch (Exception exception) {

		}

	}

	@Override
	public void deleteLevel(int judge_id) {
		try {
			String sql = "DELETE FROM YSMS_JUDGEANDLEVEL WHERE JUDGE_ID=?";
			Query query = getSession().createSQLQuery(sql);
			query.setParameter(0, judge_id);
			query.executeUpdate();
		} catch (Exception exception) {

		}

	}

	@Override
	public List<Map<String,Object>> query(String judge_id, String level_id) {
		List<Map<String,Object>> judgeandlevel_List = new ArrayList<Map<String,Object>>();
		try {
			String sql = "SELECT * FROM YSMS_JUDGEANDLEVEL WHERE 1=1";

			if (!ToolsUtil.isEmpty(level_id)) {
				sql += " AND level_id=" + level_id + "";
			}
			if (!ToolsUtil.isEmpty(judge_id)) {
				sql += " AND judge_id=" + judge_id + "";
			}
			Query query = getSession().createSQLQuery(sql);
			query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			judgeandlevel_List = query.list();
		} catch (Exception exception) {

		}
		return judgeandlevel_List;
	}

}
