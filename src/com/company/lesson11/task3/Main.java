package com.company.lesson11.task3;

import com.company.lesson11.task3.box.Box;
import com.company.lesson11.task3.fruit.Apple;
import com.company.lesson11.task3.fruit.Fruit;
import com.company.lesson11.task3.fruit.Orange;

public class Main {

    public static void main(String[] args) {
        Box<Apple> applesBox2 = new Box<Apple>();

        Box<Apple> applesBox = new Box<Apple>();
        Box<Orange> orangeBox = new Box<Orange>();

        applesBox2.addFruit(new Apple());
        applesBox2.addFruit(new Apple());

        applesBox.addFruit(new Apple());
        applesBox.addFruit(new Apple());
        applesBox.addFruit(new Apple());
        applesBox.addFruit(new Apple());

        applesBox.addAllFruit(applesBox2);

        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());

        System.out.println(applesBox.compare(orangeBox) ? "Содержимое коробок весит одинаково" : "Коробки не совпадают по весу");


    }
}
