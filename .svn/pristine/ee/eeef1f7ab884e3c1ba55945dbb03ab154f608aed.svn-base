package com.cwkj.ysms.model.view;

import java.util.Date;

import com.cwkj.ysms.model.YsmsAthlete;

public class AthleteView {

	// Fields

	private Integer athleteId; // 主键，运动员id

	private Integer schoolId; // 学校编号id
	private String schoolName; // 学校名称

	private String identifiedId;// 身份证号
	private Integer athleteFootsize;// 鞋码
	private Integer athleteHeight;// 身高
	private Integer athleteWeight;// 体重
	private Integer athletePosition;// 司职位置
	private String identifiedName;// 姓名
	private Integer identifiedGender;// 性别，男为1，女为0
	private Date identifiedBirthday;// 生日
	private String identifiedAddress;// 地址
	private String identifiedNationality;// 民族
	private Integer deleteflag;// 是否删除的flag，删除为1，不删除为0

	private String athleteMobile;
	private String athleteGuardian1; // 监护人1
	private String guardian1Mobile; // 监护人联系方式
	private String athleteGuardian2;
	private String guardian2Mobile;
	private int ysmsDiplomaByGuardian1DiplomaId;
	private String ysmsDiplomaByGrardian1DiplomaidName;
	private int ysmsDiplomaByGuardian2DiplomaId;
	private String ysmsDiplomaByGrardian2DiplomaidName;
	private int ysmsJobsByGuardian1JobId;
	private String ysmsJobsByGuardian1JobString;
	private int ysmsJobsByGuardian2JobId;
	private String ysmsJobsByGuardian2JobString;

	private String studentId;// 学籍id
	private String athleteSchoolyear;// 入学年份，根据身份证号上的生日判断，以9月1号为中间线
	//已经由athleteMobile替代
	//private String athletePhone;// 学生联系方式

	private String athleteCoach;

	private String register_id;

	/** default constructor */
	public AthleteView() {
	}

	/** full constructor */
	public AthleteView(
			Integer athleteId,
			Integer schoolId,
			String schoolName,
			String identifiedId,
			Integer athleteFootsize,
			Integer athleteHeight,
			Integer athleteWeight,
			Integer athletePosition,
			String identifiedName,
			Integer identifiedGender,
			Date identifiedBirthday,
			String identifiedAddress,
			String identifiedNationality,
			Integer deleteflag,
			String studentId,
			String athleteSchoolyear,
			String athleteMobile,
			String athleteGuardian1,// 监护人1
			String guardian1Mobile, // 监护人联系方式
			String athleteGuardian2, String guardian2Mobile,
			int ysmsDiplomaByGuardian1DiplomaId,
			String ysmsDiplomaByGrardian1DiplomaidName,
			int ysmsDiplomaByGuardian2DiplomaId,
			String ysmsDiplomaByGrardian2DiplomaidName,
			int ysmsJobsByGuardian1JobId, String ysmsJobsByGuardian1JobString,
			int ysmsJobsByGuardian2JobId, String ysmsJobsByGuardian2JobString,
			String athleteCoach, String register_id) {
		this.athleteId = athleteId;
		this.schoolId = schoolId;
		this.schoolName = schoolName;
		this.identifiedId = identifiedId;
		this.athleteFootsize = athleteFootsize;
		this.athleteHeight = athleteHeight;
		this.athleteWeight = athleteWeight;
		this.athletePosition = athletePosition;
		this.identifiedName = identifiedName;
		this.identifiedGender = identifiedGender;
		this.identifiedBirthday = identifiedBirthday;
		this.identifiedAddress = identifiedAddress;
		this.identifiedNationality = identifiedNationality;
		this.deleteflag = deleteflag;
		this.athleteSchoolyear = athleteSchoolyear;
		this.studentId = studentId;
		this.athleteMobile = athleteMobile;

		this.athleteGuardian1 = athleteGuardian1;
		this.guardian1Mobile = guardian1Mobile;
		this.athleteGuardian2 = athleteGuardian2;
		this.guardian2Mobile = guardian2Mobile;
		this.ysmsDiplomaByGuardian1DiplomaId = ysmsDiplomaByGuardian1DiplomaId;
		this.ysmsDiplomaByGrardian1DiplomaidName = ysmsDiplomaByGrardian1DiplomaidName;
		this.ysmsDiplomaByGuardian2DiplomaId = ysmsDiplomaByGuardian2DiplomaId;
		this.ysmsDiplomaByGrardian2DiplomaidName = ysmsDiplomaByGrardian2DiplomaidName;
		this.ysmsJobsByGuardian1JobId = ysmsJobsByGuardian1JobId;
		this.ysmsJobsByGuardian1JobString = ysmsJobsByGuardian1JobString;
		this.ysmsJobsByGuardian2JobId = ysmsJobsByGuardian2JobId;
		this.ysmsJobsByGuardian2JobString = ysmsJobsByGuardian2JobString;

		this.athleteCoach = athleteCoach;
		this.register_id = register_id;
	}

