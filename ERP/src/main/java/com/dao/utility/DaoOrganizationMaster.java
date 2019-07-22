
package com.dao.utility;

import java.util.List;
import com.model.utility.OrganizationMaster;

public interface DaoOrganizationMaster {

    public List<OrganizationMaster> getAll(String hql);

    public int save(OrganizationMaster obj);

    public int update(OrganizationMaster obj);

    public int delete(String sql);

    public List getRecord(String sql);

    public String getMsg();
}
