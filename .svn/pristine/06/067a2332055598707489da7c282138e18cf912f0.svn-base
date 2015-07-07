package com.cwkj.ysms.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * YsmsDiploma entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ysms_diploma", catalog = "ysms")
public class YsmsDiploma implements java.io.Serializable {

	// Fields

	private Integer diplomaId;
	private String diplomaName;
	private Set<YsmsAthlete> ysmsAthletesForGuardian1Diploma = new HashSet<YsmsAthlete>(
			0);
	private Set<YsmsAthlete> ysmsAthletesForGuardian2Diploma = new HashSet<YsmsAthlete>(
			0);

	// Constructors

	/** default constructor */
	public YsmsDiploma() {
	}

	/** minimal constructor */
	public YsmsDiploma(String diplomaName) {
		this.diplomaName = diplomaName;
	}

	/** full constructor */
	public YsmsDiploma(String diplomaName,
			Set<YsmsAthlete> ysmsAthletesForGuardian1Diploma,
			Set<YsmsAthlete> ysmsAthletesForGuardian2Diploma) {
		this.diplomaName = diplomaName;
		this.ysmsAthletesForGuardian1Diploma = ysmsAthletesForGuardian1Diploma;
		this.ysmsAthletesForGuardian2Diploma = ysmsAthletesForGuardian2Diploma;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "diploma_id", unique = true, nullable = false)
	public Integer getDiplomaId() {
		return this.diplomaId;
	}

	public void setDiplomaId(Integer diplomaId) {
		this.diplomaId = diplomaId;
	}

	@Column(name = "diploma_name", nullable = false, length = 128)
	public String getDiplomaName() {
		return this.diplomaName;
	}

	public void setDiplomaName(String diplomaName) {
		this.diplomaName = diplomaName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ysmsDiplomaByGuardian1Diploma")
	@JsonIgnore
	public Set<YsmsAthlete> getYsmsAthletesForGuardian1Diploma() {
		return this.ysmsAthletesForGuardian1Diploma;
	}

	public void setYsmsAthletesForGuardian1Diploma(
			Set<YsmsAthlete> ysmsAthletesForGuardian1Diploma) {
		this.ysmsAthletesForGuardian1Diploma = ysmsAthletesForGuardian1Diploma;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ysmsDiplomaByGuardian2Diploma")
	@JsonIgnore
	public Set<YsmsAthlete> getYsmsAthletesForGuardian2Diploma() {
		return this.ysmsAthletesForGuardian2Diploma;
	}

	public void setYsmsAthletesForGuardian2Diploma(
			Set<YsmsAthlete> ysmsAthletesForGuardian2Diploma) {
		this.ysmsAthletesForGuardian2Diploma = ysmsAthletesForGuardian2Diploma;
	}

}