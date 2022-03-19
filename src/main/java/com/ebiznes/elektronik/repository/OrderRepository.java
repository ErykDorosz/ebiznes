package com.ebiznes.elektronik.repository;

import com.ebiznes.elektronik.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long>
{
}
