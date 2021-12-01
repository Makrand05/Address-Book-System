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
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the First Name : ");
        this.firstName=sc.next();
        System.out.print("Enter the Last Name : ");
        this.lastName=sc.next();
        System.out.print("Enter the Address : ");
        this.address=sc.next();
        System.out.print("Enter the City Name : ");
        this.city=sc.next();
        System.out.print("Enter the zip code : ");
        this.zip=sc.nextInt();
        System.out.print("Enter the Phone number : ");
        this.phoneNumber=sc.nextLong();
        System.out.print("Enter the Email ID : ");
        this.emailId=sc.next();
    }
    private void showAddressBook() {
        System.out.println("First Name : "+firstName);
        System.out.println("Last Name : "+lastName);
        System.out.println("Address : "+address);
        System.out.println("City Name : "+city);
        System.out.println("Zip code : "+zip);
        System.out.println("Phone Number : "+phoneNumber);
        System.out.println("Email id : "+emailId);
    }



    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
       AddressBookMain addressBookMain=new AddressBookMain();
       addressBookMain.getInput();
       addressBookMain.showAddressBook();
    }




}
