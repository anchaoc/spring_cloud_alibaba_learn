package org.example.mapper;

import org.example.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderMapper extends JpaRepository<Order, Integer> {
}
