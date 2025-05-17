package com.example.wordex_backend.services;

import com.example.wordex_backend.model.CompletedActivities;
import com.example.wordex_backend.repository.CompletedActivitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompletedActivitiesService {

    @Autowired
    private CompletedActivitiesRepository completedActivitiesRepository;

    public CompletedActivities saveCompletedActivities(CompletedActivities completedActivities) {
        return completedActivitiesRepository.save(completedActivities);
    }

    public List<CompletedActivities> getAllActivities() {
        return completedActivitiesRepository.findAll();
    }

    public Optional<CompletedActivities> getCompletedActivitiesById(String id) {
        return completedActivitiesRepository.findById(id);
    }

    // ✅ NEW method to get completed activities by userId
    public List<CompletedActivities> getCompletedActivitiesByUserId(String userId) {
        return completedActivitiesRepository.findByUserId(userId);
    }
}
