package com.example.wordex_backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;

@Document(collection = "activities")
@Getter
@Setter
public class Activity {
    @Id
    private String id;
    private String title;
    private String url;
    private String type; // e.g., RAC, LJ, WJ, DS
    private String imageUrl;
    private String status = "Incomplete"; 
}
