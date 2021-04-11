package com.company.lesson6;

public class Dog extends Animal{

    private static  int dogCreatedCount = 0;
    private int runLimit = 500;
    private int swimLimit = 10;

    public static int dogCount(){
        return dogCreatedCount;
    }

    public Dog(String name){
        this.name = name;
        dogCreatedCount ++;
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
