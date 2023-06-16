package com.student.register.service.serviceImpl;

import com.student.register.common.dto.ResponseData;
import com.student.register.common.dto.SaveUserDto;
import com.student.register.common.entity.User;
import com.student.register.service.IUserService;
import com.student.register.service.dao.UserDaoService;

public class UserServiceImpl implements IUserService{

    private UserDaoService userDaoService;

    public UserServiceImpl(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    @Override
    public ResponseData registerUser(SaveUserDto saveUserDto) {

        User user = this.convertDtoToEntity(saveUserDto);

        userDaoService.addUser(user);

        return ResponseData.builder().status(true).message("Success").build();

    }

    private User convertDtoToEntity(SaveUserDto saveUserDto) {

        return User.builder().firstName(saveUserDto.getFirstName())
                .lastName(saveUserDto.getLastName())
                .countryCode(saveUserDto.getCountryCode())
                .email(saveUserDto.getEmail())
                .mobile(saveUserDto.getMobile())
                .gender(saveUserDto.getGender())
                .build();

    }

}
