package com.emmett.testday.model.util;

import com.emmett.testday.model.databases.Database;
import com.emmett.testday.model.databases.MainDataBase;

import javax.xml.crypto.Data;
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
        databaseMap.put("#n", MainDataBase.nouns);
        databaseMap.put("#v", MainDataBase.verbs);
        databaseMap.put("#N", MainDataBase.names);
        databaseMap.put("#a", MainDataBase.adjectives);
        databaseMap.put("#Q", MainDataBase.quotes);
        databaseMap.put("#i", MainDataBase.numbers);
        databaseMap.put("#c", MainDataBase.locations);
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

    public static String[] parseQuestionAndTextBook(String question, String textBook) {
        String[] items = new String[2];
        for(String token : databaseMap.keySet()) {
            StringBuffer buffer = new StringBuffer();
            Matcher matcher = Pattern.compile(token).matcher(question);
            while(matcher.find()) {
                String replacement = databaseMap.get(token).get();
                matcher.appendReplacement(buffer, replacement);
                textBook = textBook.replaceFirst(token, replacement);
            }
            matcher.appendTail(buffer);
            question = buffer.toString();
        }
        items[0] = question;
        items[1] = textBook;
        return items;
    }

}
