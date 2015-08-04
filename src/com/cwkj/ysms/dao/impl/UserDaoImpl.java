package com.cwkj.ysms.dao.impl;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.cwkj.ysms.basedao.impl.GenericDaoImpl;
import com.cwkj.ysms.dao.UserDao;
import com.cwkj.ysms.model.YsmsUser;
import com.cwkj.ysms.model.YsmsWechataccount;
import com.cwkj.ysms.util.ToolsUtil;

/**
 * 
 * 用户表(YSMS_USER)数据处理接口实现类
 * 
 * @author panhailin henry_pan@126.com
 * @date 2015年3月09日 下午1:50:42
 *
 */
@Repository
public class UserDaoImpl extends GenericDaoImpl implements UserDao {
	private static final Log log = LogFactory.getLog(YsmsUser.class);

	@Override
	public void save(YsmsUser ysmsUser) {
		log.debug("Saving YsmsUser instance...");

		try {

			getSession().saveOrUpdate(ysmsUser);

			log.debug("Save Successful!");
		} catch (Exception exception) {

			exception.printStackTrace();
			log.debug("Save Failed!");
		}

	}

	@Override
	public List<Map<String, Object>> findUser(String groupId, String userEmail,
			String userName, String userPassword, String deleteFlag,
			int startIndex) {
		List<Map<String, Object>> ysmsUser_List = new ArrayList<Map<String, Object>>();
		try {
			StringBuffer sql = new StringBuffer(
					"SELECT A.user_id,A.group_id,A.user_email,A.user_name,A.deleteflag,B.group_name,B.group_desc  FROM YSMS_USER  A LEFT JOIN YSMS_GROUP B ON B.group_id=A.group_id  WHERE 1=1");
			if (!ToolsUtil.isEmpty(groupId)) {
				sql.append(" AND A.group_id = " + groupId + "");
			}
			if (!ToolsUtil.isEmpty(userEmail)) {
				sql.append(" AND A.user_email LIKE '%" + userEmail + "%'");
			}
			if (!ToolsUtil.isEmpty(userName)) {
				sql.append(" AND A.user_name  LIKE '%" + userName + "%'");
			}
			if (!ToolsUtil.isEmpty(userPassword)) {
				sql.append(" AND A.user_password  LIKE '%" + userPassword
						+ "%'");
			}
			if (!ToolsUtil.isEmpty(deleteFlag)) {
				sql.append(" AND A.deleteflag = " + deleteFlag + "");
			}  
			sql.append(" ORDER BY A.group_id");
			Query query = getSession().createSQLQuery(sql.toString());
			query.setMaxResults(10);
			query.setFirstResult(startIndex);
			query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			ysmsUser_List = query.list();

		} catch (Exception exception) {
			exception.printStackTrace();
			return ysmsUser_List;
		}
		return ysmsUser_List;
	}

	@Override
	public void delete(int userId) {
		try {
			Query query = getSession().createQuery(
					"update from YsmsUser set deleteflag=1 where userId=?");
			query.setParameter(0, userId);
			query.executeUpdate();
		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}

	@Override
	public void update(YsmsUser ysmsUser) {
		try {
			getSession().update(ysmsUser);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	@Override
	public List<Map<String, Object>> findUserByID(int userId) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			Query query = getSession().createSQLQuery(
					"SELECT * FROM YSMS_USER a WHERE a.USER_ID = ?");
			query.setParameter(0, userId);
			query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			list = query.list();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Map<String, Object>> findUserByNameAndPwd(String userName,
			String passWord) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			Query query = getSession()
					.createSQLQuery(
							" SELECT A.*,B.function_id,C.school_id  FROM YSMS_USER A LEFT JOIN YSMS_GROUP_FUNCTION B ON B.group_id=A.group_id LEFT JOIN YSMS_SCHOOLUSER E ON E.user_id=A.user_id LEFT JOIN YSMS_SCHOOL C ON C.school_id=E.school_id   WHERE  A.user_name=? AND A.user_password=? AND A.deleteflag=0");
			query.setParameter(0, userName);
			query.setParameter(1, passWord);
			query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			list = query.list();

		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Map<String, Object>> getGroups(String args) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			StringBuffer sql=new StringBuffer();
			sql.append("SELECT * FROM YSMS_GROUP ");
			if(!ToolsUtil.isEmpty(args)){
				 
				sql.append(" WHERE group_id  in ("+args+")");
			}
			sql.append(" ORDER BY GROUP_NAME");
			Query query = getSession().createSQLQuery(
					sql.toString());

			query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			list = query.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Map<String, Object>> findUserCount(String groupId,
			String userEmail, String userName, String userPassword,
			String deleteFlag) {
		List<Map<String, Object>> ysmsUser_List = new ArrayList<Map<String, Object>>();
		try {
			StringBuffer sql = new StringBuffer(
					"SELECT count(*) AS COUNT  FROM YSMS_USER  A LEFT JOIN YSMS_GROUP B ON B.group_id=A.group_id  WHERE 1=1");
			if (!ToolsUtil.isEmpty(groupId)) {
				sql.append(" AND A.group_id = " + groupId + "");
			}
			if (!ToolsUtil.isEmpty(userEmail)) {
				sql.append(" AND A.user_email LIKE '%" + userEmail + "%'");
			}
			if (!ToolsUtil.isEmpty(userName)) {
				sql.append(" AND A.user_name  LIKE '%" + userName + "%'");
			}
			if (!ToolsUtil.isEmpty(userPassword)) {
				sql.append(" AND A.user_password  LIKE '%" + userPassword
						+ "%'");
			}
			if (!ToolsUtil.isEmpty(deleteFlag)) {
				sql.append(" AND A.deleteflag = " + deleteFlag + "");
			} else {
				sql.append(" AND A.deleteflag = 0");
			}
			sql.append(" ORDER BY A.group_id");
			Query query = getSession().createSQLQuery(sql.toString());

			query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			ysmsUser_List = query.list();

		} catch (Exception exception) {
			exception.printStackTrace();
			return ysmsUser_List;
		}
		return ysmsUser_List;
	}

	@Override
	public YsmsUser getUserByUsername(String username) {
		// TODO Auto-generated method stub
		log.debug("finding YsmsUser instance by username");
		String sql = " from YsmsUser where userName = '"+username + "' and deleteflag = 0";
		List<Object> objects= findByHQL(sql);
		List<YsmsUser> results = new ArrayList<YsmsUser>();
		if(objects==null)
			return null;
		else if(objects.size()==0)
			return null;
		else
			return (YsmsUser) objects.get(0);
	}

	@Override
	public YsmsUser findById(int userId) {
		log.debug("getting YsmsUser instance with userId: " + userId);
		try {
			YsmsUser result = (YsmsUser) getSession().get(
					"com.cwkj.ysms.model.YsmsUser", userId);
			return result;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public List<YsmsUser> findByGroupId(int groupId) {
		log.debug("finding YsmsUser instance by groupId");
		String sql = " from YsmsUser where group_id = '"+groupId + "' and deleteflag = 0";
		List<Object> objects= findByHQL(sql);
		List<YsmsUser> results = new ArrayList<YsmsUser>();
		for(int i=0;i<objects.size();i++){
			results.add((YsmsUser)objects.get(i));
		}
		if(objects==null)
			return null;
		else if(objects.size()==0)
			return null;
		else
			return results;
	}
	
	
}
