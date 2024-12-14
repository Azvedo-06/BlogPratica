package com.pratica.blog.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.util.Date;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // os valores a serem atribuídos ao identificador único
    private Integer id_comments;                        // serão gerados pela coluna de auto incremento do banco de dados

    @Column
    private String conteudo;

    @Column
    @CreationTimestamp  // data de criação automática atual do JVM
    private Date data_criacao;

    @ManyToOne // Relacionamento 1:N (Um post pode ter muitos comentários).
    @JoinColumn(name = "id_post") // join na coluna id_post na tabela posts
    private Post id_post;

    @ManyToOne // Relacionamento 1:N (Um usuário pode fazer muitos comentários).
    @JoinColumn(name = "id_usuario") // join na coluna id_usuario na tabela users
    private User id_usuario;

    //Getter e Setter


    public Integer getId_comments() {
        return id_comments;
    }

    public void setId_comments(Integer id_comments) {
        this.id_comments = id_comments;
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

    public Post getId_post() {
        return id_post;
    }

    public void setId_post(Post id_post) {
        this.id_post = id_post;
    }

    public User getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(User id_usuario) {
        this.id_usuario = id_usuario;
    }
}