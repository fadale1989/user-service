package com.vikas.user.controller;

import com.vikas.user.entity.User;
import com.vikas.user.service.UserService;
import com.vikas.user.vo.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    UserService service;

    @PostMapping
    User saveUser(@RequestBody User user){
        log.info("Inside saveUser method of"+ UserController.class);
        return service.saveUser(user);
    }

    @GetMapping("/{id}")
    ResponseVO findUserWithDepartment(@PathVariable("id") Long userId){
        log.info("Inside findUserWithDepartment method of"+ UserController.class);
        return service.findUserWithDepartment(userId);
    }


}
