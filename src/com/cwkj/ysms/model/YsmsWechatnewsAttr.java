package com.cwkj.ysms.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name = "ysms_wechatnews_attr", catalog = "ysms")
public class YsmsWechatnewsAttr implements java.io.Serializable {

	// Fields

	private Integer id;
	private YsmsWechatnews ysmsWechatnews;
	private String content;

	// Constructors

	/** default constructor */
	public YsmsWechatnewsAttr() {
	}

	/** minimal constructor */
	public YsmsWechatnewsAttr(YsmsWechatnews ysmsWechatnews) {
		this.ysmsWechatnews = ysmsWechatnews;
	}

	/** full constructor */
	public YsmsWechatnewsAttr(YsmsWechatnews ysmsWechatnews, String content) {
		this.ysmsWechatnews = ysmsWechatnews;
		this.content = content;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "news_id", nullable = false)
	@JsonIgnore
	public YsmsWechatnews getYsmsWechatnews() {
		return this.ysmsWechatnews;
	}

	public void setYsmsWechatnews(YsmsWechatnews ysmsWechatnews) {
		this.ysmsWechatnews = ysmsWechatnews;
	}

	@Column(name = "content", length = 65535)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}