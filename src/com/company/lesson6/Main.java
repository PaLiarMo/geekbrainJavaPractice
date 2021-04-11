package com.company.lesson6;

public class Main {

    public static void main(String[] args) {
        Animal firstAnimal = new Dog("Бобик");
        Animal secondAnimal = new Cat("Муркис");

        firstAnimal.run(120);
        firstAnimal.run(30);
        firstAnimal.run(200);

        secondAnimal.run( 140);
        secondAnimal.run( 10);
        secondAnimal.run( 140);

        firstAnimal.swim(75);
        firstAnimal.swim(5);
        secondAnimal.swim( 10);

        Animal oneMoreAnimal = new Cat("Том");
        oneMoreAnimal.run(100);


        System.out.printf("Общее количество животных %d\n", Animal.animalCount());
        System.out.printf("Общее количество созданых котов %d\n", Cat.catCount());
        System.out.printf("Общее количество созданых собак %d\n", Dog.dogCount());


    }
}
