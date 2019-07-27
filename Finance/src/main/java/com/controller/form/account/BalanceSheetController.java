package com.controller.form.account;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@ComponentScan
public class BalanceSheetController {

    @RequestMapping(value = "Account/BalanceSheet", method = RequestMethod.GET)
    public String doGet() {
        return "Account/BalanceSheet";
    }

	
}
