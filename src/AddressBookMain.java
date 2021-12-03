import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookMain {

    String firstName;
    String lastName;
    String address;
    String city;
    int zip;
    long phoneNumber;
    String emailId;

    private static AddressBookMain getInput() {
       AddressBookMain addressBookMain1= new AddressBookMain();
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

    private void showAddressBook() {
        System.out.println("------------------------------------------------");
        System.out.println("First Name : " + firstName);
        System.out.println("Last Name : " + lastName);
        System.out.println("Address : " + address);
        System.out.println("City Name : " + city);
        System.out.println("Zip code : " + zip);
        System.out.println("Phone Number : " + phoneNumber);
        System.out.println("Email id : " + emailId);
        System.out.println("------------------------------------------------");
    }


    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        ArrayList<AddressBookMain> record=new ArrayList<>();
        Scanner sc= new Scanner(System.in);
        AddressBookMain addressBookMain1;
        boolean flag=true;
        int status=1;
        while(flag) {
            System.out.print("1 - Add more contact \n2 - Edit Contact \n3 - Show address \n0 -  for exit ");
            status = sc.nextInt();

            switch(status){
                case 1:

                    record.add( getInput());
                    break;
                case 2:
                    System.out.println("Enter first name that you want to edit record");
                    String name=sc.next();
                    for(int i=0;i<record.size();i++) {
                        System.out.println(record.get(i).firstName);
                        if (name.equals(record.get(i).firstName)) {
                            record.remove(i);
                            //addressBookMain1.getInput();
                            record.add(i, getInput());
                        }
                    }
                    break;
                case 3:
                    System.out.println("Side of record : "+record.size());

                        showAllRecords(record);
                    break;
                case 0:
                    flag=false;
                    break;


            }


        }


    }

    private static void showAllRecords(ArrayList<AddressBookMain> addressBookMain) {
        //System.out.println(firstName);
        for(int j=0;j<addressBookMain.size();j++) {
            System.out.println("------------------------------------------------");
            System.out.println("First Name : " + addressBookMain.get(j).firstName);
            System.out.println("Last Name : " + addressBookMain.get(j).lastName);
            System.out.println("Address : " + addressBookMain.get(j).address);
            System.out.println("City Name : " + addressBookMain.get(j).city);
            System.out.println("Zip code : " + addressBookMain.get(j).zip);
            System.out.println("Phone Number : " + addressBookMain.get(j).phoneNumber);
            System.out.println("Email id : " + addressBookMain.get(j).emailId);
            System.out.println("------------------------------------------------");
        }
    }
}