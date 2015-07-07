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
 * YsmsJobs entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ysms_jobs", catalog = "ysms")
public class YsmsJobs implements java.io.Serializable {

	// Fields

	private Integer jobId;
	private String jobName;
	private Set<YsmsAthlete> ysmsAthletesForGuardian2Job = new HashSet<YsmsAthlete>(
			0);
	private Set<YsmsAthlete> ysmsAthletesForGuardian1Job = new HashSet<YsmsAthlete>(
			0);
	private Set<YsmsJudge> ysmsJudges = new HashSet<YsmsJudge>(0);

	// Constructors

	/** default constructor */
	public YsmsJobs() {
	}

	/** minimal constructor */
	public YsmsJobs(String jobName) {
		this.jobName = jobName;
	}

	/** full constructor */
	public YsmsJobs(String jobName,
			Set<YsmsAthlete> ysmsAthletesForGuardian2Job,
			Set<YsmsAthlete> ysmsAthletesForGuardian1Job,
			Set<YsmsJudge> ysmsJudges) {
		this.jobName = jobName;
		this.ysmsAthletesForGuardian2Job = ysmsAthletesForGuardian2Job;
		this.ysmsAthletesForGuardian1Job = ysmsAthletesForGuardian1Job;
		this.ysmsJudges = ysmsJudges;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "job_id", unique = true, nullable = false)
	public Integer getJobId() {
		return this.jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	@Column(name = "job_name", nullable = false, length = 128)
	public String getJobName() {
		return this.jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ysmsJobsByGuardian2Job")
	@JsonIgnore
	public Set<YsmsAthlete> getYsmsAthletesForGuardian2Job() {
		return this.ysmsAthletesForGuardian2Job;
	}

	public void setYsmsAthletesForGuardian2Job(
			Set<YsmsAthlete> ysmsAthletesForGuardian2Job) {
		this.ysmsAthletesForGuardian2Job = ysmsAthletesForGuardian2Job;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ysmsJobsByGuardian1Job")
	@JsonIgnore
	public Set<YsmsAthlete> getYsmsAthletesForGuardian1Job() {
		return this.ysmsAthletesForGuardian1Job;
	}

	public void setYsmsAthletesForGuardian1Job(
			Set<YsmsAthlete> ysmsAthletesForGuardian1Job) {
		this.ysmsAthletesForGuardian1Job = ysmsAthletesForGuardian1Job;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ysmsJobs")
	@JsonIgnore
	public Set<YsmsJudge> getYsmsJudges() {
		return this.ysmsJudges;
	}

	public void setYsmsJudges(Set<YsmsJudge> ysmsJudges) {
		this.ysmsJudges = ysmsJudges;
	}

}