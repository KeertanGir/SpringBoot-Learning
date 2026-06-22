package org.learnspringframework.gamerunner.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// tight Coupled
@Component
public class GameRunner {

//    Tight Coupling
//    private Mario game;
//    public GameRunner(Mario game){
//        this.game = game;
//    }

//    Loose Coupling

//    @Autowired
    private GamingConsole game;
    public GameRunner(@Qualifier(value = "pacMan") GamingConsole game){
        this.game = game;
    }


    public void run(){
        game.up();
        game.down();
        game.left();
        game.right();

    }

}
