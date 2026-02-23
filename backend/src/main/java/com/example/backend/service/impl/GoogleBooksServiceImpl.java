package com.example.backend.service.impl;

import com.example.backend.dto.BookSearchResponseDTO;
import com.example.backend.service.GoogleBooksService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class GoogleBooksServiceImpl implements GoogleBooksService {

    @Value("${google.books.api.url}")
    private String apiUrl;

    @Value("${google.books.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<BookSearchResponseDTO> searchBooks(String query) {

        String url = apiUrl + "?q=" + query + "&key=" + apiKey;

        Map response = restTemplate.getForObject(url, Map.class);

        List<Map<String, Object>> items = (List<Map<String, Object>>) response.get("items");

        List<BookSearchResponseDTO> result = new ArrayList<>();

        for (Map<String, Object> item : items) {

            Map<String, Object> volumeInfo = (Map<String, Object>) item.get("volumeInfo");

            BookSearchResponseDTO dto = new BookSearchResponseDTO();
            dto.setVolumeId((String) item.get("id"));
            dto.setTitle((String) volumeInfo.get("title"));
            dto.setAuthors((List<String>) volumeInfo.get("authors"));
            dto.setDescription((String) volumeInfo.get("description"));

            Map<String, String> imageLinks =
                    (Map<String, String>) volumeInfo.get("imageLinks");

            if (imageLinks != null) {
                dto.setThumbnail(imageLinks.get("thumbnail"));
            }

            dto.setPublishedDate((String) volumeInfo.get("publishedDate"));

            result.add(dto);
        }

        return result;
    }
}
