package com.userProgress.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userProgress.dto.UserProgress;
import com.userProgress.dto.UserProgressUpdate;
import com.userProgress.repository.UserProgressRepository;
import com.userProgress.repository.UserProgressUpdateRepository;


@Service
public class UserProgressService {

    @Autowired
    private UserProgressRepository userProgressRepository;

    @Autowired
    private UserProgressUpdateRepository userProgressUpdateRepository;

    public UserProgress saveOrUpdateUserProgress(UserProgress userProgress) {
        return userProgressRepository.save(userProgress);
    }

    public Optional<UserProgress> getUserProgressByUserId(String userId) {
        return userProgressRepository.findByUserId(userId);
    }

    // Log updates
    private void logUpdate(UserProgress userProgress, String updateType, String newValue) {
        UserProgressUpdate update = new UserProgressUpdate();
        update.setUserProgress(userProgress);
        update.setUpdateType(updateType);
        update.setNewValue(newValue);
        userProgressUpdateRepository.save(update);
    }

    public Optional<UserProgress> updateCurrentBook(String userId, String currentBook) {
        return userProgressRepository.findByUserId(userId).map(userProgress -> {
//            userProgress.setCurrentBook(currentBook);
            logUpdate(userProgress, "current_book", currentBook); // Log the update
            return userProgressRepository.save(userProgress);
        });
    }

    public Optional<UserProgress> updateCurrentChapter(String userId, int currentChapter) {
        return userProgressRepository.findByUserId(userId).map(userProgress -> {
//            userProgress.setCurrentChapter(currentChapter);
            logUpdate(userProgress, "current_chapter", String.valueOf(currentChapter)); // Log the update
            return userProgressRepository.save(userProgress);
        });
    }

    public Optional<UserProgress> updateScore(String userId, int score) {
        return userProgressRepository.findByUserId(userId).map(userProgress -> {
//            userProgress.setScore(score);
            logUpdate(userProgress, "score", String.valueOf(score)); // Log the update
            return userProgressRepository.save(userProgress);
        });
    }

    public Optional<UserProgress> updateBadgeImage(String userId, String badgeImage) {
        return userProgressRepository.findByUserId(userId).map(userProgress -> {
//            userProgress.setBadgeImage(badgeImage);
            logUpdate(userProgress, "badge_image", badgeImage); // Log the update
            return userProgressRepository.save(userProgress);
        });
    }

    public Optional<UserProgress> updateBadgeName(String userId, String badgeName) {
        return userProgressRepository.findByUserId(userId).map(userProgress -> {
//            userProgress.setBadgeName(badgeName);
            logUpdate(userProgress, "badge_name", badgeName); // Log the update
            return userProgressRepository.save(userProgress);
        });
    }
}
