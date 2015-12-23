package com.emmett.testday.model.databases;

/**
 * Created by eunderhi on 23/12/15.
 */
public interface Database {
    void load(String filePath);
    String get();
}
