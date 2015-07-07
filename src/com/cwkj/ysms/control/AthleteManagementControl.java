package com.cwkj.ysms.control;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jxl.Workbook;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cwkj.ysms.model.YsmsAthlete;
import com.cwkj.ysms.model.YsmsAthleteAtt;
import com.cwkj.ysms.model.YsmsDiploma;
import com.cwkj.ysms.model.YsmsJobs;
import com.cwkj.ysms.model.YsmsSchool;
import com.cwkj.ysms.model.view.AthleteView;
import com.cwkj.ysms.service.AthleteManagementService;
import com.cwkj.ysms.service.SchoolManagementService;
import com.cwkj.ysms.service.UserManagementService;
import com.cwkj.ysms.util.Page;
import com.cwkj.ysms.util.ToolsUtil;

@Controller
@RequestMapping(value = "/athletemanagement")
public class AthleteManagementControl {
	@Resource
	private AthleteManagementService athleteManagementService;

	public AthleteManagementService getAthleteManagementService() {
		return athleteManagementService;
	}

	public void setAthleteManagementService(
			AthleteManagementService athleteManagementService) {
		this.athleteManagementService = athleteManagementService;
	}
	@Resource
	private UserManagementService userManagementService;

	public UserManagementService getUserManagementService() {
		return userManagementService;
	}

	public void setUserManagementService(UserManagementService userManagementService) {
		this.userManagementService = userManagementService;
	}
	@Resource
	private SchoolManagementService schoolManagementService;

	public SchoolManagementService getSchoolManagementService() {
		return schoolManagementService;
	}

	public void setSchoolManagementService(
			SchoolManagementService schoolManagementService) {
		this.schoolManagementService = schoolManagementService;
	}

