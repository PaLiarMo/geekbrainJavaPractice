package com.company.lesson8;

import com.company.lesson8.interfaces.MovableObject;
import com.company.lesson8.interfaces.TrainingItem;
import com.company.lesson8.obstacle.Treadmill;
import com.company.lesson8.obstacle.Wall;
import com.company.lesson8.participants.Cat;
import com.company.lesson8.participants.Human;
import com.company.lesson8.participants.Robot;

public class Main {
    public static TrainingItem[] obstacles = new TrainingItem[4];
    public static MovableObject[] practicants = new MovableObject[3];

    public static void main(String[] args) {
        initObstacle();
        initPracticants();
        for (MovableObject practicant : practicants ) {
            for (TrainingItem obstacle : obstacles) {
                if (!obstacle.makeTraining(practicant)){
                    break;
                }
            }
        }
    }

    private static void initObstacle(){
        obstacles[0] = new Treadmill(1050);
        obstacles[1] = new Wall("Стена",1);
        obstacles[2] = new Treadmill(2000);
        obstacles[3] = new Wall("Большая стена" ,2);
    }
    private static void initPracticants(){
        practicants[0] = new Robot();
        practicants[1] = new Cat();
        practicants[2] = new Human();
    }

}
