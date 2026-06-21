package org.learnspringframework.gamerunner;

import org.learnspringframework.gamerunner.Game.GameRunner;
import org.learnspringframework.gamerunner.Game.Mario;
import org.learnspringframework.gamerunner.Game.SuperContra;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GameRunnerApplication {

    public static void main(String[] args) {

        SpringApplication.run(GameRunnerApplication.class, args);

//        Mario mario = new Mario();
        SuperContra superContra = new SuperContra();
        GameRunner game = new GameRunner(superContra);
        game.run();

    }

}
