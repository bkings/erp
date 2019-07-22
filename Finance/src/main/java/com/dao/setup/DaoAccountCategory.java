
package com.dao.setup;

import java.util.List;
import com.model.setup.AccountCategory;

public interface DaoAccountCategory {

    public List<AccountCategory> getAll(String hql);

    public int save(AccountCategory obj);

    public int update(AccountCategory obj);

    public int delete(String sql);

    public List getRecord(String sql);

    public String getMsg();
}
