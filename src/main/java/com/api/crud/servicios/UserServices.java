package com.api.crud.servicios;

import com.api.crud.models.UserModels;
import com.api.crud.repositories.iUserRespositories;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserServices {
    @Autowired
    iUserRespositories userReposiroty;

    public ArrayList<UserModels> getUser(){
        return (ArrayList<UserModels>) userReposiroty.findAll();
    }

    public UserModels saveUser(UserModels user){
        return  userReposiroty.save(user);
    }

    public Optional<UserModels> getById(Long id){
        return  userReposiroty.findById(id);

    }
    public UserModels updateNyId(UserModels req,Long id) {
        UserModels user = userReposiroty.findById(id).get();
        user.setFirstName(req.getFirstName());
        user.setLastName(req.getLastName());
        user.setEmail(req.getEmail());
        return  user;
    }
    public Boolean deleteUser(Long id){
        try{
            userReposiroty.deleteById(id);
            return  true;
        }catch (Exception e){
            return  false;
        }
    }
}
