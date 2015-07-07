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
 * YsmsCoachAtt entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ysms_coach_att", catalog = "ysms")
public class YsmsCoachAtt implements java.io.Serializable {

	// Fields

	private Integer coachAttid;
	private YsmsCoach ysmsCoach;
	private String attName;
	private Integer attType;

	// Constructors

	/** default constructor */
	public YsmsCoachAtt() {
	}

	/** minimal constructor */
	public YsmsCoachAtt(String attName, Integer attType) {
		this.attName = attName;
		this.attType = attType;
	}

	/** full constructor */
	public YsmsCoachAtt(YsmsCoach ysmsCoach, String attName, Integer attType) {
		this.ysmsCoach = ysmsCoach;
		this.attName = attName;
		this.attType = attType;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "coach_attid", unique = true, nullable = false)
	public Integer getCoachAttid() {
		return this.coachAttid;
	}

	public void setCoachAttid(Integer coachAttid) {
		this.coachAttid = coachAttid;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "coach_id")
	@JsonIgnore
	public YsmsCoach getYsmsCoach() {
		return this.ysmsCoach;
	}

	public void setYsmsCoach(YsmsCoach ysmsCoach) {
		this.ysmsCoach = ysmsCoach;
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