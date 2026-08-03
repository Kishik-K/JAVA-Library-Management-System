import java.util.HashMap;

public class Library {
    private HashMap<String, Book> books;
    private HashMap<String, Member> members;

    public Library() {
        this.books = new HashMap<>();
        this.members = new HashMap<>();
    }

    // ----- Book management -----

    public boolean addBook(Book book) {
        if (books.containsKey(book.getIsbn())) {
            return false; // already exists
        }
        books.put(book.getIsbn(), book);
        return true;
    }

    public boolean removeBook(String isbn) {
        return books.remove(isbn) != null;
    }

    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }
        for (Book b : books.values()) {
            System.out.println(b);
        }
    }

    public Book searchBook(String isbn) {
        return books.get(isbn);
    }

    // ----- Member management -----

    public boolean addMember(Member member) {
        if (members.containsKey(member.getMemberId())) {
            return false; // already exists
        }
        members.put(member.getMemberId(), member);
        return true;
    }

    public Member findMember(String memberId) {
        return members.get(memberId);
    }

    // ----- Borrowing logic -----

    public boolean borrowBook(String memberId, String isbn) {
        Member member = findMember(memberId);
        Book book = books.get(isbn);

        if (member == null || book == null) {
            return false;
        }
        if (!book.isAvailable()) {
            return false;
        }

        book.setAvailable(false);
        member.borrowBook(book);
        return true;
    }

    public boolean returnBook(String memberId, String isbn) {
        Member member = findMember(memberId);
        Book book = books.get(isbn);

        if (member == null || book == null) {
            return false;
        }

        book.setAvailable(true);
        member.returnBook(book);
        return true;
    }
}