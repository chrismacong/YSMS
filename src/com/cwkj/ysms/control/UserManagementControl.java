package com.cwkj.ysms.control;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSON;
import net.sf.json.JSONSerializer;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cwkj.ysms.service.UserManagementService;
import com.cwkj.ysms.util.Page;
import com.cwkj.ysms.util.PageUtil;
import com.cwkj.ysms.util.ToolsUtil;

/**
 * 
 * 用户管理控制器
 * 
 * @author panhailin henry_pan@126.com
 * @date 2015年3月6日 下午3:12:44
 *
 */
@Controller
@RequestMapping(value = "/usermanagement")
public class UserManagementControl {
	@Resource
	private UserManagementService userManagementService;

	public UserManagementService getUserManagementService() {
		return userManagementService;
	}

	public void setUserManagementService(
			UserManagementService userManagementService) {
		this.userManagementService = userManagementService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listResult(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) {
		return new ModelAndView("UserManagementPage");
	}

	/**
	 * 
	 * 添加用户
	 * 
	 * @param request
	 * @param session
	 * @return String
	 *
	 */
	@ResponseBody
	@Transactional
	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public Map<String, Object> addUser(HttpServletRequest request,
			HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("returnCode", 500);
		map.put("returnMessage", "添加用户失败！");
		try {
			// 组别ID
			String group_id = request.getParameter("userGroup");
			// 邮箱地址
			String user_email = request.getParameter("userEmail");
			// 用户名
			String user_name = request.getParameter("userName");
			// 密码
			String user_password = request.getParameter("userPassword");

			if (ToolsUtil.isEmpty(user_name)) {
				map.put("returnCode", 300);
				map.put("returnMessage", "出错啦，用户名不能为空！");
				return map;
			}

			if (ToolsUtil.isEmpty(user_email)) {
				map.put("returnCode", 300);
				map.put("returnMessage", "出错啦，邮箱不能为空！");
				return map;
			}
			if (!ToolsUtil.checkEmail(user_email)) {
				map.put("returnCode", 300);
				map.put("returnMessage", "出错啦，邮箱格式不正确！");
				return map;
			}
		 
			if (user_password.length()<6) {
				map.put("returnCode", 300);
				map.put("returnMessage", "出错啦，密码不能少于6位！");
				return map;
			}
			if (ToolsUtil.isEmpty(group_id)) {
				map.put("returnCode", 300);
				map.put("returnMessage", "出错啦，用户组不能为空！");
				return map;
			}
			// 检查用户名
			if (userManagementService.getUserByName(user_name)!=null) {
				map.put("returnCode", 400);
				map.put("returnMessage", "用户名已存在！");
				return map;
			}
			// 增加用户
			if (userManagementService.addUser(group_id, user_email,
					user_password, user_name)) {
				map.put("returnCode", 200);
				map.put("returnMessage", "添加用户成功！");
				return map;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return map;
	}

	/**
	 * 
	 * 删除用户
	 * 
	 * @param request
	 * @param session
	 * @return String
	 *
	 */
	@ResponseBody
	@Transactional
	@RequestMapping(value = "/deleteuser", method = RequestMethod.POST)
	public Map<String, Object> deleteUser(HttpServletRequest request,
			HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String userId = session.getAttribute("userId").toString();
			map.put("returnCode", 500);
			map.put("returnMessage", "删除失败，请联系管理员！");

			String user_id = request.getParameter("user_id");
			if (ToolsUtil.isEmpty(user_id)) {
				map.put("returnCode", 300);
				map.put("returnMessage", "出错啦,请先选择再删除！");
				return map;
			}
			String[] userIds=user_id.split(",");
			List<String> list=new ArrayList<String>();
			for(String id:userIds){
				list.add(id);
			}
			if (list.contains("1")) {
				map.put("returnCode", 400);
				map.put("returnMessage", "出错啦,您不能删除超级用户！");
				return map;
			}

			if (list.contains(userId)) {
				map.put("returnCode", 400);
				map.put("returnMessage", "出错啦,您不能删除自己！");
				return map;
			}
			// 调用service删除方法
			if (userManagementService.deleteUser(user_id) == true) {
				map.put("returnCode", 200);
				map.put("returnMessage", "删除成功！");
			}
		} catch (Exception exception) {
			exception.printStackTrace();

		}
		return map;
	}

	/**
	 * 
	 * 修改用户
	 * 
	 * @param request
	 * @param session
	 * @return String
	 *
	 */
	@ResponseBody
	@Transactional
	@RequestMapping(value = "/updateuser", method = RequestMethod.POST)
	public Map<String, Object> updateUser(HttpServletRequest request,
			HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map.put("returnCode", 500);
			map.put("returnMessage", "修改用户失败！");
			String userName = (String) session.getAttribute("userName");
			// 用户ID
			String user_id = request.getParameter("user_id");
			// 组别ID
			String group_id = request.getParameter("group_id");
			// 用户邮件地址
			String user_email = request.getParameter("user_email");
			// 用户名
			String user_name = request.getParameter("user_name");
			// 用户密码
			String user_password = request.getParameter("user_password");
			// 删除状态
			String delete_flag = "0";

			if (ToolsUtil.isEmpty(user_id)) {
				map.put("returnCode", 300);
				map.put("returnMessage", "出错啦，用户ID不能为空！");
				return map;
			}

			if (ToolsUtil.isEmpty(user_name)) {
				map.put("returnCode", 300);
				map.put("returnMessage", "出错啦，用户名不能为空！");
				return map;
			}

			if (ToolsUtil.isEmpty(user_email)) {
				map.put("returnCode", 300);
				map.put("returnMessage", "出错啦，邮箱不能为空！");
				return map;
			}

			if (ToolsUtil.isEmpty(user_password)) {
				map.put("returnCode", 300);
				map.put("returnMessage", "出错啦，用户密码不能为空！");
				return map;
			}

			if (ToolsUtil.isEmpty(group_id)) {
				map.put("returnCode", 300);
				map.put("returnMessage", "出错啦，用户组不能为空！");
				return map;
			}
			 List<Map<String,Object>> list=userManagementService.getUserbyID(user_id);
			 
				if(!list.get(0).get("user_name").toString().equals(user_name)){
					// 检查用户名
					if (!userName.equals(user_name)) {
						if (userManagementService.getUserList(null, null, user_name,
								"0", null, "0").size() > 0) {
							map.put("returnCode", 400);
							map.put("returnMessage", "用户名已存在！");
							return map;
						}
					}
				}
			 
		
			// 调用service更新方法
			if (userManagementService.updateUser(user_id, group_id, user_email,
					user_password, user_name, delete_flag)) {
				map.put("returnCode", 200);
				map.put("returnMessage", "修改用户成功！");
			}
		} catch (Exception exception) {
			exception.printStackTrace();

		}
		return map;
	}

	/**
	 * 
	 * 模糊查找用户
	 * 
	 * @param request
	 * @param session
	 * @return List<YsmsUser>
	 *
	 */
	@ResponseBody
	@RequestMapping(value = "/listUser", method = RequestMethod.POST)
	public Map<String, Object> listUser(HttpServletRequest request,
			HttpSession session) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			// 组别ID
			String group_id = request.getParameter("group_id");
			// 邮件地址
			String user_email = request.getParameter("user_email");
			// 用户名
			String user_name = request.getParameter("user_name");
			// 密码
			String user_password = request.getParameter("user_password");
			// 删除状态
			String delete_flag = request.getParameter("delete_flag");
			String currentPage = request.getParameter("current_page");
			if(!isNumeric(currentPage)){
				currentPage="1";
			}
			int count = userManagementService.getUserListCount(group_id,
					user_email, user_name, user_password, delete_flag);
			Page returnPage = new Page();
			Integer returanCurrentPage = 0;
			if (Integer.parseInt(currentPage) == 0) {
				returanCurrentPage = 1;
			} else if (Integer.parseInt(currentPage) <= PageUtil.getTotalPage(
					10, count)) {
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
			list = userManagementService.getUserList(group_id, user_email,
					user_name, user_password, "0",
					returanCurrentPage.toString());
			map.put("data", list);
			map.put("page", returnPage);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return map;
	}

	/**
	 * 
	 * 根据ID查询用户
	 * 
	 * @param request
	 * @param session
	 * @return YsmsUser
	 *
	 */
	@ResponseBody
	@RequestMapping(value = "/getuser", method = RequestMethod.POST)
	public List<Map<String, Object>> getUser(HttpServletRequest request,
			HttpSession session) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			// 用户ID
			String user_id = request.getParameter("user_id") == null ? ""
					: request.getParameter("user_id");
			// 调用service查询方法
			list = userManagementService.getUserbyID(user_id);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return list;
	}

