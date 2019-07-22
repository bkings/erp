package com.model.setup;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account_category")
public class AccountCategory implements java.io.Serializable {

	@Id
	@Column(name = "id")
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "type")
	private String type;

	public AccountCategory() {
	}

	public AccountCategory(Long id) {
		this.id = id;
	}

	public AccountCategory(String id) {
		this.id = Long.parseLong(id);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "\n{\"id\": \"" + id + "\",\"name\": \"" + name + "\",\"type\": \"" + type + "\"}";
	}
}
