package com.student.register.service.serviceImpl;

import com.student.register.common.dto.SaveUserDto;
import com.student.register.common.entity.User;
import com.student.register.service.dao.UserDaoService;

public class UserServiceImpl {

    private UserDaoService userDaoService;

    public UserServiceImpl(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    public void registerUser(SaveUserDto saveUserDto) {

        User user = this.convertDtoToEntity(saveUserDto);
        userDaoService.addUser(user);

    }

    private User convertDtoToEntity(SaveUserDto saveUserDto) {

        return User.builder().firstName(saveUserDto.getFirstName())
                .lastName(saveUserDto.getLastName())
                .countryCode(saveUserDto.getCountryCode())
                .email(saveUserDto.getEmail())
                .mobile(saveUserDto.getMobile())
                .build();

    }

}
