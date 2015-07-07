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
 * YsmsTrainDetail entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ysms_train_detail", catalog = "ysms")
public class YsmsTrainDetail implements java.io.Serializable {

	// Fields

	private Integer detailId;
	private YsmsTrain ysmsTrain;
	private Integer detailResult;
	private Integer learnerId;

	// Constructors

	/** default constructor */
	public YsmsTrainDetail() {
	}

	/** full constructor */
	public YsmsTrainDetail(YsmsTrain ysmsTrain, Integer detailResult,
			Integer learnerId) {
		this.ysmsTrain = ysmsTrain;
		this.detailResult = detailResult;
		this.learnerId = learnerId;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "detail_id", unique = true, nullable = false)
	public Integer getDetailId() {
		return this.detailId;
	}

	public void setDetailId(Integer detailId) {
		this.detailId = detailId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "train_id", nullable = false)
	@JsonIgnore
	public YsmsTrain getYsmsTrain() {
		return this.ysmsTrain;
	}

	public void setYsmsTrain(YsmsTrain ysmsTrain) {
		this.ysmsTrain = ysmsTrain;
	}

	@Column(name = "detail_result", nullable = false)
	public Integer getDetailResult() {
		return this.detailResult;
	}

	public void setDetailResult(Integer detailResult) {
		this.detailResult = detailResult;
	}

	@Column(name = "learner_id", nullable = false)
	public Integer getLearnerId() {
		return this.learnerId;
	}

	public void setLearnerId(Integer learnerId) {
		this.learnerId = learnerId;
	}

}