package com.ifpe.edu.br.repository;

import com.ifpe.edu.br.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private List<User> users;

    private static UserRepository userRepository;

    private UserRepository(){
        users = new ArrayList<>();
    }

    public static UserRepository getInstance(){
        if(userRepository == null){
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

    public void update(User user) {
        users.add(user.getId(), user);
    }

    public boolean containEmail(String email){
        return users.stream().anyMatch(user -> email.equals(user.getEmail()));
    }
}
