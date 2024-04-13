import java.util.*;

class DigitalLibraryManagement {
    HashMap<String, Integer> loginto = new HashMap<>();
    HashMap<Integer, String> map = new HashMap<>();
    public static String userID;
    public static int issues = 0;
    Scanner sc = new Scanner(System.in);

    public HashMap<Integer, String> book_database_server() {
        // Book database initialization
        map.put(1,"ECE : Basic Electronics");
        map.put(2,"ECE : Microprocessor & Microcontroller");
        map.put(3,"ECE : Analog Electronics");
        map.put(4,"ECE : Digital Electronics");
        map.put(5,"CSE : C Programming");
        map.put(6,"CSE : Java Programming");
        map.put(7,"CSE : Artificial Intelligence");
        map.put(8,"CSE : Object Oriented Programming (OOPs)");
        map.put(9,"IT : Data Structures & Algorithms");
        map.put(10,"IT : Databases - Networks");
        map.put(11,"IT : Statistics");
        map.put(12,"BBA : Principle of Management");
        map.put(13,"BBA : Economics for Engineers");
        map.put(14,"MATHS : Engineering Mathematics-1");
        map.put(15,"MATHS : Engineering Mathematics-2");
        map.put(16,"MATHS : Engineering Mathematics-3");
        map.put(17,"PHYS : Physics");
        map.put(18,"CHEM : Chemistry");
        map.put(19,"ENG : English");
        map.put(20,"EE : Control System");
        map.put(21,"EE : Electrical Circuit Theory");
        map.put(22,"EE : Electric & Hybrid Vehicle");
        map.put(23,"EE : Renewable Energy Sources");
        return map;
    }

    public void homepage() {
        System.out.println("WELCOME TO DIGITAL LIBRARY MANAGEMENT SYSTEM");
        System.out.println("1. Admin Login \n2. User Login \n3. Exit");
        System.out.print("Select Option: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                admin_login();
                break;
            case 2:
                user_login();
                break;
            case 3:
                System.out.print("Do You want to Exit? (Y/N): ");
                String exit = sc.next();
                if (exit.equalsIgnoreCase("Y"))
                    System.exit(0);
                else
                    homepage();
                break;
            default:
                System.out.println("Invalid Option Choice.! Please Try again...");
                homepage();
                break;
        }
    }

    public void admin_login() {
        System.out.println("ADMIN LOGIN PAGE");
        System.out.print("Enter User-Id: ");
        userID = sc.next();
        System.out.print("Enter Password: ");
        int password = sc.nextInt();
        loginto.put("komali", 881028);

        if (loginto.containsKey(userID) && loginto.get(userID) == password) {
            System.out.println("LOGIN SUCCESSFULLY...!");
            admin_mainpage();
        } else {
            System.out.println("Invalid login credentials.!!! Please try again...");
            admin_login();
        }
    }

    public void user_login() {
        System.out.println("USER LOGIN PAGE");
        System.out.print("Enter User-Id: ");
        userID = sc.next();
        System.out.print("Enter Password: ");
        int password = sc.nextInt();
        loginto.put("komali", 881028);
        loginto.put("ajay", 102888);

        if (loginto.containsKey(userID) && loginto.get(userID) == password) {
            System.out.println("LOGIN SUCCESSFULLY...!");
            user_mainpage();
        } else {
            System.out.println("Invalid login credentials.!!! Please try again...");
            user_login();
        }
    }

    public void admin_mainpage() {
        System.out.println("Digital Library ---> Welcome Admin " + userID + "!");
        System.out.println("1. Add a New Book \n2. Update a Existing Book \n3. Delete a Existing Book \n4. Go To User MainPage \n5. Logout");
        System.out.print("Select Option: ");
        int choice;
        try {
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    map = add_new();
                    admin_mainpage();
                    break;
                case 2:
                    map = upd_old();
                    admin_mainpage();
                    break;
                case 3:
                    map = del_old();
                    admin_mainpage();
                    break;
                case 4:
                    user_mainpage();
                    break;
                case 5:
                    System.out.println("LOGOUT SUCCESSFULLY...!");
                    homepage();
                    break;
                default:
                    System.out.println("Invalid Option Choice.! Please Try again...");
                    admin_mainpage();
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter an integer value.");
            sc.nextLine(); // Clear the invalid input from the Scanner
            admin_mainpage(); // Restart the method to allow the user to enter a valid input
        }
    }

    public void user_mainpage() {
        System.out.println("Digital Library ---> Welcome User " + userID + "!");
        System.out.println("1. View any Book \n2. Issue a Book \n3. Return a Book \n4. Logout");
        System.out.print("Select Option: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                views();
                break;
            case 2:
                borrows();
                break;
            case 3:
                returns();
                break;
            case 4:
                System.out.println("LOGOUT SUCCESSFULLY...!");
                homepage();
                break;
            default:
                System.out.println("Invalid Option Choice.! Please Try again...");
                user_mainpage();
                break;
        }
    }

