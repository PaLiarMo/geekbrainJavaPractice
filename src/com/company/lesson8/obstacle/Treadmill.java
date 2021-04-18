package com.company.lesson8.obstacle;

import com.company.lesson8.interfaces.MovableObject;
import com.company.lesson8.interfaces.TrainingItem;

public class Treadmill implements TrainingItem {
    private int distance = 0;
    public Treadmill(int distance){
        this.distance = distance;
    }

    @Override
    public String getName() {
        return "Беговая дорожка ("+distance+"м.)";
    }

    @Override
    public boolean makeTraining(MovableObject obj) {
       return obj.run(this, distance);
    }
}
