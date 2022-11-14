package com.jay.springboot.web;

import com.jay.springboot.config.auth.LoginUser;
import com.jay.springboot.config.auth.dto.SessionUser;
import com.jay.springboot.service.posts.PostsService;
import com.jay.springboot.service.posts.ReplyService;
import com.jay.springboot.web.dto.PostsResponseDto;
import com.jay.springboot.web.dto.PostsSaveRequestDto;
import com.jay.springboot.web.dto.ReplyRequestDto;
import com.jay.springboot.web.dto.ReplyResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final ReplyService replyService;
    private final PostsService postsService;
    private final HttpSession httpSession;
    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
        model.addAttribute("posts",postsService.findAllDesc());
        if(user !=null){
            model.addAttribute("userName",user.getName());
        }
        return "index";
    }

    /*게시글 작성*/
    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    /*게시글 수정*/
    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto=postsService.findById(id);
        model.addAttribute("post",dto);

        return "posts-update";
    }

    /*게시글 상세 조회*/
    @GetMapping("/posts/read/{id}")
    public String postsRead(@PathVariable Long id, Model model){
        PostsResponseDto dto=postsService.findById(id);
        List<ReplyResponseDto> reply=dto.getReply();

        /*댓글*/
        if (reply != null && !reply.isEmpty()){
            model.addAttribute("reply",reply);
        }

    model.addAttribute("post",postsService.PostsReadResponseDto(id));

        return "posts-read";
    }

    /*댓글 UPDATE 맵핑*/
    @GetMapping("/reply/update/{id}")
    public String replyUpdate(@PathVariable Long id,Model model){
        ReplyResponseDto dto=replyService.findById(id);
        model.addAttribute("reply",dto);

        return "reply-update";
    }


    /*계산기 맵핑*/
    @GetMapping("/cal/gauge")
    public String calGauge(){ return "cal-gauge";}

    @GetMapping("/cal/bag")
    public String calBag(){ return "cal-bag";}

    @GetMapping("/cal/check")
    public String calCheck(){ return "cal-check";}
}