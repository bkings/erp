package com.controller.rest.account;

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

import com.model.account.BalanceSheet;
import com.model.setup.AccountCategory;
import com.service.account.BalanceSheetService;

@RestController
@RequestMapping("api/Account/BalanceSheet")
@CrossOrigin
public class BalanceSheetRestController {

	@Autowired
	BalanceSheetService service;

	@GetMapping
	public Object index(@RequestHeader(value = "Authorization") String Authorization) {

		return service.getAll();
	}

	@PostMapping
	public Object doSave(@RequestBody BalanceSheet obj, @RequestHeader(value = "Authorization") String Authorization)
			throws IOException {
		System.out.println("inside the get mapping request \n");
		return service.save(obj, Authorization);
	}

	@PutMapping("/{number}")
	public Object doUpdate(@RequestBody BalanceSheet obj, @PathVariable long number,
			@RequestHeader(value = "Authorization") String Authorization) throws IOException {
		return service.update(obj, number, Authorization);
	}

	@DeleteMapping("/{number}")
	public Object doDelete(@PathVariable String number, @RequestHeader(value = "Authorization") String Authorization) {
		return service.delete(number, Authorization);
	}

}
