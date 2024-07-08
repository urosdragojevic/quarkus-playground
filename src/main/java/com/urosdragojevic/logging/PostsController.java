package com.urosdragojevic.logging;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import java.util.List;

@ApplicationScoped
@Path("posts")
public class PostsController {

    @Inject
    PostsService service;

    @GET
    public List<Post> getPosts() {
        return service.getPosts();
    }

    @POST
    public Post savePost(Post post) {
        return service.createPost(post);
    }
}
