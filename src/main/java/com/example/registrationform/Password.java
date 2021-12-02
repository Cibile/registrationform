package com.example.registrationform;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {
    private final String password;
    private final int MIN_PASSWORD_LENGTH = 7;

    public Password(String password){
        if(password.length() >= MIN_PASSWORD_LENGTH && checkAtLeastOneLetter(password)){
            this.password = password;
        }else {
            this.password = "Invalid password";
        }
    }

    public String getPassword(){
        return password;
    }

    public boolean checkAtLeastOneLetter(String password){
        String regex = ".*[a-zA-Z].*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
