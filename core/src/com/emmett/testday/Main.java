package com.emmett.testday;

import com.badlogic.gdx.ApplicationAdapter;
import com.emmett.testday.states.GameStateManager;
import com.emmett.testday.states.TestState;

public class Main extends ApplicationAdapter {

	GameStateManager manager;

	@Override
	public void create () {
		manager = new GameStateManager(new TestState());

	}

	@Override
	public void render () {
		manager.display();
	}
}
