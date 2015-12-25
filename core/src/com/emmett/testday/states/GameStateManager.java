package com.emmett.testday.states;

/**
 * Created by emmett on 22/12/15.
 */
public class GameStateManager {

    public GameState currentState;

    public GameStateManager() {}

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

    public void setCurrentState(GameState newState) {
        //this.currentState.dispose();
        newState.create();
        currentState = newState;
    }

    public void resize(int x, int y) {
        currentState.resize(x, y);
    }

}
