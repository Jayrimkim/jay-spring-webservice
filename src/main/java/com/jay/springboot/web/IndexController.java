package com.jay.springboot.web;

import com.jay.springboot.config.auth.LoginUser;
import com.jay.springboot.config.auth.dto.SessionUser;
import com.jay.springboot.domain.posts.Posts;
import com.jay.springboot.domain.scrap.Scrap;
import com.jay.springboot.service.posts.PostsService;
import com.jay.springboot.service.posts.ReplyService;
import com.jay.springboot.service.posts.ScrapService;
import com.jay.springboot.web.dto.PostsResponseDto;
import com.jay.springboot.web.dto.PostsSaveRequestDto;
import com.jay.springboot.web.dto.ReplyRequestDto;
import com.jay.springboot.web.dto.ReplyResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
    private final ScrapService scrapService;
    private final HttpSession httpSession;


    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user, @PageableDefault(sort = "id",direction= Sort.Direction.DESC) Pageable pageable){

        Page<Posts> list = postsService.pageList(pageable);


        model.addAttribute("posts",postsService.findAllDesc());
        if(user !=null){
            model.addAttribute("userName",user.getName());
        }
        model.addAttribute("posts",postsService.pageList(pageable));
        model.addAttribute("previous",pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next",pageable.next().getPageNumber());
        model.addAttribute("hasNext",list.hasNext());
        model.addAttribute("hasPrev",list.hasPrevious());

        return "index";
    }

    /*????????? ??????*/
    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    /*????????? ??????*/
    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto=postsService.findById(id);
        model.addAttribute("post",dto);

        return "posts-update";
    }

    /*????????? ?????? ??????*/
    @GetMapping("/posts/read/{id}")
    public String postsRead(@PathVariable Long id, Model model){
        PostsResponseDto dto=postsService.findById(id);

        /*?????????*/
        postsService.updateHit(id);

        /*??????*/
        List<ReplyResponseDto> reply=dto.getReply();

        if (reply != null && !reply.isEmpty()){
            model.addAttribute("reply",reply);
        }

    model.addAttribute("post",postsService.PostsReadResponseDto(id));

        return "posts-read";
    }

    /*?????? UPDATE ??????*/
    @GetMapping("/reply/update/{id}")
    public String replyUpdate(@PathVariable Long id,Model model){
        ReplyResponseDto dto=replyService.findById(id);
        model.addAttribute("reply",dto);

        return "reply-update";
    }

    /*??????*/
    @GetMapping("posts/search")
    public String search(String keyword, Model model,@PageableDefault(sort = "id", direction = Sort.Direction.DESC)
            Pageable pageable){
        Page<Posts> searchList=postsService.search(keyword,pageable);

        model.addAttribute("searchList",searchList);
        model.addAttribute("keyword",keyword);
        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next", pageable.next().getPageNumber());
        model.addAttribute("hasNext", searchList.hasNext());
        model.addAttribute("hasPrev", searchList.hasPrevious());
        return "posts-search";
    }

    /*????????? ????????? READ*/
    @GetMapping("posts/scrap")
        public String saveScrap(Model model, @PageableDefault(sort = "id",direction= Sort.Direction.DESC) Pageable pageable){
        Page<Scrap> list = scrapService.pageList(pageable);

        model.addAttribute("scrap",scrapService.pageList(pageable));
        model.addAttribute("previous",pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next",pageable.next().getPageNumber());
        model.addAttribute("hasNext",list.hasNext());
        model.addAttribute("hasPrev",list.hasPrevious());

        return "posts-scrap-read";
        }


    /*????????? ??????*/
    @GetMapping("/cal/gauge")
    public String calGauge(){ return "cal-gauge";}

    @GetMapping("/cal/bag")
    public String calBag(){ return "cal-bag";}

    @GetMapping("/cal/check")
    public String calCheck(){ return "cal-check";}
}