package com.company.lesson3;

import java.util.Random;
import java.util.Scanner;

public class WordsGuessGame {
    public static Scanner sc = new Scanner(System.in);
    public static final String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
    public static String word = "";

    public static void initGame() {
        System.out.println("\n\nБыло загадано слово");
        Random random = new Random();
        int randomNum = random.nextInt(words.length);
        word = words[randomNum];
    }


    public static void main(String[] args) {
        initGame();
        String userWord = "";
        do {
            System.out.println("Попробуйте угадать слово: ");
            String userInput = sc.nextLine();
            userWord = checkUserWord(userInput);
        } while (!word.equals(userWord));
        System.out.println("Вы угадали слово!");
    }

    public static String checkUserWord(String input){
        String userWord = getSameLetters(word, input);
        if (userWord.equals(word)){
            return userWord;
        }
        System.out.println(formatMaskedText(userWord));
        return userWord;
    }

    public static int minLength(String userInput, String word) {
        return Math.min(userInput.length(), word.length());
    }

    public static String getSameLetters(String original, String input){
        StringBuilder lettersFromAnswer = new StringBuilder();
        for (int i = 0; i < minLength(original, input); i ++){
            if (original.charAt(i) == input.charAt(i)){
                lettersFromAnswer.append(original.charAt(i));
            }else{
                break;
            }
        }
        return lettersFromAnswer.toString();
    }

    public static String formatMaskedText(String userWord) {
        int start = userWord.length();
        StringBuilder outputWord = new StringBuilder(userWord);
        for (int i = start ; i < 16; i++){
            outputWord.append("#");
        }
        return outputWord.toString();
    }


}
