package com.dao.account;

import java.util.List;

import com.model.account.GeneralJournals;

public interface DaoGeneralJournals {

	public List<GeneralJournals> getAll(String hql);

	public int save(GeneralJournals obj);

	public int update(GeneralJournals obj);

	public int delete(String sql);

	public List getRecord(String sql);

	public String getMsg();

}
