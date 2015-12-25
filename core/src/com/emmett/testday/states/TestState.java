package com.emmett.testday.states;

import com.badlogic.gdx.Game;
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
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.emmett.testday.model.databases.MainDataBase;
import com.emmett.testday.model.question.QuestionPool;
import com.emmett.testday.model.util.Parser;

/**
 * Created by eunderhi on 23/12/15.
 * GameState for displaying a test.
 */
public class TestState implements GameState {

    BitmapFont font = new BitmapFont();
    Label label;
    Stage stage;

    @Override
    public void create () {
        font = new BitmapFont();
        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(true);
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = font;
        labelStyle.fontColor = Color.BLACK;
        Label name = new Label("Please write your name: " + MainDataBase.getName(), labelStyle);
        table.add(name).top().right();
        table.row();
        table.top();
        //label = new Label(MainDataBase.getNoun() + " " + MainDataBase.getNoun(), labelStyle);
        label = new Label(Parser.parseAll("#N really likes to #v a #a #n"), labelStyle);
        table.add(label).width(500);
        stage = new Stage(new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
        Gdx.input.setInputProcessor(stage);
        stage.getViewport().apply();
        stage.addActor(table);
        //font.getWrappedBounds(label.getText(), label.getWidth());
        label.setWrap(true);
        label.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                label.setText(MainDataBase.getNoun() + " " + MainDataBase.getNoun());
                label.getStyle().fontColor = Color.RED;
            }
        });
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
        QuestionPool pool = new QuestionPool();
        int num = 3;
        System.out.println(pool.getQuestions().get(num).getQuestion());
        System.out.println("a. " + pool.getQuestions().get(num).getAnswers().get(0));
        System.out.println("b. " + pool.getQuestions().get(num).getAnswers().get(1));
        System.out.println("c. " + pool.getQuestions().get(num).getAnswers().get(2));
        System.out.println("d. " + pool.getQuestions().get(num).getAnswers().get(3));
        System.out.println(pool.getQuestions().get(num).getTextBookSnippet());
        System.out.println(pool.getQuestions().get(num).getCorrectAnswer());
    }

    @Override
    public void display () {
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
        return null;
    }

}
