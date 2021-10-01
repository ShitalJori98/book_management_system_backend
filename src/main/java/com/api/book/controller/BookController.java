package com.api.book.controller;

import com.api.book.entities.Book;
import com.api.book.services.BookService;
import com.api.book.swagger.ErrorResponse;
import com.api.book.utilities.GlobalResources;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@ApiOperation(value = "/api", tags = "Book Controller")
@RestController
@RequestMapping("/api")
public class BookController {
    private Logger logger = GlobalResources.getLogger(BookController.class);

    @Autowired
    private BookService bookService;


    //get all book handler
    @ApiOperation(value = "fetch all books", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Book.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = ErrorResponse.class),
            @ApiResponse(code = 403, message = "Forbidden", response = ErrorResponse.class),
            @ApiResponse(code = 404, message = "Not Found"),
    })
    @GetMapping("/books")
    public List<Book> getBook(){
        /*String methodName = "getBook()";*/
        /*logger.info(methodName + "called");*/   //info is default
        logger.trace("getBook method call");     // for trace we need to define it in property file
        return this.bookService.getAllBooks();
    }

    //get single book handler
    @ApiOperation(value = "fetch book by id", response = Book.class)
    @GetMapping("/books/{id}")
    public Book getBooks(@PathVariable("id") int id){
        return bookService.getBookById(id);

    }

    //  new book handler
    @ApiOperation(value = "Insert Book record", response = Book.class)
    @PostMapping("/books")
    public Book addBook( @RequestBody Book book){
      Book b = this.bookService.addBook(book);
        System.out.println(b);
       return b;
    }

    //delete book handler
    @ApiOperation(value = "Delete Book", response = Book.class)
    @DeleteMapping("/books/{bookId}")
    public void deleteBook(@PathVariable("bookId") int bookId){
        this.bookService.deleteBook(bookId);

    }

    //update book handler
    @ApiOperation(value = "Update the specific book", response = Book.class)
    @PutMapping("/books/{bookId}")
    public Book updateBook( @RequestBody Book book, @PathVariable("bookId") int bookId){
       this.bookService.updateBook(book, bookId);
       return book;
    }
}
