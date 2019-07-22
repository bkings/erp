package com.model.utility;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "branch_master", uniqueConstraints = {
		@UniqueConstraint(name = "UNIQUE_CODE", columnNames = { "code", "organization" }) })
public class BranchMaster implements java.io.Serializable {

	@Id
	@Column(name = "id")
	private Long id;
	@Column(name = "code", columnDefinition = "VARCHAR(3) NOT NULL")
	private String code;
	@Column(name = "name", columnDefinition = "VARCHAR(60) NOT NULL")
	private String name;
	@Column(name = "hierarchy")
	private Integer hierarchy;
	@Column(name = "parent")
	private Long parent;
	@JoinColumn(name = "organization", referencedColumnName = "id")
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private OrganizationMaster organization;

	public BranchMaster() {
	}

	public BranchMaster(Long id) {
		this.id = id;
	}

	public BranchMaster(String id) {
		this.id = Long.parseLong(id);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getParent() {
		return parent;
	}

	public void setParent(Long parent) {
		this.parent = parent;
	}

	public OrganizationMaster getOrganization() {
		return organization;
	}

	public void setOrganization(OrganizationMaster organization) {
		this.organization = organization;
	}

	public Integer getHierarchy() {
		return hierarchy;
	}

	public void setHierarchy(Integer hierarchy) {
		this.hierarchy = hierarchy;
	}

	@Override
	public String toString() {
		return "\n{\"id\": \"" + id + "\",\"code\": \"" + code + "\",\"name\": \"" + name + "\"}";
	}

}
