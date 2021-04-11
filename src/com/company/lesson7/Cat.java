package com.company.lesson7;

import com.company.lesson6.Animal;

public class Cat {

    private String name;
    private int appetite;
    private boolean isSatisfying = false;
    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }
    public void eat(Plate p) {
        if (isSatisfying){
            // Кот не есть когда наелся
            return;
        }

        if (p.decreaseFood(appetite)){
            isSatisfying = true;
        }
    }

    public void info(){
        if (isSatisfying) {
            System.out.printf("%s поел и сыт\n", name);
        }else {
            System.out.printf("%s голоден\n", name);
        }
    }

}