    public HashMap<Integer, String> add_new() {
        System.out.println("ADD A NEW BOOK");
        System.out.print("Enter a New Book Number: ");
        int addbook = sc.nextInt();
        if (book_database_server().containsKey(addbook)) {
            System.out.println("This Book Number is already exist... Please try with another number...");
        } else if (addbook == 0 || addbook < 0) {
            System.out.println("You can't assign Zero(0) or a Negative(-ve) number for a book...");
        } else {
            System.out.print("Enter New Book Details: ");
            String addbookdetails = sc.next();
            map.put(addbook, addbookdetails);
            System.out.println("New Book added Successfully...");
            System.out.println("New Book No.:: " + addbook);
            System.out.println("New Book Name & Details:: " + map.get(addbook));
        }
        return map;
    }

    public HashMap<Integer, String> upd_old() {
        System.out.println("UPDATE A BOOK DETAILS");
        System.out.print("Enter a Book No. to Update its Details: ");
        int updbook = sc.nextInt();
        if (book_database_server().containsKey(updbook)) {
            System.out.println("Backdated Book Name & Details:: " + map.get(updbook));
            System.out.print("Enter the Updated Book Details: ");
            String upbookdetails = sc.next();
            book_database_server().replace(updbook, upbookdetails);
            System.out.println("Book Details Updated Successfully...!");
            System.out.println("Book No.:: " + updbook);
            System.out.println("Updated Book Name & Details:: " + map.get(updbook));
        } else {
            System.out.println("This Book Number is not Available...!");
        }
        return map;
    }

    public HashMap<Integer, String> del_old() {
        System.out.println("DELETE A BOOK DETAILS");
        System.out.print("Enter the Book Number, which you want to delete: ");
        int delbook = sc.nextInt();
        if (book_database_server().containsKey(delbook)) {
            System.out.println("Book Details You Want to Delete...");
            System.out.println("Book No.:: " + delbook);
            System.out.println("Book Name:: " + map.get(delbook));
            System.out.print("Do You want to Delete this Book? (Y/N): ");
            String delbookdetails = sc.next();
            if (delbookdetails.equalsIgnoreCase("Y")) {
                String returned_value = (String) map.remove(delbook);
                System.out.println(returned_value + " Book Details Deleted Successfully...");
            } else {
                System.out.println("Book Deletion Cancelled...!");
            }
        } else {
            System.out.println("This Book Number Already not Exists.!!!");
        }
        return map;
    }

    public void views() {
        System.out.println("VIEW BOOKS");
        System.out.println("1. View a Specific Book \n2. View all Books \n3. Back to MainPage");
        System.out.print("Select Option: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.print("Enter Book Number: ");
                int books = sc.nextInt();
                if (book_database_server().containsKey(books)) {
                    System.out.println("\n" + books + " ---> " + map.get(books));
                } else {
                    System.out.println("Oops.! This book no. is not available... Please Try Another...");
                }
                views();
                break;
            case 2:
                System.out.println("\nAll Available Books...");
                for (Map.Entry<Integer, String> entry : book_database_server().entrySet()) {
                    int key = entry.getKey();
                    String value = entry.getValue();
                    System.out.println(key + " ---> " + value);
                }
                views();
                break;
            case 3:
                System.out.println("REDIRECTING TO USER MAINPAGE...");
                user_mainpage();
                break;
            default:
                System.out.println("Invalid Option Choice.! Please Try again...");
                views();
                break;
        }
    }

    public void borrows() {
        System.out.println("ISSUE A BOOK");
        System.out.print("Enter a Book Number which You want to Issue: ");
        int isbook = sc.nextInt();
        if (issues == 0 && isbook > 0 && book_database_server().containsKey(isbook)) {
            issues = isbook;
            System.out.println("Successfully Issued the Book...");
            System.out.println("Issued Book No.:: " + isbook);
            System.out.println("Issued Book Name & Details:: " + map.get(isbook));
        } else if (issues != 0) {
            System.out.println("You have Already Issued a Book.! Please Return that book to Issue a new book...");
        } else {
            System.out.println("Invalid Book Number or Book is not Available...");
        }
        user_mainpage();
    }

    public void returns() {
        System.out.println("RETURN A BOOK");
        if (book_database_server().containsKey(issues)) {
            System.out.println("Issued Book Details...");
            System.out.println("Book No.:: " + issues);
            System.out.println("Book Name:: " + map.get(issues));
            System.out.print("Do You want to Return this Book? (Y/N): ");
            String rebook = sc.next();
            if (rebook.equalsIgnoreCase("Y")) {
                issues = 0;
                System.out.println("Book Returned Successfully...");
            } else {
                System.out.println("Book Return Cancelled...!");
            }
        } else {
            System.out.println("You don't have any issued book.!!!");
        }
        user_mainpage();
    }

    public static void main(String args[]) {
        DigitalLibraryManagement system_run = new DigitalLibraryManagement();
        system_run.homepage();
    }
}