	/**
	 * 打开管理界面 无参数
	 * 
	 * @param request
	 * @param session
	 * @param response
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listResult(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) {
		return new ModelAndView("AthleteManagementPage");
	}

	@RequestMapping(value = "adminathletemanagement", method = RequestMethod.GET)
	public ModelAndView listMngResult(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) {
		return new ModelAndView("AdminAthleteManagementPage");
	}

	/**
	 * 获取全部运动员信息列表
	 * 
	 * @param request
	 * @param session
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "listathlete", method = RequestMethod.GET)
	public ModelAndView listAthlete(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		if (session.getAttribute("schoolId") == null) {
			List<YsmsSchool> ysmsSchools = schoolManagementService.getSchools(
					null, null);
			modelMap.put("school_list", ysmsSchools);
		}

		List<YsmsJobs> jobsList = athleteManagementService.getAllJobs();
		List<YsmsDiploma> diplomaList = athleteManagementService
				.getAllDiplomas();
		modelMap.put("jobs_list", jobsList);
		modelMap.put("diploma_list", diplomaList);
		return new ModelAndView("AthleteListPage", modelMap);
	}
	
	/**
	 * 获取全部运动员信息列表
	 * 
	 * @param request
	 * @param session
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "listpageathlete", method = RequestMethod.GET)
	public Map<String, Object> listPageAthlete(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) throws Exception {
		String requestJson = request.getParameter("requestJson");
		JSONArray jsonArray = new JSONArray(requestJson);
		String sEcho = null;
		String startIndex = null;// = request.getParameter("startIndex");
		String pageSize = null;// request.getParameter("pageSize");
		String name_filterString = null;
		String sex_filterString = null;
		String school_filterString = null;
		String year_filterString = null;
		Integer iSortCol_0 = null;
		String sSortDir_0 = null;
		String orderString = null;
		for (int i = 0; i < jsonArray.length(); i++) // 从传递参数里面选出待用的参数
		{
			JSONObject obj = (JSONObject) jsonArray.get(i);
			if (obj.get("name").equals("sEcho")) {
				sEcho = obj.get("value").toString();
			}
			if (obj.get("name").equals("iDisplayStart")) {
				startIndex = obj.get("value").toString();
			}
			if (obj.get("name").equals("iDisplayLength")) {
				pageSize = obj.get("value").toString();
			}
			if (obj.get("name").equals("name_filter")) {
				name_filterString = obj.get("value").toString();
				name_filterString = new String(
						name_filterString.getBytes("ISO8859-1"), "UTF-8");
			}
			if (obj.get("name").equals("sex_filter")) {
				sex_filterString = obj.get("value").toString();
			}
			if (obj.get("name").equals("school_filter")) {
				school_filterString = obj.get("value").toString();
			}
			if (obj.get("name").equals("year_filter")) {
				year_filterString = obj.get("value").toString();
			}
			if (obj.get("name").equals("iSortCol_0")) {
				iSortCol_0 = Integer.parseInt(obj.get("value").toString());
			}
			if (obj.get("name").equals("sSortDir_0")) {
				sSortDir_0 = obj.get("value").toString();
			}
		}

		Page page = null;
		if (!ToolsUtil.isEmpty(startIndex) && !ToolsUtil.isEmpty(pageSize)) {
			page = new Page();
			page.setEveryPage(Integer.parseInt(pageSize));
			page.setBeginIndex(Integer.parseInt(startIndex));
		}
		Integer schoolId = null;
		// String identifiedId,
		String identifiedName = null;
		Integer identifiedGender = null;
		Integer athletePosition = null;
		Integer studentId = null;
		String athleteSchoolyear = null;
		if (!ToolsUtil.isEmpty(name_filterString)) {
			identifiedName = name_filterString;
		}
		if (!ToolsUtil.isEmpty(sex_filterString)) {
			identifiedGender = Integer.parseInt(sex_filterString);
		}
		if (!ToolsUtil.isEmpty(school_filterString)) {
			schoolId = Integer.parseInt(school_filterString);
		}
		if (iSortCol_0 != null) {
			orderString = " order by ";
			switch (iSortCol_0) {
			case 0:
				orderString += "model.ysmsSchool.schoolName ";
				break;
			case 1:
				orderString += "model.identifiedName ";
				break;
			case 2:
				orderString += "model.identifiedGender ";
				break;
			case 3:
				orderString += "model.athleteSchoolyear ";
				break;
			case 4:
				orderString += "model.register_id ";
				break;
			case 5:
				orderString += "model.athleteGuardian1 ";
				break;
			case 6:
				orderString += "model.guardian1Mobile ";
				break;
			}

			orderString += sSortDir_0;
		}
		if (session.getAttribute("schoolId") != null) {
			schoolId = Integer.parseInt(session.getAttribute("schoolId")
					.toString());
		}
		List<YsmsAthlete> athletes = athleteManagementService
				.getAtheletesByPageAndOrder(schoolId, null, identifiedName,
						identifiedGender, null, null, year_filterString, page,
						orderString);
		List<AthleteView> athleteViews = new ArrayList<AthleteView>();
		for (YsmsAthlete athlete : athletes) {
			athleteViews.add(new AthleteView(athlete));
		}
		int count = athleteManagementService.findByFuzzyQueryAndPageCount(
				schoolId, null, identifiedName, identifiedGender, null, null,
				year_filterString);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("sEcho", sEcho);
		resultMap.put("iTotalRecords", count);
		resultMap.put("iTotalDisplayRecords", count);
		resultMap.put("athletes", athleteViews);
		return resultMap;
	}

	/**
	 * 根据模糊查询获取运动员信息列表
	 * 
	 * @param request
	 * @param session
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "athletebyfq", method = RequestMethod.GET)
	public Map<String, Object> listResultByFQ(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) {
		return null;

	}

	/**
	 * 根据运动员id，获取单个运动员信息
	 * 
	 * @param request
	 * @param session
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "athletebyid", method = RequestMethod.GET)
	public Map<String, Object> listAthleteById(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) {
		String requestID = request.getParameter("id");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (requestID != null && !requestID.equals("")) {
			YsmsAthlete ysmsAthlete = athleteManagementService
					.getAthleteByID(Integer.parseInt(requestID));
			YsmsAthleteAtt ysmsAthleteAtt = athleteManagementService
					.getAthleteAttByAthleteID(Integer.parseInt(requestID));
			AthleteView athleteView = new AthleteView(ysmsAthlete);
			resultMap.put("returnCode", 200);
			resultMap.put("athlete", athleteView);
			resultMap.put("athleteatt", ysmsAthleteAtt);

		} else {
			resultMap.put("returnCode", 404);
			resultMap.put("returnMessage", "找不到该运动员");
		}
		return resultMap;
	}

	/**
	 * 运动员删除
	 * 
	 * @param request
	 * @param session
	 * @param response
	 * @return
	 */
	@ResponseBody
	@Transactional
	@RequestMapping(value = "deleteathlete", method = RequestMethod.POST)
	public Map<String, Object> deleteAthlete(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) {
		String idsString = request.getParameter("id");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (idsString != null) {
			String[] ids = idsString.split(",");
			boolean result = true;
			for (int i = 0; i < ids.length; i++) {
				result = result
						& athleteManagementService.deleteAthlete(Integer
								.parseInt(ids[i]));
			}
			if (result) {
				resultMap.put("returnCode", 200);
				resultMap.put("returnMessage", "删除成功");
			} else {
				resultMap.put("returnCode", 500);
				resultMap.put("returnMessage", "删除失败");
			}
		} else {
			resultMap.put("returnCode", 300);
			resultMap.put("returnMessage", "未选定删除行");
		}
		return resultMap;
	}

