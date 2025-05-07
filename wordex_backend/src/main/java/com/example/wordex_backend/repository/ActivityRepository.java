package com.example.wordex_backend.repository;

import com.example.wordex_backend.model.Activity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends MongoRepository<Activity, String> {
    // List<Activity> findByTypeIgnoreCase(String type);
    List<Activity> findByTypeIgnoreCaseAndStatusIgnoreCase(String type, String status);

}