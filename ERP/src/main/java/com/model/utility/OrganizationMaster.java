package com.model.utility;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "organization_master")
public class OrganizationMaster implements java.io.Serializable {

	@Id
	@Column(name = "id")
	private Long id;
	@Column(name = "code")
	private String code;
	@Column(name = "name")
	private String name;
	@Column(name = "province")
	private String province;
	@Column(name = "district")
	private String district;
	@Column(name = "municipal")
	private String municipal;
	@Column(name = "location")
	private String location;
	@Column(name = "contact_no")
	private String contactNo;
	@Column(name = "email")
	private String email;
	@Column(name = "url")
	private String url;
	@Column(name = "estd_year")
	private String estdYear;
	@JoinColumn(name = "tenant", referencedColumnName = "id")
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Tenant tenant;

	public OrganizationMaster() {
	}

	public OrganizationMaster(Long id) {
		this.id = id;
	}

	public OrganizationMaster(String id) {
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

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getMunicipal() {
		return municipal;
	}

	public void setMunicipal(String municipal) {
		this.municipal = municipal;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getEstdYear() {
		return estdYear;
	}

	public void setEstdYear(String estdYear) {
		this.estdYear = estdYear;
	}

	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}

	@Override
	public String toString() {
		return "\n{\"id\": \"" + id + "\",\"code\": \"" + code + "\",\"name\": \"" + name + "\",\"province\": \""
				+ province + "\",\"district\": \"" + district + "\",\"municipal\": \"" + municipal
				+ "\",\"location\": \"" + location + "\",\"contactNo\": \"" + contactNo + "\",\"email\": \"" + email
				+ "\",\"url\": \"" + url + "\",\"estdYear\": \"" + estdYear + "\",\"tenant\": \"" + tenant + "\"}";
	}
}
