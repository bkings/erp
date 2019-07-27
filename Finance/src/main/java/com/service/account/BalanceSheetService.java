package com.service.account;

import java.util.List;

import com.model.account.BalanceSheet;

public interface BalanceSheetService {

	public List<BalanceSheet> getAll();

	public String save(BalanceSheet obj, String Authorization);

	public String update(BalanceSheet obj, long number, String Authorization);

	public String delete(String id, String Authorization);

}
