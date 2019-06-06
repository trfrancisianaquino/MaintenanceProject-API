package com.twistresources.MaintenanceProject.controllers;

import com.twistresources.MaintenanceProject.entities.Book;
import com.twistresources.MaintenanceProject.exceptions.InvalidRequestBodyException;
import com.twistresources.MaintenanceProject.pojo.ApiResponse;
import com.twistresources.MaintenanceProject.services.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hibernate.annotations.SQLDelete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.function.Function;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Api(description = "Book Service")
@RestController
@RequestMapping("books")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService booksService) {
        this.bookService = booksService;
    }

    @ApiOperation( "find all books" )
    @GetMapping
    public ResponseEntity findAllBooks(){
        return ResponseEntity.status(200).body(bookService.findAllBooks());
    }

    @ApiOperation( "add books" )
    @PostMapping
    public ResponseEntity addBook(@RequestBody @Valid Book book, Errors errors){
        if (errors.hasErrors())
            throw new InvalidRequestBodyException( getValidationErrors.apply(errors) );
        return ResponseEntity.status(201)

                .contentType(MediaType.APPLICATION_JSON_UTF8)

                .body(bookService.addBook(book));
    }

    @ApiOperation( "find book by id" )
    @GetMapping("/{id}")
    public ResponseEntity findBook(@PathVariable Long id){
        return ResponseEntity.status(200).body(bookService.findBook(id));
    }

    @ApiOperation( "update book by id")
    @PutMapping("/{id}")
    public ResponseEntity updateBook(@PathVariable Long id, @RequestBody @Valid Book books, Errors errors){
        if (errors.hasErrors())
            throw new InvalidRequestBodyException( getValidationErrors.apply(errors) );
        return ResponseEntity.status(200).body(bookService.updateBook(id, books));
    }

    @ApiOperation( "delete book by id")
    @DeleteMapping("/{id}")
    public ResponseEntity deleteBook(@PathVariable Long id){
        if (bookService.deleteBook(id))
            return ResponseEntity.status(200).body(ApiResponse.builder().code(200)
                    .status("OK").message("data at id "+id+" successfully deleted").build());
        return ResponseEntity.status(400).body(ApiResponse.builder().code(400).
                status("BAD REQUEST").message("something went wrong").build());
    }

    private Function<Errors,String> getValidationErrors = err ->
            err.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.joining(", "));


}