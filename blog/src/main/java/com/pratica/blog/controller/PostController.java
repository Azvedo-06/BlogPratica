package com.pratica.blog.controller;

import com.pratica.blog.dto.PostDTO;
import com.pratica.blog.entity.Post;
import com.pratica.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Controller: é responsável por receber todas as requisições do usuário
@RestController //RestController: é uma implementação de Controller voltado para o desenvolvimento de aplicações Restful
@RequestMapping("/posts") //ResquestMapping: é usada para mapear solicitações para métodos de controladores
public class PostController {

    @Autowired  //fornece controle sobre onde e como a ligação entre os beans deve ser realizada
    private PostService postService;

    @PostMapping //simplificar o mapeamento dos métodos HTTP e expressar de forma mais concisa os métodos de manipulação
    public ResponseEntity<PostDTO> save(@RequestBody PostDTO postDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(postService.save(postDTO));

        //RequestBody: usado quando você precisa receber dados não como parâmetros de solicitação, mas como o corpo inteiro da solicitação HTTP.
        //ResponseEntity: representa uma resposta HTTP, permitindo que você personalize o status da resposta
    }

    @GetMapping // mapeando solicitações HTTP GET
    public ResponseEntity<List<PostDTO>> findAll() {
        return ResponseEntity.ok(postService.findlAll());
    }

    @GetMapping("/{id}") // Get com parâmetro de encontra um id somente
    public ResponseEntity<PostDTO> findById(@PathVariable Integer id) {
        PostDTO post = postService.findById(id);
        if (post == null) {
            return ResponseEntity.notFound().build();
        }
        // se post for difetente de nulo, se for retorna um 200 caso contrário retorna um 404
        return ResponseEntity.ok(post);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT) // responsável pelo 204, sem conteudo para o delete
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        postService.delete(id);
    }

    @PutMapping("/{id}") // HTTP do tipo PUT,  utilizada para atualizar um recurso existente identificado pelo seu id
    public ResponseEntity<PostDTO> update(@PathVariable Integer id, @RequestBody PostDTO post) {
        // post atualizado
        return ResponseEntity.ok(postService.update(id, post));
    }

}
