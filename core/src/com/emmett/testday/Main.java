package com.emmett.testday;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
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
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import sun.font.GlyphLayout;

import java.awt.event.MouseListener;

public class Main extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
    BitmapFont font;
    Label label;
    Stage stage;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
        font = new BitmapFont();
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = font;
        labelStyle.fontColor = Color.BLACK;
        label = new Label("what up bitch!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!", labelStyle);
        //stage = new Stage(new FillViewport(640, 360));
        //stage.getViewport().apply();
        stage = new Stage();
        font.getWrappedBounds(label.getText(), label.getWidth());
        label.setWrap(true);
        label.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                label.setText("clicked yo");
            }
        });
        label.addListener(new InputListener() {
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromAcotr) {
                label.setText("whoooa what u want");
            }
        });
        Table table = new Table();
        table.setX(100);
        table.setY(100);
        table.add(label).prefWidth(1);
        label.setWidth(100);
        label.setX(100);
        label.setY(100);
        stage.addActor(label);
        Gdx.input.setInputProcessor(stage);
        font.setColor(Color.BLACK);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(255, 255, 255, 255);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
        label.draw(batch, 10);
        stage.act();
		batch.end();
	}
}
