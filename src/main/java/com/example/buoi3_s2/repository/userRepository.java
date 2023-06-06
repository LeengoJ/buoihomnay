package com.example.buoi3_s2.repository;

import com.example.buoi3_s2.Model.Product;
import com.example.buoi3_s2.Model.User;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface userRepository extends JpaRepository<User, String> {

    public static User getUserByUsername(String username) {
        return null;
    }
}
