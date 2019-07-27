
package com.controller.form.setup;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@ComponentScan
public class AccountCategoryController {

    @RequestMapping(value = "Setup/AccountCategory", method = RequestMethod.GET)
    public String doGet() {
    	System.out.println("Inside Setup/AccountCategory");
//        return "${pageContext.request.contextPath}/Setup/AccountCategory";
        return "Setup/AccountCategory";
//    	return "Setup/hello";
    }
    
    @RequestMapping(value="sum",method=RequestMethod.GET)
    public String getSomeValue(){
    	System.out.println("HERE inside getSomeValue");
    	return "Setup/hello";
    }
}