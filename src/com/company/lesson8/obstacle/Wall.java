package com.company.lesson8.obstacle;

import com.company.lesson8.interfaces.MovableObject;
import com.company.lesson8.interfaces.TrainingItem;

public class Wall implements TrainingItem {
    private int height;
    private String name;
    public Wall(String name, int height){
        this.name = name;
        this.height = height;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean makeTraining(MovableObject obj) {
       return obj.jump(this, height);
    }
}
