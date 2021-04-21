package com.sample.service;

import com.sample.domain.User;

import java.util.List;

public interface UserService {

    User findById(Long id);

    User findByName(String name);

    User saveUser(User user);

    void updateUser(User user);

    void deleteUserById(Long id);

    void deleteAllUsers();

    List<User> findAllUsers();

    boolean isUserExist(User user);
}


