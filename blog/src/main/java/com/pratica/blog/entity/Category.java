package com.pratica.blog.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // os valores a serem atribuídos ao identificador único
    private Integer id_categories;                      // serão gerados pela coluna de auto incremento do banco de dados

    @Column
    private String nome;

    // Getter e Setter

    public Integer getId_categories() {
        return id_categories;
    }

    public void setId_categories(Integer id_categories) {
        this.id_categories = id_categories;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
