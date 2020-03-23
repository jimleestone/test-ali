package com.izayoi.account.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

@Data
@Entity
@Table(name = "account_tbl")
@DynamicUpdate
@DynamicInsert
public class Account {

	@Id
	private Long id;
	private String userId;
	private BigDecimal money;

}