	/**
	 * 
	 * 登录
	 * 
	 * @param request
	 * @param session
	 * @return String
	 *
	 */
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Map<String, Object> login(HttpServletRequest request,
			HttpSession session) {	
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map.put("returnCode", 500);
			map.put("returnMessage", "用户名或密码错误！");
			// 用户名
			String user_name = request.getParameter("userName") == null ? ""
					: request.getParameter("userName");
			// 密码
			String user_password = request.getParameter("userPassword") == null ? ""
					: request.getParameter("userPassword");
			if(ToolsUtil.isEmpty(user_name)){
				map.put("returnCode", 300);
				map.put("returnMessage", "出错啦，用户名不能为空！");
				return map;
			}

			if(ToolsUtil.isEmpty(user_password)){
				map.put("returnCode", 300);
				map.put("returnMessage", "出错啦，用户密码不能为空！");
				return map;
			}

			List<Map<String, Object>> list = userManagementService.login(
					user_name, user_password);
			if (!ToolsUtil.isEmpty(list)) {
				List<Integer> functions = new ArrayList<Integer>();
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).get("function_id") != null) {
						functions.add(Integer.parseInt(list.get(i)
								.get("function_id").toString()));
					}
				}
				session.setAttribute("userId", list.get(0).get("user_id"));
				session.setAttribute("userName", list.get(0).get("user_name"));
				session.setAttribute("userGroup", list.get(0).get("group_id"));
				session.setAttribute("schoolId", list.get(0).get("school_id"));
				session.setAttribute("judegeId", list.get(0).get("judge_id"));
				session.setAttribute("userFunction", functions);
				map.put("returnCode", 200);
				map.put("returnMessage", "登录成功！");
				return map;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return map;
	}

	/**
	 * 
	 * 注销用户
	 * 
	 * @param request
	 * @param session
	 * @return String
	 *
	 */
	@ResponseBody
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpSession session) {
		try {
			// session失效
			session.invalidate();
		} catch (Exception exception) {
			exception.printStackTrace();
			return "fail";
		}
		return "success";
	}

	/**
	 * 
	 * 获取组别
	 * 
	 * @param request
	 * @param session
	 * @return String
	 *
	 */
	@ResponseBody
	@RequestMapping(value = "/getGroups", method = RequestMethod.POST)
	public List<Map<String, Object>> getGroups(HttpServletRequest request,
			HttpSession session) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			String args=request.getParameter("args");
			list = userManagementService.getGroups(args);
		} catch (Exception exception) {
			exception.printStackTrace();
			return list;
		}
		return list;
	}

	public static boolean isNumeric(String str){
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(str).matches();
	}


	/**
	 * 修改密码
	 * @param request
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/changepwd", method = RequestMethod.POST)
	public Map<String, Object> changePwd(HttpServletRequest request,
			HttpSession session) {
		Map<String, Object> model = new HashMap<String, Object>();
		String userName = session.getAttribute("userName").toString();
		String oldPwd = request.getParameter("oldpwd");
		String newPwd = request.getParameter("newpwd");
		boolean result = userManagementService.changePwd(userName, oldPwd, newPwd);
		model.put("success", result);
		return model;
	}
}
