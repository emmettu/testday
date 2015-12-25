package com.emmett.testday.states;

import com.badlogic.gdx.Game;
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
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.emmett.testday.model.question.Question;
import com.emmett.testday.model.question.QuestionPool;

/**
 * Created by emmett on 25/12/15.
 */
public class TextBookState implements GameState {

    Stage stage;
    QuestionPool pool;
    public ExamState nextPage = null;
    public ExamState previousPage = null;
    public GameStateManager manager;
    public GameState nextState = null;
    public Label.LabelStyle style;

    public TextBookState(QuestionPool pool, Stage stage) {
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

        for(int i = 0; i < 4; i++) {
            Question question = pool.getQuestions().get(i);
            Label label = new Label(question.getTextBookSnippet(), style);
            label.setWrap(true);
            table.add(label).width(500);
            table.row();
        }

        stage.addActor(table);

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