	public AthleteView(YsmsAthlete athlete) {
		this.athleteId = athlete.getAthleteId();
		if (athlete.getYsmsSchool() != null) {
			this.schoolId = athlete.getYsmsSchool().getSchoolId();
			this.schoolName = athlete.getYsmsSchool().getSchoolName();
		}
		this.identifiedId = athlete.getIdentifiedId();
		this.athleteFootsize = athlete.getAthleteFootsize();
		this.athleteHeight = athlete.getAthleteHeight();
		this.athleteWeight = athlete.getAthleteWeight();
		this.athletePosition = athlete.getAthletePosition();
		this.identifiedName = athlete.getIdentifiedName();
		this.identifiedGender = athlete.getIdentifiedGender();
		this.identifiedBirthday = athlete.getIdentifiedBirthday();
		this.identifiedAddress = athlete.getIdentifiedAddress();
		this.identifiedNationality = athlete.getIdentifiedNationality();
		this.deleteflag = athlete.getDeleteflag();
		this.athleteSchoolyear = athlete.getAthleteSchoolyear();
		this.studentId = athlete.getStudentId();
		this.athleteMobile = athlete.getAthleteMobile();

		this.athleteGuardian1 = athlete.getAthleteGuardian1();
		this.guardian1Mobile = athlete.getGuardian1Mobile();
		this.athleteGuardian2 = athlete.getAthleteGuardian2();
		this.guardian2Mobile = athlete.getGuardian2Mobile();
		if (athlete.getYsmsDiplomaByGuardian1Diploma() != null) {
			this.ysmsDiplomaByGuardian1DiplomaId = athlete
					.getYsmsDiplomaByGuardian1Diploma().getDiplomaId();
			this.ysmsDiplomaByGrardian1DiplomaidName = athlete
					.getYsmsDiplomaByGuardian1Diploma().getDiplomaName();
		}
		if (athlete.getYsmsDiplomaByGuardian2Diploma() != null) {
			this.ysmsDiplomaByGuardian2DiplomaId = athlete
					.getYsmsDiplomaByGuardian2Diploma().getDiplomaId();
			this.ysmsDiplomaByGrardian2DiplomaidName = athlete
					.getYsmsDiplomaByGuardian2Diploma().getDiplomaName();
		}
		if (athlete.getYsmsJobsByGuardian1Job() != null) {
			this.ysmsJobsByGuardian1JobId = athlete.getYsmsJobsByGuardian1Job()
					.getJobId();
			this.ysmsJobsByGuardian1JobString = athlete
					.getYsmsJobsByGuardian1Job().getJobName();
		}
		if (athlete.getYsmsJobsByGuardian2Job() != null) {
			this.ysmsJobsByGuardian2JobId = athlete.getYsmsJobsByGuardian2Job()
					.getJobId();
			this.ysmsJobsByGuardian2JobString = athlete
					.getYsmsJobsByGuardian2Job().getJobName();
		}
		this.athleteCoach = athlete.getAthleteCoach();
		this.register_id = athlete.getRegister_id();
	}

	public Integer getAthleteId() {
		return athleteId;
	}

	public void setAthleteId(Integer athleteId) {
		this.athleteId = athleteId;
	}

	public Integer getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getIdentifiedId() {
		return identifiedId;
	}

	public void setIdentifiedId(String identifiedId) {
		this.identifiedId = identifiedId;
	}

	public Integer getAthleteFootsize() {
		return athleteFootsize;
	}

	public void setAthleteFootsize(Integer athleteFootsize) {
		this.athleteFootsize = athleteFootsize;
	}

	public Integer getAthleteHeight() {
		return athleteHeight;
	}

	public void setAthleteHeight(Integer athleteHeight) {
		this.athleteHeight = athleteHeight;
	}

	public Integer getAthleteWeight() {
		return athleteWeight;
	}

	public void setAthleteWeight(Integer athleteWeight) {
		this.athleteWeight = athleteWeight;
	}

	public Integer getAthletePosition() {
		return athletePosition;
	}

	public void setAthletePosition(Integer athletePosition) {
		this.athletePosition = athletePosition;
	}

	public String getIdentifiedName() {
		return identifiedName;
	}

	public void setIdentifiedName(String identifiedName) {
		this.identifiedName = identifiedName;
	}

	public Integer getIdentifiedGender() {
		return identifiedGender;
	}

	public void setIdentifiedGender(Integer identifiedGender) {
		this.identifiedGender = identifiedGender;
	}

	public Date getIdentifiedBirthday() {
		return identifiedBirthday;
	}

	public void setIdentifiedBirthday(Date identifiedBirthday) {
		this.identifiedBirthday = identifiedBirthday;
	}

	public String getIdentifiedAddress() {
		return identifiedAddress;
	}

	public void setIdentifiedAddress(String identifiedAddress) {
		this.identifiedAddress = identifiedAddress;
	}

	public String getIdentifiedNationality() {
		return identifiedNationality;
	}

