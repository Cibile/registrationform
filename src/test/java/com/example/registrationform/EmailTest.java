package com.example.registrationform;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    void checkIfEmailContainsSymbol(){
        String testEmail = "higoogle.com";
        Email email = new Email(testEmail);
        assertNotEquals(testEmail, email.getEmail());
        assertEquals("Invalid email", email.getEmail());
    }
}