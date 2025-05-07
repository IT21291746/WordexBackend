package com.example.wordex_backend.services;

import com.example.wordex_backend.model.Activity;
import com.example.wordex_backend.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    public Activity saveActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    public Optional<Activity> updateActivityById(String id, Activity updatedActivity) {
        return activityRepository.findById(id).map(existing -> {
            existing.setTitle(updatedActivity.getTitle());
            existing.setUrl(updatedActivity.getUrl());
            existing.setType(updatedActivity.getType());
            existing.setImageUrl(updatedActivity.getImageUrl());
            return activityRepository.save(existing);
        });
    }

    public void deleteActivity(String id) {
        activityRepository.deleteById(id);
    }

    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }

    public Optional<Activity> getActivityById(String id) {
        return activityRepository.findById(id);
    }

    public List<Activity> getRandomActivitiesByType(String type, int count) {
        List<Activity> filtered = activityRepository.findByTypeIgnoreCaseAndStatusIgnoreCase(type, "Incomplete");
        Collections.shuffle(filtered);
        return filtered.stream().limit(count).collect(Collectors.toList());
    }
    
} 