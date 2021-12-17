package com.playground.backend.post.service;

import org.springframework.stereotype.Service;
import com.playground.backend.post.domain.Post;
import com.playground.backend.post.repository.PostRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public List<Post> getPosts() {
        return this.postRepository.findAll();
    }

    public Post createPost(String contents) {
        return this.postRepository.save(
                new Post().builder()
                        .contents(contents)
                        .build()
        );
    }

}
