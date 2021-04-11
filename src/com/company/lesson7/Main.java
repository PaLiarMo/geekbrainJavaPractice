package com.company.lesson7;


public class Main {
    private static Cat[] cats;
    private static Plate plate;

    public static void main(String[] args) {
        cats = initCatList();
        plate = new Plate(50);
        feedCats();
        plate.addFood(10);
        feedCats();
    }

    private static void feedCats(){
        System.out.println("\n\nНачинаем кормить котов");
        for (Cat cat: cats) {
            if (cat == null){
                continue;
            }
            cat.eat(plate);
            cat.info();
        }
        plate.info();
    }

    private static Cat[] initCatList(){
        Cat[] cats = new Cat[4];
        cats[0] = new Cat("Барсик", 10);
        cats[1] = new Cat("Мурзик", 5);
        cats[2] = new Cat("Том", 15);
        cats[3] = new Cat("Маркиз", 25);

        return cats;
    }


}
