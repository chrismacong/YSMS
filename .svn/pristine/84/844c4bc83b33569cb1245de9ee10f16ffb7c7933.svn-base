package com.cwkj.ysms.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * YsmsCoach entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ysms_coach", catalog = "ysms")
public class YsmsCoach implements java.io.Serializable {

	// Fields

	private Integer coachId;
	private YsmsSchool ysmsSchool;
	private YsmsJobs ysmsJobs;
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
	private String coachPhone;
	private Set<YsmsTeammember> ysmsTeammembers = new HashSet<YsmsTeammember>(0);
	private Set<YsmsCoachAtt> ysmsCoachAtts = new HashSet<YsmsCoachAtt>(0);

	// Constructors

	/** default constructor */
	public YsmsCoach() {
	}

	/** minimal constructor */
	public YsmsCoach(YsmsSchool ysmsSchool, String identifiedId,
			String identifiedName, Integer identifiedGender,
			Date identifiedBirthday, String identifiedAddress,
			String identifiedNationality, String coachMobile, String coachPhone, YsmsJobs ysmsJobs, 
			Integer deleteflag, Boolean schoolcoachFlag, Integer coachLevel) {
		this.ysmsSchool = ysmsSchool;
		this.identifiedId = identifiedId;
		this.identifiedName = identifiedName;
		this.identifiedGender = identifiedGender;
		this.identifiedBirthday = identifiedBirthday;
		this.identifiedAddress = identifiedAddress;
		this.identifiedNationality = identifiedNationality;
		this.coachMobile = coachMobile;
		this.deleteflag = deleteflag;
		this.schoolcoachFlag = schoolcoachFlag;
		this.coachLevel = coachLevel;
	}

	/** full constructor */
	public YsmsCoach(YsmsSchool ysmsSchool, String identifiedId,
			String identifiedName, Integer identifiedGender,
			Date identifiedBirthday, String identifiedAddress,
			String identifiedNationality, String coachMobile, String coachPhone, YsmsJobs ysmsJobs,
			Integer deleteflag, Boolean schoolcoachFlag, Integer coachLevel,
			Set<YsmsTeammember> ysmsTeammembers, Set<YsmsCoachAtt> ysmsCoachAtts) {
		this.ysmsSchool = ysmsSchool;
		this.identifiedId = identifiedId;
		this.identifiedName = identifiedName;
		this.identifiedGender = identifiedGender;
		this.identifiedBirthday = identifiedBirthday;
		this.identifiedAddress = identifiedAddress;
		this.identifiedNationality = identifiedNationality;
		this.coachMobile = coachMobile;
		this.deleteflag = deleteflag;
		this.schoolcoachFlag = schoolcoachFlag;
		this.coachLevel = coachLevel;
		this.ysmsTeammembers = ysmsTeammembers;
		this.ysmsCoachAtts = ysmsCoachAtts;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "coach_id", unique = true, nullable = false)
	public Integer getCoachId() {
		return this.coachId;
	}

	public void setCoachId(Integer coachId) {
		this.coachId = coachId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "school_id", nullable = false)
	@JsonIgnore
	public YsmsSchool getYsmsSchool() {
		return this.ysmsSchool;
	}

	public void setYsmsSchool(YsmsSchool ysmsSchool) {
		this.ysmsSchool = ysmsSchool;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "coach_job", nullable = false)
	@JsonIgnore
	public YsmsJobs getYsmsJobs(){
		return this.ysmsJobs;
	}
	
	public void setYsmsJobs(YsmsJobs ysmsJobs){
		this.ysmsJobs = ysmsJobs;
	}

	@Column(name = "identified_id", nullable = false, length = 18)
	public String getIdentifiedId() {
		return this.identifiedId;
	}

	public void setIdentifiedId(String identifiedId) {
		this.identifiedId = identifiedId;
	}

	@Column(name = "identified_name", nullable = false, length = 128)
	public String getIdentifiedName() {
		return this.identifiedName;
	}

	public void setIdentifiedName(String identifiedName) {
		this.identifiedName = identifiedName;
	}

	@Column(name = "identified_gender", nullable = false)
	public Integer getIdentifiedGender() {
		return this.identifiedGender;
	}

	public void setIdentifiedGender(Integer identifiedGender) {
		this.identifiedGender = identifiedGender;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "identified_birthday", nullable = false, length = 0)
	public Date getIdentifiedBirthday() {
		return this.identifiedBirthday;
	}

	public void setIdentifiedBirthday(Date identifiedBirthday) {
		this.identifiedBirthday = identifiedBirthday;
	}

	@Column(name = "identified_address", nullable = false, length = 512)
	public String getIdentifiedAddress() {
		return this.identifiedAddress;
	}

	public void setIdentifiedAddress(String identifiedAddress) {
		this.identifiedAddress = identifiedAddress;
	}

	@Column(name = "identified_nationality", nullable = false, length = 128)
	public String getIdentifiedNationality() {
		return this.identifiedNationality;
	}

	public void setIdentifiedNationality(String identifiedNationality) {
		this.identifiedNationality = identifiedNationality;
	}

	@Column(name = "coach_mobile", nullable = false, length = 128)
	public String getCoachMobile() {
		return this.coachMobile;
	}

	public void setCoachMobile(String coachMobile) {
		this.coachMobile = coachMobile;
	}

	@Column(name = "coach_phone", nullable = false, length = 128)
	public String getCoachPhone() { 
		return this.coachPhone;
	}
	public void setCoachPhone(String coachPhone) { 
		this.coachPhone = coachPhone;
	}

	@Column(name = "deleteflag", nullable = false)
	public Integer getDeleteflag() {
		return this.deleteflag;
	}

	public void setDeleteflag(Integer deleteflag) {
		this.deleteflag = deleteflag;
	}

	@Column(name = "schoolcoach_flag", nullable = false)
	public Boolean getSchoolcoachFlag() {
		return this.schoolcoachFlag;
	}

	public void setSchoolcoachFlag(Boolean schoolcoachFlag) {
		this.schoolcoachFlag = schoolcoachFlag;
	}

	@Column(name = "coach_level", nullable = false)
	public Integer getCoachLevel() {
		return this.coachLevel;
	}

	public void setCoachLevel(Integer coachLevel) {
		this.coachLevel = coachLevel;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ysmsCoach")
	@JsonIgnore
	public Set<YsmsTeammember> getYsmsTeammembers() {
		return this.ysmsTeammembers;
	}

	public void setYsmsTeammembers(Set<YsmsTeammember> ysmsTeammembers) {
		this.ysmsTeammembers = ysmsTeammembers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ysmsCoach")
	@JsonIgnore
	public Set<YsmsCoachAtt> getYsmsCoachAtts() {
		return this.ysmsCoachAtts;
	}

	public void setYsmsCoachAtts(Set<YsmsCoachAtt> ysmsCoachAtts) {
		this.ysmsCoachAtts = ysmsCoachAtts;
	}

}