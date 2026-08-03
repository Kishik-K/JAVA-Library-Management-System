import java.util.ArrayList;
import java.util.Scanner;
public class LibraryManagementSystem {
    static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        boolean isBook = true;
        int choice;

        while (isBook) {
            System.out.println("===============----MENU----===============");
            System.out.println("ENTER YOUR CHOICE: ");
            System.out.println(" 1. ~ADD BOOK~ \n 2. ~DELETE BOOK~ \n 3. ~LIST BOOKS~ \n 4. ~SEARCH BOOK~ \n 5. ~EXIT~");
            choice = scanner.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Enter the book to add: ");
                    String addBook = scanner.nextLine();
                    if(!arr.contains(addBook)){
                        arr.add(addBook);
                        System.out.println("Book added to the Library.");
                    } else{
                        System.out.println("Book already exists.");
                    } break;
                case 2:
                    System.out.println("Enter the number of book you want to delete: ");
                    int deleteBook = scanner.nextInt();
                    if (deleteBook>0 && deleteBook <= arr.size()){
                        arr.remove(deleteBook -1);
                        System.out.println("Book was deleted. ");
                    } else {
                        System.out.println("Unable to delete Book...!");
                    } break;
                case 3:
                    System.out.println("LIST OF BOOKS: ");
                    for (String book : arr){
                        System.out.println(book);
                    }break;
                case 4:

            }
        }
    }
}