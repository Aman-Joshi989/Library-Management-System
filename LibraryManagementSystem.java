import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to the Library Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Register User");
            System.out.println("3. Search Book");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");

            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1":
                        System.out.print("Enter Book ID: ");
                        String bookId = scanner.nextLine();
                        System.out.print("Enter Book Title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter Book Author: ");
                        String author = scanner.nextLine();
                        System.out.print("Enter Book ISBN: ");
                        String isbn = scanner.nextLine();
                        library.addBook(new Book(bookId, title, author, isbn));
                        break;
                    case "2":
                        System.out.print("Enter User ID: ");
                        String userId = scanner.nextLine();
                        System.out.print("Enter User Name: ");
                        String name = scanner.nextLine();
                        library.registerUser(new User(userId, name));
                        break;
                    case "3":
                        System.out.print("Enter Book Title to Search: ");
                        String searchTitle = scanner.nextLine();
                        library.searchBook(searchTitle);
                        break;
                    case "4":
                        System.out.print("Enter User ID: ");
                        String borrowUserId = scanner.nextLine();
                        System.out.print("Enter Book ID: ");
                        String borrowBookId = scanner.nextLine();
                        library.borrowBook(borrowUserId, borrowBookId);
                        break;
                    case "5":
                        System.out.print("Enter User ID: ");
                        String returnUserId = scanner.nextLine();
                        System.out.print("Enter Book ID: ");
                        String returnBookId = scanner.nextLine();
                        library.returnBook(returnUserId, returnBookId);
                        break;
                    case "6":
                        System.out.println("Exiting Library Management System. Goodbye!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
