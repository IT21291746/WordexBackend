package com.example.wordex_backend.controller;

import com.example.wordex_backend.model.Activity;
import com.example.wordex_backend.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    // Save activity
    @PostMapping("/save")
    public ResponseEntity<Activity> saveActivity(@RequestBody Activity activity) {
        Activity savedActivity = activityService.saveActivity(activity);
        return ResponseEntity.ok(savedActivity);
    }

    // Update activity by ID
    @PutMapping("/update/{id}")
    public ResponseEntity<Activity> updateActivity(@PathVariable("id") String id, @RequestBody Activity updatedActivity) {
        Optional<Activity> result = activityService.updateActivityById(id, updatedActivity);
        return result.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Delete activity by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteActivity(@PathVariable("id") String id) {
        activityService.deleteActivity(id);
        return ResponseEntity.ok("Activity deleted successfully!");
    }

    // Get all activities
    @GetMapping("/all")
    public ResponseEntity<List<Activity>> getAllActivities() {
        return ResponseEntity.ok(activityService.getAllActivities());
    }

    // Get a specific activity by ID
    @GetMapping("/{id}")
    public ResponseEntity<Activity> getActivityById(@PathVariable("id") String id) {
        Optional<Activity> activity = activityService.getActivityById(id);
        return activity.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Get 3 random activities by type
    @GetMapping("/random/{type}")
    public ResponseEntity<List<Activity>> getRandomActivitiesByType(@PathVariable("type") String type) {
        return ResponseEntity.ok(activityService.getRandomActivitiesByType(type, 3));
    }
} 