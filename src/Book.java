public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;

    public Book(String title, String author, String isbn){
        this.author = author;
        this.title = title;
        this.isbn = isbn;
        this.isAvailable = true;
    }

}
