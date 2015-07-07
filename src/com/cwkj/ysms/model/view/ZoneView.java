package com.cwkj.ysms.model.view;

import java.util.List;

import com.cwkj.ysms.model.YsmsLeagueLevel;

public class ZoneView {
	public int zoneId;
	public String zoneName;
	public List<YsmsLeagueLevel> levels;
	public String levelStr;
	public boolean[] levelArray;
	public boolean[] getLevelArray() {
		return levelArray;
	}
	public void setLevelArray(boolean[] levelArray) {
		this.levelArray = levelArray;
	}
	public String getLevelStr() {
		return levelStr;
	}
	public void setLevelStr(String levelStr) {
		this.levelStr = levelStr;
	}
	public int registeredZoneTeamCount;
	public int getRegisteredZoneTeamCount() {
		return registeredZoneTeamCount;
	}
	public void setRegisteredZoneTeamCount(int registeredZoneTeamCount) {
		this.registeredZoneTeamCount = registeredZoneTeamCount;
	}
	public int getZoneId() {
		return zoneId;
	}
	public void setZoneId(int zoneId) {
		this.zoneId = zoneId;
	}
	public String getZoneName() {
		return zoneName;
	}
	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}
	public List<YsmsLeagueLevel> getLevels() {
		return levels;
	}
	public void setLevels(List<YsmsLeagueLevel> levels) {
		this.levels = levels;
	}
	/**
	 * 该组别的可参加状态
	 * 0 --- 可报名。
	 * 1 --- 不可报名，不包含该级别所包含的年级
	 * 2 --- 已完成报名
	 */
	public int zoneStatus;
	public int getZoneStatus() {
		return zoneStatus;
	}
	public void setZoneStatus(int zoneStatus) {
		this.zoneStatus = zoneStatus;
	}
}
