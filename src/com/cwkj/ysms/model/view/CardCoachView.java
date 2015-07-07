package com.cwkj.ysms.model.view;

public class CardCoachView {
	private int coachId; //数据库主键Id
	private String name; //姓名
	private String gender; //性别
	private String nation; //民族
	private String school; //学校名
	private String identifiedNum; //身份证号
	private String phone; //电话号码
	private String certificate; //证书
	private String photoBase64; //base64图片
	public int getCoachId() {
		return coachId;
	}
	public void setCoachId(int coachId) {
		this.coachId = coachId;
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
	public String getCertificate() {
		return certificate;
	}
	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}
	public String getPhotoBase64() {
		return photoBase64;
	}
	public void setPhotoBase64(String photoBase64) {
		this.photoBase64 = photoBase64;
	}
}
