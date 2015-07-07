package com.cwkj.ysms.model.view;

import java.util.Date;

import com.cwkj.ysms.model.YsmsCoach;

public class CoachView {
	// Fields
	private Integer coachId;
	private Integer schoolId;
	private String schoolName;
	private String identifiedId;
	private String identifiedName;
	private Integer identifiedGender;
	private Date identifiedBirthday;
	private String identifiedAddress;
	private String identifiedNationality;
	private String coachMobile;
	private Integer deleteflag;
	private Boolean schoolcoachFlag;
	private Integer coachLevel;
	private String coachJob;

	/** default constructor */
	public CoachView() {
	}

	/** minimal constructor */
	public CoachView(Integer coachId, Integer schoolId, String schoolName,
			String identifiedId, String identifiedName,
			Integer identifiedGender, Date identifiedBirthday) {
		this.coachId = coachId;
		this.schoolId = schoolId;
		this.schoolName = schoolName;
		this.identifiedId = identifiedId;
		this.identifiedName = identifiedName;
		this.identifiedGender = identifiedGender;
		this.identifiedBirthday = identifiedBirthday;
	}

	/** full constructor */
	public CoachView(Integer coachId, Integer schoolId, String schoolName,
			String identifiedId, String coachMobile, String identifiedName,
			Integer identifiedGender, Date identifiedBirthday,
			String identifiedAddress, String identifiedNationality,
			Integer deleteflag) {
		this.coachId = coachId;
		this.schoolId = schoolId;
		this.schoolName = schoolName;
		this.identifiedId = identifiedId;
		this.coachMobile = coachMobile;
		this.identifiedName = identifiedName;
		this.identifiedGender = identifiedGender;
		this.identifiedBirthday = identifiedBirthday;
		this.identifiedAddress = identifiedAddress;
		this.identifiedNationality = identifiedNationality;
		this.deleteflag = deleteflag;
	}

	public CoachView(YsmsCoach coach) {
		this.coachId=coach.getCoachId();
		this.schoolId=coach.getYsmsSchool().getSchoolId();
		this.schoolName=coach.getYsmsSchool().getSchoolName();
		this.identifiedId=coach.getIdentifiedId();
		this.identifiedName=coach.getIdentifiedName();
		this.identifiedGender=coach.getIdentifiedGender();
		this.identifiedBirthday=coach.getIdentifiedBirthday();
		this.identifiedAddress=coach.getIdentifiedAddress();
		this.identifiedNationality=coach.getIdentifiedNationality();
		this.coachMobile=coach.getCoachMobile();
		this.deleteflag=coach.getDeleteflag();
		this.schoolcoachFlag=coach.getSchoolcoachFlag();
		this.coachLevel=coach.getCoachLevel();
		this.coachJob = coach.getYsmsJobs().getJobName();
	}

	public String getCoachJob() {
		return coachJob;
	}

	public void setCoachJob(String coachJob) {
		this.coachJob = coachJob;
	}

	public Boolean getSchoolcoachFlag() {
		return schoolcoachFlag;
	}

	public void setSchoolcoachFlag(Boolean schoolcoachFlag) {
		this.schoolcoachFlag = schoolcoachFlag;
	}

	public Integer getCoachLevel() {
		return coachLevel;
	}

	public void setCoachLevel(Integer coachLevel) {
		this.coachLevel = coachLevel;
	}

	public Integer getCoachId() {
		return coachId;
	}

	public void setCoachId(Integer coachId) {
		this.coachId = coachId;
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

	public String getCoachMobile() {
		return coachMobile;
	}

	public void setCoachMobile(String coachMobile) {
		this.coachMobile = coachMobile;
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
}