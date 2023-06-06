package com.example.buoi3_s2.repository;

import com.example.buoi3_s2.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,String> {
}
