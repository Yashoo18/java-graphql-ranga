package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@ToString
@Setter
public class Book {
    @Id
    @GeneratedValue
    private Integer id;
    private String author;
    private String title;
    private Integer pages;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="book_id")
    private List<Review> reviews;

    public Book(String author, String title, int pages) {
    }
}