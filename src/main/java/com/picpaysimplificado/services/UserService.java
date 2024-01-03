package com.picpaysimplificado.services;

import com.picpaysimplificado.domain.user.Users;
import com.picpaysimplificado.domain.user.UserType;
import com.picpaysimplificado.dto.UserDto;
import com.picpaysimplificado.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService {

    @Autowired
     private UserRepository repository;

    public void validateTransactional(Users sender, BigDecimal amout) throws Exception {
        if (sender.getUserType() == UserType.MERCHANT){
            throw new Exception("Usuario do tipo logista não está autorizado a realizar transação");

        }

        if (sender.getBalance().compareTo(amout) < 0){
            throw  new Exception("Saldo insuficiente");
        }

    }

    public Users findUserById(Long id) throws Exception {
        return this.repository.findUserById(id).orElseThrow(() -> new Exception("Usuario não encontrado"));
    }

    public void saveUser(Users Users){
        this.repository.save(Users);
    }


    public Users createUser(UserDto userDto) {
        Users newUsers = new Users(userDto);
        this.saveUser(newUsers);
        return newUsers;
    }

    public List<Users> getAllUsers() {
        return this.repository.findAll();
    }
}
