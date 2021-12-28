package com.biz.book;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

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
            System.out.println("1 - Add more Address Book  " +
                    "\n2 - Edit Address Book " +
                    "\n3 - Delete Address Book " +
                    "\n4 - Show AddressBook " +
                    "\n5 - Search person Using City or State" +
                    "\n6 - City wise data "+
                    "\n7 - Enter the city/state name for find the count " +
                    "\n8 - Enter book Name to find sorted contact person" +
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
                    System.out.print("Enter City or State name : ");
                    searchRecord((new Scanner(System.in).next()), addressBookHashMap);
                    break;
                case 6:
                    System.out.print("Enter City or State name : ");
                    Map<String, ContactPerson> cityStateMap = cityStateWiseData((new Scanner(System.in).next()), addressBookHashMap);
                    for (String cityCount : cityStateMap.keySet()) {
                        System.out.println(cityCount + " - " + cityStateMap.get(cityCount));
                    }
                    break;
                case 7:
                    System.out.print("Enter City or State name : ");
                    int numberOfContact=countOfContact((new Scanner(System.in).next()),addressBookHashMap);
                    System.out.println("Total number of contact in given City is : "+numberOfContact);
                    break;
                case 8:
                    System.out.println("Enter the Book Name ; ");
                    String book=sc.next();
                    List<ContactPerson> contacts=addressBookHashMap.get(book);
                    sortContact(contacts);
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("Please enter valid input");
            }
        }
    }

    private static void sortContact(List<ContactPerson> contacts) {
        List<ContactPerson> listObject=
                contacts.stream().sorted((o1,o2)->o1.firstName.compareTo(o2.firstName)).collect(Collectors.toList());
        //System.out.println(listObject);
        for(ContactPerson cp:listObject){
            System.out.println(cp);
        }
    }

    private static int countOfContact(String cityStateName, Map<String, ArrayList<ContactPerson>> addressBookHashMap) {
        AtomicInteger cityCounter = new AtomicInteger();
        addressBookHashMap
                .values()
                .forEach(value -> {
                    value.forEach(person -> {
                        if (person.city.equals(cityStateName) || person.state.equals(cityStateName))
                            cityCounter.getAndIncrement();
                    });
                });
        return cityCounter.get();
    }

    private static void printAddressBookHashMap(Map<String, ArrayList<ContactPerson>> addressBookHashMap) {
        for (String name : addressBookHashMap.keySet()) {
            String value = addressBookHashMap.get(name).toString();
            System.out.println(name + " --> " + value);
        }
    }

    private static Map<String, ContactPerson> cityStateWiseData(String cityStateName, Map<String, ArrayList<ContactPerson>> addressBookHashMap) {
        Map<String, ContactPerson> commonCityName = new HashMap<>();

        AtomicInteger cityCounter = new AtomicInteger(1);
        addressBookHashMap
                .values()
                .forEach(value -> {
                    value.forEach(person -> {
                                if (person.city.equals(cityStateName) || person.state.equals(cityStateName))
                                    commonCityName.put((cityCounter.getAndIncrement() + ""), person);
                            });
                });
        return commonCityName;
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
