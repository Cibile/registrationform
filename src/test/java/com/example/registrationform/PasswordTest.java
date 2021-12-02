package com.example.registrationform;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("Password length less than 7")
    void checkPasswordWithoutMinLength() {
        String testPassword = "pass";
        Password password = new Password(testPassword);
        assertEquals("Invalid password", password.getPassword());
    }

    @Test
    void checkPasswordWithMinLength(){
        String testPassword = "password123";
        Password password = new Password(testPassword);
        assertEquals(testPassword, password.getPassword());
    }

    @Test
    void checkPasswordContainsLetter(){
        String testPassword = "12345678";
        Password password = new Password(testPassword);
        assertEquals("Invalid password", password.getPassword());
    }

    @Test
    void passwordContainsLetter(){
        String testPassword = "1234567a";
        Password password = new Password(testPassword);
        assertEquals(testPassword, password.getPassword());
    }

    @Test
    void checkPasswordContainsDigit(){
        String testPassword = "abcdefghiJK";
        Password password = new Password(testPassword);
        assertEquals("Invalid password", password.getPassword());
    }

    @Test
    void passwordContainsDigit(){
        String testPassword = "abcdefghiJK1";
        Password password = new Password(testPassword);
        assertEquals(testPassword, password.getPassword());
    }
}