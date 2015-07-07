package com.cwkj.ysms.control;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cwkj.ysms.service.SchoolManagementService;

@Controller
@RequestMapping(value = "/management")
public class ManagementPlatformMainControl {

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
	 * 管理平台主页面
	 * @param request
	 * @param session
	 * @param response
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listResult(HttpServletRequest request,HttpSession session,HttpServletResponse response){
		/*获取session获取角色信息，包括session中的角色名，根据不同角色返回不同界面*/
		//		int roleId = Integer.parseInt(session.getAttribute("roleId").toString());
		//		String username = session.getAttribute("username").toString();
		Map<String, Object> model = new HashMap<String, Object>();
		String userNickName = (String) session.getAttribute("userName");
		Object schoolId = session.getAttribute("schoolId");
		if(schoolId!=null)
			userNickName = schoolManagementService.getSchoolByID(Integer.parseInt(schoolId.toString())).getSchoolName();
		model.put("username",userNickName);
		return new ModelAndView("ManagementPlatformMainPage", model);
	}
	
	
}
