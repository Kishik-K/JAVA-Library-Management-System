import java.util.Scanner;

public class LibraryManagementSystem {

    // ANSI color codes
    static final String RESET = "\u001B[0m";
    static final String CYAN = "\u001B[36m";
    static final String GREEN = "\u001B[32m";
    static final String RED = "\u001B[31m";
    static final String YELLOW = "\u001B[33m";
    static final String BOLD = "\u001B[1m";

    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        int choice;

        while (running) {
            printMenu();
            System.out.print(YELLOW + "Enter your choice: " + RESET);

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: {
                    printHeader("ADD BOOK");
                    System.out.print("Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Author: ");
                    String author = scanner.nextLine();
                    System.out.print("ISBN: ");
                    String isbn = scanner.nextLine();

                    Book book = new Book(title, author, isbn);
                    if (library.addBook(book)) {
                        success("Book added to the library.");
                    } else {
                        error("Book with this ISBN already exists.");
                    }
                    break;
                }

                case 2: {
                    printHeader("REMOVE BOOK");
                    System.out.print("ISBN: ");
                    String isbn = scanner.nextLine();
                    if (library.removeBook(isbn)) {
                        success("Book removed.");
                    } else {
                        error("Book not found.");
                    }
                    break;
                }

                case 3: {
                    printHeader("LIBRARY CATALOG");
                    library.listBooks();
                    break;
                }

                case 4: {
                    printHeader("SEARCH BOOK");
                    System.out.print("ISBN: ");
                    String isbn = scanner.nextLine();
                    Book found = library.searchBook(isbn);
                    if (found != null) {
                        success("Found: " + found);
                    } else {
                        error("Book not found.");
                    }
                    break;
                }

                case 5: {
                    printHeader("ADD MEMBER");
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Member ID: ");
                    String memberId = scanner.nextLine();

                    Member member = new Member(name, memberId);
                    if (library.addMember(member)) {
                        success("Member added.");
                    } else {
                        error("Member with this ID already exists.");
                    }
                    break;
                }

                case 6: {
                    printHeader("BORROW BOOK");
                    System.out.print("Member ID: ");
                    String memberId = scanner.nextLine();
                    System.out.print("ISBN: ");
                    String isbn = scanner.nextLine();

                    if (library.borrowBook(memberId, isbn)) {
                        success("Book borrowed successfully.");
                    } else {
                        error("Unable to borrow book (check member ID, ISBN, or availability).");
                    }
                    break;
                }

                case 7: {
                    printHeader("RETURN BOOK");
                    System.out.print("Member ID: ");
                    String memberId = scanner.nextLine();
                    System.out.print("ISBN: ");
                    String isbn = scanner.nextLine();

                    if (library.returnBook(memberId, isbn)) {
                        success("Book returned successfully.");
                    } else {
                        error("Unable to return book (check member ID or ISBN).");
                    }
                    break;
                }

                case 8:
                    running = false;
                    System.out.println(CYAN + "\nGoodbye!\n" + RESET);
                    break;

                default:
                    error("Invalid choice, try again.");
                    break;
            }
        }
        scanner.close();
    }

    static void printMenu() {
        System.out.println(CYAN + BOLD + "\n╔══════════════════════════════════════╗");
        System.out.println("║       LIBRARY MANAGEMENT SYSTEM       ║");
        System.out.println("╠══════════════════════════════════════╣" + RESET);
        System.out.println(" 1. Add Book        5. Add Member");
        System.out.println(" 2. Remove Book      6. Borrow Book");
        System.out.println(" 3. List Books       7. Return Book");
        System.out.println(" 4. Search Book      8. Exit");
        System.out.println(CYAN + BOLD + "╚══════════════════════════════════════╝" + RESET);
    }

    static void printHeader(String title) {
        System.out.println(YELLOW + "\n--- " + title + " ---" + RESET);
    }

    static void success(String msg) {
        System.out.println(GREEN + "✔ " + msg + RESET);
    }

    static void error(String msg) {
        System.out.println(RED + "✘ " + msg + RESET);
    }
}