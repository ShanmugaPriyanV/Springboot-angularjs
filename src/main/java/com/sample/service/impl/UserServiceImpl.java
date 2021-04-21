package com.sample.service.impl;

import com.sample.domain.User;
import com.sample.repositories.UserRepository;
import com.sample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public User findById(Long id) {
        return userRepository.getOne(id);
    }

    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void updateUser(User user){
        saveUser(user);
    }

    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }

    public void deleteAllUsers(){
        userRepository.deleteAll();
    }

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public boolean isUserExist(User user) {
        return findByName(user.getName()) != null;
    }
}
