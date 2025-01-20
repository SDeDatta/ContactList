import java.util.ArrayList;
import java.util.Scanner;
public class ContactList
{
    private ArrayList<Person> contacts;

    public ContactList()
    {
        // Makes the list of contacts
        contacts = new ArrayList<Person>();
    }

    public ArrayList<Person> getContacts()
    {
        return contacts;
    }
    // Adds a contact to the list
    public void addContact()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Select a type of contact to add:\n 1. Student\n 2. Tennis Player");
        int type = input.nextInt();
        input.nextLine();
        // Gets the info of the person to be added
        System.out.println("Please fill in the following information");
        System.out.println("First Name: ");
        String firstName = input.nextLine();
        System.out.println("Last Name: ");
        String lastName = input.nextLine();
        System.out.println("Phone Number: ");
        String phoneNumber = input.nextLine();
        // Asks for different information based on whether the user wants to add a Student or Tennis Player
        if(type == 1)
        {
            System.out.println("Grade: ");
            int grade = input.nextInt();
            contacts.add(new Student(firstName, lastName, phoneNumber, grade));
        }
        else if(type == 2)
        {
            System.out.println("Ranking: ");
            int ranking = input.nextInt();
            input.nextLine();
            System.out.println("Racket: ");
            String racket = input.nextLine();
            System.out.println("Strings: ");
            String strings = input.nextLine();
            contacts.add(new TennisPlayer(firstName, lastName, phoneNumber, racket, strings, ranking));
        }
    }


    // Prints all contacts in the list
    public void printContacts() {
        for (Person contact : contacts)
        {
            System.out.println(contact);
        }
    }
    // Sorts the contact list by first name, last name, or phone number using bubble sort
    public void sortArray(int sortBy) {
        int len = contacts.size();
        for (int i = 0; i < len - 1; i++)
        {
            for (int j = 0; j < len - i - 1; j++)
            {
                // Sorts the contact list alphabetically by first name
                if (sortBy == 0)
                {
                    // Compares lexicographic difference between the 2 strings with compareTo()
                    if (contacts.get(j).getFirstName().compareTo(contacts.get(j+1).getFirstName()) > 0)
                    {
                        swap(j,j+1);
                    }
                }
                // Sorts the contact list alphabetically by last name
                else if (sortBy == 1)
                {
                    // Compares lexicographic difference between the 2 strings
                    if (contacts.get(j).getLastName().compareTo(contacts.get(j+1).getLastName()) > 0)
                    {
                        swap(j, j+1);
                    }
                }
                // Sorts the contact list by phone number
                else if (sortBy == 2)
                {
                    // Compares lexicographic difference between the 2 strings
                    if (contacts.get(j).getPhoneNumber().compareTo(contacts.get(j+1).getPhoneNumber()) > 0)
                    {
                        swap(j,j+1);
                    }
                }
            }
        }
    }
    // Aids the sort function by swapping 2 people in the contact list
    public void swap(int i, int j)
    {
        Person temp = contacts.get(i);
        contacts.set(i, contacts.get(j));
        contacts.set(j, temp);
    }
    // Searches for a certain person based on first name
    public void searchByFirstName()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a name: ");
        String firstName = input.nextLine();
        for(Person person : contacts)
        {
            if(person.getFirstName().equals(firstName))
            {
                // Prints out the match
                System.out.println(person);
                // Ends the function if a match is found and once a person is printed
                return;
            }
        }
        System.out.println(firstName + " is not in the list.");
    }
    // Searches for a certain person based on last name
    public void searchByLastName()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a name: ");
        String lastName = input.nextLine();
        for(Person person : contacts)
        {
            if(person.getLastName().equals(lastName))
            {
                // Prints out the match
                System.out.println(person);
                // Ends the function if a match is found and once a person is printed
                return;
            }
        }
        System.out.println(lastName + " is not in the list.");
    }
    // Searches for a certain person based on phone number
    public void searchByPhoneNumber()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a phone number: ");
        String phoneNumber = input.nextLine();
        for(Person person : contacts)
        {
            if(person.getPhoneNumber().equals(phoneNumber))
            {
                // Prints out the match
                System.out.println(person);
                // Ends the function if a match is found and once a person is printed
                return;
            }
        }
        System.out.println(phoneNumber + " is not a phone number of one of your contacts.");
    }
    // Lists the students in the contact list
    public void listStudents()
    {
        for(Person person : contacts)
        {
            // Ensures the person being looked at is a student
            if(person instanceof Student)
            {
                System.out.println(person);
            }
        }
    }
    // Prints the menu and instructions of the program
    public static void printInstructions()
    {
        System.out.println("Welcome to your Contacts List\nPlease pick from the following menu options\n\nMenu: ");
        System.out.println("1. Add Contact");
        System.out.println("2. List All Contacts by First Name");
        System.out.println("3. List All Contacts by Last Name");
        System.out.println("4. List All Contacts by Phone Number");
        System.out.println("5. List All Students");
        System.out.println("6. Search by First Name");
        System.out.println("7. Search by Last Name");
        System.out.println("8. Search by Phone Number");
        System.out.println("0. Exit");
    }
    // Runs the program
    public void run()
    {
        printInstructions();
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        input.nextLine();
        // Runs specific features of the contact list based on the number inputted in response to the menu
        // Runs as long as the user wants
        while(choice != 0)
        {
            if(choice == 1)
            {
                addContact();
            }
            // Sorts the array by first name before printing the list
            else if(choice == 2)
            {
                sortArray(0);
                printContacts();
            }
            // Sorts the array by last name before printing the list
            else if(choice == 3)
            {
                sortArray(1);
                printContacts();
            }
            // Sorts the array by phone number before printing the list
            else if(choice == 4)
            {
                sortArray(2);
                printContacts();
            }
            else if(choice == 5)
            {
                listStudents();
            }
            else if(choice == 6)
            {
                searchByFirstName();
            }
            else if(choice == 7)
            {
                searchByLastName();
            }
            else if(choice == 8)
            {
                searchByPhoneNumber();
            }
            System.out.println();
            printInstructions();
            choice = input.nextInt();
        }

    }
}


