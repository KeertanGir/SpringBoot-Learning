package org.learnspringframework.gamerunner.game;

import org.springframework.stereotype.Component;

@Component
public class SuperContra implements GamingConsole {

    @Override
    public void up(){
        System.out.println("SuperContra Jump");
    }

    @Override
    public void down(){
        System.out.println("SuperContra Down");
    }

    @Override
    public void right(){
        System.out.println("SuperContra back");
    }

    @Override
    public void left(){
        System.out.println("SuperContra Accelerate");
    }
}
