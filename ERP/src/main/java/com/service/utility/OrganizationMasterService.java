package com.service.utility;

import com.model.utility.OrganizationMaster ;
import java.util.List;

public interface OrganizationMasterService {

    public Object getAll();

    public Object save(OrganizationMaster obj, String Authorization);

    public Object update(OrganizationMaster obj,long id, String Authorization);

    public Object delete(String id,String Authorization);

}