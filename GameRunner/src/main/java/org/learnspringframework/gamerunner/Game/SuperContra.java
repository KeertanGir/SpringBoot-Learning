package org.learnspringframework.gamerunner.Game;

public class SuperContra implements GammingConsole {

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
