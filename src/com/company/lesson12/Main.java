package com.company.lesson12;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;



    private static final Object lockArrayFill = new Object();



    public static void main(String[] args) {
        crateDataArrayConsistently();
        crateDataArrayParallels();



    }

    private static void crateDataArrayParallels(){
        System.out.println("Заполнение массива параллельно в 2-х потоках");
        long startTime = System.currentTimeMillis();
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);
        float[] a1 = new float[HALF];
        float[] a2 = new float[HALF];

        System.arraycopy(arr, 0, a1, 0, HALF);
        System.arraycopy(arr, HALF, a2, 0, HALF);
        new ArrayParallelsFill(a1, a2, new Runnable() {
            @Override
            public void run() {
                System.arraycopy(a1, 0, arr, 0, HALF);
                System.arraycopy(a2, 0, arr, HALF, HALF);
                long endTime = System.currentTimeMillis();
                System.out.printf("На заполнение массива ушло %d миллисекунд", (endTime - startTime));
            }
        });
    }

    private static void crateDataArrayConsistently(){
        System.out.println("Заполнение массива в одном потоке");
        long startTime = System.currentTimeMillis();
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);
        for (int i = 0; i < arr.length; i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5.f) * Math.cos(0.2f + i / 5.f) * Math.cos(0.4f + i / 2.f));
        }
        long endTime = System.currentTimeMillis();
        System.out.printf("На заполнение массива в одном потоке ушло %d миллисекунд", (endTime - startTime));
        System.out.println();
        System.out.println();
    }



}
