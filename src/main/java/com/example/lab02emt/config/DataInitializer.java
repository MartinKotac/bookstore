package com.example.lab02emt.config;

import com.example.lab02emt.model.enums.BookCategory;
import com.example.lab02emt.service.AuthorService;
import com.example.lab02emt.service.BookService;
import com.example.lab02emt.service.CountryService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class DataInitializer {


    private final AuthorService authorService;
    private final BookService bookService;
    private final CountryService countryService;

    public DataInitializer(AuthorService authorService, BookService bookService, CountryService countryService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.countryService = countryService;
    }


    @PostConstruct
    public void initData() {

        this.countryService.create("Panama", "America");
        this.countryService.create("Macedonia", "Europe");
        this.countryService.create("France", "Europe");
        this.authorService.create("Viktor", "Hugo", 1L);
        this.authorService.create("Onore", "de Balzac", 3L);

        this.bookService.save("Le peau de sagrin", BookCategory.CLASSICS, 2L, 15);
    }
}
