package com.emmett.testday.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.emmett.testday.model.question.Question;
import com.emmett.testday.model.question.QuestionPool;


/**
 * Created by emmett on 25/12/15.
 */
public class GradingState implements GameState {

    Stage stage;
    QuestionPool pool;
    public ExamState nextPage = null;
    public ExamState previousPage = null;
    public GameStateManager manager;
    public GameState nextState = null;
    public Label.LabelStyle style;

    public GradingState(QuestionPool pool, Stage stage) {
        this.stage = stage;
        this.pool = pool;
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
        table.row();

        int correct = getMark();
        int total = pool.getQuestions().size();

        int percent = (int) ((float) correct / ((float) total) * 100);

        String correctString = String.valueOf(correct);
        String totalString = String.valueOf(total);
        String percentString = String.valueOf(percent);

        table.add(new Label("You got " + correctString + " out of " + totalString, style)).width(500);
        table.row();
        table.add(new Label("You got " + percentString + " percent", style)).width(500);
        table.row();
        if(percent < 50) {
            table.add(new Label("Congrats you failed. Merry Christmas.", style)).width(500);
        }
        else {
            table.add(new Label("YOU PASSED. Merry Christmas", style)).width(500);
        }

        stage.addActor(table);

    }

    private int getMark() {
        int correct = 0;
        for(Question question : pool.getQuestions()) {
            if(question.getCorrectAnswer().equals(question.getAnswer())) {
                correct++;
            }
        }
        return correct;

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
        stage.dispose();
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
