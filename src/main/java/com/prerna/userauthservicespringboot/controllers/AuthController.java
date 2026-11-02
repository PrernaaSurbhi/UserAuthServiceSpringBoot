package com.prerna.userauthservicespringboot.controllers;


import com.prerna.userauthservicespringboot.dtos.LoginRequestDto;
import com.prerna.userauthservicespringboot.dtos.SignupRequestDTO;
import com.prerna.userauthservicespringboot.dtos.UserDTO;
import com.prerna.userauthservicespringboot.models.User;
import com.prerna.userauthservicespringboot.services.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private IAuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<UserDTO> signup(@RequestBody SignupRequestDTO signupRequestDTO){

        try{

            User user = authService.signup(
                    signupRequestDTO.getName(),
                    signupRequestDTO.getEmail(),
                    signupRequestDTO.getPassword()

            );

            UserDTO userDTO = user.toUserDTO();

            return new ResponseEntity<>(userDTO, HttpStatus.OK);
        }catch (Exception e){
            throw e;
        }
    }


    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody LoginRequestDto loginRequestDto){

        try{
            User user = authService.login(
                    loginRequestDto.getEmail(),
                    loginRequestDto.getPassword()
            );

            UserDTO userDTO = user.toUserDTO();

            return new ResponseEntity<>(userDTO, HttpStatus.OK);

        }catch(Exception e){
            throw  e;
        }
    }


}
