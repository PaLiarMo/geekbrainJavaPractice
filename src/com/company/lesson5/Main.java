package com.company.lesson5;

public class Main {

    public static void main(String[] args) {
        Person[] persArray = initPersonsDataArray();
        for (int i = 0; i<persArray.length; i++){
            if (persArray[i] == null){
                continue;
            }
            if (persArray[i].getAge() > 40){
                persArray[i].printInfo();
            }
        }

    }


    public static Person[] initPersonsDataArray(){
        Person[] persArray = new Person[5];
        persArray[0] = new Person(
                "Иван Иванов",
                "ivanov@gmail.com",
                "89998876878",
                20,
                45000);
        persArray[1] = new Person(
                "Алексей Негласов",
                "nglsj@gmail.com",
                "89998876878",
                41,
                39000);
        persArray[2] = new Person(
                "Алексей Негласов",
                "nglsj@gmail.com",
                "89998876878",
                35,
                62000);
        persArray[3] = new Person(
                "Екатерина Петрова",
                "petrvakt@gmail.com",
                "89998876878",
                50,
                55000);
        persArray[4] = new Person(
                "Борис Николаев",
                "niklaev@gmail.com",
                "89998876878",
                43,
                95000);
        return persArray;
    }
}
