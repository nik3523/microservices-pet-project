package com.pet.project.service;

import com.pet.project.entity.Post;
import com.pet.project.exception.EntityNotFoundException;
import com.pet.project.repository.PostRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Service
@Log
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Value("${services.user-service.url:http://localhost:8080}")
    private String userServiceUrl;

    public Post getPostById(Long id) {
        return postRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
    }

    public Post createPost(Post post) {
        post.setPostedAt(LocalDate.now());
        Post savedPost = postRepository.save(post);
        RestTemplate restTemplate = new RestTemplate();
        log.info("Call to user service url: " + userServiceUrl + " to post a message for user");
        restTemplate.postForEntity(userServiceUrl + "/users/" + post.getAuthorId() + "/posts", null, Integer.class);
        return savedPost;
    }

    public Post updatePost(Post post) {
        return postRepository.save(post);
    }

    public void deletePost(Long id) {
        if (postRepository.existsById(id)) {
            postRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException(id);
        }
    }
}
