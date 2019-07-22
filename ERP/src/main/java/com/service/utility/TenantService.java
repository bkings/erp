package com.service.utility;

import com.model.utility.Tenant ;
import java.util.List;

public interface TenantService {

    public Object getAll();

    public String save(Tenant obj, String Authorization);


}