package com.emmett.testday.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
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

    public ExamState(QuestionPool pool) {
        this.pool = pool;
        numToLetter.put(0, "a");
        numToLetter.put(1, "b");
        numToLetter.put(2, "c");
        numToLetter.put(3, "d");
    }

    @Override
    public void create() {
        Label.LabelStyle style = new Label.LabelStyle();
        style.font = new BitmapFont();
        style.fontColor = Color.BLACK;
        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(true);

        for(int i = 0; i < 4; i++) {
            Question question = pool.getQuestions().get(i);
            String questionString = question.getQuestion();
            table.add(new Label(String.valueOf(i + 1) + ". "+questionString, style)).width(500).left();
            table.row();
            List<String> answers = question.getAnswers();
            for(int j = 0; j < answers.size(); j++) {
                table.add(new Label("  " + numToLetter.get(j) + ". " + answers.get(j), style)).width(500).left();
                table.row();
            }
            table.add(new Label(" ", style)).left();
            table.row();
        }

        stage = new Stage(new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
        Gdx.input.setInputProcessor(stage);
        stage.getViewport().apply();
        stage.addActor(table);

        stage.addListener(new InputListener() {
            @Override
            public boolean keyDown(InputEvent event, int keycode) {
                if(keycode == Input.Keys.ENTER) {
                    System.out.println("OH DUDE YOU PRESSED ENTER.");
                    return true;
                }
                return false;
            }
        });
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
    public void next() {

    }

}
