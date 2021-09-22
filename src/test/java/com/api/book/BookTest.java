package com.api.book;

import com.api.book.dao.BookRepository;
import com.api.book.entities.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookTest {
    @Autowired
    private BookRepository bookRepository;

    @Test
    @Rollback(value = false) // rollback = false because we want to save data into database
    public void testAddBook(){
        Book book;
        book = new Book("AWS" , "It is a AWS book");
        Book saveBook = bookRepository.save(book);
        assertNotNull(saveBook);

    }

    @Test
    public void testGetBookByIdExist(){
        int id = 1;
        Book book = bookRepository.findById(id);
        assertThat(book.getId()).isEqualTo(id);

    }
    @Test
    public void testGetBookByIdNotExist(){
        int id = 10;
        Book book = bookRepository.findById(id);
        assertNull(book);

    }
    @Test
    @Rollback(value = false)
    public void testUpdateBook(){
        String title = "React";
        Book book = new Book(title, "It is react book");
        book.setId(2);

        bookRepository.save(book);

        Book updatedBook = bookRepository.findById(book.getId());
        assertThat(updatedBook.getTitle()).isEqualTo(title);
    }
    @Test
    public void testGetAllBooks(){
        List<Book> book = (List<Book>) bookRepository.findAll();

        // to Display Book
        for (Book book1 : book){
            System.out.println(book1);
        }
        assertThat(book).size().isGreaterThan(0);
    }

    @Test
    /*@Rollback(value = false)*/
    public void testDeleteBook(){
        int id = 3;
        Book book = bookRepository.findById(id);
        bookRepository.deleteById(id);

        assertThat(book.getId()).isEqualTo(id);
    }
}
