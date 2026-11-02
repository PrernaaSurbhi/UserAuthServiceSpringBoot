package com.prerna.userauthservicespringboot.services;

import com.prerna.userauthservicespringboot.models.User;

public interface IAuthService {

    User signup(String name , String email, String password);

    Boolean validateToken(String token);

}
