package com.example.backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String volumeId;
    private String title;
    private String authors;
    private String description;
    private String thumbnail;
    private String publishedDate;
}
