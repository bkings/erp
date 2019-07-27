package com;

import com.config.JWTToken;
import com.dao.utility.DaoBranchMaster;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.MultipartConfigElement;
import javax.servlet.http.HttpSession;
import model.DB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@CrossOrigin
@ComponentScan
public class WelcomeController {

	@Autowired
	DaoBranchMaster da;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(HttpSession session) {
		System.out.println("OKOK");
		// return "hello";
		String token = "Bearer " + com.config.JWTToken.get("MS", "Manoj", "ADMIN", "All");
		System.out.println("TOKEN :: \n " + token);
		//
		// session.setAttribute("token", token);
		// System.out.println(session.getAttribute("token"));
		return "index";
	}

	@RequestMapping(value = "/Login", method = RequestMethod.POST)
	@ResponseBody
	public Object login(@RequestBody String jsonData) {
		Map map = new HashMap();
		model.Message message = new model.Message();
		String userName, branch;
		try {
			map = new org.codehaus.jackson.map.ObjectMapper().readValue(jsonData,
					new org.codehaus.jackson.type.TypeReference<Map<String, String>>() {
					});
		} catch (IOException e) {
			return message.respondWithError("not valid json format ");
		}
		try {
			String loginId = map.get("loginId").toString();
			String password = map.get("password").toString();
			String enpassword = message.encryptText(password);
			
			System.out.println("Login ID = " + loginId);
			System.out.println("Encrypted password = \n" + enpassword);
			
			String sql = "SELECT login_id loginId,coalesce(branch,'0') branch,user_name userName,status,coalesce(password,'') AS password FROM organization_user WHERE login_id='"
					+ loginId + "' OR email='" + loginId + "'";
			DB db = new DB();
			List list = db.getRecord(sql);

			try {
				if (list.isEmpty() || list.size() == 0) {
					return message.respondWithError("invalid login id");
				}
			} catch (Exception e) {
				return message.respondWithError("try again");
			}
			map = (Map) list.get(0);

			password = map.get("password").toString();
			if (!password.equalsIgnoreCase(enpassword)) {
				return message.respondWithError("invalid password");
			}
			loginId = map.get("loginid").toString();
			userName = map.get("username").toString();
			branch = map.get("branch").toString();
			String token = JWTToken.get(loginId, userName, branch, "");
			
			System.out.println("Token is :: \n" + token);
			
			map = new HashMap();
			sql = "UPDATE organization_user SET token='" + token + "' WHERE login_id='" + loginId + "'";
			db.save(sql);
			map.put("token", token);
			map.put("userName", userName);
			map.put("loginId", loginId);
			map.put("message", "Success");
			map.put("branch", da.getAll("from BranchMaster where id=" + branch));
		} catch (Exception e) {
		}
		// BranchMaster obj

		System.out.println("token from map is :::: \n" + map.get("token") + "\n");
		
		return map;
	}

	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		factory.setMaxFileSize("1024MB");
		factory.setMaxRequestSize("1024MB");
		return factory.createMultipartConfig();
	}
}
