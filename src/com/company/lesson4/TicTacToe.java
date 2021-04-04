package com.company.lesson4;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public static char[][] map;
    public static final int SIZE = 3;
    public static final int DOTS_TO_WIN = 3;

    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';

    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();

        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");

    }

    /** GAME TURN LOGIC */

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    public static void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }


    /** GAME FIELD METHODS */


    public static void initMap(){
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }

    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }



    /** WIN CHECK */

    public static boolean checkWin(char symb) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    continue;
                }
                if (map[i][j] == symb){
                    if (checkLinesAround(i, j , symb)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean checkLinesAround(int x, int y, char symb) {
        return checkHorizontalLine(x,y,symb) || checkVerticalLine(x,y,symb) || checkDiagonalLine(x,y,symb);
    }

    public static boolean checkDiagonalLine(int x, int y, char symb) {
        boolean diagonalFilled = true;
        boolean backDiagonalFilled = true;
        for (int i = 1; i < DOTS_TO_WIN; i++) {
            if ((x+i == SIZE) || (y+i == SIZE)){
                diagonalFilled = false;
                break;
            }
            if (map[x+i][y+i] != symb) {
                diagonalFilled = false;
                break;
            }
        }
        for (int i = 1; i < DOTS_TO_WIN; i++) {
            if ((x-i < 0) || (y+i == SIZE)){
                backDiagonalFilled = false;
                break;
            }
            if (map[x-i][y+i] != symb) {
                backDiagonalFilled = false;
                break;
            }

        }
        return diagonalFilled || backDiagonalFilled;
    }

    public static boolean checkVerticalLine(int x, int y, char symb){
        for (int i = y; i < y+DOTS_TO_WIN; i++) {
            if (i >= SIZE) {
                return false;
            }
            if (map[x][i] != symb){
                return false;
            }
        }
        return true;
    }

    public static boolean checkHorizontalLine(int x, int y, char symb){
        for (int i = x; i < x+DOTS_TO_WIN; i++) {
            if (i >= SIZE) {
                return false;
            }
            if (map[i][y] != symb){
                return false;
            }
        }
        return true;
    }

}
