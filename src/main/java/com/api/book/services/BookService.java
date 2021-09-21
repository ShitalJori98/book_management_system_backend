package com.api.book.services;

import com.api.book.dao.BookRepository;
import com.api.book.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
    }

    //get all books
    public List<Book>getAllBooks(){
        List<Book> list = (List<Book>) this.bookRepository.findAll();
        return list;
    }
    //get single book by id
    public Book getBookById(int id){
        Book book = null;
        try {
            book = this.bookRepository.findById(id);
        }catch (Exception exception){
           exception.printStackTrace();
        }
        return book;
    }

    //adding the book
    public Book addBook(Book b){
        Book result = bookRepository.save(b);
        return result;
    }

    //delete the book
    public void deleteBook(int bookId) {
        bookRepository.deleteById(bookId);
    }

    //update the book
    public void updateBook(Book book, int bookId) {
        book.setId(bookId);
        bookRepository.save(book);
    }
}
