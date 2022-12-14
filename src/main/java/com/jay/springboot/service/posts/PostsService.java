package com.jay.springboot.service.posts;

import com.jay.springboot.domain.posts.Posts;
import com.jay.springboot.domain.posts.PostsRepository;
import com.jay.springboot.domain.user.User;
import com.jay.springboot.domain.user.UserRepository;
import com.jay.springboot.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;
    private final UserRepository userRepository;

    /*게시글 CREATE*/
    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }


    /*게시글 UPDATE*/
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    /*게시글 DELETE*/
    @Transactional
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        postsRepository.delete(posts);
    }

    /*게시글 리스트 READ*/
    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream().map(PostsListResponseDto::new).collect(Collectors.toList());
    }


    /*게시글 리스트 조회 오류 문구*/
    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }

    /*특정 게시글 상세 READ*/
    @Transactional(readOnly = true)
    public Posts PostsReadResponseDto(Long id) {
        return postsRepository.findById(id).get();
    }

    /*조회수*/
    @Transactional
    public int updateHit(Long id){
        return postsRepository.updateHit(id);
    }

    /*페이징*/
    @Transactional(readOnly = true)
    public Page<Posts> pageList(Pageable pageable){
        return postsRepository.findAll(pageable);
    }

    /*검색*/
    @Transactional
    public Page<Posts> search(String keyword,Pageable pageable){
        Page<Posts> postsList = postsRepository.findByTitleContaining(keyword,pageable);
        return postsList;
    }

}