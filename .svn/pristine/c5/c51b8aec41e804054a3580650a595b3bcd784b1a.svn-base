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
 * YsmsJudgelevel entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ysms_judgelevel", catalog = "ysms")
public class YsmsJudgelevel implements java.io.Serializable {

	// Fields

	private Integer levelId;
	private String levelName;
	private Set<YsmsJudgeandlevel> ysmsJudgeandlevels = new HashSet<YsmsJudgeandlevel>(
			0);

	// Constructors

	/** default constructor */
	public YsmsJudgelevel() {
	}

	/** minimal constructor */
	public YsmsJudgelevel(String levelName) {
		this.levelName = levelName;
	}

	/** full constructor */
	public YsmsJudgelevel(String levelName,
			Set<YsmsJudgeandlevel> ysmsJudgeandlevels) {
		this.levelName = levelName;
		this.ysmsJudgeandlevels = ysmsJudgeandlevels;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "level_id", unique = true, nullable = false)
	public Integer getLevelId() {
		return this.levelId;
	}

	public void setLevelId(Integer levelId) {
		this.levelId = levelId;
	}

	@Column(name = "level_name", nullable = false, length = 128)
	public String getLevelName() {
		return this.levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ysmsJudgelevel")
	@JsonIgnore
	public Set<YsmsJudgeandlevel> getYsmsJudgeandlevels() {
		return this.ysmsJudgeandlevels;
	}

	public void setYsmsJudgeandlevels(Set<YsmsJudgeandlevel> ysmsJudgeandlevels) {
		this.ysmsJudgeandlevels = ysmsJudgeandlevels;
	}

}