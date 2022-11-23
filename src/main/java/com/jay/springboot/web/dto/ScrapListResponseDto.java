package com.jay.springboot.web.dto;

import com.jay.springboot.domain.posts.Posts;
import com.jay.springboot.domain.scrap.Scrap;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScrapListResponseDto {
    private Long id;
    private Long postsId;
    private String title;
    private LocalDateTime modifiedDate;

    public ScrapListResponseDto(Scrap scrap){
        this.id= scrap.getId();
        this.postsId= scrap.getPostsId();
        this.title=scrap.getTitle();
        this.modifiedDate=scrap.getModifiedDate();
    }

}
