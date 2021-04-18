package com.company.lesson8.participants;


import com.company.lesson8.participants.abstracted.MovableObjectImpl;

public class Human extends MovableObjectImpl {
    private int runLimit = 1600;
    private int jumpLimit = 1;

    private String name = "Человек";

    @Override
    protected int getRunLimit() {
        return runLimit;
    }

    @Override
    protected int getJumpLimit() {
        return jumpLimit;
    }

    @Override
    protected void runDistance(int distance) {
        runLimit -= distance;
    }

    @Override
    protected String getName() {
        return name;
    }

}
