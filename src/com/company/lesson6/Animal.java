package com.company.lesson6;

public abstract class Animal {
    protected String name;
    private static int animalCreatedCount = 0;

    public Animal(){
        animalCreatedCount ++;
    }

    public static int animalCount(){
        return animalCreatedCount;
    }

    public boolean run(int distance){
        if (getRunLimit() == 0){
            System.out.printf("%s не может бежать\n", name);
            return false;
        }
        if (distance <= getRunLimit()){
            System.out.printf("%s пробежал %d м.\n", name,distance);
            return true;
        }else{
            System.out.printf("%s не может пробежать %d м. осталось сил на %s м.\n", name , distance, getRunLimit());
            return false;
        }

    };
    public boolean swim(int distance) {
        if (getSwimLimit() == 0){
            System.out.printf("%s не может плыть\n", name);
            return false;
        }
        if (distance <= getSwimLimit()) {
            System.out.printf("%s проплыл %d м.\n", name, distance);
            return true;
        }else{
            System.out.printf("%s не может проплыть %d м.осталось сил на %s м.\n", name , distance, getSwimLimit());
            return false;
        }

    }

    protected abstract int getRunLimit();
    protected abstract int getSwimLimit();
}


