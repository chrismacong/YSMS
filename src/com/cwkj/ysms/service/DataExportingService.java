package com.cwkj.ysms.service;

import java.io.OutputStream;
import java.util.List;

import com.cwkj.ysms.model.YsmsSchool;
import com.cwkj.ysms.model.view.CardAthleteView;
import com.cwkj.ysms.model.view.CardCoachView;
import com.cwkj.ysms.model.view.CardSchoolView;
import com.cwkj.ysms.model.view.ExcelAthleteView;
import com.cwkj.ysms.model.view.ExcelCoachView;

/**
 * 数据库数据导出功能,导出相应data表中数据
 * @author zhangjiyao
 * @since 2015-3-12
 */
public interface DataExportingService {

	/**
	 * 导出Excel
	 * @param path
	 * @param leagueName
	 * @param leagueLevel
	 * @param schoolName
	 * @param teamName
	 * @param athleteViews
	 * @param coachViews
	 * @return
	 */
	public void exportAthletesForm(OutputStream stream ,String leagueName ,
			String leagueLevel ,YsmsSchool ysmsSchool ,String teamName ,String leaderName ,
			String leaderPhone, String doctorName, String doctorPhone, 
			List<ExcelAthleteView> athleteViews,
			List<ExcelCoachView> coachViews);
	
	/**
	 * 导出word
	 * @param path
	 * @param leagueName
	 * @param leagueLevel
	 * @param schoolName
	 * @param teamName
	 * @param athleteViews
	 * @param coachViews
	 * @return
	 */
	public void letExcelIntoWord(OutputStream stream ,String leagueName ,
			String leagueLevel ,YsmsSchool ysmsSchool ,String teamName ,String leaderName, 
			String leaderPhone, String doctorName, String doctorPhone, 
			List<ExcelAthleteView> athleteViews,
			List<ExcelCoachView> coachViews);
	
	/**
	 * 导出pdf
	 * @param path
	 * @param leagueName
	 * @param leagueLevel
	 * @param schoolName
	 * @param teamName
	 * @param athleteViews
	 * @param coachViews
	 * @return
	 */
	public void letExcelIntoPDF(OutputStream stream ,String leagueName ,
			String leagueLevel ,YsmsSchool ysmsSchool ,String teamName ,String leaderName ,
			String leaderPhone, String doctorName, String doctorPhone, 
			List<ExcelAthleteView> athleteViews,
			List<ExcelCoachView> coachViews);
	
	/**
	 * 制卡-获取学校列表
	 * @return
	 */
	public List<CardSchoolView> exportCard_School();
	
	/**
	 * 制卡-获取运动员列表
	 * @param schoolId
	 * @return
	 */
	public List<CardAthleteView> exportCard_Athlete(int schoolId);
	/**
	 * 找带金字儿的
	 * @return
	 */
	public List<CardAthleteView> exportCard_AthleteJin();
	
	/**
	 * 制卡-获取教练员列表
	 * @param schoolId
	 * @return
	 */
	public List<CardCoachView> exportCard_Coach(int schoolId);
}
