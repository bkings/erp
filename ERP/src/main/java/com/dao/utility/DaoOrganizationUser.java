
package com.dao.utility;

import java.util.List;
import com.model.utility.OrganizationUser;

public interface DaoOrganizationUser {

    public List<OrganizationUser> getAll(String hql);

    public int save(OrganizationUser obj);

    public int update(OrganizationUser obj);

    public int delete(String sql);

    public List getRecord(String sql);

    public String getMsg();
}
