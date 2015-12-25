package com.emmett.testday.model.question;

import com.emmett.testday.model.util.Parser;

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

    public Question(String...questionData) {
        question = questionData[0];
        textBookSnippet = questionData[2];
        answers = getAnswers(questionData[1]);
        parse();
    }

    private List<String> getAnswers(String inputToken) {
        List<String> answers = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            answers.add(Parser.parseAll(inputToken));
        }
        return answers;
    }

    private void parse() {
        String[] questionAndTextBook = Parser.parseQuestionAndTextBook(question, textBookSnippet);
        question = questionAndTextBook[0];
        textBookSnippet = questionAndTextBook[1];
        correctAnswer = pickCorrectAnswer();
        textBookSnippet = Parser.parseAll(textBookSnippet);
        textBookSnippet = textBookSnippet.replaceFirst("@answer", correctAnswer);
    }

    private String pickCorrectAnswer() {
        return answers.get(new Random().nextInt(4));
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public String getTextBookSnippet() {
        return textBookSnippet;
    }

}
