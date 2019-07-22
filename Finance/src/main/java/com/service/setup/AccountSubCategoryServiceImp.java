package com.service.setup;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.config.JWTToken;
import com.dao.setup.DaoAccountSubCategory;
import com.model.setup.AccountCategory;
import com.model.setup.AccountSubCategory;

@Service
public class AccountSubCategoryServiceImp implements AccountSubCategoryService {

	@Autowired
	DaoAccountSubCategory da;
	model.Message message = new model.Message();
	String msg = "", sql;
	int row;

	@Override
	public Object getAll() {
		return da.getAll("from AccountSubCategory order by accountCategory,acName,acCode");
	}

	@Override
	public Object save(String jsonData, String Authorization) {
		JWTToken td = new JWTToken(Authorization);
		if (!td.isStatus()) {
			return message.respondWithError("invalid token");
		}

		AccountSubCategory obj = new AccountSubCategory();

		try {
			Map map = new org.codehaus.jackson.map.ObjectMapper().readValue(jsonData,
					new org.codehaus.jackson.type.TypeReference<Map<String, String>>() {
					});
			String parent = map.get("mgrCode").toString();
			long acCode = (long) map.get("acCode");
			String acName = map.get("acName").toString();
			String accountCategory = map.get("accountCategory").toString();
			String sql, id;
			long tableId;
			obj.setAcCode(acCode);
			obj.setAcName(acName);
			obj.setAccountCategory(new AccountCategory(accountCategory));
			if (parent.length() == 0) {
				if (accountCategory.length() == 1) {
					obj.setAcCode(Long.parseLong(accountCategory + "01"));
				} else {
					obj.setAcCode(Long.parseLong(accountCategory + "1"));
				}
				row = da.save(obj);
				if (row == 1) {
					return message.respondWithMessage("Success");
				}
				return message.respondWithError(da.getMsg());
			}

			sql = "SELECT coalesce(MAX(acCode),0) as nextid FROM account_sub_category WHERE mgrCode=" + parent;
			List list = da.getRecord(sql);
			map = (Map) list.get(0);
			id = map.get("nextid").toString();

			if (id.equalsIgnoreCase("0")) {
				id = parent + "00";
			}
			id = id.substring(parent.length(), id.length());
			tableId = Long.parseLong(id);
			tableId = tableId + 1;

			if (tableId < 10) {
				id = parent + "0" + tableId;
			} else {
				id = parent + "" + tableId;
			}

			obj.setMgrCode(Long.parseLong(parent));
			row = da.save(obj);
			if (row == 1) {
				return message.respondWithMessage("Success");
			}
			return message.respondWithError(da.getMsg());

		} catch (Exception e) {

		}

		return message.respondWithError(msg);

	}

	@Override
	public Object update(String jsonData, long id, String Authorization) {
		try {

			JWTToken td = new JWTToken(Authorization);
			if (!td.isStatus()) {
				return message.respondWithError("invalid token");
			}
			System.out.println(jsonData);
			Map map = new org.codehaus.jackson.map.ObjectMapper().readValue(jsonData,
					new org.codehaus.jackson.type.TypeReference<Map<String, String>>() {
					});

			String acName = map.get("acName").toString();
			sql = "UPDATE account_sub_category SET acName='" + acName + "' WHERE acCode='" + id + "'";
			row = da.delete(sql);
			msg = da.getMsg();
			if (row > 0) {
				return message.respondWithMessage("Success");
			} else if (msg.contains("Duplicate entry")) {
				msg = "This record already exist";
			} else if (msg.contains("foreign key")) {
				msg = "this record already used in reference tables, Cannot delete of this record";
			}

		} catch (IOException ex) {
			Logger.getLogger(AccountSubCategoryServiceImp.class.getName()).log(Level.SEVERE, null, ex);
		}
		return message.respondWithError(msg);
	}

	@Override
	public Object delete(String id, String Authorization) {
		JWTToken td = new JWTToken(Authorization);
		if (!td.isStatus()) {
			return message.respondWithError("invalid token");
		}

		id = "'" + id.replace(",", "','") + "'";
		sql = "DELETE FROM account_sub_category WHERE acCode IN (" + id + ")";
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
