package com.example.registrationform;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Email")
class EmailTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void checkConstructorValid() {
        String testEmail = "hi@google.com";
        Email email = new Email(testEmail);
        assertEquals(testEmail, email.getEmail());
    }

    @Test
    void checkIfEmailContainsAtSymbol(){
        String testEmail = "higoogle.com";
        Email email = new Email(testEmail);
        assertNotEquals(testEmail, email.getEmail());
        assertEquals("Invalid email", email.getEmail());
    }

    @Test
    void checkIfEmailContainsExactlyOneAtSymbol(){
        String testEmail = "hi@@google.com";
        Email email = new Email(testEmail);
        assertNotEquals(testEmail, email.getEmail());
        assertEquals("Invalid email", email.getEmail());
    }

    @ParameterizedTest
    @ValueSource(strings = { "hi#@gmail.com", "jo£hn$$koln@gmail.com", "l*c6^l@mail.com","abc#def@mail.com", "abc)(.def@mail.com" })
    @DisplayName("Test emails with invalid symbols")
    void checkIfEmailContainsInvalidCharacters(String argument) {
        Email email = new Email(argument);
        assertNotEquals(argument, email.getEmail());
        assertEquals("Invalid email", email.getEmail());
    }

    @ParameterizedTest
    @ValueSource( strings = {"abcdef-@gmail.com", "abc..def@gmail.com", ".abcdef@gmail.com", "abc#def@gmail.com"})
    @DisplayName("Test emails with invalid prefixes.")
    void checkIfEmailInvalidPrefix(String argument){
        Email email = new Email(argument);
        assertNotEquals(argument, email.getEmail());
        assertEquals("Invalid email", email.getEmail());
    }

    @ParameterizedTest
    @ValueSource( strings = {"abc.def@gmail.c", "abc.def@gmail#mail.com", "abc.def@gmail", "abc.def@gmail..com"})
    @DisplayName("Test emails with invalid domain.")
    void checkIfEmailInvalidDomain(String argument) {
        Email email = new Email(argument);
        assertNotEquals(argument, email.getEmail());
        assertEquals("Invalid email", email.getEmail());
    }

    @ParameterizedTest
    @ValueSource( strings = {"abc-def@gmail.com", "abc.def@gmail.com", "abcdef@gmail.com", "abc_def@gmail.com"})
    @DisplayName("Test emails with valid prefixes.")
    void checkIfEmailValidPrefix(String argument){
        Email email = new Email(argument);
        assertEquals(argument, email.getEmail());
    }

    @ParameterizedTest
    @ValueSource( strings = {"abc.def@gmail.co", "abc.def@mail-gmail.com", "abc.def@gmail.co.uk", "abc.def@gmail.org"})
    @DisplayName("Test emails with valid domains.")
    void checkIfEmailValidDomain(String argument){
        Email email = new Email(argument);
        assertEquals(argument, email.getEmail());
    }
}