package com.example.demo.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Book {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", pages=" + pages +
                ", reviews=" + reviews +
                '}';
    }

    @Id
    @GeneratedValue
    private Integer id;

    private String author;
    private String title;
    private Integer pages;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="book_id")
    private List<Review> reviews;

    public Book() {
    }

    public Book(String author, String title, Integer pages) {
        this.author = author;
        this.title = title;
        this.pages = pages;
    }


}
