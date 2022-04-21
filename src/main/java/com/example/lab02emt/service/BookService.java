package com.example.lab02emt.service;

import com.example.lab02emt.model.Author;
import com.example.lab02emt.model.Book;
import com.example.lab02emt.model.dto.BookDto;
import com.example.lab02emt.model.enums.BookCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BookService {
   Optional<Book> findById(Long id);
    List<Book> listAll();
    Page<Book> findAllWithPagination(Pageable pageable);
    Optional<Book>  delete(Long id);
    Optional<Book>  create(BookDto bookDto);
    Optional<Book>  update(Long id,BookDto bookDto);
    Optional<Book>  rent(Long id);
}
