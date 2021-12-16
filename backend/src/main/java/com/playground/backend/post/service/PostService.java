package com.playground.backend.post.service;

import com.playground.backend.post.domain.Post;
import com.playground.backend.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public List<Post> getPosts() {
        return this.postRepository.findAll();
    }

    public Post insertPost(String contents) {
        return this.postRepository.save(
                new Post().builder()
                        .contents(contents)
                        .build()
        );
    }

}
