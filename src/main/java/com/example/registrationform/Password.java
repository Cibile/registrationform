package com.example.registrationform;

public class Password {
    private final String password;
    private final int MIN_PASSWORD_LENGTH = 7;

    public Password(String password){
        if(password.length() >= MIN_PASSWORD_LENGTH){
            this.password = password;
        }else {
            this.password = "Invalid password";
        }
    }

    public String getPassword(){
        return password;
    }
}
