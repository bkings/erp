package com.controller.form.setup;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@ComponentScan
public class AccountSubCategoryController {

    @RequestMapping(value = "Setup/AccountSubCategory", method = RequestMethod.GET)
	public String doGet(){
		return "Setup/AccountSubCategory";
	}
	
}
