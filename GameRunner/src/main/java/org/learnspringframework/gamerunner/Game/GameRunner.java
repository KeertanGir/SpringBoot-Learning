package org.learnspringframework.gamerunner.Game;

// tight Coupled
public class GameRunner {

//    Tight Coupling
//    private Mario game;
//    public GameRunner(Mario game){
//        this.game = game;
//    }

//    Loose Coupling
    private GammingConsole game;
    public GameRunner(GammingConsole game){
        this.game = game;
    }


    public void run(){
        game.up();
        game.down();
        game.left();
        game.right();

    }

}
