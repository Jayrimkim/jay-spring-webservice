package com.jay.springboot.web;

import com.jay.springboot.domain.posts.Posts;
import com.jay.springboot.domain.posts.PostsRepository;
import com.jay.springboot.domain.reply.Reply;
import com.jay.springboot.domain.reply.ReplyRepository;
import com.jay.springboot.domain.user.User;
import com.jay.springboot.service.posts.PostsService;
import com.jay.springboot.service.posts.ReplyService;
import com.jay.springboot.web.dto.PostsSaveRequestDto;
import com.jay.springboot.web.dto.ReplyRequestDto;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers=ReplyApiController.class)
public class ReplyApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PostsRepository postsRepository;

    @Autowired
    private ReplyRepository replyRepository;

    @After
    public void tearDown() throws Exception {
        postsRepository.deleteAll();
        replyRepository.deleteAll();
    }


    @Test
    public void Reply_등록된다() throws Exception {
        //given : 테스트에 필요한 데이터 세팅

    }

}

