package com.jay.springboot.web;


import com.jay.springboot.domain.posts.Posts;
import com.jay.springboot.domain.reply.Reply;
import com.jay.springboot.domain.user.User;
import com.jay.springboot.service.posts.PostsService;
import com.jay.springboot.service.posts.ReplyService;
import com.jay.springboot.web.dto.PostsSaveRequestDto;
import com.jay.springboot.web.dto.ReplyRequestDto;
import com.jay.springboot.web.dto.ReplyResponseDto;
import com.jay.springboot.web.dto.ReplyUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ReplyApiController {

    private final ReplyService replyService;

    /*CREATE reply*/
    @PostMapping("/api/v1/posts/{id}/reply")
    public ResponseEntity replySave(@PathVariable("id") Long id,@RequestBody ReplyRequestDto requestDto){
        return ResponseEntity.ok(replyService.replySave(id,requestDto));
    }

    /*UPDATE reply*/
    @PutMapping("/api/v1/reply/{id}")
    public Long replyUpdate(@PathVariable("id") Long id, @RequestBody ReplyUpdateRequestDto requestDto){
        return replyService.replyUpdate(id, requestDto);
    }

    /*DELETE reply*/
    @DeleteMapping("/api/v1/posts/{post.id}/reply/{id}")
    public ResponseEntity replyDelete(@PathVariable Long id){
        replyService.replyDelete(id);
        return ResponseEntity.ok(id);
    }
}



