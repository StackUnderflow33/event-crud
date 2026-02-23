package com.example.backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int rating;
    private String note;

    @ManyToOne
    private User user;

    @ManyToOne
    private Book book;
}
