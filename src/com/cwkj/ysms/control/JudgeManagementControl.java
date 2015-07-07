package com.cwkj.ysms.control;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.cwkj.ysms.service.JudgeManagementService;
import com.cwkj.ysms.service.UserManagementService;
import com.cwkj.ysms.util.IDCard;
import com.cwkj.ysms.util.Page;
import com.cwkj.ysms.util.PageUtil;
import com.cwkj.ysms.util.ToolsUtil;

/**
 * 
 * 裁判管理控制器
 * 
 * @author panhailin henry_pan@126.com
 * @date 2015年3月11日 上午9:53:40
 *
 */
@Controller
@RequestMapping(value = "/judgemanagement")
public class JudgeManagementControl {
	@Resource
	private JudgeManagementService judgeManagementService;
	@Resource
	private UserManagementService userManagementService;

	public UserManagementService getUserManagementService() {
		return userManagementService;
	}

	public void setUserManagementService(
			UserManagementService userManagementService) {
		this.userManagementService = userManagementService;
	}

	public JudgeManagementService getJudgeManagementService() {
		return judgeManagementService;
	}

	public void setJudgeManagementService(
			JudgeManagementService judgeManagementService) {
		this.judgeManagementService = judgeManagementService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listResult(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) {
		return new ModelAndView("JudgeManagementPage");
	}

	/**
	 * 
	 * 裁判申请
	 * 
	 * @param request
	 * @param session
	 * @return String
	 *
	 */

	@RequestMapping(value = "/judegapply", method = RequestMethod.POST)
	@Transactional
	public String judgeApply(HttpServletRequest request, HttpSession session,
			HttpServletResponse response) {
		JSONObject map = new JSONObject();
		map.put("returnCode", 500);
		map.put("returnMessage", "服务器出错啦！");
		try {

			response.setContentType("text/html");

			MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
			// 身份证id
			String identifiedId = multipartHttpServletRequest
					.getParameter("identifiedId");
			// 姓名
			String identifiedName = multipartHttpServletRequest
					.getParameter("identifiedName");
			// 性别
			String identifiedGender = multipartHttpServletRequest
					.getParameter("identifiedGender");
			// 居住地
			String identifiedAddress = multipartHttpServletRequest
					.getParameter("identifiedAddress");
			// 民族
			String identifiedNationality = multipartHttpServletRequest
					.getParameter("identifiedNationality");
			// 手机号码
			String judgeMobile = multipartHttpServletRequest
					.getParameter("judgeMobile");
			// 职业
			String jobId = multipartHttpServletRequest.getParameter("jobId");
			// 工作所在区
			String districtId = multipartHttpServletRequest
					.getParameter("districtId");
			// 工作详细地址
			String jobAddress = multipartHttpServletRequest
					.getParameter("jobAddress");
			// 裁判等级证书
			String judgeLevel = multipartHttpServletRequest
					.getParameter("judgeLevel");
			// 自我介绍
			String judgeTips = multipartHttpServletRequest
					.getParameter("judgeTips");
			// 身份证附件
			MultipartFile idFile = multipartHttpServletRequest
					.getFile("att_id");
			// 等级证书附件
			MultipartFile levelFile = multipartHttpServletRequest
					.getFile("att_level");
			String levelDir = request.getSession().getServletContext()
					.getRealPath("../") + File.separator +"YSMSRepo" + File.separator + "upload" + File.separator + "certificate";
			String idDir = request.getSession().getServletContext()
					.getRealPath("../") + File.separator +"YSMSRepo" + File.separator + "upload" + File.separator + "identifiedCard";
			File file_id = null;
			File file_level = null;
			String fileName_id = null;
			String fileName_level = null;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String identifiedBirthday = "";
			map.put("returnCode", "300");

			if (ToolsUtil.isEmpty(identifiedName)) {
				map.put("returnMessage", "姓名不能为空!");

				response.getWriter().write(map.toString());
				return null;
			}
			if (ToolsUtil.isEmpty(identifiedGender)) {
				map.put("returnMessage", "性别不能为空!");

				response.getWriter().write(map.toString());
				return null;
			}

			if (ToolsUtil.isEmpty(identifiedId)) {
				map.put("returnMessage", "身份证ID不能为空");

				response.getWriter().write(map.toString());
				return null;
			}
			String result = IDCard.IDCardValidate(identifiedId);
			if (result != "") {
				map.put("returnMessage", result);

				response.getWriter().write(map.toString());
				return null;
			}
			String strYear = identifiedId.substring(6, 10);// 年份
			String strMonth = identifiedId.substring(10, 12);// 月份
			String strDay = identifiedId.substring(12, 14);// 月份
			identifiedBirthday = strYear + "-" + strMonth + "-" + strDay;

			if (ToolsUtil.isEmpty(identifiedNationality)) {
				map.put("returnMessage", "民族不能为空!");

				response.getWriter().write(map.toString());
				return null;
			}
			if (ToolsUtil.isEmpty(identifiedAddress)) {
				map.put("returnMessage", "家庭地址不能为空!");

				response.getWriter().write(map.toString());
				return null;
			}

			if (ToolsUtil.isEmpty(jobId)) {
				map.put("returnMessage", "工作不能为空!");

				response.getWriter().write(map.toString());
				return null;
			}
			if (ToolsUtil.isEmpty(jobId) || ToolsUtil.isEmpty(districtId)) {
				map.put("returnMessage", "工作地址不正确!");

				response.getWriter().write(map.toString());
				return null;
			}
			if (ToolsUtil.isEmpty(judgeLevel)) {
				map.put("returnMessage", "裁判等级不能为空!");

				response.getWriter().write(map.toString());
				return null;
			}
			if (ToolsUtil.isEmpty(judgeMobile)) {
				map.put("returnMessage", "手机号码不能为空!");

				response.getWriter().write(map.toString());
				return null;
			}

			if (!ToolsUtil.isMobile(judgeMobile)) {
				map.put("returnMessage", "手机号码格式不正确!");

				response.getWriter().write(map.toString());
				return null;
			}
			if (!levelFile.isEmpty()
					&& !ToolsUtil.isImage(idFile.getOriginalFilename())) {
				map.put("returnMessage", "证书附件格式不正确，仅支持（jpg,bmp,png,jpeg）!");

				response.getWriter().write(map.toString());
				return null;
			} else if (!levelFile.isEmpty()
					&& ToolsUtil.isImage(idFile.getOriginalFilename())) {
				// 获得文件后缀
				String suffix = levelFile.getOriginalFilename().substring(
						levelFile.getOriginalFilename().lastIndexOf("."));
				// 重命名
				fileName_level = "DJZ" + System.currentTimeMillis() + suffix;
				// 拼完整文件路径
				String path = levelDir + File.separator + fileName_level;
				file_level = new File(path);
				levelFile.transferTo(file_level);
			}
			if (idFile.isEmpty()) {
				map.put("returnMessage", "您还未上传身份证附件!");

				response.getWriter().write(map.toString());
				return null;
			} else if (!ToolsUtil.isImage(idFile.getOriginalFilename())) {
				map.put("returnMessage", "身份证附件格式不正确，仅支持（jpg,bmp,png,jpeg）!");

				response.getWriter().write(map.toString());
				return null;
			} else {
				// 获得文件后缀
				String suffix = idFile.getOriginalFilename().substring(
						idFile.getOriginalFilename().lastIndexOf("."));
				// 重命名
				fileName_id = "SFZ" + System.currentTimeMillis() + suffix;
				// 拼完整文件路径
				String path = idDir + File.separator + fileName_id;
				file_id = new File(path);
				idFile.transferTo(file_id);
			}

			if (judgeManagementService.applyJudge(identifiedId, identifiedName,
					Integer.parseInt(identifiedGender), identifiedNationality,
					sdf.parse(identifiedBirthday), identifiedAddress,
					Integer.parseInt(jobId), Integer.parseInt(districtId),
					jobAddress, Integer.parseInt(judgeLevel), 1, judgeMobile,
					judgeTips, fileName_id, fileName_level)) {
				map.put("returnCode", 200);
				map.put("returnMessage", "申请成功，请等待审核！");

				response.getWriter().write(map.toString());
				return null;
			} else {

				if (file_level != null) {
					file_level.delete();
				}
				if (file_id != null) {
					file_id.delete();
				}

			}
		} catch (Exception exception) {
			exception.printStackTrace();

		}

		return null;

	}

	/**
	 * 
	 * 
	 * @param multipartHttpServletRequest
	 * @param session
	 * @return String
	 *
	 */

	// @RequestMapping(value = "/addjudge")
	// @ResponseBody
	// @Transactional
	// public Map<String, Object> addJudge(HttpServletRequest request,
	// HttpSession session) {
	// Map<String, Object> map = new HashMap<String, Object>();
	// try {
	// map.put("returnCode", 500);
	// map.put("returnMessage", "添加裁判员失败！");
	// String judgeName = request.getParameter("judgeName");
	// String userPassword = request.getParameter("judgeUserPassword");
	// String userName = request.getParameter("judgeUserName");
	// String judgeGender = request.getParameter("judgeGender");
	// String judgeLevel = request.getParameter("judgeLevel");
	// if (ToolsUtil.isEmpty(judgeName)) {
	// map.put("returnCode", 300);
	// map.put("returnMessage", "出错啦，裁判员姓名不能为空！");
	// return map;
	// }
	// if (ToolsUtil.isEmpty(judgeGender)) {
	// map.put("returnCode", 300);
	// map.put("returnMessage", "出错啦，裁判员性别不能为空！");
	// return map;
	// }
	// if (ToolsUtil.isEmpty(userName)) {
	// map.put("returnCode", 300);
	// map.put("returnMessage", "出错啦，裁判员用户名不能为空！");
	// return map;
	// }
	// if (ToolsUtil.isEmpty(userPassword)) {
	// map.put("returnCode", 300);
	// map.put("returnMessage", "出错啦，裁判员用户密码不能为空！");
	// return map;
	// }
	//
	// if (ToolsUtil.isEmpty(judgeLevel)) {
	// map.put("returnCode", 300);
	// map.put("returnMessage", "出错啦，裁判员等级不能为空！");
	// return map;
	// }
	// // 检查用户名是否存在
	// if (userManagementService.getUserList(null, null, userName, null,
	// null, "1").size() > 0) {
	// map.put("returnCode", 400);
	// map.put("returnMessage", "出错啦，用户名已存在！");
	// return map;
	// }
	// if (judgeManagementService.addJudge(userPassword, userName,
	// judgeName, judgeGender, judgeLevel)) {
	// map.put("returnCode", 200);
	// map.put("returnMessage", "添加裁判员成功！");
	// return map;
	// }
	//
	// } catch (Exception exception) {
	// exception.printStackTrace();
	//
	// }
	// return map;
	// }

	/**
	 * 
	 * 模糊查询裁判信息
	 * 
	 * @param request
	 * @param session
	 * @return List<YsmsJudge>
	 *
	 */
	@ResponseBody
	@RequestMapping(value = "/listjudge", method = RequestMethod.POST)
	public Map<String, Object> queryJudges(HttpServletRequest request,
			HttpSession session) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		String identifiedName = request.getParameter("judgeName");
		String gender = request.getParameter("judgeGender");
		String beginTime = request.getParameter("beginTime");
		String endTime = request.getParameter("endTime");
		String judgeStatus = request.getParameter("judgeStatus");
		String judgeLevel = request.getParameter("judgeLevel");
		String currentPage = request.getParameter("currentPage");
		List<String> levelList = new ArrayList<String>();
		if (!isNumeric(currentPage)) {
			currentPage = "1";
		}
		boolean flag = false;
		if (!ToolsUtil.isEmpty(judgeLevel)) {
			flag = true;
			String[] levels = judgeLevel.split(",");
			for (String level : levels) {
				levelList.add(level);
			}
		}
		Integer count = judgeManagementService.getAllJudgesCount(
				identifiedName, gender, beginTime, endTime, judgeStatus);

		Page returnPage = new Page();
		Integer returanCurrentPage = 0;
		if (Integer.parseInt(currentPage) == 0) {
			returanCurrentPage = 1;
		} else if (Integer.parseInt(currentPage) <= PageUtil.getTotalPage(10,
				count)) {
			returanCurrentPage = Integer.parseInt(currentPage);

		} else {
			returanCurrentPage = PageUtil.getTotalPage(10, count);
		}
		returnPage.setCurrentPage(returanCurrentPage);
		returnPage.setHasNextPage(PageUtil.getHasNextPage(
				PageUtil.getTotalPage(10, count), returanCurrentPage));
		returnPage.setHasPrePage(PageUtil.getHasPrePage(returanCurrentPage));
		returnPage.setTotalPage(PageUtil.getTotalPage(10, count));
		returnPage.setTotalCount(count);
		List<Map<String, Object>> judge_list = judgeManagementService
				.getAllJudges(identifiedName, gender, beginTime, endTime,
						judgeStatus, returanCurrentPage.toString());
		if (!ToolsUtil.isEmpty(judge_list)) {
			for (int i = 0; i < judge_list.size(); i++) {

				Map<String, Object> map = new HashMap<String, Object>();
				map.put("name", judge_list.get(i).get("identified_name"));
				map.put("id", judge_list.get(i).get("judge_id"));
				map.put("birthday", judge_list.get(i)
						.get("identified_birthday"));
				map.put("gender", judge_list.get(i).get("identified_gender"));
				List<Map<String, Object>> judgeandlevel_list = judgeManagementService
						.getJudgeLevelByJudge(judge_list.get(i).get("judge_id")
								.toString());
				List<String> level = new ArrayList<String>();
				for (int j = 0; j < judgeandlevel_list.size(); j++) {
					level.add(judgeandlevel_list.get(j).get("level_id")
							.toString());
				}
				map.put("level", level);
				if (flag) {
					if (listContains(levelList, level)) {
						list.add(map);
					}
				} else {
					list.add(map);
				}

			}

		}
		returnMap.put("page", returnPage);
		returnMap.put("data", list);
		return returnMap;
	}

