package com.company.lesson11.task3.box;

import com.company.lesson11.task3.fruit.Fruit;
import com.company.lesson11.task3.fruit.Orange;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    ArrayList<T> boxFruit = new ArrayList<>();

    public void addFruit(T fruit){
        boxFruit.add(fruit);
    }
    public float getWeight(){
        float summ = 0;
        for (Fruit fruit : boxFruit){
            summ += fruit.getFruitWeight();
        }
        return summ;
    }

    public boolean addAllFruit(Box<T> otherBox) {
        return boxFruit.addAll(otherBox.boxFruit);
    }


    public boolean compare(Box<? extends Fruit> otherBox) {
        return getWeight() == otherBox.getWeight();
    }

}
