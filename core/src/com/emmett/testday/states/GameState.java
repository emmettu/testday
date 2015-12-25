package com.emmett.testday.states;

/**
 * Created by emmett on 22/12/15.
 */
public interface GameState {
    void create();
    void display();
    void update();
    void dispose();
    void resize(int x, int y);
    GameState next();
}
