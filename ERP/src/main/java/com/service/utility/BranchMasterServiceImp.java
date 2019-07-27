package com.service.utility;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import model.Message;
import com.config.JWTToken;
import com.dao.utility.DaoBranchMaster;
import com.model.utility.BranchMaster;
import com.model.utility.OrganizationMaster;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class BranchMasterServiceImp implements BranchMasterService {

	@Autowired
	DaoBranchMaster da;
	Message message = new Message();
	String msg = "", sql;
	int row;

	@Override
	public Object getAll() {
		/*
		 * sql=
		 * "SELECT B.id,B.code,B.name,B.parent,B.organization,O.code,O.name FROM public.branch_master B INNER JOIN public.organization_master O ON B.organization=O.id "
		 * ; sql="SELECT * FROM branch_master"; message.list= new
		 * DB().getRecord(sql); System.out.println(message.list); return
		 * message.list;
		 */
		return da.getAll("from BranchMaster order by organization,hierarchy,id");
	}

	@Override
	public Object save(String jsonData, String Authorization) {
		JWTToken td = new JWTToken(Authorization);
		if (!td.isStatus()) {
			return message.respondWithError("invalid token");
		}

		BranchMaster obj = new BranchMaster();
		try {
			Map map = new org.codehaus.jackson.map.ObjectMapper().readValue(jsonData,
					new org.codehaus.jackson.type.TypeReference<Map<String, String>>() {
					});
			String parent = map.get("parent").toString();
			System.out.println("Inside save method of branchmaster :: \n" + parent);
			String code = map.get("code").toString();
			System.out.println("Inside save method of branchmaster :: \n" + code);
			String name = map.get("name").toString();
			System.out.println("Inside save method of branchmaster :: \n" + name);
			String organization = map.get("organization").toString();
			System.out.println("Organization value :: \n" + organization);
			String sql, id;
			long tableId;
			obj.setCode(code);
			obj.setName(name);
			obj.setOrganization(new OrganizationMaster(organization));
			if (parent.length() == 0) {
				if (organization.length() == 1) {
					obj.setId(Long.parseLong(organization + "01"));
				} else {
					obj.setId(Long.parseLong(organization + "1"));
				}
				obj.setHierarchy(0);
				row = da.save(obj);
				if (row == 1) {
					return message.respondWithMessage("Success");
				}
				return message.respondWithError(da.getMsg());
			}

			sql = "SELECT coalesce(MAX(id),0) as nextid FROM branch_master WHERE parent=" + parent;
			List list = da.getRecord(sql);
			map = (Map) list.get(0);
			id = map.get("nextid").toString();
			sql = "SELECT hierarchy FROM branch_master WHERE id=" + parent;
			list = da.getRecord(sql);
			map = (Map) list.get(0);
			int hierarchy = Integer.parseInt(map.get("hierarchy").toString());
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

			obj.setId(Long.parseLong(id));
			obj.setParent(Long.parseLong(parent));
			obj.setHierarchy(hierarchy);
			row = da.save(obj);
			if (row == 1) {
				return message.respondWithMessage("Success");
			}
			return message.respondWithError(da.getMsg());
		} catch (IOException ex) {

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

			String code = map.get("code").toString();
			String name = map.get("name").toString();
			sql = "UPDATE branch_master SET code='" + code + "',name='" + name + "' WHERE id='" + id + "'";
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
			Logger.getLogger(BranchMasterServiceImp.class.getName()).log(Level.SEVERE, null, ex);
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
		sql = "DELETE FROM branch_master WHERE ID IN (" + id + ")";
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