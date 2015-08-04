package com.cwkj.ysms.model.view;

import com.cwkj.ysms.model.YsmsTeam;

public class MarkItemView {
	public int teamId;//球队Id
	public String teamName;//球队名称
	public int winCount;
	public int drawCount;
	public int loseCount;
	public int yellowCardCount;
	public int redCardCount;
	public int getYellowCardCount() {
		return yellowCardCount;
	}
	public void setYellowCardCount(int yellowCardCount) {
		this.yellowCardCount = yellowCardCount;
	}
	public int getRedCardCount() {
		return redCardCount;
	}
	public void setRedCardCount(int redCardCount) {
		this.redCardCount = redCardCount;
	}
	public int getWinCount() {
		return winCount;
	}
	public void setWinCount(int winCount) {
		this.winCount = winCount;
	}
	public int getDrawCount() {
		return drawCount;
	}
	public void setDrawCount(int drawCount) {
		this.drawCount = drawCount;
	}
	public int getLoseCount() {
		return loseCount;
	}
	public void setLoseCount(int loseCount) {
		this.loseCount = loseCount;
	}
	public int goalNum;//进球
	public int fumbleNum;//失球
	public int GD;//净胜球
	public int mark;//积分
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public int getGoalNum() {
		return goalNum;
	}
	public void setGoalNum(int goalNum) {
		this.goalNum = goalNum;
	}
	public int getFumbleNum() {
		return fumbleNum;
	}
	public void setFumbleNum(int fumbleNum) {
		this.fumbleNum = fumbleNum;
	}
	public int getGD() {
		return GD;
	}
	public void setGD(int gD) {
		GD = gD;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	
	public YsmsTeam team;
	public YsmsTeam getTeam() {
		return team;
	}
	public void setTeam(YsmsTeam team) {
		this.team = team;
	}

}
