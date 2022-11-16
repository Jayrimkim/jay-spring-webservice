package com.jay.springboot.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jay.springboot.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostsListResponseDto {
    private Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;
    private int hit;

    public PostsListResponseDto(Posts entity){
        this.id=entity.getId();
        this.title= entity.getTitle();
        this.author=entity.getAuthor();
        this.modifiedDate=entity.getModifiedDate();
        this.hit= entity.getHit();
    }
}
