package com.jay.springboot.domain.scrap;

import com.jay.springboot.domain.BaseTimeEntity;
import com.jay.springboot.domain.posts.Posts;
import com.jay.springboot.domain.user.User;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "scrap")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Scrap extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //프로젝트에서 연결된 DB의 넘버링 전략을 따라간다
    private Long id;

    private Long postsId;

    @Column(length = 500, nullable = false) //칼럼 나타냄, 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 칼럼이 됨. 추가로 변경하고싶은 옵션이 있다면 사용
    private String title;
}