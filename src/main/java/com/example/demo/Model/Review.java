package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Review {
    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    private String comment;
}