package com.biz.book;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class AddressBookClass {
    private static  final String PATH = "C:\\Users\\MS\\IdeaProjects\\AddressBookSystem\\resources\\Addressbook";
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Address Book Program");
        Scanner sc = new Scanner(System.in);
        String addressBookName;
        Map<String, ArrayList<ContactPerson>> addressBookHashMap = new HashMap<>();

        //addressBookHashMap = TestMain.setData();

        ArrayList arrayList = null;
        boolean flag = true;
        while (flag) {
            System.out.println("------------------------Address Book--------------------");
            System.out.println("1 - Add more Address Book  " +
                    "\n2 - Edit Address Book " +
                    "\n3 - Delete Address Book " +
                    "\n4 - Show AddressBook " +
                    "\n5 - Search person Using City or State" +
                    "\n6 - City wise data " +
                    "\n7 - Enter the city/state name for find the count " +
                    "\n8 - Enter book Name to find sorted contact person " +
                    "\n9 - Sort Address book entries by City/State/Zip " +
                    "\n0 -  for exit \nEnter your Choice.....");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter Address book Name");
                    addressBookName = sc.next();
                    addressBookHashMap = new HashMap<>();
                    //Files.createFile(Paths.get(path + "/" + addressBookName + ".txt"));
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


                    Path fileName= Paths.get( PATH+ "/"+addressBookName+".txt");
                    System.out.println(fileName);
                    if(Files.notExists(fileName)){
                        Files.createFile(fileName);
                        List<String> s=Arrays.asList(arrayList.toString());
                        Files.write(fileName,s, StandardOpenOption.APPEND);
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
                    int numberOfContact = countOfContact((new Scanner(System.in).next()), addressBookHashMap);
                    System.out.println("Total number of contact in given City is : " + numberOfContact);
                    break;
                case 8:
                    System.out.println("Enter the Book Name : ");
                    String book = sc.next();
                    List<ContactPerson> contacts = addressBookHashMap.get(book);
                    sortContact(contacts);
                    break;
                case 9:
                    System.out.println("Enter the Book Name : ");
                    String bookName = sc.next();
                    List<ContactPerson> contact = addressBookHashMap.get(bookName);
                    System.out.println("1- City \n2- Sate \n3- Zip");
                    sortAddressBookCityStateZip(new Scanner(System.in).nextInt(), contact);
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("Please enter valid input");
            }
        }
    }

    private static void sortAddressBookCityStateZip(int option, List<ContactPerson> contact) {
        List<ContactPerson> listObject = null;
        if (option == 1) {
            listObject = contact.stream().sorted((o1, o2) -> o1.city.compareTo(o2.city)).collect(Collectors.toList());
        }
        if (option == 2) {
            listObject = contact.stream().sorted((o1, o2) -> o1.state.compareTo(o2.state)).collect(Collectors.toList());
        }
        if (option == 3) {
            listObject = contact.stream().sorted((o1, o2) -> o1.zip.compareTo(o2.zip)).collect(Collectors.toList());
        }
        for (ContactPerson cp : listObject) {
            System.out.println(cp);
        }
    }

    private static void sortContact(List<ContactPerson> contacts) {
        List<ContactPerson> listObject =
                contacts.stream().sorted((o1, o2) -> o1.firstName.compareTo(o2.firstName)).collect(Collectors.toList());
        //System.out.println(listObject);
        for (ContactPerson cp : listObject) {
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

    private static void printAddressBookHashMap(Map<String, ArrayList<ContactPerson>> addressBookHashMap) throws IOException {
        for (String name : addressBookHashMap.keySet()) {

        Path fileName= Paths.get(PATH + "/"+name+".txt");
            List<String> list = Files.readAllLines(fileName);

            for (String bookData:list)
            {
                System.out.println(bookData);
            }


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
