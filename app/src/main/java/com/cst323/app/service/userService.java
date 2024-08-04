package com.cst323.app.service;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cst323.app.entity.user;
import com.cst323.app.repository.userRepository;

@Service
public class userService {

    @Autowired
    private userRepository userRepository;

    private static final Logger logger = Logger.Factory(userService.class);

    public List<user> getAllUsers()
    {
        logger.info("Finding Users");
        return userRepository.findAll();
    }

    
    public user saveUser(user user)
    {
        logger.info("User Saved");
        return userRepository.save(user);
    }
    
    public user updateUser(user user)
    {
        logger.info("User Updated");
        return userRepository.save(user);
    }

    public void deleteUserById(Long id)
    {
        logger.info("User Deleted");
        userRepository.deleteById(id);
    }

    public user getUserById(Long id) {
        Optional<user> findUser = userRepository.findById(id);
        logger.info("Finding User");
        return findUser.orElse(null);
    }
    
}