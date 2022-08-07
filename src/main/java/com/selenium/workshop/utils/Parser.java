package com.selenium.workshop.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    public static int parseInteger(String inputWithNumbers) {

        String regex = "^\\d*";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputWithNumbers);

        if (matcher.find()) {
            return Integer.parseInt(matcher.group(0));
        }
        return 0;
    }
}
