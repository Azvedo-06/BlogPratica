package com.pratica.blog.repository;

import com.pratica.blog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

//JPA fornece seus próprios métodos de pesquisa, como também métodos capazes de salvar e remover listas de objetos do banco de dados.
public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
