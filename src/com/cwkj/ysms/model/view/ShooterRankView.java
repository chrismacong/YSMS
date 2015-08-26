package com.cwkj.ysms.model.view;

public class ShooterRankView {
	public int schoolId;
	public String schoolName;
	public int athleteId;
	public String athleteName;
	public int goalCount;//进球数（包括点球）
	public int penaltyCount;//球点球进球数
	public int getPenaltyCount() {
		return penaltyCount;
	}
	public void setPenaltyCount(int penaltyCount) {
		this.penaltyCount = penaltyCount;
	}
	public int getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getAthleteName() {
		return athleteName;
	}
	public void setAthleteName(String athleteName) {
		this.athleteName = athleteName;
	}
	public int getGoalCount() {
		return goalCount;
	}
	public void setGoalCount(int goalCount) {
		this.goalCount = goalCount;
	}
	public int getAthleteId() {
		return athleteId;
	}
	public void setAthleteId(int athleteId) {
		this.athleteId = athleteId;
	}
}
