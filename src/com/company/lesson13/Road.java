package com.company.lesson13;

public class Road extends Stage {
    public Road(int length) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
    }
    private final static Object lock = new Object();

    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000L);
            synchronized (lock) {
                System.out.println(c.getName() + " закончил этап: " + description);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
