package com.service.setup;

import com.model.setup.AccountCategory ;
import java.util.List;

public interface AccountCategoryService {

    public List<AccountCategory> getAll();

    public String save(AccountCategory obj, String Authorization);

    public String update(AccountCategory obj,long id, String Authorization);

    public String delete(String id,String Authorization);

}