package com.example.buoi3_s2.Service;

import com.example.buoi3_s2.Model.Product;
import com.example.buoi3_s2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public List<Product> GetAll() {
        return productRepository.findAll();
    }
    public void add(Product product) {
        productRepository.save(product);
    }
    public Optional<Product> get(int id) {
        return productRepository.findById(String.valueOf(id));
    }

    public void edit(Product editProduct) {
        productRepository.save(editProduct);
    }
}
