package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.models.Book;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService
{
    List<Book> findAllPageable(Pageable pageable);

    List<Book> findAll();

    void update(Book updateBook,long id);

    Book updateBookAuthor(long bookid, long authorid);

    void delete(long id);
}
