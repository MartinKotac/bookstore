package com.example.lab02emt.service;

import com.example.lab02emt.model.Author;
import com.example.lab02emt.model.Book;
import com.example.lab02emt.model.enums.BookCategory;

import java.util.List;

public interface BookService {
    Book findById(Long id);
    List<Book> listAll();
    Book delete(Long id);
    Book create(String name, BookCategory bookCategory, Long authorId, Integer availableCopies);
    Book update(Long id,String name, BookCategory bookCategory, Long authorId, Integer availableCopies);
    Book rent(Long id);
}
