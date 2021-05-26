package com.bloo.jpa.demo;

import com.bloo.jpa.demo.Entity.Post;
import com.bloo.jpa.demo.Entity.PostRepository;
import com.bloo.jpa.demo.enumclass.PostStatus;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @CreateBy: Bloo
 * @Date: 2021/05/26
 */
@RequestMapping("/api/posts")
@RestController
public class ApiPostController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("")
    public List<Post> findAll() {
        postRepository.findAll().forEach(System.out::println);
        return Collections.unmodifiableList(postRepository.findAll());
    }

    @GetMapping("/un")
    public List<Post> find() {
        postRepository.findAll().stream().filter(
            post -> post.getStatus().equals(PostStatus.REGISTER)
        ).collect(Collectors.toList()).forEach(System.out::println);

        return null;
    }
}
