package com.example.lab02emt.service.impl;

import com.example.lab02emt.model.Author;
import com.example.lab02emt.model.Book;
import com.example.lab02emt.model.enums.BookCategory;
import com.example.lab02emt.model.exceptions.AuthorNotFoundException;
import com.example.lab02emt.model.exceptions.BookNotFoundException;
import com.example.lab02emt.repository.AuthorRepository;
import com.example.lab02emt.repository.BookRepository;
import com.example.lab02emt.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl  implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }


    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElseThrow(()->new BookNotFoundException("Book with id:"+id+" is not found"));
    }

    @Override
    public List<Book> listAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book delete(Long id) {
        Book book=bookRepository.findById(id).orElseThrow(()->new BookNotFoundException("Book with id:"+id+" is not found"));
        bookRepository.delete(book);
        return book;
    }

    @Override
    public Book create(String name, BookCategory bookCategory, Long authorId, Integer availableCopies) {
       Author author=authorRepository.findById(authorId).orElseThrow(()->new AuthorNotFoundException("Author with id:"+authorId+"is not found"));
       Book book=new Book(name,bookCategory,author,availableCopies);
       return bookRepository.save(book);
    }

    @Override
    public Book update(Long id, String name, BookCategory bookCategory, Long authorId, Integer availableCopies) {
        Book book=bookRepository.findById(id).orElseThrow(()->new BookNotFoundException("Book with id:"+id+" is not found"));
        Author author=authorRepository.findById(authorId).orElseThrow(()->new AuthorNotFoundException("Author with id:"+authorId+"is not found"));
        book.setBookCategory(bookCategory);
        book.setAuthor(author);
        book.setAvailableCopies(availableCopies);
        return bookRepository.save(book);
    }

    @Override
    public Book rent(Long id) {
        Book book=bookRepository.findById(id).orElseThrow(()->new BookNotFoundException("Book with id:"+id+" is not found"));
        Integer availableCopiesAfterRent=book.getAvailableCopies()-1;
        book.setAvailableCopies(availableCopiesAfterRent);
        return book;
    }
}
