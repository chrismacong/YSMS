package com.cwkj.ysms.test.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cwkj.ysms.model.YsmsGames;
import com.cwkj.ysms.model.YsmsLeague;
import com.cwkj.ysms.model.YsmsLeagueZone;
import com.cwkj.ysms.service.GamesStatisticsService;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations="file:WebContent/WEB-INF/springMVC-servlet.xml") 
public class GamesStatisticsServiceTest {
	@Autowired
	private GamesStatisticsService gamesStatisticsService;
	
	@Test
	public void testGetAthleteGoalsInZone(){
		int result =  gamesStatisticsService.getAthleteGoalsInZone(1, 1);
		System.out.println("the athlete has " + result + " goals in the game");
	}
	
	@Test
	public void testGetAthleteAssistsInZone(){
		int result = gamesStatisticsService.getAthleteAssistsInZone(1, 1);
		System.out.println("the athlete has " + result + " assistants in the game");
	}
	
	@Test
	public void testGetAthletePresentation(){
		List<YsmsLeagueZone> leagueZoneList = gamesStatisticsService.getAthletePresentation(1);
		for (int i = 0; i < leagueZoneList.size(); i++) {
			System.out.println(leagueZoneList.get(i).getYsmsLeague().getLeagueName());
		}
	}
	
	@Test
	public void testGetCoachPresentation(){
		List<YsmsLeagueZone> leagueZoneList = gamesStatisticsService.getCoachPresentation(1);
		for (int i = 0; i < leagueZoneList.size(); i++) {
			System.out.println(leagueZoneList.get(i).getZoneName());
		}
	}
	
	@Test
	public void testGetTeamYellowCardsInZone(){
		int result = gamesStatisticsService.getTeamYellowCardsInZone(1);
		System.out.println("the team has " + result + " yellowCards in this league");
	}
	
	@Test
	public void testGetTeamRedCardsInZone(){
		int result = gamesStatisticsService.getTeamRedCardsInZone(1);
		System.out.println("the team has " + result + " redCards in this league");
	}
	
	@Test
	public void testGetCoachWinningPercentage(){
		double result[] = gamesStatisticsService.getCoachWinningPercentage(1);
		for(int i=0;i<result.length;i++)
			System.out.println(result[i]);
	}
	
	@Test
	public void testgGetTeamGoalsInZone(){
		int result = gamesStatisticsService.getTeamGoalsInZone(1);
		System.out.println(result);
	}
	
	@Test
	public void testGetTotalWinningPercentageBySchool(){
		double result[] = gamesStatisticsService.getTotalWinningPercentageBySchool(2);
		for(int i=0;i<result.length;i++)
			System.out.println(result[i]);
	}
	
	@Test
	public void testGetJudgePresentation(){
		List<YsmsLeagueZone> ysmsLeague_list = gamesStatisticsService.getJudgePresentation(4);
		System.out.println(ysmsLeague_list.get(0));
	}
	
	@Test
	public void testGetJudgeGamesInZone(){
		List<YsmsGames> ysmsGames_list = gamesStatisticsService.getJudgeGamesInZone(1, 1);
		System.out.println(ysmsGames_list.get(0).getGameLocation());
	}
}
