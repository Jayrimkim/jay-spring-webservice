package com.jay.springboot.web.dto;

import com.jay.springboot.domain.posts.Posts;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PostsReadResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    //엔티티간 무한 참조 방지를 위한 List 타입
    private List<ReplyResponseDto> reply;

    public PostsReadResponseDto(Posts entity){
        this.id=entity.getId();
        this.title=entity.getTitle();
        this.content=entity.getContent();
        this.author=entity.getAuthor();

        //댓글 추가
        this.reply = entity.getReply().stream().map(ReplyResponseDto::new).collect(Collectors.toList());
    }
}
