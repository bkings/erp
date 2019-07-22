
package com.dao.utility;

import java.util.List;
import com.model.utility.Tenant;

public interface DaoTenant {

    public List<Tenant> getAll(String hql);

    public int save(Tenant obj);

    public String getMsg();
}
