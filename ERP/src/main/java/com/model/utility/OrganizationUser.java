package com.model.utility;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "organization_user")
public class OrganizationUser implements java.io.Serializable {

@Id
@Column(name = "login_id")
private String loginId;
@Column(name = "user_name")
private String userName;
@Column(name = "email")
private String email;
@Column(name = "mobile")
private String mobile;
@Column(name = "address")
private String address;
@Column(name = "join_date")
private String joinDate;
@Column(name = "password",updatable = false)
private String password;
@Column(name = "status")
private String status;
@Column(name = "token",updatable = false)
private String token;
@JoinColumn(name = "branch", referencedColumnName = "id")
@ManyToOne(optional = false, fetch = FetchType.EAGER)
private BranchMaster branch;

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public BranchMaster getBranch() {
        return branch;
    }

    public void setBranch(BranchMaster branch) {
        this.branch = branch;
    }



}
