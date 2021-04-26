package com.company.lesson10;

import com.company.lesson10.phonebook.ContactRecord;
import com.company.lesson10.phonebook.PhoneBook;

import java.util.ArrayList;
import java.util.Scanner;

public class PhoneTask {
    static private PhoneBook contactList = new PhoneBook();
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        initPhoneBook();
        System.out.print("Введите имя для поиска контакта: ");
        String inputName = sc.next();
        ArrayList<ContactRecord> searched = contactList.get(inputName);
        printSearchResultInfo(searched, inputName);
    }


    private static void printSearchResultInfo(ArrayList<ContactRecord> searched, String query){
        if (searched.isEmpty()){
            System.out.printf("по запросу \"%s\" контактов не найдено\n", query);
            return;
        }
        System.out.printf("по запросу \"%s\" Найдены следующие контакты:\n", query);
        for (ContactRecord record : searched){
            System.out.printf("%s - номер телефона: %s\n", record.getName(), record.getPhone());
        }
        System.out.println();

    }




    private static void initPhoneBook(){
        contactList.addContact(new ContactRecord("+19974562987", "Иванов"));
        contactList.addContact(new ContactRecord("+19984572787", "Петров"));
        contactList.addContact(new ContactRecord("+19074562977", "Сидоров"));
        contactList.addContact(new ContactRecord("+19984762977", "Иванов"));
        contactList.addContact(new ContactRecord("+19287567987", "Карпоткин"));
        contactList.addContact(new ContactRecord("+19884792977", "Некрасов"));
    }


}
