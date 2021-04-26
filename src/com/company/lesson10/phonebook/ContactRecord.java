package com.company.lesson10.phonebook;

public class ContactRecord {
    private String phone;
    private String name;

    public ContactRecord(String phone, String name){
        this.phone = phone;
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }
}
