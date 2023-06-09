package com.student.register.common.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SaveUserDto {

    private String firstName;
    private String lastName;

    private String dob;

    @Pattern(regexp = "^\\d{7,10}$", message="Mobile number is not valid")
    private String mobile;
    @Pattern(regexp = "^\\+\\d{1,3}",message="Country code is not valid")
    private String countryCode;
    @Email(message = "Email is not valid")
    private String email;
    
}
