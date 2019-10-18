package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.logging.Loggable;
import com.lambdaschool.starthere.models.Author;
import com.lambdaschool.starthere.models.Book;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

public interface AuthorService
{
    List<Author> findAllPageable(Pageable pageable);

    List<Author> findAll();
}
