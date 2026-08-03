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
    public boolean removeBook(String isbn){
        return books.remove(isbn) != null;
    }
    public void listBooks(){
        if(books.isEmpty()){
            System.out.println("No books in the library");
            return;
        }
        for (Book b: books.values()){
            System.out.println(b);
        }
    }
    public Book searchBook(String isbn){
        return books.get(isbn);
    }

    // ------------MEMBER MANAGEMENT-----------

    public boolean addMember(Member member){
        for (Member m : members ){
            if(m.getMemberId().equals(member.getMemberId())){
                return false;
            }
        }
        members.add(member);
        return true;
    }

    public Member findMember(String memberId){
        for (Member m : members){
            if(m.getMemberId().equals(memberId)){
                return m;
            }
        }
        return null;
    }


}
