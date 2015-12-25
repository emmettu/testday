package com.emmett.testday;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.emmett.testday.model.question.QuestionPool;
import com.emmett.testday.states.*;

public class Main extends ApplicationAdapter {

	GameStateManager manager = new GameStateManager();

	@Override
	public void create () {

        Stage stage = new Stage(new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
        Gdx.input.setInputProcessor(stage);
        stage.getViewport().apply();

        stage.addListener(new InputListener() {
            @Override
            public boolean keyDown(InputEvent event, int keycode) {
                if(keycode == Input.Keys.ENTER) {
                    GameState currentState = manager.currentState;
                    if(currentState != null) {
                        manager.setCurrentState(currentState.next());
                    }
                    return true;
                }
                return false;
            }
        });

        QuestionPool pool = new QuestionPool();
        pool.shuffle();
        TextBookState bookState = new TextBookState(pool, stage);
        ExamState examState = new ExamState(pool, stage);
        ExamState examState2 = new ExamState(pool, stage);
        ExamState examState3 = new ExamState(pool, stage);
        examState2.order = 1;
        examState3.order = 2;
        GradingState grades = new GradingState(pool, stage);
        TitleScreen title = new TitleScreen(stage);
        title.nextState = bookState;
        examState.manager = manager;
        examState2.manager = manager;
        examState3.manager = manager;
        bookState.nextState = examState;
        bookState.manager = manager;
        examState.nextState = examState2;
        examState2.nextState = examState3;
        examState3.nextState = grades;
        grades.nextState = bookState;

        manager = new GameStateManager();
        manager.setCurrentState(title);

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
