package com.example.buoi3_s2.Service;

import com.example.buoi3_s2.Model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.security.Key;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BookService {
    List<Book> listBook = new ArrayList<>(Arrays.asList(
            new Book(1,"Lap trinh window","Nguyen Duy Cuong",99999),
            new Book(2,"Lap trinh Web","Nguyen Duy Cuong",12345),
            new Book(3,"Lap trinh ung dung java","Nguyen Duy Cuong",454534),
            new Book(4,"Thuong mai dien tu","Nguyen Dinh Anh",848593)
    ));

    public List<Book> getListBook() {
        return listBook;
    }

    public Book get(int id) {
         var findBook = listBook.stream().filter(p->p.getId()==id).findFirst().orElse(null);
         if(findBook==null)
             throw new ResponseStatusException(HttpStatus.NOT_FOUND);
         return findBook;

    }

    public void add(Book newbook){
        var maxId = listBook
                .stream()
                .mapToInt(v->v.getId())
                .max()
                .orElse(0);
        newbook.setId(maxId+1);
        listBook.add(newbook);
    }

    public void remove(int id){
        var findBook = listBook.stream().filter(p->p.getId()==id).findFirst().orElseThrow();
        listBook.remove(findBook);
    }
    public List<Book> search(String key){
        return listBook.stream().filter(p->p.getAuthor().toLowerCase().contains(key)||p.getTitle().toLowerCase().contains(key)).toList();
    }
}
