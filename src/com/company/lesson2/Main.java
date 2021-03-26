package com.company.lesson2;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println( "Задание №1");
        invertArrayValues();

        System.out.println( "\nЗадание №2");
        fillArray();

        System.out.println( "\nЗадание №3");
        incrementArrayValues();

        System.out.println( "\nЗадание №4");
        fillTwoDimArray();

        System.out.println( "\nЗадание №5");
        findMaxAndMin(new int[]{4,7,9,23,5,2,15,1,2,4,7,-5,-8,10});

        System.out.println( "\nЗадание №6");
        checkBalance(new int[]{4,7,9,23,5,2,15,1,2});
        System.out.println( "");
        checkBalance(new int[]{4,7,9,23,5,2,15,20,2,9});

        System.out.println( "\nЗадание №7");
        biasArrayValues(new int[]{4,7,9,23,5,2,15,20,2,9}, -16);
    }

    /** 1 **/
    public static void invertArrayValues() {
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println( "Исходный массив: " + Arrays.toString(array));
        for (int i = 0; i < array.length; i++){
            array[i] = array[i] == 1 ? 0 : 1;
        }
        System.out.println( "Массив с инвертированными значениями: " + Arrays.toString(array));
    }

    /** 2 **/
    public static void fillArray() {
        int[] array = new int[8];
        for (int i = 0; i < array.length; i++){
            array[i] = i*3;
        }
        System.out.println( "Заполненный массив: " + Arrays.toString(array));
    }

    /** 3 **/
    public static void incrementArrayValues() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println( "Исходный массив: " + Arrays.toString(array));
        for (int i = 0; i < array.length; i++){
            int value = array[i];
            array[i] = value < 6 ? value*2 : value;
        }
        System.out.println( "Измененный массив: " + Arrays.toString(array));

    }

    /** 4 **/
    public static void fillTwoDimArray() {
        int[][] array = new int[8][8];
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                if (i == j){
                    array[i][j] = 1;
                }else if (i == ((array.length-1) - j) ){
                    array[i][j] = 1;
                }
            }
        }
        System.out.println("Заполненый массив: ");
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }

    /** 5 **/
    public static void findMaxAndMin(int[] array) {
        if (array.length == 0){
            System.out.println("Заданный массив пустой");
            return;
        }
        System.out.println( "Заданный массив: " + Arrays.toString(array));
        int max = array[0];
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            int currentValue =  array[i];
            if (currentValue > max){
                max = currentValue;
            }
            if (currentValue < min){
                min = currentValue;
            }
        }
        System.out.println("Максимальное значение в массиве: " + max);
        System.out.println("Минимальное значение в массиве: " + min);
    }

    /** 6 **/
    public static boolean checkBalance(int[] array){
        if (array.length == 0){
            System.out.println("Заданный массив пустой");
            return false;
        }
        System.out.println( "Заданный массив: " + Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            if (i == 0){
                continue;
            }
            if (sumAfterIndex(array, i) == sumBeforeIndex(array,i)){
                System.out.println( "В массиве есть место, в котором сумма левой и правой части массива равны");
                System.out.println( "Середина находится между " + (i-1) + " и " + i + " эллементом");
                return true;
            }
        }
        System.out.println( "В массиве нет места, в котором сумма левой и правой части массива равны");
        return false;
    }

    public static int sumAfterIndex(int[] array, int index){
        int sum = 0;
        for (int i = 0; i < index; i++) {
            sum += array[i];
        }
        return sum;
    }

    public static int sumBeforeIndex(int[] array, int index){
        int sum = 0;
        for (int i = index; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }
    /** --- **/


    /** 7 **/
    public static void biasArrayValues(int[] array, int offset) {
        if (array.length == 0){
            System.out.println("Заданный массив пустой");
            return;
        }
        System.out.println( "Заданный массив: " + Arrays.toString(array));
        int shiftValue = offset%array.length; //Определяем количество смещений
        int reverseShiftValue = shiftValue > 0 ? shiftValue - array.length :  array.length - Math.abs(shiftValue);
        System.out.println( "Необходимый сдвиг массива: " + shiftValue);
        //Проверяем а не эффективнее будет сделать сдвиг в обратную сторону?
        if (Math.abs(reverseShiftValue) < Math.abs(shiftValue)){
            shiftValue = reverseShiftValue; //оптимизация
            System.out.println( "Более эффективный сдвиг: " + shiftValue);
        }
        if (shiftValue == 0){
            System.out.println( "Заданный сдвиг " + offset +" не изменит порядок элементов массива: " + Arrays.toString(array));
            return;
        }
        int direction = shiftValue > 0 ? -1 : 1; //Задаем направление сдвига
        System.out.print( "При сдвиге массива на " + offset);
        do {
            if (shiftValue > 0){
                translationForward(array);
            }else{
                translationBack(array);
            }
            shiftValue += direction;
        }while (shiftValue != 0);

        System.out.println( " получается: " + Arrays.toString(array));

    }

    public static void translationForward(int[] array) {
        if (array.length == 0){
            return;
        }
        int last = array[array.length-1];
        for (int i = array.length-2; i >= 0 ; i--) {
            array[i+1] = array[i];
        }
        array[0] = last;
    }
    public static void translationBack(int[] array) {
        if (array.length == 0){
            return;
        }
        int first = array[0];
        for (int i = 1; i < array.length; i++) {
            array[i-1] = array[i];
        }
        array[array.length - 1] = first;
    }
    /** --- **/

}
