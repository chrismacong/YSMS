package com.cwkj.ysms.model.view;

import java.util.Date;

import com.cwkj.ysms.model.YsmsCoach;
import com.cwkj.ysms.model.YsmsCoachAtt;

public class CoachManagerListView {	
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
	private String coachPhone;
	private Integer deleteflag;
	private Boolean schoolcoachFlag;
	private Integer coachLevel;
	private int coachJob;
	
	private String identifiedImage;
	private String schoolCoachImgPath;
	private String coachLevelImgPath;
	
	
	public CoachManagerListView(YsmsCoach coach,YsmsCoachAtt ysmsCoachID,YsmsCoachAtt ysmsCoachSchool,YsmsCoachAtt ysmsCoachLeve) {
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
		this.coachPhone = coach.getCoachPhone();
		this.coachJob = coach.getYsmsJobs().getJobId();
		this.deleteflag=coach.getDeleteflag();
		this.schoolcoachFlag=coach.getSchoolcoachFlag();
		this.coachLevel=coach.getCoachLevel();
		
		if(ysmsCoachID!=null)
			this.identifiedImage=ysmsCoachID.getAttName();
		if(ysmsCoachSchool!=null)
		this.schoolCoachImgPath=ysmsCoachSchool.getAttName();
		if(ysmsCoachLeve!=null)
		this.coachLevelImgPath=ysmsCoachLeve.getAttName();
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


	public String getCoachPhone() {
		return coachPhone;
	}


	public void setCoachPhone(String coachPhone) {
		this.coachPhone = coachPhone;
	}


	public int getCoachJob() {
		return coachJob;
	}


	public void setCoachJob(int coachJob) {
		this.coachJob = coachJob;
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


	public String getCoachMobile() {
		return coachMobile;
	}


	public void setCoachMobile(String coachMobile) {
		this.coachMobile = coachMobile;
	}


	public Integer getDeleteflag() {
		return deleteflag;
	}


	public void setDeleteflag(Integer deleteflag) {
		this.deleteflag = deleteflag;
	}


	public Boolean getSchoolcoachFlag() {
		return schoolcoachFlag;
	}


	public void setSchoolcoachFlag(Boolean schoolcoachFlag) {
		this.schoolcoachFlag = schoolcoachFlag;
	}


	public String getSchoolCoachImgPath() {
		return schoolCoachImgPath;
	}


	public void setSchoolCoachImgPath(String schoolCoachImgPath) {
		this.schoolCoachImgPath = schoolCoachImgPath;
	}


	public Integer getCoachLevel() {
		return coachLevel;
	}


	public void setCoachLevel(Integer coachLevel) {
		this.coachLevel = coachLevel;
	}


	public String getCoachLevelImgPath() {
		return coachLevelImgPath;
	}


	public void setCoachLevelImgPath(String coachLevelImgPath) {
		this.coachLevelImgPath = coachLevelImgPath;
	}
	public String getIdentifiedImage() {
		return identifiedImage;
	}


	public void setIdentifiedImage(String identifiedImage) {
		this.identifiedImage = identifiedImage;
	}
	
}
