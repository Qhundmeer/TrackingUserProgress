package com.userProgress.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userProgress.dto.UserProgress;

public interface UserProgressRepository extends JpaRepository<UserProgress, Long> {
    Optional<UserProgress> findByUserId(String userId);
}
