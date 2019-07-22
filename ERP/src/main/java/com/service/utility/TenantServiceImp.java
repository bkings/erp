/*    map = new org.codehaus.jackson.map.ObjectMapper().readValue(jsonData, new org.codehaus.jackson.type.TypeReference<Map<String, String>>() {});
        */

package com.service.utility;

import com.config.JWTToken;
import com.dao.utility.DaoTenant;
import com.model.utility.Tenant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TenantServiceImp implements TenantService {

    @Autowired
    DaoTenant da;
    model.Message message = new model.Message();
    String msg = "", sql;
    int row;

    @Override
    public Object getAll() {
        Tenant obj=new Tenant();
      List<Tenant> list=da.getAll("from Tenant");
      if(list.isEmpty())
      {
      obj.setId(1l);
      obj.setCode("CODE");
      obj.setName("NAME");
      da.save(obj);
      }else obj=list.get(0);
        return obj;
    }

    @Override
    public String save(Tenant obj, String Authorization) {
        JWTToken td = new JWTToken(Authorization);
        if (!td.isStatus()) {
            return message.respondWithError("invalid token");
        }
        try {
          
            obj.setId(1l);  
            obj.setCode(obj.getCode().toUpperCase());
            row = da.save(obj);
            msg = da.getMsg();
            if (row > 0) {
                return message.respondWithMessage("Success");
            } else if (msg.contains("Duplicate entry")) {
                    msg = "This record already exist";
                }
                return message.respondWithError(msg);

        } catch(Exception e) {
            return message.respondWithError(e.getMessage());
        }
    }

}
