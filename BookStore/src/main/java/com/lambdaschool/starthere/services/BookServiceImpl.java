package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.logging.Loggable;
import com.lambdaschool.starthere.models.Author;
import com.lambdaschool.starthere.models.Book;
import com.lambdaschool.starthere.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Loggable
@Service(value = "bookService")
public class BookServiceImpl implements BookService
{
    @Autowired
    BookRepository bookRepos;

    @Override
    public List<Book> findAllPageable(Pageable pageable)
    {
        List<Book> list = new ArrayList<>();
        bookRepos.findAll(pageable)
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }

    @Override
    public List<Book> findAll()
    {
        List<Book> list = new ArrayList<>();
        bookRepos.findAll()
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }

}
