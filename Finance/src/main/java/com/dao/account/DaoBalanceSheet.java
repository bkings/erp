package com.dao.account;

import java.util.List;

import com.model.account.BalanceSheet;

public interface DaoBalanceSheet {

	public List<BalanceSheet> getAll(String hql);

	public int save(BalanceSheet obj);

	public int update(BalanceSheet obj);

	public int delete(String sql);

	public List getRecord(String sql);

	public String getMsg();

}
