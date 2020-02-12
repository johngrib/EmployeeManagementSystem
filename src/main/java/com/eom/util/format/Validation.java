package com.eom.util.format;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    // Employee 클래스: Setter/Getter
    // Validation 클래스: 입력 유효성 검사(Employee 객체 생성 전)
    private static final String PHONE_NUMBER_PATTERN = "^[0-9]{2,3}-[0,9]{3,4}-[0,9]{4}$";
    private static final String EMAIL_PATTERN = "(^[0-9a-zA-Z_-]+@[0-9a-zA-Z]+[.][a-zA-Z]{2,4}$)";

    public static boolean checkPhoneNumFormat(String phoneNum) {
        Pattern pattern = Pattern.compile(PHONE_NUMBER_PATTERN);
        Matcher matcher = pattern.matcher(phoneNum);

        return matcher.find();
    }

    public static boolean checkEmailFormat(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);

        return matcher.find();
    }
}
