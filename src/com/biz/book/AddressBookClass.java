package com.biz.book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookClass {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        Scanner sc = new Scanner(System.in);

        String addressBookName;
        Map<String, ArrayList<ContactPerson>> addressBookHashMap = new HashMap<>();
        ArrayList arrayList=null;
        boolean flag = true;

        while (flag) {

            System.out.println("------------------------Address Book--------------------");
            System.out.println("1 - Add more Address Book  \n2 - Edit Address Book \n3 - Delete Address Book \n4 - Show AddressBook " +
                    "\n0 -  for exit \nEnter your Choice.....");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter Address book Name");
                    addressBookName = sc.next();
                    addressBookHashMap.put(addressBookName,null);
                    break;
                case 2:
                    System.out.println("Enter Address book Name for Edit");
                    addressBookName = sc.next();
                    arrayList=ContactList.editAddressBook();
                    if(addressBookHashMap.get(addressBookName)!=null)
                    {
                        //ArrayList temp=addressBookHashMap.get(addressBookName);
                        arrayList.add(addressBookHashMap.get(addressBookName));
                       // temp.add(arrayList);

                    }
                    addressBookHashMap.put(addressBookName,arrayList);
                    break;
                case 3:
                    System.out.println("Enter Address book Name for Delete...");
                    addressBookName = sc.next();
                    addressBookHashMap.remove(addressBookName);
                    break;
                case 4:
                    System.out.println("Address Bool List");
                    //System.out.println(addressBookHashMap);
                    for(String name:addressBookHashMap.keySet()){
                       String value=addressBookHashMap.get(name).toString();
                       System.out.println(name+" --> "+value);
                    }
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("Please enter valid input");
            }

        }


    }
}
