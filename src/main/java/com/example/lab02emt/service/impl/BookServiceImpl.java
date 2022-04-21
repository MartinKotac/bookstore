package com.example.lab02emt.service.impl;

import com.example.lab02emt.model.Author;
import com.example.lab02emt.model.Book;
import com.example.lab02emt.model.dto.BookDto;
import com.example.lab02emt.model.enums.BookCategory;
import com.example.lab02emt.model.exceptions.AuthorNotFoundException;
import com.example.lab02emt.model.exceptions.BookNotFoundException;
import com.example.lab02emt.repository.AuthorRepository;
import com.example.lab02emt.repository.BookRepository;
import com.example.lab02emt.service.BookService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl  implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }


    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> listAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book>  delete(Long id) {
        Book book=bookRepository.findById(id)
                .orElseThrow(()->new BookNotFoundException("Book with id:"+id+" is not found"));
        bookRepository.delete(book);
        return Optional.of(book);
    }

    @Override
    public Optional<Book>  create(BookDto bookDto) {
       Author author=authorRepository.findById(bookDto.getAuthorId())
               .orElseThrow(()->new AuthorNotFoundException("Author with id:"+bookDto.getAuthorId()+"is not found"));
       Book book=new Book(bookDto.getName(),bookDto.getBookCategory(),author,bookDto.getAvailableCopies());
       return Optional.of(bookRepository.save(book));
    }

    @Override
    public Optional<Book>  update(Long id, BookDto bookDto) {
        Book book=bookRepository.findById(id).orElseThrow(()->new BookNotFoundException("Book with id:"+id+" is not found"));
        Author author=authorRepository.findById(bookDto.getAuthorId())
                .orElseThrow(()->new AuthorNotFoundException("Author with id:"+bookDto.getAuthorId()+"is not found"));
        book.setBookCategory(bookDto.getBookCategory());
        book.setAuthor(author);
        book.setAvailableCopies(bookDto.getAvailableCopies());
        return Optional.of(bookRepository.save(book));
    }

    @Override
    public Optional<Book> rent(Long id) {
        Book book=bookRepository.findById(id).orElseThrow(()->new BookNotFoundException("Book with id:"+id+" is not found"));
        book.setDateRented(LocalDateTime.now());
        return Optional.of(book);
    }
}
