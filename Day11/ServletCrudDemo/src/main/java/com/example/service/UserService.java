package com.example.service;

import com.example.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {

    private Map<Integer, User>userDB;

    public UserService() {
        userDB=new HashMap<>();
    }

    public void createUser(User userReq){
        userDB.put(userReq.getId(),userReq);
    }

    public List<User> getAllUsers(){
        return new ArrayList<>(userDB.values());
    }

    public User getUserById(Integer id){
        if(userDB.containsKey(id)){
            return userDB.get(id);
        }
        return null;
    }
}
