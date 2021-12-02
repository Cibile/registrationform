package com.example.registrationform;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
        String testPassword = "password123*";
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
        String testPassword = "1234567a!";
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
        String testPassword = "abcdefghiJK11&";
        Password password = new Password(testPassword);
        assertEquals(testPassword, password.getPassword());
    }

    @Test
    void checkPasswordContainsSpecialCharacter(){
        String testPassword = "abcdABCD123";
        Password password = new Password(testPassword);
        assertEquals("Invalid password", password.getPassword());
    }

    @Test
    void passwordContainsSpecialCharacter() {
        String testPassword = "abcdefghiJK1@";
        Password password = new Password(testPassword);
        assertEquals(testPassword, password.getPassword());
    }

    @ParameterizedTest
    @ValueSource(strings = {"valid.pass123", "Val1DP@$$", "P@$$^w0rd","Valid123^&@", "!pf$.v^@1r6!" })
    @DisplayName("Tests of valid passwords to make sure they pass")
    void checkValidPasswords(String argument){
        Password password = new Password(argument);
        assertEquals(argument, password.getPassword());
    }

    @ParameterizedTest
    @ValueSource(strings = {"sh0rt^", "nospecialchars123", "nonumbers@*", "123@@$^456", "a@1"})
    @DisplayName("Tests of invalid passwords to make sure they fail")
    void checkInvalidPasswords(String argument){
        Password password = new Password(argument);
        assertNotEquals(argument, password.getPassword());
        assertEquals("Invalid password", password.getPassword());
    }
}