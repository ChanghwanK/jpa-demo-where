package com.bloo.jpa.demo.Entity;

import static org.junit.jupiter.api.Assertions.*;

import com.bloo.jpa.demo.enumclass.PostStatus;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @CreateBy: Bloo
 * @Date: 2021/05/26
 */

@SpringBootTest
class PostTest {

    @Autowired
    private PostRepository postRepository;


    @Test
    void find() {
        Post post = Post.builder()
            .content("test01")
            .title("title_test")
            .status(PostStatus.REGISTER)
            .build();
        // System.out.println(post);

        postRepository.save(post);

        Post post2 = Post.builder()
            .content("test02")
            .title("title_test2")
            .status(PostStatus.UNREGISTER)
            .build();

        postRepository.save(post2);

        List<Post> findPost = postRepository.findAll();
        findPost.forEach(System.out::println);

//        Post post = postRepository.findById(1L).orElseThrow(RuntimeException::new);
    }

}