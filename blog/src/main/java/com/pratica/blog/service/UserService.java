package com.pratica.blog.service;

import com.pratica.blog.dto.UserDTO;
import com.pratica.blog.entity.User;
import com.pratica.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


//Camada Service: responsável em chamar o repository para fazer as operações
@Service
public class UserService {

    @Autowired //fornece controle sobre onde e como a ligação entre os beans deve ser realizada
    private UserRepository userRepository;

    // salvando um Usuario
    public User save(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setSenha(userDTO.getSenha());
        user.setData_criacao(userDTO.getData_criacao());
        return userRepository.save(user);
    }

    // lista de Usuarios, retorna uma lista de todos os usuarios
    public List<UserDTO> findlAll() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(UserDTO::fromEntity) // converte cada entidade em um DTO
                .collect(Collectors.toList()); // coleta os dados do stream e transforma numa lista
    }

    // buscando um usuario pelo id
    public UserDTO findById(Integer id) {
        Optional<User> optionalUser = userRepository.findById(id);
        // verifica se o id existi, se não existir retorna nulo e tambem fazer a mudança do entidade para dto
        return UserDTO.fromEntity(optionalUser.orElse(null));
    }

    // deletando um usuario pelo id
    public void delete(Integer id) {
        // verificando se o usuario existe
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("Usuario não encontrado");
        }

        // excluir usuario
        userRepository.deleteById(id);
    }

    // update de um usuario
    public UserDTO update(Integer id, UserDTO userDTO) {
        // achando o usuario pelo id, caso não exista uma mensagem sera exibida
        User userFound = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

        // atualizando campos (todos)
        userFound.setUsername(userDTO.getUsername());
        userFound.setEmail(userDTO.getEmail());
        userFound.setSenha(userDTO.getSenha());
        userFound.setData_criacao(userDTO.getData_criacao());

        // Retorna o DTO atualizado
        return UserDTO.fromEntity(userFound);
    }
}
