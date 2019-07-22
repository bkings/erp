package com.service.utility;

import com.model.utility.OrganizationUser ;
public interface OrganizationUserService {

    public Object getAll();

    public Object save(OrganizationUser obj, String Authorization);

    public Object update(OrganizationUser obj,String id, String Authorization);

    public Object delete(String id,String Authorization);

}