package com.example.registrationform;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {
    private final String password;

    public Password(String password){
        final int MIN_PASSWORD_LENGTH = 7;
        if(password.length() >= MIN_PASSWORD_LENGTH && checkAtLeastOneLetter(password) && checkAtLeastOneDigit(password)
        && checkAtLeastOneSpecialChar(password)){
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

    public boolean checkAtLeastOneDigit(String password){
        String regex = ".*[0-9].*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public boolean checkAtLeastOneSpecialChar(String password){
        String regex = ".*[*^&@!.].*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
