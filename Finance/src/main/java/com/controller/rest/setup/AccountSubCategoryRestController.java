package com.controller.rest.setup;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.setup.AccountCategory;
import com.model.setup.AccountSubCategory;
import com.service.setup.AccountSubCategoryService;

@RestController
@RequestMapping("api/Setup/AccountSubCategory")
@CrossOrigin
public class AccountSubCategoryRestController {

	@Autowired
	AccountSubCategoryService service;
	
	@GetMapping
	public Object index(@RequestHeader(value = "Authorization") String Authorization) {
		return service.getAll();
	}

	@PostMapping
	public Object doSave(@RequestBody String jsonData, @RequestHeader(value = "Authorization") String Authorization)
			throws IOException {
		return service.save(jsonData, Authorization);
	}

	@PutMapping("/{id}")
	public Object doUpdate(@RequestBody String jsonData, @PathVariable long id,
			@RequestHeader(value = "Authorization") String Authorization) throws IOException {
		System.out.println(Authorization);
		return service.update(jsonData, id, Authorization);
	}

	@DeleteMapping("/{id}")
	public Object doDelete(@PathVariable String id, @RequestHeader(value = "Authorization") String Authorization) {
		return service.delete(id, Authorization);
	}

	
}
