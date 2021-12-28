package com.biz.book;

import java.util.ArrayList;
import java.util.HashMap;

public class TestMain {
    private static HashMap<String, ArrayList<ContactPerson>> hashMap = new HashMap<>();
    private static ContactPerson contactPerson = new ContactPerson();
    private static ArrayList<ContactPerson> arrayList = new ArrayList<>();

    public static HashMap<String, ArrayList<ContactPerson>> setData() {
        contactPerson = new ContactPerson("Rahul", "abc", "Pune", "Pune", "maharashtra", 12345, 12345, "rahul@gmail.com");
        arrayList.add(contactPerson);
        contactPerson = new ContactPerson("Ram", "PQR", "Mumbai", "Mumbai", "maharashtra", 567890, 56789, "ram@pqr.com");
        arrayList.add(contactPerson);
        contactPerson = new ContactPerson("Shaam", "xyz", "Nagpur", "nagpur", "MP", 12345, 67890, "shaam@xyz.com");
        arrayList.add(contactPerson);
        contactPerson = new ContactPerson("Raju", "PQR", "Mumbai", "Mumbai", "MP", 567890, 56789, "ram@pqr.com");
        arrayList.add(contactPerson);
        hashMap.put("book1", arrayList);
        arrayList.clear();
        contactPerson = new ContactPerson("Rahul", "abc", "Pune", "Pune", "maharashtra", 12345, 12345, "rahul@gmail.com");
        arrayList.add(contactPerson);
        contactPerson = new ContactPerson("Ram", "PQR", "Mumbai", "Mumbai", "maharashtra", 567890, 56789, "ram@pqr.com");
        arrayList.add(contactPerson);
        contactPerson = new ContactPerson("Shaam", "xyz", "Nagpur", "nagpur", "MP", 12345, 67890, "shaam@xyz.com");
        arrayList.add(contactPerson);
        contactPerson = new ContactPerson("Raju", "PQR", "Mumbai", "Mumbai", "MP", 567890, 56789, "ram@pqr.com");
        arrayList.add(contactPerson);
        hashMap.put("book2", arrayList);

        return hashMap;

    }
}
