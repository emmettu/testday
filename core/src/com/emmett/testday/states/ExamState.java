package com.emmett.testday.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.emmett.testday.model.databases.MainDataBase;
import com.emmett.testday.model.question.Question;
import com.emmett.testday.model.question.QuestionPool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by emmett on 25/12/15.
 */
public class ExamState implements GameState {

    Stage stage;
    QuestionPool pool;
    Map<Integer, String> numToLetter = new HashMap<Integer, String>();
    public ExamState nextPage = null;
    public ExamState previousPage = null;
    public GameStateManager manager;
    public GameState nextState = null;
    public Label.LabelStyle style;
    public int order = 0;

    public ExamState(QuestionPool pool, Stage stage) {
        this.stage = stage;
        this.pool = pool;
        numToLetter.put(0, "a");
        numToLetter.put(1, "b");
        numToLetter.put(2, "c");
        numToLetter.put(3, "d");
        style = new Label.LabelStyle();
        style.font = new BitmapFont();
        style.fontColor = Color.BLACK;
    }

    @Override
    public void create() {
        for(Actor actor : stage.getActors()) {
            actor.remove();
        }
        Table table = new Table();
        table.setFillParent(true);
        if(order == 0) {
            table.add(new Label("Name: " + MainDataBase.getName(), style)).top().right();
            table.row();
        }


        for(int i = order * 4; i < order * 4 + 4; i++) {
            Question question = pool.getQuestions().get(i);
            String questionString = question.getQuestion();
            table.add(new Label(String.valueOf(i + 1) + ". "+questionString, style)).width(500).left();
            table.row();
            List<String> answers = question.getAnswers();
            final Label answerLabel = new Label("answer: " , style);
            for(int j = 0; j < answers.size(); j++) {
                addAnswer(answers.get(j), table, j, question, answerLabel);
            }
            table.add(answerLabel);
            table.add(new Label(" ", style)).left();
            table.row();
        }

        stage.addListener(new InputListener() {
            @Override
            public boolean keyDown(InputEvent event, int keycode) {
                if(keycode == Input.Keys.ENTER) {
                    if(nextState != null) {
                        manager.setCurrentState(nextState);
                    }
                    return true;
                }
                return false;
            }
        });
        stage.addActor(table);
    }

    private void addAnswer(String answer, Table table, int j, Question question, final Label answerLabel) {
        final Label label = new Label("  " + numToLetter.get(j) + ". " + answer, style);

        label.setUserObject(question);

        label.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                Question theQuestion = (Question) label.getUserObject();
                theQuestion.setAnswer(label.getText().substring(5));
                //System.out.println(theQuestion.getAnswer().equals(theQuestion.getCorrectAnswer()));
                answerLabel.setText("answer: " + theQuestion.getAnswer());
            }
        });

        table.add(label).width(500).left();
        table.row();
    }

    private String getAnswer(Question question) {
        if(question.getAnswer() == null) {
            return "";
        }
        return question.getAnswer();
    }

    @Override
    public void display() {
        Gdx.gl.glClearColor(255, 255, 255, 50);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }

    @Override
    public void update() {

    }


    @Override
    public void dispose() {

    }

    @Override
    public void resize(int x, int y) {
        stage.getViewport().update(x, y, true);
    }

    @Override
    public GameState next() {
        return nextState;
    }

    public void nextPage() {
        if(nextPage != null) {
            manager.setCurrentState(nextPage);
        }
    }

    public void previousPage() {
        if(previousPage != null) {
            manager.setCurrentState(previousPage);
        }
    }

}
