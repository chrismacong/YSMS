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
 * YsmsFunction entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ysms_function", catalog = "ysms")
public class YsmsFunction implements java.io.Serializable {

	// Fields

	private Integer functionId;
	private String functionContent;
	private Integer functionCategory;
	private String functionName;
	private Set<YsmsGroupFunction> ysmsGroupFunctions = new HashSet<YsmsGroupFunction>(
			0);

	// Constructors

	/** default constructor */
	public YsmsFunction() {
	}

	/** minimal constructor */
	public YsmsFunction(String functionContent, Integer functionCategory,
			String functionName) {
		this.functionContent = functionContent;
		this.functionCategory = functionCategory;
		this.functionName = functionName;
	}

	/** full constructor */
	public YsmsFunction(String functionContent, Integer functionCategory,
			String functionName, Set<YsmsGroupFunction> ysmsGroupFunctions) {
		this.functionContent = functionContent;
		this.functionCategory = functionCategory;
		this.functionName = functionName;
		this.ysmsGroupFunctions = ysmsGroupFunctions;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "function_id", unique = true, nullable = false)
	public Integer getFunctionId() {
		return this.functionId;
	}

	public void setFunctionId(Integer functionId) {
		this.functionId = functionId;
	}

	@Column(name = "function_content", nullable = false, length = 256)
	public String getFunctionContent() {
		return this.functionContent;
	}

	public void setFunctionContent(String functionContent) {
		this.functionContent = functionContent;
	}

	@Column(name = "function_category", nullable = false)
	public Integer getFunctionCategory() {
		return this.functionCategory;
	}

	public void setFunctionCategory(Integer functionCategory) {
		this.functionCategory = functionCategory;
	}

	@Column(name = "function_name", nullable = false, length = 128)
	public String getFunctionName() {
		return this.functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ysmsFunction")
	@JsonIgnore
	public Set<YsmsGroupFunction> getYsmsGroupFunctions() {
		return this.ysmsGroupFunctions;
	}

	public void setYsmsGroupFunctions(Set<YsmsGroupFunction> ysmsGroupFunctions) {
		this.ysmsGroupFunctions = ysmsGroupFunctions;
	}

}