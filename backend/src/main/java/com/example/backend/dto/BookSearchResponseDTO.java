package com.example.backend.dto;

import lombok.Data;
import java.util.List;

@Data
public class BookSearchResponseDTO {
    private String volumeId;
    private String title;
    private List<String> authors;
    private String description;
    private String thumbnail;
    private String publishedDate;
}
