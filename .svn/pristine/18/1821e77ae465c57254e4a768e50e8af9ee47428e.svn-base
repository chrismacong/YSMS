package com.cwkj.ysms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * YsmsAthleteAtt entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ysms_athlete_att", catalog = "ysms")
public class YsmsAthleteAtt implements java.io.Serializable {

	// Fields

	private Integer athleteAttid;
	private YsmsAthlete ysmsAthlete;
	private String attName;
	private Integer attType;

	// Constructors

	/** default constructor */
	public YsmsAthleteAtt() {
	}

	/** minimal constructor */
	public YsmsAthleteAtt(String attName, Integer attType) {
		this.attName = attName;
		this.attType = attType;
	}

	/** full constructor */
	public YsmsAthleteAtt(YsmsAthlete ysmsAthlete, String attName,
			Integer attType) {
		this.ysmsAthlete = ysmsAthlete;
		this.attName = attName;
		this.attType = attType;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "athlete_attid", unique = true, nullable = false)
	public Integer getAthleteAttid() {
		return this.athleteAttid;
	}

	public void setAthleteAttid(Integer athleteAttid) {
		this.athleteAttid = athleteAttid;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "athlete_id")
	@JsonIgnore
	public YsmsAthlete getYsmsAthlete() {
		return this.ysmsAthlete;
	}

	public void setYsmsAthlete(YsmsAthlete ysmsAthlete) {
		this.ysmsAthlete = ysmsAthlete;
	}

	@Column(name = "att_name", nullable = false, length = 65535)
	public String getAttName() {
		return this.attName;
	}

	public void setAttName(String attName) {
		this.attName = attName;
	}

	@Column(name = "att_type", nullable = false)
	public Integer getAttType() {
		return this.attType;
	}

	public void setAttType(Integer attType) {
		this.attType = attType;
	}

}