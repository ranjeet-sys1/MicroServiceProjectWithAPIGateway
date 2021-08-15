package com.app.ranjeet.UserService.controller;

import com.app.ranjeet.UserService.VO.ResponseTemplateVO;
import com.app.ranjeet.UserService.entity.User;
import com.app.ranjeet.UserService.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/saveUser")
    public ResponseEntity saveUser(@RequestBody User user){
        User savedUser = userService.SaveUser(user);
        return new ResponseEntity<User>(savedUser, HttpStatus.ACCEPTED);
    }
    @GetMapping("/getUser/{userId}")
    public ResponseTemplateVO getUserFromDepartment(@PathVariable("userId") long userId){
        return userService.getUserFromDepartment(userId);

    }
}
