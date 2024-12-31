package com.pratica.blog.dto;

import com.pratica.blog.entity.User;
import java.util.Date;

public class UserDTO  {

    private Integer id_usuario;
    private String username;
    private String email;
    private String senha;
    private Date data_criacao;

    // Métodos de conversão
    public static UserDTO fromEntity(User user) {
        UserDTO dto = new UserDTO();
        dto.setId_usuario(user.getId_usuario());
        dto.setUsername(user.getUsername());
        dto.setSenha(user.getSenha());
        dto.setData_criacao(user.getData_criacao());
        dto.setEmail(user.getEmail());
        return dto;
    }

    public static User toEntity(UserDTO dto) {
        User user = new User();
        dto.setId_usuario(user.getId_usuario());
        dto.setUsername(user.getUsername());
        dto.setSenha(user.getSenha());
        dto.setData_criacao(user.getData_criacao());
        dto.setEmail(user.getEmail());
        return user;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(Date data_criacao) {
        this.data_criacao = data_criacao;
    }
}
