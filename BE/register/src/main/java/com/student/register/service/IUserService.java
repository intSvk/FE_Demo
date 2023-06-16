package com.student.register.service;

import org.springframework.stereotype.Service;

import com.student.register.common.dto.ResponseData;
import com.student.register.common.dto.SaveUserDto;
import com.student.register.service.dao.UserDaoService;

@Service
public interface IUserService {

    ResponseData registerUser(SaveUserDto saveUserDto);

}
