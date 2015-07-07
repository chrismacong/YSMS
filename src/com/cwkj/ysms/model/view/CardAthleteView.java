package com.cwkj.ysms.model.view;

public class CardAthleteView {
	private int athleteId; // 主键ID
	private String name; //姓名
	private String gender; //性别
	private String nation; //民族
	private String school; //学校名
	private String schoolNum; //学籍号
	private String registerNum; // 注册号
	private String identifiedNum; //身份证号
	private String phone; // 监护人号码
	private String photoBase64; // base64图片
	public int getAthleteId() {
		return athleteId;
	}
	public void setAthleteId(int athleteId) {
		this.athleteId = athleteId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getSchoolNum() {
		return schoolNum;
	}
	public void setSchoolNum(String schoolNum) {
		this.schoolNum = schoolNum;
	}
	public String getRegisterNum() {
		return registerNum;
	}
	public void setRegisterNum(String registerNum) {
		this.registerNum = registerNum;
	}
	public String getIdentifiedNum() {
		return identifiedNum;
	}
	public void setIdentifiedNum(String identifiedNum) {
		this.identifiedNum = identifiedNum;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPhotoBase64() {
		return photoBase64;
	}
	public void setPhotoBase64(String photoBase64) {
		this.photoBase64 = photoBase64;
	}
}
