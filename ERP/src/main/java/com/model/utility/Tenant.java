package com.model.utility;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tenant")
public class Tenant implements java.io.Serializable {

@Id
@Column(name = "id")
private Long id;
@Column(name = "code")
private String code;
@Column(name = "name")
private String name;

public Tenant() {
}

public Tenant(Long id) {
    this.id = id;
}

public Tenant(String id) {
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

@Override
public String toString() {
    return "\n{\"id\": \"" + id + "\",\"code\": \"" + code + "\",\"name\": \"" + name + "\"}";
}
}
