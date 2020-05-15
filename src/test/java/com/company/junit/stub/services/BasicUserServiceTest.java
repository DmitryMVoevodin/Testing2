package com.company.junit.stub.services;

import com.company.junit.stub.exceptions.DataNotFoundException;
import com.company.junit.stub.repositories.UserRepository;
import com.company.junit.stub.repositories.entities.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import static com.company.junit.stub.services.UserRepositoryStub.ID;
import static com.company.junit.stub.services.UserRepositoryStub.FIRST_NAME;
import static com.company.junit.stub.services.UserRepositoryStub.LAST_NAME;
import static com.company.junit.stub.services.UserRepositoryStub.ID_FOR_EXCEPTION;

//@SpringBootTest
//@RunWith(SpringJUnit4ClassRunner.class)
@RunWith(MockitoJUnitRunner.class)
public class BasicUserServiceTest {

    private final static String USER_NOT_FOUND = "User is not found";

    //@Autowired
    @Mock
    private UserRepository userRepository;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getUserStubTesting(){
        BasicUserService basicUserService = new BasicUserService(new UserRepositoryStub());
        assertEquals(new User(ID, FIRST_NAME, LAST_NAME), basicUserService.getUser(ID));
        DataNotFoundException exception = assertThrows(DataNotFoundException.class, () -> basicUserService.getUser(ID_FOR_EXCEPTION));
        assertEquals(USER_NOT_FOUND, exception.getMessage());
    }

    @Test
    public void getUserMockTesting(){
        Mockito.when(userRepository.findById(ID)).thenReturn(Optional.of(new User(ID, FIRST_NAME, LAST_NAME)));
        Mockito.when(userRepository.findById(ID_FOR_EXCEPTION)).thenThrow(new DataNotFoundException(USER_NOT_FOUND));
        BasicUserService basicUserService = new BasicUserService(userRepository);
        assertEquals(new User(ID, FIRST_NAME, LAST_NAME), basicUserService.getUser(ID));
        Mockito.verify(userRepository).findById(ID);
        DataNotFoundException exception = assertThrows(DataNotFoundException.class, () -> basicUserService.getUser(ID_FOR_EXCEPTION));
        assertEquals(USER_NOT_FOUND, exception.getMessage());
        Mockito.verify(userRepository).findById(ID_FOR_EXCEPTION);
    }
}