package com.izayoi.storage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.izayoi.storage.entity.Storage;
import com.izayoi.storage.repository.StorageRepository;

@Service
public class StorageService {

	@Autowired
	private StorageRepository storageRepo;

	@Transactional
	public void deduct(String commodityCode, int count) {
		Storage storage = storageRepo.findByCommodityCode(commodityCode);
		storage.setCount(storage.getCount() - count);

		storageRepo.save(storage);
	}
}
