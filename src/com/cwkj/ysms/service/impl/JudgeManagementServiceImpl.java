package com.cwkj.ysms.service.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cwkj.ysms.dao.DistrictDao;
import com.cwkj.ysms.dao.GamesDao;
import com.cwkj.ysms.dao.GamesJudgeDao;
import com.cwkj.ysms.dao.GroupDao;
import com.cwkj.ysms.dao.JobsDao;
import com.cwkj.ysms.dao.JudgeAndLevelDao;
import com.cwkj.ysms.dao.JudgeDao;
import com.cwkj.ysms.dao.JudgeUserDao;
import com.cwkj.ysms.dao.UserDao;
import com.cwkj.ysms.model.YsmsDistrict;
import com.cwkj.ysms.model.YsmsGames;
import com.cwkj.ysms.model.YsmsGamesJudge;
import com.cwkj.ysms.model.YsmsGroup;
import com.cwkj.ysms.model.YsmsJobs;
import com.cwkj.ysms.model.YsmsJudge;
import com.cwkj.ysms.model.YsmsJudgeAtt;
import com.cwkj.ysms.model.YsmsJudgeUser;
import com.cwkj.ysms.model.YsmsJudgeandlevel;
import com.cwkj.ysms.model.YsmsJudgelevel;
import com.cwkj.ysms.model.YsmsUser;
import com.cwkj.ysms.model.view.JudgeView;
import com.cwkj.ysms.service.JudgeManagementService;
import com.cwkj.ysms.service.UserManagementService;
import com.cwkj.ysms.util.ToolsUtil;

/**
 * 
 * 裁判管理Service实现类
 * 
 * @author panhailin henry_pan@126.com
 * @date 2015年3月10日 下午1:46:06
 *
 */
@Service
public class JudgeManagementServiceImpl implements JudgeManagementService {
	@Autowired
	private JobsDao jobsDao;
	@Autowired
	private DistrictDao districtDao;
	
	@Resource
	private JudgeDao judgeDao;

	public JudgeDao getJudgeDao() {
		return judgeDao;
	}

	public void setJudgeDao(JudgeDao judgeDao) {
		this.judgeDao = judgeDao;
	}

	@Resource
	private JudgeAndLevelDao judgeAndLevelDao;

	public JudgeAndLevelDao getJudgeAndLevelDao() {
		return judgeAndLevelDao;
	}

	public void setJudgeAndLevelDao(JudgeAndLevelDao judgeAndLevelDao) {
		this.judgeAndLevelDao = judgeAndLevelDao;
	}

	@Resource
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Resource
	private UserManagementService userManagementService;

	public UserManagementService getUserManagementService() {
		return userManagementService;
	}

	public void setUserManagementService(
			UserManagementService userManagementService) {
		this.userManagementService = userManagementService;
	}
	
	@Resource
	private JudgeUserDao judgeUserDao;

	public JudgeUserDao getJudgeUserDao() {
		return judgeUserDao;
	}

	public void setJudgeUserDao(JudgeUserDao judgeUserDao) {
		this.judgeUserDao = judgeUserDao;
	}
	
	@Resource
	private GroupDao groupDao;

	public GroupDao getGroupDao() {
		return groupDao;
	}

	public void setGroupDao(GroupDao groupDao) {
		this.groupDao = groupDao;
	}

	@Resource
	private GamesJudgeDao gamesJudgeDao;
	
	public GamesJudgeDao getGamesJudgeDao() {
		return gamesJudgeDao;
	}

	public void setGamesJudgeDao(GamesJudgeDao gamesJudgeDao) {
		this.gamesJudgeDao = gamesJudgeDao;
	}
	
	@Resource
	private GamesDao gamesDao;

	public GamesDao getGamesDao() {
		return gamesDao;
	}

	public void setGamesDao(GamesDao gamesDao) {
		this.gamesDao = gamesDao;
	}

