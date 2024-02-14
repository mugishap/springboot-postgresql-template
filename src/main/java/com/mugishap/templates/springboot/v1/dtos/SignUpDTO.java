package com.mugishap.templates.springboot.v1.dtos;


import com.mugishap.templates.springboot.v1.enums.ERole;
import com.mugishap.templates.springboot.v1.security.ValidPassword;
import com.mugishap.templates.springboot.v1.enums.EGender;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
public class SignUpDTO {

    @Email
    private  String email;

    @NotBlank
    private  String firstName;

    @NotBlank
    private  String lastName;

    @NotBlank
    @Pattern(regexp = "[0-9]{9,12}", message = "Your phone is not a valid tel we expect 2507***, or 07*** or 7***")
    private  String mobile;

    private EGender gender;

    private ERole role;

    @ValidPassword
    private  String password;
}
