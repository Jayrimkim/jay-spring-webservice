package com.jay.springboot.domain.reply;

import com.jay.springboot.domain.BaseTimeEntity;
import com.jay.springboot.domain.posts.Posts;
import com.jay.springboot.domain.user.User;
import lombok.*;

import javax.persistence.*;

@Table(name = "reply")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Reply extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //프로젝트에서 연결된 DB의 넘버링 전략을 따라간다
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String comment;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name="postsId"))
    private Posts posts;

    @Column
    private Long dept;

    public void update(String comment) {
        this.comment=comment;
    }
}
