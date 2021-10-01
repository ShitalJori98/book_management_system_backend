package com.api.book.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books")
@ApiModel(description = "Book Model")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "ID of the Book", name = "id", required = true, value = "111")
    private int id;

    @ApiModelProperty(notes = "Title of the Book", name = "title", required = true, value = "Learn React Js")
    private String title;

    @ApiModelProperty(notes = "Description of the Book", name = "description", required = true, value = "It is a ReactJs book")
    private String description;

    public Book() {
    }

    public Book( String title, String description) {

        this.title = title;
        this.description = description;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
