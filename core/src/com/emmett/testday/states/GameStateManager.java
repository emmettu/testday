package com.emmett.testday.states;

/**
 * Created by emmett on 22/12/15.
 */
public class GameStateManager {

    GameState currentState;

    void display() {
        currentState.update();
        currentState.display();
    }

}
