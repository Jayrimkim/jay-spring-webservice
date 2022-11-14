package com.jay.springboot.web.dto;

import com.jay.springboot.domain.reply.Reply;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ReplyResponseDto {

    private Long id;
    private String comment;
    private Long postsId;

    /*엔티티에서 Dto*/
    public ReplyResponseDto(Reply reply){
        this.id=reply.getId();
        this.comment=reply.getComment();
        this.postsId=reply.getPosts().getId();
    }
}
