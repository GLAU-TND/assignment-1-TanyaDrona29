package Assignment1.Execution;

import Assignment1.PersonDetails.Person;
import Assignment1.defination.DefinationList;

import java.util.Scanner;

public class MyMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstName;
        String lastName;
        String[] contactNumber = new String[2];
        DefinationList definationList = new DefinationList();
        System.out.println("welcome to Tanya's Contact list");
        System.out.println("Press 1 to add new contact\n" +
                "Press 2 to view all contact details\n" +
                "Press 3 to search a contact in contact list\n" +
                "Press 4 to delete the contacts\n" +
                "Press 5 to exit from the menu option ");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                System.out.println("You have chosen to add the contact details" +
                        "\nPlease enter the Name");
                System.out.println("First Name:");
                firstName = scanner.next();
                System.out.println("Last Name:");
                lastName = scanner.next();
                System.out.println("Please enter the contact number");
                contactNumber[0] = scanner.next();
                System.out.println("Would you like to add another contact number? (y/n)");
                char choice = scanner.next().charAt(0);
                if (choice == 'y') {
                    System.out.println("please enter another contact no");
                    contactNumber[1] = scanner.next();
                } else {
                    contactNumber[1] = null;
                }
                System.out.println("Enter the email");
                String email = scanner.next();
                Person person = new Person(firstName,lastName,email,contactNumber);
                definationList.add(person);
                System.out.println("Contact added \n" +
                        "First Name:" + firstName + "\nLast Name:" + lastName + "\n email:" + email +
                        "\nContact number");
                for (int i = 0; i < 2; i++) {
                    System.out.print(contactNumber[i]);

                }
                break;
            case 2:
                definationList.viewAllDetails();
                break;
            case 3:
                scanner.nextLine();
                System.out.println("you could search by the First Names");
                String str = scanner.nextLine();
                definationList.search(str);
            case 4:
                System.out.println("Enter the contact you want to be deleted ");
                int num = scanner.nextInt();
                definationList.delete(num - 1);
                break;
            case 5:
                System.out.println("Exit done, Thank you for visting");
                break;
            default:
                System.out.println("Invalid input given, I am sorry");
        }
    }
}
