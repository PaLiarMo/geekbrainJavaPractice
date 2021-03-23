package com.company.lesson1;

public class Main {

    public static void main(String[] args) {
        byte bVar = 100;
        short shortVar = 50;
        int intVar = 10;
        long longVar = 20009;

        char characterVar = 'C';

        float floatVar = 1.20F;
        double doubleVar = 1.20;

        boolean boolVar = true;

    }

    public static float calculateExpression(float a, float b, float c, float d) {
        return a * ( b + (c/d));
    }

    public static boolean sumIsLessLimit(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    public static void defineNumSign(int num) {
        String checkResult = (num >= 0 ? " is positive" : " is negative");
        System.out.println( ""+ num + checkResult +" number");
    }

    public static boolean isNegative(int num) {
        return num < 0;
    }

    public static void greetingTo(String userName) {
        System.out.println( "Привет, "+ userName + "!");
    }

    public static boolean isLeapYear(int year) {
        return (year%4 == 0 && year%100 != 0) || year%400 == 0;
    }

}
