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
public class TitleScreen implements GameState {
    Stage stage;
    public ExamState nextPage = null;
    public ExamState previousPage = null;
    public GameStateManager manager;
    public GameState nextState = null;
    public Label.LabelStyle style;

    String TITLE_PHRASE = "Hi welcome to this year's Secret Santa Game." +
            "You play someone taking a quiz in an alternate Universe where things are" +
            " completely different from the reality that you have come to know. So obviously" +
            " you're wondering how you can possibly pass this quiz? No worries! There's a short one" +
            " page study guide to help you through it that's shown to you before the quiz. Simply hit enter" +
            " to go to the study guide, then hit enter to go to the quiz etc. etc. It's multiple choice so you" +
            " just click on the potential answers that you think are right. There's two pages so hit enter to" +
            " go to the second page once you're done with the first one. Then hit enter to submit it and see your" +
            " marks! Good luck.";

    public TitleScreen(Stage stage) {
        this.stage = stage;
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

        Label label = new Label(TITLE_PHRASE, style);
        label.setWrap(true);
        table.add(label).width(500);
        table.setFillParent(true);
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
