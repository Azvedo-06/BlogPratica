package com.pratica.blog.controller;
import com.pratica.blog.entity.User;
import com.pratica.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//Controller: é responsável por receber todas as requisições do usuário
@RestController //RestController: é uma implementação de Controller voltado para o desenvolvimento de aplicações Restful
@RequestMapping("/users") //ResquestMapping: é usada para mapear solicitações para métodos de controladores
public class UserController {

    @Autowired //fornece controle sobre onde e como a ligação entre os beans deve ser realizada
    private UserService userService;

    @PostMapping //simplificar o mapeamento dos métodos HTTP e expressar de forma mais concisa os métodos de manipulação
    public ResponseEntity<User> save(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));

        //RequestBody: usado quando você precisa receber dados não como parâmetros de solicitação, mas como o corpo inteiro da solicitação HTTP.
        //ResponseEntity: representa uma resposta HTTP, permitindo que você personalize o status da resposta
    }

    @GetMapping // mapeando solicitações HTTP GET
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userService.findlAll());
    }

    @GetMapping("/{id}") // Get com parâmetro de encontra um id somente
    public ResponseEntity<User> findById(@PathVariable Integer id) {
        User user = userService.findById(id);
        // se user for difetente de nulo, se for retorna um 200 caso contrário retorna um 404
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updata(@RequestBody User user, @PathVariable Integer id) {
        return ResponseEntity.ok(userService.update(id, user));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT) // responsável pelo 204, sem conteudo para o delete
    @DeleteMapping
    public void delete(@PathVariable Integer id) {
        userService.delete(id);
    }

}
