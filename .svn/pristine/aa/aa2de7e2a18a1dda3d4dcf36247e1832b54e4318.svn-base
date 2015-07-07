package com.cwkj.ysms.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * YsmsAthlete entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ysms_athlete", catalog = "ysms")
public class YsmsAthlete implements java.io.Serializable {

	// Fields

	private Integer athleteId;
	private YsmsDiploma ysmsDiplomaByGuardian2Diploma;
	private YsmsJobs ysmsJobsByGuardian1Job;
	private YsmsDiploma ysmsDiplomaByGuardian1Diploma;
	private YsmsJobs ysmsJobsByGuardian2Job;
	private YsmsSchool ysmsSchool;
	private String identifiedName;
	private Integer identifiedGender;
	private String identifiedNationality;
	private Integer athletePosition;
	private Integer athleteHeight;
	private Integer athleteFootsize;
	private Integer athleteWeight;
	private String identifiedId;
	private String identifiedAddress;
	private String athleteMobile;
	private String athleteSchoolyear;
	private String studentId;
	private String athleteCoach;
	private Integer deleteflag;
	private String athleteGuardian1;
	private String guardian1Mobile;
	private String athleteGuardian2;
	private String guardian2Mobile;
	private Date identifiedBirthday;
	private String register_id;
	private Set<YsmsFoul> ysmsFouls = new HashSet<YsmsFoul>(0);
	private Set<YsmsTeammember> ysmsTeammembers = new HashSet<YsmsTeammember>(0);
	private Set<YsmsAthleteAtt> ysmsAthleteAtts = new HashSet<YsmsAthleteAtt>(0);

	// Constructors

	/** default constructor */
	public YsmsAthlete() {
	}

	/** minimal constructor */
	public YsmsAthlete(YsmsJobs ysmsJobsByGuardian1Job,
			YsmsDiploma ysmsDiplomaByGuardian1Diploma, YsmsSchool ysmsSchool,
			String identifiedName, Integer identifiedGender,
			String identifiedNationality, Integer athletePosition,
			Integer athleteHeight, Integer athleteFootsize,
			Integer athleteWeight, String identifiedId,
			String identifiedAddress, String athleteMobile,
			String athleteSchoolyear, String studentId, String athleteCoach,
			Integer deleteflag, String athleteGuardian1,
			String guardian1Mobile, Date identifiedBirthday) {
		this.ysmsJobsByGuardian1Job = ysmsJobsByGuardian1Job;
		this.ysmsDiplomaByGuardian1Diploma = ysmsDiplomaByGuardian1Diploma;
		this.ysmsSchool = ysmsSchool;
		this.identifiedName = identifiedName;
		this.identifiedGender = identifiedGender;
		this.identifiedNationality = identifiedNationality;
		this.athletePosition = athletePosition;
		this.athleteHeight = athleteHeight;
		this.athleteFootsize = athleteFootsize;
		this.athleteWeight = athleteWeight;
		this.identifiedId = identifiedId;
		this.identifiedAddress = identifiedAddress;
		this.athleteMobile = athleteMobile;
		this.athleteSchoolyear = athleteSchoolyear;
		this.studentId = studentId;
		this.athleteCoach = athleteCoach;
		this.deleteflag = deleteflag;
		this.athleteGuardian1 = athleteGuardian1;
		this.guardian1Mobile = guardian1Mobile;
		this.identifiedBirthday = identifiedBirthday;
	}

