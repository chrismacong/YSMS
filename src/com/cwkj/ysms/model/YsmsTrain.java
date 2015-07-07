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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * YsmsTrain entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ysms_train", catalog = "ysms")
public class YsmsTrain implements java.io.Serializable {

	// Fields

	private Integer trainId;
	private String trainName;
	private Date trainBegintime;
	private String trainAddress;
	private String trainTeacher;
	private Integer trainCategory;
	private String trainDesc;
	private Date trainEndtime;
	private Integer deleteflag;
	private Set<YsmsTrainDetail> ysmsTrainDetails = new HashSet<YsmsTrainDetail>(
			0);

	// Constructors

	/** default constructor */
	public YsmsTrain() {
	}

	/** minimal constructor */
	public YsmsTrain(String trainName, Date trainBegintime,
			String trainAddress, String trainTeacher, Integer trainCategory,
			Date trainEndtime, Integer deleteflag) {
		this.trainName = trainName;
		this.trainBegintime = trainBegintime;
		this.trainAddress = trainAddress;
		this.trainTeacher = trainTeacher;
		this.trainCategory = trainCategory;
		this.trainEndtime = trainEndtime;
		this.deleteflag = deleteflag;
	}

	/** full constructor */
	public YsmsTrain(String trainName, Date trainBegintime,
			String trainAddress, String trainTeacher, Integer trainCategory,
			String trainDesc, Date trainEndtime, Integer deleteflag,
			Set<YsmsTrainDetail> ysmsTrainDetails) {
		this.trainName = trainName;
		this.trainBegintime = trainBegintime;
		this.trainAddress = trainAddress;
		this.trainTeacher = trainTeacher;
		this.trainCategory = trainCategory;
		this.trainDesc = trainDesc;
		this.trainEndtime = trainEndtime;
		this.deleteflag = deleteflag;
		this.ysmsTrainDetails = ysmsTrainDetails;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "train_id", unique = true, nullable = false)
	public Integer getTrainId() {
		return this.trainId;
	}

	public void setTrainId(Integer trainId) {
		this.trainId = trainId;
	}

	@Column(name = "train_name", nullable = false, length = 128)
	public String getTrainName() {
		return this.trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "train_begintime", nullable = false, length = 0)
	public Date getTrainBegintime() {
		return this.trainBegintime;
	}

	public void setTrainBegintime(Date trainBegintime) {
		this.trainBegintime = trainBegintime;
	}

	@Column(name = "train_address", nullable = false, length = 256)
	public String getTrainAddress() {
		return this.trainAddress;
	}

	public void setTrainAddress(String trainAddress) {
		this.trainAddress = trainAddress;
	}

	@Column(name = "train_teacher", nullable = false, length = 128)
	public String getTrainTeacher() {
		return this.trainTeacher;
	}

	public void setTrainTeacher(String trainTeacher) {
		this.trainTeacher = trainTeacher;
	}

	@Column(name = "train_category", nullable = false)
	public Integer getTrainCategory() {
		return this.trainCategory;
	}

	public void setTrainCategory(Integer trainCategory) {
		this.trainCategory = trainCategory;
	}

	@Column(name = "train_desc", length = 1024)
	public String getTrainDesc() {
		return this.trainDesc;
	}

	public void setTrainDesc(String trainDesc) {
		this.trainDesc = trainDesc;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "train_endtime", nullable = false, length = 0)
	public Date getTrainEndtime() {
		return this.trainEndtime;
	}

	public void setTrainEndtime(Date trainEndtime) {
		this.trainEndtime = trainEndtime;
	}

	@Column(name = "deleteflag", nullable = false)
	public Integer getDeleteflag() {
		return this.deleteflag;
	}

	public void setDeleteflag(Integer deleteflag) {
		this.deleteflag = deleteflag;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ysmsTrain")
	@JsonIgnore
	public Set<YsmsTrainDetail> getYsmsTrainDetails() {
		return this.ysmsTrainDetails;
	}

	public void setYsmsTrainDetails(Set<YsmsTrainDetail> ysmsTrainDetails) {
		this.ysmsTrainDetails = ysmsTrainDetails;
	}

}