	/**
	 * 运动员信息修改
	 * 
	 * @param request
	 * @param session
	 * @param response
	 * @return
	 */
	@ResponseBody
	@Transactional
	@RequestMapping(value = "modifyathlete", method = RequestMethod.POST)
	public Map<String, Object> modifyAthlete(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String identifiedName = request.getParameter("name");
			int athleteId = Integer.parseInt(request.getParameter("athleteid"));
			int identifiedGender = Integer.parseInt(request
					.getParameter("gender"));
			String identifiedNationality = request.getParameter("nation");
			String birthday = request.getParameter("birthday");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date identifiedBirthday = sdf.parse(birthday);
			String identifiedId = request.getParameter("identity");
			String identifiedAddress = request.getParameter("address");
			String studentId = request.getParameter("studentid").toString();
			int gradeIndex = Integer.parseInt(request
					.getParameter("grade_index"));
			String athleteSchoolyear;
			Calendar calendar = Calendar.getInstance();
			if (calendar.get(Calendar.MONTH) + 1 < 9) {// 九月份之前注册的球员，说明还未升级
				athleteSchoolyear = (calendar.get(Calendar.YEAR) - gradeIndex)
						+ "";
			} else {// 九月份之后注册的球员，需要少减一年
				athleteSchoolyear = (calendar.get(Calendar.YEAR) - gradeIndex)
						+ 1 + "";
			}
			String athletePhone = request.getParameter("phonenum");
			int athletePosition = Integer.parseInt(request
					.getParameter("position_index"));
			int athleteFootsize = Integer.parseInt(request
					.getParameter("shoesize_index"));
			String heightStr = request.getParameter("height").toString();
			int athleteHeight = 0;
			if (!heightStr.equals(""))
				athleteHeight = Integer.parseInt(heightStr);
			String weightStr = request.getParameter("weight").toString();
			int athleteWeight = 0;
			if (!weightStr.equals(""))
				athleteWeight = Integer.parseInt(weightStr);
			String athleteGuardian1name = request
					.getParameter("guardian1_name");
			int athleteGuardian1DiplomaId = Integer.parseInt(request
					.getParameter("guardian1_diploma"));
			int athleteGuardian1JobId = Integer.parseInt(request
					.getParameter("guardian1_job"));
			String athleteGuardian1mobi = request
					.getParameter("guardian1_phone");
			String athleteGuardian2name = request
					.getParameter("guardian2_name");
			int athleteGuardian2DiplomaId = Integer.parseInt(request
					.getParameter("guardian2_diploma"));
			int athleteGuardian2JobId = Integer.parseInt(request
					.getParameter("guardian2_job"));
			String athleteGuardian2mobi = request
					.getParameter("guardian2_phone");
			String coachName = request.getParameter("coach_name");
			String photoBase64 = request.getParameter("image");
			boolean result = athleteManagementService.updateAthlete(athleteId,
					athleteGuardian1name, athleteGuardian2name,
					athleteGuardian1mobi, athleteGuardian2mobi,
					athleteGuardian1DiplomaId, athleteGuardian2DiplomaId,
					athleteGuardian1JobId, athleteGuardian2JobId, identifiedId,
					identifiedName, identifiedGender, identifiedBirthday,
					identifiedAddress, identifiedNationality, athleteFootsize,
					athleteHeight, athleteWeight, athletePosition, studentId,
					athleteSchoolyear, athletePhone, photoBase64, coachName);
			if (result)
				map.put("success", true);
			else
				map.put("success", false);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("success", false);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("success", false);
		}
		return map;
	}

	/**
	 * 进入运动员注册页
	 * 
	 * @param request
	 * @param session
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "registerathlete", method = RequestMethod.GET)
	public ModelAndView registerAthlete(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) {
		Map<String, Object> model = new HashMap<String, Object>();
		List<YsmsJobs> jobsList = athleteManagementService.getAllJobs();
		List<YsmsDiploma> diplomaList = athleteManagementService
				.getAllDiplomas();
		model.put("jobs_list", jobsList);
		model.put("diploma_list", diplomaList);
		return new ModelAndView("AthleteRegisterPage", model);
	}
	/**
	 * 管理员进入运动员注册页
	 * 
	 * @param request
	 * @param session
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "adminregisterathlete", method = RequestMethod.GET)
	public ModelAndView adminRegisterAthlete(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) {
		Map<String, Object> model = new HashMap<String, Object>();
		List<YsmsJobs> jobsList = athleteManagementService.getAllJobs();
		List<YsmsDiploma> diplomaList = athleteManagementService
				.getAllDiplomas();
		model.put("jobs_list", jobsList);
		model.put("diploma_list", diplomaList);
		return new ModelAndView("AdminAthleteRegisterPage", model);
	}
	
	@ResponseBody
	@RequestMapping(value = "getschoolid", method = RequestMethod.POST)
	public Map<String, Object> getSchoolId(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String schoolUsername = request.getParameter("schoolusername");
		int schoolId = userManagementService.checkSchoolUsername(schoolUsername);
		map.put("schoolid", schoolId);
		return map;
	}

	/**
	 * 运动员注册
	 * 
	 * @param request
	 * @param session
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "addathlete", method = RequestMethod.POST)
	public Map<String, Object> addAthlete(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Object schoolIdInSession = session.getAttribute("schoolId");
			if (schoolIdInSession == null) {
				map.put("success", false);
				map.put("message", "网络会话失效，请重新登录！");
				return map;
			}
			int schoolId = Integer.parseInt(schoolIdInSession.toString());
			String identifiedName = request.getParameter("name");
			int identifiedGender = Integer.parseInt(request
					.getParameter("gender"));
			String identifiedNationality = request.getParameter("nation");
			String birthday = request.getParameter("birthday");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
			Date identifiedBirthday = sdf.parse(birthday);
			String identifiedId = request.getParameter("identity");
			String identifiedAddress = request.getParameter("address");
			String studentId = request.getParameter("studentid").toString();
			boolean isAddingPermitted = athleteManagementService
					.isAddingAthletePermitted(identifiedId);
			if (!isAddingPermitted) {
				map.put("success", false);
				map.put("message", "注册失败，该运动员已注册！");
			} else {
				int gradeIndex = Integer.parseInt(request
						.getParameter("grade_index"));
				String athleteSchoolyear;
				Calendar calendar = Calendar.getInstance();
				if (calendar.get(Calendar.MONTH) + 1 < 9) {// 九月份之前注册的球员，说明还未升级
					athleteSchoolyear = (calendar.get(Calendar.YEAR) - gradeIndex)
							+ "";
				} else {// 九月份之后注册的球员，需要少减一年
					athleteSchoolyear = (calendar.get(Calendar.YEAR) - gradeIndex)
							+ 1 + "";
				}
				String athletePhone = request.getParameter("phonenum");
				int athletePosition = Integer.parseInt(request
						.getParameter("position_index"));
				int athleteFootsize = Integer.parseInt(request
						.getParameter("shoesize_index"));
				String heightStr = request.getParameter("height").toString();
				int athleteHeight = 0;
				if (!heightStr.equals(""))
					athleteHeight = Integer.parseInt(heightStr);
				String weightStr = request.getParameter("weight").toString();
				int athleteWeight = 0;
				if (!weightStr.equals(""))
					athleteWeight = Integer.parseInt(weightStr);
				String athleteGuardian1name = request
						.getParameter("guardian1_name");
				int athleteGuardian1DiplomaId = Integer.parseInt(request
						.getParameter("guardian1_diploma"));
				int athleteGuardian1JobId = Integer.parseInt(request
						.getParameter("guardian1_job"));
				String athleteGuardian1mobi = request
						.getParameter("guardian1_phone");
				String athleteGuardian2name = request
						.getParameter("guardian2_name");
				int athleteGuardian2DiplomaId = Integer.parseInt(request
						.getParameter("guardian2_diploma"));
				int athleteGuardian2JobId = Integer.parseInt(request
						.getParameter("guardian2_job"));
				String athleteGuardian2mobi = request
						.getParameter("guardian2_phone");
				String coachName = request.getParameter("coach_name");
				String photoBase64 = request.getParameter("image");
				boolean result = athleteManagementService
						.addAthlete(schoolId, athleteGuardian1name,
								athleteGuardian2name, athleteGuardian1mobi,
								athleteGuardian2mobi,
								athleteGuardian1DiplomaId,
								athleteGuardian2DiplomaId,
								athleteGuardian1JobId, athleteGuardian2JobId,
								identifiedId, identifiedName, identifiedGender,
								identifiedBirthday, identifiedAddress,
								identifiedNationality, athleteFootsize,
								athleteHeight, athleteWeight, athletePosition,
								studentId, athleteSchoolyear, athletePhone,
								photoBase64, coachName);
				if (result)
					map.put("success", true);
				else {
					map.put("success", false);
					map.put("message", "添加运动员失败！");
				}
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("success", false);
			map.put("message", "添加运动员失败！");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("success", false);
			map.put("message", "添加运动员失败！");
		}
		return map;
	}
	/**
	 * 管理员运动员注册
	 * 
	 * @param request
	 * @param session
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "adminaddathlete", method = RequestMethod.POST)
	public Map<String, Object> adminAddAthlete(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			int schoolId = Integer.parseInt(request.getParameter("schoolid"));
			String identifiedName = request.getParameter("name");
			int identifiedGender = Integer.parseInt(request
					.getParameter("gender"));
			String identifiedNationality = request.getParameter("nation");
			String birthday = request.getParameter("birthday");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
			Date identifiedBirthday = sdf.parse(birthday);
			String identifiedId = request.getParameter("identity");
			String identifiedAddress = request.getParameter("address");
			String studentId = request.getParameter("studentid").toString();
			boolean isAddingPermitted = athleteManagementService
					.isAddingAthletePermitted(identifiedId);
			if (!isAddingPermitted) {
				map.put("success", false);
				map.put("message", "注册失败，该运动员已注册！");
			} else {
				int gradeIndex = Integer.parseInt(request
						.getParameter("grade_index"));
				String athleteSchoolyear;
				Calendar calendar = Calendar.getInstance();
				if (calendar.get(Calendar.MONTH) + 1 < 9) {// 九月份之前注册的球员，说明还未升级
					athleteSchoolyear = (calendar.get(Calendar.YEAR) - gradeIndex)
							+ "";
				} else {// 九月份之后注册的球员，需要少减一年
					athleteSchoolyear = (calendar.get(Calendar.YEAR) - gradeIndex)
							+ 1 + "";
				}
				String athletePhone = request.getParameter("phonenum");
				int athletePosition = Integer.parseInt(request
						.getParameter("position_index"));
				int athleteFootsize = Integer.parseInt(request
						.getParameter("shoesize_index"));
				String heightStr = request.getParameter("height").toString();
				int athleteHeight = 0;
				if (!heightStr.equals(""))
					athleteHeight = Integer.parseInt(heightStr);
				String weightStr = request.getParameter("weight").toString();
				int athleteWeight = 0;
				if (!weightStr.equals(""))
					athleteWeight = Integer.parseInt(weightStr);
				String athleteGuardian1name = request
						.getParameter("guardian1_name");
				int athleteGuardian1DiplomaId = Integer.parseInt(request
						.getParameter("guardian1_diploma"));
				int athleteGuardian1JobId = Integer.parseInt(request
						.getParameter("guardian1_job"));
				String athleteGuardian1mobi = request
						.getParameter("guardian1_phone");
				String athleteGuardian2name = request
						.getParameter("guardian2_name");
				int athleteGuardian2DiplomaId = Integer.parseInt(request
						.getParameter("guardian2_diploma"));
				int athleteGuardian2JobId = Integer.parseInt(request
						.getParameter("guardian2_job"));
				String athleteGuardian2mobi = request
						.getParameter("guardian2_phone");
				String coachName = request.getParameter("coach_name");
				String photoBase64 = request.getParameter("image");
				System.out.println("schoolid:" + schoolId);
				boolean result = athleteManagementService
						.addAthlete(schoolId, athleteGuardian1name,
								athleteGuardian2name, athleteGuardian1mobi,
								athleteGuardian2mobi,
								athleteGuardian1DiplomaId,
								athleteGuardian2DiplomaId,
								athleteGuardian1JobId, athleteGuardian2JobId,
								identifiedId, identifiedName, identifiedGender,
								identifiedBirthday, identifiedAddress,
								identifiedNationality, athleteFootsize,
								athleteHeight, athleteWeight, athletePosition,
								studentId, athleteSchoolyear, athletePhone,
								photoBase64, coachName);
				if (result)
					map.put("success", true);
				else {
					map.put("success", false);
					map.put("message", "添加运动员失败！");
				}
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("success", false);
			map.put("message", "添加运动员失败！");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("success", false);
			map.put("message", "添加运动员失败！");
		}
		return map;
	}

	/**
	 * 获取excel文件
	 * 
	 * @param request
	 * @param session
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "exportexcel", method = RequestMethod.POST)
	public void exportExcel(HttpServletRequest request, HttpSession session,
			HttpServletResponse response) {
		try {

			String name_filterString = request.getParameter("name_filter");
			String sex_filterString = request.getParameter("sex_filter");
			String school_filterString = request.getParameter("school_filter");
			String year_filterString = request.getParameter("year_filter");

			Integer schoolId = null;

			String identifiedName = null;
			if (!ToolsUtil.isEmpty(name_filterString)) {
				identifiedName = name_filterString;
			}
			Integer identifiedGender = null;
			if (!ToolsUtil.isEmpty(sex_filterString)
					&& !sex_filterString.equals("-1")) {
				identifiedGender = Integer.parseInt(sex_filterString);
			}
			if (!ToolsUtil.isEmpty(school_filterString)) {
				schoolId = Integer.parseInt(school_filterString);
			}
			
			String year_filter=null;
			if (!ToolsUtil.isEmpty(year_filterString)&&!"-1".equals(year_filterString)) {
				year_filter =year_filterString;
			}
			if (session.getAttribute("schoolId") != null) {
				schoolId = Integer.parseInt(session.getAttribute("schoolId")
						.toString());
			}
			if(schoolId == -1)
				schoolId = null;
			List<YsmsAthlete> athletes = athleteManagementService
					.getAtheletesByPageAndOrder(schoolId, null, identifiedName,
							identifiedGender, null, null, year_filter,
							null, null);
			List<AthleteView> athleteViews = new ArrayList<AthleteView>();
			for (YsmsAthlete athlete : athletes) {
				athleteViews.add(new AthleteView(athlete));
			}

			response.reset();
			String fileName = "运动员.xls";
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Cache-Control", "no-cache");
			String userAgent = request.getHeader("User-Agent");
			if (userAgent.contains("Firefox")) {// 专修火狐编码
				response.setHeader("Content-Disposition",
						"attachment;filename="
								+ new String(fileName.getBytes(), "ISO-8859-1"));// 指定下载的文件名
				response.setCharacterEncoding("UTF-8");
			} else {// IE ,google
				response.setHeader(
						"Content-Disposition",
						"attachment;filename="
								+ java.net.URLEncoder.encode(fileName, "UTF-8"));
			}
			response.setDateHeader("Expires", 0);

			WritableWorkbook wwb = Workbook.createWorkbook(response
					.getOutputStream());
			// 创建工作表
			WritableSheet sheet = wwb.createSheet("运动员列表", 0);
			sheet.setColumnView(0, 10);
			sheet.setColumnView(1, 10);
			sheet.setColumnView(2, 10);
			sheet.setColumnView(3, 10);
			sheet.setColumnView(4, 5);
			sheet.setColumnView(5, 25);
			sheet.setColumnView(6, 15);
			sheet.setColumnView(7, 25);
			sheet.setColumnView(8, 20);
			sheet.setColumnView(9, 30);
			sheet.setColumnView(16, 30);
			sheet.setColumnView(18, 30);
			sheet.setColumnView(20, 30);
			sheet.setColumnView(22, 30);
			// 定义格式 字体 下划线 斜体 粗体 颜色
			WritableFont fontStyle1 = new WritableFont(WritableFont.TIMES, 15,
					WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE,
					jxl.format.Colour.BLACK);
			WritableFont fontStyle2 = new WritableFont(WritableFont.TIMES, 13,
					WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE,
					jxl.format.Colour.BLACK);
			WritableFont fontStyle3 = new WritableFont(WritableFont.ARIAL, 11,
					WritableFont.BOLD);
			WritableCellFormat formatCell = new WritableCellFormat(fontStyle1);
			WritableCellFormat formatCell2 = new WritableCellFormat(fontStyle2);
			WritableCellFormat formatCell3 = new WritableCellFormat(fontStyle3);
			WritableCellFormat formatCell4 = new WritableCellFormat(fontStyle3);
			WritableCellFormat formatCell5 = new WritableCellFormat(fontStyle3);
			formatCell.setAlignment(jxl.format.Alignment.CENTRE);
			formatCell2.setAlignment(jxl.format.Alignment.CENTRE);
			formatCell3.setAlignment(jxl.format.Alignment.CENTRE);

			sheet.addCell(new Label(0, 0, "编号", formatCell5));
			sheet.addCell(new Label(1, 0, "学校", formatCell5));
			sheet.addCell(new Label(2, 0, "年级", formatCell5));
			sheet.addCell(new Label(3, 0, "姓名", formatCell5));
			sheet.addCell(new Label(4, 0, "性别", formatCell5));
			sheet.addCell(new Label(5, 0, "身份证", formatCell5));
			sheet.addCell(new Label(6, 0, "生日", formatCell5));
			sheet.addCell(new Label(7, 0, "注册证号", formatCell5));
			sheet.addCell(new Label(8, 0, "联系电话", formatCell5));
			sheet.addCell(new Label(9, 0, "户籍地址", formatCell5));
			sheet.addCell(new Label(10, 0, "民族", formatCell5));
			sheet.addCell(new Label(11, 0, "身高", formatCell5));
			sheet.addCell(new Label(12, 0, "体重", formatCell5));
			sheet.addCell(new Label(13, 0, "位置", formatCell5));
			sheet.addCell(new Label(14, 0, "鞋码", formatCell5));
			sheet.addCell(new Label(15, 0, "监护人1", formatCell5));
			sheet.addCell(new Label(16, 0, "联系方式", formatCell5));
			sheet.addCell(new Label(17, 0, "学历", formatCell5));
			sheet.addCell(new Label(18, 0, "职业", formatCell5));
			sheet.addCell(new Label(19, 0, "监护人2", formatCell5));
			sheet.addCell(new Label(20, 0, "联系方式", formatCell5));
			sheet.addCell(new Label(21, 0, "学历", formatCell5));
			sheet.addCell(new Label(22, 0, "职业", formatCell5));
			sheet.addCell(new Label(23, 0, "学籍号", formatCell5));
			sheet.addCell(new Label(24, 0, "教练", formatCell5));

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
					"yyyy-MM-dd");
			Calendar calendar = Calendar.getInstance();
			for (int i = 1; i < athleteViews.size() + 1; i++) {
				AthleteView athleteView = athleteViews.get(i - 1);
				sheet.addCell(new Label(0, i, athleteView.getAthleteId() + ""));
				sheet.addCell(new Label(1, i, athleteView.getSchoolName()));
				sheet.addCell(new Label(2, i, getSchoolYear(calendar
						.get(Calendar.YEAR)
						- Integer.parseInt(athleteView.getAthleteSchoolyear())
						+ calendar.get(Calendar.MONTH) > 8 ? 1 : 0)));
				sheet.addCell(new Label(3, i, athleteView.getIdentifiedName()));
				sheet.addCell(new Label(4, i,
						athleteView.getIdentifiedGender() == 0 ? "女" : "男"));
				sheet.addCell(new Label(5, i, athleteView.getIdentifiedId()));
				sheet.addCell(new Label(6, i, simpleDateFormat
						.format(athleteView.getIdentifiedBirthday())));
				sheet.addCell(new Label(7, i, athleteView.getRegister_id()));
				sheet.addCell(new Label(8, i, athleteView.getAthleteMobile()));
				sheet.addCell(new Label(9, i, athleteView
						.getIdentifiedAddress()));
				sheet.addCell(new Label(10, i, athleteView
						.getIdentifiedNationality()));
				sheet.addCell(new Label(11, i, athleteView.getAthleteHeight()
						+ "cm"));
				sheet.addCell(new Label(12, i, athleteView.getAthleteWeight()
						+ "kg"));
				sheet.addCell(new Label(13, i, getPosition(athleteView
						.getAthletePosition() - 1)));
				sheet.addCell(new Label(14, i, athleteView.getAthleteFootsize()
						+ ""));
				sheet.addCell(new Label(15, i, athleteView
						.getAthleteGuardian1()));
				sheet.addCell(new Label(16, i, athleteView.getGuardian1Mobile()));
				sheet.addCell(new Label(17, i, athleteView
						.getYsmsDiplomaByGrardian1DiplomaidName()));
				sheet.addCell(new Label(18, i, athleteView
						.getYsmsJobsByGuardian1JobString()));
				sheet.addCell(new Label(19, i, athleteView
						.getAthleteGuardian2()));
				sheet.addCell(new Label(20, i, athleteView.getGuardian2Mobile()));
				sheet.addCell(new Label(21, i, athleteView
						.getYsmsDiplomaByGrardian2DiplomaidName()));
				sheet.addCell(new Label(22, i, athleteView
						.getYsmsJobsByGuardian2JobString()));
				sheet.addCell(new Label(23, i, athleteView.getStudentId()));
				sheet.addCell(new Label(24, i, athleteView.getAthleteCoach()));
			}
			// 写进文档
			wwb.write();
			// // 关闭Excel工作簿对象
			wwb.close();
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String getSchoolYear(int year) {
		switch (year) {
		case 0:
			return "一年级";
		case 1:
			return "二年级";
		case 2:
			return "三年级";
		case 3:
			return "四年级";
		case 4:
			return "五年级";
		case 5:
			return "六年级";
		case 6:
			return "七年级";
		case 7:
			return "八年级";
		case 8:
			return "九年级";
		case 9:
			return "高一";
		case 10:
			return "高二";
		case 11:
			return "高三";
		default:
			return "已毕业";
		}
	}

	private String getPosition(int position) {
		switch (position) {
		case 0:
			return "未选择";
		case 1:
			return "门将";
		case 2:
			return "后卫";
		case 3:
			return "中锋";
		case 4:
			return "前锋";
		default:
			return "";
		}
	}
}
