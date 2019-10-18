package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.logging.Loggable;
import com.lambdaschool.starthere.models.Book;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Loggable
@Service(value = "bookService")
public class BookServiceImpl implements BookService
{
    @Override
    public List<Book> findAllPageable(Pageable pageable)
    {
        return null;
    }

    @Override
    public List<Book> findAll()
    {
        return null;
    }

}
