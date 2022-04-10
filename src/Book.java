import java.util.UUID;

public class Book {

    private String title;
    private String author;
    private String genre;
    private int pages;
    private boolean available;
    private String uniqueId ;
    private int bookHolders;

    public String getUniqueId() {
        return uniqueId;
    }

    public Book(String title, String author, String genre, int pages, boolean available) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.pages = pages;
        this.available = true;
        this.uniqueId = UUID.randomUUID().toString();
        this.bookHolders = 0;
    }

    public void setBookHolders(int bookHolders) {
        this.bookHolders = bookHolders;
    }

    public void incrementHolders(){
        this.bookHolders++;

    }

    public int getBookHolders() {
        return bookHolders;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

}