	/** full constructor */
	public YsmsAthlete(YsmsDiploma ysmsDiplomaByGuardian2Diploma,
			YsmsJobs ysmsJobsByGuardian1Job,
			YsmsDiploma ysmsDiplomaByGuardian1Diploma,
			YsmsJobs ysmsJobsByGuardian2Job, YsmsSchool ysmsSchool,
			String identifiedName, Integer identifiedGender,
			String identifiedNationality, Integer athletePosition,
			Integer athleteHeight, Integer athleteFootsize,
			Integer athleteWeight, String identifiedId,
			String identifiedAddress, String athleteMobile,
			String athleteSchoolyear, String studentId, String athleteCoach,
			Integer deleteflag, String athleteGuardian1,
			String guardian1Mobile, String athleteGuardian2,
			String guardian2Mobile, Date identifiedBirthday,
			Set<YsmsFoul> ysmsFouls, Set<YsmsTeammember> ysmsTeammembers,
			Set<YsmsAthleteAtt> ysmsAthleteAtts) {
		this.ysmsDiplomaByGuardian2Diploma = ysmsDiplomaByGuardian2Diploma;
		this.ysmsJobsByGuardian1Job = ysmsJobsByGuardian1Job;
		this.ysmsDiplomaByGuardian1Diploma = ysmsDiplomaByGuardian1Diploma;
		this.ysmsJobsByGuardian2Job = ysmsJobsByGuardian2Job;
		this.ysmsSchool = ysmsSchool;
		this.identifiedName = identifiedName;
		this.identifiedGender = identifiedGender;
		this.identifiedNationality = identifiedNationality;
		this.athletePosition = athletePosition;
		this.athleteHeight = athleteHeight;
		this.athleteFootsize = athleteFootsize;
		this.athleteWeight = athleteWeight;
		this.identifiedId = identifiedId;
		this.identifiedAddress = identifiedAddress;
		this.athleteMobile = athleteMobile;
		this.athleteSchoolyear = athleteSchoolyear;
		this.studentId = studentId;
		this.athleteCoach = athleteCoach;
		this.deleteflag = deleteflag;
		this.athleteGuardian1 = athleteGuardian1;
		this.guardian1Mobile = guardian1Mobile;
		this.athleteGuardian2 = athleteGuardian2;
		this.guardian2Mobile = guardian2Mobile;
		this.identifiedBirthday = identifiedBirthday;
		this.ysmsFouls = ysmsFouls;
		this.ysmsTeammembers = ysmsTeammembers;
		this.ysmsAthleteAtts = ysmsAthleteAtts;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "athlete_id", unique = true, nullable = false)
	public Integer getAthleteId() {
		return this.athleteId;
	}

	public void setAthleteId(Integer athleteId) {
		this.athleteId = athleteId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "guardian2_diploma")
	@JsonIgnore
	public YsmsDiploma getYsmsDiplomaByGuardian2Diploma() {
		return this.ysmsDiplomaByGuardian2Diploma;
	}

	public void setYsmsDiplomaByGuardian2Diploma(
			YsmsDiploma ysmsDiplomaByGuardian2Diploma) {
		this.ysmsDiplomaByGuardian2Diploma = ysmsDiplomaByGuardian2Diploma;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "guardian1_job", nullable = false)
	@JsonIgnore
	public YsmsJobs getYsmsJobsByGuardian1Job() {
		return this.ysmsJobsByGuardian1Job;
	}

	public void setYsmsJobsByGuardian1Job(YsmsJobs ysmsJobsByGuardian1Job) {
		this.ysmsJobsByGuardian1Job = ysmsJobsByGuardian1Job;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "guardian1_diploma", nullable = false)
	@JsonIgnore
	public YsmsDiploma getYsmsDiplomaByGuardian1Diploma() {
		return this.ysmsDiplomaByGuardian1Diploma;
	}

	public void setYsmsDiplomaByGuardian1Diploma(
			YsmsDiploma ysmsDiplomaByGuardian1Diploma) {
		this.ysmsDiplomaByGuardian1Diploma = ysmsDiplomaByGuardian1Diploma;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "guardian2_job")
	@JsonIgnore
	public YsmsJobs getYsmsJobsByGuardian2Job() {
		return this.ysmsJobsByGuardian2Job;
	}

