package com.cwkj.ysms.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cwkj.ysms.model.YsmsUser;
import com.cwkj.ysms.model.view.SchoolView;
import com.cwkj.ysms.service.SchoolManagementService;
import com.cwkj.ysms.service.UserManagementService;
import com.cwkj.ysms.util.MD5Util;
import com.cwkj.ysms.util.Page;
import com.cwkj.ysms.util.PageUtil;
import com.cwkj.ysms.util.PinyinUtil;
import com.cwkj.ysms.util.ToolsUtil;

@Controller
@RequestMapping(value = "/schoolmanagement")
public class SchoolManagementControl {
	@Resource
	private SchoolManagementService schoolManagementService;

	public SchoolManagementService getSchoolManagementService() {
		return schoolManagementService;
	}

	public void setSchoolManagementService(
			SchoolManagementService schoolManagementService) {
		this.schoolManagementService = schoolManagementService;
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
		return new ModelAndView("SchoolManagementPage");
	}

	@RequestMapping(value = "/listschool", method = RequestMethod.GET)
	public ModelAndView listSchool(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) {
		Map<String, Object> model = new HashMap<String, Object>();
		List<SchoolView> schools = schoolManagementService.getAllSchools(null,
				null, "1");
		model.put("schools", schools);
		return new ModelAndView("SchoolListPage", model);
	}

	@RequestMapping(value = "/getschools", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getSchools(HttpServletRequest request,
			HttpSession session) {
		List<SchoolView> schools = new ArrayList<SchoolView>();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			// 学校名称
			String schoolName = request.getParameter("school_name");
			// 学校分类
			String schoolCategory = request.getParameter("category");
			// 当前页
			String currentPage = request.getParameter("current_page");

			int count = schoolManagementService.getSchoolsCount(schoolName,
					schoolCategory);
			Page returnPage = new Page();
			Integer returanCurrentPage = 0;
			if (Integer.parseInt(currentPage) <= PageUtil.getTotalPage(10,
					count)) {
				returanCurrentPage = Integer.parseInt(currentPage);

			} else {
				returanCurrentPage = PageUtil.getTotalPage(10, count);
			}
			returnPage.setCurrentPage(returanCurrentPage);
			returnPage.setHasNextPage(PageUtil.getHasNextPage(
					PageUtil.getTotalPage(10, count), returanCurrentPage));
			returnPage
					.setHasPrePage(PageUtil.getHasPrePage(returanCurrentPage));
			returnPage.setTotalPage(PageUtil.getTotalPage(10, count));
			returnPage.setTotalCount(count);
			// 调用service模糊查询方法
			schools = schoolManagementService.getAllSchools(schoolName,
					schoolCategory, returanCurrentPage.toString());
			map.put("data", schools);
			map.put("page", returnPage);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/registerschool", method = RequestMethod.GET)
	public ModelAndView registerSchoolInfo(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) {
		return new ModelAndView("SchoolRegisterPage");
	}

	@RequestMapping(value = "/addschool", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addSchoolInfo(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String groupId = "2"; // hardcode here!
		String schoolName = request.getParameter("school_name");
		String schoolCategory = request.getParameter("category");
		String userEmail = request.getParameter("email");
		String userName = request.getParameter("user_name");

		String districtId = request.getParameter("district_id");
		String schoolAddress = request.getParameter("school_address");
		String schoolContacts = request.getParameter("school_contacts");
		String schoolMobile = request.getParameter("school_mobile");
		String schoolFax = request.getParameter("school_fax");

		Boolean result = schoolManagementService.addSchool(groupId, schoolName,
				schoolCategory, userEmail, userName, MD5Util.MD5("123456"),
				districtId, schoolAddress, schoolContacts, schoolMobile,
				schoolFax);
		map.put("success", result);
		return map;
	}

	@RequestMapping(value = "/deleteschool", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Boolean> deleteSchoolInfo(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) {
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		int schoolId = Integer.parseInt(request.getParameter("school_id"));
		Boolean result = schoolManagementService.deleteSchool(schoolId);
		map.put("success", result);
		return map;
	}

	@RequestMapping(value = "/modifyschool", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Boolean> modifySchoolInfo(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) {
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		String schoolId = request.getParameter("school_id");
		String schoolName = request.getParameter("school_name");
		Boolean result = schoolManagementService.updateSchool(schoolId,
				schoolName);
		map.put("success", result);
		return map;
	}

	@RequestMapping(value = "pinyinusername", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> pinyinUsername(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String schoolname = request.getParameter("school_name");
		String pinyinUsername = "";
		map.put("pinyin_username", "");
		try {
			 
			if (ToolsUtil.checkChs(schoolname)) {

				String pinyinUsernames[] = PinyinUtil.getPinyinJianPin(
						schoolname).split(",");
				if (pinyinUsernames.length > 0) {
					pinyinUsername = pinyinUsernames[0];
				} else {
					pinyinUsername = PinyinUtil.getPinyinJianPin(schoolname);
				}
				YsmsUser ysmsUser = userManagementService
						.getUserByName(pinyinUsername);
				if (ysmsUser != null) {
					pinyinUsernames = PinyinUtil.getPinyinJianPin(schoolname)
							.split(",");
					if (pinyinUsernames.length > 0) {
						pinyinUsername = pinyinUsernames[0];
					} else {
						pinyinUsername = PinyinUtil
								.getPinyinJianPin(schoolname);
					}
					ysmsUser = userManagementService
							.getUserByName(pinyinUsername);
					int index = 1;
					if (ysmsUser != null) {
						pinyinUsernames = PinyinUtil.getPinyinJianPin(
								schoolname).split(",");
						if (pinyinUsernames.length > 0) {
							pinyinUsername = pinyinUsernames[0] + index;
						} else {
							pinyinUsername = PinyinUtil
									.getPinyinJianPin(schoolname) + index;
						}
						ysmsUser = userManagementService
								.getUserByName(pinyinUsername);
						index++;
						while (ysmsUser != null) {
							pinyinUsernames = PinyinUtil.getPinyinJianPin(
									schoolname).split(",");
							if (pinyinUsernames.length > 0) {
								pinyinUsername = pinyinUsernames[0] + index;
							} else {
								pinyinUsername = PinyinUtil
										.getPinyinJianPin(schoolname) + index;
							}
							ysmsUser = userManagementService
									.getUserByName(pinyinUsername);
							index++;
						}
					}
				}
				map.put("pinyin_username", pinyinUsername);
			}
		} catch (Exception ex) {

		}
		
		return map;
	}

	@RequestMapping(value = "checkusername", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> checkUsername(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String username = request.getParameter("user_name");
		YsmsUser ysmsUser = userManagementService.getUserByName(username);
		boolean result = true;
		if (ysmsUser != null)
			result = false;
		map.put("success", result);
		return map;
	}

}
