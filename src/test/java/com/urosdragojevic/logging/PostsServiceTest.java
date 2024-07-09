package com.urosdragojevic.logging;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
class PostsServiceTest {

    @Inject
    PostsService service;
    @Inject
    EntityManager entityManager;

    @Test
    @TestTransaction
    void getPosts_success() {
        List<Post> posts = service.getPosts();
        assertEquals(3, posts.size());
    }

    @Test
    @TestTransaction
    void createPost_success() {
        Post post = new Post();
        post.setTitle("A new post");
        Post savedPost = service.createPost(post);
        Post postFromDb = entityManager.find(Post.class, savedPost.getId());
        assertEquals("A new post", postFromDb.getTitle());
    }
}
