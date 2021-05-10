package com.company.lesson13;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c) {

        try {
            try {
                if (Main.SEMAPHORE.hasQueuedThreads()){
                    System.out.println(c.getName() + " ждет начала этапа: " + description);
                }
                Main.SEMAPHORE.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                Main.SEMAPHORE.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
