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

import com.cwkj.ysms.model.YsmsFunction;
import com.cwkj.ysms.model.view.UserGroupView;
import com.cwkj.ysms.service.UserManagementService;

@Controller
@RequestMapping(value = "/authoritymatrix")
public class AuthorityMatrixControl {
	@Resource
	private UserManagementService userManagementService;

	public UserManagementService getUserManagementService() {
		return userManagementService;
	}

	public void setUserManagementService(UserManagementService userManagementService) {
		this.userManagementService = userManagementService;
	}
	

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listResult(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) {
		Map<String, Object> model = new HashMap<String, Object>();
		List<YsmsFunction> functionList = userManagementService.getAllFunction();
		model.put("functions", functionList);
		return new ModelAndView("AuthorityMatrixPage", model);
	}
	
	@ResponseBody
	@RequestMapping(value = "getgroups", method = RequestMethod.POST)
	public Map<String, Object> getGroups(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		List<UserGroupView> groupViewList = userManagementService.getAllGroups();
		model.put("groups", groupViewList);
		model.put("func_count", userManagementService.getAllFunction().size());
		return model;
	}
	
	@ResponseBody
	@RequestMapping(value = "addauthority", method = RequestMethod.POST)
	public Map<String, Object> addAuthority(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		int functionId = Integer.parseInt(request.getParameter("function_id"));
		int groupId = Integer.parseInt(request.getParameter("group_id"));
		boolean result = userManagementService.addFunctionToGroup(groupId, functionId);
		model.put("success", result);
		return model;
	}
	
	@ResponseBody
	@RequestMapping(value = "removeauthority", method = RequestMethod.POST)
	public Map<String, Object> removeAuthority(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		int functionId = Integer.parseInt(request.getParameter("function_id"));
		int groupId = Integer.parseInt(request.getParameter("group_id"));
		boolean result = userManagementService.deleteFunctionToGroup(groupId, functionId);
		model.put("success", result);
		return model;
	}
	
	@ResponseBody
	@RequestMapping(value = "addgroup", method = RequestMethod.POST)
	public Map<String, Object> addGroup(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		String groupName = request.getParameter("group_name");
		boolean result = userManagementService.addGroup(groupName);
		model.put("success", result); 
		return model;
	}
	
	@ResponseBody
	@RequestMapping(value = "removegroup", method = RequestMethod.POST)
	public Map<String, Object> removeGroup(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		int groupId = Integer.parseInt(request.getParameter("group_id"));
		boolean result = userManagementService.deleteGroup(groupId);
		model.put("success", result);
		return model;
	}
}
