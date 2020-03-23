package com.izayoi.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.izayoi.order.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
