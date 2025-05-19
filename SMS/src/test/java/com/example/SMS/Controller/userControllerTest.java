package com.example.SMS.Controller;

import com.example.SMS.Model.userModel;
import com.example.SMS.Service.userService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class userControllerTest {

    @InjectMocks
    private userController userController;

    @Mock
    private userService userService;

    private userModel user;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        user = new userModel();
        user.setId(1L);
        user.setUserName("test");
        user.setPassword("test123");
        user.setRole(null); // Set only if needed
    }

    @Test
    void createUserTest() {
        when(userService.createUser(user)).thenReturn(user);

        userModel result = userController.createUser(user); // No cast needed

        assertEquals("test", result.getUserName());
        verify(userService, times(1)).createUser(user);
    }

    @Test
    void userData() {
    }

    @Test
    void userDataById() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUserById() {
    }
}