package com.company.lesson11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        swapTwoElements();
        arrayToArrayList(new Integer[]{3,5,7,8,3,3});
    }

    private static void arrayToArrayList(Integer[] array){
        System.out.println("Преобразуем массив в ArrayList:");
        ArrayList<Integer> convertedArrayList = new ArrayList<Integer>(Arrays.asList(array));
        System.out.println(convertedArrayList);
    }

    private static void swapTwoElements(){
        ArrayList<String> words = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h"));
        System.out.println("Изначальный массив:");
        System.out.println(words);
        try {
            Collections.swap(words, 1, 7);
        }catch (IndexOutOfBoundsException exception){
            System.out.println("Введен некоректный индекс эелемета(ов)\n невозможно сделать смену местами");
            return;
        }
        System.out.println("Изначальный после замены двух элементов:");
        System.out.println(words);
        System.out.println();
    }

}
