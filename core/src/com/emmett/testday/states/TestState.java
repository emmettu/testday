package com.emmett.testday.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.emmett.testday.model.databases.TestDataBase;

/**
 * Created by eunderhi on 23/12/15.
 * GameState for displaying a test.
 */
public class TestState implements GameState {

    BitmapFont font;
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
        TestDataBase data = new TestDataBase("databases/verbs.txt");
        label = new Label(data.get(), labelStyle);
        table.add(label).width(500);
        stage = new Stage(new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
        Gdx.input.setInputProcessor(stage);
        stage.getViewport().apply();
        stage.addActor(table);
        font.getWrappedBounds(label.getText(), label.getWidth());
        label.setWrap(true);
        label.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                label.setText("clicked yo");
            }
        });
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

}
