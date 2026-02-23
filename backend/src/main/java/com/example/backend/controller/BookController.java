package com.example.backend.controller;

import com.example.backend.dto.BookSearchResponseDTO;
import com.example.backend.service.GoogleBooksService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final GoogleBooksService googleBooksService;

    @GetMapping("/search")
    public List<BookSearchResponseDTO> searchBooks(@RequestParam String q) {
        return googleBooksService.searchBooks(q);
    }
}
