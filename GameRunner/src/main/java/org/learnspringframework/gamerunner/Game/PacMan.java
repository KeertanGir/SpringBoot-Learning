package org.learnspringframework.gamerunner.Game;

public class PacMan implements GammingConsole{


    @Override
    public void up() {
        System.out.println("PacMan Up");
    }

    @Override
    public void down() {
        System.out.println("PacMan Down");
    }

    @Override
    public void left() {
        System.out.println("PacMan left");
    }

    @Override
    public void right() {
        System.out.println("PacMan right");
    }
}