	/**
	 * 
	 * 查询裁判申请信息
	 * 
	 * @param request
	 * @param session
	 * @return Map<String, Object>
	 *
	 */
	@ResponseBody
	@RequestMapping(value = "/getapplications", method = RequestMethod.POST)
	public Map<String, Object> getApplications(HttpServletRequest request,
			HttpSession session) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> returnList = new ArrayList<Map<String, Object>>();

		String currentPage = request.getParameter("currentPage");

		if (!isNumeric(currentPage)) {
			currentPage = "1";
		}

		Integer count = judgeManagementService.getAllJudgesCount(null, null,
				null, null, "1");

		Page returnPage = new Page();
		Integer returanCurrentPage = 0;
		if (Integer.parseInt(currentPage) == 0) {
			returanCurrentPage = 1;
		} else if (Integer.parseInt(currentPage) <= PageUtil.getTotalPage(10,
				count)) {
			returanCurrentPage = Integer.parseInt(currentPage);

		} else {
			returanCurrentPage = PageUtil.getTotalPage(10, count);
		}
		returnPage.setCurrentPage(returanCurrentPage);
		returnPage.setHasNextPage(PageUtil.getHasNextPage(
				PageUtil.getTotalPage(10, count), returanCurrentPage));
		returnPage.setHasPrePage(PageUtil.getHasPrePage(returanCurrentPage));
		returnPage.setTotalPage(PageUtil.getTotalPage(10, count));
		returnPage.setTotalCount(count);
		list = judgeManagementService.getAllJudges(null, null, null, null, "1",
				returanCurrentPage.toString());
		if (!ToolsUtil.isEmpty(list)) {
			for (int i = 0; i < list.size(); i++) {

				Map<String, Object> map = new HashMap<String, Object>();
				map.put("name", list.get(i).get("identified_name"));
				map.put("id", list.get(i).get("judge_id"));
				map.put("birthday", list.get(i).get("identified_birthday"));
				map.put("gender", list.get(i).get("identified_gender"));
				map.put("level", list.get(i).get("judge_level"));
				map.put("mobile", list.get(i).get("judge_mobile"));
				returnList.add(map);

			}

		}
		returnMap.put("page", returnPage);
		returnMap.put("data", returnList);
		return returnMap;
	}

	/**
	 * 
	 * 修改裁判信息
	 * 
	 * @param request
	 * @param session
	 * @return String
	 *
	 */
	@ResponseBody
	@RequestMapping(value = "/updatejudge", method = RequestMethod.POST)
	@Transactional
	public Map<String, Object> updateJudge(HttpServletRequest request,
			HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map.put("returnCode", 500);
			map.put("returnMessage", "修改裁判员失败！");
			String judgeId = request.getParameter("judgeId");
			String jobId = request.getParameter("jobId");
			String districtId = request.getParameter("districtId");
			String identifiedAddress = request
					.getParameter("identifiedAddress");
			String judgeLevel = request.getParameter("judgeLevel");
			String jobAddress = request.getParameter("jobAddress");
			String judgeContact = request.getParameter("judgeContact");
			if(ToolsUtil.isEmpty(judgeId)){
				map.put("returnCode", 300);
				map.put("returnMessage", "获取裁判员ID失败！");
				return map;
			}
			if(judgeManagementService.updateJudge(judgeId, jobId, jobAddress, districtId, identifiedAddress, judgeContact, judgeLevel)){
				map.put("returnCode", 200);
				map.put("returnMessage", "修改裁判员成功！");
				return map;
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return map;
	}

	/**
	 * 
	 * 删除裁判信息
	 * 
	 * @param request
	 * @param session
	 * @return String
	 *
	 */
	@ResponseBody
	@RequestMapping(value = "/deletejudge", method = RequestMethod.POST)
	@Transactional
	public Map<String, Object> deleteJudge(HttpServletRequest request,
			HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map.put("returnCode", 500);
			map.put("returnMessage", "删除裁判员失败！");
			String judge_id = request.getParameter("judge_id");
			if (ToolsUtil.isEmpty(judge_id)) {
				map.put("returnCode", 300);
				map.put("returnMessage", "没有选择任何记录！");
				return map;
			}
			if (judgeManagementService.deleteJudge(judge_id)) {
				map.put("returnCode", 200);
				map.put("returnMessage", "删除裁判员成功！");
				return map;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return map;
	}

	@ResponseBody
	@RequestMapping(value = "/getjobsanddistrict", method = RequestMethod.POST)
	@Transactional
	public Map<String, Object> getjobsanddistrict(HttpServletRequest request,
			HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			map = judgeManagementService.getJobAndDistrict();

		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return map;
	}

	@ResponseBody
	@RequestMapping(value = "/getatts", method = RequestMethod.POST)
	@Transactional
	public Map<String, Object> getAtts(HttpServletRequest request,
			HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("returnCode", 500);
		map.put("returnMessage", "获取附件失败！");
		try {

			String judgeId = request.getParameter("judgeId");
			String attType = request.getParameter("attType");
			map.put("returnCode", 300);
			if (ToolsUtil.isEmpty(judgeId)) {
				map.put("returnMessage", "裁判员ID不能为空！");
				return map;
			}
			if (ToolsUtil.isEmpty(attType)) {
				map.put("returnMessage", "附件类型不能为空！");
				return map;
			}
			List<Map<String, Object>> list = judgeManagementService.getAtt(
					judgeId, attType);
			map.put("returnCode", 200);
			map.put("returnMessage", list);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return map;
	}

	@ResponseBody
	@RequestMapping(value = "/getjudge", method = RequestMethod.POST)
	@Transactional
	public Map<String, Object> getjudge(HttpServletRequest request,
			HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String judgeId = request.getParameter("judgeId");
			if (!ToolsUtil.isEmpty(judgeId)) {
				map = judgeManagementService.getJudgeById(Integer
						.parseInt(judgeId));
			} else {
				map.put("returnCode", 300);
				map.put("returnMessage", "裁判员ID不能为空！");
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return map;
	}

	@ResponseBody
	@RequestMapping(value = "/ispassed", method = RequestMethod.POST)
	@Transactional
	public Map<String, Object> isPassed(HttpServletRequest request,
			HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("returnCode", 500);
		map.put("returnMessage", "服务器出错啦！");
		try {
			String judgeId = request.getParameter("judgeId");
			String judgeStatus = request.getParameter("judgeStatus");
			map.put("returnCode", 300);
			if (ToolsUtil.isEmpty(judgeId)) {
				map.put("returnMessage", "裁判员ID不能为空！");
				return map;
			}
			if (ToolsUtil.isEmpty(judgeStatus)) {
				map.put("returnMessage", " 审核状态不能为空！");
				return map;
			}
			if (judgeManagementService.isPassed(judgeId, judgeStatus)) {
				map.put("returnCode", 200);
				map.put("returnMessage", "审核成功！");
				return map;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return map;
	}

	public static boolean listContains(List<String> fatherList,
			List<String> sonList) {
		for (int i = 0; i < sonList.size(); i++) {
			if (fatherList.contains(sonList.get(i))) {
				return true;
			}
		}
		return false;
	}

	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(str).matches();
	}
}
