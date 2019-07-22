package com.dao.setup;

import java.util.List;

import com.model.setup.AccountSubCategory;

public interface DaoAccountSubCategory {

    public List<AccountSubCategory> getAll(String hql);

    public int save(AccountSubCategory obj);

    public int update(AccountSubCategory obj);

    public int delete(String sql);

    public List getRecord(String sql);

    public String getMsg();

	
}
