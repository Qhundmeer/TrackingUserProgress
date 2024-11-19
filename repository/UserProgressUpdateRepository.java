package com.userProgress.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.userProgress.dto.UserProgressUpdate;

public interface UserProgressUpdateRepository extends JpaRepository<UserProgressUpdate, Long> {
}

