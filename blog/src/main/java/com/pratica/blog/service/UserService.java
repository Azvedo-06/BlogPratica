package com.pratica.blog.service;

import com.pratica.blog.entity.User;
import com.pratica.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Camada Service: responsável em chamar o repository para fazer as operações
@Service
public class UserService {

    @Autowired //fornece controle sobre onde e como a ligação entre os beans deve ser realizada
    private UserRepository userRepository;

    // salvando um Usuario
    public User save(User user) {
        return userRepository.save(user);
    }

    // lista de Usuarios, retorna uma lista de todos os usuarios
    public List<User> findlAll() {
        return userRepository.findAll();
    }

    // buscando um usuario pelo id
    public User findById(Integer id) {
        Optional<User> optionalUser = userRepository.findById(id);
        // verifica se o id existi, se não existir retorna nulo
        return optionalUser.orElse(null);
    }

    // deletando um usuario pelo id
    public void delete(Integer id) {
        // instância de usuario
        User user = new User();
        // setter o id que queremos deletar na instância
        user.setId_usuario(id);
        // delete do usuario
        userRepository.delete(user);
    }

    // update de um usuario
    public User update(Integer id, User user) {
        User userFound = findById(id);
        // se o user for diferente de nulo ele salva
        if (userFound != null ) {
            return userRepository.save(user);
        } else {
            return user;
        }
    }
}
