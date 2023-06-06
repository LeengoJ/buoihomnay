package com.example.buoi3_s2.Controller;

import com.example.buoi3_s2.Model.Book;
import com.example.buoi3_s2.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> GetAll(){
        return bookService.getListBook();
    }
    @GetMapping("/books/{id}")
    public Book get(@PathVariable int id){
        return bookService.get(id);

    }
    @PostMapping("books/cr")
    public Book create(@RequestBody Book book){
        bookService.add(book);
        return book;
    }
    @DeleteMapping("/books/rm/{id}")
    public void delete(@PathVariable int id){
        bookService.remove(id);
    }
}
