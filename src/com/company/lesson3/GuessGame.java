package com.company.lesson3;
import java.util.Random;
import java.util.Scanner;

public class GuessGame {
    public static Scanner sc = new Scanner(System.in);
    public static final int retryCount = 3;
    public static int userRetry = 3;
    public static boolean gameActive = true;

    public static void initGame() {
        userRetry = retryCount;
        System.out.println("\n\nБыло загадано случайное число от 0 до 9");
        System.out.printf("У вас есть %s попытки чтобы угадать", retryCount);
    }

    public static void gameEnded() {
        int userAnswer = getNumberFromScanner("Повторить игру еще раз? 1 – да / 0 – нет", 0, 1);
        gameActive = userAnswer != 0;
    }

    public static void userTryFailed() {
        userRetry--;
        String winText = "Вы потратили все свои попытки и не угадали число";
        String notGuessText = "Вы не угадали, осталось попыток: " + userRetry;
        System.out.println(userRetry == 0 ? winText : notGuessText);
    }

    public static void main(String[] args) {
        do {
            initGame();
            Random random = new Random();
            int randomNum = random.nextInt(10);
            for (int i = 0; i < retryCount; i++) {
                int userNum = getNumberFromScanner(randomNum + " Введите число от 0 до 9", 0, 9);
                if (userNum != randomNum) {
                    userTryFailed();
                } else {
                    System.out.println("Вы угадали число!");
                    break;
                }
            }
            gameEnded();
        } while (gameActive);
    }


    public static int getNumberFromScanner(String message, int min, int max) {
        int x;
        do {
            System.out.println(message);
            x = sc.nextInt();
        } while (x < min || x > max);
        return x;
    }
}
