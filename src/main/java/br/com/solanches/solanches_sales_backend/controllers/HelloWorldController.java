package br.com.solanches.solanches_sales_backend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping
    public String helloWorld() {
        return "Hello World!";
    }
}
