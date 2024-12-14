package com.pratica.blog.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "posts_categories")
public class PostCategory {

    @EmbeddedId // para especificar a chave composta.
    private PostCategoryID id;

    @ManyToOne
    @MapsId("postId") // Mapeia o campo postId da chave composta
    @JoinColumn(name = "id_post")
    private Post id_post;

    @ManyToOne
    @MapsId("categoriesId") // Mapeia o campo postId da chave composta
    @JoinColumn(name = "id_categories")
    private Category id_categories;

    // Constructor

    public PostCategory() {}

    public PostCategory(PostCategoryID id, Post id_post, Category id_categories) {
        this.id = id;
        this.id_post = id_post;
        this.id_categories = id_categories;
    }

    // Getters e Seters

    public PostCategoryID getId() {
        return id;
    }

    public void setId(PostCategoryID id) {
        this.id = id;
    }

    public Post getId_post() {
        return id_post;
    }

    public void setId_post(Post id_post) {
        this.id_post = id_post;
    }

    public Category getId_categories() {
        return id_categories;
    }

    public void setId_categories(Category id_categories) {
        this.id_categories = id_categories;
    }
}
