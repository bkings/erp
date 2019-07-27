package com.model.account;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.model.setup.AccountCategory;
import com.model.setup.AccountSubCategory;

@Entity
@Table(name="balance_sheet")
public class BalanceSheet {

	@Id
	@Column(name="number")
	private long number;
	@Column(name="name")
	private String name;
	@Column(name="income_balance")
	private String income_balance;
	
	@JoinColumn(name="accountCategory")
	@ManyToOne(fetch=FetchType.EAGER)
	private AccountCategory accountCategory;
	
	@JoinColumn(name="accountSubCategory")
	@ManyToOne(fetch=FetchType.EAGER)
	private AccountSubCategory accountSubCategory;
	
	@Column(name="debit_credit")
	private String debit_credit;
	@Column(name="accountType")
	private String accountType;
	
	@JoinColumn(name="totaling")
	@ManyToOne(fetch=FetchType.EAGER)
	private AccountSubCategory totaling;
	
	@Column(name="balance")
	private long balance;
	@Column(name="reconciliationAccount")
	private String reconciliationAccount;
	@Column(name="automaticExtTexts")
	private String automaticExtTexts;
	@Column(name="directPosting")
	private String directPosting;
	@Column(name="blocked")
	private String blocked;
	@Column(name="lastDateModified")
	private java.sql.Date lastDateModified;
	@Column(name="omitDefaultDesc")
	private String omitDefaultDesc;
	@Column(name="genPostingType")
	private String genPostingType;
	@Column(name="genBusPostingGroup")
	private String genBusPostingGroup;
	@Column(name="genProdPostingGroup")
	private String genProdPostingGroup;
	@Column(name="VATBusPostingGroup")
	private String VATBusPostingGroup;
	@Column(name="VATProdPostingGroup")
	private String VATProdPostingGroup;
	@Column(name="defaultICPartnerGLAccNo")
	private String defaultICPartnerGLAccNo;
	@Column(name="defaultDeferralTemplate")
	private String defaultDeferralTemplate;
	@Column(name="consolDebitAcc")
	private String consolDebitAcc;
	@Column(name="consolCreditAcc")
	private String consolCreditAcc;
	@Column(name="consolTranslation")
	private String consolTranslation;
	@Column(name="exchangeRateAdjustment")
	private String exchangeRateAdjustment;
	@Column(name="costTypeNo")
	private String costTypeNo;

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIncome_balance() {
		return income_balance;
	}

	public void setIncome_balance(String income_balance) {
		this.income_balance = income_balance;
	}

	public AccountCategory getAccountCategory() {
		return accountCategory;
	}

	public void setAccountCategory(AccountCategory accountCategory) {
		this.accountCategory = accountCategory;
	}

	public AccountSubCategory getAccountSubCategory() {
		return accountSubCategory;
	}

	public void setAccountSubCategory(AccountSubCategory accountSubCategory) {
		this.accountSubCategory = accountSubCategory;
	}

	public String getDebit_credit() {
		return debit_credit;
	}

	public void setDebit_credit(String debit_credit) {
		this.debit_credit = debit_credit;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public AccountSubCategory getTotaling() {
		return totaling;
	}

	public void setTotaling(AccountSubCategory totaling) {
		this.totaling = totaling;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	public String getReconciliationAccount() {
		return reconciliationAccount;
	}

	public void setReconciliationAccount(String reconciliationAccount) {
		this.reconciliationAccount = reconciliationAccount;
	}

	public String getAutomaticExtTexts() {
		return automaticExtTexts;
	}

	public void setAutomaticExtTexts(String automaticExtTexts) {
		this.automaticExtTexts = automaticExtTexts;
	}

	public String getDirectPosting() {
		return directPosting;
	}

	public void setDirectPosting(String directPosting) {
		this.directPosting = directPosting;
	}

	public String getBlocked() {
		return blocked;
	}

	public void setBlocked(String blocked) {
		this.blocked = blocked;
	}

	public Date getLastDateModified() {
		return lastDateModified;
	}

	public void setLastDateModified(java.sql.Date lastDateModified) {
		this.lastDateModified = lastDateModified;
	}

	public String getOmitDefaultDesc() {
		return omitDefaultDesc;
	}

	public void setOmitDefaultDesc(String omitDefaultDesc) {
		this.omitDefaultDesc = omitDefaultDesc;
	}

	public String getGenPostingType() {
		return genPostingType;
	}

	public void setGenPostingType(String genPostingType) {
		this.genPostingType = genPostingType;
	}

	public String getGenBusPostingGroup() {
		return genBusPostingGroup;
	}

	public void setGenBusPostingGroup(String genBusPostingGroup) {
		this.genBusPostingGroup = genBusPostingGroup;
	}

	public String getGenProdPostingGroup() {
		return genProdPostingGroup;
	}

	public void setGenProdPostingGroup(String genProdPostingGroup) {
		this.genProdPostingGroup = genProdPostingGroup;
	}

	public String getVATBusPostingGroup() {
		return VATBusPostingGroup;
	}

	public void setVATBusPostingGroup(String vATBusPostingGroup) {
		VATBusPostingGroup = vATBusPostingGroup;
	}

	public String getVATProdPostingGroup() {
		return VATProdPostingGroup;
	}

	public void setVATProdPostingGroup(String vATProdPostingGroup) {
		VATProdPostingGroup = vATProdPostingGroup;
	}

	public String getDefaultICPartnerGLAccNo() {
		return defaultICPartnerGLAccNo;
	}

	public void setDefaultICPartnerGLAccNo(String defaultICPartnerGLAccNo) {
		this.defaultICPartnerGLAccNo = defaultICPartnerGLAccNo;
	}

	public String getDefaultDeferralTemplate() {
		return defaultDeferralTemplate;
	}

	public void setDefaultDeferralTemplate(String defaultDeferralTemplate) {
		this.defaultDeferralTemplate = defaultDeferralTemplate;
	}

	public String getConsolDebitAcc() {
		return consolDebitAcc;
	}

	public void setConsolDebitAcc(String consolDebitAcc) {
		this.consolDebitAcc = consolDebitAcc;
	}

	public String getConsolCreditAcc() {
		return consolCreditAcc;
	}

	public void setConsolCreditAcc(String consolCreditAcc) {
		this.consolCreditAcc = consolCreditAcc;
	}

	public String getConsolTranslation() {
		return consolTranslation;
	}

	public void setConsolTranslation(String consolTranslation) {
		this.consolTranslation = consolTranslation;
	}

	public String getExchangeRateAdjustment() {
		return exchangeRateAdjustment;
	}

	public void setExchangeRateAdjustment(String exchangeRateAdjustment) {
		this.exchangeRateAdjustment = exchangeRateAdjustment;
	}

	public String getCostTypeNo() {
		return costTypeNo;
	}

	public void setCostTypeNo(String costTypeNo) {
		this.costTypeNo = costTypeNo;
	}

}
