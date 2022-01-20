package com.ifpe.edu.br.repository;

import com.ifpe.edu.br.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private List<User> users;

    private UserRepository userRepository;

    private UserRepository(){}

    public UserRepository getInstance(){
        if(userRepository == null){
            users = new ArrayList<>();
            userRepository = new UserRepository();
        }
        return userRepository;
    }

    public void add(User user){
        user.setId(users.size());
        users.add(user);
    }

    public User getById(int id){
        return users.get(id);
    }
}
