package com.izayoi.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.izayoi.business.feign.OrderFeignClient;
import com.izayoi.business.feign.StorageFeignClient;

import io.seata.spring.annotation.GlobalTransactional;

@Service
public class BusinessService {

	@Autowired
	private StorageFeignClient storageFeignClient;

	@Autowired
	private OrderFeignClient orderFeignClient;

	@GlobalTransactional
	public void purchase(String userId, String commodityCode, int orderCount) {
		storageFeignClient.deduct(commodityCode, orderCount);

		orderFeignClient.create(userId, commodityCode, orderCount);
	}
}
