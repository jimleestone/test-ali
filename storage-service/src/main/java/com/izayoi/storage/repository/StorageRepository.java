package com.izayoi.storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.izayoi.storage.entity.Storage;

@Repository
public interface StorageRepository extends JpaRepository<Storage, Long> {

	Storage findByCommodityCode(String commodityCode);

}
