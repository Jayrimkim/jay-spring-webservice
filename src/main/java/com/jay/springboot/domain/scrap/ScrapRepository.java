package com.jay.springboot.domain.scrap;

import com.jay.springboot.domain.posts.Posts;
import com.jay.springboot.domain.reply.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Arrays;
import java.util.List;

public interface ScrapRepository extends JpaRepository<Scrap, Long> {
    @Query("SELECT s FROM Scrap s ORDER BY s.id DESC")
    List<Scrap> findAllDesc();
}
