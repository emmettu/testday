package com.emmett.testday.model.question;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by emmett on 25/12/15.
 */
public class QuestionPool {

    List<Question> questions = new ArrayList<Question>();
    public static final int QUESTION_NUM = 12;

    public QuestionPool() {
        FileHandle handle = Gdx.files.internal("databases/questions.txt");
        String[] questionRaws = handle.readString().split("\n");
        for(int i = 0; i < questionRaws.length - 2; i += 3) {
            Question question = new Question(questionRaws[i], questionRaws[i + 1], questionRaws[i + 2]);
            questions.add(question);
        }
    }

    public void shuffle() {
        Random random = new Random();
        List<Question> shuffledQuestions = new ArrayList<Question>();

        for(int i = 0; i < QUESTION_NUM; i++) {
            int randomIndex = random.nextInt(questions.size());
            shuffledQuestions.add(questions.get(randomIndex));
            questions.remove(randomIndex);
        }
        questions = shuffledQuestions;
    }

    public List<Question> getQuestions() {
        return questions;
    }
}
