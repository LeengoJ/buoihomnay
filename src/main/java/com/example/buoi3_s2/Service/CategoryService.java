package com.example.buoi3_s2.Service;

import com.example.buoi3_s2.Model.Category;
import com.example.buoi3_s2.repository.CategoryRepository;
import com.example.buoi3_s2.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    public List<Category> GetAll () {
        return categoryRepository.findAll();
    }
}
