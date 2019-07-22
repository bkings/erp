
package com.controller.form.utility;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;@Controller
@ComponentScan
public class BranchMasterController {
    @RequestMapping(value = "Utility/BranchMaster", method = RequestMethod.GET)
    public String doGet() {
        return "Utility/BranchMaster";
    } 

}