package com.student.register.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.register.common.dto.SaveUserDto;

@RestController
@RequestMapping("/user/v1")
public class UserController {

    

    public ResponseEntity<ResponseData> registerUser(@RequestBody SaveUserDto request){

        return new ResponseEntity<ResponseData>(new ResponseData(),HttpStatus.OK);

    }
    
}
