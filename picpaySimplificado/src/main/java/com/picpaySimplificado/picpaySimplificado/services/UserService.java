package com.picpaySimplificado.picpaySimplificado.services;


import com.picpaySimplificado.picpaySimplificado.domain.user.User;
import com.picpaySimplificado.picpaySimplificado.domain.user.UserType;
import com.picpaySimplificado.picpaySimplificado.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;


    public void validateTransaction(User sender, BigDecimal amount) throws Exception {
        if(sender.getUserType() == UserType.MERCHANT) {
            throw new Exception("Usuario não está autorizado !");
        }
        if(sender.getBalance().compareTo(amount) < 0 )
            throw new Exception("Usuário sem saldo!");
    }
    public User findUserByDocument(Long id) throws Exception {
        return this.repository.findById(id)
                .orElseThrow(() -> new Exception("Usuário não encontrado."));
    }

}
