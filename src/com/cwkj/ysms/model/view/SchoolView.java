package com.cwkj.ysms.model.view;

/**
 * 学校对象
 * @author chrismacong
 *
 */
public class SchoolView {
	public int schoolId;
	public String schoolName;
	public String schoolCategory;
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
	public String getSchoolCategory() {
		return schoolCategory;
	}
	public void setSchoolCategory(String schoolCategory) {
		this.schoolCategory = schoolCategory;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String username;
}
