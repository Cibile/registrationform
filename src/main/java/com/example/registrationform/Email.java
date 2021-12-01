package com.example.registrationform;

public class Email {
    private final String email;

    public Email(final String email){
        if (email.contains("@")){
            this.email = email;
        }else{
            this.email = "Invalid email";
        }
    }

    public String getEmail() {
        return email;
    }
}
