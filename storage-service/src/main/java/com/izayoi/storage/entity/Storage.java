package com.izayoi.storage.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

@Data
@Entity
@Table(name = "storage_tbl")
@DynamicUpdate
@DynamicInsert
public class Storage {

	@Id
	private Long id;
	private String commodityCode;
	private Integer count;

}
