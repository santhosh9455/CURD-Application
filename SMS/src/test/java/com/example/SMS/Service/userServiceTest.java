package com.example.SMS.Service;

import com.example.SMS.Model.userModel;
import com.example.SMS.Repository.userRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class userServiceTest {

    @InjectMocks
    private userService userService;

    @Mock
    private userRepo userRepoObj;

    @Mock
    private PasswordEncoder passwordEncoder;

    private userModel testUser;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        testUser = new userModel();
        testUser.setId(1L);
        testUser.setUserName("john");
        testUser.setPassword("password123");
    }

    @Test
    void testCreateUser() {
        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");

        userService.createUser(testUser);

        assertEquals("encodedPassword", testUser.getPassword());
        verify(userRepoObj, times(1)).save(testUser);
    }

    @Test
    void testFindAllUsers() {
        when(userRepoObj.findAll()).thenReturn(Arrays.asList(testUser));

        List<userModel> result = userService.findAlluser();

        assertEquals(1, result.size());
        assertEquals("john", result.get(0).getUserName());
    }

    @Test
    void testFindUserById() {
        when(userRepoObj.findById(1L)).thenReturn(Optional.of(testUser));

        Optional<userModel> result = userService.findUserById(1L);

        assertTrue(result.isPresent());
        assertEquals("john", result.get().getUserName());
    }

    @Test
    void testFindDataById() {
        when(userRepoObj.findAllById(1L)).thenReturn(Arrays.asList(testUser));

        List<userModel> result = userService.findDatabyId(1L);

        assertEquals(1, result.size());
        assertEquals(1L, result.get(0).getId());
    }

    @Test
    void testUpdateUser() {
        userService.updateUser(testUser);

        verify(userRepoObj, times(1)).save(testUser);
    }

    @Test
    void testDeleteUser() {
        userService.deleteUser(1L);

        verify(userRepoObj, times(1)).deleteById(1L);
    }
}
