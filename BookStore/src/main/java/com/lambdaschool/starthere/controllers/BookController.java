package com.lambdaschool.starthere.controllers;

import com.lambdaschool.starthere.logging.Loggable;
import com.lambdaschool.starthere.models.Book;
import com.lambdaschool.starthere.models.User;
import com.lambdaschool.starthere.services.BookService;
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
@RequestMapping("/books")
public class BookController
{
    @Autowired
    BookService bookService;

    @ApiOperation(value = "Return All Books w/Paging", response = Book.class, responseContainer = "List")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query",
                    value = "Results page you want to retrieve (0..N)"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
                    value = "Number of records per page."),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                    value = "Sorting criteria in the format: property(,asc|desc). " +
                            "Default sort order is ascending. " +
                            "Multiple sort criteria are supported.")})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "List Of All Books w/Paging", response = Book.class)})
    @GetMapping(value = "/books/paging", produces = {"application/json"})
    public ResponseEntity<?> listAllBooksByPage(
            @PageableDefault(page = 0,
                    size = 3)
                    Pageable pageable)
    {
        List<Book> myBooks = bookService.findAllPageable(pageable);
        return new ResponseEntity<>(myBooks, HttpStatus.OK);
    }

    @ApiOperation(value = "List of Books", response = Book.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "List Of All Books", response = Book.class)})
    @GetMapping(value = "/books", produces = {"application/json"})
    public ResponseEntity<?> listAllBooks()
    {
        List<Book> myBooks = bookService.findAll();
        return new ResponseEntity<>(myBooks, HttpStatus.OK);
    }


}
