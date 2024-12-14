package com.pratica.blog.entity;

import jakarta.persistence.Embeddable;
import java.io.Serializable; // permite que os objetos dessa classe sejam convertidos em uma sequência de bytes

@Embeddable // para definir a chave composta
public class PostCategoryID implements Serializable {

    private Integer postId;
    private Integer categoriesId;

    // Constructor

    public PostCategoryID() {}

    public PostCategoryID(Integer postId, Integer categoriesId) {
        this.postId = postId;
        this.categoriesId = categoriesId;
    }

    // Getters e Setters


    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getCategoriesId() {
        return categoriesId;
    }

    public void setCategoriesId(Integer categoriesId) {
        this.categoriesId = categoriesId;
    }
}
