package com.jay.springboot.service.posts;


import com.jay.springboot.domain.posts.Posts;
import com.jay.springboot.domain.posts.PostsRepository;
import com.jay.springboot.domain.reply.Reply;
import com.jay.springboot.domain.reply.ReplyRepository;
import com.jay.springboot.domain.user.UserRepository;
import com.jay.springboot.web.dto.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Getter
public class ReplyService {

    private final ReplyRepository replyRepository;
    private final UserRepository userRepository;
    private final PostsRepository postsRepository;


    /*댓글 CREATE*/
    @Transactional
    public Long replySave(Long postsId, ReplyRequestDto requestDto) {

        Posts posts = postsRepository.findById(postsId).orElseThrow(() -> new IllegalArgumentException("댓글 쓰기 실패 : 해당 게시글이 존재하지 않습니다." + postsId));

        requestDto.setPosts(posts);

        Reply reply = requestDto.toEntity();
        replyRepository.save(reply);

        return requestDto.getId();
    }

    /*댓글 UPDATE*/
    @Transactional
    public Long replyUpdate(Long id, ReplyUpdateRequestDto requestDto){
        Reply reply = replyRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        reply.update(requestDto.getComment());

        return id;
    }



    public ReplyResponseDto findById(Long id) {
        Reply entity = replyRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new ReplyResponseDto(entity);
    }
/*댓글 DELETE*/
    public void replyDelete(Long id) {
        replyRepository.deleteById(id);
    }
}
