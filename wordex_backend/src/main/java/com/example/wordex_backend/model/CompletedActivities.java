package com.example.wordex_backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;

@Document(collection = "completedactivities")
@Getter
@Setter
public class CompletedActivities {
    @Id
    private String id;
    private String userId;
    private String activityId;
    private Date timestamp; 
}
