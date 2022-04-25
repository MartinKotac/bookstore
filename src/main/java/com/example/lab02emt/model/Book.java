package com.example.lab02emt.model;

import com.example.lab02emt.model.enums.BookCategory;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    @Enumerated
    BookCategory bookCategory;

    @OneToOne
    Author author;

    boolean rented;

    Integer availableCopies;

    public Book() {
    }

    public Book(String name, BookCategory bookCategory, Author author, Integer availableCopies) {
        this.name = name;
        this.bookCategory = bookCategory;
        this.author = author;
        this.availableCopies = availableCopies;
        this.rented=false;
    }
}
