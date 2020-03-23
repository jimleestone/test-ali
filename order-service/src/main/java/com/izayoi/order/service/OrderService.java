package com.izayoi.order.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.izayoi.order.entity.Order;
import com.izayoi.order.feign.AccountFeignClient;
import com.izayoi.order.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private AccountFeignClient accountFeignClient;

	@Autowired
	private OrderRepository orderRepo;

	@Transactional
	public void create(String userId, String commodityCode, Integer count) {

		BigDecimal orderMoney = new BigDecimal(count).multiply(new BigDecimal(5));

		Order order = new Order();
		order.setUserId(userId);
		order.setCommodityCode(commodityCode);
		order.setCount(count);
		order.setMoney(orderMoney);

		orderRepo.save(order);

		accountFeignClient.debit(userId, orderMoney);

	}
}
