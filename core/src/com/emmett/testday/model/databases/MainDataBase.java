package com.emmett.testday.model.databases;

/**
 * Created by eunderhi on 23/12/15.
 */
public class MainDataBase {

    public static TestDataBase quotes;
    public static TestDataBase nouns;
    public static TestDataBase verbs;
    public static TestDataBase names;
    public static TestDataBase adjectives;
    public static NumberDatabase numbers;
    public static TestDataBase locations;

    static {
        quotes = new TestDataBase("databases/quotes.txt");
        nouns = new TestDataBase("databases/nouns.txt");
        verbs = new TestDataBase("databases/verbs.txt");
        names = new TestDataBase("databases/names.txt");
        adjectives = new TestDataBase("databases/adjectives.txt");
        numbers = new NumberDatabase();
        locations = new TestDataBase("databases/locations.txt");
     }

    public static String getName() {
        return names.get();
    }

    public static String getNoun() {
        return nouns.get();
    }

}
