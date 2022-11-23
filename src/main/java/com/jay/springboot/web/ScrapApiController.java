package com.jay.springboot.web;

import com.jay.springboot.service.posts.ScrapService;
import com.jay.springboot.web.dto.ScrapRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ScrapApiController {

    private final ScrapService scrapService;

    /*CREATE scrap*/
    @PostMapping("/api/v1/scrap")
    public Long scrapSave(@RequestBody ScrapRequestDto requestDto) {
        return scrapService.scrapSave(requestDto);
    }

    /*DELETE reply*/
    @DeleteMapping("/api/v1/posts/scrap/{id}")
    public ResponseEntity scrapDelete(@PathVariable Long id){
        scrapService.scrapDelete(id);
        return ResponseEntity.ok(id);
    }

}
