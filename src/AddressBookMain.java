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

    private void getInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the First Name : ");
        this.firstName = sc.next();
        System.out.print("Enter the Last Name : ");
        this.lastName = sc.next();
        System.out.print("Enter the Address : ");
        this.address = sc.next();
        System.out.print("Enter the City Name : ");
        this.city = sc.next();
        System.out.print("Enter the zip code : ");
        this.zip = sc.nextInt();
        System.out.print("Enter the Phone number : ");
        this.phoneNumber = sc.nextLong();
        System.out.print("Enter the Email ID : ");
        this.emailId = sc.next();
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
        AddressBookMain addressBookMain1 = new AddressBookMain();
        int status=1;
        while(status==1) {
            addressBookMain1.getInput();
            record.add(addressBookMain1);

            System.out.print("you want to add more address press 1 or 0 for exit ): ");
            status = sc.nextInt();
            if (status == 0) break;
        }

        for(int i=0;i<record.size();i++){
            showAllRecords(record.get(i));
        }
    }

    private static void showAllRecords(AddressBookMain addressBookMain) {
        addressBookMain.showAddressBook();
    }
}