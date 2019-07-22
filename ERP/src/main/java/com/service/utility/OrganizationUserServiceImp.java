/*    map = new org.codehaus.jackson.map.ObjectMapper().readValue(jsonData, new org.codehaus.jackson.type.TypeReference<Map<String, String>>() {});
        */

package com.service.utility;

import com.config.JWTToken;
import com.dao.utility.DaoOrganizationUser;
import com.model.utility.OrganizationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationUserServiceImp implements OrganizationUserService {

    @Autowired
    DaoOrganizationUser da;
    model.Message message = new model.Message();
    String msg = "", sql;
    int row;

    @Override
    public Object getAll() {
        return da.getAll("from OrganizationUser");
    }

    @Override
    public Object save(OrganizationUser obj, String Authorization) {
        JWTToken td = new JWTToken(Authorization);
        if (!td.isStatus()) {
            return message.respondWithError("invalid token");
        }
        try {
             String enpassword = message.encryptText(obj.getPassword());
             obj.setPassword(enpassword);
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

    @Override
    public Object update(OrganizationUser obj,String id,String Authorization) {
        JWTToken td = new JWTToken(Authorization);
        if (!td.isStatus()) {
            return message.respondWithError("invalid token");
        }
sql="UPDATE organization_user SET login_id='"+obj.getLoginId()+"',address='"+obj.getAddress()+"',email='"+obj.getEmail()+"',mobile='"+obj.getMobile()+"',status='"+obj.getStatus()+"',user_name='"+obj.getUserName()+"',branch='"+obj.getBranch().getId()+"' WHERE login_id='"+id+"'";
    row=da.delete(sql);
msg = da.getMsg();
        if (row > 0) {
            return message.respondWithMessage("Success");
        }else if (msg.contains("Duplicate entry")) {
                    msg = "This record already exist";
                } else if (msg.contains("foreign key")) {
            msg = "this record already used in reference tables, Cannot delete of this record";
        }
        return message.respondWithError(msg);    }

    @Override
    public Object delete(String id,String Authorization) {
        JWTToken td = new JWTToken(Authorization);
        if (!td.isStatus()) {
            return message.respondWithError("invalid token");
        }

        id = "'" + id.replace(",", "','") + "'";
        sql = "DELETE FROM organization_user WHERE login_id IN (" + id + ")";
        row = da.delete(sql);
        msg = da.getMsg();
        if (row > 0) {
            return message.respondWithMessage("Success");
        } else if (msg.contains("foreign key")) {
            msg = "this record already used in reference tables, Cannot delete of this record";
        }
        return message.respondWithError(msg);    }
}
