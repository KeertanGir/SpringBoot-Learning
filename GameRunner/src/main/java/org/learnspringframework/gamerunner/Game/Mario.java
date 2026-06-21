package org.learnspringframework.gamerunner.Game;

public class Mario implements GammingConsole{
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
