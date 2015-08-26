package com.cwkj.ysms.model.view;

public class SuspensionView {
	public String playerName;//停赛运动员姓名
	public String suspensionReason;//停赛原因
	public String playerNum;//球衣号码
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public String getSuspensionReason() {
		return suspensionReason;
	}
	public void setSuspensionReason(String suspensionReason) {
		this.suspensionReason = suspensionReason;
	}
	public String getPlayerNum() {
		return playerNum;
	}
	public void setPlayerNum(String playerNum) {
		this.playerNum = playerNum;
	}
}
