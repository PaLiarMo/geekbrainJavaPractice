package com.company.lesson10.phonebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    //Phone : names
    private HashMap<String, String> contacts = new HashMap<>();

    public void addContact(ContactRecord record) {
        contacts.put(record.getPhone(), record.getName());
    }
    public ArrayList<ContactRecord> get(String name){
        ArrayList<ContactRecord> searchedItems = new ArrayList<>();
        if (contacts.containsValue(name)){
            for (Map.Entry<String, String> item : contacts.entrySet()){
                if (item.getValue().equalsIgnoreCase(name)){
                    searchedItems.add(new ContactRecord(item.getKey(),item.getValue()));
                }
            }
        }
        return searchedItems;
    }

}
