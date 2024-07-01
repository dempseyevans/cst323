package com.cst323.app.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cst323.app.entity.user;
import com.cst323.app.repository.userRepository;

@Service
public class userService {

    @Autowired
    private userRepository userRepository;

    public List<user> getAllUsers()
    {
        return userRepository.findAll();
    }

    public user saveUser(user user)
    {
        return userRepository.save(user);
    }
    
    public user updateUser(user user)
    {
        return userRepository.save(user);
    }

    public void deleteUser(Long id)
    {
        userRepository.deleteById(id);
    }

    public user getUserById(Long id) {
        Optional<user> findUser = userRepository.findById(id);

        return findUser.orElse(null);
    }
    
}
