package com.emmett.testday.model.databases;

import java.util.Random;

/**
 * Created by emmett on 25/12/15.
 */
public class NumberDatabase implements Database {

    @Override
    public void load(String filePath) {}

    @Override
    public String get() {
        return String.valueOf(new Random().nextInt(2000));
    }
}
