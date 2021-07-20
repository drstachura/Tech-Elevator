package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.UserDAO;
import com.techelevator.tenmo.model.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")

public class UserApiController {
    private UserDAO userDAO;

    public UserApiController (UserDAO theUserMethods) {
        userDAO = theUserMethods;
    }

    @RequestMapping(path = "users", method = RequestMethod.GET)
    public List<User> getAllUsers(){
        List<User> allUsers;
        allUsers = userDAO.findAll();
        return allUsers;
    }



}//END
