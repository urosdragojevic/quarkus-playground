package com.urosdragojevic.logging;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import java.util.List;

@ApplicationScoped
@Path("posts")
public class PostsController {

    @Inject
    PostsService service;
    @Inject
    PostMapper postMapper;

    @GET
    public List<Post> getPosts() {
        return service.getPosts();
    }

    @POST
    public PostDto savePost(@Valid Post post) {
        Post newPost = service.createPost(post);
        return postMapper.toDto(newPost);
    }
}
