package com.izayoi.account.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.izayoi.account.entity.Account;
import com.izayoi.account.repository.AccountRepository;

@Service
public class AccountService {

	private static final String ERROR_USER_ID = "1002";

	@Autowired
	private AccountRepository accountRepo;

	@Transactional(rollbackFor = Exception.class)
	public void debit(String userId, BigDecimal num) {
		Account account = accountRepo.findByUserId(userId);
		account.setMoney(account.getMoney().subtract(num));
		accountRepo.save(account);

		if (ERROR_USER_ID.equals(userId)) {
			throw new RuntimeException("account branch exception");
		}
	}
}
