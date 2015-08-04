package com.cwkj.ysms.model.view;

public class UserGroupView {
	public int groupId;
	public String groupName;
	public String functionStr;
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getFunctionStr() {
		return functionStr;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public void setFunctionStr(String functionStr) {
		this.functionStr = functionStr;
	}
}
