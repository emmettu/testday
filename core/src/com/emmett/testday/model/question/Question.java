package com.emmett.testday.model.question;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by eunderhi on 23/12/15.
 */
public class Question {

    private List<String> answers = new ArrayList<String>(4);
    private String correctAnswer;
    private String textBookSnippet;
    private String question;
    private int seed;

    public Question(String[] questionData) {
        seed = new Random().nextInt();
    }

    private void parse(String string) {

    }

}
