package com.emmett.testday;

import com.badlogic.gdx.ApplicationAdapter;
import com.emmett.testday.model.question.QuestionPool;
import com.emmett.testday.states.ExamState;
import com.emmett.testday.states.GameStateManager;

public class Main extends ApplicationAdapter {

	GameStateManager manager;

	@Override
	public void create () {
		manager = new GameStateManager(new ExamState(new QuestionPool()));
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
