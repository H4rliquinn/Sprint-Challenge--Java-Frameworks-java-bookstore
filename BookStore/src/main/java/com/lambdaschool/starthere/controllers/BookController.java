package com.lambdaschool.starthere.controllers;

import com.lambdaschool.starthere.logging.Loggable;
import com.lambdaschool.starthere.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Loggable
@RestController
@RequestMapping("/books")
public class BookController
{
    @Autowired
    BookService bookService;


}
