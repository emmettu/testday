package com.emmett.testday.model.util;

import com.emmett.testday.model.databases.Database;
import com.emmett.testday.model.databases.MainDataBase;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by eunderhi on 23/12/15.
 */
public class Parser {

    static Map<String, Database> databaseMap;

    static {
        databaseMap = new HashMap<String, Database>();
        databaseMap.put("#q", MainDataBase.quotes);
        databaseMap.put("#n", MainDataBase.nouns);
        databaseMap.put("#v", MainDataBase.verbs);
        databaseMap.put("#N", MainDataBase.names);
    }

    public static String parseAll(String input) {
        for(String token : databaseMap.keySet()) {
            input = parseSingle(input, token);
        }
        return input;
    }

    public static String parseSingle(String input, String token) {
        StringBuffer buffer = new StringBuffer();
        Matcher matcher = Pattern.compile(token).matcher(input);
        while(matcher.find()) {
            matcher.appendReplacement(buffer, databaseMap.get(token).get());
        }
        matcher.appendTail(buffer);
        return buffer.toString();
    }

}
