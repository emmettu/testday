package com.emmett.testday.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;

/**
 * Created by eunderhi on 23/12/15.
 */
public class TestState implements GameState {

    SpriteBatch batch;
    Texture img;
    BitmapFont font;
    Label label;
    Stage stage;

    @Override
    public void create () {
        batch = new SpriteBatch();
        font = new BitmapFont();
        Table table = new Table();
        table.setFillParent(true);
        //table.setPosition(100, 100);
        table.setDebug(true);
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = font;
        labelStyle.fontColor = Color.BLACK;
        label = new Label("teeeeest!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!", labelStyle);
        table.add(label).width(100);
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
//        TextField.TextFieldStyle style = new TextField.TextFieldStyle();
//        style.font = font;
//        table.add(new TextField("Hi", style));
//        label.setWidth(100);
//        label.setX(100);
//        label.setY(100);
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
        batch.dispose();
    }

    @Override
    public void resize(int x, int y) {
        stage.getViewport().update(x, y, true);
    }

}