package com.jay.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReplyUpdateRequestDto {
    private String comment;

    @Builder
    public ReplyUpdateRequestDto(String comment){
        this.comment=comment;
    }
}
