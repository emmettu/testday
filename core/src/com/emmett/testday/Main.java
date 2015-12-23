package com.emmett.testday;

import com.badlogic.gdx.ApplicationAdapter;
import com.emmett.testday.states.GameStateManager;
import com.emmett.testday.states.TableTestState;
import com.emmett.testday.states.TestState;

public class Main extends ApplicationAdapter {

	GameStateManager manager;

	@Override
	public void create () {
		manager = new GameStateManager(new TestState());
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
