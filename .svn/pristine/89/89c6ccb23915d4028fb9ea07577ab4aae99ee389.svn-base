package com.cwkj.ysms.model;

import static javax.persistence.GenerationType.IDENTITY;

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

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * YsmsSchool entity. @author chrismacong
 */
@Entity
@Table(name = "ysms_school", catalog = "ysms")
public class YsmsSchool implements java.io.Serializable {

	// Fields

	private Integer schoolId;
	private YsmsDistrict ysmsDistrict;
	private String schoolName;
	private Integer schoolCategory;
	private String schoolAddress;
	private String schoolContacts;
	private String schoolMobile;
	private String schoolFax;
	private Integer deleteflag;
	private Set<YsmsSchooluser> ysmsSchoolusers = new HashSet<YsmsSchooluser>(0);
	private Set<YsmsCoach> ysmsCoachs = new HashSet<YsmsCoach>(0);
	private Set<YsmsAthlete> ysmsAthletes = new HashSet<YsmsAthlete>(0);
	private Set<YsmsTeam> ysmsTeams = new HashSet<YsmsTeam>(0);

	// Constructors

	/** default constructor */
	public YsmsSchool() {
	}

	/** minimal constructor */
	public YsmsSchool(YsmsDistrict ysmsDistrict, String schoolName,
			Integer schoolCategory) {
		this.ysmsDistrict = ysmsDistrict;
		this.schoolName = schoolName;
		this.schoolCategory = schoolCategory;
	}

	/** full constructor */
	public YsmsSchool(YsmsDistrict ysmsDistrict, String schoolName,
			Integer schoolCategory, String schoolAddress,
			String schoolContacts, String schoolMobile, String schoolFax,
			Integer deleteflag, Set<YsmsSchooluser> ysmsSchoolusers,
			Set<YsmsCoach> ysmsCoachs, Set<YsmsAthlete> ysmsAthletes,
			Set<YsmsTeam> ysmsTeams) {
		this.ysmsDistrict = ysmsDistrict;
		this.schoolName = schoolName;
		this.schoolCategory = schoolCategory;
		this.schoolAddress = schoolAddress;
		this.schoolContacts = schoolContacts;
		this.schoolMobile = schoolMobile;
		this.schoolFax = schoolFax;
		this.deleteflag = deleteflag;
		this.ysmsSchoolusers = ysmsSchoolusers;
		this.ysmsCoachs = ysmsCoachs;
		this.ysmsAthletes = ysmsAthletes;
		this.ysmsTeams = ysmsTeams;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "school_id", unique = true, nullable = false)
	public Integer getSchoolId() {
		return this.schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "district_id", nullable = false)
	@JsonIgnore
	public YsmsDistrict getYsmsDistrict() {
		return this.ysmsDistrict;
	}

	public void setYsmsDistrict(YsmsDistrict ysmsDistrict) {
		this.ysmsDistrict = ysmsDistrict;
	}

	@Column(name = "school_name", nullable = false, length = 128)
	public String getSchoolName() {
		return this.schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	@Column(name = "school_category", nullable = false)
	public Integer getSchoolCategory() {
		return this.schoolCategory;
	}

	public void setSchoolCategory(Integer schoolCategory) {
		this.schoolCategory = schoolCategory;
	}

	@Column(name = "school_address", length = 512)
	public String getSchoolAddress() {
		return this.schoolAddress;
	}

	public void setSchoolAddress(String schoolAddress) {
		this.schoolAddress = schoolAddress;
	}

	@Column(name = "school_contacts", length = 128)
	public String getSchoolContacts() {
		return this.schoolContacts;
	}

	public void setSchoolContacts(String schoolContacts) {
		this.schoolContacts = schoolContacts;
	}

	@Column(name = "school_mobile", length = 128)
	public String getSchoolMobile() {
		return this.schoolMobile;
	}

	public void setSchoolMobile(String schoolMobile) {
		this.schoolMobile = schoolMobile;
	}

	@Column(name = "school_fax", length = 128)
	public String getSchoolFax() {
		return this.schoolFax;
	}

	public void setSchoolFax(String schoolFax) {
		this.schoolFax = schoolFax;
	}

	@Column(name = "deleteflag")
	public Integer getDeleteflag() {
		return this.deleteflag;
	}

	public void setDeleteflag(Integer deleteflag) {
		this.deleteflag = deleteflag;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ysmsSchool")
	@JsonIgnore
	public Set<YsmsSchooluser> getYsmsSchoolusers() {
		return this.ysmsSchoolusers;
	}

	public void setYsmsSchoolusers(Set<YsmsSchooluser> ysmsSchoolusers) {
		this.ysmsSchoolusers = ysmsSchoolusers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ysmsSchool")
	@JsonIgnore
	public Set<YsmsCoach> getYsmsCoachs() {
		return this.ysmsCoachs;
	}

	public void setYsmsCoachs(Set<YsmsCoach> ysmsCoachs) {
		this.ysmsCoachs = ysmsCoachs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ysmsSchool")
	@JsonIgnore
	public Set<YsmsAthlete> getYsmsAthletes() {
		return this.ysmsAthletes;
	}

	public void setYsmsAthletes(Set<YsmsAthlete> ysmsAthletes) {
		this.ysmsAthletes = ysmsAthletes;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ysmsSchool")
	@JsonIgnore
	public Set<YsmsTeam> getYsmsTeams() {
		return this.ysmsTeams;
	}

	public void setYsmsTeams(Set<YsmsTeam> ysmsTeams) {
		this.ysmsTeams = ysmsTeams;
	}

}