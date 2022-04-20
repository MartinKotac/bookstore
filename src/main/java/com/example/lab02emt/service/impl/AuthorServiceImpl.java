package com.example.lab02emt.service.impl;

import com.example.lab02emt.model.Author;
import com.example.lab02emt.model.exceptions.AuthorNotFoundException;
import com.example.lab02emt.repository.AuthorRepository;
import com.example.lab02emt.service.AuthorService;

public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author findById(Long id) {
        return authorRepository.findById(id).orElseThrow(()->new AuthorNotFoundException("Author with id:"+id+"is not found"));
    }
}
