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
 * YsmsDistrict entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ysms_district", catalog = "ysms")
public class YsmsDistrict implements java.io.Serializable {

	// Fields

	private Integer districtId;
	private String districtName;
	private Set<YsmsJudge> ysmsJudges = new HashSet<YsmsJudge>(0);

	// Constructors

	/** default constructor */
	public YsmsDistrict() {
	}

	/** minimal constructor */
	public YsmsDistrict(String districtName) {
		this.districtName = districtName;
	}

	/** full constructor */
	public YsmsDistrict(String districtName, Set<YsmsJudge> ysmsJudges) {
		this.districtName = districtName;
		this.ysmsJudges = ysmsJudges;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "district_id", unique = true, nullable = false)
	public Integer getDistrictId() {
		return this.districtId;
	}

	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}

	@Column(name = "district_name", nullable = false, length = 512)
	public String getDistrictName() {
		return this.districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ysmsDistrict")
	@JsonIgnore
	public Set<YsmsJudge> getYsmsJudges() {
		return this.ysmsJudges;
	}

	public void setYsmsJudges(Set<YsmsJudge> ysmsJudges) {
		this.ysmsJudges = ysmsJudges;
	}

}