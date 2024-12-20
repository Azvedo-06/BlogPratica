package com.pratica.blog.service;
import com.pratica.blog.entity.User;
import com.pratica.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//Camada Service: responsável em chamar o repository para fazer as operações
@Service
public class UserService {

    @Autowired //fornece controle sobre onde e como a ligação entre os beans deve ser realizada
    private UserRepository userRepository;

    // salvando um Usuario
    public User save(User user) {
        return userRepository.save(user);
    }
}
