package com.example.lab02emt.service.impl;

import com.example.lab02emt.model.Author;
import com.example.lab02emt.model.Country;
import com.example.lab02emt.model.exceptions.AuthorNotFoundException;
import com.example.lab02emt.repository.AuthorRepository;
import com.example.lab02emt.repository.CountryRepository;
import com.example.lab02emt.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author create(String name, String surname, Long countryId) {
        Country country=this.countryRepository.findById(countryId).orElseThrow(()-> new AuthorNotFoundException("Epa ne e za avtor za country e"));
        Author author=new Author(name,surname,country);
        return this.authorRepository.save(author);
    }
}
