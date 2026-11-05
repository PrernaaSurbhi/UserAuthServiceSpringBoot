package com.prerna.userauthservicespringboot.services;

import com.prerna.userauthservicespringboot.exceptions.IncorrectPasswordException;
import com.prerna.userauthservicespringboot.exceptions.UserAlreadyExistException;
import com.prerna.userauthservicespringboot.exceptions.UserNotRegisteredException;
import com.prerna.userauthservicespringboot.models.Role;
import com.prerna.userauthservicespringboot.models.State;
import com.prerna.userauthservicespringboot.models.User;
import com.prerna.userauthservicespringboot.repositories.RoleRepo;
import com.prerna.userauthservicespringboot.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service("AuthService")
public class AuthService implements IAuthService{

    @Autowired
    private  RoleRepo roleRepo;

    @Autowired
    private  UserRepo userRepo;


    @Override
    public User signup(String name, String email, String password) {

        // Check uniqueness
        //Check email already exist or not , if exist throw exception

        Optional<User> optionalUser  = userRepo.findByEmail(email);

        if(optionalUser.isPresent()){
            throw new UserAlreadyExistException("User already present");
        }

        //if user not exist , create new user

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setCreatedAt(System.currentTimeMillis());
        user.setUpdatedAt(System.currentTimeMillis());
        user.setState(State.ACTIVE);

        //Assign Role

        Role role = null;

        Optional<Role> optionalRole =  roleRepo.findByValue(email);

        if(optionalRole.isEmpty()){

            role = new Role();
            role.setValue("DEFAULT");
            role.setCreatedAt(System.currentTimeMillis());
            role.setUpdatedAt(System.currentTimeMillis());
            role.setState(State.ACTIVE);
            roleRepo.save(role);

        }
        else optionalRole.get();

        List<Role> roles = new ArrayList<>();
        roles.add(role);

        return userRepo.save(user);
    }

    @Override
    public Boolean validateToken(String token) {
        return null;
    }

    @Override
    public User login(String email, String password) {

        //fetch user
        Optional<User> optionalUser = userRepo.findByEmail(email);

        //check if user exists
        if(optionalUser.isEmpty()){
            throw new UserNotRegisteredException("user with email: "+email+ " not registered");
        }

        User user = optionalUser.get();

        //check if password is correct
        if(password.equals(user.getPassword())){
            throw new IncorrectPasswordException("Invalid credential");
        }

        return user;
    }

}
