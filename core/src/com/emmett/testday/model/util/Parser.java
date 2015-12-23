package com.emmett.testday.model.util;

import com.emmett.testday.model.databases.Database;
import com.emmett.testday.model.databases.MainDataBase;

import java.util.HashMap;
import java.util.Map;

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

    public static String parse(String input) {
        
        return null;
    }
}
