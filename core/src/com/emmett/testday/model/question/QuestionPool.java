package com.emmett.testday.model.question;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by emmett on 25/12/15.
 */
public class QuestionPool {

    List<Question> questions = new ArrayList<Question>();

    public QuestionPool() {
        FileHandle handle = Gdx.files.internal("databases/questions.txt");
        String[] questionRaws = handle.readString().split("\n");
        for(int i = 0; i < questionRaws.length - 2; i += 3) {
            Question question = new Question(questionRaws[i], questionRaws[i + 1], questionRaws[i + 2]);
            questions.add(question);
        }
    }

    public List<Question> getQuestions() {
        return questions;
    }
}
