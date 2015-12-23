package com.emmett.testday.model.databases;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by eunderhi on 23/12/15.
 */
public class TestDataBase implements Database {

    private List<String> items = new ArrayList<String>();
    Random randomizer = new Random();

    public TestDataBase(String filePath) {
        load(filePath);
    }

    @Override
    public void load(String filePath) {
        FileHandle handle = Gdx.files.internal(filePath);
        File file = handle.file();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while((line = br.readLine()) != null) {
                items.add(line);
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String get() {
        int randomIndex = randomizer.nextInt(items.size());
        return items.get(randomIndex);
    }

    public String get(int seed) {
        randomizer.setSeed(seed);
        int randomIndex = randomizer.nextInt(items.size());
        return items.get(randomIndex);
    }

}
