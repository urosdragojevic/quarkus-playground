package com.urosdragojevic.logging;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class PostsRepository implements PanacheRepositoryBase<Post, UUID> {

}
