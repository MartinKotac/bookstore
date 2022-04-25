package com.example.lab02emt.service;

import com.example.lab02emt.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findAll();
    Optional<Country> findById(Long id);
    Country create(String name, String continent);
}
