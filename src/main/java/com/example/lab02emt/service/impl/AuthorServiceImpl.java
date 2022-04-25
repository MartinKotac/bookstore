package com.example.lab02emt.service.impl;

import com.example.lab02emt.model.Author;
import com.example.lab02emt.model.exceptions.AuthorNotFoundException;
import com.example.lab02emt.repository.AuthorRepository;
import com.example.lab02emt.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }
}
