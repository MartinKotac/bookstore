package com.example.lab02emt.model.dto;

import com.example.lab02emt.model.Author;
import com.example.lab02emt.model.enums.BookCategory;
import lombok.Data;

import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

@Data
public class BookDto {
    String name;

    BookCategory bookCategory;

    Long authorId;

    Integer availableCopies;

    public BookDto(String name, BookCategory bookCategory, Long authorId, Integer availableCopies) {
        this.name = name;
        this.bookCategory = bookCategory;
        this.authorId = authorId;
        this.availableCopies = availableCopies;
    }

    public BookDto() {
    }
}
