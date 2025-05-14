package com.example.SMS.Service;


import com.example.SMS.Model.userModel;
import com.example.SMS.Repository.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class userService {

    @Autowired
    public userRepo userRepoObj;

    public void createUser(userModel user) {
        userRepoObj.save(user);
    }

    public List<userModel> findAlluser() {
        return userRepoObj.findAll();
    }

    public List<userModel> findDatabyId(Long id) {
        return userRepoObj.findAllById(id);
    }

    public Optional<userModel> findUserById(Long id) {
        return userRepoObj.findById(id);
    }

    public void updateUser(userModel userExiste) {
        userRepoObj.save(userExiste);
    }

    public void deleteUser(Long id) {
        userRepoObj.deleteById(id);
    }
}
