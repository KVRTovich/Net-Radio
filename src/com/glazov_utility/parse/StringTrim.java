package com.glazov_utility.parse;

public class StringTrim {
    public static String StringTrim(String string) {
        string = string.trim();
        String[] wordList = string.split("\\s+");
        return wordList[wordList.length-2];
    }
}
