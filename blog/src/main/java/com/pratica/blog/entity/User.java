package com.pratica.blog.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.util.Date;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // os valores a serem atribuídos ao identificador único
    private Integer id_usuario;                         // serão gerados pela coluna de auto incremento do banco de dados

    @Column(unique = true) // unique= true : dado em uma coluna serem exclusivos
    private String username;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String senha;

    @Column
    @CreationTimestamp // data de criação automática atual do JVM
    private Date data_criacao;

    // Getter e Setter

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(Date data_criacao) {
        this.data_criacao = data_criacao;
    }
}
