import java.util.ArrayList;
import java.util.HashMap;

public class Library {
    private HashMap<String, Book> books;
    private ArrayList<Member> members;

    public Library(){
        this.books = new HashMap<>();
        this.members = new ArrayList<>();
    }

    // ------------BOOK MANAGEMENT-----------

    public boolean addBook(Book book){
        if (books.containsKey(book.getIsbn())){
            System.out.println("Book already exists.");
            return false;
        }
        books.put(book.getIsbn(), book);
        return true;
    }
}
