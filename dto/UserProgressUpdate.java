package com.userProgress.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class UserProgressUpdate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_progress_id", nullable = false)
    @JsonIgnore
    private UserProgress userProgress;

    private String updateType; // e.g., "current_book", "score", "badge_image"
    private String newValue;   // the updated value
    private LocalDateTime timestamp; // when the update happened

    public UserProgressUpdate() {
        this.timestamp = LocalDateTime.now(); // Set the current time by default
    }
}
