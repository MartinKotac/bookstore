package com.example.lab02emt.web.restApi;

import com.example.lab02emt.model.Book;
import com.example.lab02emt.model.dto.BookDto;
import com.example.lab02emt.model.enums.BookCategory;
import com.example.lab02emt.service.BookService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/books")
public class BookRestController {
    private  final BookService bookService;


    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping
    public List<Book> findAll(){
        return bookService.listAll();
    }
    @GetMapping("/categories")
    public BookCategory[] findAllCategories(){
        return BookCategory.values();
    }
    @GetMapping("/pagination")
    public List<Book> findAllWithPagination(Pageable pageable){
        return bookService.findAllWithPagination(pageable).getContent();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id){
        return bookService.findById(id)
                .map(book->ResponseEntity.ok().body(book))
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    //create
    @PostMapping("/add")
    public ResponseEntity<Book> create(@RequestBody BookDto bookDto){
        return this.bookService.create(bookDto)
                .map(book->ResponseEntity.ok().body(book))
                .orElseGet(()->ResponseEntity.notFound().build());

    }

    //edit
    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> update(@PathVariable Long id,@RequestBody BookDto bookDto){
        return this.bookService.update(id,bookDto)
                .map(book->ResponseEntity.ok().body(book))
                .orElseGet(()->ResponseEntity.badRequest().build());
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Book> delete(@PathVariable Long id){
        this.bookService.delete(id);
        if(this.bookService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

    //rent book by
    @PostMapping("/rent/{id}")
    public ResponseEntity<Book> rent(@PathVariable Long id){
        return this.bookService.rent(id)
                .map(book->ResponseEntity.ok().body(book))
                .orElseGet(()->ResponseEntity.notFound().build());
    }

}
