package com.simBank.service;

import com.simBank.controller.dto.UserDTO;
import com.simBank.domain.user.User;
import com.simBank.domain.user.UserType;
import com.simBank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public void validateTransaction(User sender, BigDecimal amount) throws Exception{
        if(sender.getUserType() == UserType.MERCHANT){
            throw new Exception("Lojista não pode realizar transações");
        }
        if(sender.getBalance().compareTo(amount) <= 0){
            throw  new Exception("Saldo Insuficiente");
        }
    }

    public User findUserById(Long Id) throws Exception {
        return this.repository.findUserByid(Id).orElseThrow(() -> new Exception("User Not Found"));
    }

    public void saveUser(User user){
        this.repository.save(user);
    }

    public User createUser(UserDTO data) {
        User newUser = new User(data);
        this.saveUser(newUser);
        return newUser;
    }

    public List<User> getAllUsers() {
       return this.repository.findAll();
    }
}
