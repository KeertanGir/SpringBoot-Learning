package org.learnspringframework.gamerunner;

import org.learnspringframework.gamerunner.Game.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GameRunnerApplication {

    public static void main(String[] args) {

        SpringApplication.run(GameRunnerApplication.class, args);
//        Tight Coupling

//        Mario mario = new Mario();
//        SuperContra superContra = new SuperContra();
//        this Game Runner is dependent only on the Mario Game, It doesn't accept other game.
//        GameRunner game = new GameRunner(mario);
//        game.run();

//        Lose Coupling

        Mario mario = new Mario();
        SuperContra superContra = new SuperContra();
        PacMan pacMan = new PacMan();

//        Now This Game Runner can Handle all game Which implements the GammingConsole Interface
        GameRunner game = new GameRunner(mario);
        game.run();

    }

}
