package com.prerna.userauthservicespringboot.services;

import com.prerna.userauthservicespringboot.models.User;
import org.springframework.stereotype.Service;


@Service("AuthService")
public class AuthService implements IAuthService{

    @Override
    public User signup(String name, String email, String password) {
        return null;
    }

    @Override
    public Boolean validateToken(String token) {
        return null;
    }

    @Override
    public User login(String email, String Password) {
        return null;
    }

}
