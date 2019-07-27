package com.service.setup;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.config.JWTToken;
import com.dao.setup.DaoAccountSubCategory;
import com.model.setup.AccountCategory;
import com.model.setup.AccountSubCategory;

import model.HibernateUtil;

@Service
public class AccountSubCategoryServiceImp implements AccountSubCategoryService {

	@Autowired
	DaoAccountSubCategory da;
	model.Message message = new model.Message();
	String msg = "", sql;
	int row;

	@Override
	public Object getAll() {
		return da.getAll("from AccountSubCategory order by accountCategory,acCode");
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
			System.out.println("Inside save method:: \n " + parent);
			/*long acCode = (long) map.get("ac_code");
			System.out.println("Inside save method:: \n " + acCode); */
			String acName = map.get("acName").toString();
			System.out.println("Inside save method:: \n " + acName);
			String accountCategory = map.get("accountCategory").toString();
			System.out.println("after acc category == " + accountCategory );
			String sql, id;
			long tableId;
//			obj.setAcCode(acCode);
			obj.setAcName(acName);
			obj.setAccountCategory(new AccountCategory(accountCategory));
			System.out.println("parent length " + parent.length());
			if (parent.length() == 0) {
				if (accountCategory.length() == 1) {
					obj.setAcCode(Long.parseLong(accountCategory + "01"));
				} else {
					obj.setAcCode(Long.parseLong(accountCategory + "1"));
				}
				System.out.println("before save");
				row = da.save(obj);
				System.out.println("after save");
				if (row == 1) {
					return message.respondWithMessage("Success");
				}
				return message.respondWithError(da.getMsg());
			}

			System.out.println("out of if condn");
			
			sql = "SELECT coalesce(MAX(acCode),0) as nextid FROM account_sub_category WHERE mgrCode=" + parent;
			List list = da.getRecord(sql);
			map = (Map) list.get(0);
			id = map.get("nextid").toString();
			
			System.out.println("running where id = " + id);

			if (id.equalsIgnoreCase("0")) {
				id = parent + "00";
			}
			
			System.out.println("parent length = " + parent.length() + "and id length = " + id.length());
			
			id = id.substring(parent.length(), id.length());
			
			System.out.println("id from substring " + id);
			
			tableId = Long.parseLong(id);
			
			System.out.println("table id before " + tableId);
			
			tableId = tableId + 1;
			
			System.out.println("table id after " + tableId);
			
			if (tableId < 10) {
				id = parent + "0" + tableId;
			} else {
				id = parent + "" + tableId;
			}
			
			System.out.println("ID later is " + id);

			obj.setAcCode(Long.parseLong(id));
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
		
		
		
		Session session = HibernateUtil.getSession();
		Transaction tr = session.beginTransaction();
		String sqlQuery = "SELECT * FROM account_sub_category WHERE acCode= '"+id+"' ";
		
		AccountSubCategory obj = (AccountSubCategory) session.createSQLQuery(sqlQuery).list();
		System.out.println("mgr code is ::: \n" + obj.getMgrCode());
		
		if(obj.getMgrCode() != null){
			row = da.delete(sql);
			msg = da.getMsg();
			sql = "DELETE FROM account_sub_category WHERE acCode IN (" + id + ")";
			if (row > 0) {
				return message.respondWithMessage("Success");
			} else if (msg.contains("foreign key")) {
				msg = "this record already used in reference tables, Cannot delete of this record";
			}
			
		}else{
			System.out.println("Parent lai delete garna khojchas?? \n");
		}
		return message.respondWithError(msg);
	}
	
}
