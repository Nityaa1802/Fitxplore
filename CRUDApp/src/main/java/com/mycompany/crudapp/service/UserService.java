package com.mycompany.crudapp.service;

import com.mycompany.crudapp.dao.UserRepository;
import com.mycompany.crudapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired private UserRepository repository;

    public List<User> listAll(){
        return (List<User>) repository.findAll();
    }
}
