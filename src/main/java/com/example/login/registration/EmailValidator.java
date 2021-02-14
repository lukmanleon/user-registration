package com.example.login.registration;

import org.springframework.stereotype.Service;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class EmailValidator implements Predicate<String> {
    @Override
    public boolean test(String email) {
        Pattern pattern = Pattern.compile(
                "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$",
                Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        boolean matchFound = matcher.find();

        if(matchFound) {
            return true;
        } else {
            return false;
        }
    }
}