package com.ebiznes.elektronik.repository;

import com.ebiznes.elektronik.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>
{
}
