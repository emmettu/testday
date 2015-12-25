package com.emmett.testday.states;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.viewport.FitViewport;

/**
 * Created by eunderhi on 23/12/15.
 */
public class TableTestState implements GameState {

    SpriteBatch batch;
    Texture img;
    BitmapFont font;
    Label label;
    Stage stage;

    @Override
    public void create() {

        font = new BitmapFont();

        Table table = new Table();
        table.setFillParent(true);
        table.row().height(100).width(100);
        table.row().height(100).width(100);
        table.row().height(100).width(100);
        table.row().height(100).width(100);
        table.row().height(100).width(100);

        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = font;
        labelStyle.fontColor = Color.WHITE;
        label = new Label("teeeeest!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!", labelStyle);

        stage = new Stage(new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
        Gdx.input.setInputProcessor(stage);
        stage.getViewport().apply();
        stage.addActor(table);

//        TextField.TextFieldStyle style = new TextField.TextFieldStyle();
//        style.font = font;
//        table.add(new TextField("Hi", style));
    }

    @Override
    public void display() {
        Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
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

    }

    @Override
    public GameState next() {
        return null;
    }
}
