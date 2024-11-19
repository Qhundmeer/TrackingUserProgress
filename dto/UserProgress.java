package com.userProgress.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class UserProgress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;	
    private String currentBook;
    private int currentChapter;
    private int score;
    private String badgeImage;
    private String badgeName;

    @OneToMany(mappedBy = "userProgress", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UserProgressUpdate> updates; // List of all updates for this user
}