	public void setIdentifiedNationality(String identifiedNationality) {
		this.identifiedNationality = identifiedNationality;
	}

	public Integer getDeleteflag() {
		return deleteflag;
	}

	public void setDeleteflag(Integer deleteflag) {
		this.deleteflag = deleteflag;
	}

	public String getAthleteGuardian1() {
		return athleteGuardian1;
	}

	public void setAthleteGuardian1(String athleteGuardian1) {
		this.athleteGuardian1 = athleteGuardian1;
	}

	public String getGuardian1Mobile() {
		return guardian1Mobile;
	}

	public void setGuardian1Mobile(String guardian1Mobile) {
		this.guardian1Mobile = guardian1Mobile;
	}

	public String getAthleteGuardian2() {
		return athleteGuardian2;
	}

	public void setAthleteGuardian2(String athleteGuardian2) {
		this.athleteGuardian2 = athleteGuardian2;
	}

	public String getGuardian2Mobile() {
		return guardian2Mobile;
	}

	public void setGuardian2Mobile(String guardian2Mobile) {
		this.guardian2Mobile = guardian2Mobile;
	}

	public int getYsmsDiplomaByGuardian1DiplomaId() {
		return ysmsDiplomaByGuardian1DiplomaId;
	}

	public void setYsmsDiplomaByGuardian1DiplomaId(
			int ysmsDiplomaByGuardian1DiplomaId) {
		this.ysmsDiplomaByGuardian1DiplomaId = ysmsDiplomaByGuardian1DiplomaId;
	}

	public String getYsmsDiplomaByGrardian1DiplomaidName() {
		return ysmsDiplomaByGrardian1DiplomaidName;
	}

	public void setYsmsDiplomaByGrardian1DiplomaidName(
			String ysmsDiplomaByGrardian1DiplomaidName) {
		this.ysmsDiplomaByGrardian1DiplomaidName = ysmsDiplomaByGrardian1DiplomaidName;
	}

	public int getYsmsDiplomaByGuardian2DiplomaId() {
		return ysmsDiplomaByGuardian2DiplomaId;
	}

	public void setYsmsDiplomaByGuardian2DiplomaId(
			int ysmsDiplomaByGuardian2DiplomaId) {
		this.ysmsDiplomaByGuardian2DiplomaId = ysmsDiplomaByGuardian2DiplomaId;
	}

	public String getYsmsDiplomaByGrardian2DiplomaidName() {
		return ysmsDiplomaByGrardian2DiplomaidName;
	}

	public void setYsmsDiplomaByGrardian2DiplomaidName(
			String ysmsDiplomaByGrardian2DiplomaidName) {
		this.ysmsDiplomaByGrardian2DiplomaidName = ysmsDiplomaByGrardian2DiplomaidName;
	}

	public int getYsmsJobsByGuardian1JobId() {
		return ysmsJobsByGuardian1JobId;
	}

	public void setYsmsJobsByGuardian1JobId(int ysmsJobsByGuardian1JobId) {
		this.ysmsJobsByGuardian1JobId = ysmsJobsByGuardian1JobId;
	}

	public String getYsmsJobsByGuardian1JobString() {
		return ysmsJobsByGuardian1JobString;
	}

	public void setYsmsJobsByGuardian1JobString(
			String ysmsJobsByGuardian1JobString) {
		this.ysmsJobsByGuardian1JobString = ysmsJobsByGuardian1JobString;
	}

	public int getYsmsJobsByGuardian2JobId() {
		return ysmsJobsByGuardian2JobId;
	}

	public void setYsmsJobsByGuardian2JobId(int ysmsJobsByGuardian2JobId) {
		this.ysmsJobsByGuardian2JobId = ysmsJobsByGuardian2JobId;
	}

	public String getYsmsJobsByGuardian2JobString() {
		return ysmsJobsByGuardian2JobString;
	}

	public void setYsmsJobsByGuardian2JobString(
			String ysmsJobsByGuardian2JobString) {
		this.ysmsJobsByGuardian2JobString = ysmsJobsByGuardian2JobString;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getAthleteSchoolyear() {
		return athleteSchoolyear;
	}

	public void setAthleteSchoolyear(String athleteSchoolyear) {
		this.athleteSchoolyear = athleteSchoolyear;
	}

//	public String getAthletePhone() {
//		return athletePhone;
//	}
//
//	public void setAthletePhone(String athletePhone) {
//		this.athletePhone = athletePhone;
//	}

	public String getAthleteCoach() {
		return athleteCoach;
	}

	public void setAthleteCoach(String athleteCoach) {
		this.athleteCoach = athleteCoach;
	}

	public String getRegister_id() {
		return register_id;
	}

	public void setRegister_id(String register_id) {
		this.register_id = register_id;
	}

	public String getAthleteMobile() {
		return athleteMobile;
	}

	public void setAthleteMobile(String athleteMobile) {
		this.athleteMobile = athleteMobile;
	}

}