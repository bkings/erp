package com.controller.rest.setup;


import com.model.setup.AccountCategory;
import com.service.setup.AccountCategoryService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@RestController
@RequestMapping("api/Setup/AccountCategory")
@CrossOrigin
public class AccountCategoryRestController {

    @Autowired
    AccountCategoryService service;

    @GetMapping
    public Object index(@RequestHeader(value = "Authorization") String Authorization) {

        return service.getAll();
    }

    @PostMapping
    public Object doSave(@RequestBody AccountCategory obj, @RequestHeader(value = "Authorization") String Authorization) throws IOException {
    	System.out.println("inside the rest::save \n");
        return service.save(obj, Authorization);
    }

    @PutMapping("/{id}")
    public Object doUpdate(@RequestBody AccountCategory obj, @PathVariable long id, @RequestHeader(value = "Authorization") String Authorization) throws IOException {
        return service.update(obj,id,Authorization);
    }

    @DeleteMapping("/{id}")
    public Object doDelete(@PathVariable String id,@RequestHeader(value = "Authorization") String Authorization) {
        return service.delete(id,Authorization);
    }
}
