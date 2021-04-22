package com.company.lesson9.exceptions;

public class MyArrayDataException extends Exception{
    int row;
    int column;
    public MyArrayDataException(int row, int column) {
        this.row = row ;
        this.column = column ;
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
        System.out.printf("Был задан массив не правильного размера\n неправильный элемент на пересечении %s строки и %s столбца",row + 1, column + 1);
    }
}
