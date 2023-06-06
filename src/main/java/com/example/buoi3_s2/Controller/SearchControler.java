package com.example.buoi3_s2.Controller;


import com.example.buoi3_s2.Model.Book;
import com.example.buoi3_s2.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SearchControler {
    @Autowired
    private BookService bookService;
    @GetMapping("/search")
    public List<Book> search(@RequestParam String key)
    {
        return bookService.search(key);
    }
}