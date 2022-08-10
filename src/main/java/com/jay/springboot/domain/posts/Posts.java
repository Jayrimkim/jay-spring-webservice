package com.jay.springboot.domain.posts;

import com.jay.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


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

    @Builder //해당 클래스의 빌더 패턴 클래스를 생성, 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;

    }

    public void update(String title, String content){
        this.title=title;
        this.content=content;
    }


}