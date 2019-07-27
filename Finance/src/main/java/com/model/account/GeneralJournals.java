package com.model.account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "general_journals")
public class GeneralJournals {

	@Id
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	@Column(name = "balAccountType")
	private String balAccountType;
	@Column(name = "balAccountNo")
	private long balAccountNo;
	@Column(name = "numberSeries")
	private String numberSeries;

	@Column(name = "postingNumberSeries")
	private String postingNumberSeries;
	@Column(name = "reasonCode")
	private String reasonCode;
	@Column(name = "copyVATSetupToJnlLines")
	private String copyVATSetupToJnlLines;
	@Column(name = "allowVATDifference")
	private String allowVATDifference;
	@Column(name = "suggestBalancingAmount")
	private String suggestBalancingAmount;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBalAccountType() {
		return balAccountType;
	}

	public void setBalAccountType(String balAccountType) {
		this.balAccountType = balAccountType;
	}

	public long getBalAccountNo() {
		return balAccountNo;
	}

	public void setBalAccountNo(long balAccountNo) {
		this.balAccountNo = balAccountNo;
	}

	public String getNumberSeries() {
		return numberSeries;
	}

	public void setNumberSeries(String numberSeries) {
		this.numberSeries = numberSeries;
	}

	public String getPostingNumberSeries() {
		return postingNumberSeries;
	}

	public void setPostingNumberSeries(String postingNumberSeries) {
		this.postingNumberSeries = postingNumberSeries;
	}

	public String getReasonCode() {
		return reasonCode;
	}

	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}

	public String getCopyVATSetupToJnlLines() {
		return copyVATSetupToJnlLines;
	}

	public void setCopyVATSetupToJnlLines(String copyVATSetupToJnlLines) {
		this.copyVATSetupToJnlLines = copyVATSetupToJnlLines;
	}

	public String getAllowVATDifference() {
		return allowVATDifference;
	}

	public void setAllowVATDifference(String allowVATDifference) {
		this.allowVATDifference = allowVATDifference;
	}

	public String getSuggestBalancingAmount() {
		return suggestBalancingAmount;
	}

	public void setSuggestBalancingAmount(String suggestBalancingAmount) {
		this.suggestBalancingAmount = suggestBalancingAmount;
	}

}
