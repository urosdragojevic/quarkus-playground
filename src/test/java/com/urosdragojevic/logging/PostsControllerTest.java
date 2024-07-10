package com.urosdragojevic.logging;

import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@QuarkusTest
class PostsControllerTest {

    @InjectMock
    PostsService service;

    @Test
    void getPosts_success() {
        when(service.getPosts()).thenReturn(List.of(new Post(), new Post(), new Post()));
        Post[] result = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/posts")
                .then()
                .extract()
                .as(Post[].class);
        assertEquals(3, result.length);
    }

    @Test
    void createPost_success() {
        Post newPost = new Post();
        newPost.setTitle("Test post");
        PostDto result = given()
                .contentType(ContentType.JSON)
                .body(newPost)
                .when()
                .post("/posts")
                .then()
                .statusCode(200)
                .extract()
                .as(PostDto.class);
        assertEquals("Test post", result.title());
    }

    @Test
    void createPost_titleBlank_400() {
        Post newPost = new Post();
        newPost.setTitle("");
        given()
                .contentType(ContentType.JSON)
                .body(newPost)
                .when()
                .post("/posts")
                .then()
                .statusCode(400);
    }

    @Test
    void createPost_titleNull_400() {
        Post newPost = new Post();
        given()
                .contentType(ContentType.JSON)
                .body(newPost)
                .when()
                .post("/posts")
                .then()
                .statusCode(400);
    }
}
