package com.cwkj.ysms.test.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cwkj.ysms.model.YsmsTeam;
import com.cwkj.ysms.model.view.ExcelAthleteView;
import com.cwkj.ysms.model.view.ExcelCoachView;
import com.cwkj.ysms.service.DataExportingService;
import com.cwkj.ysms.service.TeamManagementService;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations="file:WebContent/WEB-INF/springMVC-servlet.xml") 
public class DataExportingServiceTest {

	@Autowired
	private TeamManagementService teamManagementService;
	
	@Autowired
	private DataExportingService dataExportingService;
	
//	@Test
//	public void testExportAthlete(){
//		String path = this.getClass().getResource("/")+"downloadResource\\athletesForm\\运动员导出测试用.xls";
//		path = path.substring(6, path.length());
//		String leagueName = "测试联赛名称";
//		String leagueLevel = "初中组";
//		int teamId = 3;
//		YsmsTeam ysmsTeam = teamManagementService.getTeamById(teamId);
//		String schoolName = ysmsTeam.getYsmsSchool().getSchoolName();
//		String teamName = ysmsTeam.getTeamName();
//		List<ExcelAthleteView> athleteViews = teamManagementService.getAthletesForTeam(teamId);
//		List<ExcelCoachView> coachViews = teamManagementService.getCoachsForTeam(teamId);
//		String result = dataExportingService.exportAthletesForm(path, leagueName, leagueLevel,
//				schoolName, teamName, "王苏", athleteViews, coachViews);
//		if(result != null){
//			System.out.println(result);
//		}else{
//			System.out.println("Excel导出异常！");
//		}
//	}
	
//	@Test
//	public void testLetExcelIntoWord(){
//		String path = this.getClass().getResource("/")+"downloadResource\\athletesForm\\运动员导出测试用.doc";
//		path = path.substring(6, path.length());
//		String leagueName = "测试联赛名称";
//		String leagueLevel = "小学组";
//		int teamId = 3;
//		YsmsTeam ysmsTeam = teamManagementService.getTeamById(teamId);
//		String schoolName = ysmsTeam.getYsmsSchool().getSchoolName();
//		String teamName = ysmsTeam.getTeamName();
//		List<ExcelAthleteView> athleteViews = teamManagementService.getAthletesForTeam(teamId);
//		List<ExcelCoachView> coachViews = teamManagementService.getCoachsForTeam(teamId);
//		String result = dataExportingService.letExcelIntoWord(path, leagueName, leagueLevel,
//				schoolName, teamName, "王苏", athleteViews, coachViews);
//		if(result != null){
//			System.out.println(result);
//		}else{
//			System.out.println("Excel嵌入Word导出异常！");
//		}
//	}
	
//	@Test
//	public void testLetExcelIntoPdf(){
//		String path = this.getClass().getResource("/")+"downloadResource\\athletesForm\\运动员导出测试用.pdf";
//		path = path.substring(6, path.length());
//		String leagueName = "测试联赛名称";
//		String leagueLevel = "小学组";
//		int teamId = 3;
//		YsmsTeam ysmsTeam = teamManagementService.getTeamById(teamId);
//		String schoolName = ysmsTeam.getYsmsSchool().getSchoolName();
//		String teamName = ysmsTeam.getTeamName();
//		List<ExcelAthleteView> athleteViews = teamManagementService.getAthletesForTeam(teamId);
//		List<ExcelCoachView> coachViews = teamManagementService.getCoachsForTeam(teamId);
//		String result = dataExportingService.letExcelIntoPDF(path, leagueName, leagueLevel,
//				schoolName, teamName, "王苏", athleteViews, coachViews);
//		if(result != null){
//			System.out.println(result);
//		}else{
//			System.out.println("Excel嵌入PDF导出异常！");
//		}
//	}
}
