package com.api.book.dao;

import com.api.book.entities.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Integer> {
  public Book findById(int id);

}
