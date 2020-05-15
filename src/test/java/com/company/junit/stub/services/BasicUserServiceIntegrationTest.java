package com.company.junit.stub.services;

import com.company.junit.stub.exceptions.DataNotFoundException;
import com.company.junit.stub.repositories.UserRepository;
import com.company.junit.stub.repositories.entities.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import static com.company.junit.stub.services.UserRepositoryStub.ID;
import static com.company.junit.stub.services.UserRepositoryStub.FIRST_NAME;
import static com.company.junit.stub.services.UserRepositoryStub.LAST_NAME;
import static com.company.junit.stub.services.UserRepositoryStub.ID_FOR_EXCEPTION;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class BasicUserServiceIntegrationTest {

    private final static String USER_NOT_FOUND = "User is not found";

    @Autowired
    private UserRepository userRepository;

    @Test
    public void getUserTesting(){
        BasicUserService basicUserService = new BasicUserService(userRepository);
        assertEquals(new User(ID, FIRST_NAME, LAST_NAME), basicUserService.getUser(ID));
        DataNotFoundException exception = assertThrows(DataNotFoundException.class, () -> basicUserService.getUser(ID_FOR_EXCEPTION));
        assertEquals(USER_NOT_FOUND, exception.getMessage());
    }

}