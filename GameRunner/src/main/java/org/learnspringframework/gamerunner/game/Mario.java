package org.learnspringframework.gamerunner.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Mario implements GamingConsole {
    @Override
    public void up(){
        System.out.println("Jump");
    }

    @Override
    public void down(){
        System.out.println("do Down");
    }

    @Override
    public void right(){
        System.out.println("back");
    }

    @Override
    public void left(){
        System.out.println("Accelerate");
    }
}
