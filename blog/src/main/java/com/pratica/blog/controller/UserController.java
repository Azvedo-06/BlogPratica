package com.pratica.blog.controller;
import com.pratica.blog.entity.User;
import com.pratica.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//Controller: é responsável por receber todas as requisições do usuário
//RestController: é uma implementação de Controller voltado para o desenvolvimento de aplicações Restful
@RestController
//ResquestMapping: é usada para mapear solicitações para métodos de controladores
@RequestMapping("/users")
public class UserController {

    @Autowired //fornece controle sobre onde e como a ligação entre os beans deve ser realizada
    private UserService userService;

    @PostMapping //simplificar o mapeamento dos métodos HTTP e expressar de forma mais concisa os métodos de manipulação
    public ResponseEntity<User> save(@RequestBody User user) {
        // RequestBody indicar ao Spring que um recurso não será enviado ou recebido por meio de uma página da Web
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }
}
