package com.lambdaschool.starthere.controllers;

import com.lambdaschool.starthere.logging.Loggable;
import com.lambdaschool.starthere.models.Book;
import com.lambdaschool.starthere.models.User;
import com.lambdaschool.starthere.services.BookService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@Loggable
@RestController
@RequestMapping("/data")
public class DataController
{
    @Autowired
    BookService bookService;

    @PutMapping(value = "/books/{id}")
    public ResponseEntity<?> updatebook(@Valid
            @RequestBody
                    Book updateBook,
            @PathVariable
                    long id)
    {
        bookService.update(updateBook, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @ApiOperation(value = "Create New Student", response = Book.class)
//    @ApiResponses(value = {@ApiResponse(code = 200, message = "Book Updated", response = Book.class),
//            @ApiResponse(code = 400, message = "Incorrect Information", response = URISyntaxException.class)})
    @PostMapping(value = "/books/{bookid}/authors/{authorid}",
            consumes = {"application/json"},
            produces = {"application/json"})
    public ResponseEntity<?> AssignBookToAuthor(@PathVariable long bookid,
                                                @PathVariable long authorid)
    {
        Book newBook=bookService.updateBookAuthor(bookid,authorid);

        HttpHeaders responseHeaders = new HttpHeaders();

        return new ResponseEntity<>(null,responseHeaders,HttpStatus.OK);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<?> deleteBookById(
            @ApiParam(value = "Book ID", required = true, example = "1")
            @PathVariable
                    long id)
    {
        bookService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
