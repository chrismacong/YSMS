package com.cwkj.ysms.model.view;

public class JudgeView {
	public int judgeId;
	public String judgeName;
	public int[] levels;
	public int getJudgeId() {
		return judgeId;
	}
	public void setJudgeId(int judgeId) {
		this.judgeId = judgeId;
	}
	public String getJudgeName() {
		return judgeName;
	}
	public void setJudgeName(String judgeName) {
		this.judgeName = judgeName;
	}
	public int[] getLevels() {
		return levels;
	}
	public void setLevels(int[] levels) {
		this.levels = levels;
	}
}
