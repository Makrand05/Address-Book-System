package com.biz.book;

import java.util.ArrayList;
import java.util.Scanner;

public class ContactPerson {
    String firstName;
    String lastName;
    String address;
    String city;
    int zip;
    long phoneNumber;
    String emailId;

    public ContactPerson() {

    }

    public void addressBook(ArrayList<ContactPerson> contactPerson) {
        for(int j=0;j<contactPerson.size();j++) {
            System.out.println("------------------------------------------------");
            System.out.println("First Name : " + contactPerson.get(j).firstName);
            System.out.println("Last Name : " + contactPerson.get(j).lastName);
            System.out.println("Address : " + contactPerson.get(j).address);
            System.out.println("City Name : " + contactPerson.get(j).city);
            System.out.println("Zip code : " + contactPerson.get(j).zip);
            System.out.println("Phone Number : " + contactPerson.get(j).phoneNumber);
            System.out.println("Email id : " + contactPerson.get(j).emailId);
            System.out.println("------------------------------------------------");
        }
    }

    public void updatedata(String name, ArrayList<ContactPerson> record) {
        for(int i=0;i<record.size();i++) {
            if (name.equals(record.get(i).firstName)) {
                record.remove(i);
                record.add(i, getInput());
            }
    }
        System.out.println("Record Update Successfully.......");
}

    public ContactPerson getInput() {

        ContactPerson addressBookMain1= new ContactPerson();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the First Name : ");
        addressBookMain1.firstName = sc.next();
        System.out.print("Enter the Last Name : ");
        addressBookMain1.lastName = sc.next();
        System.out.print("Enter the Address : ");
        addressBookMain1.address = sc.next();
        System.out.print("Enter the City Name : ");
        addressBookMain1.city = sc.next();
        System.out.print("Enter the zip code : ");
        addressBookMain1.zip = sc.nextInt();
        System.out.print("Enter the Phone number : ");
        addressBookMain1.phoneNumber = sc.nextLong();
        System.out.print("Enter the Email ID : ");
        addressBookMain1.emailId = sc.next();
        return addressBookMain1;
    }

    public void deleteRecord(String name, ArrayList<ContactPerson> record) {
        if(record.size()>0) {
            for (int i = 0; i < record.size(); i++) {
                if (name.equals(record.get(i).firstName)) {
                    record.remove(i);
                }
                else System.out.println("There is no any person contact for "+name);
            }
        }
        else System.out.println("There is no any person address to delete");
        System.out.println("Record Delete Successfully.......");
    }
}
