package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.logging.Loggable;
import com.lambdaschool.starthere.models.Author;
import com.lambdaschool.starthere.models.Book;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Loggable
@Service(value = "authorService")
public class AuthorServiceImpl implements AuthorService
{
    @Override
    public List<Author> findAllPageable(Pageable pageable)
    {
        return null;
    }

    @Override
    public List<Author> findAll()
    {
        return null;
    }
}
