package com.student.register.service.dao;

import com.student.register.common.entity.User;
import com.student.register.common.repo.IUserRepository;

public class UserDaoService {

    private IUserRepository userRepository;

    public UserDaoService(IUserRepository userRepository){
        this.userRepository =userRepository;

    }

    public void addUser(User user){
        try {
            userRepository.save(user);  
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
}
