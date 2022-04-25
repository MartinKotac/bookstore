package com.example.lab02emt.service.impl;

import com.example.lab02emt.model.Country;
import com.example.lab02emt.repository.CountryRepository;
import com.example.lab02emt.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return this.countryRepository.findById(id);
    }

    @Override
    public Country create(String name, String continent) {
        Country country=new Country(name,continent);
        return this.countryRepository.save(country);
    }
}
