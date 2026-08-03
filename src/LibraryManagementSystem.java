import java.util.Scanner;

public class LibraryManagementSystem{
    //ANSI COLOR CODES:::::
    static final String RESET = "\u001B[0m";
    static final String CYAN = "\u001B[36m";
    static final String GREEN = "\u001B[32m";
    static final String RED = "\u001B[31m";
    static final String YELLOW = "\u001B[33m";
    static final String BOLD = "\u001B[1m";

    static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        int choice;

        while (running){
            printMenu();
            System.out.println(YELLOW + "ENTER YOUR CHOICE: " + RESET);

            choice = scanner.nextInt();
            scanner.nextLine();


        }
    }
}