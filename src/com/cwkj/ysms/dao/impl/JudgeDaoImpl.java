package com.cwkj.ysms.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.cwkj.ysms.basedao.impl.GenericDaoImpl;
import com.cwkj.ysms.dao.JudgeDao;
import com.cwkj.ysms.model.YsmsJudge;
import com.cwkj.ysms.model.YsmsJudgeAtt;
import com.cwkj.ysms.util.Page;
import com.cwkj.ysms.util.ToolsUtil;

/**
 * 
 * 裁判表(Ysms_Judge)数据处理接口实现类
 * 
 * @author panhailin henry_pan@126.com
 * @date 2015年3月10日 下午1:50:34
 *
 */
@Repository
public class JudgeDaoImpl extends GenericDaoImpl implements JudgeDao {

	@Override
	public Integer save(YsmsJudge ysmsJudge) {
		Integer id=null;
		try {
			id=(Integer) getSession().save(ysmsJudge);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return id;
	}

	@Override
	public void update(String identifiedId, String judgeName,
			String judgeGender, String judgeBirthDate,
			String identifiedAddress, String nationality, String judegeReason,
			String contact, String deleteflag, String judge_id) {
		try {
			StringBuffer sql = new StringBuffer(
					"UPDATE YSMS_JUDGE A SET A.JUDGE_ID=A.JUDGE_ID ");

			if (!ToolsUtil.isEmpty(judgeName)) {
				sql.append(" , A.IDENTIFIED_NAME = '" + judgeName + "' ");
			}
			if (!ToolsUtil.isEmpty(identifiedId)) {
				sql.append(" , A.IDENTIFIED_ID   =  '" + identifiedId + "' ");
			}
			if (!ToolsUtil.isEmpty(judgeGender)) {
				sql.append(" , A.IDENTIFIED_GENDER  =  " + judgeGender + " ");
			}
			if (!ToolsUtil.isEmpty(judgeBirthDate)) {
				sql.append(" , A.IDENTIFIED_BIRTHDAY = '" + judgeBirthDate
						+ "'");
			}
			if (!ToolsUtil.isEmpty(judegeReason)) {
				sql.append(" , A.JUDGE_REASON = '" + judegeReason + "'");
			}
			if (!ToolsUtil.isEmpty(contact)) {
				sql.append(" , A.JUDGE_CONTACT = '" + contact + "'");
			}

			if (!ToolsUtil.isEmpty(deleteflag)) {
				sql.append(" , A.DELETEFLAG = " + deleteflag + "");
			}
			sql.append(" WHERE JUDGE_ID =" + judge_id + " ");
			Query query = getSession().createSQLQuery(sql.toString());
			query.executeUpdate();
		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}

	@Override
	public List<Map<String, Object>> getJudgeListByPage(String identifiedName,
			String gender, String beginTime, String endTime,
			String judgeStatus, int startIndex) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			StringBuffer sql = new StringBuffer(
					"SELECT * FROM YSMS_JUDGE  A  WHERE A.deleteflag=0");
			if (!ToolsUtil.isEmpty(judgeStatus)) {
				sql.append(" AND A.judge_status = '" + judgeStatus + "' ");
			}
			if (!ToolsUtil.isEmpty(identifiedName)) {
				sql.append(" AND A.identified_name = '" + identifiedName + "' ");
			}

			if (!ToolsUtil.isEmpty(gender)) {
				sql.append(" AND A.identified_gender = "
						+ Integer.parseInt(gender) + " ");
			}
			if (!ToolsUtil.isEmpty(beginTime)) {
				sql.append(" AND A.identified_birthday >= '" + beginTime + "' ");
			}
			if (!ToolsUtil.isEmpty(endTime)) {
				sql.append(" AND A.identified_birthday <= '" + endTime + "' ");
			}
			sql.append(" ORDER BY A.judge_id,A.identified_name");
			Query query = getSession().createSQLQuery(sql.toString());
			query.setMaxResults(10);
			query.setFirstResult(startIndex);
			query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			list = query.list();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return list;
	}

	@Override
	public YsmsJudge findById(int judgeId) {
		// TODO Auto-generated method stub
		try {
			YsmsJudge result = (YsmsJudge) getSession().get(
					"com.cwkj.ysms.model.YsmsJudge", judgeId);
			return result;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@Override
	public void updateById(YsmsJudge ysmsJudge) {
		try {
			getSession().update(ysmsJudge);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Map<String, Object>> getJudgeListCount(String identifiedName,
			String gender, String beginTime, String endTime, String judgeStatus) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			StringBuffer sql = new StringBuffer(
					"SELECT COUNT(*) count FROM YSMS_JUDGE  A  WHERE A.deleteflag=0");
			if (!ToolsUtil.isEmpty(judgeStatus)) {
				sql.append(" AND A.judge_status = '" + judgeStatus + "' ");
			}
			if (!ToolsUtil.isEmpty(identifiedName)) {
				sql.append(" AND A.identified_name = '" + identifiedName + "' ");
			}

			if (!ToolsUtil.isEmpty(gender)) {
				sql.append(" AND A.identified_gender = "
						+ Integer.parseInt(gender) + " ");
			}
			if (!ToolsUtil.isEmpty(beginTime)) {
				sql.append(" AND A.identified_birthday >= '" + beginTime + "' ");
			}
			if (!ToolsUtil.isEmpty(endTime)) {
				sql.append(" AND A.identified_birthday <= '" + endTime + "' ");
			}
			sql.append(" ORDER BY A.judge_id,A.identified_name");
			Query query = getSession().createSQLQuery(sql.toString());

			query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			list = query.list();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return list;
	}

	@Override
	public void delete(String judge_id) {
		try {
			getSession().createSQLQuery(
					" UPDATE YSMS_JUDGE A SET A.deleteflag=1 where A.judge_id="
							+ judge_id + "").executeUpdate();
		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}

	@Override
	public List<Map<String, Object>> getJudgeById(int judgeId) {
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		 try {
			Query query= getSession().createSQLQuery(
						" SELECT a.*,b.level_id,c.job_name,d.district_name FROM ysms_judge a LEFT JOIN ysms_judgeandlevel b ON b.judge_id=a.judge_id LEFT JOIN ysms_jobs c ON c.job_id=a.job_id LEFT JOIN ysms_district d ON d.district_id=a.district_id WHERE a.judge_id="+judgeId+"");
			query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			list=query.list();
		} catch (Exception e) {
			// TODO: handle exception
		}
		 return list;
	}

	@Override
	public void saveAtt(YsmsJudgeAtt att) {
		 try{
			 getSession().save(att);
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		
	}

	@Override
	public void isPassed(int judgeId, int judgeStatus) {
		try {
			getSession().createSQLQuery(
					" UPDATE YSMS_JUDGE A SET A.judge_status="+judgeStatus+" where A.judge_id="
							+ judgeId + "").executeUpdate();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
	}

	@Override
	public List<Map<String, Object>> gettAtt(int judgeId, int attType) {
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		 try {
			Query query= getSession().createSQLQuery(
						" select * from ysms_judge_att where judge_id="+judgeId+" and att_type="+attType+"");
			query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			list=query.list();
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return list;
	}

}
