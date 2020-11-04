package org.example.mapper;

import org.example.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductMapper extends JpaRepository<Product, Integer> {
}
