package com.example.wordex_backend.repository;

import com.example.wordex_backend.model.CompletedActivities;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CompletedActivitiesRepository extends MongoRepository<CompletedActivities, String> {
    // Custom query to find questions by a keyword
} 
