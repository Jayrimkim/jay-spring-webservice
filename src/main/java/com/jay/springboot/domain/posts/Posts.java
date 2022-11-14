package com.jay.springboot.domain.posts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jay.springboot.domain.BaseTimeEntity;
import com.jay.springboot.domain.reply.Reply;
import com.jay.springboot.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.List;


@Getter// 클래스 내 모든 필드의 Getter 메소드를 자동 생성
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {
    @Id //해당 테이블의 PK 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK의 생성규칙
    private Long id;

    @Column(length = 500, nullable = false) //칼럼 나타냄, 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 칼럼이 됨. 추가로 변경하고싶은 옵션이 있다면 사용
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @OneToMany(mappedBy = "posts",fetch=FetchType.EAGER, cascade=CascadeType.REMOVE) //EAGER 전략에 의해 POSTS가 불러질때 REPLY도 불러짐
    @OrderBy("id asc")// 댓글 오름차순 정렬
    //posts와 reply 무한 참조 방지
    private List<Reply> reply; //외래키 아니고 DB에는 없는데 select 할 때 패치해서 들고 옴.

    @Builder //해당 클래스의 빌더 패턴 클래스를 생성, 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;

    }

    /*게시글 수정*/
    public void update(String title, String content){
        this.title=title;
        this.content=content;
    }


}