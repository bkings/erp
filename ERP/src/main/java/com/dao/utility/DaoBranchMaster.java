
package com.dao.utility;

import java.util.List;
import com.model.utility.BranchMaster;

public interface DaoBranchMaster {

    public List<BranchMaster> getAll(String hql);

    public int save(BranchMaster obj);

    public int update(BranchMaster obj);

    public int delete(String sql);

    public List getRecord(String sql);

    public String getMsg();
}
