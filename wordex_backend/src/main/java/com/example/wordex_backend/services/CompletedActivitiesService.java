package com.example.wordex_backend.services;

import com.example.wordex_backend.model.CompletedActivities;
import com.example.wordex_backend.repository.CompletedActivitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CompletedActivitiesService {

    @Autowired
    private CompletedActivitiesRepository completedactivitiesRepository;

    public CompletedActivities saveCompletedActivities(CompletedActivities completedactivities) {
        return completedactivitiesRepository.save(completedactivities);
    }
    public void deleteCompletedActivities(String id) {
        completedactivitiesRepository.deleteById(id);
    }

    public List<CompletedActivities> getAllActivities() {
        return completedactivitiesRepository.findAll();
    }

    public List<CompletedActivities> getCompletedActivitiesByUserId(String userId) {
    return completedActivitiesRepository.findByUserId(userId);
}


    public Optional<CompletedActivities> getCompletedActivitiesById(String id) {
        return completedactivitiesRepository.findById(id);
    }

    
} 