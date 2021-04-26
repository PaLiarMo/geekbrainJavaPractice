package com.company.lesson10;

import java.util.*;

public class ArrayWork {

    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>(Arrays.asList("маринад","фельдшер", "чашка", "дождевик", "удочка", "квартал", "экскаватор", "кузов", "автотранспорт", "маринад", "крендель", "кукушка", "ксерокс", "метелка",
                "паук","чашка","удочка","маринад"));
        calculateWordsInArray(words);
    }



    public static void calculateWordsInArray(ArrayList<String> words){
        Set<String> uniqueWord = new HashSet<>();
        HashMap<String, Integer> wordCount = new HashMap<>();
        for (String word : words){
            uniqueWord.add(word);
            if (!wordCount.containsKey(word)){
                wordCount.put(word, 1);
            }else{
                wordCount.put(word, wordCount.get(word) + 1);
            }
        }

        System.out.println("Список уникальных слов "+uniqueWord);
        System.out.println("Подсчет слов повоторяющийся в массиве:");
        for (String key: wordCount.keySet()){
            System.out.printf("%s - %d\n", key, wordCount.get(key));
        }

    }

}
