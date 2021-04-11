package com.company.lesson7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void addFood(int n) {
        food+=n;
        System.out.printf("В тарелку добавили %s единиц еды\n",food);
    }

    public boolean decreaseFood(int n) {
        if (food < n){
            return false;
        }
        food -= n;
        return true;
    }

    public void info() {
        System.out.printf("Еды осталось %s единиц\n",food);

    }
}