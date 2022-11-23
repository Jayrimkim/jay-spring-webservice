package com.jay.springboot.web.dto;

import com.jay.springboot.domain.scrap.Scrap;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ScrapRequestDto {
    private String title;
    private Long postsId;

    @Builder
    public ScrapRequestDto(String title){
        this.title=title;
    }

    public Scrap toEntity(){
        return Scrap.builder().title(title).postsId(postsId).build();
    }
}
