package com.jay.springboot.service.posts;

import com.jay.springboot.domain.posts.PostsRepository;
import com.jay.springboot.domain.scrap.Scrap;
import com.jay.springboot.domain.scrap.ScrapRepository;
import com.jay.springboot.domain.user.UserRepository;
import com.jay.springboot.web.dto.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Getter
public class ScrapService {
    private final ScrapRepository scrapRepository;
    private final UserRepository userRepository;
    private final PostsRepository postsRepository;

    /*스크랩 CREATE*/
    @Transactional
    public Long scrapSave(ScrapRequestDto requestDto) {
        return scrapRepository.save(requestDto.toEntity()).getId();
    }

    /*스크랩 리스트 READ*/
    @Transactional(readOnly = true)
    public List<ScrapListResponseDto> findAllDesc() {
        return scrapRepository.findAllDesc().stream().map(ScrapListResponseDto::new).collect(Collectors.toList());
    }

    /*스크랩 DELETE*/
    public void scrapDelete(Long id) {
        scrapRepository.deleteById(id);
    }


    /*페이징*/
    @Transactional(readOnly = true)
    public Page<Scrap> pageList(Pageable pageable){
        return scrapRepository.findAll(pageable);
    }


        }


