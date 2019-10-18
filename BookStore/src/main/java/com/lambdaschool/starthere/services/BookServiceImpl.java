package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.logging.Loggable;
import com.lambdaschool.starthere.models.Author;
import com.lambdaschool.starthere.models.Book;
import com.lambdaschool.starthere.repository.AuthorRepository;
import com.lambdaschool.starthere.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Loggable
@Service(value = "bookService")
public class BookServiceImpl implements BookService
{

    @Autowired
    BookRepository bookRepos;

    @Autowired
    AuthorRepository authorRepos;

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

    @Override
    public void update(Book updateBook, long id)
    {
        Book oldBook=bookRepos.findById(id).orElseThrow(()->new EntityNotFoundException());
        if (updateBook.getTitle()!=null)
        {
            oldBook.setTitle(updateBook.getTitle());
        }
        if (updateBook.getIsbn()!=null)
        {
            oldBook.setIsbn(updateBook.getIsbn());
        }
        if (updateBook.getCopy()!=0)
        {
            oldBook.setCopy(updateBook.getCopy());
        }
        bookRepos.save(oldBook);
    }

    @Override
    public Book updateBookAuthor(long bookid, long authorid)
    {
        Book book=bookRepos.findById(bookid).orElseThrow(()->new EntityNotFoundException());
        Author author=authorRepos.findById(authorid).orElseThrow(()->new EntityNotFoundException());
        book.getAuthors().add(author);
        book= bookRepos.save(book);
        return book;
    }

    @Override
    public void delete(long id)
    {
        Book book=bookRepos.findById(id).orElseThrow(()->new EntityNotFoundException());
        bookRepos.delete(book);
    }
}
