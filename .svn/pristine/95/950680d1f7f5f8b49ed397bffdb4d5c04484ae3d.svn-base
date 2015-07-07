package com.cwkj.ysms.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/login")
public class LoginControl {
	/**
	 * 登陆
	 * @param request
	 * @param session
	 * @param response
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listResult(HttpServletRequest request,HttpSession session,HttpServletResponse response){
		return new ModelAndView("IndexPage");
	}
	
	/**
	 * 注销登陆
	 * @param request
	 * @param session
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView leaguesByYear(HttpServletRequest request,
			HttpSession session,HttpServletResponse response){
		session.setAttribute("userId", null);
		session.setAttribute("userName", null);
		session.setAttribute("userGroup", null);
		session.setAttribute("schoolId", null);
		session.setAttribute("judegeId", null);
		session.setAttribute("userFunction", null);
		return new ModelAndView("redirect:/login.html");
	}
}
