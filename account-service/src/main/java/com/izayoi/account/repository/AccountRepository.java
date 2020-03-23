package com.izayoi.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.izayoi.account.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	Account findByUserId(String userId);

}
