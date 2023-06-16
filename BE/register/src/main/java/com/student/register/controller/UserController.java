package com.student.register.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.register.common.dto.ResponseData;
import com.student.register.common.dto.SaveUserDto;
import com.student.register.service.IUserService;

@RestController
@RequestMapping("/user/v1")
public class UserController {

    private IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseData> registerUser(@RequestBody SaveUserDto request) {

        return new ResponseEntity<ResponseData>(userService.registerUser(request), HttpStatus.OK);

    }

}
