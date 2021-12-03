package com.biz.book;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookMain {


    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        ContactPerson contactPerson = new ContactPerson();

        ArrayList<ContactPerson> record = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        int status = 1;
        while (flag) {
            System.out.print("1 - Add more contact \n2 - Edit Contact \n3 - Show address \n0 -  for exit ");
            status = sc.nextInt();

            switch (status) {
                case 1:

                    record.add(contactPerson.getInput());
                    break;
                case 2:
                    System.out.println("Enter first name that you want to edit record");
                    String name = sc.next();
                    contactPerson.updatedata(name, record);
                    break;
                case 3:
                    System.out.println("Side of record : " + record.size());
                    contactPerson.addressBook(record);
                    break;
                case 0:
                    flag = false;
                    break;
            }
        }
    }
}
