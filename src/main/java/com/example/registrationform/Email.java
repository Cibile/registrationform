package com.example.registrationform;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
    private final String email;

    public Email(final String email){
        if (checkExactlyOneAtSymbol(email) && checkEmailPrefix(email) && checkEmailDomain(email)){
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

    public boolean checkEmailPrefix(String email){
        String prefix = email.substring(0,email.lastIndexOf("@"));
        String regexStartsWith = "^[+._-]";
        String regexEndsWith = "[+._-]$";
        String regexMultipleChars = "[+._-]{2,}";
        return !Pattern.compile(regexStartsWith).matcher(prefix).find() &&
                !Pattern.compile(regexEndsWith).matcher(prefix).find() &&
                !Pattern.compile(regexMultipleChars).matcher(prefix).find();
    }

    public boolean checkEmailDomain(String email){
        int length = email.length();
        String domain = email.substring(email.lastIndexOf("@")+1, length);
        String regexEndsWith = "[a-zA-Z]{2,}$";
        String regexHasDot = ".*[.].*";
        String regexMultipleDots = "[.]{2,}";
        return Pattern.compile(regexEndsWith).matcher(domain).find() &&
                Pattern.compile(regexHasDot).matcher(domain).find() &&
                !Pattern.compile(regexMultipleDots).matcher(domain).find();
    }
}
