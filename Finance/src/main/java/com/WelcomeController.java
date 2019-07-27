package com;

import com.config.JWTToken;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.MultipartConfigElement;
import model.DB;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
@ComponentScan
public class WelcomeController {

	@RequestMapping(value = "api/welcome", method = RequestMethod.GET)
	@ResponseBody
	public Object loginCheck(@RequestHeader(value = "Authorization") String Authorization) {
		
		System.out.println("Inside api welcome");
		
		JWTToken td = new JWTToken(Authorization);
		model.Message message = new model.Message();
		if (!td.isStatus()) {
			return message.respondWithError("invalid token");
		}
		Map map = new HashMap();//
		String branch = td.getBranch();
		String sql = "SELECT concat(id,'') id,code,name,parent FROM public.branch_master WHERE concat(id,'') LIKE '"
				+ branch + "%' ORDER BY id";
		map.put("branchList", new DB().getRecord(sql));
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
