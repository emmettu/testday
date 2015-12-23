package com.emmett.testday.states;

/**
 * Created by emmett on 22/12/15.
 */
public interface GameState {
    void display();
    void update();
    void create();
    void dispose();
}
