package com.lambdaschool.starthere.controllers;

import com.lambdaschool.starthere.logging.Loggable;
import com.lambdaschool.starthere.models.Author;
import com.lambdaschool.starthere.models.Book;
import com.lambdaschool.starthere.services.AuthorService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Loggable
@RestController
@RequestMapping("/authors")
public class AuthorController
{
    @Autowired
    AuthorService authorService;

    //students/students/paging?page=1&size=10&sort=studname
    @ApiOperation(value = "Return All Authors w/Paging", response = Book.class, responseContainer = "List")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query",
                    value = "Results page you want to retrieve (0..N)"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
                    value = "Number of records per page."),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                    value = "Sorting criteria in the format: property(,asc|desc). " +
                            "Default sort order is ascending. " +
                            "Multiple sort criteria are supported.")})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "List Of All Authors w/Paging", response = Book.class)})
    @GetMapping(value = "/authors/paging", produces = {"application/json"})
    public ResponseEntity<?> listAllBooksByPage(
            @PageableDefault(page = 0,
                    size = 3)
                    Pageable pageable)
    {
        List<Author> myAuthors = authorService.findAllPageable(pageable);
        return new ResponseEntity<>(myAuthors, HttpStatus.OK);
    }

    @ApiOperation(value = "List of Authors", response = Book.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "List Of All Authors", response = Book.class)})
    @GetMapping(value = "/authors", produces = {"application/json"})
    public ResponseEntity<?> listAllBooks()
    {
        List<Author> myAuthors = authorService.findAll();
        return new ResponseEntity<>(myAuthors, HttpStatus.OK);
    }
}