	public void setYsmsJobsByGuardian2Job(YsmsJobs ysmsJobsByGuardian2Job) {
		this.ysmsJobsByGuardian2Job = ysmsJobsByGuardian2Job;
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

	@Column(name = "identified_nationality", nullable = false, length = 128)
	public String getIdentifiedNationality() {
		return this.identifiedNationality;
	}

	public void setIdentifiedNationality(String identifiedNationality) {
		this.identifiedNationality = identifiedNationality;
	}

	@Column(name = "athlete_position", nullable = false)
	public Integer getAthletePosition() {
		return this.athletePosition;
	}

	public void setAthletePosition(Integer athletePosition) {
		this.athletePosition = athletePosition;
	}

	@Column(name = "athlete_height", nullable = false)
	public Integer getAthleteHeight() {
		return this.athleteHeight;
	}

	public void setAthleteHeight(Integer athleteHeight) {
		this.athleteHeight = athleteHeight;
	}

	@Column(name = "athlete_footsize", nullable = false)
	public Integer getAthleteFootsize() {
		return this.athleteFootsize;
	}

	public void setAthleteFootsize(Integer athleteFootsize) {
		this.athleteFootsize = athleteFootsize;
	}

	@Column(name = "athlete_weight", nullable = false)
	public Integer getAthleteWeight() {
		return this.athleteWeight;
	}

	public void setAthleteWeight(Integer athleteWeight) {
		this.athleteWeight = athleteWeight;
	}

	@Column(name = "identified_id", nullable = false, length = 18)
	public String getIdentifiedId() {
		return this.identifiedId;
	}

	public void setIdentifiedId(String identifiedId) {
		this.identifiedId = identifiedId;
	}

	@Column(name = "identified_address", nullable = false, length = 512)
	public String getIdentifiedAddress() {
		return this.identifiedAddress;
	}

	public void setIdentifiedAddress(String identifiedAddress) {
		this.identifiedAddress = identifiedAddress;
	}

	@Column(name = "athlete_mobile", nullable = false, length = 128)
	public String getAthleteMobile() {
		return this.athleteMobile;
	}

	public void setAthleteMobile(String athleteMobile) {
		this.athleteMobile = athleteMobile;
	}

	@Column(name = "athlete_schoolyear", nullable = false, length = 128)
	public String getAthleteSchoolyear() {
		return this.athleteSchoolyear;
	}

	public void setAthleteSchoolyear(String athleteSchoolyear) {
		this.athleteSchoolyear = athleteSchoolyear;
	}

	@Column(name = "student_id", nullable = false, length = 128)
	public String getStudentId() {
		return this.studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	@Column(name = "athlete_coach", nullable = false, length = 128)
	public String getAthleteCoach() {
		return this.athleteCoach;
	}

	public void setAthleteCoach(String athleteCoach) {
		this.athleteCoach = athleteCoach;
	}

	@Column(name = "deleteflag", nullable = false)
	public Integer getDeleteflag() {
		return this.deleteflag;
	}

	public void setDeleteflag(Integer deleteflag) {
		this.deleteflag = deleteflag;
	}

	@Column(name = "athlete_guardian1", nullable = false, length = 128)
	public String getAthleteGuardian1() {
		return this.athleteGuardian1;
	}

	public void setAthleteGuardian1(String athleteGuardian1) {
		this.athleteGuardian1 = athleteGuardian1;
	}

	@Column(name = "guardian1_mobile", nullable = false, length = 128)
	public String getGuardian1Mobile() {
		return this.guardian1Mobile;
	}

	public void setGuardian1Mobile(String guardian1Mobile) {
		this.guardian1Mobile = guardian1Mobile;
	}

	@Column(name = "athlete_guardian2", length = 128)
	public String getAthleteGuardian2() {
		return this.athleteGuardian2;
	}

	public void setAthleteGuardian2(String athleteGuardian2) {
		this.athleteGuardian2 = athleteGuardian2;
	}

	@Column(name = "guardian2_mobile", length = 128)
	public String getGuardian2Mobile() {
		return this.guardian2Mobile;
	}

	public void setGuardian2Mobile(String guardian2Mobile) {
		this.guardian2Mobile = guardian2Mobile;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "identified_birthday", nullable = false, length = 0)
	public Date getIdentifiedBirthday() {
		return this.identifiedBirthday;
	}

	public void setIdentifiedBirthday(Date identifiedBirthday) {
		this.identifiedBirthday = identifiedBirthday;
	}
	
	
	@Column(name = "register_id", length = 128)
	public String getRegister_id() {
		return register_id;
	}

	public void setRegister_id(String register_id) {
		this.register_id = register_id;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ysmsAthlete")
	@JsonIgnore
	public Set<YsmsFoul> getYsmsFouls() {
		return this.ysmsFouls;
	}

	public void setYsmsFouls(Set<YsmsFoul> ysmsFouls) {
		this.ysmsFouls = ysmsFouls;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ysmsAthlete")
	@JsonIgnore
	public Set<YsmsTeammember> getYsmsTeammembers() {
		return this.ysmsTeammembers;
	}

	public void setYsmsTeammembers(Set<YsmsTeammember> ysmsTeammembers) {
		this.ysmsTeammembers = ysmsTeammembers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ysmsAthlete")
	@JsonIgnore
	public Set<YsmsAthleteAtt> getYsmsAthleteAtts() {
		return this.ysmsAthleteAtts;
	}

	public void setYsmsAthleteAtts(Set<YsmsAthleteAtt> ysmsAthleteAtts) {
		this.ysmsAthleteAtts = ysmsAthleteAtts;
	}
	
	

}