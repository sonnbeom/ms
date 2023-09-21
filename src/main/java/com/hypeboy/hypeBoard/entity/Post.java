package com.hypeboy.hypeBoard.entity;


import com.hypeboy.hypeBoard.dto.PostDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "POSTS")
@NoArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long postId;
    @Column(name = "USER_ID", nullable = false)
    private String userId;
    @Column(name = "TITLE", nullable = false)
    @NotBlank(message = "제목은 필수 입력 값입니다.")
    private String title;
    @Column(name = "NICKNAME",nullable = false)
    private String nickname;
    @Column(name = "TEXT_CONTENT")
    private String textContent;
    @Column(name = "CATEGORY", nullable = false)
    @NotBlank(message = "카테고리는 필수 입력 값입니다.")
    private String category;
    @Column(name = "LIKE_COUNT")
    private Integer likeCount;
    @Column(name = "VIEW_COUNT")
    private Integer viewCount = 0;
    @Column(name = "COMMENT_COUNT")
    private Integer commentCount = 0;
    @Column(name = "REFERENCED_ID")
    private Long referencedId;
    @Column(name = "CREATED_AT")
    @CreatedDate
    private LocalDateTime createdAt;
    @Column(name = "UPDATED_AT")
    @LastModifiedDate
    private LocalDateTime updatedAt;


    public Post(Long postId, String userId, String title, String nickname ,String textContent, String category, Integer likeCount, Integer viewCount, Integer commentCount, Long referencedId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.postId = postId;
        this.userId = userId;
        this.title = title;
        this.textContent = textContent;
        this.category = category;
        this.likeCount = likeCount;
        this.viewCount = viewCount;
        this.commentCount = commentCount;
        this.referencedId = referencedId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.nickname = nickname;

    }
    public Post(PostDto postDto){
        this.title = postDto.getTitle();
        this.textContent = postDto.getTextContent();
        this.category = postDto.getCategory();
        this.nickname = postDto.getNickname();
        this.userId = postDto.getUserId();
    }

}
