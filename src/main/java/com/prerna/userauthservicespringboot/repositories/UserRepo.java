package com.prerna.userauthservicespringboot.repositories;

import com.prerna.userauthservicespringboot.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

}
