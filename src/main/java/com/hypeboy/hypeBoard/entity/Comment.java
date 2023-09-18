package com.hypeboy.hypeBoard.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "post_id", nullable = false)
    private int postId;

    @Column(nullable = false)
    private String text;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "recomment_id")
    private Integer recommentId;

    @Column(name = "user_id", nullable = false)
    private String userId;

}
