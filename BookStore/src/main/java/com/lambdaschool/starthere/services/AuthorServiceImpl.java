package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.logging.Loggable;
import com.lambdaschool.starthere.models.Author;
import com.lambdaschool.starthere.models.Book;
import com.lambdaschool.starthere.models.Role;
import com.lambdaschool.starthere.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Loggable
@Service(value = "authorService")
public class AuthorServiceImpl implements AuthorService
{
    @Autowired
    AuthorRepository authorRepos;

    @Override
    public List<Author> findAllPageable(Pageable pageable)
    {
            List<Author> list = new ArrayList<>();
            authorRepos.findAll(pageable)
                    .iterator()
                    .forEachRemaining(list::add);
            return list;
    }

    @Override
    public List<Author> findAll()
    {
    List<Author> list = new ArrayList<>();
        authorRepos.findAll()
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }
}
