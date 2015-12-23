package com.emmett.testday.states;

/**
 * Created by emmett on 22/12/15.
 */
public class GameStateManager {

    private GameState currentState;

    public GameStateManager(GameState initialState) {
        currentState = initialState;
        currentState.create();
    }

    public void display() {
        currentState.update();
        currentState.display();
    }

    public void create() {
        currentState.create();
    }

    public void setCurrentState(GameState currentState) {
        this.currentState.dispose();
        this.currentState = currentState;
        currentState.create();
    }

    public void resize(int x, int y) {
        currentState.resize(x, y);
    }

}
