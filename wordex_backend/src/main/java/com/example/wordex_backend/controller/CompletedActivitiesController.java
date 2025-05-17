package com.example.wordex_backend.controller;

import com.example.wordex_backend.model.CompletedActivities;
import com.example.wordex_backend.services.CompletedActivitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/completedactivities")
public class CompletedActivitiesController {

    @Autowired
    private CompletedActivitiesService completedactivitiesService;

    // Save completedactivities
    @PostMapping("/save")
    public ResponseEntity<CompletedActivities> saveCompletedActivities(@RequestBody CompletedActivities completedactivities) {
        CompletedActivities savedCompletedActivities = completedactivitiesService.saveCompletedActivities(completedactivities);
        return ResponseEntity.ok(savedCompletedActivities);
    }

    // Update completedactivities by ID
    @PutMapping("/update/{id}")
    public ResponseEntity<CompletedActivities> updateCompletedActivities(@PathVariable("id") String id, @RequestBody CompletedActivities updatedCompletedActivities) {
        Optional<CompletedActivities> result = completedactivitiesService.updateCompletedActivitiesById(id, updatedCompletedActivities);
        return result.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Delete completedactivities by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCompletedActivities(@PathVariable("id") String id) {
        completedactivitiesService.deleteCompletedActivities(id);
        return ResponseEntity.ok("CompletedActivities deleted successfully!");
    }

    // Get all activities
    @GetMapping("/all")
    public ResponseEntity<List<CompletedActivities>> getAllActivities() {
        return ResponseEntity.ok(completedactivitiesService.getAllActivities());
    }

    // Get a specific completedactivities by ID
    @GetMapping("/{id}")
    public ResponseEntity<CompletedActivities> getCompletedActivitiesById(@PathVariable("id") String id) {
        Optional<CompletedActivities> completedactivities = completedactivitiesService.getCompletedActivitiesById(id);
        return completedactivities.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
} 