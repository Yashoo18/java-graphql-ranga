package com.example.demo.controller;

import com.example.demo.Model.Book;
import com.example.demo.Model.BookInput;
import com.example.demo.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Controller("/api/books")
public class BookController {
    @Autowired
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @QueryMapping
    public List<Book> getBook(){
        return bookRepository.findAll();
    }
    @MutationMapping
    public Book createBook(@Argument String title,@Argument String author, @Argument Integer pages){
        Book book = new Book(title,author,pages);
        bookRepository.save(book);
        return book;
    }
    @MutationMapping
    public Book addBook(@Argument BookInput book){
        return bookRepository.save(new Book(book.author(), book.title(), book.pages()));
    }
    @MutationMapping
    public List<Book> listBooks(@Argument List<BookInput> books){
        return bookRepository.saveAll(books.stream().map(b-> new Book(b.author(), b.title(), b.pages())).collect(Collectors.toList()));
    }
}
