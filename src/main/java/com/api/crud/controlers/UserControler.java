package com.api.crud.controlers;

import com.api.crud.models.UserModels;
import com.api.crud.servicios.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserControler {

    @Autowired
    private UserServices userServices;

    @GetMapping
    public ArrayList<UserModels> getUsers(){
        return  this.userServices.getUser();
    }

    @PostMapping
    public UserModels savaUser(@RequestBody UserModels user ){
        return  this.userServices.saveUser(user);

    }

    @GetMapping(path = "/{id}")
    public Optional<UserModels> getById(@PathVariable("id") long id){
        return this.userServices.getById(id);
    }

    @PutMapping(path = "/{id}")
    public  UserModels updateUserById(@RequestBody UserModels user,@PathVariable("id") long id){
        //revisar
        return  this.userServices.updateNyId(user,id);
    }
    @DeleteMapping(path = "/{id}")
    public Boolean deletById(@PathVariable("id") long id){
        return this.userServices.deleteUser(id);
    }

}
