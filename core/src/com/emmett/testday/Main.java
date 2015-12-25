package com.emmett.testday;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.emmett.testday.model.question.QuestionPool;
import com.emmett.testday.states.ExamState;
import com.emmett.testday.states.GameStateManager;

public class Main extends ApplicationAdapter {

	GameStateManager manager;

	@Override
	public void create () {
        Stage stage = new Stage(new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
        Gdx.input.setInputProcessor(stage);
        stage.getViewport().apply();

		manager = new GameStateManager(new ExamState(new QuestionPool(), stage));
		//manager = new GameStateManager(new TableTestState());

	}

	@Override
	public void render () {
		manager.display();
	}

	@Override
	public void resize(int x, int y) {
		manager.resize(x, y);
	}

}
