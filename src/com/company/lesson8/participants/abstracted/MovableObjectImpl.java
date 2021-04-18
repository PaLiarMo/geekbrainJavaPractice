package com.company.lesson8.participants.abstracted;

import com.company.lesson8.interfaces.MovableObject;
import com.company.lesson8.interfaces.TrainingItem;

public abstract class MovableObjectImpl implements MovableObject {

    protected abstract int getRunLimit();
    protected abstract int getJumpLimit();

    protected abstract void runDistance (int distance);

    protected abstract String getName();

    @Override
    public boolean run(TrainingItem item, int distance) {
        if (distance > getRunLimit()){
            System.out.printf("%s не смог пробежать препядствие: %s\n",getName(), item.getName());
            return false;
        }
        runDistance(distance);
        System.out.printf("%s пробежал препядствие: %s\n",getName(), item.getName());
        return true;
    }

    @Override
    public boolean jump(TrainingItem item, int height) {
        if (height > getJumpLimit()){
            System.out.printf("%s не смог перепрыгнуть препядствие: %s\n",getName(), item.getName());
            return false;
        }
        System.out.printf("%s перепрыгнул препядствие: %s\n",getName(), item.getName());
        return true;
    }




}
