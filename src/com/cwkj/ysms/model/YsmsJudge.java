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
 * YsmsJudge entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ysms_judge", catalog = "ysms")
public class YsmsJudge implements java.io.Serializable {

	// Fields

	private Integer judgeId;
	private YsmsDistrict ysmsDistrict;
	private YsmsJobs ysmsJobs;
	private String identifiedId;
	private String identifiedName;
	private Integer identifiedGender;
	private String identifiedNationality;
	private String identifiedAddress;
	private Date identifiedBirthday;
	private Integer deleteflag;
	private String judgeJobaddress;
	private Integer judgeLevel;
	private Integer judgeStatus;
	private String judgeMobile;
	private String judgeTips;
	private Set<YsmsJudgeAtt> ysmsJudgeAtts = new HashSet<YsmsJudgeAtt>(0);
	private Set<YsmsJudgeandlevel> ysmsJudgeandlevels = new HashSet<YsmsJudgeandlevel>(
			0);
	private Set<YsmsGamesJudge> ysmsGamesJudges = new HashSet<YsmsGamesJudge>(0);

	// Constructors

	/** default constructor */
	public YsmsJudge() {
	}

	/** minimal constructor */
	public YsmsJudge(YsmsDistrict ysmsDistrict, YsmsJobs ysmsJobs,
			String identifiedId, String identifiedName,
			Integer identifiedGender, String identifiedNationality,
			String identifiedAddress, Date identifiedBirthday,
			Integer deleteflag, String judgeJobaddress, Integer judgeLevel,
			Integer judgeStatus, String judgeMobile) {
		this.ysmsDistrict = ysmsDistrict;
		this.ysmsJobs = ysmsJobs;
		this.identifiedId = identifiedId;
		this.identifiedName = identifiedName;
		this.identifiedGender = identifiedGender;
		this.identifiedNationality = identifiedNationality;
		this.identifiedAddress = identifiedAddress;
		this.identifiedBirthday = identifiedBirthday;
		this.deleteflag = deleteflag;
		this.judgeJobaddress = judgeJobaddress;
		this.judgeLevel = judgeLevel;
		this.judgeStatus = judgeStatus;
		this.judgeMobile = judgeMobile;
	}

	/** full constructor */
	public YsmsJudge(YsmsDistrict ysmsDistrict, YsmsJobs ysmsJobs,
			String identifiedId, String identifiedName,
			Integer identifiedGender, String identifiedNationality,
			String identifiedAddress, Date identifiedBirthday,
			Integer deleteflag, String judgeJobaddress, Integer judgeLevel,
			Integer judgeStatus, String judgeMobile, String judgeTips,
			Set<YsmsJudgeAtt> ysmsJudgeAtts,
			Set<YsmsJudgeandlevel> ysmsJudgeandlevels,
			Set<YsmsGamesJudge> ysmsGamesJudges) {
		this.ysmsDistrict = ysmsDistrict;
		this.ysmsJobs = ysmsJobs;
		this.identifiedId = identifiedId;
		this.identifiedName = identifiedName;
		this.identifiedGender = identifiedGender;
		this.identifiedNationality = identifiedNationality;
		this.identifiedAddress = identifiedAddress;
		this.identifiedBirthday = identifiedBirthday;
		this.deleteflag = deleteflag;
		this.judgeJobaddress = judgeJobaddress;
		this.judgeLevel = judgeLevel;
		this.judgeStatus = judgeStatus;
		this.judgeMobile = judgeMobile;
		this.judgeTips = judgeTips;
		this.ysmsJudgeAtts = ysmsJudgeAtts;
		this.ysmsJudgeandlevels = ysmsJudgeandlevels;
		this.ysmsGamesJudges = ysmsGamesJudges;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "judge_id", unique = true, nullable = false)
	public Integer getJudgeId() {
		return this.judgeId;
	}

	public void setJudgeId(Integer judgeId) {
		this.judgeId = judgeId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "district_id")
	@JsonIgnore
	public YsmsDistrict getYsmsDistrict() {
		return this.ysmsDistrict;
	}

	public void setYsmsDistrict(YsmsDistrict ysmsDistrict) {
		this.ysmsDistrict = ysmsDistrict;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "job_id")
	@JsonIgnore
	public YsmsJobs getYsmsJobs() {
		return this.ysmsJobs;
	}

	public void setYsmsJobs(YsmsJobs ysmsJobs) {
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

	@Column(name = "identified_nationality", length = 128)
	public String getIdentifiedNationality() {
		return this.identifiedNationality;
	}

	public void setIdentifiedNationality(String identifiedNationality) {
		this.identifiedNationality = identifiedNationality;
	}

	@Column(name = "identified_address",  length = 512)
	public String getIdentifiedAddress() {
		return this.identifiedAddress;
	}

	public void setIdentifiedAddress(String identifiedAddress) {
		this.identifiedAddress = identifiedAddress;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "identified_birthday",  length = 0)
	public Date getIdentifiedBirthday() {
		return this.identifiedBirthday;
	}

	public void setIdentifiedBirthday(Date identifiedBirthday) {
		this.identifiedBirthday = identifiedBirthday;
	}

	@Column(name = "deleteflag", nullable = false)
	public Integer getDeleteflag() {
		return this.deleteflag;
	}

	public void setDeleteflag(Integer deleteflag) {
		this.deleteflag = deleteflag;
	}

	@Column(name = "judge_jobaddress", length = 1024)
	public String getJudgeJobaddress() {
		return this.judgeJobaddress;
	}

	public void setJudgeJobaddress(String judgeJobaddress) {
		this.judgeJobaddress = judgeJobaddress;
	}

	@Column(name = "judge_level")
	public Integer getJudgeLevel() {
		return this.judgeLevel;
	}

	public void setJudgeLevel(Integer judgeLevel) {
		this.judgeLevel = judgeLevel;
	}

	@Column(name = "judge_status", nullable = false)
	public Integer getJudgeStatus() {
		return this.judgeStatus;
	}

	public void setJudgeStatus(Integer judgeStatus) {
		this.judgeStatus = judgeStatus;
	}

	@Column(name = "judge_mobile", nullable = false, length = 20)
	public String getJudgeMobile() {
		return this.judgeMobile;
	}

	public void setJudgeMobile(String judgeMobile) {
		this.judgeMobile = judgeMobile;
	}

	@Column(name = "judge_tips", length = 1024)
	public String getJudgeTips() {
		return this.judgeTips;
	}

	public void setJudgeTips(String judgeTips) {
		this.judgeTips = judgeTips;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ysmsJudge")
	@JsonIgnore
	public Set<YsmsJudgeAtt> getYsmsJudgeAtts() {
		return this.ysmsJudgeAtts;
	}

	public void setYsmsJudgeAtts(Set<YsmsJudgeAtt> ysmsJudgeAtts) {
		this.ysmsJudgeAtts = ysmsJudgeAtts;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ysmsJudge")
	@JsonIgnore
	public Set<YsmsJudgeandlevel> getYsmsJudgeandlevels() {
		return this.ysmsJudgeandlevels;
	}

	public void setYsmsJudgeandlevels(Set<YsmsJudgeandlevel> ysmsJudgeandlevels) {
		this.ysmsJudgeandlevels = ysmsJudgeandlevels;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ysmsJudge")
	@JsonIgnore
	public Set<YsmsGamesJudge> getYsmsGamesJudges() {
		return this.ysmsGamesJudges;
	}

	public void setYsmsGamesJudges(Set<YsmsGamesJudge> ysmsGamesJudges) {
		this.ysmsGamesJudges = ysmsGamesJudges;
	}

}