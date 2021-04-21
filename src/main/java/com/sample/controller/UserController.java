package com.sample.controller;

import com.sample.domain.User;
import com.sample.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    private final Logger log = LoggerFactory.getLogger(UserController.class);

    @Inject
    UserService userService;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/users", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public User createUser(@RequestBody User user){
        log.debug("into create user :: {}",user);
        System.out.println(user);
        try{
            user = userService.saveUser(user);
            log.debug("user  saved {}", user);
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/getUsers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getUsers(){
        System.out.println("into getUsers");
        List<User> list = new ArrayList<>();
        try{
            list = userService.findAllUsers();
            System.out.println("list :: "+list.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @RequestMapping(value = "/editUser/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUser(@PathVariable("id") Long id){
        System.out.println("into getUser :: "+id);
        User user = new User();
        try{
            user = userService.findById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteUser(@PathVariable("id") Long id){
        System.out.println("into getUser :: "+id);
        User user = new User();
        try{
            userService.deleteUserById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/testData/{action}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public User someMethod(@PathVariable("action") String action, @RequestBody User user){
        System.out.println("into someMethod");
        System.out.println("action" +action);
        System.out.println(user.toString());
        user.setName("Rohini");

        return user;
    }

}
