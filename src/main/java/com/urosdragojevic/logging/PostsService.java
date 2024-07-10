package com.urosdragojevic.logging;

import com.urosdragojevic.logging.interceptor.Logged;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@Logged
@ApplicationScoped
public class PostsService {

    @Inject
    PostsRepository repository;

    public List<Post> getPosts() {
        return repository.listAll();
    }

    @Transactional
    public void createPost(Post post) {
        repository.persist(post);
    }
}
