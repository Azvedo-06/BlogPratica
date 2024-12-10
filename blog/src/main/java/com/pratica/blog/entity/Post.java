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

}
