package com.student.register.common.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.register.common.entity.User;

public interface IUserRepository extends JpaRepository<User,Long>{
    
}
