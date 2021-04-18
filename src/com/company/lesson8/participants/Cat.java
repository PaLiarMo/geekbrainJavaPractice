package com.company.lesson8.participants;

import com.company.lesson8.participants.abstracted.MovableObjectImpl;

public class Cat extends MovableObjectImpl {
    private int runLimit = 4000;
    private int jumpLimit = 3;

    private String name = "Кот";

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
