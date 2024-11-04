package com.picpaySimplificado.picpaySimplificado.services;


import com.picpaySimplificado.picpaySimplificado.domain.user.User;
import com.picpaySimplificado.picpaySimplificado.domain.user.UserType;
import com.picpaySimplificado.picpaySimplificado.dtos.UserDTO;
import com.picpaySimplificado.picpaySimplificado.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService {

    public Object saveUser;
    @Autowired
    private UserRepository repository;


    public void validateTransaction(User sender, BigDecimal amount) throws Exception {
        if (sender.getUserType() == UserType.MERCHANT) {
            throw new Exception("Usuario não está autorizado !");
        }
        if (sender.getBalance().compareTo(amount) < 0)
            throw new Exception("Usuário sem saldo!");
    }

    public User findUserByDocument(Long id) throws Exception {
        return this.repository.findById(id)
                .orElseThrow(() -> new Exception("Usuário não encontrado."));
    }

    public User createUser(UserDTO data) {
        User newUser = new User(data);
        this.setSaveUser(newUser);
        return newUser;
    }


    public List<User> getAllUsers() {
        return this.repository.findAll();
    }

    public void setSaveUser(User user) {
        this.repository.save(user);
    }
}