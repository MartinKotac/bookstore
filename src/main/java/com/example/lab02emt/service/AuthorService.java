package com.example.lab02emt.service;

import com.example.lab02emt.model.Author;

import java.util.Optional;

public interface AuthorService {

    Optional<Author> findById(Long id);
}
