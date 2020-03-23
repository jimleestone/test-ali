package com.izayoi.account.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.izayoi.account.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;

	@RequestMapping("/debit")
	public Boolean debit(String userId, BigDecimal money) {
		accountService.debit(userId, money);
		return true;
	}
}
