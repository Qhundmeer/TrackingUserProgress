package com.userProgress.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userProgress.dto.UserProgress;
import com.userProgress.service.UserProgressService;

@RestController
@RequestMapping("/progress")
public class UserProgressController {

    @Autowired
    private UserProgressService userProgressService;

    // Create or update user progress (existing)
    @PostMapping
    public ResponseEntity<UserProgress> createOrUpdateUserProgress(@RequestBody UserProgress userProgress) {
        UserProgress savedProgress = userProgressService.saveOrUpdateUserProgress(userProgress);
        return ResponseEntity.ok(savedProgress);
    }

    // Get user progress by user_id (existing)
    @GetMapping("/{userId}")
    public ResponseEntity<UserProgress> getUserProgress(@PathVariable String userId) {
        Optional<UserProgress> userProgress = userProgressService.getUserProgressByUserId(userId);
        return userProgress.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // PATCH: Update current book
    @PatchMapping("/{userId}/currentBook")
    public ResponseEntity<UserProgress> updateCurrentBook(
            @PathVariable String userId,
            @RequestBody Map<String, String> request) {
        String currentBook = request.get("currentBook");
        return userProgressService.updateCurrentBook(userId, currentBook)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // PATCH: Update current chapter
    @PatchMapping("/{userId}/currentChapter")
    public ResponseEntity<UserProgress> updateCurrentChapter(
            @PathVariable String userId,
            @RequestBody Map<String, Integer> request) {
        Integer currentChapter = request.get("currentChapter");
        return userProgressService.updateCurrentChapter(userId, currentChapter)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // PATCH: Update score
    @PatchMapping("/{userId}/score")
    public ResponseEntity<UserProgress> updateScore(
            @PathVariable String userId,
            @RequestBody Map<String, Integer> request) {
        Integer score = request.get("score");
        return userProgressService.updateScore(userId, score)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // PATCH: Update badge image
    @PatchMapping("/{userId}/badgeImage")
    public ResponseEntity<UserProgress> updateBadgeImage(
            @PathVariable String userId,
            @RequestBody Map<String, String> request) {
        String badgeImage = request.get("badgeImage");
        return userProgressService.updateBadgeImage(userId, badgeImage)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // PATCH: Update badge name
    @PatchMapping("/{userId}/badgeName")
    public ResponseEntity<UserProgress> updateBadgeName(
            @PathVariable String userId,
            @RequestBody Map<String, String> request) {
        String badgeName = request.get("badgeName");
        return userProgressService.updateBadgeName(userId, badgeName)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
