package com.example.registrationform;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
    private final String email;

    public Email(final String email){
        if (checkExactlyOneAtSymbol(email)){
            this.email = email;
        }else{
            this.email = "Invalid email";
        }
    }

    public String getEmail() {
        return email;
    }

    public boolean checkExactlyOneAtSymbol(String email){
        String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
