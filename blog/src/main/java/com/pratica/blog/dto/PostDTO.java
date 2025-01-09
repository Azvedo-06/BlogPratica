package com.pratica.blog.dto;

import com.pratica.blog.entity.Post;
import com.pratica.blog.entity.User;

import java.util.Date;

//DTO para abstrair a entidade das outras camadas
public class PostDTO {
    private Integer id_post;
    private String titulo;
    private String conteudo;
    private Date data_criacao;
    private User id_usuario;

    // Métodos de conversão
    public static PostDTO fromEntity(Post post) {
        PostDTO dto = new PostDTO();
        dto.setId_post(post.getId_post());
        dto.setTitulo(post.getTitulo());
        dto.setConteudo(post.getConteudo());
        dto.setData_criacao(post.getData_criacao());
        dto.setId_usuario(post.getId_usuario());
        return dto;
    }

    public static Post toEntity(PostDTO dto) {
        Post post = new Post();
        dto.setId_post(post.getId_post());
        dto.setTitulo(post.getTitulo());
        dto.setConteudo(post.getConteudo());
        dto.setData_criacao(post.getData_criacao());
        dto.setId_usuario(post.getId_usuario());
        return post;
    }

    // gatter e setter

    public Integer getId_post() {
        return id_post;
    }

    public void setId_post(Integer id_post) {
        this.id_post = id_post;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Date getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(Date data_criacao) {
        this.data_criacao = data_criacao;
    }

    public User getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(User id_usuario) {
        this.id_usuario = id_usuario;
    }
}
