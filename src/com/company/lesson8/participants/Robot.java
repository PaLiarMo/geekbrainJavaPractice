package com.company.lesson8.participants;
import com.company.lesson8.participants.abstracted.MovableObjectImpl;

public class Robot extends MovableObjectImpl {
    private int runLimit = 8000;
    private int jumpLimit = 0;

    private String name = "Робот";

    @Override
    protected int getRunLimit() {
        return runLimit;
    }

    @Override
    protected int getJumpLimit() {
        return jumpLimit;
    }

    @Override
    protected String getName() {
        return name;
    }

    @Override
    protected void runDistance(int distance) {
        runLimit -= distance;
    }
}