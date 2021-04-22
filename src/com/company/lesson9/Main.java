package com.company.lesson9;

import com.company.lesson9.exceptions.MyArrayDataException;
import com.company.lesson9.exceptions.MyArraySizeException;

public class Main {

    public static void main(String[] args) {
        String[][] array = createCorrectArray();
        try {
            int arraySumm = processArray(array);
            System.out.printf("Сумма всех элементов массива равна %d", arraySumm);
        } catch (MyArrayDataException | MyArraySizeException error) {
            error.printStackTrace();
        }
    }




    public static int processArray(String[][] array) throws MyArrayDataException, MyArraySizeException{
        if (notCorrectSizeArray(array)){
            throw new MyArraySizeException();
        }
        int summ = 0;
        for (int i = 0; i<array.length; i++){
            for (int j = 0; j<array[i].length; j++){
                try {
                    Integer value = Integer.parseInt(array[i][j]);
                    summ += value;
                }catch (NumberFormatException e){
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return summ;
    }

    private static Boolean notCorrectSizeArray(String[][] array)  {
        if (array.length != 4){
            return true;
        }
        for (int i = 0; i<array.length; i++){
            if (array[i].length != 4){
                return true;
            }
        }
        return false;
    }




    private static String[][] createCorrectArray() {
        String[][] output = new String[4][4];
        output[0] = new String[]{"5", "8", "9", "1"};
        output[1] = new String[]{"6", "4", "6", "5"};
        output[2] = new String[]{"1", "2", "8", "12"};
        output[3] = new String[]{"7", "9", "1", "0"};
        return output;
    }
    private static String[][] createWrongSizeArray() {
        String[][] output = new String[4][5];
        output[0] = new String[]{"5", "8", "9", "1", "2"};
        output[1] = new String[]{"6", "4", "6", "5", "4"};
        output[2] = new String[]{"1", "2", "8", "12","8"};
        output[3] = new String[]{"7", "9", "1", "0", "11"};
        return output;
    }
    private static String[][] createWrongDataArray() {
        String[][] output = new String[4][4];
        output[0] = new String[]{"5", "8", "9", "1"};
        output[1] = new String[]{"6", "4", "ы", "5"};
        output[2] = new String[]{"1", "2", "8", "12"};
        output[3] = new String[]{"7", "9", "1", "0"};
        return output;
    }

}
