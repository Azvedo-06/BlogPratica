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
}
