package com.pratica.blog.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.util.Date;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // os valores a serem atribuídos ao identificador único
    private Integer id_post;                            // serão gerados pela coluna de auto incremento do banco de dados

    @Column
    private String titulo;

    @Column
    private String conteudo;

    @Column
    @CreationTimestamp // data de criação automática atual do JVM
    private Date data_criacao;

    @ManyToOne // Relacionamento N:1 (Um usuário pode criar vários posts)
    @JoinColumn(name = "id_usuario") // join na coluna id_usuario na tabela users
    private User id_usuario;

    // getter e setter


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
