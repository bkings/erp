package com.service.account;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.config.JWTToken;
import com.dao.account.DaoBalanceSheet;
import com.model.account.BalanceSheet;

import model.Message;

@Service
public class BalanceSheetServiceImp implements BalanceSheetService {

	@Autowired
	DaoBalanceSheet da;
	Message message = new Message();
	String msg = "",sql;
	int row;
	
	@Override
	public List<BalanceSheet> getAll() {
		System.out.println("insdie service imp \n");
		return da.getAll("from BalanceSheet");
	}

	@Override
	public String save(BalanceSheet obj, String Authorization) {
        JWTToken td = new JWTToken(Authorization);
        if (!td.isStatus()) {
            return message.respondWithError("invalid token");
        }

        try {
        	try {
        		System.out.println("inside save method");
        		sql = "SELECT coalesce(MAX(number),0)+1 AS number FROM balance_sheet";
        		System.out.println("inside save method 1");
        		message.map = (Map) da.getRecord(sql).get(0);
        		obj.setNumber(Long.parseLong(message.map.get("number").toString()));
        		System.out.println("inside save method 3");
			} catch (Exception e) {
				return message.respondWithError("connection error or invalid table name");
			}
        	row = da.save(obj);
        	msg = da.getMsg();
            if (row > 0) {
                return message.respondWithMessage("Success");
            } else if (msg.contains("Duplicate entry")) {
                msg = "This record already exist";
            }
            return message.respondWithError(msg);
	
		} catch (Exception e) {
			return message.respondWithError(e.getMessage());
		}
        
	}

	@Override
	public String update(BalanceSheet obj, long number, String Authorization) {
        JWTToken td = new JWTToken(Authorization);
        if (!td.isStatus()) {
            return message.respondWithError("invalid token");
        }
        obj.setNumber(number);
        row = da.update(obj);
        msg = da.getMsg();
        if (row > 0) {
            return message.respondWithMessage("Success");
        } else if (msg.contains("Duplicate entry")) {
            msg = "This record already exist";
        } else if (msg.contains("foreign key")) {
            msg = "this record already used in reference tables, Cannot delete of this record";
        }
        return message.respondWithError(msg);
    }

	@Override
	public String delete(String number, String Authorization) {
        JWTToken td = new JWTToken(Authorization);
        if (!td.isStatus()) {
            return message.respondWithError("invalid token");
        }

        number = "'" + number.replace(",", "','") + "'";
        sql = "DELETE FROM balance_sheet WHERE number IN (" + number + ")";
        row = da.delete(sql);
        msg = da.getMsg();
        if (row > 0) {
            return message.respondWithMessage("Success");
        } else if (msg.contains("foreign key")) {
            msg = "this record already used in reference tables, Cannot delete of this record";
        }
        return message.respondWithError(msg);
	}

}
