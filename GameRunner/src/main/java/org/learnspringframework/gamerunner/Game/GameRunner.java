package org.learnspringframework.gamerunner.Game;

public class GameRunner {

    private Mario game;
    public GameRunner(Mario game){
        this.game = game;
    }

    public void run(){
        game.up();
        game.left();
        game.right();
        game.down();
    }

}
