package com.example.buoi3_s2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookControler {
        @GetMapping("/")
    public String WellCome(){
            return ("Well come to me");
        }
}
