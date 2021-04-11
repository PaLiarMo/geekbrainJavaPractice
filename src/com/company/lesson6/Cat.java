package com.company.lesson6;

public class Cat extends Animal {

    private static  int catCreatedCount = 0;
    private int runLimit = 200;
    private int swimLimit = 0;

    public static int catCount(){
        return catCreatedCount;
    }

    public Cat(String name){
        this.name = name;
        catCreatedCount ++;
    }

    @Override
    protected int getRunLimit() {
        return runLimit;
    }

    @Override
    protected int getSwimLimit() {
        return swimLimit;
    }

    @Override
    public boolean run(int distance) {
        boolean done = super.run(distance);
        if (done) {
            runLimit -= distance;
        }
        return done;
    }

    @Override
    public boolean swim(int distance) {
        boolean done = super.swim(distance);
        if (done) {
            swimLimit -= distance;
        }
        return done;
    }
}
