package com.cwkj.ysms.control;

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

import com.cwkj.ysms.model.view.CardAthleteView;
import com.cwkj.ysms.model.view.CardCoachView;
import com.cwkj.ysms.model.view.CardSchoolView;
import com.cwkj.ysms.service.DataExportingService;

@Controller
@RequestMapping(value = "/exportcard")
public class ExportCardControl {
	@Resource
	private DataExportingService dataExportingService;
	public DataExportingService getDataExportingService() {
		return dataExportingService;
	}
	public void setDataExportingService(DataExportingService dataExportingService) {
		this.dataExportingService = dataExportingService;
	}
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listResult(HttpServletRequest request,
			HttpSession session, HttpServletResponse response) {
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value = "/school", method = RequestMethod.POST)
	public List<CardSchoolView> getSchool(HttpServletRequest request,
			HttpSession session,HttpServletResponse response){
		List<CardSchoolView> result = dataExportingService.exportCard_School();
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/athlete", method = RequestMethod.POST)
	public List<CardAthleteView> getAthlete(HttpServletRequest request,
			HttpSession session,HttpServletResponse response){
		int schoolId = Integer.parseInt(request.getParameter("school_id"));
		List<CardAthleteView> result = dataExportingService.exportCard_Athlete(schoolId);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/coach", method = RequestMethod.POST)
	public List<CardCoachView> getCoach(HttpServletRequest request,
			HttpSession session,HttpServletResponse response){
		int schoolId = Integer.parseInt(request.getParameter("school_id"));
		List<CardCoachView> result = dataExportingService.exportCard_Coach(schoolId);
		return result;
	}
	
	
}
