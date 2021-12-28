package com.biz.book;

import java.util.*;

public class ContactList {


    public static ArrayList<ContactPerson> editAddressBook() {
        ArrayList<ContactPerson> record = new ArrayList<>();
        //System.out.println("Welcome to Address Book Program");
        ContactPerson contactPerson = new ContactPerson();
        ArrayList contact;
        String name;

        Scanner sc = new Scanner(System.in);
        boolean flag = true, fg = false;
        int status = 1;
        while (flag) {
            System.out.println("------------------------Contact List---------------------");
            System.out.print("1 - Add more contact \n2 - Edit Contact \n3 - Delete person Contact " +
                    "\n4 - Show AddressBook " +
                    "\n0 -  for exit \nEnter your Choice.....");
            status = sc.nextInt();
            switch (status) {
                case 1:
                    int flag1 = 0;
                    ContactPerson newContact = contactPerson.getInput();
                    if (record.isEmpty()) {
                        flag1 = 0;
                    } else {
                        for (ContactPerson cp : record) //for (int i = 0; i < record.size(); i++) {
                        {
                            if (cp.firstName.equals(newContact.firstName)) {
                                System.out.println("Contact person is already present");
                                //record.set(i, newContact);
                                flag1 = 1;
                                break;
                            }
                        }
                    }
                    if (flag1 == 0)
                        record.add(newContact);//adding the new contact in address book
                    break;
                case 2:
                    System.out.println("Enter first name that you want to edit record");
                    name = sc.next();
                    contactPerson.updatedata(name, record);//Update the record using name
                    break;
                case 3:
                    System.out.println("Enter first name that you want to Delete record");
                    name = sc.next();
                    contactPerson.deleteRecord(name, record);//Delete contact using name
                    break;
                case 4:
                    System.out.println("Size of record : " + record.size());
                    contactPerson.addressBook(record);// print all contact from the address book
                    break;

                case 0:
                    flag = false;//exit from loop
                    break;
            }
        }
        return record;
    }


}
