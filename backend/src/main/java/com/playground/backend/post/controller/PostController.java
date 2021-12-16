package com.playground.backend.post.controller;

import com.playground.backend.post.domain.Post;
import com.playground.backend.post.dto.PostRequest;
import com.playground.backend.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/posts")
@RequiredArgsConstructor
@CrossOrigin(value = "http://localhost:3000")
@RestController
public class PostController {

    private final PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> getPosts() {
        List<Post> posts = this.postService.getPosts();
        return ResponseEntity.ok(posts);
    }

    @PostMapping
    public ResponseEntity<Post> insertPost(@RequestBody PostRequest postRequest) {
        Post post = this.postService.insertPost(postRequest.getContents());
        return ResponseEntity.ok(post);
    }
}


