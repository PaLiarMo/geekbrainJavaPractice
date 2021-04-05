package com.company.lesson5;

public class Person {
    private String name;
    private String email;
    private String phone;
    private int age;
    private int salary;


    public Person(String name, String email, String phone, int age, int salary){
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.age = age;
        this.salary = salary;
    }



    public int getAge() {
        return age;
    }

    public void printInfo(){
        StringBuilder builder = new StringBuilder();
        builder.append("Информация о пользователе: \n");
        builder.append(String.format("ФИО: %s;\n", name));
        builder.append(String.format("Email: %s;\n", email));
        builder.append(String.format("Телефон: %s;\n", phone));
        builder.append(String.format("Возраст: %d;\n", age));
        builder.append(String.format("Зарплата: %d;\n", salary));
        builder.append("\n");
        System.out.print(builder.toString());
    }

}
