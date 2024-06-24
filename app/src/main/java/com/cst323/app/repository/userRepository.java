package com.cst323.app.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cst323.app.entity.user;

//Interact with Database
@Repository
public interface userRepository extends JpaRepository<user, Long> {

    //Query methods, CRUD methods created with JpaRepository interface

    //Delete method to fix method in service method
    void deleteUser(Long id);
    
}
