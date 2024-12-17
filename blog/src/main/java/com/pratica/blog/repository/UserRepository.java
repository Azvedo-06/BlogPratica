package com.pratica.blog.repository;

import com.pratica.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

//JPA fornece seus próprios métodos de pesquisa, como também métodos capazes de salvar e remover listas de objetos do banco de dados.
public interface UserRepository extends JpaRepository<User, Integer> {
}
