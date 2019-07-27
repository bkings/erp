package com.controller.form.setup;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@ComponentScan
public class AccountSubCategoryController {

	@RequestMapping(value = "Setup/AccountSubCategory", method = RequestMethod.GET)
	public String doGet() {
		return "Setup/AccountSubCategory";
	}
}
