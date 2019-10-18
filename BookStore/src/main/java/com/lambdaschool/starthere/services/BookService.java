package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.models.Author;
import com.lambdaschool.starthere.models.Book;

import java.awt.print.Pageable;
import java.util.List;

public interface BookService
{
    List<Book> findAllPageable(Pageable pageable);

    List<Book> findAll();
}
