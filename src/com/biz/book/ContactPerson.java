package com.biz.book;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

public class ContactPerson {
    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    Integer zip;
    Long phoneNumber;
    String emailId;

    public ContactPerson() {

    }

    public ContactPerson(String firstName, String lastName, String address, String city, String state, int zip, long phoneNumber, String emailId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
    }

    public void addressBook(ArrayList<ContactPerson> contactPerson) {

        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.printf("%10s %10s %20s %10s %10s %10s %10s %10s", "First Name", "Last Name", "Address", "City ","state,", "Pin Code", "Phone Number", "Email");
        System.out.println();
        System.out.println("------------------------------------------------------------------------------------------------");
        for (int j = 0; j < contactPerson.size(); j++) {
            System.out.format("%10s %10s %20s %10s %10s %10s %10s"
                    , contactPerson.get(j).firstName
                    , contactPerson.get(j).lastName
                    , contactPerson.get(j).address
                    , contactPerson.get(j).city
                    , contactPerson.get(j).state
                    , contactPerson.get(j).zip
                    , contactPerson.get(j).phoneNumber
                    , contactPerson.get(j).emailId);

            System.out.println();
        }
    }

    public void updatedata(String name, ArrayList<ContactPerson> record) {
        for (int i = 0; i < record.size(); i++) {
            if (name.equals(record.get(i).firstName)) {
                record.remove(i);
                record.add(i, getInput());
            }
        }
        System.out.println("Record Update Successfully.......");
    }

    public ContactPerson getInput() {
        ContactPerson addressBookMain1 = new ContactPerson();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the First Name : ");
        addressBookMain1.firstName = sc.next();
        System.out.print("Enter the Last Name : ");
        addressBookMain1.lastName = sc.next();
        System.out.print("Enter the Address : ");
        addressBookMain1.address = sc.next();
        System.out.print("Enter the City Name : ");
        addressBookMain1.city = sc.next();
        System.out.print("Enter the State Name : ");
        addressBookMain1.state = sc.next();
        System.out.print("Enter the zip code : ");
        addressBookMain1.zip = sc.nextInt();
        System.out.print("Enter the Phone number : ");
        addressBookMain1.phoneNumber = sc.nextLong();
        System.out.print("Enter the Email ID : ");
        addressBookMain1.emailId = sc.next();
        return addressBookMain1;
    }

    public void deleteRecord(String name, ArrayList<ContactPerson> record) {
        if (record.size() > 0) {
            for (int i = 0; i < record.size(); i++) {
                if (name.equals(record.get(i).firstName)) {
                    record.remove(i);
                    System.out.println("Record Delete Successfully.......");
                } else System.out.println("There is no any person contact for " + name);
            }
        } else System.out.println("There is no any person address to delete");
    }

    public void getAddressbook(Map<String, ContactPerson> addressBookHashMap) {
        for (String addressbook : addressBookHashMap.keySet()) {
            System.out.println("Person contact for the " + addressbook.toString() + " is " + addressBookHashMap.get(addressbook).toString());
        }
    }

    @Override
    public String toString() {
        return "ContactPerson{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +
                ", phoneNumber=" + phoneNumber +
                ", emailId='" + emailId + '\'' +
                '}';
    }
}
