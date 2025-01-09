package com.pratica.blog.service;


import com.pratica.blog.dto.PostDTO;
import com.pratica.blog.entity.Post;
import com.pratica.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    // buscando por Id
    public PostDTO findById(Integer id) {
        Optional<Post> postOptional = postRepository.findById(id);
        // verifica se o id existi, se não existir retorna nulo e tambem fazer a mudança do entidade para dto
        return PostDTO.fromEntity(postOptional.orElse(null));
    }

    // deletar Post pelo id
    public void delete(Integer id) {
        // verifica se existe um post com este id (! = caso contrário ou seja "!" e usado para negação)
        if (!postRepository.existsById(id)) {
            throw new RuntimeException("Post não encontrado");
        }
        // deletando pelo id
        postRepository.deleteById(id);
    }

    // update de post
    public PostDTO update(Integer id, PostDTO postDTO) {
        // achando o Post pelo id, caso não exista uma mensagem sera exibida
        Post postFound = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post não encontrado"));

        // atualizando campos (todos)
        postFound.setTitulo(postDTO.getTitulo());
        postFound.setConteudo(postFound.getConteudo());
        postFound.setData_criacao(postFound.getData_criacao());
        postFound.setId_usuario(postDTO.getId_usuario());

        // Retorna o DTO atualizado
        return PostDTO.fromEntity(postFound);

    }
}
