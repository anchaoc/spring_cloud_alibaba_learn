package org.example.mapper;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderMapper extends JpaRepository<Order, Integer> {
}
