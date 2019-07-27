package com.model.setup;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "account_sub_category")
public class AccountSubCategory implements java.io.Serializable {

	@Id
	@Column(name = "acCode")
	private Long acCode;
	@Column(name = "acName")
	private String acName;
	@Column(name = "mgrCode")
	private Long mgrCode;
	@JoinColumn(name = "account_category", referencedColumnName = "id")
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private AccountCategory accountCategory;

	public AccountSubCategory() {
	}

	public AccountSubCategory(Long acCode) {
		this.acCode = acCode;
	}

	public AccountSubCategory(String acCode) {
		this.acCode = Long.parseLong(acCode);
	}

	public Long getAcCode() {
		return acCode;
	}

	public void setAcCode(Long acCode) {
		this.acCode = acCode;
	}

	public String getAcName() {
		return acName;
	}

	public void setAcName(String acName) {
		this.acName = acName;
	}

	public Long getMgrCode() {
		return mgrCode;
	}

	public void setMgrCode(Long mgrCode) {
		this.mgrCode = mgrCode;
	}

	public AccountCategory getAccountCategory() {
		return accountCategory;
	}

	public void setAccountCategory(AccountCategory accountCategory) {
		this.accountCategory = accountCategory;
	}

	@Override
	public String toString() {
		return "\n{\"ac_code\": \"" + acCode + "\",\"ac_name\": \"" + acName + "\",\"mgr_code\": \"" + mgrCode
				+ "\",\"accountCategory\": \"" + accountCategory + "\"}";
	}

}
