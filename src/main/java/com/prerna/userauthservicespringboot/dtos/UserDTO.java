package com.prerna.userauthservicespringboot.dtos;

import com.prerna.userauthservicespringboot.models.Role;

import java.util.List;

public class UserDTO {

    private Long id;
    private List<Role> roles;
    private String name;
    private String email;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

