package com.jay.springboot.web.dto;

import com.jay.springboot.domain.posts.Posts;
import com.jay.springboot.domain.reply.Reply;
import com.jay.springboot.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReplyRequestDto {
    private Long id;
    private String comment;
    private Posts posts;


    /*Dto에서 Entity로 데이터 전달*/
    public Reply toEntity() {
        Reply reply = Reply.builder()
                .id(id)
                .comment(comment)
                .posts(posts)
                .build();

        return reply;
    }

}
