package com.prerna.userauthservicespringboot.repositories;

import com.prerna.userauthservicespringboot.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role,Long> {

}
