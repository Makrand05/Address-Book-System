package com.biz.book;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AddressBookClass {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        Scanner sc = new Scanner(System.in);

        String addressBookName;
        Map<String, ArrayList<ContactPerson>> addressBookHashMap = new HashMap<>();
        //tesing data
       // addressBookHashMap = TestMain.setData();
        ArrayList arrayList = null;
        boolean flag = true;

        while (flag) {

            System.out.println("------------------------Address Book--------------------");
            System.out.println("1 - Add more Address Book  \n2 - Edit Address Book \n3 - Delete Address Book \n4 - Show AddressBook " +
                    "\n5 - Search Using City or State" +
                    "\n6- City wise data" +
                    "\n0 -  for exit \nEnter your Choice.....");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter Address book Name");
                    addressBookName = sc.next();
                    addressBookHashMap = new HashMap<>();


                    break;
                case 2:
                    System.out.println("Enter Address book Name for Edit");
                    addressBookName = sc.next();
                    arrayList = ContactList.editAddressBook();
                    if (addressBookHashMap.get(addressBookName) != null) {
                        //ArrayList temp=addressBookHashMap.get(addressBookName);
                        arrayList.add(addressBookHashMap.get(addressBookName));
                        // temp.add(arrayList);

                    }
                    addressBookHashMap.put(addressBookName, arrayList);
                    break;
                case 3:
                    System.out.println("Enter Address book Name for Delete...");
                    addressBookName = sc.next();
                    addressBookHashMap.remove(addressBookName);
                    break;
                case 4:
                    System.out.println("Address Bool List");
                    //System.out.println(addressBookHashMap);
                    printAddressBookHashMap(addressBookHashMap);
                    break;
                case 5:
                    System.out.print("Enter City name : ");
                    searchRecord((new Scanner(System.in).next()), addressBookHashMap);
                    break;
                case 6:
                    //Map<String, ContactPerson> temp = cityStateWiseData(addressBookHashMap);
                  //  System.out.println(temp);
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("Please enter valid input");
            }

        }


    }

    private static void printAddressBookHashMap(Map<String, ArrayList<ContactPerson>> addressBookHashMap) {
        for (String name : addressBookHashMap.keySet()) {
            String value = addressBookHashMap.get(name).toString();
            System.out.println(name + " --> " + value);
        }
    }


//Search the data form using City name and state name
    private static void searchRecord(String cityName, Map<String, ArrayList<ContactPerson>> addressBookHashMap) {
        addressBookHashMap
                .values()
                .stream().
                forEach(value -> {
                            value.stream()
                            .forEach(person -> {
                            if (person.city.equals(cityName) || person.state.equals(cityName))
                                    System.out.println(person);
                            });
                });
    }
}
