package com.pratica.blog.service;


import com.pratica.blog.dto.PostDTO;
import com.pratica.blog.entity.Post;
import com.pratica.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

//Camada Service: responsável em chamar o repository para fazer as operações
@Service
public class PostService {

    @Autowired //fornece controle sobre onde e como a ligação entre os beans deve ser realizada
    private PostRepository postRepository;

    // salvando um Post
    public PostDTO save(PostDTO postDTO) {
        Post post = new Post();
        post.setId_post(postDTO.getId_post());
        post.setTitulo(postDTO.getTitulo());
        post.setConteudo(postDTO.getConteudo());
        post.setData_criacao(postDTO.getData_criacao());
        post.setId_usuario(postDTO.getId_usuario());
        return PostDTO.fromEntity(postRepository.save(post));
    }

    //buscando todos os post (list)
    public List<PostDTO> findlAll() {
        List<Post> posts = postRepository.findAll();
        return posts.stream()
                .map(PostDTO:: fromEntity) // converte cada entidade em DTO
                .collect(Collectors.toList()); // coleta os dados do stream e transforma num list
    }
}
