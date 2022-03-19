package com.ebiznes.elektronik.repository;

import com.ebiznes.elektronik.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long>
{
}