	@Override
	public boolean applyJudge(String identifiedId, String identifiedName,
			int identifiedGender, String identifiedNationality,Date identifiedBirthday,
			String identifiedAddress, int jobId, int districtId,
			String jobAddress, int judgeLevel, int judgeStatus,
			String judgeMobile, String judgeTips,String fileName_id,String fileName_level,
			String username, String password) {
		try {
			YsmsJudge ysmsJudge=new YsmsJudge();
			 
			ysmsJudge.setIdentifiedId(identifiedId);
			ysmsJudge.setIdentifiedName(identifiedName);
			ysmsJudge.setIdentifiedGender(identifiedGender);
			ysmsJudge.setIdentifiedNationality(identifiedNationality);
			ysmsJudge.setIdentifiedAddress(identifiedAddress);
			ysmsJudge.setJudgeJobaddress(jobAddress);
			ysmsJudge.setJudgeMobile(judgeMobile);
			ysmsJudge.setJudgeTips(judgeTips);
			ysmsJudge.setJudgeStatus(judgeStatus);
			ysmsJudge.setJudgeLevel(judgeLevel);
			ysmsJudge.setIdentifiedBirthday(identifiedBirthday);
			ysmsJudge.setDeleteflag(0);
			YsmsDistrict district=new YsmsDistrict();
			district.setDistrictId(districtId);
			ysmsJudge.setYsmsDistrict(district);
			YsmsJobs jobs=new YsmsJobs();
			jobs.setJobId(jobId);
			ysmsJudge.setYsmsJobs(jobs);
			judgeDao.save(ysmsJudge);
			
			YsmsUser ysmsUser = new YsmsUser();
			ysmsUser.setDeleteflag(0);
			ysmsUser.setUserName(username);
			ysmsUser.setUserPassword(password);
			ysmsUser.setYsmsGroup(groupDao.findById(9));//hard code
			userDao.save(ysmsUser);
			
			YsmsJudgeUser ju = new YsmsJudgeUser();
			ju.setYsmsJudge(ysmsJudge);
			ju.setYsmsUser(ysmsUser);
			judgeUserDao.save(ju);
			
			if(!ToolsUtil.isEmpty(fileName_level)){
				YsmsJudgeAtt att=new YsmsJudgeAtt();
				att.setAttName(fileName_level);
				att.setAttType(1);//type=0 身份证 1 等级证
				att.setYsmsJudge(ysmsJudge);
				judgeDao.saveAtt(att);
			}
			if(!ToolsUtil.isEmpty(fileName_id)){
				YsmsJudgeAtt att=new YsmsJudgeAtt();
				att.setAttName(fileName_id);
				att.setAttType(0);//type=0 身份证 1 等级证
				att.setYsmsJudge(ysmsJudge);
				judgeDao.saveAtt(att);
			}

		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<Map<String,Object>> getAllJudges(String identifiedName, String gender,
			String beginTime, String endTime, String judgeStatus,String pageIndex) {
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		try {
			int startIndex = (Integer.parseInt(pageIndex) - 1) * 10;
			list = judgeDao.getJudgeListByPage(identifiedName, gender,
					beginTime, endTime, judgeStatus,startIndex);
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return list;
	}

	@Override
	public List<YsmsJudge> getJudgesByLevel(int judgeLevel) {
		// TODO Auto-generated method stub
		return null;
	}

 
 

	@Override
	public boolean addJudge(String userPassword, String userName,
			String judgeName, String judgeGender, String judgeLevel,
			 String identifiedId, String phonenum) {

		try {
	
			YsmsJudge ysmsJudge = new YsmsJudge();

			ysmsJudge.setDeleteflag(0);
			ysmsJudge.setIdentifiedName(judgeName);
			ysmsJudge.setIdentifiedGender(Integer.parseInt(judgeGender));
			ysmsJudge.setJudgeStatus(2);
			ysmsJudge.setIdentifiedId(identifiedId);
			ysmsJudge.setJudgeMobile(phonenum);
			Set<YsmsJudgeandlevel> ysmsJudgeandlevels = new HashSet<YsmsJudgeandlevel>();
			String[] levels = judgeLevel.split(",");
			for (String level : levels) {
				YsmsJudgeandlevel judgeandlevel = new YsmsJudgeandlevel();
				judgeandlevel.setYsmsJudge(ysmsJudge);
				YsmsJudgelevel judgeLevelTemp = new YsmsJudgelevel();
				judgeLevelTemp.setLevelId(Integer.parseInt(level));
				judgeandlevel.setYsmsJudgelevel(judgeLevelTemp);
				ysmsJudgeandlevels.add(judgeandlevel);
			}
			ysmsJudge.setYsmsJudgeandlevels(ysmsJudgeandlevels);

			YsmsUser ysmsUser = new YsmsUser();
			ysmsUser.setUserName(userName);
			ysmsUser.setUserPassword(userPassword);
			ysmsUser.setDeleteflag(0);			
			//HARD CODE
			YsmsGroup ysmsGroup = groupDao.findById(9);
			ysmsUser.setYsmsGroup(ysmsGroup);
			
			//先保存，进入持久态获取Id
			userDao.save(ysmsUser);
			judgeDao.save(ysmsJudge);
			
			YsmsJudgeUser judgeUser = new YsmsJudgeUser();
			judgeUser.setYsmsJudge(ysmsJudge);
			judgeUser.setYsmsUser(ysmsUser);
			judgeUserDao.save(judgeUser);

		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
		return true;
	}

 
	@Override
	public boolean updateJudge(String judgeId,String jobId,String jobAddress, String districtId,
			String identifiedAddress,   String contact,
			String judgeLevel, String level, String nationality, String birthday, 
			String identifiedId, String gender) {
		try {
			YsmsJudge ysmsJudge = judgeDao.findById(Integer.parseInt(judgeId));
			if (!ToolsUtil.isEmpty(jobId)) {
				YsmsJobs job=new YsmsJobs();
				job.setJobId(Integer.parseInt(jobId));
				ysmsJudge.setYsmsJobs(job);
			}
			if (!ToolsUtil.isEmpty(districtId)) {
				YsmsDistrict district=new YsmsDistrict();
				district.setDistrictId(Integer.parseInt(districtId));
				ysmsJudge.setYsmsDistrict(district); 
			}
			if (!ToolsUtil.isEmpty(identifiedAddress)) {
				ysmsJudge.setIdentifiedAddress(identifiedAddress);
			} 
			if (!ToolsUtil.isEmpty(jobAddress)) {
				ysmsJudge.setJudgeJobaddress(jobAddress);
			} 
			if (!ToolsUtil.isEmpty(contact)) {
				ysmsJudge.setJudgeMobile(contact);
			}
			if(!ToolsUtil.isEmpty(level)){
				ysmsJudge.setJudgeLevel(Integer.parseInt(level));
			}
			if(!ToolsUtil.isEmpty(nationality)){
				ysmsJudge.setIdentifiedNationality(nationality);
			}
			if(!ToolsUtil.isEmpty(birthday)){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				ysmsJudge.setIdentifiedBirthday(sdf.parse(birthday));
			}
			if(!ToolsUtil.isEmpty(identifiedId)){
				ysmsJudge.setIdentifiedId(identifiedId);
			}
			if(!ToolsUtil.isEmpty(gender)){
				ysmsJudge.setIdentifiedGender(Integer.parseInt(gender));
			}
			if (!ToolsUtil.isEmpty(judgeLevel)) {
				judgeAndLevelDao.deleteLevel(Integer.parseInt(judgeId));
				Set<YsmsJudgeandlevel> ysmsJudgeandlevels = new HashSet<YsmsJudgeandlevel>();
				String[] levels = judgeLevel.split(",");
				for (String _level : levels) {
					YsmsJudgeandlevel judgeandlevel = new YsmsJudgeandlevel();
					judgeandlevel.setYsmsJudge(ysmsJudge);
					YsmsJudgelevel judgeLevelTemp = new YsmsJudgelevel();
					judgeLevelTemp.setLevelId(Integer.parseInt(_level));
					judgeandlevel.setYsmsJudgelevel(judgeLevelTemp);
					ysmsJudgeandlevels.add(judgeandlevel);
				}
				ysmsJudge.setYsmsJudgeandlevels(ysmsJudgeandlevels);
				
			}

			judgeDao.updateById(ysmsJudge);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<Map<String,Object>> getJudgeLevelByJudge(String judgeId) {
		
		return judgeAndLevelDao.query(judgeId, null);
	}

	@Override
	public Integer getAllJudgesCount(String identifiedName,
			String gender, String beginTime, String endTime,
			String judgeStatus) {
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		Integer count=0;
		try {
			list = judgeDao.getJudgeListCount(identifiedName, gender, beginTime, endTime, judgeStatus);
			if(!ToolsUtil.isEmpty(list)){
				count=Integer.parseInt(list.get(0).get("count").toString());
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return count;
	}

	@Override
	public boolean deleteJudge(String judge_id) {
		try {
			 for(String judgeId:judge_id.split(",") ){
				 judgeDao.delete(judgeId);
				 List<YsmsJudgeUser> judgeUserList = judgeUserDao.findByJudgeId(Integer.parseInt(judgeId));
				 for(int m=0;m<judgeUserList.size();m++){
					 userDao.delete(judgeUserList.get(m).getYsmsUser().getUserId());
				 }
			 }
			 
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Map<String, Object> getJudgeById(int judgeId) {
		 Map<String, Object> map=new HashMap<String, Object>();
		try{
		List<Map<String,Object>>	list=judgeDao.getJudgeById(judgeId);
		if(!ToolsUtil.isEmpty(list)){
			map.put("judgeId", list.get(0).get("judge_id"));
			map.put("id", list.get(0).get("identified_id"));
			map.put("name", list.get(0).get("identified_name"));
			map.put("gender", list.get(0).get("identified_gender"));
			map.put("nationality", list.get(0).get("identified_nationality"));
			map.put("address", list.get(0).get("identified_address"));
			map.put("birthday", list.get(0).get("identified_birthday"));
			map.put("jobId", list.get(0).get("job_id"));
			map.put("jobName", list.get(0).get("job_name"));
			map.put("districtId", list.get(0).get("district_id"));
			map.put("districtName", list.get(0).get("district_name"));
			map.put("jobAddress", list.get(0).get("judge_jobaddress"));
			map.put("judgeLevel", list.get(0).get("judge_level"));
			map.put("mobile", list.get(0).get("judge_mobile"));
			map.put("tips", list.get(0).get("judge_tips"));
			List<Object> idList=new ArrayList<Object>();
			for(int i=0;i<list.size();i++){
				idList.add(list.get(i).get("level_id"));
			}
			map.put("levels", idList);
		}
		}catch(Exception exception){
			exception.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<String, Object> getJobAndDistrict() {
		 Map<String, Object> map=new HashMap<String, Object>();
		try{
			List<YsmsDistrict> districts=districtDao.findAll();
			List<YsmsJobs> jobs=jobsDao.findAll();
			map.put("district", districts);
			map.put("job", jobs);
		}catch(Exception exception){
			exception.printStackTrace();
		}
		return map;
	}

	@Override
	public boolean isPassed(String judgeId, String judgeStatus) {
		try{
			 judgeDao.isPassed(Integer.parseInt(judgeId), Integer.parseInt(judgeStatus));
		}catch(Exception exception){
			exception.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<Map<String, Object>> getAtt(String forwardDir, String judgeId, String attType) {
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		try{
			list= judgeDao.gettAtt(Integer.parseInt(judgeId), Integer.parseInt(attType));
			 
			if(!ToolsUtil.isEmpty(list)){
				if("0".equals(attType)){
					list.get(0).put("att_name", forwardDir + "upload"+File.separator+"identifiedCard"+File.separator+list.get(0).get("att_name"));	
				}else if("1".equals(attType)){
					list.get(0).put("att_name", forwardDir + "upload"+File.separator+"certificate"+File.separator+list.get(0).get("att_name"));	
				}
			}
		 
		}catch(Exception exception){
			exception.printStackTrace();
			 
		}
		return list;
	}

	@Override
	public List<JudgeView> getAllJudge() {
		List<JudgeView> result = new ArrayList<JudgeView>();
		List<YsmsJudge> allJudges = judgeDao.findAll();
		if(allJudges!=null){
			for(int i=0;i<allJudges.size();i++){
				JudgeView judgeView = new JudgeView();
				YsmsJudge judge = allJudges.get(i);
				int levelsStatus[] = new int[8];
				List<YsmsJudgeandlevel> levelList = judgeAndLevelDao.getByJudgeId(judge.getJudgeId());
				if(levelList!=null){
					for(YsmsJudgeandlevel level : levelList){
						levelsStatus[level.getYsmsJudgelevel().getLevelId()-1] = 1;
					}
				}
				judgeView.setLevels(levelsStatus);
				judgeView.setJudgeId(judge.getJudgeId());
				judgeView.setJudgeName(judge.getIdentifiedName());
				result.add(judgeView);
			}
		}
		return result;
	}

	@Override
	public boolean bindJudgeToGame(int judgeId, int gamesId, int positionIndex) {
		YsmsGamesJudge gamesJudge = gamesJudgeDao.getJudgeByGameAndPosition(gamesId, positionIndex);
		if(gamesJudge!=null){
			gamesJudgeDao.delete(gamesJudge);
		}
		YsmsJudge judge = judgeDao.findById(judgeId);
		YsmsGames game = gamesDao.findById(gamesId);
		YsmsGamesJudge newGamesJudge = new YsmsGamesJudge();
		newGamesJudge.setJudgePosition(positionIndex);
		newGamesJudge.setYsmsGames(game);
		newGamesJudge.setYsmsJudge(judge);
		gamesJudgeDao.save(newGamesJudge);
		return true;
	}

	@Override
	public boolean cancelBindingJudgeToGame(int gamesId, int positionIndex) {
		YsmsGamesJudge gamesJudge = gamesJudgeDao.getJudgeByGameAndPosition(gamesId, positionIndex);
		if(gamesJudge!=null){
			gamesJudgeDao.delete(gamesJudge);
		}
		return true;
	}
}
