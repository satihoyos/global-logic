package com.globallogic.evaluation.userapi.controller;

import com.globallogic.evaluation.userapi.entity.UserEntity;
import com.globallogic.evaluation.userapi.model.UserInfo;
import com.globallogic.evaluation.userapi.model.UserRq;
import com.globallogic.evaluation.userapi.model.UserRs;
import com.globallogic.evaluation.userapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sati on 29-07-20.
 */
@RestController
@RequestMapping("/user")
public class UserResource {

    @Autowired
    private UserService userService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public UserRs create(@RequestBody UserRq user){
       return  userService.create(user);
    }

    @GetMapping()
    public List<UserInfo> lista(){
        return userService.getList();
    }
}
