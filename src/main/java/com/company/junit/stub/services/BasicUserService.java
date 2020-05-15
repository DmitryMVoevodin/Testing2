package com.company.junit.stub.services;

import com.company.junit.stub.exceptions.DataNotFoundException;
import com.company.junit.stub.repositories.UserRepository;
import com.company.junit.stub.repositories.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasicUserService implements UserService {

    private UserRepository userRepo;

    private final static String USER_NOT_FOUND = "User is not found";

    @Autowired
    public BasicUserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public User getUser(Long userId) {
        return userRepo.findById(userId).orElseThrow(() -> new DataNotFoundException(USER_NOT_FOUND));
    }

}
