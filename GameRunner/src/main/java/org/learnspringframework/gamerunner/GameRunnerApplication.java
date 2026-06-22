package org.learnspringframework.gamerunner;

import org.learnspringframework.gamerunner.enterprice.web.BusinessWebController;
import org.learnspringframework.gamerunner.game.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class GameRunnerApplication {

    public static void main(String[] args) {


//        Tight Coupling

//        Mario mario = new Mario();
//        SuperContra superContra = new SuperContra();
//        this Game Runner is dependent only on the Mario Game, It doesn't accept other game.
//        GameRunner game = new GameRunner(mario);
//        game.run();

//        Lose Coupling

//        Mario mario = new Mario();
//        SuperContra superContra = new SuperContra();
//        PacMan pacMan = new PacMan(); // Step 1 Create Object Of any Game
//        GameRunner game = new GameRunner(pacMan); // Step 2 The Pass This Object into the Game Runner Constructor
//         ---- >>> Now This Game Runner can Handle all game Which implements the GammingConsole Interface

//        "----------------------------------------------------------------------------------------------"

//        ==> Now Spring Handle that Creation of beans Unless creating, Or injecting Dependeacy Manually Spring Handle It Automatically

        ConfigurableApplicationContext context = SpringApplication.run(GameRunnerApplication.class, args);
        GameRunner game = context.getBean(GameRunner.class);
        game.run();

        BusinessWebController controller = context.getBean(BusinessWebController.class);
        System.out.println(controller.showBusinessData());

    }

}
