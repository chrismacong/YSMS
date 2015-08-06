package com.cwkj.ysms.test.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cwkj.ysms.model.YsmsGames;
import com.cwkj.ysms.model.view.FoulView;
import com.cwkj.ysms.model.view.GoalView;
import com.cwkj.ysms.service.GamesManagementService;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations="file:WebContent/WEB-INF/springMVC-servlet.xml") 
public class GamesServiceTest {
	@Autowired
	private GamesManagementService gamesManagementService;
	@Test
	public void testgetGamesInfo(){
		System.out.println(gamesManagementService.getGamesInfo(2));
	}
	@Test
	public void testupdateGamesInfo(){
		String testTime = "2015-04-20 00:00:00";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			int gamesId = 5;
			Date gamesTime = sdf.parse(testTime);
			String gamesLocation = "Highbury Statium";
			int chief = 4;
			int side1 = 6;
			int side2 = 4;
			int forth = 4;
			int officer1 = 6;
			int officer2 = 6;
			int recorder1 = 4;
			int recorder2 = 4;
			System.out.println(gamesManagementService.updateGamesInfo(gamesId, gamesTime, gamesLocation, chief, side1, side2, forth, officer1, officer2, recorder1, recorder2));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	public void testreplyGamesInfo(){
		int hostScore = 2;
		int guestScore = 3;

		System.out.println(gamesManagementService.replyGamesInfo(614, hostScore, guestScore, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null));
	}
	@Test
	public void testaddGoalInfo(){
		int gamesId = 2;
		int shooterId = 1;
		int assistId = 2;
		String goalTime = "89min29s";
		int goalType = 0;
		System.out.println(gamesManagementService.addGoalInfo(gamesId, shooterId, assistId, goalTime, goalType));
	}
	@Test
	public void testmodifyGoalInfo(){
		int goalId = 3;
		int shooterId = 2;
		int assistId = 1;
		String goalTime = "59min29s";
		int goalType = 0;
		System.out.println(gamesManagementService.modifyGoalInfo(goalId, shooterId, assistId, goalTime, goalType));
	}
	@Test
	public void testdeleteGoal(){
		int goalId = 2;
		System.out.println(gamesManagementService.deleteGoalInfo(goalId));
	}
	@Test
	public void testaddFoulInfo(){
		int gamesId = 2;
		int foulPlayerId = 1;
		int foulLevel = 1;
		String timeStr = "89min";
		System.out.println(gamesManagementService.addFoulInfo(gamesId, foulPlayerId, foulLevel, timeStr));
	}
	@Test
	public void testmodifyFoulInfo(){
		int foulId = 2;
		int gamesId = 2;
		int foulPlayerId = 1;
		int foulLevel = 2;
		String timeStr = "49min";
		System.out.println(gamesManagementService.modifyFoulInfo(foulId, gamesId, foulPlayerId, foulLevel, timeStr));
	}
	@Test
	public void testdeleteFoulInfo(){
		int foulId = 2;
		System.out.println(gamesManagementService.deleteFoulInfo(foulId));
	}
	@Test
	public void testgetGamesByTeam(){
		int teamId = 1;
		List<YsmsGames> gamesList = gamesManagementService.getGamesByTeam(teamId);
		for(int i=0;i<gamesList.size();i++){
			System.out.print(gamesList.get(i).getGamesId() + "    ");
			System.out.print(gamesList.get(i).getGamesTime() + "    ");
			System.out.println(gamesList.get(i).getYsmsTeamByHostTeamid().getTeamName() + " VS. " + 
					gamesList.get(i).getYsmsTeamByGuestTeamid().getTeamName());
		}
	}
	@Test
	public void testgetGamesThisMonthByTeam(){
		int teamId = 1;
		List<YsmsGames> gamesList = gamesManagementService.getGamesThisMonthByTeam(teamId);
		for(int i=0;i<gamesList.size();i++){
			System.out.print(gamesList.get(i).getGamesId() + "    ");
			System.out.print(gamesList.get(i).getGamesTime() + "    ");
			System.out.println(gamesList.get(i).getYsmsTeamByHostTeamid().getTeamName() + " VS. " + 
					gamesList.get(i).getYsmsTeamByGuestTeamid().getTeamName());
		}
	}
	@Test
	public void testgetNextGameByTeam(){
		int teamId = 1;
		System.out.println(gamesManagementService.getNextGameByTeam(teamId).getGameLocation());
	}
	@Test
	public void testgetLastGameByTeam(){
		int teamId = 2;
		System.out.println(gamesManagementService.getLastGameByTeam(teamId).getGameLocation());
	}
	@Test
	public void testgetGamesByDate(){
		String testTime = "2015-4-20 00:00:00";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date gamesDate = sdf.parse(testTime);
			System.out.println(gamesManagementService.getGamesByDate(gamesDate).size());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testgetGamesByLeague(){
		int zoneId = 1;
		System.out.println(gamesManagementService.getGamesByZone(zoneId).size());
	}
	@Test
	public void testgetGamesByLeagueAndDate(){
		int zoneId = 1;
		String testTime = "2015-03-13 00:00:00";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date gamesDate = sdf.parse(testTime);
			System.out.println(gamesManagementService.getGamesByZoneAndDate(zoneId, gamesDate).get(0));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetTeamGoalsInGame(){
		List<GoalView> hostGoals = gamesManagementService.getTeamGoalsInGame(5, 2);
		List<GoalView> guestGoals = gamesManagementService.getTeamGoalsInGame(5, 3);
		System.out.println("主队得分：" + hostGoals.size() + " 客队得分：" + guestGoals.size());
	}
	
	@Test
	public void testGetTeamFoalsInGame(){
		List<FoulView> hostFouls = gamesManagementService.getTeamFoulInGame(5, 2);
		List<FoulView> guestFouls = gamesManagementService.getTeamFoulInGame(5, 3);
		System.out.println("主队犯规：" + hostFouls.size() + " 客队犯规：" + guestFouls.size());
	}
}
