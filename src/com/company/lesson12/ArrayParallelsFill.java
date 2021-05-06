package com.company.lesson12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ArrayParallelsFill {


    private Runnable onArraysFilled;

    private boolean firstArrayReady = false;
    private boolean secondArrayReady = false;


    public ArrayParallelsFill(float[] arr1, float[] arr2, Runnable onArraysFilled){
        this.onArraysFilled = onArraysFilled;
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new Runnable() {
            public void run() {
                fillValuesInArray(arr1);
                firstArrayReady = true;
                onExecuteEnded();
            }
        });
        executorService.execute(new Runnable() {
            public void run() {
                fillValuesInArray(arr2);
                secondArrayReady = true;
                onExecuteEnded();
            }
        });
    }


    private void onExecuteEnded(){
        if (firstArrayReady && secondArrayReady){
            onArraysFilled.run();
        }
    }


    private void fillValuesInArray(float[] arr){
        for (int i = 0; i < arr.length; i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5.f) * Math.cos(0.2f + i / 5.f) * Math.cos(0.4f + i / 2.f));
        }
    }
}
