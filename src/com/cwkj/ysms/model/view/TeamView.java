package com.cwkj.ysms.model.view;

public class TeamView {
	private int teamId;
	private String teamName;
	private String schoolName;
	private int schoolCategory;
	public int getSchoolCategory() {
		return schoolCategory;
	}
	public void setSchoolCategory(int schoolCategory) {
		this.schoolCategory = schoolCategory;
	}
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
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
}
