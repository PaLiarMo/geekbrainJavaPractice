package com.company.lesson9.exceptions;

public class MyArraySizeException extends Exception{

    @Override
    public void printStackTrace() {
        super.printStackTrace();
        System.out.println("Был задан массив не правильного размера");
    }
}
