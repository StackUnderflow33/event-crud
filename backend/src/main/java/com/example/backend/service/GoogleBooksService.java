package com.example.backend.service;

import com.example.backend.dto.BookSearchResponseDTO;

import java.util.List;

public interface GoogleBooksService {
    List<BookSearchResponseDTO> searchBooks(String query);
}
